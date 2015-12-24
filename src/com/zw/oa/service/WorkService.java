package com.zw.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.Page;
import com.zw.oa.domain.Employee;
import com.zw.oa.domain.Work;
import com.zw.oa.web.servlet.vo.WorkVO;

/**
 * 工作安排服务接口
 * 
 *
 */
public interface WorkService {

	/**
	 * 添加工作安排
	 * @param work
	 */
	void add(Work work) throws SQLException;

	/**
	 * 查询所有工作安排为列表
	 * @return
	 */
	List<Work> list(Employee emp) throws SQLException;

	/**
	 * 删除工作安排
	 * @param id
	 * @param current
	 */
	void delete(Integer id, Employee current) throws SQLException;

	void update(Work work) throws SQLException ;

	Work get(int id) throws SQLException ;

	Page<Work> lists(WorkVO wv, int pageIndex, int pageRows) throws SQLException ;

	void addred(Integer readerid, Employee current) throws SQLException;

	void addagency(Integer agencyid, Employee current) throws SQLException;

}
