<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/color/color-1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" 
              integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/shortcodes/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/popupNotiResogister.css">
        <style>
            .li-item{
                width: 20%;
            }
            .hiden1{
                display: none;
            }
            .card-content > li {
                font-size: 14px;
            }
        </style>
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <jsp:include page="base/header_t.jsp" /> 
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->

                <!-- Breadcrumb row -->
                <c:if test="${requestScope.flag != 0}">
                    <c:if test="${requestScope.success == true}">
                        <div class="alert alert-success box_notify">
                            <i  class="fas fa-times" onclick="BoxClose()"></i> Successfully! your request is pending approval
                        </div>
                    </c:if>
                    <c:if test="${requestScope.success == false}">
                        <div class="alert alert alert-danger box_notify">
                            <i  class="fas fa-times" onclick="BoxClose()"></i> Fail! 
                        </div>
                    </c:if>
                </c:if>

                <div class="breadcrumb-row">
<!--                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Blog List Sidebar</li>
                        </ul>
                    </div>-->
                </div>
                <!-- Breadcrumb row END -->
                <!-- contact area -->
                <div class="content-block">
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <!-- Left part start -->
                                <div class="col-lg-8">
                                    <div style="width: 100%" class="blog-post blog-md clearfix">


                                        <c:if test="${requestScope.myCourses.size()>0}">
                                            <c:forEach var = "i" begin="0" end="${requestScope.myCourses.size()-1}">

                                                <div style="display: block" class="ttr-post-info card-content">
                                                    <ul style="width: 100%" class="media-post">
                                                        <li><a href="#"><i class="fa fa-calendar"></i>start: ${requestScope.myCourses.get(i).startDate}</a></li>
                                                        <li><a href="#"><i class="fa fa-calendar"></i>end :${requestScope.myCourses.get(i).endDate}</a></li>
                                                    </ul>
                                                    <h5 class="post-title"><a href="blog-details.html">${requestScope.myCourses.get(i).course.title}</a></h5>


                                                    <ul style="width: 100%" class="media-post">
                                                        <li class="li-item"><a href="#"><i class="fa fa-id-card"></i>id: ${requestScope.myCourses.get(i).course.courseId}</a></li>
                                                        <li class="li-item"><a href="#">package: ${requestScope.myCourses.get(i).pricePackage.name}</a></li>
                                                        <li  class="li-item"><a href="#"><i class="fa fa-calendar"></i>
                                                                <c:if test="${!requestScope.myCourses.get(i).registration_status}"> status: submitted </c:if>
                                                                <c:if test="${requestScope.myCourses.get(i).registration_status}"> status: accepted </c:if>
                                                                </a></li>
                                                            <li  class="li-item"><a href="#"><i class="fa fa-"></i><c:if test="${!requestScope.myCourses.get(i).registration_status}">
                                                                    <a href="#" >Edit</a>
                                                                </c:if></a></li>
                                                    </ul>

                                                    <div class="post-extra">

                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>
                                    </div>


                                    <!-- Pagination start -->
                                   <div class="pagination-bx rounded-sm gray clearfix">
                                        <ul class="pagination">
                                            <li class="previous"><a href="#"><i class="ti-arrow-left"></i> Prev</a></li>
                                            <li class="active"><a href="#">1</a></li>
                                            <li><a href="myregistration?page=2">2</a></li>
                                           
                                            <li class="next"><a href="#">Next <i class="ti-arrow-right"></i></a></li>
                                        </ul>
                                    </div>
                                    <!-- Pagination END -->
                                </div>
                                <!-- Left part END -->
                                <!-- Side bar start -->
                                <div class="col-lg-4 sticky-top">
                                    <aside class="side-bar ">
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
                                                    <div class="widget widget_archive" style="margin-bottom: 10px">
                                                        <h5 class="widget-title style-1">category</h5>
                                                        <ul >

                                                            <c:set var="checkCate" value="${requestScope.cidcheck}"  />
                                                            <c:set var="cates" value="${requestScope.cates}"  />
                                                            <c:forEach items="${requestScope.pCates}" var="p">
                                                                <li class="label"><a style="font-size: 16px; font-weight: 10px" data-toggle="collapse" 
                                                                                     data-target="#demo-${p.id}">${p.name}<i class="ti-angle-down"></i></a></li>
                                                                <div id="demo-${p.id}" class="collapse">
                                                                    <ul>
                                                                        <c:forEach begin="0" end="${p.categories.size()-1}" var="i" >
                                                                            <li>
                                                                                <div class="cate-card">
                                                                                    <label class="cate-item">
                                                                                        <a  href="myregistration?categoryId=${p.categories.get(i).categoryID}">
                                                                                            <span>${p.categories.get(i).getValue()}</a>
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

            <!-- Footer END ==== -->
            <!-- scroll top button -->
            <button class="back-to-top fa fa-chevron-up" ></button>

        </div>
        <script>
            BoxClose = function () {
                document.querySelector(".box_notify").classList.add("hiden1");
            }

        </script>
        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/counter/waypoints-min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/counter/counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/masonry/masonry.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/masonry/filter.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/functions.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/contact.js"></script>
        <script src='${pageContext.request.contextPath}/assets/vendors/switcher/switcher.js'></script>
    </body>

</html>