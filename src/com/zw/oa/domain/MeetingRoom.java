package com.zw.oa.domain;

public class MeetingRoom {
	private Integer id ;
	private String name;
	private String address;
	private String equi;
	private Integer capacity;
	private Integer valid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEqui() {
		return equi;
	}
	public void setEqui(String equi) {
		this.equi = equi;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public MeetingRoom(Integer id, String name, String address, String equi,
			Integer capacity, Integer valid) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.equi = equi;
		this.capacity = capacity;
		this.valid = valid;
	}
	public MeetingRoom(Integer id) {
		super();
		this.id = id;
	}
	public MeetingRoom() {
		// TODO Auto-generated constructor stub
	}
}
