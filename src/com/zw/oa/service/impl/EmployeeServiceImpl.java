package com.zw.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.dao.EmployeeDao;
import com.zw.oa.dao.impl.EmployeeDaoImpl;
import com.zw.oa.domain.Employee;
import com.zw.oa.exception.LoginFailException;
import com.zw.oa.service.EmployeeService;

/**
 * 员工信息服务实现类
 * @author Direct
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	/***
	 * 员工信息数据库访问对象
	 */
	private EmployeeDao employeeDao = new EmployeeDaoImpl(); 
	
	/**
	 * 登录功能
	 * <p>
	 * 	 如果登录成功,则会返回当前登录用户的信息,如果失败则会抛出com.direct.exception.LoginFailException异常
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
	public Employee login(String username, String password) throws LoginFailException {
		// 查询将要登录的用户的信息
		Employee emp = null;
		try {
			emp = employeeDao.getEmployeeByCode(username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginFailException("数据库连接出错");
		}
		
		// 将查询结果进行比较
		if(emp == null) {
			// 如果账号不正确则返回账号不正确
			throw new LoginFailException("账号不存在");
		}
		if(!emp.getPassword().equals(password)) {
			// 如果密码不正确则返回密码不正确
			throw new LoginFailException("密码错误");
		}
		
		// 如果都正确证明登录成功
		return emp;
	}

	/**
	 * 查询所有的用户信息
	 * @return
	 */
	public List<Employee> list() throws SQLException {
		return employeeDao.list();
	}

	@Override
	public void update(Employee emp) throws SQLException  {
		employeeDao.update(emp);
	}

	@Override
	public void add(Employee emp) throws SQLException {
		employeeDao.add(emp) ;
	}

	@Override
	public void updatePwd(String oldpassword, String newpassword,
			String repassword, String password) throws LoginFailException,
			SQLException {
		if(!oldpassword.equals(password)){
			throw new LoginFailException("原始密码不正确！");
		}
		
		else{
			if(!newpassword.equals(repassword)){
				throw new LoginFailException("两次输入密码不一致！");
			}
			employeeDao.updatePassword(newpassword);
		}		
	}

	@Override
	public void delete(Integer id) throws SQLException {
		employeeDao.delete(id);
	}

}
