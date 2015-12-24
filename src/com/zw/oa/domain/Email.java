package com.zw.oa.domain;

import java.util.Date;

public class Email {
	private Integer id;
	private String title;
	private String content;
	private Employee  sender;
	private Date sendTime;
	private Integer emailId;
	private Employee receiver;
	private Integer state;
	/**
	 * 1:已删除 2:未删除 
	 */
	@Override
	public String toString() {
		return "Email [id=" + id + ", title=" + title + ", content=" + content
				+ ", sender=" + sender + ", senderTime=" + sendTime
				+ ", emailId=" + emailId + ", receiver=" + receiver
				+ ", state=" + state + "]";
	}

	

	public Email(Integer id, String title, String content, Employee sender,
			Date senderTime, Integer emailId, Employee receiver, Integer state) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.sender = sender;
		this.sendTime = sendTime;
		this.emailId = emailId;
		this.receiver = receiver;
		this.state = state;
	}



	public Email() {
		super();
	}
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
	public Employee getSender() {
		return sender;
	}
	public void setSender(Employee sender) {
		this.sender = sender;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Integer getEmailId() {
		return emailId;
	}
	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}
	public Employee getReceiver() {
		return receiver;
	}
	public void setReceiver(Employee receiver) {
		this.receiver = receiver;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
    
}
