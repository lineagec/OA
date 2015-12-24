package com.zw.oa.web.servlet.email;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.Utils;
import com.zw.oa.domain.Email;
import com.zw.oa.service.EmailService;
import com.zw.oa.service.impl.EmailServiceImpl;


/**
 * Servlet implementation class OutBoxServlet
 */
public class OutBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmailService emailService = new EmailServiceImpl();   
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   
	   try {
		List<Email> outlist = emailService.listOutBox(Utils.current(request));
		
		request.setAttribute("outlist", outlist);
		request.getRequestDispatcher("/pages/email/outbox.jsp").forward(request, response);
	} catch (SQLException e) {
		e.printStackTrace();
		request.setAttribute("msg", "发送失败！");
		request.getRequestDispatcher("/pages/email/outbox.jsp").forward(request, response);
	}
}

}
