package com.zw.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.StringUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.WorkDao;
import com.zw.oa.domain.Employee;
import com.zw.oa.domain.Work;
import com.zw.oa.web.servlet.vo.WorkVO;

public class WorkDaoImpl extends BaseDaoImpl<Work> implements WorkDao {

	/**
	 * 结果集转换对象
	 */

	
	public void add(Work work) throws SQLException {
		String sql = "insert into t_work( title ,content ,emp_id ,creator_id ,create_time ,start_time ,end_time ,finish_time ,state) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {
				work.getTitle(),
				work.getContent(),
				work.getEmp().getId(),
				work.getCreator().getId(),
				work.getCreateTime(),
				work.getStartTime(),
				work.getEndTime(),
				work.getFinishTime(),
				work.getState()
		};
		
		DataBaseUtils.executeUpdate(sql, params);
	}


	public void delete(Integer id, Employee current) throws SQLException {
		String sql  = "delete from t_work where id = ? and emp_id = ?";
		Object[] params = new Object[] {
				id,current.getId()
		};
		
		DataBaseUtils.executeUpdate(sql, params);
	}

	@Override
	public void update(Work work) throws SQLException {
		String sql = "update t_work set title=?, content=?, emp_id=?, start_time=?, end_time=? where id=?";
		Object[] params = {
				work.getTitle(),
				work.getContent(),
				work.getEmp().getId(),
				work.getStartTime(),
				work.getEndTime(),
				work.getId()
		};
		
		DataBaseUtils.executeUpdate(sql, params);
	}


	@Override
	public void delete(Integer id) throws SQLException {
		throw new RuntimeException("不能使用该方法删除,必须使用delete(Integer id, Employee current)");
	}


	@Override
	public void addred(Integer readerid, Employee current) throws SQLException {
		 DataBaseUtils.executeUpdate("insert into t_reader(emp_id,reader_id) values (?,?)", new Object[]{
				 readerid,
				 current.getId()}
				 );
	}


	@Override
	public void addagency(Integer agencyid, Employee current)
			throws SQLException {
		 DataBaseUtils.executeUpdate("insert into t_writer(emp_id,writer_id) values (?,?)", new Object[]{
				 agencyid,
				 current.getId()}
				 );
		
	}

}
