package com.zw.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.domain.MeetingRoom;

public interface MeetingRoomService {

	void add(MeetingRoom meetingRoom) throws SQLException;

	List<MeetingRoom>  list() throws SQLException;

	void delete(int id) throws SQLException;

	MeetingRoom get(int id) throws SQLException;

	void update(MeetingRoom meetingRoom) throws SQLException;



}
