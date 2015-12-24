package com.zw.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.domain.Email;
import com.zw.oa.domain.Employee;

public interface EmailService {

	void add(Email email) throws SQLException;

	List<Email> listInBox(Employee current) throws SQLException;

	List<Employee> list(Integer id, Employee current) throws SQLException;

	List<Email> listOutBox(Employee current)throws SQLException;

	List<Email> gbklist(Employee current) throws SQLException;

	void toGbk(Integer id) throws SQLException;

	void deleteout(Integer id) throws SQLException;

	
        
}
