package com.zw.oa.web.servlet.meeting;

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
import com.zw.oa.domain.Meeting;
import com.zw.oa.domain.MeetingRoom;
import com.zw.oa.service.MeetingService;
import com.zw.oa.service.impl.MeetingServiceImpl;

/**
 * Servlet implementation class AddMeetingServlet
 */
public class AddMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MeetingService meetingService = new  MeetingServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String roomNameStr = request.getParameter("roomName");
		int roomName = NumberUtils.parseInt(roomNameStr);
		MeetingRoom meetingRoom = new MeetingRoom(roomName);
		Date createTime = new Date();
		String startTimeStr = request.getParameter("startTime");
    	Date startTime = DateUtils.parse(startTimeStr,"MM-dd-yyyy");
    	String endtTimeStr = request.getParameter("endTime");
    	Date endTime = DateUtils.parse(endtTimeStr,"MM-dd-yyyy");
    	
    	Meeting meeting = new Meeting(null, title, content, meetingRoom, createTime, Utils.current(request), startTime, endTime, null);
    	try {
			meetingService.add(meeting);
			request.setAttribute("msg", "预约会议成功");
			request.getRequestDispatcher("/pages/meeting/addmeeting.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		
	}

}
