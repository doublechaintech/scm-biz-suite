package com.terapico.utils;

public class RandomUtil {
	private static final String charSet4NumAndChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String charSet4Chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String charSet4Num = "0123456789";
	private static final String charSet4HexChars = "0123456789ABCDEF";

	public static String randomNumAndChars(int length) {
		return genRandomString(charSet4NumAndChars, length);
	}

	public static String randomNum(int length) {
		return genRandomString(charSet4Num, length);
	}

	public static int randomInteger(int maxRange) {
		Double value = maxRange * Math.random();
		return value.intValue();
	}

	public static String randomChars(int length) {
		return genRandomString(charSet4Chars, length);
	}
	
	public static String randomHexChars(int length) {
		return genRandomString(charSet4HexChars, length);
	}

	private static String genRandomString(String charset, int length) {
		int max = charset.length();
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			Double randomVal = max * Math.random();
			int pos = randomVal.intValue();
			pos = Math.min(pos, max - 1);
			pos = Math.max(0, pos);
			sb.append(charset.charAt(pos));
		}
		return sb.toString();
	}

	public static int getRandomInRange(int min, int max) {
		return min + (int)(Math.random()*(max-min));
	}
}
