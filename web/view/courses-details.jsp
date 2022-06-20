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
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/tagline.css">
        <link rel="stylesheet" type="text/css" href="css/registerCourse.css">
        <style>
            .course-img > img{
                height: 15rem;
                object-fit:cover;
            }
            .scroll{

                height: 110px;
                overflow: auto;
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
                <div class="page-banner ovbl-dark" style="background-image:url(${pageContext.request.contextPath}/assets/images/banner/banner2.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Courses Details</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Courses Details</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row d-flex flex-row-reverse">
                                <div class="col-lg-2 col-md-3 col-sm-12 m-b30">
                                    <div style="margin-bottom: 40px" class="input-group">
                                        <input name="title" value="${requestScope.title}" class="form-control"  type="text">
                                        <span class="input-group-btn">
                                            <button style="height: 40px; width: 40px" type="submit" class="fa fa-search text-primary"></button>
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
                                                                        <a   href="course/list?cateId=${p.categories.get(i).categoryID}" ><span>${p.categories.get(i).getValue()}</a>
                                                                    </label>
                                                                </div>

                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>  


                                <div class="col-lg-7 col-md-4 col-sm-12">
                                    <div class="courses-post" id="overview">
                                        <div class="ttr-post-media media-effect course-img">
                                            <img class="img " src="images/courses/${requestScope.Course.thumnailURL}" alt="First slide">
                                        </div>
                                        <div class="ttr-post-info">
                                            <div class="ttr-post-title ">
                                                <h2 class="post-title">${requestScope.Course.title}</h2>
                                            </div>
                                            <div class="ttr-post-text">
                                                <p><i>${requestScope.Course.briefinfo}</i></p>
                                            </div>
                                            <ul class="tag">
                                                <c:forEach items="${requestScope.Course.tags}" var="tags">
                                                    <li class="tag-item" style="margin-bottom: 20px">${tags.getTagname()}</li>
                                                    </c:forEach>
                                            </ul>
                                            <div style="margin-top: 20px" class="ttr-post-text">
                                                <p>${requestScope.Course.description}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="m-b30" id="curriculum">
                                        <h4>There are ${requestScope.Topics.size()} 
                                            Courses in this Specialization</h4>
                                        <ul class="curriculum-list">
                                            <li>

                                                <c:forEach items="${requestScope.Topics}" var="t">
                                                    <h5>${t.topicOrder} ${t.topicName}</h5>
                                                    <ul>
                                                        <li>
                                                            <div class="scroll">
                                                                ${t.description}
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </c:forEach>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-3 col-md-3 col-sm-12 m-b30">
                                    <div class="course-detail-bx">
                                        <div class="course-price">
                                            <c:if test="${requestScope.PricePackes.size()>0}">
                                                <del>${requestScope.PricePackes.get(0).listPrice}</del>
                                                <h4 class="price">$${requestScope.PricePackes.get(0).salePrice}</h4>
                                            </c:if>
                                        </div>	
                                        <div class="course-buy-now text-center">
                                            <button  class="btn radius-xl text-uppercase" data-toggle="modal" 
                                                     data-target="#myModal-course">Buy Now This Courses</button>
                                        </div>
                                        <div class="teacher-bx">
                                            <div class="teacher-info">

                                                <div>
                                                    <h5>expert of Course</h5>
                                                    <ul>
                                                        <c:forEach items="${requestScope.users}" var="user">
                                                            <li>${user.fullName}</li>
                                                            </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cours-more-info">
                                            
            
                                        </div>
                                        <div class="course-info-list scroll-page">
                                            <ul class="navbar">
                                                <li><a class="nav-link" href="#overview"><i class="ti-zip"></i>Overview</a></li>
                                                <li><a class="nav-link" href="#curriculum"><i class="ti-bookmark-alt"></i>Curriculum</a></li>
                                             
                                            </ul>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- contact area END -->
                <div class="modal fade" id="myModal-course">
                    <div style="max-width: 1000px"class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="row">
                                <c:forEach items="${PricePackes}" var="price">
                                   <div class="col-lg-4">
                                            <div class="columns">
                                                <ul class="price">
                                                    <li class="header">${price.name}</li>
                                                    <li class="grey">duration ${price.duration} month</li>
                                                   
                                                    <li><del>${price.listPrice}</del></li>
                                                    <li>${price.salePrice}</li>
                                                    <c:if test = "${sessionScope.user != null}">
                                                        <li class="grey">  
                                                            <a  href="course/register?courseid=${requestScope.Course.courseId}&userid=${sessionScope.user.id}&priceid=${price.id}"  
                                                               class="button">register</a>
                                                           
                                                        </li>  
                                                    </c:if>
                                                    <c:if test = "${sessionScope.user == null}">

                                                        <li class="grey">  
                                                            <a href="#" data-toggle="modal" data-target="#myModal-login" class="button">login</a>

                                                        </li>    
                                                    </c:if>   

                                                </ul>
                                            </div>
                                        </div>
                                </c:forEach>
                            </div>
                            <!-- Modal footer -->
                            <div class="modal-footer col-12">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <jsp:include page="base/footer_t.jsp" /> 
            <!-- Footer END ==== -->
            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>
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
        <script src="${pageContext.request.contextPath}/assets/js/jquery.scroller.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/functions.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/contact.js"></script>
        <script src="${pageContext.request.contextPath}/assets/vendors/switcher/switcher.js"></script>
    </body>

</html>
