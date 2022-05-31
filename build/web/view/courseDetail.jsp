<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Detail|Edu-FCourse</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../css/home.css"/>

        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <link href="css/courseDetail.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>

        <!-- Header side -->
        <jsp:include page="../view/base/header.jsp" /> 
        <div class="body">
            <!--Content course detail-->
            <div class="row text-center content-detail">
                <div class="col-lg-2 col-sm-12">
                    <h4 style="text-align: center; margin: 5%;">All Subject Category</h4>
                    <div class="scroll">
                        <c:forEach items="${requestScope.Categorys}" var="Category">
                            <div class="subject">
                                <a href="#">${Category.value}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-8 col-sm-12">
                    <a href="#">
                        <div >
                            <img class="img " src="images/courses/${requestScope.Course.thumnailURL}" alt="First slide">
                        </div>
                    </a>
                    <div class="ttr-post-title ">
                        <h1 class="post-title">${requestScope.Course.title}</h1>
                        
                    </div>
                    <div>
                        <p>
                            <h5>${requestScope.Course.tagline}</h5>
                        <h4> About this Specialization</h4>
                        ${requestScope.Course.briefinfo}
                        </p>
                    </div>
                </div>
                <div class="col-lg-2 col-sm-12  " id="featuredsubjects">
                    <div class="course-price text-center"><br><br>
                        original price <del>$${requestScope.PricePackes.get(0).listPrice} </del>
                        <h4 class="price"> $${requestScope.PricePackes.get(0).salePrice} 
                            per month</h4><br><br>
                        <h6>When you subscribe you'll get access to:</h6>
                        <br>
                        <h7>Practice material,graded assignments, discussion forums and more.
                            Certificates to share on your resume, Linkedin, or CV. 
                            24/7 customer support 
                            and Easy cancellation</h7>
                    </div><br>
                    <div class="course-buy-now text-center">
                        <input type="button" value="Register This Courses" class="test">
                        <p><br>Start ${requestScope.now}</p>    
                    </div>
                </div>
            </div>

            <div class="description ">
                <h2 class="text-center Courses_Specialization ">There are ${requestScope.Topics.size()} 
                    Courses in this Specialization</h2>
                <div class="scroll">      
                    <c:forEach items="${requestScope.Topics}" var="t">
                        <div class="row text-center ">
                            <div class="col-lg-3 col-sm-12 text-center nametopic">
                                <h6 class="Tid">${t.id}</h6>
                                <h6 class="topicName">${t.topicName}</h6>
                            </div>
                            <div class="col-lg-9 col-sm-12 description">
                                <h6 class="td">${t.description}</h6>
                            </div>
                        </div>
                    </c:forEach>
                </div>  
            </div>

            <h1 class="text-center content-detail description">featured subjects</h1> 
            <div class="row ">

                <div class="cards col-md-4 col-xs-6">
                    <div class="course-card">
                        <div class="card-infor">
                            <div class="card-img">
                                <img src="../images/courses/anh_course_temp.jpg" alt="">

                            </div>

                            <div class="card-title">
                                <a href="#">SWP</a>
                            </div>
                            <p class="card-subject">Soft Ware</p>
                            <p class="card-price">$99</p>
                        </div>
                    </div>
                </div>
                <div class="cards col-md-4 col-xs-6">
                    <div class="course-card">
                        <div class="card-infor">
                            <div class="card-img">
                                <img src="../images/courses/anh_course_temp.jpg" alt="">
                            </div>
                            <div class="card-title">
                                <a href="#">SWP</a>
                            </div>
                            <p class="card-subject">Soft Ware</p>
                            <p class="card-price">$99</p>
                        </div>
                    </div>
                </div>
                <div class="cards col-md-4 col-xs-6">
                    <div class="course-card ">
                        <div class="card-infor">
                            <div class="card-img">
                                <img src="../images/courses/anh_course_temp.jpg" alt="">
                            </div>
                            <div class="card-title">
                                <a href="#">SWP</a>
                            </div>
                            <p class="card-subject">Soft Ware</p>
                            <p class="card-price">$99</p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- footer side -->
        <jsp:include page="../view/base/footer.jsp" />  

    </body>

</html>