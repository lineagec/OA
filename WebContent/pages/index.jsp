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
	<link href="resource/assets/jqvmap/jqvmap.css" rel="stylesheet" />
	<link href="resource/assets/jquery-timelinr/css/style.css" rel="stylesheet" />
	<link href="resource/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
	<link href="resource/assets/gritter/css/jquery.gritter.css" rel="stylesheet" />
  	<link href="resource/assets/isotope/isotope.css" rel="stylesheet" />
  	<link href="resource/assets/lightbox/css/lightbox.css" rel="stylesheet" />
	<!-- ================== PAGE LEVEL STYLE END ================== -->
    
    <!-- IE8 HTML5 COMPATIBILITY -->
    <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

	<!-- Body Cover Image & Logo
  	================================================== -->
	<div class="body-cover"></div>
	<div class="logo"><i class="icon-leaf"></i> OA自动化办公</div>
	
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
				<form class="navbar-search pull-right hidden-phone" >
				  	<input type="text" class="search-query" placeholder="Search" />
  					<button type="submit" class="btn"><i class="icon-search"></i></button>
				</form>
		  	</div><!-- end navbar inner -->
		</div><!-- end navbar -->
  	</div><!-- end #top-navigation -->
	
	<!-- Sidebar 
  	================================================== -->
  	   <jsp:include page="/pages/common/menu.jsp"></jsp:include>
