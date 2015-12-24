package com.zw.oa.web.servlet.email;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.service.EmailService;
import com.zw.oa.service.impl.EmailServiceImpl;


public class DeleteGomibakoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmailService emailService = new EmailServiceImpl();    
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   
	   String idStr = request.getParameter("id");
	   Integer id = NumberUtils.parseInt(idStr);
	   try {
		emailService.deleteout(id);
		// TODO 成功
		request.getRequestDispatcher("/servlet/GomibakoServlet").forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
