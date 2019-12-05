package com.tanpham.playaround.cryptography;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Cryptography {

	public String certdir;
	public Connection conn;
	private static SecretKeySpec secretKey;
	
	public Cryptography() {
		Properties properties = new Properties();
		// Load our configurations
		try {
			properties.loadFromXML(this.getClass().getClassLoader().getResourceAsStream("configuration.xml"));
			
			// connection to store the .pem file extension
			conn = DriverManager.getConnection(properties.getProperty("url"), "admin", "admin");

			// Create secret key
			byte[] key = properties.getProperty("secret_key").getBytes("UTF-8");
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
			
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String encrypt(String strToEncrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//			return Base64.getEncoder().encodeToString(strToEncrypt.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException ex) {
			System.err.println("No such algorithm: " + ex.getMessage());
		} catch (NoSuchPaddingException ex) {
			System.err.println("No such padding: " + ex.getMessage());
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return null;
	}

	public String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
//			return new String(Base64.getDecoder().decode(strToDecrypt));
		} catch (NoSuchAlgorithmException ex) {
			System.err.println("No such algorithm: " + ex.getMessage());
		} catch (NoSuchPaddingException ex) {
			System.err.println("No such padding: " + ex.getMessage());
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return null;
	}
	
	public void insertDB(Long id, String encryptedContent) {
	    
        try {
        	String cert = encryptedContent;
        	// Use the Postgresql 9.5+ UPSERT
        	String statement = 
        	"insert into certstore (id, cert) values (?,?)";
        	
			PreparedStatement st = conn.prepareStatement(statement);
			st.setLong(1, id);
			st.setString(2, cert);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
		}
    }
    
    public String loadCert(String certname) {
    	String contents=null;
        try {
            String concat = certname.concat(".pem");
			URI uri = this.getClass().getClassLoader().getResource(concat).toURI();
			Path path = Paths.get(uri);
			contents = encrypt(new String(Files.readAllBytes(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contents;
    }
    
    public String loadCertWithoutEncrypting(String certname) {
        try {
            String concat = certname.concat(".pem");
            System.out.println(concat);
			URI uri = this.getClass().getClassLoader().getResource(concat).toURI();
			System.out.println(uri);
			Path path = Paths.get(uri);
			return new String(Files.readAllBytes(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	public String readDB(Long id) {
		PreparedStatement st = null;
		String result = "";
		try {
			st = conn
			        .prepareStatement("SELECT cert from certstore where id=?");
			st.setLong(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				result = rs.getString("cert");
			}
			st.close();
			return result;
		} catch (SQLException e) {
			System.err.println("SQL Error: " + e.getMessage());
		}
		return "";
	}

	public static void main(String[] args) throws InvalidPropertiesFormatException, IOException, NoSuchAlgorithmException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found: " + e.getMessage() + "\n Add postgresql-xx.jar to classpath");
		}

		Cryptography cryptography = new Cryptography();
		String certFileName = "sample";
		System.out.println("Without encrypted content: " + cryptography.loadCertWithoutEncrypting(certFileName));
		
		String encryptedContent = cryptography.loadCert(certFileName);
		System.out.println("WITH encrypted content: " + encryptedContent);
		long idInDatabase = new Random().nextLong();
		cryptography.insertDB(idInDatabase, encryptedContent);
		System.out.println("" + cryptography.decrypt(cryptography.readDB(idInDatabase)));
	}
}
