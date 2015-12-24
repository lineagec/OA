package com.zw.oa.web.servlet.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zw.oa.common.NumberUtils;
import com.zw.oa.common.Utils;
import com.zw.oa.domain.Employee;
import com.zw.oa.domain.File;
import com.zw.oa.domain.Folder;
import com.zw.oa.service.FileService;
import com.zw.oa.service.impl.FileServiceImpl;

public class ListFilesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Employee current = Utils.current(request);
		int parentId = NumberUtils.parseInt(request.getParameter("parentId"), -1);
		
		// 查询
		try {
			List<Folder> folders = fileService.listFolders(current,parentId);
			List<File> files = fileService.listFiles(current,parentId);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.append("{");
				out.append("folders:[");
				for(int i=0;i<folders.size();i++) {
					Folder folder = folders.get(i);
					if(i>0) {
						out.append(",");
					}
					out.append("{");
						out.append("\"id\":" + folder.getId() + ",");
						out.append("\"name\":\"" + folder.getName() + "\",");
						out.append("\"createTime\":\"" + folder.getCreateTime()+"\"");
					out.append("}");
				}
				out.append("],");
				out.append("files: [");
				for(int i=0;i<files.size();i++) {
					File file = files.get(i);
					if(i>0) {
						out.append(",");
					}
					out.append("{");
						out.append("\"id\":" + file.getId() + ",");
						out.append("\"name\":\"" + file.getName() + "\",");
						out.append("\"createTime\":\"" + file.getCreateTime()+"\"");
					out.append("}");
				}
				out.append("],");
			out.append("}");

			out.flush();
			// 显示
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
