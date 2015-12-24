<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div id="sidebar" class="nav-collapse collapse">
		<ul class="nav">
			<li class="active"><a href="pages/index.jsp"><i class="icon-home"></i> 主页</a></li>
			<li class="has-sub">
				<a href="#"><i class="icon-briefcase"></i>个人办公 <span class="label">2</span></a>
				<ul class="dropdown-menu">
					<li><a href="pages/employee/info.jsp">个人信息</a></li>
					<li><a href="pages/employee/password.jsp">修改密码</a></li>
				</ul>
			</li>
		
			<li class="has-sub">
				<a href="#"><i class="icon-file-text"></i> 工作安排 <span class="label">5</span></a>
				<ul class="dropdown-menu">
					<li><a href="pages/work/reader.jsp">读者设置</a></li>
					<li><a href="pages/work/agency.jsp">代办设置</a></li>
					<li><a href="servlet/ListWorkServlet">日程安排</a></li>
					<li><a href="servlet/QueryWorkServlet">综合查询</a></li>
					<li><a href="pages/work/calendar.jsp">日历</a></li>
				</ul>
			</li>
			<li class="has-sub">
				<a href=""><i class="icon-table"></i> 文件夹 <span class="label"></span></a>
				<ul class="dropdown-menu">
					<li><a href="pages/file/manage.jsp">文件夹分类</a></li>
				</ul>
			</li>
			
			<li class="has-sub">
				<a href="#"><i class="icon-file"></i> 在线信息 <span class="label">4</span></a>
				<ul class="dropdown-menu">
					<li><a href="pages/email/email.jsp">新建留言</a></li>
					<li><a href="servlet/InBoxServlet">收件箱</a></li>
					<li><a href="servlet/OutBoxServlet">发件箱</a></li>
					<li><a href="servlet/GomibakoServlet">垃圾箱</a></li>
				</ul>
			</li>
			 <c:if test="${current.role == 2 || current.role ==3}">
			<li class="has-sub">
				<a href="#"><i class="icon-file-text-alt"></i> 会议管理 <span class="label">4</span></a>
				<ul class="dropdown-menu">
					<li><a href="servlet/MeetingServlet">会议管理</a></li>
					<li><a href="pages/meeting/addmeetingroom.jsp">新添会议室</a></li>
					<li><a href="servlet/MeetingRoomServlet">会议室管理</a></li>
					<li><a href="pages/meeting/addmeeting.jsp">预约会议室</a></li>
				</ul>
			</li>
			  </c:if>
			  
			   <c:if test="${current.role == 3 }">
			  	<li class="has-sub">
				<a href="#"><i class="icon-file"></i> 系统管理<span class="label">3</span></a>
				<ul class="dropdown-menu">
					<li><a href="pages/administrator/add.jsp">添加员工</a></li>
					<li><a href="pages/employee/password.jsp">修改密码</a></li>
					<li><a href="pages/administrator/delete.jsp">删除员工</a></li>
				</ul>
			</li>
			   </c:if>
			<li><a href="login.jsp"><i class="icon-user"></i> 登陆</a></li>
		</ul>
	</div>