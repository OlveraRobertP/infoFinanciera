/**
 * 
 */
package com.robolverap.web.security.ecrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * @author jrobolvp
 *
 */
public class SHA256Util {
	
	/**
	 * Codifica un sting a un sha-256 de 64 bits
	 * @param original Caneda a codificar
	 * @return Cadena codificada
	 */
	public static String encodeToSha256(String original)  {
	    MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(original.getBytes());
		    byte[] digest = md.digest();
		    return new String(DatatypeConverter.printHexBinary(digest));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	    
	}

}
