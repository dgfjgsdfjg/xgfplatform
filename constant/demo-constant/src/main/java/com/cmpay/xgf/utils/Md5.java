package com.cmpay.xgf.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xgf
 */
public class Md5 {
	public static String md5(String text) {
		String result = null;
		
		try {
			byte[] out = MessageDigest.getInstance("MD5").digest(text.getBytes());
			//System.out.println(Arrays.toString(out));
			//System.out.println(out.length);
			
			result = new BigInteger(1,out).toString(16);
			
			
		} catch (NoSuchAlgorithmException e) {
		
			e.printStackTrace();
		}
		
		return result;
	}
}
