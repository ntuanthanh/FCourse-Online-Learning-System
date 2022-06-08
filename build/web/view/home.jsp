<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home|Edu-FCourse</title>
        <link rel="stylesheet" href="css/home.css"/>
        <link rel="stylesheet" href="css/blog.css"/>
        <link rel="stylesheet" href="css/tagline.css"/>
        <%
            ArrayList<Course> coursesSlider = (ArrayList<Course>) request.getAttribute("coursesSlider");
        %>
    </head>

    <body>
        <!-- Header side -->
        <jsp:include page="../view/base/header_t.jsp" />     
        <!-- Slider side --> 
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
                            <img class="d-block w-100" src="images/courses/<%=c.getThumnailURL()%>" alt="" >
                            <div class="carousel-caption d-none d-md-block">
                                <h5><%=c.getTitle()%></h5>
                            </div>
                        </a>
                    </div>        
                    <%}%>
                    <%if (i != 0) {%>
                    <div class="carousel-item">
                        <a href="#">
                            <img class="d-block w-100" src="images/courses/<%=c.getThumnailURL()%>" alt="" >
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
        <!-- Content side -->
        <div class = "content-main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3 col-12">
                        <h4 class="category-subject" style="text-align: center; margin-bottom: 60px;">Subject Category</h4>
                        <div class="list-category">
                            <c:forEach items="${requestScope.cates}" var="cate">
                                <div >
                                    <a href="course/list?cateId=${cate.categoryID}">${cate.value}</a>
                                </div>
                            </c:forEach>


                        </div>
                        <hr>
                        <h4 class="category-subject" style="text-align: center;">most prominent</h4>
                        <div class="course-recent">
                            

                                <c:forEach items="${requestScope.coursesProminent}" var="c">
                                    <div class="row list-course-recent">
                                    <div class="col-md-4 col-3 recent">
                                        <div class="img-recent">
                                            <img src="images/courses/${c.thumnailURL}" alt="">
                                        </div>
                                    </div>
                                    <div class="col-md-8 col-3 recent">
                                        <div class="title-recent"><a href="#">${c.title}</a></div>
                                        <p>$${c.pricePackage[0].salePrice}</p>
                                    </div>
                                    </div>

                                </c:forEach>
                            
                        </div>
                    </div>
                    <div class="col-md-9 col-12">
                        <h2 class="title">Featured Course</h2>
                        <div class="row">
                            <c:forEach items="${requestScope.courses}" var="course">
                                <div class="cards col-xl-4 col-sm-6 col-12">
                                    <div class="course-card">
                                        <div class="card-infor">
                                            <div class="card-img">
                                                <img src="images/courses/${course.thumnailURL}" alt="">
                                                <div class="button">
                                                    <button class="resgiter-card" onclick="alert('Hello world!')">register</button>
                                                </div>
                                                <c:if test ="${course.feature}">
                                                    <div class="feature-card">hot</div>
                                                </c:if>
                                                <div class="category-card">${course.category.value}</div>
                                            </div>

                                            <div class="card-title">
                                                <a href="coursedetail?id=${course.courseId}">${course.title}</a>
                                            </div>
                                            <div class="card-price row">
                                                <div class="sale-price col-md-6  col-sm-6 col-6"><span>${course.pricePackage[0].salePrice}</span></div>
                                                <div class="list-price col-md-6  col-sm-6 col-6"><span>${course.pricePackage[0].listPrice}</span></div>

                                            </div>
                                            <ul class="tag">
                                              
                                                <c:forEach items="${course.getTags()}" var="tag">
                                                    <li class="tag-item" style="margin-bottom: 20px"><a href="course/list?tagId=${tag.tagId}">${tag.getTagname()}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>
                            <div class="col-12 show">
                                <a href="course/list"> show more</a> 
                            </div>
                            <hr>
                            <h2 class="title col-12"> Featured Blog </h2>

                            <c:forEach items="${requestScope.blogs}" var="b">
                                <div class="cards col-xl-4 col-sm-6 col-12">
                                    <div class="blog-card">
                                        <div class="blog-infor">
                                            <div class="blog-img">
                                                <img src="images/blogdetail/${b.thumbnail}" alt="">
                                                <div class="category-card">${b.category.value}</div>
                                            </div>
                                            <div class="blog-title">
                                                <a href="blog/detail?bid=${b.id}">${b.title}</a>

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


                            <div class="col-12 show">
                                <a href="#"> show more</a> 
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!-- footer side --> 
            <jsp:include page="base/footer_t.jsp" /> 
    </body>

</html>