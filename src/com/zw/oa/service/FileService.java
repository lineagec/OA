package com.zw.oa.service;

import java.sql.SQLException;
import java.util.List;

import com.zw.oa.domain.Employee;
import com.zw.oa.domain.File;
import com.zw.oa.domain.Folder;

public interface FileService {

	List<Folder> listFolders(Employee current, int parentId) throws SQLException;

	List<File> listFiles(Employee current, int parentId) throws SQLException;

	void addFolder(Folder folder) throws SQLException;

}
