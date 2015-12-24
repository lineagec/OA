package com.zw.oa.dao;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.Transformer;

public interface BaseDao<T> {

	public void add(T obj) throws SQLException;
	public void update(T obj) throws SQLException;
	public void delete(Integer id) throws SQLException;
	public List<T> list(String sql, Object[] params, int pageIndex, int pageRows, Transformer transformer) throws SQLException;
	public List<T> list(String sql, Object[] params, Transformer transformer) throws SQLException;
	public T get(String sql, Object[] params, Transformer transformer) throws SQLException;
	public long getCount(String sql, Object[] params) throws SQLException;
}
