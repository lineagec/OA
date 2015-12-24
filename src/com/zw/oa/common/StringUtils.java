package com.zw.oa.common;

import java.util.UUID;

public class StringUtils {

	public static boolean isEmpty(String source) {
		return source == null || source.isEmpty();
	} 
	
	public static boolean notEmpty(String source) {
		return !isEmpty(source);
	}
	
	public static String uuid36() {
		return UUID.randomUUID().toString();
	}
	
	public static String uuid32() {
		return uuid36().replace("-", "");
	}
}
