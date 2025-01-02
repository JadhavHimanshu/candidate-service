package org.dnyanyog.encryption;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class EncryptionUtil {
	private static final String Secret_Key = "nNdOpe1rP4OhtnKiFf7smtujfMUgo5LYHAkwmooo790=";
	private static final String Algorithm = "AES";
	private static SecretKey secretKey; 
	private static Cipher cipher; 
	static {
	    // Base64 decode the secret key string and check length
	    byte[] decodedKey = Base64.getDecoder().decode(Secret_Key);
	    
	    // Ensure key is 32 bytes (256 bits)
	    if (decodedKey.length != 32) {
	        throw new IllegalArgumentException("Invalid AES key length. Expected 32 bytes.");
	    }

	    // Create the AES key
	    secretKey = new SecretKeySpec(decodedKey, Algorithm);
	    try {
	        cipher = Cipher.getInstance(Algorithm);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	    } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
	        e.printStackTrace();
	    }
	}

	
//	static {
//		secretKey = new SecretKeySpec(Secret_Key.getBytes(StandardCharsets.UTF_8), Algorithm);
//		try {
//			cipher = Cipher.getInstance(Algorithm);
//			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//		} catch (InvalidKeyException e) {
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
//			e.printStackTrace();
//		}

	public static int encrypt(Integer integer) throws Exception {
	    // Convert integer to a byte array
	    byte[] inputBytes = integer.toString().getBytes(StandardCharsets.UTF_8);
	    
	    // Encrypt the byte array
	    byte[] encryptedData = cipher.doFinal(inputBytes);
	    
	    // Convert encrypted byte array to BigInteger, then return as int
	    BigInteger bigInt = new BigInteger(1, encryptedData); // Convert to positive BigInteger
	    return bigInt.intValue(); // Convert BigInteger to int
	}

//	public static int encrypt(Integer integer) throws Exception {
//	    byte[] encryptedData = cipher.doFinal(integer.getBytes(StandardCharsets.UTF_8));
//	    BigInteger bigInt = new BigInteger(1, encryptedData); // Convert to positive BigInteger
//	    return bigInt.intValue(); // Convert BigInteger to int
//	}

	

//	public static String encrypt(String data) throws Exception {
//		byte[] encryptedData = cipher.doFinal(data.getBytes());
//		return Base64.getEncoder().encodeToString(encryptedData);

	//}  

	 

	public static String decrypt(String encryptedData) throws Exception {
		byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
		return new String(decryptedData, StandardCharsets.UTF_8);

	}

	public static SecretKey generateAesKey() {
		KeyGenerator keyGenerator;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(256);
			return keyGenerator.generateKey();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Error generating AES key");
		}

	}
	
}
