package com.zw.oa.dao;

import java.sql.SQLException;

import com.zw.oa.domain.Meeting;

public interface MeetingDao extends BaseDao<Meeting> {

	void delete(int id, int roomId) throws SQLException;

}
