package com.zw.oa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.EmailDao;
import com.zw.oa.domain.Email;
import com.zw.oa.domain.Employee;

public class EmailDaoImpl implements EmailDao {
	private Transformer transformer = new Transformer() {
		public Object transform(ResultSet res) throws SQLException {
			Email email = new Email();
			email.setId(res.getInt("e_id"));
			email.setTitle(res.getString("e_title"));
			email.setContent(res.getString("e_content"));
			
			Employee sender = new Employee();
			sender.setId(res.getInt("e_sender"));
			sender.setName(res.getString("a_name"));
			email.setSender(sender);
			
			Employee receiver = new Employee();
			receiver.setId(res.getInt("r_receiver"));
			receiver.setName(res.getString("b_name"));
			email.setReceiver(receiver);
			
			email.setSendTime(res.getTimestamp("e_sendTime"));
			return email ;
		}
	};
	
	
	public void add(Email email) throws SQLException {
		DataBaseUtils.executeUpdate("insert into t_email(title,content,sender,send_time,state) values(?,?,?,?,?)",
				new Object[]{
				email.getTitle(),
				email.getContent(),
				email.getSender().getId(),
				email.getSendTime(),
				email.getState()
		});
		int emailId = -1;
		Connection conn= DataBaseUtils.getConnection();
		PreparedStatement pst = conn.prepareStatement("select max(id) from t_email");
		ResultSet res = pst.executeQuery();
		if(res.next()){
			emailId=res.getInt(1);
		} 
		conn.close();
		pst.close();
		res.close();
		DataBaseUtils.executeUpdate("insert into t_receive(email_id,receiver) values(?,?)", new Object[]{
				emailId,
				email.getReceiver().getId()
		});
	}


	@Override
	public List<Email> listInBox(Employee current) throws SQLException{
		return  DataBaseUtils.queryList("SELECT e.sender e_sender,r.receiver r_receiver,e.id e_id,e.title e_title,e.content e_content,e.send_time e_sendTime,r.receiver r_receiver,a. NAME a_name,b. NAME b_name FROM t_email e INNER JOIN t_receive r ON e.id = r.email_id INNER JOIN t_employee a ON e.sender = a.id INNER JOIN t_employee b ON r.receiver = b.id WHERE e.state = 1 AND  r.receiver = ?",
				new Object[]{
				current.getId()
		}, transformer);
}


	@Override
	public List<Employee> list(Integer id, Employee current) throws SQLException {
		return  DataBaseUtils.queryList("SELECT e.sender e_sender,r.receiver r_receiver,e.id e_id,e.title e_title,e.content e_content,e.send_time e_sendTime,r.receiver r_receiver,a. NAME a_name,b. NAME b_name FROM t_email e INNER JOIN t_receive r ON e.id = r.email_id INNER JOIN t_employee a ON e.sender = a.id INNER JOIN t_employee b ON r.receiver = b.id WHERE e.state = 1 AND  r.receiver = ? and e.id=?",
				new Object[]{
				current.getId(),
				id
		}, 
				transformer);
	}


	@Override
	public List<Email> listOutBox(Employee current) throws SQLException {
		return DataBaseUtils.queryList("SELECT e.sender e_sender,r.receiver r_receiver,e.id e_id ,e.title e_title,e.content e_content,e.send_time e_sendTime,r.receiver r_receiver, a.name a_name , b.name b_name"
				+ " FROM t_email e INNER JOIN t_receive r ON e.id = r.email_id INNER JOIN t_employee a on e.sender = a.id INNER JOIN t_employee b on r.receiver=b.id "
				+ "WHERE e.state = 1 and e.sender = ?",
				new Object[]{
				current.getId()
		}, transformer);
	}


	@Override
	public List<Email> gbklist(Employee current) throws SQLException {
		return DataBaseUtils.queryList("SELECT e.sender e_sender,r.receiver r_receiver,e.id e_id,e.title e_title,e.content e_content,e.send_time e_sendTime,r.receiver r_receiver,a. NAME a_name,b. NAME b_name FROM t_email e INNER JOIN t_receive r ON e.id = r.email_id INNER JOIN t_employee a ON e.sender = a.id INNER JOIN t_employee b ON r.receiver = b.id WHERE e.state = 2 and  r.receiver = ?", new Object[]{
				current.getId()
		}, transformer);
	}


	@Override
	public void toGbk(Integer id) throws SQLException {
		DataBaseUtils.executeUpdate("update t_email set state = 2 where id = ?", new Object[]{id});
		
	}


	@Override
	public void deleteout(Integer id) throws SQLException {
		DataBaseUtils.executeUpdate("delete from t_email where id = ?", new Object[]{id});
		
	}


	
}
