package com.zw.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.domain.Meeting;

public interface MeetingService {

	void add(Meeting meeting) throws SQLException;

	List<Meeting> list() throws SQLException;

	void delete(int id, int roomId) throws SQLException;

	Meeting get(int id) throws SQLException;

}
