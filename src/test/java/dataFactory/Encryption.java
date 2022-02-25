package dataFactory;

import java.util.Base64;

public class Encryption {

	
	
	
	public static String Decoder(String encryptedCred) {
		
		byte[] decryptedCred = Base64.getDecoder().decode(encryptedCred.getBytes());
		
		return new String(decryptedCred);
		
		
	}
}
