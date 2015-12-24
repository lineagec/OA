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


public class ReadServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WorkService workService = new WorkServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readerStr=request.getParameter("reader");
		Integer readerid=NumberUtils.parseInt(readerStr);
		
		try {
			workService.addred(readerid, Utils.current(request));
			request.setAttribute("msg", "读者设置成功");
			request.getRequestDispatcher("/pages/work/reader.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
