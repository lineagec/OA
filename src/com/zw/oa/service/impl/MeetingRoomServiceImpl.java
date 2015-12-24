package com.zw.oa.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.Transformer;
import com.zw.oa.dao.MeetingRoomDao;
import com.zw.oa.dao.impl.MeetingRoomDaoImpl;
import com.zw.oa.domain.MeetingRoom;
import com.zw.oa.service.MeetingRoomService;

public class MeetingRoomServiceImpl implements MeetingRoomService {
	MeetingRoomDao meetingRoomDao = new MeetingRoomDaoImpl();
	Transformer transformer = new Transformer() {
		@Override
		public Object transform(ResultSet res) throws SQLException {
			MeetingRoom meetingRoom = new MeetingRoom();
			meetingRoom.setId(res.getInt("id"));
			meetingRoom.setName(res.getString("name"));
			meetingRoom.setAddress(res.getString("address"));
			meetingRoom.setCapacity(res.getInt("capacity"));
			meetingRoom.setEqui(res.getString("equi"));
			meetingRoom.setValid(res.getInt("valid"));
			return meetingRoom;
		}
	};
	public void add(MeetingRoom meetingRoom) throws SQLException {
		meetingRoomDao.add(meetingRoom);
	}
	@Override
	public List<MeetingRoom>  list() throws SQLException {
		String sql = "select * from t_meeting_room";
		return meetingRoomDao.list(sql, null, transformer);
	}
	@Override
	public void delete(int id) throws SQLException {
		meetingRoomDao.delete(id);
	}
	@Override
	public MeetingRoom get(int id) throws SQLException {
		String sql = "select * from t_meeting_room where id = ?";
		return meetingRoomDao.get(sql, new Object[]{id}, transformer);
	}
	@Override
	public void update(MeetingRoom meetingRoom) throws SQLException {
		meetingRoomDao.update(meetingRoom);
	}
	
	

}
