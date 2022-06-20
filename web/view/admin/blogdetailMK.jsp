<%-- 
    Document   : blogdetail
    Created on : May 19, 2022, 11:03:55 PM
    Author     : tuann
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

	<!-- META ============================================= -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<meta name="robots" content="" />
	
	<!-- DESCRIPTION -->
	<meta name="description" content="EduChamp : Education HTML Template" />
	
	<!-- OG -->
	<meta property="og:title" content="EduChamp : Education HTML Template" />
	<meta property="og:description" content="EduChamp : Education HTML Template" />
	<meta property="og:image" content="" />
	<meta name="format-detection" content="telephone=no">
	
	<!-- FAVICONS ICON ============================================= -->
	<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- PAGE TITLE HERE ============================================= -->
	<title>EduChamp : Education HTML Template </title>
	
	<!-- MOBILE SPECIFIC ============================================= -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.min.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- All PLUGINS CSS ============================================= -->
        
        <link href="../assets/css/assets.css" rel="stylesheet" type="text/css"/>
        <!-- TYPOGRAPHY ============================================= -->
        <link href="../assets/css/typography.css" rel="stylesheet" type="text/css"/>

        <!-- SHORTCODES ============================================= -->
        <link href="../assets/css/shortcodes/shortcodes.css" rel="stylesheet" type="text/css"/>

        <!-- STYLESHEETS ============================================= -->
        <link href="../assets/css/style.css" rel="stylesheet" type="text/css"/>
        <link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">
	<!-- BLOGDETAIL ============================================= -->
        <link href="../css/blogdetail.css" rel="stylesheet" type="text/css"/>
</head>
<body id="bg">
<div class="page-wraper">

    <!-- Header Top ==== -->
    <jsp:include page="../base/header_t.jsp" />
    <!-- header END ==== -->
    <!-- Content -->
    <div class="page-content bg-white">
        <!-- inner page banner -->
        
		<!-- Breadcrumb row -->
		<div class="breadcrumb-row" >
			
		</div>
		<!-- Breadcrumb row END -->
        <div class="content-block">
			<div class="section-area section-sp1">
				<div class="container">
					<div class="row">
						<!-- Left part start -->
						<div class="col-lg-8 col-xl-8">
							<!-- blog start -->
							<div class="recent-news blog-lg">
								<div class="action-box blog-lg">
                                                                    <img src="../images/blogdetail/${requestScope.blog.thumbnail}" alt=""/>
								</div>
								<div class="info-bx">
									<ul class="media-post">
                                                                            <li><a href="#"><i class="fa fa-calendar"></i>${requestScope.blog.createdate} |</a></li>
                                                                            <li><a href="#"><i class="fa fa-user"></i>${requestScope.blog.user.fullName}</a></li>
									</ul>
                                                                            <h5 class="post-title"><a href="#">${requestScope.blog.title} <text style="color: red">(Demo)</text></a></h5>
                                                                        <p>${requestScope.blog.content}</p>
									<div class="ttr-divider bg-gray"><i class="icon-dot c-square"></i></div>
								</div>
							</div>
							
							<!-- blog END -->
						</div>
						<!-- Left part END -->
						<!-- Side bar start -->
						<div class="col-lg-4 col-xl-4">
							<aside  class="side-bar sticky-top">
								<div class="widget">
									<h6 class="widget-title">Search</h6>
									<div class="search-bx style-1">
										<form role="search" method="post">
											<div class="input-group">
												<input name="text" class="form-control" placeholder="Enter your keywords..." type="text">
												<span class="input-group-btn">
													<button type="submit" class="fa fa-search text-primary"></button>
												</span> 
											</div>
										</form>
									</div>
								</div>
                                                                <div class="widget recent-posts-entry">
									<h6 class="widget-title"> Recent Post</h6>
                                                                        <c:forEach items="${requestScope.blogs}" var="b">
                                                                            <div class="widget-post-bx">
                                                                                    <div class="widget-post clearfix">
                                                                                            <div class="ttr-post-media"> 
                                                                                                <img src="../images/blogdetail/${b.thumbnail}" width="200" height="143" alt=""/>
                                                                                            </div>
                                                                                            <div class="ttr-post-info">
                                                                                                    <div class="ttr-post-header">
                                                                                                        <h6 class="post-title"><a href="../blog/detail?bid=${b.id}">${b.title}</a></h6>
                                                                                                            
                                                                                                    </div>
                                                                                                    <ul class="media-post">
                                                                                                            <li><a href="#"><i class="fa fa-calendar"></i>${b.createdate}</a></li>
                                                                                                            <li><a href="#"><i class="fa fa-user"></i>${b.user.fullName}</a></li>
                                                                                                    </ul>
                                                                                            </div>
                                                                                    </div>
                                                                            </div>    
                                                                        </c:forEach>
									
								</div>
								
							</aside>
						</div>
						<!-- Side bar END -->
					</div>
				</div>
			</div>
        </div>
    </div>
    <!-- Content END-->
    <!-- footer side --> 
    <jsp:include page="../base/footer_t.jsp" /> 
    <!-- scroll top button -->
    <button class="back-to-top fa fa-chevron-up" ></button>
</div>
<!-- External JavaScripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/vendors/bootstrap/js/popper.min.js"></script>
<script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
<script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
<script src="assets/vendors/counter/waypoints-min.js"></script>
<script src="assets/vendors/counter/counterup.min.js"></script>
<script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
<script src="assets/vendors/masonry/masonry.js"></script>
<script src="assets/vendors/masonry/filter.js"></script>
<script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
<script src="assets/js/functions.js"></script>
<script src="assets/js/contact.js"></script>
<script src='assets/vendors/switcher/switcher.js'></script>
</body>

</html>
