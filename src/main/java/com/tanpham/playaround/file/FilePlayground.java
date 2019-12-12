package com.tanpham.playaround.file;

import java.io.File;

public class FilePlayground {

	public String getUidCertificate(Long companyLuzCompId) throws Exception {
		String companyUid = "abc";
		String pathToCertificate = System.getProperty("path.of.certificate");
		validatePathToCertificate(companyLuzCompId, companyUid, pathToCertificate);
		
		File initialFile = new File(pathToCertificate, companyUid + ".pem");
		validateFile(initialFile);
//			byte[] bytes = IOUtils.toByteArray(new FileInputStream(initialFile));
//			return new String(bytes, StandardCharsets.UTF_8);
//			LOGGER.log(Level.SEVERE, "Cannot read file", e);
		return null;
	}
	
	public void validatePathToCertificate(Long companyLuzCompId, String companyUid, String pathToCertificate) throws Exception {
		if (pathToCertificate == null) {
			throw new Exception(
			        "Please setup the path to UID-CRT directory!!! Without this configuration, we cannot get the correct uid-crt file of company id: "
			                + companyLuzCompId + ", company uid: " + companyUid);
		} else if (!"/".equals(getLastCharacter(pathToCertificate))) {
			throw new Exception("Configuration without slash(/) at the end could lead to the situation that we cannot get the corresponding files");
		}
	}
	
	public static String getLastCharacter(String inputPath) {
		if (inputPath == null || inputPath.length() == 0) {
			return null;
		}
		return inputPath.substring(inputPath.length() - 1, inputPath.length());
	}
	
	public void validateFile(File initialFile) throws Exception {
		if (!initialFile.exists()) {
			throw new Exception("File " + initialFile.getAbsolutePath() + " does not exist");
		}
		if (!initialFile.canRead()) {
			throw new Exception(
			        "File " + initialFile.getAbsolutePath() + " cannot be read. Please check the permission of this file.");
		}
	}
	
}
