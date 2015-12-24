package com.zw.oa.web.servlet.work;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.Utils;
import com.zw.oa.domain.Work;
import com.zw.oa.service.WorkService;
import com.zw.oa.service.impl.WorkServiceImpl;

/**
 * Servlet implementation class ListWorkServlet
 */
public class ListWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WorkService workService = new WorkServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			List<Work> works = workService.list(Utils.current(request));
			
			request.setAttribute("works", works);
			request.getRequestDispatcher("/pages/work/workinfo.jsp").forward(request, response);
			// TODO 查询成功
		} catch(SQLException e) {
			e.printStackTrace();
			// TODO 查询失败
		}
	}
}
