<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Detail|Edu-FCourse</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <a href="courseDetail.jsp"></a>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>


    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="css/courseDetail.css" rel="stylesheet" type="text/css"/>
    <link href="css/tagline.css" rel="stylesheet" type="text/css"/>
</head>

<body>

    <!-- Header side -->
    <jsp:include page="../view/base/header.jsp" /> 
    <div class="body">
        <!--Content course detail-->
        <div class="row text-center content-detail">
            <div class="col-lg-2 col-sm-12">
                <h4 class="category-subject" style="text-align: center; margin-bottom: 60px;">Subject Category</h4>
                <div class="scroll">
                    <c:forEach items="${requestScope.Categorys}" var="Category">
                        <div style="text-align: left; font-size: 20px; ">
                            <a href="course/list?cateId=${Category.categoryID}">${Category.value}</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-lg-8 col-sm-12">
                <h4 class="category-subject" style="text-align: center; margin-bottom: 60px;">Subject Category</h4>
                <a href="#">
                    <div class="card-img">
                        <img class="img " src="images/courses/${requestScope.Course.thumnailURL}" alt="First slide">
                    </div>
                </a>
                <div class="ttr-post-title ">
                    <h1 class="post-title">${requestScope.Course.title}</h1>
                    <h6 >
                        ${requestScope.Course.briefinfo}</h6>
                </div>
                <div>
                    <p>
                    <h4> About this Specialization</h4>
                    </p>
                    ${requestScope.Course.description}
                </div>
                <!--tagname-->
                <ul class="tag">

                    <c:forEach items="${requestScope.Course.tags}" var="tags">
                        <li class="tag-item" style="margin-bottom: 20px"><i>${tags.getTagname()}</i></li>
                            </c:forEach>
                </ul>

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
                            <h6 class="Tid">${t.topicOrder}</h6>
                            <h6 class="topicName">${t.topicName}</h6>
                        </div>
                        <div class="col-lg-9 col-sm-12 description">
                            <h6 class="td">${t.description}</h6>
                        </div>
                    </div>
                </c:forEach>
            </div>  
        </div>


        <div class="Course_list">
            <h4 class="category-subject" style="text-align: center;">Course List</h4>
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
            </div>
        </div>         

    </div>
    <!-- footer side -->
    <jsp:include page="../view/base/footer.jsp" />  

</body>

</html>