<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/pages/common/head.jsp"></jsp:include>
<jsp:include page="/pages/common/menu.jsp"></jsp:include>
<div class="span12">
	<div class="widget">
		<div class="widget-header">
			<h4>我的账户</h4>
		</div>
		<div class="widget-content">
			<ul class="nav nav-tabs">
				<li class=""><a href="#change-password" data-toggle="tab"><i
						class="icon-lock"></i> <span class="hidden-phone">修改密码
							</span></a></li>
			</ul>
			<div class="tab-content">
			
				<div class="tab-pane fade" id="change-password">
					<div class="user-profile">
						 <form action="servlet/PasswordUpdateServlet" method="post">
							<div class="profile-header">
								<i class="icon-lock"></i> 修改密码
							</div>
							<div class="control-group">
								<label class="control-label" >旧密码</label>
								<div class="controls">
									<input type="password" name="oldpassword">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">新密码</label>
								<div class="controls">
									<input type="password" name="newpassword">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">再次输入新密码</label>
								<div class="controls">
									<input type="password" name="repassword">
								</div>
							</div>
							
							<div class="form-actions">
								<button type="submit" class="btn btn-primary">
									<i class="icon-ok-sign"></i> 修改
								</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

</html>

