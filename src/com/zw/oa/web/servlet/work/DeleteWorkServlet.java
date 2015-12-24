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

/**
 * Servlet implementation class DeleteWorkServlet
 */
public class DeleteWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WorkService workService = new WorkServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = NumberUtils.parseInt(request.getParameter("id"));
		
		try {
			
			workService.delete(id, Utils.current(request));
			
			request.setAttribute("msg", "删除成功");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "删除失败:" + e.getMessage());
		}
		request.getRequestDispatcher("/servlet/ListWorkServlet").forward(request, response);
	}
}
