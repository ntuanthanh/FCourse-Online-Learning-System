<%-- 
    Document   : blogdetail
    Created on : May 19, 2022, 11:03:55 PM
    Author     : tuann
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/blogdetail.css"/>
    <title>Blog Detail|Edu-FCourse</title>
</head>
<body>
    <!-- Header side -->
    <jsp:include page="base/header.jsp"/>
    <!-- Content side -->
    <div class="content">       
        <div class="image-detail"><img src="../images/blogdetail/blogdetail.png" alt="" ></div>
        <div class="grid">
            <div class="row">
                <div class="col-md-8 right" >
                    <div class="thurmbnail">
                        <img src="../images/blogdetail/${requestScope.blog.thumbnail}">
                    </div>
                    <div class="info">
                        <div class="day"><a>${requestScope.blog.category.value} | </a><i class="fa-solid fa-calendar-days"></i> ${requestScope.blog.createdate}</div>
                        <div class="poster">Author: ${requestScope.blog.user.fullName}</div>
                    </div>
                    <div class="details">
                        <h1>${requestScope.blog.title}
                        </h1>
                        <p>${requestScope.blog.content}</p>
                    </div>
                    <div class="space"></div>
                </div>
                <div class="col-md-4 left" >
                    <div class="box-search">
                        <form action="list" method="GET" class="search-box" >
                            <input name="title" type="text" placeholder="Enter Searching..." required>
                            <button type="submit" class="search-icon" ><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="sider-post">
                        <h3>Categories Posts</h3>
                        <div class="post-category">
                            <c:forEach items="${requestScope.categories}" var="c">
                                <p class="category-items"><a  href="list?cateId=${c.categoryID}">${c.value}</a></p>
                            </c:forEach>
                            
                        </div>
                    </div>
                    <div class="sider-post">
                        <h3>Recent Post</h3>
                        <c:forEach items="${requestScope.blogs}" var="b">
                            <a href="/summer2022-se1616-g4/blog/detail?bid=${b.id}">
                                <div class="post">
                                    <img src="../images/blogdetail/${b.thumbnail}" alt="" >
                                    <div class="text-post">
                                        <h5 style="margin-bottom: 0px; font-weight: bold; font-size: 15px">${b.title}</h5>
                                        <p>${b.brief}</p>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                        
                    </div>
                </div>
            </div>
      </div>
    </div>
    <!-- footer side -->
    <jsp:include page="../view/base/footer.jsp" /> 
</body>
</html>