<!-- end #sidebar -->
	
	<!-- Content 
  	================================================== -->
	<div id="content">
		<div class="container-fluid">
			<h1 class="page-title">Dashboard <small>statistic and more</small></h1>
			<div class="row-fluid">
				<div class="span8">
					<div class="widget">
						<div class="widget-header">
							Visitor Analyze
						</div>
						<div class="widget-content">
							<div id="interactive-chart" class="statistic-graph"></div>
						</div>
					</div>
					<div class="widget widget-tabs">
						<div class="tabbable striped">
							<ul class="nav nav-tabs">
								<li class="dropdown active important"><a href="#post" data-toggle="tab"><i class="icon-picture"></i> <span class="hidden-phone">Latest Post</span></a></li>
								<li class="dropdown warning"><a href="#buyer" data-toggle="tab"><i class="icon-shopping-cart"></i> <span class="hidden-phone">Purchase</span></a></li>
								<li class="dropdown green"><a href="#email" data-toggle="tab"><i class="icon-envelope"></i> <span class="hidden-phone">Email</span></a></li>
							</ul>
							<div class="tab-content" data-scrollbar="true" data-height="400px">
								<div class="tab-pane fade active in" id="post">
									<div class="media-post">
										<div class="image">
											<img alt="" src="resource/assets/img/envato/winter/scottwills_riverbank.jpg" />
										</div>
										<div class="content">
											<h4 class="title">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor accumsan rutrum.</h4>
											<p class="desc">
												Fusce augue diam, vestibulum a mattis sit amet, vehicula eu ipsum. Vestibulum eu mi nec purus tempor consequat. Vestibulum porta non mi quis cursus. Fusce vulputate cursus magna, tincidunt sodales ipsum lobortis tincidunt. Mauris quis lorem ligula. Morbi placerat est nec pharetra placerat. Ut laoreet nunc accumsan orci aliquam accumsan. Maecenas volutpat dolor vitae sapien ultricies fringilla. Suspendisse vitae orci sed nibh ultrices tristique. Aenean in ante eget urna semper imperdiet. Pellentesque sagittis a nulla at scelerisque.
											</p>
										</div>
									</div>
									<div class="media-post">
										<div class="image">
											<img alt="" src="resource/assets/img/envato/nature/scottwills_enchantedcreek.jpg" />
										</div>
										<div class="content">
											<h4 class="title">Aenean viverra arcu nec pellentesque ultrices. In erat purus, adipiscing nec lacinia at, ornare ac eros.</h4>
											<p class="desc">
												Nullam at risus metus. Quisque nisl purus, pulvinar ut mauris vel, elementum suscipit eros. Praesent ornare ante massa, egestas pellentesque orci convallis ut. Curabitur consequat convallis est, id luctus mauris lacinia vel. Nullam tristique lobortis mauris, ultricies fermentum lacus bibendum id. Proin non ante tortor. Suspendisse pulvinar ornare tellus nec pulvinar. Nam pellentesque accumsan mi, non pellentesque sem convallis sed. Quisque rutrum erat id auctor gravida.
											</p>
										</div>
									</div>
									<div class="media-post">
										<div class="image">
											<img alt="" src="resource/assets/img/envato/city/scottwills_hydrant1.jpg" />
										</div>
										<div class="content">
											<h4 class="title">Vestibulum vitae diam nec odio dapibus placerat. Ut ut lorem justo.</h4>
											<p class="desc">
												Fusce bibendum augue nec fermentum tempus. Sed laoreet dictum tempus. Aenean ac sem quis nulla malesuada volutpat. Nunc vitae urna pulvinar velit commodo cursus. Nullam eu felis quis diam adipiscing hendrerit vel ac turpis. Nam mattis fringilla euismod. Donec eu ipsum sit amet mauris iaculis aliquet. Quisque sit amet feugiat odio. Cras convallis lorem at libero lobortis, placerat lobortis sapien lacinia. Duis sit amet elit bibendum sapien dignissim bibendum. 
											</p>
										</div>
									</div>
									<div class="media-post">
										<div class="image">
											<img alt="" src="resource/assets/img/envato/nature/scottwills_mossytree.jpg" />
										</div>
										<div class="content">
											<h4 class="title">Maecenas eget turpis luctus, scelerisque arcu id, iaculis urna. Interdum et malesuada fames ac ante ipsum primis in faucibus.</h4>
											<p class="desc">
												Morbi placerat est nec pharetra placerat. Ut laoreet nunc accumsan orci aliquam accumsan. Maecenas volutpat dolor vitae sapien ultricies fringilla. Suspendisse vitae orci sed nibh ultrices tristique. Aenean in ante eget urna semper imperdiet. Pellentesque sagittis a nulla at scelerisque. Nam augue nulla, accumsan quis nisi a, facilisis eleifend nulla. Praesent aliquet odio non imperdiet fringilla. Morbi a porta nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.
											</p>
										</div>
									</div>
								</div>
							  	<div class="tab-pane fade" id="buyer">
							  		<table class="table">
							  			<thead>
							  				<tr>
							  					<th>Date</th>
							  					<th class="hidden-tablet hidden-phone">Product</th>
							  					<th>Amount</th>
							  					<th>User</th>
							  				</tr>
							  			</thead>
							  			<tbody>
							  				<tr>
							  					<td>13/02/2013</td>
							  					<td class="hidden-tablet hidden-phone">
							  						<div class="media">
														<a class="pull-left text-center media-object" href="#">
															<img alt="" class="image-small" src="resource/assets/img/products/product-1.png" />
													  	</a>
													  	<div class="media-body">
													  		<h6 class="media-heading"><a href="#">Nunc eleifend lorem eu velit eleifend, eget faucibus nibh placerat.</a></h6>
													  	</div>
							  						</div>
							  					</td>
							  					<td>$349.00</td>
							  					<td><a href="#">Derick Wong</a></td>
							  				</tr>
							  				<tr>
							  					<td>13/02/2013</td>
							  					<td class="hidden-tablet hidden-phone">
							  						<div class="media">
														<a class="pull-left text-center media-object" href="#">
															<img alt="" class="image-small" src="resource/assets/img/products/product-2.png" />
													  	</a>
													  	<div class="media-body">
													  		<h6 class="media-heading"><a href="#">Nunc eleifend lorem eu velit eleifend, eget faucibus nibh placerat.</a></h6>
													  	</div>
							  						</div>
							  					</td>
							  					<td>$399.00</td>
							  					<td><a href="#">Derick Wong</a></td>
							  				</tr>
							  				<tr>
							  					<td>13/02/2013</td>
							  					<td class="hidden-tablet hidden-phone">
							  						<div class="media">
														<a class="pull-left text-center media-object" href="#">
															<img alt="" class="image-small" src="resource/assets/img/products/product-3.png" />
													  	</a>
													  	<div class="media-body">
													  		<h6 class="media-heading"><a href="#">Nunc eleifend lorem eu velit eleifend, eget faucibus nibh placerat.</a></h6>
													  	</div>
							  						</div>
							  					</td>
							  					<td>$499.00</td>
							  					<td><a href="#">Derick Wong</a></td>
							  				</tr>
							  				<tr>
							  					<td>13/02/2013</td>
							  					<td class="hidden-tablet hidden-phone">
							  						<div class="media">
														<a class="pull-left text-center media-object" href="#">
															<img alt="" class="image-small" src="resource/assets/img/products/product-4.png" />
													  	</a>
													  	<div class="media-body">
													  		<h6 class="media-heading"><a href="#">Nunc eleifend lorem eu velit eleifend, eget faucibus nibh placerat.</a></h6>
													  	</div>
							  						</div>
							  					</td>
							  					<td>$230.00</td>
							  					<td><a href="#">Derick Wong</a></td>
							  				</tr>
							  				<tr>
							  					<td>13/02/2013</td>
							  					<td class="hidden-tablet hidden-phone">
							  						<div class="media">
														<a class="pull-left text-center media-object" href="#">
															<img alt="" class="image-small" src="resource/assets/img/products/product-5.png" />
													  	</a>
													  	<div class="media-body">
													  		<h6 class="media-heading"><a href="#">Nunc eleifend lorem eu velit eleifend, eget faucibus nibh placerat.</a></h6>
													  	</div>
							  						</div>
							  					</td>
							  					<td>$500.00</td>
							  					<td><a href="#">Derick Wong</a></td>
							  				</tr>
							  			</tbody>
							  		</table>
								</div>
							  	<div class="tab-pane fade" id="email">
									<ul class="email-list">
										<li>
											<div class="media">
												<a href="#" class="pull-left media-image">
													<img alt="" src="resource/assets/img/user-profile-pic-2.png" />
												</a>
												<div class="media-body">
													<h4><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></h4>
													<p>
														Aenean mollis arcu sed turpis accumsan dignissim. Etiam vel tortor at risus tristique convallis. Donec adipiscing euismod arcu id euismod. Suspendisse potenti. Aliquam lacinia sapien ac urna placerat, eu interdum mauris viverra.
														<span class="date">Received on 04/16/2013, 12.39pm</span>
													</p>
												</div>
											</div>
										</li>
										<li>
											<div class="media">
												<a href="#" class="pull-left media-image">
													<img alt="" src="resource/assets/img/user-profile-pic-3.png" />
												</a>
												<div class="media-body">
													<h4><a href="#">Praesent et sem porta leo tempus tincidunt eleifend et arcu.</a></h4>
													<p>
														Proin adipiscing dui nulla. Duis pharetra vel sem ac adipiscing. Vestibulum ut porta leo. Pellentesque orci neque, tempor ornare purus nec, fringilla venenatis elit. Duis at est non nisl dapibus lacinia.
														<span class="date">Received on 04/16/2013, 12.39pm</span>
													</p>
												</div>
											</div>
										</li>
										<li>
											<div class="media">
												<a href="#" class="pull-left media-image">
													<img alt="" src="resource/assets/img/user-profile-pic-4.png" />
												</a>
												<div class="media-body">
													<h4><a href="#">Ut mi eros, varius nec mi vel, consectetur convallis diam.</a></h4>
													<p>
														Ut mi eros, varius nec mi vel, consectetur convallis diam. Nullam eget hendrerit eros. Duis lacinia condimentum justo at ultrices. Phasellus sapien arcu, fringilla eu pulvinar id, mattis quis mauris.
														<span class="date">Received on 04/16/2013, 12.39pm</span>
													</p>
												</div>
											</div>
										</li>
										<li>
											<div class="media">
												<a href="#" class="pull-left media-image">
													<img alt="" src="resource/assets/img/user-profile-pic-5.png" />
												</a>
												<div class="media-body">
													<h4><a href="#">Aliquam nec dolor vel nisl dictum ullamcorper.</a></h4>
													<p>
														Aliquam nec dolor vel nisl dictum ullamcorper. Duis vel magna enim. Aenean volutpat a dui vitae pulvinar. Nullam ligula mauris, dictum eu ullamcorper quis, lacinia nec mauris.
														<span class="date">Received on 04/16/2013, 12.39pm</span>
													</p>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<div class="widget">
						<div class="widget-header">
							<h4>Discussion</h4>
						</div>
						<div class="widget-content">
							<ul class="chats" data-scrollbar="true" data-height="370">
								<li class="left">
									<div class="image">
										<img alt="" src="resource/assets/img/user-profile-pic-2.png" />
									</div>
									<div class="message">
										<a href="#" class="name">Derick Wong</a>
										<span class="date-time">at Jan 25, 2013 11:23</span>
										<span class="message-body">
											Lorem ipsum dolor sit amet, consectetuer adipiscing elit, 
											sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
										</span>
									</div>
								</li>
								<li class="right">
									<div class="image">
										<img alt="" src="resource/assets/img/user-profile-pic-3.png" />
									</div>
									<div class="message">
										<a href="#" class="name">Derick Wong</a>
										<span class="date-time">at Jan 25, 2013 11:23</span>
										<span class="message-body">
											 Fusce vulputate cursus magna, tincidunt sodales ipsum lobortis tincidunt. Mauris quis lorem ligula. Morbi placerat est nec pharetra placerat. Ut laoreet nunc accumsan orci aliquam accumsan. Maecenas volutpat dolor vitae sapien ultricies fringilla.
										</span>
									</div>
								</li>
								<li class="left">
									<div class="image">
										<img alt="" src="resource/assets/img/user-profile-pic-5.png" />
									</div>
									<div class="message">
										<a href="#" class="name">Derick Wong</a>
										<span class="date-time">at Jan 25, 2013 11:23</span>
										<span class="message-body">
											Nullam at risus metus. Quisque nisl purus, pulvinar ut mauris vel, elementum suscipit eros. Praesent ornare ante massa, egestas pellentesque orci convallis ut. Curabitur consequat convallis est, id luctus mauris lacinia vel. Nullam tristique lobortis mauris, ultricies fermentum lacus bibendum id.
										</span>
									</div>
								</li>
								<li class="right">
									<div class="image">
										<img alt="" src="resource/assets/img/user-profile-pic-4.png" />
									</div>
									<div class="message">
										<a href="#" class="name">Derick Wong</a>
										<span class="date-time">at Jan 25, 2013 11:23</span>
										<span class="message-body">
											Aenean sollicitudin arcu sit amet fringilla dignissim. Aenean fermentum dolor eget pharetra tincidunt. Vestibulum vitae diam nec odio dapibus placerat. Ut ut lorem justo. Nunc ut dui sed augue luctus ultricies quis ac leo.
										</span>
									</div>
								</li>
							</ul>
						</div>
						<div class="widget-footer">
							<input class="input-block-level" placeholder="Comment" type="text" />
						</div>
					</div>
					<div class="widget">
						<div class="widget-header">
							<h4>Gallery</h4>
						</div>
						<div class="widget-content">
							<section id="options">
								<span class="margin-right-10">Filter by</span>
								<span class="btn-group option-set" id="filter" data-option-key="filter">
									<a href="#show-all" class="btn btn-small active" data-option-value="*">Show All</a>
									<a href="#date" class="btn btn-small" data-option-value=".date">Date</a>
									<a href="#author" class="btn btn-small" data-option-value=".author">Author</a>
									<a href="#category" class="btn btn-small" data-option-value=".category">Category</a>
								</span>
							</section>
							<div id="gallery" class="margin-top-10 gallery">
								<div class="image date">
									<div class="image-inner">
										<a href="resource/assets/img/envato/winter/scottwills_bussnow.jpg" data-lightbox="date">
											<img src="resource/assets/img/envato/winter/scottwills_bussnow.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image date">
									<div class="image-inner">
										<a href="resource/assets/img/envato/nature/kariminal_rider.jpg" data-lightbox="date">
											<img src="resource/assets/img/envato/nature/kariminal_rider.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image date">
									<div class="image-inner">
										<a href="resource/assets/img/envato/nature/scottwills_enchantedcreek.jpg" data-lightbox="date">
											<img src="resource/assets/img/envato/nature/scottwills_enchantedcreek.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image date">
									<div class="image-inner">
										<a href="resource/assets/img/envato/nature/scottwills_gunpowder.jpg" data-lightbox="date">
											<img src="resource/assets/img/envato/nature/scottwills_gunpowder.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image author">
									<div class="image-inner">
										<a href="resource/assets/img/envato/winter/scottwills_rockCreek.jpg" data-lightbox="author">
											<img src="resource/assets/img/envato/winter/scottwills_rockCreek.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image author">
									<div class="image-inner">
										<a href="resource/assets/img/envato/nature/scottwills_mill.jpg" data-lightbox="author">
											<img src="resource/assets/img/envato/nature/scottwills_mill.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image author">
									<div class="image-inner">
										<a href="resource/assets/img/envato/nature/scottwills_mossytree.jpg" data-lightbox="author">
											<img src="resource/assets/img/envato/nature/scottwills_mossytree.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image author">
									<div class="image-inner">
										<a href="resource/assets/img/envato/winter/scottwills_snowScene16.jpg" data-lightbox="author">
											<img src="resource/assets/img/envato/winter/scottwills_snowScene16.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image category">
									<div class="image-inner">
										<a href="resource/assets/img/envato/nature/scottwills_pinecone.jpg" data-lightbox="category">
											<img src="resource/assets/img/envato/nature/scottwills_pinecone.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image category">
									<div class="image-inner">
										<a href="resource/assets/img/envato/winter/scottwills_icedrip.jpg" data-lightbox="category">
											<img src="resource/assets/img/envato/winter/scottwills_icedrip.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image category">
									<div class="image-inner">
										<a href="resource/assets/img/envato/city/scottwills_hydrant1.jpg" data-lightbox="category">
											<img src="resource/assets/img/envato/city/scottwills_hydrant1.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image category">
									<div class="image-inner">
										<a href="resource/assets/img/envato/city/scottwills_hydrant2.jpg" data-lightbox="category">
											<img src="resource/assets/img/envato/city/scottwills_hydrant2.jpg" alt="" />
										</a>
									</div>
								</div>
								<div class="image category">
									<div class="image-inner">
										<a href="resource/assets/img/envato/city/scottwills_firetruck.jpg" data-lightbox="category">
											<img src="resource/assets/img/envato/city/scottwills_firetruck.jpg" alt="" />
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div><!-- end span4 -->
				<div class="span4">
					<div class="widget">
						<div class="widget-content">
							<table class="table table-striped td-valign-middle margin-bottom-0">
								<thead>
									<tr>	
										<th>Source</th>
										<th>Total</th>
										<th>Trend</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><label class="label label-important">Unique Visitor</label></td>
										<td>13,203 <span class="text-success"><i class="icon-arrow-up"></i></span></td>
										<td><div id="sparkline-unique-visitor"></div></td>
									</tr>
									<tr>
										<td><label class="label label-warning">Bounce Rate</label></td>
										<td>28.2%</td>
										<td><div id="sparkline-bounce-rate"></div></td>
									</tr>
									<tr>
										<td><label class="label label-success">Total Page Views</label></td>
										<td>1,230,030</td>
										<td><div id="sparkline-total-page-views"></div></td>
									</tr>
									<tr>
										<td><label class="label label-info">Avg Time On Site</label></td>
										<td>00:03:45</td>
										<td><div id="sparkline-avg-time-on-site"></div></td>
									</tr>
									<tr>
										<td><label class="label label-inverse">% New Visits</label></td>
										<td>40.5%</td>
										<td><div id="sparkline-new-visits"></div></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="widget">
						<div class="widget-header">
							<h4>
								News
								<a href="#" class="btn btn-inverse pull-right">View All</a>
							</h4>
						</div>
						<div class="widget-content">
							<ul class="news-list">
								<li>
									<a href="#">
										<div class="news-media">
											<img alt="" src="resource/assets/img/user-profile-pic-4.png" />
										</div>
										<div class="news-info">
											<h4 class="news-title">21 Inspiring Clean Website Designs</h4>
											<span class="news-date">Posted On Feb <i class="date">21, 2013</i></span>
										</div>
									</a>
								</li>
								<li>
									<a href="#">
										<div class="news-media">
											<img alt="" src="resource/assets/img/user-profile-pic-2.png" />
										</div>
										<div class="news-info">
											<div class="news-title">The Benefits of Working on Freelance Projects</div>
											<div class="news-date">Posted On Feb <span class="date">21, 2013</span></div>
										</div>
									</a>
								</li>
								<li>
									<a href="#">
										<div class="news-media">
											<img alt="" src="resource/assets/img/user-profile-pic-3.png" />
										</div>
										<div class="news-info">
											<div class="news-title">The Flexible Web</div>
											<div class="news-date">Posted On Feb <span class="date">21, 2013</span></div>
										</div>
									</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="widget">
						<div class="widget-header">
							<div class="btn-group pull-right">
								<a href="#" data-toggle="dropdown" class="btn btn-inverse dropdown-toggle pull-right">Select Maps <span class="caret margin-left-5"></span></a>
								<ul class="dropdown-menu pull-right">
									<li><a href="#" data-map="world_en">World</a></li>
									<li><a href="#" data-map="usa_en">USA</a></li>
									<li><a href="#" data-map="europe_en">Europe</a></li>
									<li><a href="#" data-map="germany_en">Germany</a></li>
									<li><a href="#" data-map="russia_en">Russia</a></li>
								</ul>
							</div>
							<h4>Maps</h4>
						</div>
						<div class="widget-content">
							<div id="vmap" class="maps" style="height:300px;"></div>
						</div>
					</div>
					<div class="widget">
						<div class="widget-header">
							<h4>Calendar</h4>
						</div>
						<div class="widget-content">
							<div id="calendar"></div>
						</div>
					</div>
					<div class="widget">
						<div id="myCarousel" class="carousel slide">
							<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
								<li data-target="#myCarousel" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img src="resource/assets/img/envato/winter/scottwills_riverbank2.jpg" alt="" />
									<div class="carousel-caption">
										<h4>First Thumbnail label</h4>
										<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
									</div>
								</div>
								<div class="item">
									<img src="resource/assets/img/envato/nature/scottwills_enchantedcreek2.jpg" alt="" />
									<div class="carousel-caption">
										<h4>Second Thumbnail label</h4>
										<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
									</div>
								</div>
								<div class="item">
									<img src="resource/assets/img/envato/nature/scottwills_pinecone2.jpg" alt="" />
									<div class="carousel-caption">
										<h4>Third Thumbnail label</h4>
										<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
									</div>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
							<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
						</div>
					</div>
				</div><!-- end span4 -->
			</div>
		</div><!-- end container-fluid -->
	</div><!-- end #content -->
	
	<!-- Footer 
  	================================================== -->
    <div id="footer">
        <span id="scrollTop" class="pull-right">
        	<a href="#top-nav" class="btn btn-inverse btn-small" data-toggle="tooltip" data-title="Back to Top" data-placement="top">
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
	<script src="resource/assets/sparkline/jquery.sparkline.min.js"></script>
	<script src="resource/assets/jqvmap/jquery.vmap.js"></script>
	<script src="resource/assets/jqvmap/maps/jquery.vmap.world.js"></script>
	<script src="resource/assets/jqvmap/data/jquery.vmap.sampledata.js"></script>
	<script src="resource/assets/jqvmap/maps/jquery.vmap.usa.js"></script>
	<script src="resource/assets/jqvmap/maps/jquery.vmap.europe.js"></script>
	<script src="resource/assets/jqvmap/maps/jquery.vmap.germany.js"></script>
	<script src="resource/assets/jqvmap/maps/jquery.vmap.russia.js"></script>
	<script src="resource/assets/graph-jflot/jquery.flot.min.js"></script>
	<script src="resource/assets/graph-jflot/jquery.flot.time.min.js"></script>
	<script src="resource/assets/graph-jflot/jquery.flot.resize.min.js"></script>
	<script src="resource/assets/graph-jflot/jquery.flot.pie.min.js"></script>
	<script src="resource/assets/graph-jflot/jquery.flot.stack.min.js"></script>
	<script src="resource/assets/graph-jflot/jquery.flot.crosshair.min.js"></script>
    <!--[if lt IE 9]><script src="resource/assets/graph-jflot/excanvas.min.js"></script><![endif]-->
	<script src="resource/assets/fullcalendar/fullcalendar/fullcalendar.min.js"></script>
	<script src="resource/assets/gritter/js/jquery.gritter.min.js"></script>
	<script src="resource/assets/isotope/jquery.isotope.js"></script>
  	<script src="resource/assets/lightbox/js/lightbox-2.6.min.js"></script>
	<!-- ================== PAGE LEVEL PLUGINS END ================== -->
	
	<!-- Application Setting -->
	<script src="resource/assets/js/apps.js"></script>
	<script>
		$(document).ready(function() {
			App.setPage('index');
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