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
 * Servlet implementation class InBoxServlet
 */
public class InBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmailService emailService = new EmailServiceImpl();    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	 try {
    			List<Email> inlist = emailService.listInBox(Utils.current(request));
    			request.setAttribute("inlist", inlist);
    			request.getRequestDispatcher("/pages/email/inbox.jsp").forward(request, response);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    }

}
