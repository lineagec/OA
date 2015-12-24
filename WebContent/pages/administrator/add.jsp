<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>

	<base href="<%=basePath %>">
	<title>OA | 自动化办公</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	
	<!-- ================== GLOBAL STYLE START ================== -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
	<link href="resource/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="resource/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="resource/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
	<link href="resource/assets/jquery-ui/jquery-ui-1.10.1.custom.css" rel="stylesheet" />
	<link href="resource/assets/css/style.min.css" rel="stylesheet" />
	<link href="resource/assets/css/style-responsive.min.css" rel="stylesheet" />
	<!-- ================== GLOBAL STYLE END ================== -->
    
    
	<!-- ================== PAGE LEVEL STYLE START ================== -->
	<link rel="stylesheet" href="resource/assets/bootstrap-datepicker/css/datepicker.css" />
	<!-- ================== PAGE LEVEL STYLE END ================== -->
    
    <!-- IE8 HTML5 COMPATIBILITY -->
    <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

	<!-- Body Cover Image & Logo
  	================================================== -->
	<div class="body-cover"></div>
	<div class="logo"><i class="icon-leaf"></i>OA自动化办公</div>
	
	<!-- Top Navigation 
  	================================================== -->
	<div id="top-nav">
		<div class="navbar">
			<div class="navbar-inner">
				<a href="#" class="btn btn-navbar pull-right" data-toggle="collapse" data-target=".nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<ul class="nav pull-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-refresh"></i><span class="label label-info">5</span>
						</a>
						<ul class="dropdown-menu ">
							<li><a href="#"><span class="label label-success"><i class="icon-plus-sign"></i></span> Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
							<li><a href="#"><span class="label label-warning"><i class="icon-exclamation-sign"></i></span> Duis aliquet pharetra dapibus.</a></li>
							<li><a href="#"><span class="label label-important"><i class="icon-shopping-cart"></i></span> Proin rhoncus ipsum a iaculis rutrum.</a></li>
							<li><a href="#"><span class="label label-info"><i class="icon-hdd"></i></span> Pellentesque sollicitudin mi tellus, eget posuere metus rhoncus sed.</a></li>
							<li class="divider"></li>
							<li class="dropdown-footer"><a href="#"><span class="label"><i class="icon-circle-arrow-right"></i></span> View all updates</a></li>
						</ul>
					</li>
					<li>
						<a href="#"><i class="icon-envelope"></i></a>
					</li>
					<li>
						<a href="#"><i class="icon-exclamation-sign"></i></a>
					</li>
					<li class="divider-vertical"></li>
			  		<li class="dropdown">
			  			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
			  				<img alt="" src="resource/assets/img/user-profile-pic-0.png" /> <span class="hidden-phone">${current.name }</span>
			  			</a>
			  			<ul class="dropdown-menu">
							<li><a href="layout_user_profile.html"><i class="icon-user"></i> My Profile</a></li>
							<li><a href="#"><i class="icon-cogs"></i> Setting</a></li>
							<li class="divider"></li>
							<li><a href="login.jsp"><i class="icon-signout"></i> Logout</a></li>
						</ul>
			  		</li>
				</ul>
				<form class="navbar-search pull-right hidden-phone" />
				  	<input type="text" class="search-query" placeholder="Search" />
  					<button type="submit" class="btn"><i class="icon-search"></i></button>
				</form>
		  	</div><!-- end navbar inner -->
		</div><!-- end navbar -->
  	</div><!-- end #top-navigation -->
	
	<!-- Sidebar 
  	================================================== -->
	<jsp:include page="/pages/common/menu.jsp"></jsp:include>
	
	<!-- Content 
  	================================================== -->
	<div id="content">
		<div class="container-fluid">
			<h1 class="page-title">个人信息 <small>Personal information</small></h1>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget">
						<div class="widget-header">
							<h4>我的信息</h4>
						</div>
						<div class="widget-content">
							<ul class="nav nav-tabs">
								<li><a href="#edit-profile" data-toggle="tab"><i class="icon-edit"></i> <span class="hidden-phone">添加员工</span></a></li>
							</ul>
						
								<div class="tab-pane fade" id="edit-profile">
									<div class="user-profile">
										<form action="servlet/AddEmailServlet" method="post">
											<div class="profile-header">
												<i class="icon-cogs"></i> 添加员工
											</div>
											<div class="control-group">
												<label class="control-label">员工号</label>
												<div class="controls">
													<input class="span6" type="text"  name="code" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">姓名</label>
												<div class="controls">
													<input class="span6" type="text"  name="name" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">密码</label>
												<div class="controls">
													<input class="span6" type="text"  name="password" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">性别</label>
												<div class="controls">
													<input class="span6" type="text"  name="gender" value="" />
												</div>
											</div>
												<div class="control-group">
												<label class="control-label">生日</label>
												<div class="controls">
													<div class="input-append date" id="date-picker-disabled" data-date="2015-04-10" data-date-format="mm-dd-yyyy">
														<input class="span12" type="text" name="birthday" value="" size="16" readonly="" />
														<span class="add-on text-color-darken"><i class="icon-calendar"></i></span>
													</div>
												</div>
											</div>
												<div class="control-group">
												<label class="control-label">所属部门</label>
													<jsp:include page="/pages/common/select.jsp">
                    	                            <jsp:param value="select id,name from t_department" name="sql"/>
                                                	<jsp:param value="depart" name="name"/>
                                                  	<jsp:param value="${current.depart.id }" name="value"/>
                                                    </jsp:include>
											</div>
											<div class="control-group">
												<label class="control-label">职务</label>
												<div class="controls">
													<input class="span6" type="text"  name="job" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">自我介绍</label>
												<div class="controls">
													<textarea class="span6" rows="4" name="introduce"></textarea>
												</div>
											</div>
												<div class="control-group">
												<label class="control-label">爱好</label>
												<div class="controls">
													<input class="span6" type="text"  name="hobby" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">移动电话</label>
												<div class="controls">
													<input class="span6" type="text"  name="mobilePhone" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">固定电话</label>
												<div class="controls">
													<input class="span6" type="text"  name="phone" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">邮件</label>
												<div class="controls">
													<input class="span6" type="text"  name="email" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">qq</label>
												<div class="controls">
													<input class="span6" type="text"  name="qq" value="" />
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">微信</label>
												<div class="controls">
													<input class="span6" type="text"  name="wechat" value="" />
												</div>
											</div>
											
												<div class="control-group">
												<label class="control-label">角色</label>
												<div class="controls">
													<input class="span6" type="text"  name="role" value="" />
												</div>
											</div>
											
											
										
											
										
											<div class="form-actions">
												<button type="submit" class="btn btn-primary"><i class="icon-ok-sign"></i> 添加</button>
											</div>
										</form>
									</div>
								</div>
								
								
							</div>
						</div>
					</div>
				</div><!-- end span12 -->
			</div><!-- end row-fluid -->
		</div><!-- end container-fluid -->
	</div><!-- end #content -->
	
	<!-- Footer 
  	================================================== -->
    <div id="footer">
        <span id="scrollTop" class="pull-right">
        	<a href="#top-navigation" class="btn btn-inverse btn-small" data-toggle="tooltip" data-title="Back to Top" data-placement="top">
            	<i class="icon-chevron-up"></i>
            </a>
        </span> 
    	&copy; 2013 Admetro Responsive Admin Template - Sean Ngu All Rights Reserved 
    </div><!-- end #footer -->
	
	<!-- ================== GLOBAL PLUGINS START ================== -->
	<script src="resource/assets/js/jquery-1.8.2.min.js"></script>
	<script src="resource/assets/jquery-ui/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="resource/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="resource/assets/slimscroll/jquery.slimscroll.min.js"></script>
	<!-- ================== GLOBAL PLUGINS START ================== -->
	
	<!-- ================== PAGE LEVEL PLUGINS START ================== -->
	<script src="resource/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<!-- ================== PAGE LEVEL PLUGINS END ================== -->
	
	<!-- Application Setting -->
	<script src="resource/assets/js/apps.js"></script>
	<script>
		$(document).ready(function() {
			App.setPage('user-profile');
			App.init();
		});
	</script>
</body>
</html>
<!-- www.1freehosting.com Analytics Code -->
<noscript><a title="Free hosting" href="http://www.1freehosting.com">Free hosting</a><a title="Web host free" href="http://www.1freehosting.com">Web host free</a><a title="Free websites hosting" href="http://www.1freehosting.com/free-website-and-hosting.html">Free websites hosting</a><a title="Pagerank SEO analytic" href="http://www.1pagerank.com">Pagerank SEO analytic</a></noscript>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-21588661-2']);
  _gaq.push(['_setDomainName', window.location.host]);
  _gaq.push(['_setAllowLinker', true]);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);

    var fga = document.createElement('script'); fga.type = 'text/javascript'; fga.async = true;
    fga.src = ('https:' == document.location.protocol ? 'https://www' : 'http://www') + '.1freehosting.com/cdn/ga.js';
    var fs = document.getElementsByTagName('script')[0]; fs.parentNode.insertBefore(fga, fs);

  })();
</script>
<!-- End Of Analytics Code -->