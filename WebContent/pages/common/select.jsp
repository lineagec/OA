<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.zw.oa.service.CommonService" %>
<%@ page import="com.zw.oa.service.impl.CommonServiceImpl" %>

<%! CommonService commonService = new CommonServiceImpl(); %>
<%
	// 接收查询sql
	String sql = request.getParameter("sql");
	String[] params = request.getParameterValues("param");
	// 调用service来完成查询
	List<Object[]> options = commonService.listOptions(sql, params);
	
	// 放到作用域中
	pageContext.setAttribute("options", options);
%>
<select name="${param.name }" class="select"  style="${param.style}">
<option value="">---请选择---</option>
	<c:choose>
		<c:when test="${!empty options }">
			<c:forEach items="${options }" var="opt">
				<option ${param.value eq opt[0] ? "selected" : "" } value="${opt[0] }">${opt[1] }</option>
			</c:forEach>
		</c:when>
	</c:choose>
</select>
