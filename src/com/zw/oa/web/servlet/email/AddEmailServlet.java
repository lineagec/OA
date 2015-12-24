package com.zw.oa.web.servlet.email;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.common.Utils;
import com.zw.oa.domain.Email;
import com.zw.oa.domain.Employee;
import com.zw.oa.service.EmailService;
import com.zw.oa.service.impl.EmailServiceImpl;

public class AddEmailServlet extends HttpServlet{
	/**
	 * 工作安排服务对象
	 */
	private static final long serialVersionUID = 1L;
	private EmailService emailService = new EmailServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	/*
    	 * 接受参数
    	 */
    	String title=request.getParameter("title");
    	String content=request.getParameter("content");
    	String receiverStr=request.getParameter("receiver");
    	Integer receiverid=NumberUtils.parseInt(receiverStr);
    	Employee receiver = new Employee(receiverid);
    	Date sendTime=new Date();
    	Integer state=1;
    	
    	Email email=new Email(null, title, content, Utils.current(request), sendTime, null, receiver, state);
    	
    	try {
			emailService.add(email);
			request.setAttribute("msg", "发送成功");
			request.getRequestDispatcher("/pages/email/email.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
