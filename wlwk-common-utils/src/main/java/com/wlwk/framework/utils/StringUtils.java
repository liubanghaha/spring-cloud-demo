package com.wlwk.framework.utils;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

public final class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static final String[] chars = new String[] { //
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", //
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", //
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9" //
	};
	
	/**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^1\\d{10}$";
	
	/**
	 * 系统UUID
	 * 
	 * @return
	 */
	public static String systemUuid() {
		return String.valueOf(UUID.randomUUID());
	}

	/**
	 * 不带符号的UUID
	 * 
	 * @return
	 */
	public static String uuid() {
		return systemUuid().replace("-", "");
	}

	/**
	 * 8位UUID
	 * 
	 * @return
	 */
	public static String shortUuid() {
		final StringBuffer shortBuffer = new StringBuffer();
		final String uuid = uuid();
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	private final static String RAND_STR = "012356678899";
	private final static Random RANDOM = new Random();

	/**
	 * 获取随机字符串
	 * 
	 * @param len
	 * @return
	 */
	public static String randomStr(final Integer len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			sb.append(RAND_STR.charAt(RANDOM.nextInt(RAND_STR.length())));
		}
		return sb.toString();
	}
	
	/**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static Boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
}
