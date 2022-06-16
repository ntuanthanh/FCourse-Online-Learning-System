<%-- 
    Document   : courseList
    Created on : May 23, 2022, 10:32:36 PM
    Author     : jicon
--%>

<%@page import="model.Course"%>
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

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/color/color-1.css">
        <style>
            .title-card{
                -webkit-line-clamp: 3;
                -webkit-box-orient: vertical;
                overflow: hidden;
            }
            .post-thumnal{

            }

        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <jsp:include page="../view/base/header_t.jsp" /> 
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner2.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Blog List Sidebar</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Blog List Sidebar</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- contact area -->
                <div class="content-block">
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <!-- Left part start -->
                                <div class="col-lg-8">

                                    <c:forEach items="${requestScope.blogs}" var="b">

                                        <div class="blog-post blog-md clearfix">
                                            <div class="ttr-post-media post-thumnal"> 
                                                <a href="#"> <img src="../images/blogdetail/${b.thumbnail}" alt=""></a> 
                                            </div>
                                            <div class="ttr-post-info">
                                                <ul class="media-post">
                                                    <li><a href="#"><i class="fa fa-calendar"></i>${b.createdate}</a></li>
                                                    <li><a href="#"><i class="fa fa-user"></i>${b.user.fullName}</a></li>
                                                </ul>
                                                <h5 class="post-title title-card"><a href="../blog/detail?bid=${b.id}">${b.title}</a></h5>
                                                <p> ${b.brief}</p>
                                                <div class="post-extra">
                                                    <a href="#" class="btn-link">${b.category.value}</a>

                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>


                                    <!-- Pagination start -->
                                    <div class="pagination-bx rounded-sm gray clearfix">
                                        <ul id="pagger" class="pagination">

                                        </ul>
                                    </div>
                                    <!-- Pagination END -->
                                </div>
                                <!-- Left part END -->
                                <!-- Side bar start -->
                                <div class="col-lg-4 sticky-top">
                                    <aside class="side-bar sticky-top">
                                        <div class="widget">
                                            <h6 class="widget-title">Search</h6>
                                            <div class="search-bx style-1">
                                                <form  method="GET">
                                                    <div class="input-group">
                                                        <input name="title" value="${requestScope.title}" class="form-control"  type="text">
                                                        <span class="input-group-btn">
                                                            <button type="submit" class="fa fa-search text-primary"></button>
                                                        </span> 
                                                    </div>
                                                    <div class="widget widget_archive" style="margin-bottom: 10px">
                                                        <h5 style="margin-top: 30px" class="widget-title style-1">category</h5>
                                                        <ul>

                                                            <c:set var="checkCate" value="${requestScope.cidcheck}"  />
                                                            <c:set var="cates" value="${requestScope.cates}"  />
                                                            <c:forEach items="${requestScope.pCates}" var="p">
                                                                <li><a data-toggle="collapse" data-target="#demo-${p.id}">${p.name}<i class="ti-angle-down"></i></a></li>
                                                                <div id="demo-${p.id}" class="collapse">
                                                                    <ul>
                                                                        <c:forEach begin="0" end="${p.categories.size()-1}" var="i" >
                                                                            <li>
                                                                                <c:set var="flag"  value="${false}}"/>


                                                                                <c:forEach begin="0" end="${cates.size()-1}" var="j">
                                                                                    <div style="display: none">${checkCate[j]==p.categories.get(i).getCategoryID()?(flag=true):""}</div>

                                                                                </c:forEach>
                                                                                <div class="cate-card">
                                                                                    <label class="cate-item">
                                                                                        <input ${flag?"checked":""}  type="checkbox" name="cateId" value="${p.categories.get(i).getCategoryID()}"><span>${p.categories.get(i).getValue()}</span>
                                                                                    </label>
                                                                                </div>

                                                                            </li>
                                                                        </c:forEach>
                                                                    </ul>
                                                                </div>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </form>
                                            </div>
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
            <!-- Footer ==== -->

            <jsp:include page="../view/base/footer_t.jsp" /> 
            <!-- Footer END ==== -->

            <!-- scroll top button -->
            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>
        <script>
            scrollWindow();

            // scrolls the window to auto load in middle of page 

            function scrollWindow() {
                window.scroll(0, 700);
            }

            pagging("pagger", 2,${requestScope.totalpage}, ${requestScope.pageindex}, '${requestScope.url}');
            function pagging(id, gap, totalPage, pageIndex, url_param) {
                var container = document.getElementById(id);
                result = '';
                if (pageIndex - gap > 1) {
                    result += '<li><a  href="' + url_param + 'page=1">First</a></li>';
                }
                // mới thêm
                if (pageIndex > 1) {
                    result += '<li ><a  href="' + url_param + 'page=' + (pageIndex - 1) + '"><i class="ti-arrow-left"></i> Prev</a></li>';
                }
                for (var i = pageIndex - gap; i < pageIndex; i++) {
                    if (i > 0)
                        result += '<li><a  href="' + url_param + 'page=' + i + '">' + i + '</a></li>';
                }
                result += '<li  class="active"><a href="#">' + pageIndex + '</a></li>';

                for (var i = pageIndex + 1; i <= pageIndex + gap; i++) {
                    if (i <= totalPage)
                        result += '<li><a href="' + url_param + 'page=' + i + '">' + i + '</a></li>';
                }
                // mới thêm
                if (pageIndex < totalPage) {
                    result += '<li><a href="' + url_param + 'page=' + (pageIndex + 1) + '">Next</a></li>';
                }
                if (pageIndex + gap < totalPage) {
                    result += '<li"><a href="' + url_param + 'page=' + totalPage + '">Last<i class="ti-arrow-right"></i></a></li>';
                }
                container.innerHTML = result;

            }
        </script>
        <!-- External JavaScripts -->
        <script src="../assets/js/jquery.min.js"></script>
        <script src="../assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="../assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="../assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="../assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="../assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="../assets/vendors/counter/waypoints-min.js"></script>
        <script src="../assets/vendors/counter/counterup.min.js"></script>
        <script src="../assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="../assets/vendors/masonry/masonry.js"></script>
        <script src="../assets/vendors/masonry/filter.js"></script>
        <script src="../assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="../assets/js/functions.js"></script>
        <script src="../assets/js/contact.js"></script>
        <script src='../assets/vendors/switcher/switcher.js'></script>
    </body>

</html>