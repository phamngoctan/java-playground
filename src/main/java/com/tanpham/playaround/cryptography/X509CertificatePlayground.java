package com.tanpham.playaround.cryptography;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class X509CertificatePlayground {

	public static void main(String[] args) throws CertificateException {
		String binarySecurityToken = "cannotExposedToken";
		
		byte[] decodedBytes = Base64.getDecoder().decode(binarySecurityToken);
		
		CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
		InputStream in = new ByteArrayInputStream(decodedBytes);
		X509Certificate cert = (X509Certificate)certFactory.generateCertificate(in);
		System.out.println("Version: " + cert.getVersion());
		System.out.println("Subject: " + cert.getSubjectDN());
		System.out.println("Issuer: " + cert.getIssuerDN());
		System.out.println("public key encoded         : " + Base64.getEncoder().encodeToString(cert.getPublicKey().getEncoded()));
		
		String expectedPublicKeyInPemFormat = "anyKeyInPemformat\\r\\n";
		expectedPublicKeyInPemFormat = expectedPublicKeyInPemFormat.replaceAll("\\r\\n", "");
		System.out.println("Expected public key encoded: " + expectedPublicKeyInPemFormat);
		System.out.println("Is matched with expected base64 public key: " + (Base64.getEncoder().encodeToString(cert.getPublicKey().getEncoded()).equals(expectedPublicKeyInPemFormat)));
		
		System.out.println("================================= Second binary security token ==============================");
		String secondBinarySecurityToken = "cannotExposedToken2";
		InputStream secondIn = new ByteArrayInputStream(Base64.getDecoder().decode(secondBinarySecurityToken));
		X509Certificate secondCert = (X509Certificate)certFactory.generateCertificate(secondIn);
		System.out.println("Version: " + secondCert.getVersion());
		System.out.println("Subject: " + secondCert.getSubjectDN());
		System.out.println("Issuer: " + secondCert.getIssuerDN());
		System.out.println("public key encoded         : " + Base64.getEncoder().encodeToString(secondCert.getPublicKey().getEncoded()));
		
		String secondExpectedPublicKeyInPemFormat = "anyKeyInPemformat\r\n";
		secondExpectedPublicKeyInPemFormat = secondExpectedPublicKeyInPemFormat.replaceAll("\\r\\n", "");
		System.out.println("Expected public key encoded: " + secondExpectedPublicKeyInPemFormat);
		System.out.println("Is matched with second expected base64 public key: " + (Base64.getEncoder().encodeToString(secondCert.getPublicKey().getEncoded()).equals(secondExpectedPublicKeyInPemFormat)));
	}
	
}
