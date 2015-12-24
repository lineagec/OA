package com.zw.oa.domain;

import java.util.Date;

public class Work {
	private Integer id;
	private String title;
	private String content;
	private Employee emp;
	private Employee creator;
	private Date createTime;
	private Date startTime;
	private Date endTime;
	private Date finishTime;
	/**
	 * 1:未开始 2:正在进行 3:已经完成
	 */
	private int state;

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

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Employee getCreator() {
		return creator;
	}

	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Work(Integer id, String title, String content, Employee emp,
			Employee creator, Date createTime, Date startTime, Date endTime,
			Date finishTime, int state) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.emp = emp;
		this.creator = creator;
		this.createTime = createTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.finishTime = finishTime;
		this.state = state;
	}
	
	

	public Work(String title, String content, Employee emp, Employee creator,
			Date startTime, Date endTime) {
		super();
		this.title = title;
		this.content = content;
		this.emp = emp;
		this.creator = creator;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createTime = new Date();
		this.state = 1;
	}

	public Work() {
		super();
	}
}
