package com.zw.oa.domain;

import java.util.Date;

import com.zw.oa.common.DateUtils;

/**
 * 员工信息
 * 
 * @version 0.1.1 2015年4月8日 下午20:48:19
 */
public class Employee {
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 员工编号
	 */
	private String code;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 所属部门
	 */
	private Department depart;
	/**
	 * 职位
	 */
	private String job;
	/**
	 * 自我介绍
	 */
	private String introduce;
	/**
	 * 爱好
	 */
	private String hobby;
	/**
	 * 手机
	 */
	private String mobilePhone;
	/**
	 * 固定电话
	 */
	private String phone;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * QQ号
	 */
	private String qq;
	/**
	 * 微信
	 */
	private String wechat;
	/**
	 * 角色
	 */
	private Integer role;

	public Employee() {
		super();
	}

	public Employee(Integer id) {
		super();
		this.id = id;
	}

	public Employee(Integer id, String code, String password, String name,
			String gender, Date birthday, Department depart, String job,
			String introduce, String hobby, String mobilePhone, String phone,
			String email, String qq, String wechat, Integer role) {
		super();
		this.id = id;
		this.code = code;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.depart = depart;
		this.job = job;
		this.introduce = introduce;
		this.hobby = hobby;
		this.mobilePhone = mobilePhone;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.wechat = wechat;
		this.role = role;
	}

	public Employee(String code, String password, String name, String gender,
			Date birthday, Department depart, String job, String introduce,
			String hobby, String mobilePhone, String phone, String email,
			String qq, String wechat, Integer role) {
		super();
		this.code = code;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.depart = depart;
		this.job = job;
		this.introduce = introduce;
		this.hobby = hobby;
		this.mobilePhone = mobilePhone;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.wechat = wechat;
		this.role = role;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	public String getCode() {
		return code;
	}

	public Department getDepart() {
		return depart;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getHobby() {
		return hobby;
	}

	public Integer getId() {
		return id;
	}

	public String getIntroduce() {
		return introduce;
	}

	public String getJob() {
		return job;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getQq() {
		return qq;
	}

	public Integer getRole() {
		return role;
	}

	public String getWechat() {
		return wechat;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getFormatBirthday() {
		return DateUtils.format(birthday, "yyyy-MM-dd");
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", code=" + code + ", password="
				+ password + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", depart=" + depart + ", job="
				+ job + ", introduce=" + introduce + ", hobby=" + hobby
				+ ", mobilePhone=" + mobilePhone + ", phone=" + phone
				+ ", email=" + email + ", qq=" + qq + ", wechat=" + wechat
				+ ", role=" + role + "]";
	}

}
