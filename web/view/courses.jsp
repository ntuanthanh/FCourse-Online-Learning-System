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
        <link rel="icon" href="../assets/images/favicon.ico" type="../assets/image/x-icon" />
        <link rel="shortcut icon" type="../assets/image/x-icon" href="../assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/tagline.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/checkbox.css">
        <link rel="stylesheet" type="text/css" href="../css/registerCourse.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">
        <style>
            .action-box img{

                height: 150px;
                object-fit:cover;
            }
            .title-course{
                text-align: left;
                font-weight: 500;
                height: 52px;
                font-size: 110%;

                padding: 0px 5px;
                display: -webkit-box;
                -webkit-line-clamp: 2;
                -webkit-box-orient: vertical;
                overflow: hidden;
            }
            input[type="date"]{
                width: 100%;
                font-size: 14px;

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
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <jsp:include page="../view/base/header_t.jsp" /> 
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(user/images/banner/banner3.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Our Courses</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Our Courses</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <!-- Button trigger modal -->


                <!-- Modal -->

                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">

                                    <form action="list" method="GET">

                                        <div class="widget courses-search-bx placeani">
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <h4>Search Courses</h4>

                                                    <input   type="text" name="title"  value="${requestScope.title}" >
                                                </div>
                                            </div>
                                        </div>
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
                                        <hr>
                                        <div style="margin-bottom: 10px" class="widget widget_tag_cloud">
                                            <h6 class="widget-title">Tags</h6>
                                            <div class="tagcloud"> 
                                                <c:set var="tags" value="${requestScope.tags}"  />
                                                <c:set var="checkTag" value="${requestScope.tidcheck}"  />
                                                <c:forEach begin="0" end="${tags.size()-1}" var="i">
                                                    <a> <div class="cate-card">
                                                            <label class="cate-item">
                                                                <input onchange="submitSearch();" type="checkbox" name="tagId"  ${checkTag[i]?"checked":""} 
                                                                       value="${tags.get(i).tagId}"><span>${tags.get(i).tagname}</span>
                                                            </label>
                                                        </div>
                                                    </a>
                                                </c:forEach>


                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6" >
                                                from
                                                <br>
                                                <input id="from"  onchange="myFrom()" max="" name="from" type="date" value="${requestScope.begin}">
                                            </div>
                                            <div class="col-sm-6">
                                                to
                                                <br>
                                                <input id="to"  onchange="myTo()" min="" name="to" type="date" value="${requestScope.end}">
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

                                            <div class="col-sm-6 col-6">
                                                feature
                                                <br>
                                                <select  onchange="submitSearch();" name="feature">

                                                    <option  ${requestScope.feature == 0?"selected = selected":""} value="0">all</option>
                                                    <option ${requestScope.feature == 1?"selected = selected":""} value="1">featured</option>
                                                </select>
                                            </div>
                                        </div>                                     
                                        <div  style="margin-top: 20px"  class="col-sm-12 button">
                                            <div>
                                                <button class="button-36" type="submit" class="search-btn" >
                                                    submit
                                                </button>
                                            </div>
                                        </div>
                                    </form>



                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="row">
                                        <c:forEach items="${requestScope.courses}" var="course" >
                                            <div class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                                <div class="cours-bx">
                                                    <div class="action-box">
                                                        <img  src="../images/courses/${course.thumnailURL}" alt="">
                                                        <button class="btn" data-toggle="modal" data-target="#myModal-course${course.courseId}" >resgister</button>
                                                    </div>
                                                    <div class="info-bx text-center">
                                                        <div class="title-course"> <h5><a href="../coursedetail?id=${course.courseId}">${course.title}</a></h5></div>
                                                        <span>${course.category.value}</span>
                                                        <ul class="tag">

                                                            <c:forEach items="${course.getTags()}" var="tag">

                                                                <li class="tag-item"  style="margin-bottom: 20px"><a href="list?tagId=${tag.tagId}">${tag.getTagname()}</a></li>
                                                                </c:forEach>
                                                        </ul>
                                                    </div>
                                                    <div class="cours-more-info">
                                                        <div class="review">
                                                            <span>3 Review</span>
                                                            <ul class="cours-star">
                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                <li><i class="fa fa-star"></i></li>
                                                                <li><i class="fa fa-star"></i></li>
                                                            </ul>
                                                        </div>
                                                        <div class="price">
                                                            <del>$${course.pricePackage[0].listPrice}</del>
                                                            <h5>$${course.pricePackage[0].salePrice}</h5>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>


                                        <div class="col-lg-12 m-b20">
                                            <div class="pagination-bx rounded-sm gray clearfix">
                                                <ul id="pagger" class="pagination">

                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- contact area END -->
                <c:forEach items="${requestScope.courses}" var="course">
                    <div class="modal fade" id="myModal-course${course.courseId}">
                        <div style="max-width: 1000px"class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="row">
                                    <c:forEach items="${course.pricePackage}" var="price">
                                        <div class="col-lg-4">
                                            <div class="columns">
                                                <ul class="price">
                                                    <li class="header">${price.name}</li>
                                                    <li class="grey">duration ${price.duration} month</li>

                                                    <li><del>${price.listPrice}</del></li>
                                                    <li>${price.salePrice}</li>
                                                        <c:if test = "${sessionScope.user != null}">
                                                        <li class="grey">  
                                                            <a  onclick="submitRe();" href="#"  class="button">register</a>
                                                            <form id="regist" method="POST" action="../course/register">
                                                                <input type="hidden" name="courseid" value="${course.courseId}">
                                                                <input type="hidden" name="userid" value="${sessionScope.user.id}">
                                                                <input type="hidden" name="priceid" value="${price.id}">

                                                            </form> 
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
                </c:forEach> 
            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <jsp:include page="../view/base/footer_t.jsp" /> 
            <!-- Footer END ==== -->

        </div>
        <!-- External JavaScripts -->
        <script>
            function submitRe() {
                document.getElementById("regist").submit();
            }
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
            
            var inputtitle;
            var inputelement = document.querySelector('input[name="title"]');
            inputelement.oninput = function (e) {
                inputtitle = e.target.value;
            }

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
