package com.zw.oa.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//判断是否登录
		HttpSession session = req.getSession();
		
		if(session.getAttribute("current") == null) {
			chain.doFilter(req, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login.jsp?state=0");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
