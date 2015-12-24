package com.zw.oa.web.servlet.meeting;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.domain.Meeting;
import com.zw.oa.service.MeetingService;
import com.zw.oa.service.impl.MeetingServiceImpl;

public class ToUpdateMeetingServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MeetingService meetingService = new  MeetingServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	int id = NumberUtils.parseInt(request.getParameter("id"));
    	
    	Meeting meeting;
		try {
			meeting = meetingService.get(id);
			request.setAttribute("meeting", meeting);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	request.getRequestDispatcher("/pages/meeting/updatemeeting.jsp").forward(request, response);
    	
    }
}
