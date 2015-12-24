package com.zw.oa.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.MeetingDao;
import com.zw.oa.dao.impl.MeetingDaoImpl;
import com.zw.oa.domain.Employee;
import com.zw.oa.domain.Meeting;
import com.zw.oa.domain.MeetingRoom;
import com.zw.oa.domain.Work;
import com.zw.oa.service.MeetingService;


public class MeetingServiceImpl implements MeetingService {
    
	Transformer transformer = new Transformer() {
		
		@Override
		public Object transform(ResultSet res) throws SQLException {
			Meeting meeting = new Meeting();
			meeting.setId(res.getInt("m.id"));
			meeting.setTitle(res.getString("m.title"));
			meeting.setContent(res.getString("m.content"));
			
			MeetingRoom meetingRoon = new MeetingRoom();
			meetingRoon.setId(res.getInt("m.room_id"));
			meetingRoon.setName(res.getString("r.name"));
			
			meeting.setRoom(meetingRoon);
			meeting.setCreateTime(res.getDate("m.create_time"));
			meeting.setStartTime(res.getDate("m.start_time"));
			meeting.setEndTime(res.getDate("m.end_time"));
			
			Employee creator = new Employee();
			creator.setId(res.getInt("m.creator"));
			creator.setName(res.getString("e.name"));
			meeting.setCreator(creator);
			
			
			return meeting;
		}
	};
	
	
	private StringBuilder getSql() {
		StringBuilder builder = new StringBuilder();
		builder.append(" select                                           ");
		builder.append(" 	o.id         ,                                ");
		builder.append(" 	o.title      ,                                ");
		builder.append(" 	o.room_id    ,                                ");
		builder.append(" 	o.content     ,                               ");
		builder.append(" 	o.creator_id ,                                ");
		builder.append(" 	o.create_time,                                ");
		builder.append(" 	o.start_time ,                                ");
		builder.append(" 	o.end_time   ,                                ");
		builder.append(" 	o.state      ,                                ");
		builder.append("   e.name e_name                                  ");
		builder.append(" from                                             ");
		builder.append(" 	t_meeting o                                   ");
		builder.append(" 	inner join t_employee c on o.creator_id = c.id");
		builder.append(" 	inner join t_employee e on o.emp_id = e.id    ");
		builder.append(" where                                          ");
		builder.append(" 	1=1                                           ");
		
		return builder;
	}
	
	MeetingDao meetingDao = new MeetingDaoImpl();
	@Override
	public void add(Meeting meeting) throws SQLException {
		meetingDao.add(meeting);
	}
	@Override
	public List<Meeting> list() throws SQLException {
		String sql = "SELECT m.*,e.name,r.name FROM t_meeting m INNER JOIN t_employee e ON e.id = m.creator inner join t_meeting_room r on r.id = m.room_id";
		
		return meetingDao.list(sql, null, transformer);
	}
	@Override
	public void delete(int id, int roomId) throws SQLException {
		meetingDao.delete(id,roomId);
	}
	@Override
	public Meeting get(int id) throws SQLException {
		StringBuilder builder = getSql();
		builder.append(" and m.id = ?");
		return (Meeting) DataBaseUtils.querySingle(builder.toString(), new Object[] {id}, transformer);
	}

}
