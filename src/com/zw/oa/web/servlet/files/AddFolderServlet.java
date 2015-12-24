package com.zw.oa.web.servlet.files;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.common.Utils;
import com.zw.oa.domain.Folder;
import com.zw.oa.service.FileService;
import com.zw.oa.service.impl.FileServiceImpl;

public class AddFolderServlet extends HttpServlet {

	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int parentId = NumberUtils.parseInt(request.getParameter("parentId"));
		
		Folder parent = null;
		if(parentId > 0) {
			parent = new Folder();
			parent.setId(parentId);
		}
		
		Folder folder = new Folder();
		folder.setName(name);;
		folder.setCreator(Utils.current(request));
		folder.setCreateTime(new Date());
		folder.setParent(parent);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			fileService.addFolder(folder);
			response.getWriter().write("{\"state\": true, \"id\": " + folder.getId() + ", createTime: \"" + folder.getCreateTime() + "\"}");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("{\"state\": false}");
		}
	}
	
}
