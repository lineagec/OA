package com.zw.oa.web.servlet.meeting;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.service.MeetingService;
import com.zw.oa.service.impl.MeetingServiceImpl;

/**
 * Servlet implementation class DeleteMeetingServlet
 */
public class DeleteMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MeetingService meetingService = new MeetingServiceImpl();  
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String idStr = request.getParameter("id");
    	int id = NumberUtils.parseInt(idStr);
    	String roomIdStr = request.getParameter("roomId");
    	int roomId = NumberUtils.parseInt(roomIdStr);
    	try {
			meetingService.delete(id,roomId);
			request.setAttribute("msg", "已经取消预约");
			request.getRequestDispatcher("/servlet/MeetingServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
