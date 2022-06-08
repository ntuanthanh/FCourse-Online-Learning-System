<%-- 
    Document   : courseList
    Created on : May 23, 2022, 10:32:36 PM
    Author     : jicon
--%>

<%@page import="model.Course"%>
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
        <title>Course List</title>
        <script src="../js/pagging.js" type="text/javascript" ></script>
        <link rel="stylesheet" href="../css/courseList.css">
        <link rel="stylesheet" href="../css/blog.css"/>
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <%
            ArrayList<Course> coursesSlider = (ArrayList<Course>) request.getAttribute("coursesSlider");

        %>
        <script>
            function submitSearch() {
                document.getElementById("search").submit();
            }

        </script>
    </head>

    <body>
        <jsp:include page="../view/base/header.jsp" />  
        <div class = "slider">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">


                    <%for (int i = 0; i < 3; i++) {%> 
                    <%Course c = coursesSlider.get(i);%>
                    <%if (i == 0) {%>
                    <div class="carousel-item active">
                        <a href="#">
                            <img class="d-block w-100" src="../images/courses/<%=c.getThumnailURL()%>" alt="" >
                            <div class="carousel-caption d-none d-md-block">
                                <h5><%=c.getTitle()%></h5>
                            </div>
                        </a>
                    </div>        
                    <%}%>
                    <%if (i != 0) {%>
                    <div class="carousel-item">
                        <a href="#">
                            <img class="d-block w-100" src="../images/courses/<%=c.getThumnailURL()%>" alt="" >
                            <div class="carousel-caption d-none d-md-block">
                                <h5><%=c.getTitle()%></h5>
                            </div>
                        </a>
                    </div>        
                    <%}%>

                    <%}%>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

        </div>

        <!--Content side-->
        <div class="content-main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xl-3 col-sm-12">
                        <h4 class="category-subject" style="text-align: center;">Search Blog</h4>
                        <div class="slider-search row">
                            <form class="form-inline" action="list" method="GET" id="search">

                                <div class="search-box col-9">
                                    <input type="text" name="title" class="search-input" value="${requestScope.title}"  />
                                    <button type="submit" class="search-btn" >
                                        <i class='bx bx-search'></i>
                                    </button>
                                </div>

                                <c:set var="cates" value="${requestScope.categories}"  />
                                <c:set var="checkCate" value="${requestScope.cidcheck}"  />
                                <div class=" col-xl-12 col-sm-6 col-6">
                                    <h5 class=" col-xl-12 col-sm-12 col-12">category</h5>
                                    <div class="list-cate col-xl-12 col-sm-6 col-6">

                                        <c:forEach begin="0" end="${cates.size()-1}" var="i" >
                                            <div class=" col-12">
                                                <input onchange="submitSearch();" type="checkbox" name="cateId" ${checkCate[i]?"checked":""} 
                                                       value="${cates.get(i).getCategoryID()}">${cates.get(i).getValue()}
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>


                            </form>
                        </div>
                        <hr>
                    </div>
                    <div class="col-md-9 col-12">
                        <h2 class="title">Blog List</h2>
                        <div class="row">



                            

                            <c:forEach items="${requestScope.blogs}" var="b">
                                <div class="cards col-xl-4 col-sm-6 col-12">
                                    <div class="blog-card">
                                        <div class="blog-infor">
                                            <div class="blog-img">
                                                <img src="../images/blogdetail/${b.thumbnail}" alt="">
                                                <div class="category-card">${b.category.value}</div>
                                            </div>
                                            <div class="blog-title">
                                                <a href="../blog/detail?bid=${b.id}">${b.title}</a>

                                            </div>
                                            <div class="row">
                                                <div class="bief ">
                                                    ${b.brief}
                                                </div>
                                            </div>
                                            <div>
                                                <p class="auhor">${b.user.fullName}</p>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="col-12 page-card">
                                <div  id="pagger"></div> 
                            </div>



                        </div>
                    </div>
                </div>
            </div>  
        </div>
        <script>

            scrollWindow();

            // scrolls the window to auto load in middle of page 

            function scrollWindow() {
                window.scroll(0, 730);
            }

            pagging("pagger", 2,${requestScope.totalpage}, ${requestScope.pageindex}, '${requestScope.url}');

        </script>
        <jsp:include page="base/footer.jsp" /> 
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js " integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q " crossorigin="anonymous "></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js " integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl " crossorigin="anonymous "></script>
    </body>

</html>
