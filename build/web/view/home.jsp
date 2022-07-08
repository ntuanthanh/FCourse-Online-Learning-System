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

        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <link href="css/slider.css" rel="stylesheet" type="text/css"/>
        <noscript>
        <link rel="stylesheet" type="text/css" href="css/nojs.css" />
        </noscript>
        <!--        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
                <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Oswald:700|Montserrat:700'>-->
        <%
            ArrayList<Course> coursesSlider = (ArrayList<Course>) request.getAttribute("coursesSlider");
        %>
        <style>
            .da-img img{
                height: 256px;
                width: 256px;
                object-fit: cover;
            }
            .action-box img{

                height: 150px;
                object-fit:cover;
            }
            .title-course{
                height: 60px;
            }
            .text-center{
                text-align: left;
                font-weight: 500;
                height: 100px;
                font-size: 110%;

                padding: 0px 5px;
                display: -webkit-box;
                -webkit-line-clamp: 2;
                -webkit-box-orient: vertical;
                overflow: hidden;
            }
            .recent-post img{
                width: 100px;
                height: 100px;
                object-fit:cover;
            }
            .register:hover {
                color:white;
                background-color: purple: 
            }
            .register{
                color:white;
                background-color: orange; 
            }
            .card-feature{
                height: 50px;
            }
            .card-price > del{
                display: inline-block;
            }
        </style>
        <!-- Nhung Alert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="sweetalert2.all.min.js"></script>
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css"> 
        <script src="/summer2022-se1616-g4/js/validationForm/validateForm.js" type="text/javascript"></script>
    </head>

    <body id="bg">
        <jsp:include page="../view/base/header_t.jsp" />
        <!-- SLIDER-->
        <div id="da-slider" class="da-slider">
            <div class="da-slide">
                <h2>AI Blogs</h2>
                <p>Artificial intelligence (AI) is a wide-ranging branch of computer science concerned with building smart machines capable of performing tasks that typically require human intelligence. See AI blogs now</p>
                <a href="#" class="da-link">Read More</a>
                <div class="da-img"><img src="images/slider/1.png" alt="image01" /></div>
            </div>
            <div class="da-slide">
                <h2>How to save money</h2>
                <p>Sometimes the hardest thing about saving money is just getting started. This step-by-step guide can help you develop a simple and realistic strategy, so that you can save for all your short- and long-term goals.</p>
                <a href="#" class="da-link">Read more</a>
                <div class="da-img"><img src="images/slider/3.png" alt="image01"  /></div>
            </div>
            <div class="da-slide">
                <h2>How to learn Math fast</h2>
                <p>Many people struggle with math. It tends to be one of the most common subjects that people have trouble with. But with the right training, practice and effort, it can become easier. For those who want to learn how to be good at math, it may require extra practice. Here are a few best practices to learn math fast.</p>
                <a href="#" class="da-link">Read more</a>
                <div class="da-img"><img src="images/slider/2.png" alt="image01" /></div>
            </div>
            <div class="da-slide">
                <h2>What is the internet of things?</h2>
                <p>The internet of things, or IoT, is a system of interrelated computing devices, mechanical and digital machines, objects, animals or people that are provided with unique identifiers (UIDs) and the ability to transfer data over a network without requiring human-to-human or human-to-computer interaction.</p>
                <a href="#" class="da-link">Read more</a>
                <div class="da-img"><img src="images/slider/4.png" alt="image01" /></div>
            </div>
            <nav class="da-arrows">
                <span class="da-arrows-prev"></span>
                <span class="da-arrows-next"></span>
            </nav>
        </div>

        <!-- SLIDER END-->
        <div class="content-block">
            <!-- About Us -->
            <div class="section-area section-sp1">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                            <h4>LATEST POST</h4>
                            <c:forEach items="${requestScope.blognews}" var="b">
                                <div class="recent-post">
                                    <img src="images/blogdetail/${b.thumbnail}" alt=""/>
                                    <div>
                                        <h5>${b.title}</h5>
                                        <p>${b.brief}</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col-lg-9 col-md-8 col-sm-12">
                            <h4 class="title-home">Featured Courses</h4>
                            <div class="row">
                                <c:forEach items="${requestScope.courses}" var="course" >
                                    <div class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                        <div class="cours-bx">
                                            <div class="action-box">
                                                <img  src="images/courses/${course.thumnailURL}" alt="">
                                                <a href="#" class="btn register">resgister</a>
                                            </div>
                                            <div class="info-bx text-center">
                                                <div class="title-course"> <h5><a href="../coursedetail?id=${course.courseId}">${course.title}</a></h5></div>
                                                <span>${course.category.value}</span>

                                                <!--                                                <ul class="tag">
                                                <c:forEach items="${course.getTags()}" var="tag">

                                                     <li class="tag-item"  style="margin-bottom: 20px"><a href="list?tagId=${tag.tagId}">${tag.getTagname()}</a></li>
                                                </c:forEach>
                                            </ul>-->
                                            </div>
                                            <div class="cours-more-info card-feature">
                                                <div class="review">
                                                    <span>Feature</span>

                                                </div>
                                                <div class="card-price">
                                                    <c:if test="${course.pricePackage.size()>0}">
                                                        <del>$${course.pricePackage[0].listPrice}</del>

                                                        <h5>$${course.pricePackage[0].salePrice}</h5>
                                                    </c:if>  
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>



                            </div>
                            <h4 class="title-home">Hot Posts</h4>
                            <div class="row">
                                <c:forEach items="${requestScope.blogs}" var="b">
                                    <div class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                        <div class="cours-bx">
                                            <div class="action-box">
                                                <img src="images/blogdetail/${b.thumbnail}" alt=""/>
                                                <a  href="blog/detail?bid=${b.id}" class="btn register">See Now</a>
                                            </div>
                                            <div class="info-bx text-center">
                                                <div class="title-course"> <h5><a href="../coursedetail?id=${course.courseId}">${b.title}</a></h5></div>

                                            </div>
                                            <div class="cours-more-info">
                                                <div class="info-blog">
                                                    <p><i class="fa fa-calendar"></i> ${b.createdate} | <i class="fa fa-user"></i>${b.user.fullName}</p>
                                                </div>
                                                <!--                                                    <div class="review">
                                                                                        </div>-->
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>                   

                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- contact area END -->    
    </div>
</div>
<!-- footer side --> 
<jsp:include page="base/footer_t.jsp" />

<!--    <script src="../js/slider.js" type="text/javascript"></script>-->
<div class="page-wraper">

    <!-- Header Top ==== -->

    <!-- header END ==== -->
    <!-- Content -->

    <!-- inner page banner -->






</div>
<!-- Content END-->

<!-- scroll top button -->

</div>
<!-- External JavaScripts -->

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
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.cslider.js"></script>
<script type="text/javascript">
    <c:if test="${sessionScope.quizHandle_mess!=null}">
                Swal.fire(
                    'Submit successfully',
                    'Submit successfully ',
                    'success'
                          )
                <% request.getSession().setAttribute("quizHandle_mess", null); %>
            </c:if>
    $(function () {

        $('#da-slider').cslider({
            autoplay: true,
            bgincrement: 450
        });

    });
</script>
<script type="text/javascript" src="js/modernizr.custom.28468.js"></script>
</body>

</html>