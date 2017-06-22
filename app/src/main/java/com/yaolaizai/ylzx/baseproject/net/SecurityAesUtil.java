package com.yaolaizai.ylzx.baseproject.net;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES加解密
 * @author wei
 */
public abstract class SecurityAesUtil {
	
	/**
	 * 加密
	 * @param content 需要加密的内容
	 * @param password 消息加解密密钥
	 * @return
	 */
	public static String encode(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			byte[] byteContent = content.getBytes("utf-8");
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			return parseByte2HexStr(cipher.doFinal(byteContent)); // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**解密
	 * @param content  待解密内容
	 * @param password 消息加解密密钥
	 * @return
	 */
	public static String decode(String content, String password) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, new SecureRandom(password.getBytes()));
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			return new String(cipher.doFinal(parseHexStr2Byte(content))); // 加密
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**将二进制转换成16进制
	 * @param value
	 * @return
	 */
	private static String parseByte2HexStr(byte[] value) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < value.length; i++) {
			String hex = Integer.toHexString(value[i] & 0xFF);
			if (hex.length() == 1) {
			hex = '0' + hex;
		}
			buf.append(hex.toLowerCase());
		}
		return buf.toString();
	}
	
	/**将16进制转换为二进制
	 * @param value
	 * @return
	 */
	private static byte[] parseHexStr2Byte(String value) {
		if (value.length() < 1) {
			return null;
		}
		byte[] result = new byte[value.length() / 2];
		for (int i = 0; i < value.length() / 2; i++) {
			int high = Integer.parseInt(value.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(value.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

}
