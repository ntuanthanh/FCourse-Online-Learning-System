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

        <!-- header start -->
        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <!--sidebar menu toggler start -->
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <!--sidebar menu toggler end -->
                <!--logo start -->
                <div class="ttr-logo-box">
                    <div>
                        <a href="index.html" class="ttr-logo">
                            <img alt="" class="ttr-logo-mobile" src="../view/admin/assets/images/logo-mobile.png" width="30" height="30">
                            <img alt="" class="ttr-logo-desktop" src="../view/admin/assets/images/logo-white.png" width="160" height="27">
                        </a>
                    </div>
                </div>
                <!--logo end -->
                <div class="ttr-header-menu">
                    <!-- header left menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="../index.html" class="ttr-material-button ttr-submenu-toggle">HOME</a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="../courses.html">Our Courses</a></li>
                                    <li><a href="../event.html">New Event</a></li>
                                    <li><a href="../membership.html">Membership</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <!-- header left menu end -->
                </div>
                <div class="ttr-header-right ttr-with-seperator">
                    <!-- header right menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="#" class="ttr-material-button ttr-search-toggle"><i class="fa fa-search"></i></a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><i class="fa fa-bell"></i></a>
                            <div class="ttr-header-submenu noti-menu">
                                <div class="ttr-notify-header">
                                    <span class="ttr-notify-text-top">9 New</span>
                                    <span class="ttr-notify-text">User Notifications</span>
                                </div>
                                <div class="noti-box-list">
                                    <ul>
                                        <li>
                                            <span class="notification-icon dashbg-gray">
                                                <i class="fa fa-check"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 02:14</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-yellow">
                                                <i class="fa fa-shopping-cart"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Your order is placed</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 7 Min</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-red">
                                                <i class="fa fa-bullhorn"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Your item is shipped</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 2 May</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-green">
                                                <i class="fa fa-comments-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Sneha Jogi</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 14 July</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-primary">
                                                <i class="fa fa-file-word-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 15 Min</span>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="../view/admin/assets/images/testimonials/pic3.jpg" width="32" height="32"></span></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="user-profile.html">My profile</a></li>
                                    <li><a href="list-view-calendar.html">Activity</a></li>
                                    <li><a href="mailbox.html">Messages</a></li>
                                    <li><a href="../login.html">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="ttr-hide-on-mobile">
                            <a href="#" class="ttr-material-button"><i class="ti-layout-grid3-alt"></i></a>
                            <div class="ttr-header-submenu ttr-extra-menu">
                                <a href="#">
                                    <i class="fa fa-music"></i>
                                    <span>Musics</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-youtube-play"></i>
                                    <span>Videos</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-envelope"></i>
                                    <span>Emails</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-book"></i>
                                    <span>Reports</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-smile-o"></i>
                                    <span>Persons</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-picture-o"></i>
                                    <span>Pictures</span>
                                </a>
                            </div>
                        </li>
                    </ul>
                    <!-- header right menu end -->
                </div>
                <!--header search panel start -->
                <div class="ttr-search-bar">
                    <form class="ttr-search-form">
                        <div class="ttr-search-input-wrapper">
                            <input type="text" name="qq" placeholder="search something..." class="ttr-search-input">
                            <button type="submit" name="search" class="ttr-search-submit"><i class="ti-arrow-right"></i></button>
                        </div>
                        <span class="ttr-search-close ttr-search-toggle">
                            <i class="ti-close"></i>
                        </span>
                    </form>
                </div>
                <!--header search panel end -->
            </div>
        </header>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <div class="ttr-sidebar">
            <div class="ttr-sidebar-wrapper content-scroll">
                <!-- side menu logo start -->
                <div class="ttr-sidebar-logo">
                    <a href="#"><img alt="" src="../view/admin/assets/images/logo.png" width="122" height="27"></a>
                    <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                                            <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                                            <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
                                    </div> -->
                    <div class="ttr-sidebar-toggle-button">
                        <i class="ti-arrow-left"></i>
                    </div>
                </div>
                <!-- side menu logo end -->
                <!-- sidebar menu start -->
                <nav class="ttr-sidebar-navi">
                    <ul>
                        <li>
                            <a href="index.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-home"></i></span>
                                <span class="ttr-label">Dashborad</span>
                            </a>
                        </li>
                        <li>
                            <a href="courses.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Courses</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-email"></i></span>
                                <span class="ttr-label">Mailbox</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="mailbox.html" class="ttr-material-button"><span class="ttr-label">Mail Box</span></a>
                                </li>
                                <li>
                                    <a href="mailbox-compose.html" class="ttr-material-button"><span class="ttr-label">Compose</span></a>
                                </li>
                                <li>
                                    <a href="mailbox-read.html" class="ttr-material-button"><span class="ttr-label">Mail Read</span></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-calendar"></i></span>
                                <span class="ttr-label">Calendar</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="basic-calendar.html" class="ttr-material-button"><span class="ttr-label">Basic Calendar</span></a>
                                </li>
                                <li>
                                    <a href="list-view-calendar.html" class="ttr-material-button"><span class="ttr-label">List View</span></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="bookmark.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-bookmark-alt"></i></span>
                                <span class="ttr-label">Bookmarks</span>
                            </a>
                        </li>
                        <li>
                            <a href="review.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-comments"></i></span>
                                <span class="ttr-label">Review</span>
                            </a>
                        </li>
                        <li>
                            <a href="add-listing.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                <span class="ttr-label">Add listing</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-user"></i></span>
                                <span class="ttr-label">My Profile</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="user-profile.html" class="ttr-material-button"><span class="ttr-label">User Profile</span></a>
                                </li>
                                <li>
                                    <a href="teacher-profile.html" class="ttr-material-button"><span class="ttr-label">Teacher Profile</span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="ttr-seperate"></li>
                    </ul>
                    <!-- sidebar menu end -->
                </nav>
                <!-- sidebar menu end -->
            </div>
        </div>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Courses</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Courses</li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-sm-12 m-b30">

                        <form action="list" method="GET">

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="widget courses-search-bx placeani ">
                                        <div class="form-group">
                                            <div class="input-group">
                                                <h4>Search Courses</h4>

                                                <input   type="text" name="title"  value="${requestScope.title}" >
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6" >
                                            from
                                            <br>
                                            <input  onchange="myFrom()" id="from" max="" name="from" type="date" value="${requestScope.begin}">
                                        </div>
                                        <div class="col-sm-6">
                                            to
                                            <br>
                                            <input   onchange="myTo()" id="to" min="" name="to" type="date" value="${requestScope.end}">
                                        </div>
                                        <div class="col-sm-6">

                                            sort<br>
                                            <select  onchange="submitSearch();" name="sort">
                                                <option ${requestScope.sort == "0"?"selected = selected":""} value="0">new</option>
                                                <option ${requestScope.sort == "1"?"selected = selected":""} value="1">old</option>
                                                <option ${requestScope.sort == "2"?"selected = selected":""} value="2">a-z</option>
                                                <option ${requestScope.sort == "3"?"selected = selected":""} value="3">z-a</option>

                                            </select>
                                        </div>

                                        <div class="col-sm-6">
                                            status
                                            <br>
                                            <select  onchange="submitSearch();" name="status">
                                                <option ${requestScope.status == 0?"selected = selected":""} value="">all</option>
                                                <c:forEach items="${requestScope.statues}" var="st">
                                                    <option ${requestScope.status == st.id?"selected = selected":""} value="${st.id}">${st.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div> 
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="widget widget_archive" style="margin-bottom: 10px">
                                        <h5 class="widget-title style-1">category</h5>
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
                                </div>

                                <hr>
                                <div  style="margin-top: 20px"  class="col-sm-12 button">
                                    <div>
                                        <button class="button-36" type="submit" class="search-btn" >
                                            submit
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>

                    </div>
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Your Courses</h4>
                            </div>
                            <div class="widget-inner">
                                <c:set  var="courses" value="${requestScope.courses}" />
                                <c:set var="num" value="${requestScope.num}"/>
                                <c:if test="${courses.size()>0}">
                                    <c:forEach begin="0" end="${courses.size()-1}" var="i">
                                        <div class="card-courses-list admin-courses">
                                            <div class="card-courses-media">
                                                <img  src="../images/courses/${courses.get(i).thumnailURL}" alt="" />
                                            </div>
                                            <div class="card-courses-full-dec">
                                                <div class="card-courses-title">
                                                    <h4>${courses.get(i).title}</h4>
                                                </div>
                                                <div class="card-courses-list-bx">
                                                    <ul class="card-courses-view">
                                                        <li class="card-courses-categories">
                                                            <h5>id</h5>
                                                            <h4>${courses.get(i).courseId}</h4>
                                                        </li>
                                                        <li class="card-courses-categories">
                                                            <h5>Categories</h5>
                                                            <h4>${courses.get(i).category.value}</h4>
                                                        </li>
                                                        <li class="card-courses-categories">
                                                            <h5>number of lesons</h5>
                                                            <h4>${num[i]}</h4>
                                                        </li>
                                                        <li class="card-courses-categories">
                                                            <h5>create date</h5>
                                                            <h4>${courses.get(i).createDate}</h4>
                                                        </li>
                                                        <li class="card-courses-stats">
                                                            <h5>stastus</h5>
                                                            <span 
                                                                <c:if test="${courses.get(i).status.id == 1}">
                                                                    class="btn button-sm green radius-xl"
                                                                </c:if>
                                                                <c:if test="${courses.get(i).status.id == 2}">
                                                                    class="btn button-sm red radius-xl"
                                                                </c:if>
                                                                >${courses.get(i).status.name}</span>

                                                        </li>

                                                        <li class="card-courses-user">

                                                            <div class="card-courses-user-info">
                                                                <h5>Teacher</h5>
                                                                <h4 class="card-teacher"><c:if test="${courses.get(i).owners.size()>0}">
                                                                        <c:forEach begin="0" end="${courses.get(i).owners.size()-1}" var="j">
                                                                            <span>  ${courses.get(i).owners.get(j).fullName}
                                                                                <c:if test="${j<courses.get(i).owners.size()-1}">, </c:if>
                                                                                </span>
                                                                        </c:forEach>
                                                                    </c:if>
                                                                </h4>
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="row card-courses-dec">

                                                    <div class="col-md-12">
                                                        <a href="../admin/subject/details?id=${courses.get(i).courseId}" class="btn green radius-xl outline">detail</a>
                                                        <a href="#" class="btn red outline radius-xl ">edit</a>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>


                            </div>
                        </div>
                        <ul id="pagger" class="pagination">

                        </ul>
                    </div>

                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
             var from = document.getElementById("from");
            var to = document.getElementById("to");

            function myFrom() {
                to.min = from.value;
                console.log(from.max + "|" + to.value);
            }

            function myTo() {
                from.max = to.value;
                console.log(from.max + "|" + to.value);
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