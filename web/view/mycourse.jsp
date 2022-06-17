<%-- 
    Document   : mycourse
    Created on : May 28, 2022, 1:47:26 AM
    Author     : thand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
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
        <title>My Course</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/home.css"/>
        <script src="js/pager.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/coursecard.css"/>

        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <!-- Header side -->
        <jsp:include page="../view/base/header_t.jsp" /> 
        <!-- footer side -->
        <div >
            <c:forEach var = "j" begin = "1" end = "${requestScope.Courses.size()}">
                <c:if test = "${ j % 4 == 1}">
                    <div class="row">
                    </c:if> 

                    <div class="cards col-md-3 col-xs-6">
                        <div class="course-card">
                            <div class="card-infor">


                                <div class="course-img">
                                    <img src="images/courses/${requestScope.Courses.get(j-1).thumnailURL}" alt="">

                                </div>
                                <div class="course-title" >
                                    <a href="#"><h4>${requestScope.Courses.get(j-1).title}</h4></a>
                                </div>
                                <div class="briefInfo">
                                    <p>${requestScope.Courses.get(j-1).briefInfo}</p>
                                </div>

                                <div class="progress" style="margin-top: 10px" >

                                    <div class="progress-bar"  style="width: ${requestScope.courserates.get(j-1)}%; ">
                                        <c:if test="${requestScope.courserates.get(j-1)>0 }">

                                        </c:if>
                                    </div>

                                </div>
                                <div>
                                    <c:if test="${requestScope.courserates.get(j-1)>0 }">
                                        ${requestScope.courserates.get(j-1)}% complete
                                    </c:if>
                                    <c:if test="${requestScope.courserates.get(j-1)==0 }">
                                        <span style="margin-top: 8px; font-size: 20px">Start Course</span> 
                                    </c:if>
                                </div>
                            </div>


                        </div>

                    </div>
                    <c:set var = "i" scope = "request" value = "${j+1}"/>
                    <c:if test = "${ i % 4 == 1}">
                    </div>
                </c:if> 
            </c:forEach>


        </div>
        
        <div id="paggerbot" class = "text-center" > </div>
        
        <script>
            pagger("paggerbot",${requestScope.pageindex},${requestScope.totalpage}, 1);
            
        </script>

    </body>
    <jsp:include page="../view/base/footer_t.jsp" />  
</html>
