package com.zw.oa.dao.impl;

import java.sql.SQLException;

import com.zw.oa.common.DataBaseUtils;
import com.zw.oa.dao.FileDao;
import com.zw.oa.domain.Folder;

public class FileDaoImpl extends BaseDaoImpl implements FileDao {

	public void add(Object obj) throws SQLException {
        Folder folder = (Folder) obj;
		
		String sql = "insert into t_folder(name,is_share,creator,parent,create_time) values(?,?,?,?,?)";
		Object[] params = {
				folder.getName(),
				folder.getIsShare(),
				folder.getCreator().getId(),
				folder.getParent() == null ? null : folder.getParent().getId(),
				folder.getCreateTime()
		};
		
		int id = DataBaseUtils.insert(sql, params);
		folder.setId(id);
	}

	public void update(Object obj) throws SQLException {

	}

	public void delete(Integer id) throws SQLException {

	}

}
