package com.zw.oa.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.DateUtils;
import com.zw.oa.common.NumberUtils;
import com.zw.oa.domain.Department;
import com.zw.oa.domain.Employee;
import com.zw.oa.service.EmployeeService;
import com.zw.oa.service.impl.EmployeeServiceImpl;

public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService = new EmployeeServiceImpl();

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String birthdayStr    = request.getParameter("birthday");
		Date birthday = DateUtils.parse(birthdayStr, "mm-dd-yyyy");
		String job=request.getParameter("job");
	    String introduce=request.getParameter("introduce");
	    String hobby=request.getParameter("hobby");
	    String mobilePhone = request.getParameter("mobilePhone");
		String phone       = request.getParameter("phone");
		String email       = request.getParameter("email");
		String qq          = request.getParameter("qq");
		String wechat      = request.getParameter("wechat");

        String departStr   = request.getParameter("depart");
		int departId = NumberUtils.parseInt(departStr);
		Department depart = new Department();
		depart.setId(departId);
		
		String roleStr=request.getParameter("role");
		int role = NumberUtils.parseInt(roleStr);
		
		
		Employee emp = new Employee(code, name, password, gender, birthday, depart, job, introduce, hobby, mobilePhone, phone, email, qq, wechat,role);
	
		try {
			employeeService.add(emp);
			request.getRequestDispatcher("/pages/administrator/add.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加失败:" + e.getMessage());
			request.getRequestDispatcher("/pages/administrator/add.jsp").forward(request, response);
		}
	}
}
