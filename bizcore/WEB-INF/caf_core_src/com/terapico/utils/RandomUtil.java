package com.terapico.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class RandomUtil {
	private static final String charSet4NumAndChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String charSet4Chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String charSet4Num = "0123456789";
	private static final String charSet4HexChars = "0123456789ABCDEF";
	private static final String charSet4NumAndClearChars = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZ";

	public static String randomNumAndChars(int length) {
		return genRandomString(charSet4NumAndChars, length);
	}

	public static String randomNum(int length) {
		return genRandomString(charSet4Num, length);
	}

	public static int randomInteger(int maxRange) {
		double value = maxRange * Math.random();
		return (int) value;
	}

	public static String randomChars(int length) {
		return genRandomString(charSet4Chars, length);
	}
	
	public static String randomHexChars(int length) {
		return genRandomString(charSet4HexChars, length);
	}

	public static String randomClearNumAndChars(int length) {
		return genRandomString(charSet4NumAndClearChars, length);
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

    public static List<Integer> getRandomArray(int size) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<size;i++){
			list.add(i);
		}
		Collections.shuffle(list);
		return list;
    }
}
