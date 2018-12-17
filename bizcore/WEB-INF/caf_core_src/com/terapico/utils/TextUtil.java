package com.terapico.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.List;

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

    public static String join(List<String> inputArray, String seperator) {
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
        int finalLen = headChars + tailChars + (moreFlag == null ? 0 : moreFlag.length());
        if (orgStr.length() <= finalLen) {
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
		return urlStr;
	}
	public static String encodeEntireUrl(String urlStr) {
		try {
			return new URI(urlStr).toASCIIString();
		} catch (URISyntaxException e) {
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
}
