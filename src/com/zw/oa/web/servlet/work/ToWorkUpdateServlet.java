package com.zw.oa.web.servlet.work;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.domain.Work;
import com.zw.oa.service.WorkService;
import com.zw.oa.service.impl.WorkServiceImpl;

/**
 * Servlet implementation class ToWorkUpdateServlet
 */
public class ToWorkUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WorkService workService = new WorkServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取id
		int id = NumberUtils.parseInt(request.getParameter("id"));
		
		try {
			// 依赖service进行查询
			Work work = workService.get(id);
			
			request.setAttribute("work", work);
			
			request.getRequestDispatcher("/pages/work/update.jsp").forward(request, response);
		} catch (SQLException e) {
			//TODO 提示没找到
			e.printStackTrace();
		}
	}
}
