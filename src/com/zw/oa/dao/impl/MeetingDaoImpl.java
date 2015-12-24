package com.zw.oa.dao.impl;

import java.sql.SQLException;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.dao.MeetingDao;
import com.zw.oa.domain.Meeting;
import com.zw.oa.service.MeetingService;

public class MeetingDaoImpl extends BaseDaoImpl<Meeting> implements
		MeetingDao {

	@Override
	public void add(Meeting meeting) throws SQLException {
		DataBaseUtils.executeUpdate("insert into t_meeting(title,content,room_id,create_time,creator,start_time,end_time) values(?,?,?,?,?,?,?)",
				new Object[] {
				meeting.getTitle(),
				meeting.getContent(),
				meeting.getRoom().getId(),
				meeting.getCreateTime(),
				meeting.getCreator().getId(),
				meeting.getStartTime(),
				meeting.getEndTime()
		});
		DataBaseUtils.executeUpdate("update t_meeting_room set valid = 2 where id = ? ", new Object[]{meeting.getRoom().getId()});
	}

	@Override
	public void update(Meeting obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id, int roomId) throws SQLException {
		DataBaseUtils.executeUpdate("delete from t_meeting where id = ?", new Object[]{id});
		DataBaseUtils.executeUpdate("update t_meeting_room set valid = 1 where id = ?", new Object[]{roomId});
	}

}
