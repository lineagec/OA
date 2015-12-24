package com.zw.oa.web.servlet.work;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.common.Utils;
import com.zw.oa.service.WorkService;
import com.zw.oa.service.impl.WorkServiceImpl;

public class AgencyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private WorkService workService = new WorkServiceImpl();
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	    String agencyStr=request.getParameter("agency");
		Integer agencyid=NumberUtils.parseInt(agencyStr);
		
		try {
			workService.addagency(agencyid, Utils.current(request));
			request.setAttribute("msg", "代办设置成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/work/agency.jsp").forward(request, response);
	   
}
}
