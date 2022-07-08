<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:10:19 GMT -->

    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="owners" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../view/admin/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
            <script src="../view/admin/assets/js/html5shiv.min.js"></script>
            <script src="../view/admin/assets/js/respond.min.js"></script>
            <![endif]-->

       
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/typography.css">

        
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/shortcodes/shortcodes.css">

       
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../view/admin/assets/css/color/color-1.css">
        <script src="../js/pagination/pagging_subjectlesson.js" type="text/javascript"></script>

        <style>
            .card-teacher {
                display: -webkit-box;
                -webkit-line-clamp: 1;
                -webkit-box-orient: vertical;
                overflow: hidden;
            }
            .card-courses-media {
                width: 180px;
                height: 180px;
                object-fit: cover;
                min-width: 180px;
            }

            .card-courses-media img {
                width: 180px !important;
                height: 160px;
                object-fit: cover;
            }
        </style>
    </head>

    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

       <jsp:include page="../../view/admin/header_admin.jsp" />

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Blog</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>DashBoard</a></li>
                        <li>blogs</li>
                    </ul>
                </div>
                <div class="row">
                    
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Post List</h4>
                            </div>
                            <div class="widget-inner">
                                <c:forEach items="${requestScope.BlogListForMK}" var="b">
                                    <div class="card-courses-list admin-courses">
                                        <div class="card-courses-media">
                                            <img  src="../images/blogdetail/${b.thumbnail}" alt="" />
                                        </div>
                                            <div class="card-courses-full-dec">
                                                <div class="card-courses-title">
                                                    <h4>${b.title}</h4>
                                                </div>
                                                <div class="card-courses-list-bx">
                                                    <ul class="card-courses-view">
                                                        <li class="card-courses-categories">
                                                            <h5>id</h5>
                                                            <h4>${b.id}</h4>
                                                        </li>
                                                        <li class="card-courses-categories">
                                                            <h5>Categories</h5>
                                                            <h4>${b.category.value}</h4>
                                                        </li>
                                                        
                                                        <li class="card-courses-categories">
                                                            <h5>create date</h5>
                                                            <h4>${b.createdate}</h4>
                                                        </li>
                                                        <li class="card-courses-stats">
                                                            <h5>stastus</h5>
                                                            <span 
                                                                <c:if test="${b.status.id == 1}">
                                                                    class="btn button-sm green radius-xl"
                                                                </c:if>
                                                                <c:if test="${b.status.id == 2}">
                                                                    class="btn button-sm red radius-xl"
                                                                </c:if>
                                                                >${b.status.name}</span>

                                                        </li>

                                                        <li class="card-courses-categories">
                                                            <h5>Author</h5>
                                                            <h4>${b.user.fullName}</h4>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="row card-courses-dec">

                                                    <div class="col-md-12">
                                                        <a href="../blog/demo?bid=${b.id}" class="btn green radius-xl outline">detail</a>
                                                        <a href="detail?bid=${b.id}" class="btn red outline radius-xl ">edit</a>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </c:forEach>
                                


                            </div>
                        </div>
                        <div style="display: flex; justify-content: center">
                            <ul class="pagination" id = "paggerBottomPostList">

                            </ul>
                        </div>
                    </div>

                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
            pagger_Lessons("paggerBottomPostList",2,${requestScope.totalPage},${requestScope.pageIndex},'${requestScope.url}'); 
        </script>
        <!-- External JavaScripts -->
        <script src="../view/admin/assets/js/jquery.min.js"></script>
        <script src="../view/admin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="../view/admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="../view/admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="../view/admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="../view/admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="../view/admin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="../view/admin/assets/vendors/counter/counterup.min.js"></script>
        <script src="../view/admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="../view/admin/assets/vendors/masonry/masonry.js"></script>
        <script src="../view/admin/assets/vendors/masonry/filter.js"></script>
        <script src="../view/admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='../view/admin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="../view/admin/assets/js/functions.js"></script>
        <script src="../view/admin/assets/vendors/chart/chart.min.js"></script>
        <script src="../view/admin/assets/js/admin.js"></script>
        <script src='../view/admin/assets/vendors/switcher/switcher.js'></script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->

</html>
