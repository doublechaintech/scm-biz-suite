package com.terapico.utils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextUtil {
    public static boolean isBlank(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    public static String formatBookISBN(String bookIsbn) {
        if (isBlank(bookIsbn)) {
            return "";
        }
        return bookIsbn.replaceAll("[^\\d]", "");
    }

    public static String join(Collection<String> inputArray, String seperator) {
        if (CollectionUtils.isEmpty(inputArray)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String str : inputArray) {
            if (isBlank(str)) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                sb.append(seperator);
            }
            sb.append(str);
        }
        return sb.toString();
    }


    public static String headNChars(String input, int maxLength) {
        if (isBlank(input)) {
            return input;
        }
        if (input.length() <= maxLength) {
            return input;
        }
        return input.substring(0, maxLength) + "...";
    }

    public static String onlyNumber(String input) {
        if (isBlank(input)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean canPlaceSignFlag = true;
        boolean hasPointer = false;
        for (char c : input.toCharArray()) {
            c = transferSBCCaseNumber(c, false);
            if (c != '+' && c != '-' && c != '.' && (c < '0' || c > '9')) {
                continue;
            }
            if ((c == '+' || c == '-') && canPlaceSignFlag) {
                canPlaceSignFlag = false;
                sb.append(c);
                continue;
            }
            canPlaceSignFlag = false;
            if (c == '.' && !hasPointer) {
                sb.append(c);
                hasPointer = true;
                continue;
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static char transferSBCCaseNumber(char c, boolean handleChineseNumber) {
        int index = "０１２３４５６７８９".indexOf(c);
        if (index >= 0) {
            return (char) (index + '0');
        }
        if (handleChineseNumber) {
            index = "零壹贰叁肆伍陆柒捌玖".indexOf(c);
            if (index >= 0) {
                return (char) (index + '0');
            }
            index = "零一二三四五六七八九".indexOf(c);
            if (index >= 0) {
                return (char) (index + '0');
            }
        }
        return c;
    }

    public static String firstChars(String inputStr, int maxLength) {
        if (inputStr == null) {
            return null;
        }
        int length = inputStr.length();
        if (length <= maxLength) {
            return inputStr;
        }
        if (maxLength < 3) {
            return inputStr.substring(0, maxLength);
        }
        return inputStr.substring(0, maxLength - 3) + "...";
    }

    // 值相等。如果有一个为null则判定为false.
    public static boolean valueEquals(String val1, String val2) {
        if (val1 == null || val2 == null) {
            return false;
        }
        return val1.equals(val2);
    }


    /**
     * ASCII表中可见字符从!开始，偏移位值为33(Decimal)
     */
    static final char DBC_CHAR_START = 33; // 半角!

    /**
     * ASCII表中可见字符到~结束，偏移位值为126(Decimal)
     */
    static final char DBC_CHAR_END = 126; // 半角~

    /**
     * 全角对应于ASCII表的可见字符从！开始，偏移值为65281
     */
    static final char SBC_CHAR_START = 65281; // 全角！

    /**
     * 全角对应于ASCII表的可见字符到～结束，偏移值为65374
     */
    static final char SBC_CHAR_END = 65374; // 全角～

    /**
     * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
     */
    static final int CONVERT_STEP = 65248; // 全角半角转换间隔

    /**
     * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
     */
    static final char SBC_SPACE = 12288; // 全角空格 12288

    /**
     * 半角空格的值，在ASCII中为32(Decimal)
     */
    static final char DBC_SPACE = ' '; // 半角空格

    /**
     * <PRE>
     * 半角字符->全角字符转换
     * 只处理空格，!到˜之间的字符，忽略其他
     * </PRE>
     */
    public static String bj2qj(String src) {
        if (src == null) {
            return src;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == DBC_SPACE) { // 如果是半角空格，直接用全角空格替代
                buf.append(SBC_SPACE);
            } else if ((ca[i] >= DBC_CHAR_START) && (ca[i] <= DBC_CHAR_END)) { // 字符是!到~之间的可见字符
                buf.append((char) (ca[i] + CONVERT_STEP));
            } else { // 不对空格以及ascii表中其他可见字符之外的字符做任何处理
                buf.append(ca[i]);
            }
        }
        return buf.toString();
    }

    /**
     * 半角转换全角
     *
     * @param src
     * @return
     */
    public static int bj2qj(char src) {
        int r = src;
        if (src == DBC_SPACE) { // 如果是半角空格，直接用全角空格替代
            src = SBC_SPACE;
        } else if ((src >= DBC_CHAR_START) && (src <= DBC_CHAR_END)) { // 字符是!到~之间的可见字符
            r = src + CONVERT_STEP;
        }
        return r;
    }

    /**
     * <PRE>
     * 全角字符->半角字符转换
     * 只处理全角的空格，全角！到全角～之间的字符，忽略其他
     * </PRE>
     */
    public static String qj2bj(String src) {
        if (src == null) {
            return src;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < src.length(); i++) {
            if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内
                buf.append((char) (ca[i] - CONVERT_STEP));
            } else if (ca[i] == SBC_SPACE) { // 如果是全角空格
                buf.append(DBC_SPACE);
            } else { // 不处理全角空格，全角！到全角～区间外的字符
                buf.append(ca[i]);
            }
        }
        return buf.toString();
    }

    /**
     * 全角转换半角
     *
     * @param src
     * @return
     */
    public static int qj2bj(char src) {
        int r = src;
        if (src >= SBC_CHAR_START && src <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内
            r = src - CONVERT_STEP;
        } else if (src == SBC_SPACE) { // 如果是全角空格
            r = DBC_SPACE;
        }
        return r;
    }

    public static String formatNumber(Number number, String format) {
    	if (number == null) {
    		number = new Integer(0);
    	}
        return new DecimalFormat(format).format(number.doubleValue());
    }

    public static String getExtVariable(String key, String defaultValue) {
        String val = System.getProperty(key);
        if (val != null) {
            return val;
        }
        val = System.getenv(key);
        if (val != null) {
            return val;
        }
        return defaultValue;
    }

    public static String concatUrl(String prefix, String uri) {
        if (isBlank(prefix)) {
            return uri;
        }
        if (isBlank(uri)) {
            return prefix;
        }
        boolean hasEnd = prefix.endsWith("/");
        boolean hasLead = uri.startsWith("/");
        if (!hasEnd && !hasLead) {
            return prefix + "/" + uri;
        }
        if (hasEnd != hasLead) {
            return prefix + uri;
        }
        return prefix + uri.substring(1);
    }

    public static String shrink(String orgStr, int headChars, int tailChars, String moreFlag) {
        if (isBlank(orgStr)) {
            return orgStr;
        }
        boolean isMask = moreFlag.matches("^\\*+$");
        if (isMask && (headChars + tailChars) >= orgStr.length()) {
        	return orgStr;
        }
        int finalLen = headChars + tailChars + (moreFlag == null ? 0 : moreFlag.length());
        if (orgStr.length() <= finalLen && !isMask) {
            return orgStr;
        }
        StringBuilder sb = new StringBuilder();
        if (headChars >= 0) {
            sb.append(orgStr.substring(0, headChars));
        }
        sb.append(moreFlag);
        if (tailChars >= 0) {
            sb.append(orgStr.substring(orgStr.length() - tailChars));
        }
        return sb.toString();
    }

	public static String uncapFirstChar(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return Character.toLowerCase(str.charAt(0)) + str.substring(1);
	}
	public static String capFirstChar(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	public static String encodeUrl(String urlStr) {
		return encodeEntireUrl(urlStr);
	}
//	private static String ENCODED_SLASH = URLEncoder.encode("/");
			
	public static String encodeEntireUrl(String urlStr) {
		if (isBlank(urlStr)) {
			return null;
		}
		try {
//			String urlEncoded = URLEncoder.encode(urlStr, "ut-8");
//			urlEncoded = urlEncoded.replace("%2F", replacement)
			return new URI(urlStr).toASCIIString();
		} catch (Exception e) {
			e.printStackTrace();
			return urlStr;
		}
	}

	public static boolean isEqualsIfNotNull(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		return str1.equals(str2);
	}
	
	public static String repeat(String repeatedStr, int times, String seperator) {
		return repeat(repeatedStr, times, seperator, true);
	}

	public static String repeat(String repeatedStr, int times, String seperator, boolean noSeperatorAtLast) {
		if (times <= 0) {
			return "";
		}
		StringBuilder sb  = new StringBuilder();
		for(int i=0;i<times;i++) {
			sb.append(repeatedStr);
			if (seperator!= null  && (!noSeperatorAtLast || i < (times-1))) {
				sb.append(seperator);
			}
		}
		return sb.toString();
	}

	public static int lengthOf(String inStr) {
		if (inStr == null) {
			return 0;
		}
		return inStr.length();
	}
	
	public static String formatMobileNumber(String inStr) {
		if (inStr == null) {
			return null;
		}
		String str = onlyNumber(inStr);
		return str;
	}

	private static final Pattern ptnChnMobile = Pattern.compile("1[3-9]\\d{9}");
	public static String formatChinaMobile(String mobile) {
		String num = TextUtil.onlyNumber(mobile);
		if (num.startsWith("86") || num.startsWith("086") || num.startsWith("0086")) {
			int pos = num.indexOf("86");
			num = num.substring(pos+2);
		}
		Matcher m = ptnChnMobile.matcher(num);
		if (m.matches()) {
			return num;
		}
		return null;
	}
	
	public static String nullIfBlank(String input) {
		if (isBlank(input)) {
			return null;
		}
		return input.trim();
	}

	public static String firstNotBlank(String ...strings ) {
		if (strings == null || strings.length == 0) {
			return null;
		}
		for(String str : strings) {
			if(!isBlank(str)) {
				return str;
			}
		}
		return null;
	}

	public static List<String> findAllMatched(String source, Pattern pattern) {
		Matcher matcher = pattern.matcher(source);
		List<String> list = new ArrayList<>();
		while (matcher.find()) {
			list.add(matcher.group());
		}
		return list;

	}
	
	public static String toCamelCase(String input) {
		// 以空格或者下划线分隔,首字母大写,其他全部小写
		// 已经是camel case了,就不处理
		if (input == null || input.isEmpty()) {
			return input;
		}
		if (input.matches("^[A-Za-z][^ _]*$")) {
			return capFirstChar(input); 
		}
		List<String> strList = new ArrayList<>(Arrays.asList(input.trim().split("[ _]")));
		List<String> strList2 = strList.stream()
			.filter(str->(str != null && str.trim().length() > 0))
			.map(str->capFirstChar(str.toLowerCase()))
			.collect(Collectors.toList());
		return String.join("", strList2);
	}
	
	static final int GB_SP_DIFF = 160;
    // 存放国标一级汉字不同读音的起始区位码
    static final int[] secPosValueList = { 1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635,
            3722, 3730, 3858, 4027, 4086, 4390, 4558, 4684, 4925, 5249, 5600 };
    // 存放国标一级汉字不同读音的起始区位码对应读音
    static final char[] firstLetter = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'w', 'x', 'y', 'z' };

    /**
     * 提取汉字字符串的首字母
     * @param characters 汉字字符串
     * @return
     */
    public static String getSpells(String characters) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < characters.length(); i++) {

            char ch = characters.charAt(i);
            if ((ch >> 7) == 0) {
                // 判断是否为汉字，如果左移7为为0就不是汉字，否则是汉字
                buffer.append(ch);
            } else {
                char spell = getFirstLetter(ch);
                buffer.append(String.valueOf(spell));
            }
        }
        return buffer.toString();
    }

    /**
     * 获取一个汉字的首字母
     * @param ch 汉字
     * @return
     */
    public static Character getFirstLetter(char ch) {

        byte[] uniCode = null;
        try {
            uniCode = String.valueOf(ch).getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        if (uniCode[0] < 128 && uniCode[0] > 0) { // 非汉字
            return null;
        } else {
            return convert(uniCode);
        }
    }

    /**
     * 获取一个汉字的拼音首字母。 GB码两个字节分别减去160，转换成10进制码组合就可以得到区位码
     * 例如汉字“你”的GB码是0xC4/0xE3，分别减去0xA0（160）就是0x24/0x43
     * 0x24转成10进制就是36，0x43是67，那么它的区位码就是3667，在对照表中读音为‘n’
     */
    private static char convert(byte[] bytes) {
        char result = '#';
        int secPosValue = 0;
        int i;
        for (i = 0; i < bytes.length; i++) {
            bytes[i] -= GB_SP_DIFF;
        }
        secPosValue = bytes[0] * 100 + bytes[1];
        for (i = 0; i < 23; i++) {
            if (secPosValue >= secPosValueList[i] && secPosValue < secPosValueList[i + 1]) {
                result = firstLetter[i];
                break;
            }
        }
        return result;
    }

}
