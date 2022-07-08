<%-- 
    Document   : MyRegistrations
    Created on : May 30, 2022, 3:35:20 PM
    Author     : thand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home|Edu-FCourse</title>
        <link rel="stylesheet" href="css/home.css"/>
        <link rel="stylesheet" href="css/blog.css"/>
        <link rel="stylesheet" href="css/tagline.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/images/favicon.png" />

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
        <!-- header css -->
        <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css"/>
        <!-- JavaScripts -->
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
        <!-- Bootstrap 4.6.1 -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <!--         End Bootstrap 4.6.1 -->
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Registion</title>

        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="css/coursecard.css"/>

        <link href="css/myRedistration.css" rel="stylesheet" type="text/css"/>
    </head>
    <body id="bg">

        <jsp:include page="../view/base/header_t.jsp" /> 
        <div class="page-banner ovbl-dark" style="background-image:url(user/images/banner/banner3.jpg);">
            <div class="container">
                <div class="page-banner-entry">
                    <h1 class="text-white">my registation</h1>
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
        <div class="content-block">
            <div class="section-area section-sp1">
                <div class="row text-center content-Categorys" >
                    <div class="col-lg-2 col-sm-12">
                        <form action="myregistration" method="POST">
                            <input name="title" placeholder="Search in My Registration">
                            <button style="margin: 5%" type="submit">Search</button>
                        </form>
                        <a  href="myregistration"><h4 style="text-align: left; margin: 5%;">
                                All Subject Category</h4>
                        </a>
                        <div class="scroll">
                            <c:forEach items="${requestScope.Categorys}" var="Category">
                                <div style="text-align: left; font-size: 20px">
                                    <a href="myregistration?categoryId=${Category.categoryID}">${Category.value}</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="col-lg-10 col-sm-12" style="right: 0px">
                        <table border="1" style="width: 95%" >
                            <thead>
                                <tr>
                                    <th> &emsp;id &emsp;</th>
                                    <th> &emsp;subject &emsp;</th>
                                    
                                    <th> &emsp;Registration &emsp;<br> &emsp; status &emsp;</th>
                                    <th> &emsp;valid from &emsp;</th>
                                    <th> &emsp;valid to &emsp;</th>
                                    <th> &emsp;Edit &emsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${requestScope.myCourses.size()>0}">
                                    <c:forEach var = "i" begin="0" end="${requestScope.myCourses.size()-1}">
                                        <tr>
                                            <td >${requestScope.myCourses.get(i).userCourseId}</td>
                                            <td class="b">${requestScope.myCourses.get(i).course.title}</td>
                                           
                                            <td >${requestScope.myCourses.get(i).registration_status}</td>
                                            <td >${requestScope.myCourses.get(i).startDate}</td>
                                            <td >${requestScope.myCourses.get(i).endDate}</td>
                                            <td >
                                                <c:if test="${!requestScope.myCourses.get(i).registration_status}">
                                                    <a href="#" >Edit</a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                            </tbody>
                        </table>
                    </div>   

                </div>
            </div>
        </div>

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
        <jsp:include page="../view/base/footer_t.jsp" />
    </body>

</html>
