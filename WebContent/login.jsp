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
<title>OA | Login</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />

<!-- ================== GLOBAL STYLE START ================== -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet" />
<link href="resource/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="resource/assets/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" />
<link href="resource/assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />
<link href="resource/assets/jquery-ui/jquery-ui-1.10.1.custom.css"
	rel="stylesheet" />
<link href="resource/assets/css/style.min.css" rel="stylesheet" />
<link href="resource/assets/css/style-responsive.min.css"
	rel="stylesheet" />
<!-- ================== GLOBAL STYLE END ================== -->

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

	<!-- Body Cover Image
  	================================================== -->
	<div class="body-cover"></div>

	<!-- Login Container
  	================================================== -->
	<div id="login">
		<div class="brand">
			<span class="color"><i class="icon-leaf"></i> OA自动化办公</span>
		</div>
		<div class="login-container">
			<div class="login-header">
				<i class="icon-lock" id="login-signal"></i> 登陆
				<strong>${suc}</strong> 
			</div>
			<div class="login-content">
				<form class="margin-bottom-0" action="LoginServlet" >
				<input type="text" name="code" class="input-block-level" placeholder="员工号" /><br />
				<input type="password" name="password" class="input-block-level" placeholder="密码" /><br />
				<label class="checkbox"> <input type="checkbox" /> 记住密码
				<label class="label label-success">${msg }</label>
				</label>
				<div class="login-buttons">
					<button type="submit" class="btn btn-success">
						<i class="icon-signin"></i> 登陆
					</button>
					<a href="#" class="pull-right">忘记密码 -联系:023-15615845895</a>
				</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end #login -->
	<!-- ================== GLOBAL PLUGINS START ================== -->
	<script src="resource/assets/js/jquery-1.8.2.min.js"></script>
	<script src="resource/assets/jquery-ui/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="resource/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="resource/assets/slimscroll/jquery.slimscroll.min.js"></script>
	<!-- ================== GLOBAL PLUGINS START ================== -->

	<!-- Application Setting -->
	<script src="resource/assets/js/apps.js"></script>
	<script>
		$(document).ready(function() {
			App.init();
		});
	</script>
</body>
</html>
<!-- www.1freehosting.com Analytics Code -->
<noscript>
	<a title="Free hosting" href="http://www.1freehosting.com">Free
		hosting</a><a title="Web host free" href="http://www.1freehosting.com">Web
		host free</a><a title="Free websites hosting"
		href="http://www.1freehosting.com/free-website-and-hosting.html">Free
		websites hosting</a><a title="Pagerank SEO analytic"
		href="http://www.1pagerank.com">Pagerank SEO analytic</a>
</noscript>
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-21588661-2' ]);
	_gaq.push([ '_setDomainName', window.location.host ]);
	_gaq.push([ '_setAllowLinker', true ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);

		var fga = document.createElement('script');
		fga.type = 'text/javascript';
		fga.async = true;
		fga.src = ('https:' == document.location.protocol ? 'https://www'
				: 'http://www')
				+ '.1freehosting.com/cdn/ga.js';
		var fs = document.getElementsByTagName('script')[0];
		fs.parentNode.insertBefore(fga, fs);

	})();
</script>
<!-- End Of Analytics Code -->