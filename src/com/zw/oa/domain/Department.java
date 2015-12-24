package com.zw.oa.domain;


/**
 * 部门信息
 * 
 * @version 0.1.1 2015年4月8日 下午20:39:58
 */
public class Department {

	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 部门编码
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String remark;

	public Department() {
		super();
	}

	public Department(Integer id, String code, String name, String remark) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.remark = remark;
	}

	public Department(String code, String name, String remark) {
		super();
		this.code = code;
		this.name = name;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRemark() {
		return remark;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
