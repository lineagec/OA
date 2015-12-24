package com.zw.oa.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zw.oa.domain.Employee;
import com.zw.oa.exception.LoginFailException;
import com.zw.oa.service.EmployeeService;
import com.zw.oa.service.impl.EmployeeServiceImpl;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受账号和密码
		String username = request.getParameter("code");
		String password = request.getParameter("password");
		
		try {
			// 将账号和密码交给service来完成登录
			Employee emp = employeeService.login(username, password);
			
			// 获取会话对象
			HttpSession session = request.getSession();
			// 将登录成功的用户信息保存到会话中
			session.setAttribute("current", emp);
			
			if(password.equals(emp.getPassword())){
				String remember = request.getParameter("remember");
				if(remember!=null&&!remember.isEmpty()){
					Cookie cookie4username = new Cookie("code", username);
					cookie4username.setMaxAge(604800);
					Cookie cookie4password = new Cookie("password", password);
					cookie4password.setMaxAge(604800);
					response.addCookie(cookie4username);
					response.addCookie(cookie4password);
				}
			}
			//转到登录成功后的页面
			response.sendRedirect(request.getContextPath() + "/pages/index.jsp");
		} catch (LoginFailException e) {
			e.printStackTrace();
			// 登录出错直接返回到登录页面,并提示消息
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}
	
}
