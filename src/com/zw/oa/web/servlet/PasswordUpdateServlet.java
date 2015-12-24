package com.zw.oa.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zw.oa.domain.Employee;
import com.zw.oa.exception.LoginFailException;
import com.zw.oa.service.EmployeeService;
import com.zw.oa.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class SuccessServlet
 */
public class PasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = new EmployeeServiceImpl();
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response)

	throws ServletException, IOException {
		  HttpSession session = request.getSession();
		  String oldpassword = request.getParameter("oldpassword");
		  String newpassword = request.getParameter("newpassword");
		  String repassword = request.getParameter("repassword");
		  Employee emp = (Employee) session.getAttribute("current");
		  String username = emp.getCode();
		  String password = emp.getPassword();
		 
		  try {
			employeeService.updatePwd(oldpassword,newpassword,repassword,password);
			request.setAttribute("suc", "密码修改成功");
			employeeService.login(username, newpassword);
			session.setAttribute("emp", emp);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		} catch (LoginFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/pages/employee/password.jsp").forward(request, response);
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
