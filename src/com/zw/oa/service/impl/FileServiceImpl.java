package com.zw.oa.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zw.oa.common.Transformer;
import com.zw.oa.dao.FileDao;
import com.zw.oa.dao.impl.FileDaoImpl;
import com.zw.oa.domain.Employee;
import com.zw.oa.domain.File;
import com.zw.oa.domain.Folder;
import com.zw.oa.service.FileService;

public class FileServiceImpl implements FileService {

	private FileDao fileDao = new FileDaoImpl();
	
	private Transformer folderTransformer = new Transformer() {
		public Object transform(ResultSet res) throws SQLException {
			Folder folder = new Folder();
			folder.setId(res.getInt("id"));
			folder.setName(res.getString("name"));
			folder.setIsShare(res.getInt("is_share"));
			folder.setCreateTime(res.getTimestamp("create_time"));
			Employee creator = new Employee();
			creator.setId(res.getInt("creator"));
			folder.setCreator(creator);
			
			return folder;
		}
	};
	
	private Transformer fileTransformer = new Transformer() {
		public Object transform(ResultSet res) throws SQLException {
			File file = new File();
			file.setId(res.getInt("id"));
			file.setName(res.getString("name"));
			file.setCreateTime(res.getTimestamp("create_time"));
			Employee creator = new Employee();
			creator.setId(res.getInt("creator"));
			file.setCreator(creator);
			
			return file;
		}
	};
	
	private StringBuilder getFolderSql() {
		return new StringBuilder("select * from t_folder where creator = ? ");
	}
	
	private StringBuilder getFileSql() {
		return new StringBuilder("select * from t_file where creator = ? ");
	}
	
	/**
	 * 查询指定的目录列表
	 * @throws SQLException 
	 */
	public List<Folder> listFolders(Employee current, int parentId) throws SQLException {
		Object[] params = null;
		StringBuilder sql = getFolderSql();
		if(parentId > 0) {
			sql.append(" and parent = ?");
			params = new Object[]{current.getId(), parentId};
		} else {
			sql.append( " and parent is null");
			params = new Object[]{current.getId()};
		}
		
		return fileDao.list(sql.toString(), params, folderTransformer);
	}

	/**
	 * 查询文件列表
	 * @throws SQLException 
	 */
	public List<File> listFiles(Employee current, int parentId) throws SQLException {
		Object[] params = null;
		StringBuilder sql = getFileSql();
		if(parentId > 0) {
			sql.append(" and folder = ?");
			params = new Object[]{current.getId(), parentId};
		} else {
			sql.append( " and folder is null");
			params = new Object[]{current.getId()};
		}
		
		return fileDao.list(sql.toString(), params, fileTransformer);
	}

	@Override
	public void addFolder(Folder folder) throws SQLException {
		fileDao.add(folder);
	}
}
