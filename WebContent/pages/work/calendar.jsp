<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<title>Admetro | Calendar</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	
	<!-- ================== GLOBAL STYLE START ================== -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
	<link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
	<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
	<link href="assets/jquery-ui/jquery-ui-1.10.1.custom.css" rel="stylesheet" />
	<link href="assets/css/style.min.css" rel="stylesheet" />
	<link href="assets/css/style-responsive.min.css" rel="stylesheet" />
	<!-- ================== GLOBAL STYLE END ================== -->
	
	<!-- ================== PAGE LEVEL STYLE START ================== -->
	<link rel="stylesheet" href="assets/fullcalendar/fullcalendar/fullcalendar.css" />
	<!-- ================== PAGE LEVEL STYLE END ================== -->
    
    <!-- IE8 HTML5 COMPATIBILITY -->
    <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
	
	<jsp:include page="/pages/common/head.jsp"></jsp:include>
    <jsp:include page="/pages/common/menu.jsp"></jsp:include>
	
	<!-- Sidebar 
  	================================================== -->
	
	
	<!-- Content 
  	================================================== -->
	<div id="content">
		<div class="container-fluid">
			<h1 class="page-title">日历 <small>schedule planning and more</small></h1>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget">
						<div class="widget-header">
							<h4>日历</h4>
						</div>
						<div class="widget-content">
							<div id="calendar"></div>
						</div><!--  -->
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
	<script src="assets/js/jquery-1.8.2.min.js"></script>
	<script src="assets/jquery-ui/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/slimscroll/jquery.slimscroll.min.js"></script>
	<!-- ================== GLOBAL PLUGINS START ================== -->
	
	<!-- ================== PAGE LEVEL PLUGINS START ================== -->
	<script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
	<!-- ================== PAGE LEVEL PLUGINS END ================== -->
	
	<!-- Application Setting -->
	<script src="assets/js/apps.js"></script>
	<script>
		$(document).ready(function() {
			App.setPage('calendar');
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