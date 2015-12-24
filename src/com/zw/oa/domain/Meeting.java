package com.zw.oa.domain;

import java.util.Date;

import com.zw.oa.common.DateUtils;


public class Meeting {
	private Integer id;
	private String title;
	private String content;
	private MeetingRoom room;
	private Date createTime;
	private Employee creator;
	private Date startTime;
	private Date endTime;
	private String record;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MeetingRoom getRoom() {
		return room;
	}
	public void setRoom(MeetingRoom room) {
		this.room = room;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Employee getCreator() {
		return creator;
	}
	public void setCreator(Employee creator) {
		this.creator = creator;
	}
	public String getFormatStartTime() {
		return DateUtils.format(startTime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getFormatEndTime() {
		return DateUtils.format(endTime, "yyyy-MM-dd HH:mm:ss");
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public Meeting(Integer id, String title, String content, MeetingRoom room,
			Date createTime, Employee creator, Date startTime, Date endTime,
			String record) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.room = room;
		this.createTime = createTime;
		this.creator = creator;
		this.startTime = startTime;
		this.endTime = endTime;
		this.record = record;
	}
	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}
}
