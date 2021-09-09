package com.terapico.utils;

import java.util.Arrays;
import java.util.List;

public class InviteCodeUtil {
	protected static String[] codeArrays = new String[] { "z9r16spewh84vqj037nmcabxy2gfdukt5",
			"dne5r31jqa4bhfv0m6k9ztcp728yguxws", "k1r95y8vuscm4jxnfgbezpa0t7hw26qd3",
			"b4k97fsw3v1ynqpg8thjzdr5x0um2ae6c", "vn67f05kdqstbeyzu1pmah4wg39xjc2r8",
			"hqtcfjnzr5ba64ysew1k2398muv0dpx7g", "rsq2gek8tdj9uph0a1fb354mx67znvcyw",
			"m5fxz1gbw2h8jpsecvar4q7yu9d0kn6t3", "snyh0wdj34tebfxvugrcmp58kzq6a1729",
			"2h4f36ktmvwjpsrzudc05xa1bn7gyeq89", "my4cfkse9gz7vr3what16bnq50jpu8d2x",
			"cm8g21tubaz7xvyjh5wdpqr03s9e4f6nk", };

	public static String genInviteCode(long code) {
		int inviteCodeLen = 12;
		int saltWidth = codeArrays[0].length();
		int inviteCodeBits = (int) (Math.log10(Math.pow(saltWidth, inviteCodeLen)) / Math.log10(2));
		return convertToInviteCode(code, codeArrays[0].length(), inviteCodeBits, Arrays.asList(codeArrays),
				inviteCodeLen);
	}

	public static String gen6CharInviteCode(long code) {
		return convertToInviteCode(code, codeArrays[0].length(), 32, Arrays.asList(codeArrays),	6);
	}
	public static String gen8CharInviteCode(long code) {
		return convertToInviteCode(code, codeArrays[0].length(), 40, Arrays.asList(codeArrays),	8);
	}
	
	private static String convertToInviteCode(long inviteCode, int radix, int inviteCodeBits, List<String> codeTable,
			int inviteCodeLen) {
		if (inviteCodeBits > 60) {
			throw new RuntimeException("max invite code bits is 60. Now assigned " + inviteCodeBits);
		}
		long codeValue = processCodeValue(inviteCode, inviteCodeBits);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inviteCodeLen; i++) {
			int modNum = (int) (codeValue % radix);
			sb.append(codeTable.get(i).charAt(modNum));
			codeValue = codeValue / radix;
		}
		return sb.toString().toUpperCase();
	}

	private static long processCodeValue(long inviteCode, int inviteCodeBits) {
		String bitString = Long.toBinaryString(inviteCode ^ 0xA5A5A5A5A5A5A5A5L);
		int len = bitString.length();
		char[] step1Array = new char[inviteCodeBits];
		for (int i = 0; i < inviteCodeBits; i++) {
			if (i < len) {
				step1Array[i] = bitString.charAt(len - 1 - i);
			} else {
				step1Array[i] = '0';
			}
		}
		for (int i = 0; i < inviteCodeBits / 2; i += 2) {
			char c = step1Array[i];
			step1Array[i] = step1Array[inviteCodeBits - i - 1];
			step1Array[inviteCodeBits - i - 1] = c;
		}
		long step2Value = 0;
		for (int i = 0; i < inviteCodeBits; i++) {
			step2Value = (step2Value << 1) + (step1Array[inviteCodeBits - 1 - i] == '1' ? 1 : 0);
		}
		return step2Value;
	}

}
