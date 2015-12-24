package com.zw.oa.common;

import javax.servlet.http.HttpServletRequest;

import com.zw.oa.domain.Employee;

public class Utils {

	public static Employee current(HttpServletRequest request) {
		return (Employee) request.getSession().getAttribute("current");
	}
	
}
