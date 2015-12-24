package com.zw.oa.web.servlet.work;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.DateUtils;
import com.zw.oa.common.NumberUtils;
import com.zw.oa.common.Page;
import com.zw.oa.common.Utils;
import com.zw.oa.domain.Work;
import com.zw.oa.service.WorkService;
import com.zw.oa.service.impl.WorkServiceImpl;
import com.zw.oa.web.servlet.vo.WorkVO;

/**
 * Servlet implementation class QueryWorkServlet
 */
public class QueryWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WorkService workService = new WorkServiceImpl();
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageIndex = NumberUtils.parseInt(request.getParameter("pageIndex"), 1);
		int pageRows = NumberUtils.parseInt(request.getParameter("pageRows"), 10);
		// 获取参数 并封装
		int finisherId = NumberUtils.parseInt(request.getParameter("finisher"));
		if(finisherId == 0) {
			finisherId = Utils.current(request).getId();
		}
		int creatorId = NumberUtils.parseInt(request.getParameter("creator"));
		String startTime1    = request.getParameter("startTime");
    	Date startTime = DateUtils.parse(startTime1, "MM-dd-yyyy");
    	String endTime1    = request.getParameter("endTime");
    	Date endTime = DateUtils.parse(endTime1, "MM-dd-yyyy");
		String keyWord = request.getParameter("keyWord");
		WorkVO wv = new WorkVO(finisherId, creatorId, startTime, endTime, keyWord);
		
		// 调用service 查询
		try {
			Page<Work> page = workService.lists(wv, pageIndex, pageRows);
			
			request.setAttribute("page", page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/pages/work/query.jsp").forward(request, response);
	}
}
