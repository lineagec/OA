package com.zw.oa.dao;

import java.sql.SQLException;
import java.util.List;

public interface CommonDao {
	
	public List<Object[]> listOptions(String sql, Object[] params) throws SQLException ;
}
