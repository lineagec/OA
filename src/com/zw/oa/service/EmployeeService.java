package com.zw.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.domain.Employee;
import com.zw.oa.exception.LoginFailException;

/**
 * 员工信息服务接口
 *
 */
public interface EmployeeService {

	/**
	 * 登录功能
	 * <p>
	 * 	 如果登录成功,则会返回当前登录用户的信息,如果失败则会抛出com.zw.exception.LoginFailException异常
	 * </p>
	 * @param username
	 *     登录用户的账号
	 * @param password
	 *     登录的密码
	 * @return
	 *     登录成功的员工的信息
	 * @throws LoginFailException
	 *     登录失败发生的异常
	 */
	public Employee login(String username,String password) throws LoginFailException;

	/**
	 * 查询所有的用户信息
	 * @return
	 */
	public List<Employee> list() throws SQLException;

	public void update(Employee emp) throws SQLException ;

	public void add(Employee emp) throws SQLException;
	
	public void updatePwd(String oldpassword, String newpassword,
			String repassword, String password) throws LoginFailException, SQLException;

	public void delete(Integer id) throws SQLException;
}
