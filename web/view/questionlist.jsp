<%-- 
    Document   : questionlist
    Created on : Jun 13, 2022, 4:11:12 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../assets/images/favicon.png" />
        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <!--<link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">-->


        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>

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
                            <h1 class="text-white">Question List</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Question List</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- contact area -->
                <div class="container" style="margin-top: 20px;">
                    <div class="row">
                        <!-- Left part start -->
                        <div class="col-lg-12">
                            <!--<div class="col-lg-4 sticky-top">-->
                            <aside class="side-bar sticky-top">

                                <div class="widget recent-posts-entry">
                                    <h6 class="widget-title">Level</h6>
                                    <div >
                                        <c:forEach items="${requestScope.quizlevels}" var="c">
                                            <input type="checkbox" name="cid" value="${c.id}"/> ${c.levelName}    
                                        </c:forEach>
                                    </div>
                                </div>
                                <!--                                        <div class="widget widget-newslatter">
                                                                            <h6 class="widget-title">Newsletter</h6>
                                                                            <div class="news-box">
                                                                                <p>Enter your e-mail and subscribe to our newsletter.</p>
                                                                                <form class="subscription-form" action="http://educhamp.themetrades.com/demo/assets/script/mailchamp.php" method="post">
                                                                                    <div class="ajax-message"></div>
                                                                                    <div class="input-group">
                                                                                        <input name="dzEmail" required="required" type="email" class="form-control" placeholder="Your Email Address"/>
                                                                                        <button name="submit" value="Submit" type="submit" class="btn black radius-no">
                                                                                            <i class="fa fa-paper-plane-o"></i>
                                                                                        </button>
                                                                                    </div>
                                                                                </form>
                                                                            </div>
                                                                        </div>-->

                                <div style="margin-bottom: 10px" class="widget widget_tag_cloud">
                                    <h6 class="widget-title">Tags</h6>
                                    <div class="tagcloud"> 
                                       
                                        <c:forEach begin="0" end="${tags.size()-1}" var="i">
                                            <a> <div class="cate-card">
                                                    <label class="cate-item">
                                                        <input onchange="submitSearch();" type="checkbox" name="tagId"  ${checkTag[i]?"checked":""} 
                                                               value="${tags.get(i).tagId}"> <span>${tags.get(i).tagname}</span>
                                                    </label>
                                                </div>
                                            </a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </aside>
                        </div>
                    </div>
                </div>
            </div>
            <!--                <div class="content-block">
                                <div class="section-area section-sp1">-->
            <div class="container">
                <div class="row">
                    <!-- Left part start -->
                    <div class="col-lg-12">
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Question List</h1>
                            <ol class="breadcrumb mb-4">

                            </ol>
<!--                            <div class="card mb-4">
                                <div class="card-body">
                                    DataTables 
                                    .
                                </div>
                            </div>-->
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-table me-1"></i>
                                    Question List
                                </div>
                                <div class="card-body">
                                    <table id="datatablesSimple"  >
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Content</th>   
                                                <th>Option</th>
                                                <th>Answer</th>
                                                <th>Explainaton</th>
                                                <th>Course</th>
                                                <th>Level</th>
                                                <th>Status</th>
                                                <th>Detail</th>
                                                <th>Edit</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Id</th>
                                                <th>Content</th>  
                                                <th>Option</th>
                                                <th>Answer</th>
                                                <th>Explainaton</th>
                                                <th>Course</th>
                                                <th>Level</th>
                                                <th>Status</th>
                                                <th>Detail</th>
                                                <th>Edit</th>
                                            </tr>
                                        </tfoot>
                                        <tbody >
                                            <c:forEach items="${requestScope.list}" var="b">
                                                <tr>
                                                    <td>${b.id}</td>

                                                    <td>${b.content}</td>
                                                    <td>${b.option1}</td>
                                                    <td>${b.answer}</td>     
                                                    <td>${b.explain}</td>

                                                    <td>${b.course.courseId}</td>
                                                    <td>${b.quizlevel.id}</td>
                                                    <td>${b.status.id}</td>
                                                    <td>Detail</td>
                                                    <td>Edit</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Left part END -->
                    <!-- Side bar start -->

                    <!-- Side bar END -->
                </div>
            </div>
            <!--                    </div>
                            </div>-->
        </div>
        <!-- Content END-->
        <!-- Footer ==== -->
        <jsp:include page="../view/base/footer_t.jsp" /> 
        <!-- Footer END ==== -->
        <!-- scroll top button -->
        <button class="back-to-top fa fa-chevron-up" ></button>
    </div>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="../js/datatables-simple-demo.js"></script>
</body>

</html>
