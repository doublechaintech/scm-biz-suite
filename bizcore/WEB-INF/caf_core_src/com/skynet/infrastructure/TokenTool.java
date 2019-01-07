package com.skynet.infrastructure;


import java.util.ArrayList;
import java.util.List;

public class TokenTool {

	public TokenTool() {
		// TODO Auto-generated constructor stub
	}

	// the sample has 8 bits, for basic privileges,
	// MXWR in binary code 11111111
	// mxwr in binary code 01010101
	// Mxwr in binary code 11010101
	private static final String privilegeNames = "rRwWxXmM";
	private static final int[] privilegeValues = { 1, 3, 4, 12, 16, 48, 64, 192 };

	// 00000001, 00000011, 000000100, 00001100, 00010000, 00110000, 01000000,
	// 11000000

	public static int decode(String token) {
		int result = 0;
		for (char ch : token.toCharArray()) {

			int index = privilegeNames.indexOf(ch);
			if (index < 0) {
				// ignore any other chars
				continue;
			}
			int value = privilegeValues[index];
			
			result |= value;
		}

		return result;
	}

	public static int encodeTokens(String tokens[]) {
		int result = 0xff;
		for (String token : tokens) {

			int singleToken = decode(token);
			result &= singleToken;
		}

		return result;
	}

	public static int finalTokensOf(List<String[]> tokensList) {
		int result = 0;
		for (String[] tokens : tokensList) {

			int singleToken = encodeTokens(tokens);
			//System.out.println("--"+singleToken);
			result |= singleToken;
		}

		return result;
	}

	protected static char getTokenChar(int tokenValue, int offset,
			char partialChar, char fullChar) {

		int partialValue = (tokenValue >> offset) & 3;
		
		if (partialValue == 0) {
			return 0;
		}
		
		if (partialValue == 1) {
			return partialChar;
		}
		if (partialValue == 3) {
			return fullChar;
		}
		
		throw new IllegalArgumentException("The token value '" + tokenValue + "' is not legal");

	}

	public static String decodeTokens(int tokenValue) {

		StringBuilder result = new StringBuilder();

		char[] baseTokens = { 'r', 'w', 'x', 'm' };

		for (int i = 0; i < 4; i++) {
			char lowerCaseChar = baseTokens[3 - i];
			char upperCaseChar = (char) (lowerCaseChar - 32);
			char singleToken = getTokenChar(tokenValue, 6 - i * 2,
					lowerCaseChar, upperCaseChar);
			if(singleToken == 0){
				continue;
			}
			result.append(singleToken);
		}

		return result.toString();

	}

	public static void main(String[] args) throws ClassNotFoundException {

		
		System.out.println("v: " + decode("MXWR"));
		// decodeTokens
		System.out.println("v: " + decodeTokens(decode("MXWR")));
		System.out.println("v: " + decodeTokens(decode("MxWR")));
		
		String []tokens = {"MR","R"}; //mw
		String []tokens2 = {"Mxw","Mwr"}; //Mw
		
		//mw+Mw=Mw
		
		System.out.println("encodeTokens: " + encodeTokens(tokens));
		System.out.println("decodeTokens: " + decodeTokens(encodeTokens(tokens)));
		
		List<String []> list = new ArrayList<String []>();
		list.add(tokens);
		list.add(tokens2);
		System.out.println("finalTokensOf: " + decodeTokens(finalTokensOf(list)));
		
		
	}
}


