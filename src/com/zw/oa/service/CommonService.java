package com.zw.oa.service;

import java.sql.SQLException;
import java.util.List;

public interface CommonService {

	public List<Object[]> listOptions(String sql, Object[] params) throws SQLException ;
	
}
