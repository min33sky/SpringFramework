package encrypt;

import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * AES와 DES 암호화 하기
 * http://linuxism.tistory.com/1564
 * 초기화 백터(initialization vector, IV )
 */
public class EncryptAesDes {
	public static byte[] enc(String alg, byte[] key, byte[] iv, byte[] msg) throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(key, alg);
		if (alg.equals("DES")) {
			alg = "DES/CBC/PKCS5Padding";
		} else {
			alg = "AES/CBC/PKCS5Padding";
		}
		Cipher cipher = Cipher.getInstance(alg);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));
		cipher.update(msg);
		return cipher.doFinal();
	}

	public static void main(String[] args) throws Exception {
		byte[] key = "1234567890123456".getBytes();
		byte[] iv = "1234567890123456".getBytes();
		String pt = "This is a test message!!!";
		System.out.println("평문: " + pt);
		byte[] e = enc("AES", key, iv, pt.getBytes());
		System.out.println("AES 암호화: " + new BigInteger(e).toString(16));
		key = "12345678".getBytes();
		iv = "12345678".getBytes();
		e = enc("DES", key, iv, pt.getBytes());
		System.out.println("DES 암호화: " + new BigInteger(e).toString(16));
	}
}
