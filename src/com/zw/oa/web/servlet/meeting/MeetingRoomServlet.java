package com.zw.oa.web.servlet.meeting;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.domain.MeetingRoom;
import com.zw.oa.service.MeetingRoomService;
import com.zw.oa.service.impl.MeetingRoomServiceImpl;

/**
 * Servlet implementation class MeetingRoomServlet
 */
public class MeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();   
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	try {
			List<MeetingRoom> listmeetingroom = meetingRoomService.list();
			request.setAttribute("listmeetingroom", listmeetingroom);
			request.getRequestDispatcher("/pages/meeting/meetingroom.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
