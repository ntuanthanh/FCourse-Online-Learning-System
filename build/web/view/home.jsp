<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home|Edu-FCourse</title>
    <link rel="stylesheet" href="css/home.css"/>
</head>

<body>
    <!-- Header side -->
    <jsp:include page="../view/base/header.jsp" />     
    <!-- Slider side --> 
    <div class = "slider">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active test">
                    <img class="d-block w-100" src="images/slider/slider1.jpg" alt="First slide" style="height: 260px">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="images/slider/slider2.jpg" alt="Second slide" style="height: 260px">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <!-- Content side -->
    <div class = "content-main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 col-xs-3">
                    <h4 class="category-subject" style="text-align: center; margin-bottom: 60px;">Subject Category</h4>
                    <div class="list-category">
                        <div class="subject">
                            <a href="#">Software Engineering</a>
                        </div>
                        <div class="subject">
                            <a href="#">Digital Marketing</a>
                        </div>
                        <div class="subject">
                            <a href="#">Business</a>
                        </div>
                        <div class="subject">
                            <a href="#">Your Life</a>
                        </div>
                        <div class="subject">
                            <a href="#">Math</a>
                        </div>
                    </div>
                    <hr>
                    <h4 class="category-subject" style="text-align: center;">Course Recent</h4>
                    <div class="course-recent">
                        <div class="row list-course-recent">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="images/courses/anh_course_temp.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-sm-8 recent">
                                <a href="#" class="title-recent">Course 1</a>
                                <p>99$</p>
                            </div>
                        </div>
                        <div class="row list-course-recent">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="images/courses/anh_course_temp.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-sm-8 recent">
                                <a href="#" class="title-recent">Course 2</a>
                                <p>99$</p>
                            </div>
                        </div>
                        <div class="row list-course-recent">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="images/courses/anh_course_temp.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-sm-8 recent">
                                <a href="#" class="title-recent">Course 3</a>
                                <p>99$</p>
                            </div>
                        </div>
                        <div class="row list-course-recent">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="images/courses/anh_course_temp.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-sm-8 recent">
                                <a href="#" class="title-recent">Course 4</a>
                                <p>99$</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-9 col-xs-9">
                    <h2 class="title">Featured Course</h2>
                    <div class="row">
                        <div class="cards col-md-4 col-xs-6">
                            <div class="course-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>

                                    <div class="card-title">
                                        <a href="course/detail">SWP</a>
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
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="course/detail">SWP</a>
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
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="course/detail">SWP</a>
                                    </div>
                                    <p class="card-subject">Soft Ware</p>
                                    <p class="card-price">$99</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="cards col-md-4 col-xs-6">
                            <div class="course-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>

                                    <div class="card-title">
                                        <a href="course/detail">SWP</a>
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
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="course/detail">SWP</a>
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
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="course/detail">SWP</a>
                                    </div>
                                    <p class="card-subject">Soft Ware</p>
                                    <p class="card-price">$99</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <h2 class="title"> Featured Blog </h2>
                    <div class="row">
                        <div class="cards col-md-4 col-xs-6">
                            <div class="blog-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="blog/detail">aaaaa</a>
                                    </div>
                                    <p class="card-subject">author</p>

                                </div>
                            </div>
                        </div>
                        <div class="cards col-md-4 col-xs-6">
                            <div class="blog-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="blog/detail">aaaaa</a>
                                    </div>
                                    <p class="card-subject">author</p>

                                </div>
                            </div>
                        </div>
                        <div class="cards col-sm-4 col-xs-6">
                            <div class="blog-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="blog/detail">aaaaa</a>
                                    </div>
                                    <p class="card-subject">author</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer side --> 
    <jsp:include page="base/footer.jsp" /> 
</body>

</html>