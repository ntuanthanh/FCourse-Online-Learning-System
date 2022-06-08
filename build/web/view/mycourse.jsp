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
        <jsp:include page="../view/base/header.jsp" /> 
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
                                    <c:if test="${requestScope.courserates.get(j-1)==0 }">
                                        <span style="margin-top: 8px; font-size: 20px">Start</span> 
                                    </c:if>


                                    <div class="progress-bar"  style="width: ${requestScope.courserates.get(j-1)}%; ">

                                        <c:if test="${requestScope.courserates.get(j-1)>0 }">
                                            ${requestScope.courserates.get(j-1)}%
                                        </c:if>

                                    </div>

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
    <jsp:include page="../view/base/footer.jsp" />  
</html>
