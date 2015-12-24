package com.zw.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.MeetingRoomDao;
import com.zw.oa.domain.MeetingRoom;

public class MeetingRoomDaoImpl extends BaseDaoImpl<MeetingRoom> implements
		MeetingRoomDao {

	@Override
	public void add(MeetingRoom meetingRoom) throws SQLException {

		DataBaseUtils.executeUpdate("insert into t_meeting_room(name,address,equi,capacity,valid) values(?,?,?,?,?)", 
				new Object[]{
				meetingRoom.getName(),
				meetingRoom.getAddress(),
				meetingRoom.getEqui(),
				meetingRoom.getCapacity(),
				meetingRoom.getValid()
		});
	}

	@Override
	public void update(MeetingRoom meetingRoom) throws SQLException {
 
		DataBaseUtils.executeUpdate("update t_meeting_room set name=?,address=?,equi=?,capacity=? where id =?", new Object[]{
			meetingRoom.getName(),
			meetingRoom.getAddress(),
			meetingRoom.getEqui(),
			meetingRoom.getCapacity(),
			meetingRoom.getId()
	});
	}

	@Override
	public void delete(Integer id) throws SQLException {
		DataBaseUtils.executeUpdate("delete from t_meeting_room where id = ?", new Object[] {
        		 id
         });
	}

	@Override
	public List<MeetingRoom> list(String sql, Object[] params,
			Transformer transformer) throws SQLException {
		return DataBaseUtils.queryList(sql, params, transformer);
	}

	@Override
	public List<MeetingRoom> list(String sql, Object[] params, int pageIndex,
			int pageRows, Transformer transformer) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeetingRoom get(String sql, Object[] params, Transformer transformer)
			throws SQLException {
		return (MeetingRoom) DataBaseUtils.querySingle(sql, params, transformer);
	}

	@Override
	public long getCount(String sql, Object[] params) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
