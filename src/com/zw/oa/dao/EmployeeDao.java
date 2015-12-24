package com.zw.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.domain.Employee;

public interface EmployeeDao {

	/**
	 * 根据账号查询单条数据
	 * @param username
	 * @return
	 */
	public Employee getEmployeeByCode(String code) throws SQLException;

	/**
	 * 查询数据
	 * @return
	 */
	public List<Employee> list() throws SQLException;

	public void update(Employee emp) throws SQLException;

	public void add(Employee emp) throws SQLException;

	public void updatePassword(String newpassword) throws SQLException;

	public void delete(Integer id) throws SQLException;

	
	
}
