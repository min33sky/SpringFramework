package encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

/*
 * 자바 암호화 
 */
public class EncryptEx {
	public static void main(String[] args) {
		String password = "qwe123";
		
		MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] mdResult = md.digest(password.getBytes());
			Encoder enc = Base64.getEncoder();
			String encryptedPass = enc.encodeToString(mdResult);
			System.out.println(encryptedPass);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
}
