package com.zw.oa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	public List<T> list(String sql, Object[] params, int pageIndex, int pageRows,
			Transformer transformer) throws SQLException {
		return DataBaseUtils.queryList(sql, params, pageIndex, pageRows, transformer);
	}
	
	public List<T> list(String sql, Object[] params, Transformer transformer)
			throws SQLException {
		return DataBaseUtils.queryList(sql, params, transformer);
	}
	
	public T get(String sql, Object[] params, Transformer transformer) throws SQLException {
		return (T) DataBaseUtils.querySingle(sql, params, transformer);
	}
	
	public long getCount(String sql, Object[] params)
			throws SQLException {
		return DataBaseUtils.getCount(sql, params);
	}
}
