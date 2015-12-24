package com.zw.oa.web.servlet.meeting;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.domain.MeetingRoom;
import com.zw.oa.service.MeetingRoomService;
import com.zw.oa.service.impl.MeetingRoomServiceImpl;

/**
 * Servlet implementation class AddMeetingRoomServlet
 */
public class AddMeetingRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MeetingRoomService meetingRoomService = new MeetingRoomServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String equi = request.getParameter("equi");
		String capacityStr = request.getParameter("capacity");
		int capacity = NumberUtils.parseInt(capacityStr);
		int valid = 1;
		
		MeetingRoom meetingRoom = new MeetingRoom(null, name, address, equi, capacity, valid);
		
		try {
			meetingRoomService.add(meetingRoom);
			request.setAttribute("msg", "添加成功");
			request.getRequestDispatcher("/servlet/MeetingRoomServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
