package com.zw.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.domain.Employee;
import com.zw.oa.domain.Work;
import com.zw.oa.web.servlet.vo.WorkVO;

/**
 * 工作安排数据访问接口
 * @author Direct
 *
 */
public interface WorkDao extends BaseDao<Work>{

	/**
	 * 添加工作安排到数据库
	 * @param work
	 * @throws SQLException
	 */

	/**
	 * 查询工作安排
	 * @return
	 */

	void delete(Integer id, Employee current) throws SQLException;

	void addred(Integer readerid, Employee current) throws SQLException;

	void addagency(Integer agencyid, Employee current) throws SQLException;



}
