package com.zw.oa.common;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 结果集转换器
 * @author Direct
 *
 */
public interface Transformer {
	public Object transform(ResultSet res) throws SQLException;
}