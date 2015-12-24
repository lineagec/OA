package com.zw.oa.web.servlet.vo;

import java.util.Date;

public class WorkVO {

	private int finisherId;
	private int creatorId;
	private Date startTime;
	private Date endTime;
	private String keyWord;
	public int getFinisherId() {
		return finisherId;
	}
	public void setFinisherId(int finisherId) {
		this.finisherId = finisherId;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public WorkVO(int finisherId, int creatorId, Date startTime, Date endTime,
			String keyWord) {
		super();
		this.finisherId = finisherId;
		this.creatorId = creatorId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.keyWord = keyWord;
	}
	public WorkVO() {
		super();
	}
	
}
