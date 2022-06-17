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
    <link rel="stylesheet" type="text/css" href="css/registerCourse.css">
    <style>
        .bttn{
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }



        /* CSS */
        .button36 {
            background-image: linear-gradient(92.88deg, #455EB5 9.16%, #5643CC 43.89%, #673FD7 64.72%);
            border-radius: 8px;
            border-style: none;
            box-sizing: border-box;
            color: #FFFFFF;
            cursor: pointer;
            flex-shrink: 0;
            font-family: "Inter UI","SF Pro Display",-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,Oxygen,Ubuntu,Cantarell,"Open Sans","Helvetica Neue",sans-serif;
            font-size: 16px;
            font-weight: 500;
            height: 2.5rem;
            padding: 0 1rem;
            text-align: center;
            text-shadow: rgba(0, 0, 0, 0.25) 0 3px 8px;
            transition: all .5s;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
        }

        .button36:hover {
            box-shadow: rgba(80, 63, 205, 0.5) 0 1px 30px;
            transition-duration: .1s;
        }

        @media (min-width: 768px) {
            .button36 {
                padding: 0 2.6rem;
            }
        }
    </style>
</head>

<body id="bg">
    <div class="page-wraper">
        <!-- Header side -->
        <jsp:include page="../view/base/header_t.jsp" /> 
        <!-- inner page banner -->
        <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner2.jpg);">
            <div class="container">
                <div class="page-banner-entry">
                    <h1 class="text-white">Courses Details</h1>
                </div>
            </div>
        </div>
        <div class="body">
            <!--Content course detail-->
            <div class="row text-center content-detail">
                <div class="col-lg-2 col-sm-12">
                    <div class="widget courses-search-bx placeani">
                        <div class="form-group">
                            <div class="input-group">
                                <h4>Search Courses</h4>

                                <input   type="text" name="title"  value="${requestScope.title}" >
                            </div>
                        </div>
                    </div>
                    <div class="widget widget_archive" style="margin-bottom: 10px">
                        <h5 class="widget-title style-1">category</h5>
                        <ul>


                            <c:set var="cates" value="${requestScope.cates}"  />
                            <c:forEach items="${requestScope.pCates}" var="p">
                                <li><a data-toggle="collapse" data-target="#demo-${p.id}">${p.name}<i class="ti-angle-down"></i></a></li>
                                <div id="demo-${p.id}" class="collapse">
                                    <ul>
                                        <c:forEach begin="0" end="${p.categories.size()-1}" var="i" >
                                            <li>
                                                <div class="cate-card">
                                                    <label class="cate-item">
                                                        <input   type="checkbox" name="cateId" value="${p.categories.get(i).getCategoryID()}"><span>${p.categories.get(i).getValue()}</span>
                                                    </label>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-8 col-sm-12">
                    <a href="#">
                        <div class="card-img">
                            <img class="img " src="images/courses/${requestScope.Course.thumnailURL}" alt="First slide">
                        </div>
                    </a>
                    <div class="ttr-post-title ">
                        <h1 class="post-title">${requestScope.Course.title}</h1>
                        <h7 >
                            ${requestScope.Course.briefinfo}</h7>
                    </div>
                    <div>
                        <h7>About this Specialization</h7> 
                        <h7>${requestScope.Course.description}</h7>
                    </div>
                    <!--tagname-->
                    <ul class="tag">
                        <c:forEach items="${requestScope.Course.tags}" var="tags">
                            <li class="tag-item" style="margin-bottom: 20px"><i>${tags.getTagname()}</i></li>
                                </c:forEach>
                    </ul>

                </div>
                <div class="col-lg-2 col-sm-12  " id="featuredsubjects">
                    <div class="course-price text-center"><br>
                        original price <del>$${requestScope.PricePackes.get(0).listPrice} </del>
                        <h5> $${requestScope.PricePackes.get(0).salePrice}/month</h5>
                        <br>
                        <h6>When you subscribe you'll get access to:</h6>

                        <h7>Practice material,graded assignments, discussion forums,
                            graded assignments, discussion forums, presentations,
                            debates, tests, review assignment  and more.
                            Certificates to share on your resume, Linkedin, or CV. 
                            24/7 customer support 
                            and Easy cancellation</h7>
                    </div><br>
                    <div >
                        <div class="course-buy-now text-center">

                            <button class="btn radius-xl text-uppercase" style="background-color: #0062cc; color: #ffffff" 
                                    data-toggle="modal" data-target="#myModal-course" > Buy This Courses</button>
                        </div>
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
                                <h7 class="td" >${t.description}</h7>
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
        <div class="modal fade" id="myModal-course">
            <div style="max-width: 1000px"class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="row">
                        <c:forEach items="${PricePackes}" var="price">
                            <div class="col-lg-4">
                                <div class="columns">
                                    <ul class="price">
                                        <li class="header">${price.name}</li>
                                        <li class="grey">duration ${price.duration} month</li>

                                        <li><del>${price.listPrice}</del></li>
                                        <li>${price.salePrice}</li>
                                            <c:if test = "${sessionScope.user != null}">
                                            <li class="grey bttn">  
                                                
                                                <form method="POST" action="course/register">
                                                    <input type="hidden" name="courseid" value="${requestScope.Course.courseId}">
                                                    <input type="hidden" name="userid" value="${sessionScope.user.id}">
                                                    <input type="hidden" name="priceid" value="${price.id}">
                                                    <input  type="submit" value="register">
                                                </form> 
                                            </li>  
                                        </c:if>
                                        <c:if test = "${sessionScope.user == null}">

                                            <li class="grey bttn">  
                                                <button  data-toggle="modal" data-target="#myModal-login" class="button36">login</button>

                                            </li>    
                                        </c:if>    

                                    </ul>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer col-12">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer side -->
    <jsp:include page="../view/base/footer.jsp" />  

</body>

</html>