package com.zw.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.dao.EmailDao;
import com.zw.oa.dao.impl.EmailDaoImpl;
import com.zw.oa.domain.Email;
import com.zw.oa.domain.Employee;
import com.zw.oa.service.EmailService;

public class EmailServiceImpl implements EmailService {
 
	private EmailDao emailDao=new EmailDaoImpl();
	
	public void add(Email email) throws SQLException{
         emailDao.add(email);		
	}

	@Override
	public List<Email> listInBox(Employee current) throws SQLException {
		return emailDao.listInBox(current);
	}


	@Override
	public List<Employee> list(Integer id, Employee current) throws SQLException {
		return emailDao.list(id,current);
	}

	@Override
	public List<Email> listOutBox(Employee current) throws SQLException{
		return emailDao.listOutBox(current);
	}

	@Override
	public List<Email> gbklist(Employee current) throws SQLException {
		return emailDao.gbklist(current);
	}

	@Override
	public void toGbk(Integer id) throws SQLException {
		emailDao.toGbk(id);		
	}

	@Override
	public void deleteout(Integer id) throws SQLException {
		emailDao.deleteout(id);
		
	}

}
