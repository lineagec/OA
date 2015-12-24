<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" href="resource/assets/bootstrap-wysihtml5/src/bootstrap-wysihtml5.css" />
	<!-- ================== PAGE LEVEL STYLE END ================== -->
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
				  	<input type="text" class="search-query" placeholder="Search" />
  					<button type="submit" class="btn"><i class="icon-search"></i></button>
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
			<h1 class="page-title">收件箱 <small>Personal information</small></h1>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget">
						<div class="widget-header">
							<h4>收件箱</h4>
						</div>
						<div class="widget-content">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#overview" data-toggle="tab"><i class="icon-desktop"></i> <span class="hidden-phone">收件箱</span></a></li>
							</ul>
							<div class="tab-content">
								<div class="tab-pane fade active in" id="overview">
									<div class="user-profile">
										<div class="profile-header">
											<i class="icon-info-sign"></i> 收件箱
										</div>
										<div class="profile-image">
											<img src="resource/assets/img/user-profile-pic-4.png" alt="" />
										</div>
										<div class="widget">
						<div class="widget-header">
							<h4>收件箱</h4>
						</div>
						<div class="widget-content">
							<table class="table table-hover">
								 <thead>
                         <tr>
                             <th>标题</th>
                             <th>内容</th>
                             <th>收件时间</th>
                             <th>发件人</th>
                             <th>操作</th>
                         </tr>
                     </thead>
                     <tbody>
                     	 <c:choose>
                           <c:when test="${!empty inlist }">
                           <c:forEach items="${inlist }" var="i">
                              <tr>
                               <%--  <td>${o.id} </td> --%>
			                    <td>${i.title }</td>
			                    <td>${i.content }</td>
			                    <td>${i.sendTime}</td>
			                    <td>${i.sender.name }</td>
			                    <td>
			                    <a href="servlet/SeeEamilServlet?id=${i.id }" class="btn mini black"><i class="icon-trash"></i> 查看</a>
			                    <a href="servlet/ToGomibakoServlet?id=${i.id }" class="btn mini black"><i class="icon-trash"></i> 删除</a>
			                    </td>
                              </tr>
                           </c:forEach>
                           </c:when>
                           <c:otherwise>
                           <tr >
                           <td colspan="5">还没有邮件</td>
                           </tr>
                           </c:otherwise>
                           </c:choose>
                     </tbody>
							</table>
						</div>
					</div>
									
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
	<script src="resource/assets/ckeditor/ckeditor.js"></script>
	<script src="resource/assets/bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0.js"></script>
	<script src="resource/assets/bootstrap-wysihtml5/src/bootstrap-wysihtml5.js"></script>
	<!-- ================== PAGE LEVEL PLUGINS END ================== -->
	
	<!-- ================== PAGE LEVEL PLUGINS START ================== -->
	<script src="resource/assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="resource/assets/js/Calendar.js"></script>
	<!-- ================== PAGE LEVEL PLUGINS END ================== -->
	
	<!-- Application Setting -->
	<script src="resource/assets/js/apps.js"></script>
	<script>
		$(document).ready(function() {
			App.setPage('user-profile');
			App.init();
		});
	</script>
	
	<script src="resource/assets/js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->
	<script src="resource/assets/js/select.min.js"></script> <!-- Custom Select -->
    <script src="resource/assets/js/markdown.min.js"></script> <!-- Markdown Editor -->
   
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


