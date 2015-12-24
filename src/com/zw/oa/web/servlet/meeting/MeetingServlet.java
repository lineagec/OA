package com.zw.oa.web.servlet.meeting;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.domain.Meeting;
import com.zw.oa.service.MeetingService;
import com.zw.oa.service.impl.MeetingServiceImpl;

/**
 * Servlet implementation class MeetingServlet
 */
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MeetingService meetingServce = new MeetingServiceImpl();   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	try {
			List<Meeting> meetinglist = meetingServce.list();
			request.setAttribute("meetinglist", meetinglist);
			
			request.getRequestDispatcher("/pages/meeting/meeting.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
