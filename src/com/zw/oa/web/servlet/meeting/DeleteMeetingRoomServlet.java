package com.zw.oa.web.servlet.meeting;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.service.MeetingRoomService;
import com.zw.oa.service.impl.MeetingRoomServiceImpl;

/**
 * Servlet implementation class DeleteMeetingRoomServlet
 */
public class DeleteMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();   
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	   
	   String IdStr = request.getParameter("id");
	   int id = NumberUtils.parseInt(IdStr);
	   
	   try {
		meetingRoomService.delete(id);
		request.setAttribute("msg", "删除成功");
		request.getRequestDispatcher("/servlet/MeetingRoomServlet").forward(request, response);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
