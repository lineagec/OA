package com.zw.oa.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.Page;
import com.zw.oa.common.StringUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.WorkDao;
import com.zw.oa.dao.impl.WorkDaoImpl;
import com.zw.oa.domain.Employee;
import com.zw.oa.domain.Work;
import com.zw.oa.service.WorkService;
import com.zw.oa.web.servlet.vo.WorkVO;

/**
 * 工作安排服务实现类
 * 
 *
 */
public class WorkServiceImpl implements WorkService {

	private WorkDao workDao = new WorkDaoImpl();
	
	private Transformer transformer = new Transformer() {
		public Object transform(ResultSet res) throws SQLException {
			Work work = new Work();
			work.setId(res.getInt("id"));
			work.setTitle(res.getString("title"));
			work.setContent(res.getString("content"));
			work.setCreateTime(res.getTimestamp("create_time"));
			work.setStartTime(res.getTimestamp("start_time"));
			work.setEndTime(res.getTimestamp("end_time"));
			work.setFinishTime(res.getTimestamp("finish_time"));
			work.setState(res.getInt("state"));
			
			Employee creator = new Employee();
			creator.setId(res.getInt("creator_id"));
			creator.setName(res.getString("c_name"));
			
			Employee emp = new Employee();
			emp.setId(res.getInt("emp_id"));
			emp.setName(res.getString("e_name"));
			
			work.setCreator(creator);
			work.setEmp(emp);
			
			return work;
		}
	};
	
	private StringBuilder getSql() {
		StringBuilder builder = new StringBuilder();
		builder.append(" select                                         ");
		builder.append(" 	w.id         ,                                ");
		builder.append(" 	w.title      ,                                ");
		builder.append(" 	w.content    ,                                ");
		builder.append(" 	w.emp_id     ,                                ");
		builder.append(" 	w.creator_id ,                                ");
		builder.append(" 	w.create_time,                                ");
		builder.append(" 	w.start_time ,                                ");
		builder.append(" 	w.end_time   ,                                ");
		builder.append(" 	w.finish_time,                                ");
		builder.append(" 	w.state      ,                                ");
		builder.append("   c.name c_name,                               ");
		builder.append("   e.name e_name                                ");
		builder.append(" from                                           ");
		builder.append(" 	t_work w                                      ");
		builder.append(" 	inner join t_employee c on w.creator_id = c.id");
		builder.append(" 	inner join t_employee e on w.emp_id = e.id    ");
		builder.append(" where                                          ");
		builder.append(" 	1=1                                           ");
		
		return builder;
	}
	
	/**
	 * 添加工作安排
	 * @param work
	 */
	public void add(Work work) throws SQLException {
		workDao.add(work);
	}

	public void delete(Integer id, Employee current) throws SQLException {
		workDao.delete(id, current);
	}
	
	@Override
	public void update(Work work) throws SQLException {
		workDao.update(work);
	}
	
	
	public List<Work> list(Employee emp) throws SQLException {
		StringBuilder sql = getSql();
		sql.append(" and w.emp_id = ?");
		return DataBaseUtils.queryList(sql.toString(), new Object[] {emp.getId()}, transformer);
	}



	@Override
	public Work get(int id) throws SQLException {
		StringBuilder builder = getSql();
		builder.append(" and w.id = ?");
		
		return (Work) DataBaseUtils.querySingle(builder.toString(), new Object[] {id}, transformer);
	}

	@Override
	public Page<Work> lists(WorkVO wv, int pageIndex, int pageRows) throws SQLException {
		StringBuilder sql = getSql();
		List<Object> params = new ArrayList<Object>();
		if(wv != null) {
			// 证明选择了完成人
			if(wv.getFinisherId() != 0) {
				sql.append(" and w.emp_id = ? ");
				params.add(wv.getFinisherId());
			}
			// 条件上加了安排人
			if(wv.getCreatorId() != 0) {
				sql.append(" and w.creator_id = ? ");
				params.add(wv.getCreatorId());
			}
			// 选择了开始时间
			if(wv.getStartTime() != null) {
				sql.append(" and w.end_time >= ?");
				params.add(wv.getStartTime());
			}
			// 选择了开始时间
			if(wv.getEndTime() != null) {
				sql.append(" and w.start_time <= ?");
				params.add(wv.getEndTime());
			}
			// 如果输入了关键字
			if(StringUtils.notEmpty(wv.getKeyWord())) { 
				sql.append(" and (w.title like ? or w.content like ?) ");
				
				// 拼接参数
				StringBuilder keyBuilder = new StringBuilder();
				keyBuilder.append("%");
				keyBuilder.append(wv.getKeyWord());
				keyBuilder.append("%");
				
				String key = keyBuilder.toString();
				
				params.add(key);
				params.add(key);
			}
		}
         Object[] param = params.toArray();
		
		// 查询数据
		List<Work> works = workDao.list(sql.toString(), param, pageIndex, pageRows, transformer);
		// 查询总记录数
		long count = workDao.getCount(sql.toString(), param);
		
		return new Page<Work>(works, count, pageIndex, pageRows);
	}

	public void addred(Integer readerid, Employee current) throws SQLException {
		    workDao.addred(readerid,current);
	}

	public void addagency(Integer agencyid, Employee current)
			throws SQLException {
		  workDao.addagency(agencyid,current);
	}
	

}
