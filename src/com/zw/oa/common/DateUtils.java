package com.zw.oa.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {

	/**
	 * 日期格式转换对象
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	/**
	 * 系统默认格式
	 */
	public static final String DEFAULT_PATTERN = "MM-dd-yyyy HH:mm:ss";
	
	/**
	 * 将指定日期按照默认格式转成字符串
	 * 
	 * @param source
	 *     被转的日期
	 * @return
	 *     转换后的字符串
	 */
	public static String format(Date source) {
		return format(source, DEFAULT_PATTERN);
	}
	
	/**
	 * 将指定日期按照指定格式转换成字符串
	 * 
	 * @param source
	 *     被转日期
	 * @param pattern
	 *     指定格式
	 * @return
	 *     转换后的字符串
	 */
	public static String format(Date source, String pattern) {
		if(source == null) {
			return null;
		}
		sdf.applyPattern(pattern);
		
		return sdf.format(source);
	}
	
	/**
	 * 将字符串按照默认格式转成日期类型
	 * 
	 * @param source
	 *     被转字符串
	 * @return
	 *     转换后的日期值
	 */
	public static Date parse(String source) {
		return parse(source, DEFAULT_PATTERN);
	}
	
	/**
	 * 将字符串按照指定格式转成日期类型
	 * 
	 * @param source
	 *     被转的字符串
	 * @param pattern
	 *     指定格式
	 * @return
	 *     转换后的日期值
	 */
	public static Date parse(String source, String pattern) {
		
		if(StringUtils.isEmpty(source)) {
			return null;
		}
		
		// 设置格式
		sdf.applyPattern(pattern);
		try {
			// 将字符串转出成时间返回
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 将普通日期类型转成数据库日期类型
	 * 
	 * @param date 
	 *     被转的日期值
	 * @return
	 *     转换后的日期值
	 */
	public static java.sql.Date toSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
	
	/**
	 * 将普通日期类型转换为数据库时间戳
	 * 
	 * @param date
	 *     被转日期
	 * @return
	 *     转换后的时间戳值
	 */
	public static java.sql.Timestamp toTimestamp(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}
}
