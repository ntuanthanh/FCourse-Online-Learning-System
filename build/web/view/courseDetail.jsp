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
     <Style>
        .content-detail {
            margin: 3%;
        }

        .content-detail .carousel {
            margin: 1%;
        }
        #featuredsubjects{
            background-color: blanchedalmond;
            border: 10px;
            border-color: black;
        }
    </Style>
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
                            <a class=" btn btn-primary" href="../login">Login</a>
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
                                    <a class="nav-link" href="../home">Home</a>
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
                    <li class="breadcrumb-item"><a href="../home">Home</a></li>
                    <li class="breadcrumb-item active"><a href="#">Course Detail</a></li>
                </ol>
            </nav>
        </div>
    </div>
    <!--Content course detail-->
    <div class="row text-center content-detail">
        <div class="col-lg-8 col-sm-12">
            <a href="#">
                <div id="carouselExampleControls" class="carousel" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img class="d-block w-100" src="../images/courses/anh_course_temp.jpg" alt="First slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="../images/courses/anh_course_temp.jpg" alt="Second slide">
                        </div>
                        <div class="carousel-item">
                            <img class="d-block w-100" src="../images/courses/anh_course_temp.jpg" alt="Third slide">
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
            </a>
            <div class="ttr-post-title ">
                <h1 class="post-title">Project Management Principles and Practices</h1>
            </div>
            <div>
                <p>
                <div class="course-price text-center">

                    original price <del>$190</del>
                    <h4 class="price"> sale price $120</h4>
                </div>
                <div class="course-buy-now text-center">
                    <input type="button" value="Register This Courses">
                    <p>starting May 15</p>    

                </div>
                <h4> About this Specialization</h4>

                This specialization is a precursor to the Applied Project Management Certificate.
                Project management has been proven to be the most effective method of delivering products within cost,
                schedule, and resource constraints.
                This intensive and hands-on series of courses gives you the skills to ensure your projects are completed
                on time and on budget while giving the user the product they expect.
                You will gain a strong working knowledge of the basics of project management and be able to immediately
                use that knowledge to effectively manage work projects. At the end of
                the series you will be able to identify and manage the product scope, build a work breakdown structure,
                create a project plan, create the project budget, define and allocate
                resources, manage the project development, identify and manage risks, and understand the project
                procurement process.</p>
            </div>
        </div>
        <div class="col-lg-4 col-sm-12  " id="featuredsubjects">
            <h1>featured subjects</h1>

        </div>
    </div>
    <!-- footer side -->
    <div class = "footer-side" style = "margin-top: 10px;">
        <footer>
        <div class="footer-top">
            <div class="row">
                <div class="col-md-4">
                    <img src="images/header/logo-main.png" alt="">
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