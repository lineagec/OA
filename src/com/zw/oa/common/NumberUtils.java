package com.zw.oa.common;

public class NumberUtils {

	public static int parseInt(String source, int defaultValue) {
		if(StringUtils.isEmpty(source)) {
			return defaultValue;
		}
		return Integer.parseInt(source);
	}
	
	public static int parseInt(String source) {
		return parseInt(source, 0);
	}
}
