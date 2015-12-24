<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath %>">
<jsp:include page="/pages/common/head.jsp"></jsp:include>
<jsp:include page="/pages/common/menu.jsp"></jsp:include>
<div class="container-fluid">
			<h1 class="page-title">读者设置<small>input validation and more</small></h1>
			<div class="row-fluid">
				<div class="span6">
					<div class="widget">
						<div class="widget-header">
							<h4>读者设置</h4>
							<div class="alert alert-success" id="sussessBox" style="display: none;">
									<strong>${msg}</strong> 
								<span class="close" data-dismiss="alert">×</span>
							</div>
						</div>
						<div class="widget-content">
							<form action="servlet/ReadServlet" method="post" id="basic-validate-form" class="form-horizontal" data-validate="parsley">
								<div class="control-group">
									<label class="control-label" for="email">读者:</label>
									<div class="controls">
									 <jsp:include page="/pages/common/select.jsp">
				                 	<jsp:param value="select e.id,e.name from t_employee e where e.id not in (?) " name="sql"/>
				                 	<jsp:param value="${current.id }" name="param"/>
				                 	<jsp:param value="reader" name="name"/>
				                 	<jsp:param value="${current.name }" name="value"/>
				                    </jsp:include> 
									</div> 
								</div>
								<div class="control-group">
									<div class="controls">
										<button type="submit" class="btn btn-primary">设置</button>
										<button type="reset" class="btn btn-primary">取消</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div><!-- end span6 -->
			</div><!-- end row-fluid -->
		</div>
<script type="text/javascript">
    if("${msg}"){
	  var sussessBox = document.getElementById("sussessBox");
			sussessBox.style.display = "block";
  }
    if("${error}"){
  	  var dangerBox = document.getElementById("dangerBox");
  	dangerBox.style.display = "block";
    }
    </script>
</html>

