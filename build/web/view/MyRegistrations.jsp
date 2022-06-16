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
        <title>My Registion</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="../view/base/header.jsp" /> 
        <link href="css/myRedistration.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>


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

            <div class="col-lg-10 col-sm-12" >
                <table border="1" >
                    <thead>
                        <tr>
                            <th> &emsp;id &emsp;</th>
                            <th> &emsp;subject &emsp;</th>
                            <th> &emsp;Registration &emsp;<br>  &emsp;time &emsp;</th>
                            <th> &emsp;package &emsp;</th>
                            <th> &emsp;total cost &emsp;</th>
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
                                    <td >${requestScope.myCourses.get(i).pricePackage.duration} month</td>
                                    <td >&emsp;${requestScope.myCourses.get(i).pricePackage.name}&emsp;</td>
                                    <td >${requestScope.myCourses.get(i).pricePackage.salePrice} $</td>
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



    </body>
    <jsp:include page="../view/base/footer.jsp" />
</html>
