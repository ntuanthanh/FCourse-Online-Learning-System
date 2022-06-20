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
             .button{
                display: flex;
                justify-content: center;
                margin-bottom: 30px;
            }



            /* CSS */
            .button-36 {
                background-image: linear-gradient(92.88deg, #455EB5 9.16%, #5643CC 43.89%, #673FD7 64.72%);
                border-radius: 8px;
                border-style: none;
                box-sizing: border-box;
                color: #FFFFFF;
                cursor: pointer;
                flex-shrink: 0;
                font-family: "Inter UI","SF Pro Display",-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,Oxygen,Ubuntu,Cantarell,"Open Sans","Helvetica Neue",sans-serif;
                font-size: 16px;
                font-weight: 500;
                height: 2.5rem;
                padding: 0 1rem;
                text-align: center;
                text-shadow: rgba(0, 0, 0, 0.25) 0 3px 8px;
                transition: all .5s;
                user-select: none;
                -webkit-user-select: none;
                touch-action: manipulation;
            }

            .button-36:hover {
                box-shadow: rgba(80, 63, 205, 0.5) 0 1px 30px;
                transition-duration: .1s;
            }
            
            
            @media (min-width: 768px) {
                .button-36 {
                    padding: 0 2.6rem;
                }
            }
        </style>
    </head>

    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="../../view/admin/header_admin.jsp" />         <!-- header end -->
        <!-- Left sidebar menu start -->
       
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
                                            <input  onchange="myFrom()" id="from" max="" name="from" type="date" value="${requestScope.begin}" max="${requestScope.end}">
                                        </div>
                                        <div class="col-sm-6">
                                            to
                                            <br>
                                            <input   onchange="myTo()" id="to" min="" name="to" type="date" value="${requestScope.end}" min="${requestScope.begin}">
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
                                        <div class="dropdown">
                                            <ul>

                                                <c:set var="checkCate" value="${requestScope.cidcheck}"  />
                                                <c:set var="cates" value="${requestScope.cates}"  />
                                                <c:forEach items="${requestScope.pCates}" var="p">
                                                    <li><button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">${p.name}<i class="ti-angle-down"></i></a></button>
                                                    
                                                        <ul class="dropdown-menu">
                                                            <c:forEach begin="0" end="${p.categories.size()-1}" var="i" >
                                                                <li>
                                                                    <c:set var="flag"  value="${false}}"/>


                                                                    <c:forEach begin="0" end="${cates.size()-1}" var="j">
                                                                        <div style="display: none">${checkCate[j]==p.categories.get(i).getCategoryID()?(flag=true):""}</div>

                                                                    </c:forEach>
                                                                    <div class=>
                                                                        <label >
                                                                            <input ${flag?"checked":""}  type="checkbox" name="cateId" value="${p.categories.get(i).getCategoryID()}"><span>${p.categories.get(i).getValue()}</span>
                                                                        </label>
                                                                    </div>

                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <hr>
                                <div  style="margin-top: 20px"  class="col-sm-12 button">
                                    
                                        <button class="button-36" type="submit" class="search-btn" >
                                            submit
                                        </button>   
                                </div>
                            </div>
                        </form>

                    </div>
                    
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <button style="color: white; float: right" class="btn btn-light"><a href="../course/add">NEW COURSE</a></button>
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