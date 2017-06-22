package com.yaolaizai.ylzx.baseproject.net;

import java.net.URLEncoder;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DES3Util {
	
    private final static String iv = "01234567";  
    
    private final static String encoding = "utf-8";  
    
    /** 
     * 3DES加密 
     *  
     * @param plainText 普通文本 
     * @return 
     * @throws Exception  
     */  
    public static String encode(String plainText, String secretKey) throws Exception { 
        Key deskey = null;  
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());  
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
        deskey = keyfactory.generateSecret(spec);  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());  
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);  
        byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));  
        return Base64.encode(encryptData);
    }  
  
    /** 
     * 3DES解密 
     * @param encryptText 加密文本
     * @return 
     * @throws Exception 
     */  
    public static String decode(String encryptText, String secretKey) throws Exception {  
        Key deskey = null;  
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());  
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
        deskey = keyfactory.generateSecret(spec);  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());  
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);  
        byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));
        return new String(decryptData, encoding);  
    }

    public static void main(String[] args) throws Exception{
        System.out.println("liuyunqiang@lx100$#365#$".length());
        String content = "test1,,test2,中文,test";
        System.out.println("加密前：" + content);
        String key = "yaolaizaixian20160601###";
        System.out.println("加密密钥和解密密钥：" + key);
        String encrypt = encode(content, key);
        System.out.println("加密后：" + encrypt);
        System.out.println(URLEncoder.encode(encrypt, "utf-8"));
        String decrypt = decode(encrypt, key);
        System.out.println("解密后：" + decrypt);
    }

}
