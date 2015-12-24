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
import com.zw.oa.common.Utils;
import com.zw.oa.domain.Employee;
import com.zw.oa.domain.Work;
import com.zw.oa.service.WorkService;
import com.zw.oa.service.impl.WorkServiceImpl;

/**
 * Servlet implementation class AddWorkServlet
 */
public class AddWorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 工作安排服务对象
	 */
	private WorkService workService = new WorkServiceImpl();
	
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// 接收参数
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	int empId = NumberUtils.parseInt(request.getParameter("emp"));
    	Employee emp = new Employee(empId);
     	String startTime1    = request.getParameter("startTime");
		Date startTime = DateUtils.parse(startTime1, "MM-dd-yyyy");
	   	String endTime1    = request.getParameter("endTime");
		Date endTime = DateUtils.parse(endTime1, "MM-dd-yyyy");
  /*  	Date startTime = DateUtils.parse(request.getParameter("startTime"));
    	Date endTime = DateUtils.parse(request.getParameter("endTime"));   */
    	// 封装到对象
    	Work work = new Work(title, 
    			content, 
    			emp, 
    			Utils.current(request), 
    			startTime, 
    			endTime);
    	
    	try {
    		// 添加到数据库中
    		workService.add(work);
    		request.setAttribute("msg", "添加日程成功");
    		response.sendRedirect(request.getContextPath() + "/servlet/ListWorkServlet");
    		// TODO 成功
    	} catch(SQLException e) {
    		e.printStackTrace();
    		// TODO 失败
    	}
    }
}
