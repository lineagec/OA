package com.zw.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.EmployeeDao;
import com.zw.oa.domain.Department;
import com.zw.oa.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	/**
	 * 结果集到员工信息转换对象
	 */
	private Transformer transformer = new Transformer() {
		public Object transform(ResultSet res) throws SQLException {
			
			Employee emp = new Employee();
			
			Department depart = null;
			if(res.getInt("d_id") > 0) {
				depart = new Department();
				
				depart.setId(res.getInt("d_id"));
				depart.setCode(res.getString("d_code"));
				depart.setName(res.getString("d_name"));
				depart.setRemark(res.getString("d_remark"));
			}
			
			emp.setId(res.getInt("e_id"));
			emp.setCode(res.getString("e_code"));
			emp.setPassword(res.getString("e_password"));
			emp.setName(res.getString("e_name"));
			emp.setGender(res.getString("e_gender"));
			emp.setBirthday(res.getDate("e_birthday"));
			emp.setJob(res.getString("e_job"));
			emp.setIntroduce(res.getString("e_introduce"));
			emp.setHobby(res.getString("e_hobby"));
			emp.setMobilePhone(res.getString("e_mobile_phone"));
			emp.setPhone(res.getString("e_phone"));
			emp.setEmail(res.getString("e_email"));
			emp.setQq(res.getString("e_qq"));
			emp.setWechat(res.getString("e_wechat"));
			emp.setRole(res.getInt("e_role"));
			
			emp.setDepart(depart);
			
			return emp;
		}
	};
	
	/**
	 * 根据账号查询单条数据
	 * @param username
	 * @return
	 */
	public Employee getEmployeeByCode(String code) throws SQLException {
		
		StringBuilder builder = getSQL();
		builder.append(" and e.code = ?  ");
		
		return (Employee) DataBaseUtils.querySingle(
				builder.toString(), 
				new Object[] {code}, 
				transformer);
	}

	/**
	 * 查询数据
	 * @return
	 * @throws SQLException 
	 */
	public List<Employee> list() throws SQLException {
		
		String sql = getSQL().toString();
		
		return DataBaseUtils.queryList(sql, null, transformer);
	}
	
	private StringBuilder getSQL() {
		StringBuilder builder = new StringBuilder();
		builder.append(" select                                         ");
		builder.append(" 	e.id e_id,                                    ");
		builder.append(" 	e.code e_code,                                ");
		builder.append(" 	e.password e_password,                        ");
		builder.append(" 	e.name e_name,                                ");
		builder.append(" 	e.gender e_gender,                            ");
		builder.append(" 	e.birthday e_birthday,                        ");
		builder.append(" 	e.depart_id e_depart_id,                      ");
		builder.append(" 	e.job e_job,                                  ");
		builder.append(" 	e.introduce e_introduce,                      ");
		builder.append(" 	e.hobby e_hobby,                              ");
		builder.append(" 	e.mobile_phone e_mobile_phone,                ");
		builder.append(" 	e.phone e_phone,                              ");
		builder.append(" 	e.email e_email,                              ");
		builder.append(" 	e.qq e_qq,                                    ");
		builder.append(" 	e.wechat e_wechat,                            ");
		builder.append(" 	e.role e_role,                                ");
		builder.append(" 	d.id d_id,                                    ");
		builder.append(" 	d.code d_code,                                ");
		builder.append(" 	d.name d_name,                                ");
		builder.append(" 	d.remark d_remark                             ");
		builder.append(" from                                             ");
		builder.append(" 	t_employee e                                  ");
		builder.append(" left join t_department d on e.depart_id = d.id ");
		builder.append(" where                                          ");
		builder.append(" 	1=1                             ");
		
		return builder;
	}

	@Override
	public void update(Employee emp) throws SQLException {
		StringBuilder builder = new StringBuilder();
		builder.append(" update            ");
		builder.append(" 	t_employee       ");
		builder.append(" set               ");
		builder.append(" 	code         = ?,");
		builder.append(" 	name         = ?,");
		builder.append(" 	gender       = ?,");
		builder.append(" 	birthday     = ?,");
		builder.append(" 	depart_id      = ?,");
		builder.append(" 	job          = ?,");
		builder.append(" 	introduce    = ?,");
		builder.append(" 	hobby        = ?,");	
		builder.append(" 	mobile_phone = ?,");
		builder.append(" 	phone        = ?,");
		builder.append(" 	email        = ?,");
		builder.append(" 	qq           = ?,");
		builder.append(" 	wechat       = ?");
		builder.append(" where             ");
		builder.append(" 	id = ?           ");

		Object[] params = {
				emp.getCode(),
				emp.getName(),
				emp.getGender(),
				emp.getBirthday(),
				emp.getDepart().getId(),
				emp.getJob(),
				emp.getIntroduce(),
				emp.getHobby(),
				emp.getMobilePhone(),
				emp.getPhone(),
				emp.getEmail(),
				emp.getQq(),
				emp.getWechat(),
				emp.getId()
		};
		
		DataBaseUtils.executeUpdate(builder.toString(), params);
	}

	@Override
	public void add(Employee emp) throws SQLException {
		    String sql="insert into t_employee(code, password, name,gender,birthday,depart_id,job,introduce,hobby,mobile_phone,phone,email,qq,wechat,role) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    Object[] params={
	    		emp.getCode(),
	    		emp.getName(),
	    		emp.getPassword(),
	    		emp.getGender(),
	    		emp.getBirthday(),
	    		emp.getDepart().getId(),
	    		emp.getJob(),
	    		emp.getIntroduce(),
	    		emp.getHobby(),
	    		emp.getMobilePhone(),
	    		emp.getPhone(),
	    		emp.getEmail(),
	    		emp.getQq(),
	    		emp.getWechat(),
				emp.getRole(),
	    };
	    
	    DataBaseUtils.executeUpdate(sql, params);
	}

	@Override
	public void updatePassword(String newpassword) throws SQLException {
		DataBaseUtils.executeUpdate("update t_employee set password = ?", new Object[]{newpassword});
	}

	@Override
	public void delete(Integer id) throws SQLException {
		DataBaseUtils.executeUpdate("delete from t_employee where id = ?", new Object[]{id});
	}
		
	}


