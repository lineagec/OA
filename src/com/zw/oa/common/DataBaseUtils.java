package com.zw.oa.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

public class DataBaseUtils {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException("没找到驱动包", e);
		}
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/t_oa", "root", "123");
	}
	
	
	public static void executeUpdate(String sql, Object[] params) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
		
			conn = DataBaseUtils.getConnection();
			
			
			pst = conn.prepareStatement(sql);
			
			if(params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					
					if(params[i] instanceof Date){
						Date dt = (Date) params[i];
						params[i] = new java.sql.Date(dt.getTime());
					}
					pst.setObject(i+1, params[i]);
				}
			}
			
			pst.executeUpdate();
		} finally {
			if(pst != null) {
				pst.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	
	public static Object querySingle(String sql, Object[] params, Transformer transformer) throws SQLException {
		List list = queryList(sql, params, transformer);
		
		if(list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	
	public static List queryList(String sql, Object[] params, Transformer transformer) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		List list = new ArrayList();
		
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			
			if(params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			
			res = pst.executeQuery();
			
			while(res.next()) {
				
				list.add(transformer.transform(res));
			}
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		return list;
	}
	
public static List queryList(String sql, Object[] params, int pageIndex,int pageRows, Transformer transformer) throws SQLException {
		
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		List list = new ArrayList();
		
		// 在sql上添加分页条件
		sql += " limit ?,? ";
		
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql.toString());
			
			if(params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			
			// 设置分页条件
			int pl = params != null ? params.length : 0;
			pst.setInt(pl + 1, (pageIndex-1) * pageRows);
			pst.setInt(pl + 2, pageRows);
			
			res = pst.executeQuery();
			
			while(res.next()) {
				
				list.add(transformer.transform(res));
			}
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		return list;
	}
	
	public static long getCount(String sql, Object[] params) throws SQLException {
		sql = "select count(1) from (" + sql + ") count_temp";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		List list = new ArrayList();
		
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql.toString());
			
			if(params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			
			res = pst.executeQuery();
			res.next();
			
			return res.getLong(1);
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
	}


	public static int insert(String sql, Object[] params) throws SQLException {
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DataBaseUtils.getConnection();
			// 通过Statement.RETURN_GENERATED_KEYS来表示新增数据之后需要返回自增长的主键
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			if(params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					
					if(params[i] instanceof java.util.Date) {
						params[i] = DateUtils.toTimestamp((Date) params[i]);
					}
					
					pst.setObject(i+1, params[i]);
				}
			}
			pst.executeUpdate();
			// 获取返回的主键结果集
			ResultSet res = pst.getGeneratedKeys();
			if(res.next()) {
				// 返回主键
				return res.getInt(1);
			}
		} finally {
			if(pst != null) {
				pst.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
		return -1;
	}
}
