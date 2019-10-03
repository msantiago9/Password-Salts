package main;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class HashController {

	private static String getHex(byte[] bytes) {
		String hex = "";

		for (int i = 0; i < bytes.length; i++) {
			hex += String.format("%02x", bytes[i]);
		}
		return hex;
	}

	public static String getHash(String input) {

		byte[] MD5InBytes = new byte[16];
		try {
			MD5InBytes = input.getBytes("UTF-8");
			MessageDigest MD5Converter = MessageDigest.getInstance("MD5");
			MD5InBytes = MD5Converter.digest(MD5InBytes);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String MD5InHex = getHex(MD5InBytes);

		return MD5InHex;
	}
	
	public static void compareHashes(String databaseHash, String generatedHash) {
		System.out.println("\nHash in the database: " + databaseHash);
		System.out.println("Generated Hash: " + generatedHash);
		System.out
				.println("Match: "
						+ (databaseHash.equals(generatedHash)
								? "true\n - The input password and salt matches the has value in the database."
								: "false\n - The input password and salt do not match the has value in the database.")
						+ "\n");
	}
	
	public static boolean hashesAreEqual(String databaseHash, String generatedHash) {
		return databaseHash.equals(generatedHash) ? true : false;
	}
}
