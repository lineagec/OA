package com.zw.oa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.common.Transformer;
import com.zw.oa.dao.CommonDao;



public class CommonDaoImpl implements CommonDao {

	private final Transformer optionTransformer = new Transformer() {
		public Object transform(ResultSet res) throws SQLException {
			return new Object[] {
					res.getObject(1),
					res.getObject(2)
			};
		}
	};
	
	public List<Object[]> listOptions(String sql, Object[] params) throws SQLException {
		return DataBaseUtils.queryList(sql, params, optionTransformer);
	}

}
