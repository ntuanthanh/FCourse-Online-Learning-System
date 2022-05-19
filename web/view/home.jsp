<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
    <link href="../css/header.css" rel="stylesheet" type="text/css" />
     <link rel="stylesheet" href="../css/home.css"/>
</head>

<body>
    <header>
        <div class="header-frist">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-7">
                        <div class="row">
                            <div class="col-md-3">
                                <img src="../images/header/logo-main.png" width="50px" height="50px" alt="" />
                                <span class="name-banner">Edu-FCourse</span>
                            </div>
                            <div class="col-md-9">
                                <ul class="nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Ask a Question<img src="../images/header/ask.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Course@gmail.com<img src="../images/header/email.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <!--  Da login -->
                        <!--<ul class="nav">
                           <li class="nav-item"> 
                            <a class="nav-link" href="#">My Course<img src="../images/header/online-course.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                           </li>       
                            <li class="nav-item">
                                <a class="nav-link" href="#">Nguyễn Tuấn Thành<img src="../images/header/icons8-user.png" style="margin-bottom: 8px;" width="20px" height="20px" alt=""/></a> 
                            </li>   
                            <li class="nav-item">
                                <a class="nav-link" href="logout">Logout<img src="../images/header/icons8-logout-16.png" width="20px" style="margin-bottom: 6px;" height="20px" alt=""/></a>
                            </li>
                        </ul>-->
                        <!-- Chua login-->
                        <div style="display: flex; justify-content: flex-end">
                            <img src="../images/header/user.png" width="20px" height="20px" style="margin-top: 10px; margin-right: 5px" alt="" />
                            <a class=" btn btn-primary" href="login">Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row header-second">
                <div class="col-md-12">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                        <div class="collapse navbar-collapse" id="collapsibleNavbar">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item color-menu">
                                    <a class="nav-link" href="#">Home</a>
                                </li>
                                <li class="nav-item color-menu">
                                    <a class="nav-link" href="#">Our Courses</a>
                                </li>
                                <li class="nav-item color-menu">
                                    <a class="nav-link" href="#">Blogs</a>
                                </li>
                                <li class="nav-item color-menu">
                                    <a class="nav-link" href="#">About Us</a>
                                </li>
                                <li class="nav-item color-menu">
                                    <a class="nav-link" href="#">References</a>
                                </li>
                            </ul>
                            <form class="form-inline">
                                <input class="form-control mr-sm-2" placeholder="Search Courses">
                                <button class="btn btn-warning" type="submit">Search</button>
                            </form>
                        </div>
                    </nav>
                </div>
            </div>
        </div>     
    </header>
    <!-- Slider side -->
    <div class = "slider">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="../images/slider/slider1.jpg" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="../images/slider/slider2.jpg" alt="Second slide">
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
        <div>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active"><a href="#">Home</a></li>
                </ol>
            </nav>
        </div>
    </div>
    <!--Content side-->
    <div class = "content-main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 col-xs-3">
                    <h4 style="text-align: center; margin-bottom: 80px;">All Subject Category</h4>
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
                    <hr>
                    <h4 style="text-align: center;">Course Recent</h4>
                    <div class="course-recent">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="../images/courses/anh_course_temp.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-sm-8 recent">
                                <a href="#" class="title-recent">Course 1</a>
                                <p>99$</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="../images/courses/anh_course_temp.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-sm-8 recent">
                                <a href="#" class="title-recent">Course 2</a>
                                <p>99$</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="../images/courses/anh_course_temp.jpg" alt="">
                                </div>
                            </div>
                            <div class="col-sm-8 recent">
                                <a href="#" class="title-recent">Course 3</a>
                                <p>99$</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="img-recent">
                                    <img src="../images/courses/anh_course_temp.jpg" alt="">
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
                    <div class="row">
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
                    <hr>
                    <h2 class="title"> Featured Blog </h2>
                    <div class="row">
                        <div class="cards col-md-4 col-xs-6">
                            <div class="blog-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="../images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="#">aaaaa</a>
                                    </div>
                                    <p class="card-subject">author</p>

                                </div>
                            </div>
                        </div>
                        <div class="cards col-md-4 col-xs-6">
                            <div class="blog-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="../images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="#">aaaaa</a>
                                    </div>
                                    <p class="card-subject">author</p>

                                </div>
                            </div>
                        </div>
                        <div class="cards col-sm-4 col-xs-6">
                            <div class="blog-card">
                                <div class="card-infor">
                                    <div class="card-img">
                                        <img src="../images/courses/anh_course_temp.jpg" alt="">
                                    </div>
                                    <div class="card-title">
                                        <a href="#">aaaaa</a>
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
    <div class = "footer-side" style = "margin-top: 10px;">
        <footer>
        <div class="footer-top">
            <div class="row">
                <div class="col-md-4">
                    <img src="../images/header/logo-main.png" alt="">
                </div>
                <div class="col-md-4"></div>
                <div class="col-md-4 icon">
                    <a href=""><i class="fa-brands fa-facebook"></i></a>
                    <a href=""><i class="fa-brands fa-twitter"></i></a>
                    <a href=""><i class="fa-brands fa-google"></i></a>                 
                </div>
            </div>         
        </div>
        <div class="space"></div>
        <div class="footer-medium">
            <div class="row">
                <div class="col-sm-4">
                    <h4>introduction</h4>
                    <div class="clearfix">
                        <li><a href="">About Us</a></li>
                        <li><a href="">Policy</a></li>
                        <li><a href="">Contact</a></li>
                        <li><a href="">Rules</a></li>
                        
                    </div>  
                </div>
                <div class="col-sm-4">
                    <h4>Course</h4>
                    <div class="clearfix">
                        <li><a href="">New Course</a></li>
                        <li><a href="">Hot Course</a></li>
                        <li><a href="">Free Course</a></li>
                    </div>  
                </div>
                <div class="col-sm-4">
                    <h4>Contact</h4>
                    <div class="clearfix">
                        <li><a href="">Blog</a></li>
                        <li><a href="">Phone</a></li>
                        <li><a href="">Contact</a></li>
                        
                    </div>  
                </div>
            </div>    
        </div>
        <div class="space"></div>
        <div class="footer-bottom">
            <h4>@Copyright by group 4 FPT University</h4>
        </div>
    </footer>  
    </div>   
</body>

</html>