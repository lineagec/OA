package com.zw.oa.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zw.oa.common.DateUtils;
import com.zw.oa.common.NumberUtils;
import com.zw.oa.domain.Department;
import com.zw.oa.domain.Employee;
import com.zw.oa.service.EmployeeService;
import com.zw.oa.service.impl.EmployeeServiceImpl;



/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收请求参数
		String idStr          = request.getParameter("id");
		int id = NumberUtils.parseInt(idStr);
		String code        = request.getParameter("code");
		String name        = request.getParameter("name");
		String gender      = request.getParameter("gender");
		String birthdayStr    = request.getParameter("birthday");
		Date birthday = DateUtils.parse(birthdayStr, "mm-dd-yyyy");
		String job         = request.getParameter("job");
		String introduce   = request.getParameter("introduce");
		String hobby       = request.getParameter("hobby");
		String mobilePhone = request.getParameter("mobilePhone");
		String phone       = request.getParameter("phone");
		String email       = request.getParameter("email");
		String qq          = request.getParameter("qq");
		String wechat      = request.getParameter("wechat");
		
		String departStr   = request.getParameter("depart");
		
		int departId = NumberUtils.parseInt(departStr);
		Department depart = new Department();
		depart.setId(departId);
		
		// 封装到对象
		Employee emp = new Employee(id, code, null, name, gender, birthday, depart, job, introduce, hobby, mobilePhone, phone, email, qq, wechat, null);
		
		try {
			employeeService.update(emp);
			// 成功
			HttpSession session = request.getSession();
			session.setAttribute("current", emp);
			request.setAttribute("status", 1);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("status", 2);
		}
		request.getRequestDispatcher("/pages/employee/info.jsp").forward(request, response);
	}
}
