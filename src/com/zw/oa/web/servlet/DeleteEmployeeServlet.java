package com.zw.oa.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.domain.Employee;
import com.zw.oa.service.EmployeeService;
import com.zw.oa.service.impl.EmployeeServiceImpl;

public class DeleteEmployeeServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = new EmployeeServiceImpl();

@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String idStr=request.getParameter("ids");
	Integer id=NumberUtils.parseInt(idStr);
	try {
		employeeService.delete(id);
		request.setAttribute("msg", "员工删除成功");
		request.getRequestDispatcher("/pages/administrator/delete.jsp").forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
