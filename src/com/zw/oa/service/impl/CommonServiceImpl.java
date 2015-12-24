package com.zw.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.dao.CommonDao;
import com.zw.oa.dao.impl.CommonDaoImpl;
import com.zw.oa.service.CommonService;


public class CommonServiceImpl implements CommonService {

	private CommonDao commonDao = new CommonDaoImpl();
	
	public List<Object[]> listOptions(String sql, Object[] params) throws SQLException {
		return commonDao.listOptions(sql, params);
	}

}
