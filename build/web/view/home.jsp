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
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-xs-3">
                <h4 style="text-align: center; margin-bottom: 80px;">all course</h4>
                <div class="subject">
                    <a href="#">SE</a>
                </div>
                <div class="subject">
                    <a href="#">AI</a>
                </div>
                <div class="subject">
                    <a href="#">IA</a>
                </div>
                <div class="subject">
                    <a href="#">photo</a>
                </div>
                <div class="subject">
                    <a href="#">math    </a>

                </div>
                <hr>

                <h4 style="text-align: center;">course recent</h4>
                <div class="course-recent">

                    <div class="row">
                        <div class="col-sm-4">
                            <div class="img-recent">
                                <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
                            </div>
                        </div>
                        <div class="col-sm-8 recent">

                            <a href="#" class="title-recent">aaaaa</a>
                            <p>99$</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-9 col-xs-9">
                <h2 class="title">course</h2>
                <div class="row">
                    <div class="cards col-md-4 col-xs-6">
                        <div class="course-card">
                            <div class="card-infor">
                                <div class="card-img">
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
                                </div>

                                <div class="card-title">
                                    <a href="#">SWP</a>
                                </div>
                                <p class="card-subject">soft ware</p>
                                <p class="card-price">$99</p>
                            </div>
                        </div>
                    </div>
                    <div class="cards col-md-4 col-xs-6">
                        <div class="course-card">
                            <div class="card-infor">
                                <div class="card-img">
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
                                </div>
                                <div class="card-title">
                                    <a href="#">SWP</a>
                                </div>
                                <p class="card-subject">soft ware</p>
                                <p class="card-price">$99</p>
                            </div>
                        </div>
                    </div>
                    <div class="cards col-md-4 col-xs-6">
                        <div class="course-card ">
                            <div class="card-infor">
                                <div class="card-img">
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
                                </div>
                                <div class="card-title">
                                    <a href="#">SWP</a>
                                </div>
                                <p class="card-subject">soft ware</p>
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
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
                                </div>

                                <div class="card-title">
                                    <a href="#">SWP</a>
                                </div>
                                <p class="card-subject">soft ware</p>
                                <p class="card-price">$99</p>
                            </div>
                        </div>
                    </div>
                    <div class="cards col-md-4 col-xs-6">
                        <div class="course-card">
                            <div class="card-infor">
                                <div class="card-img">
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
                                </div>
                                <div class="card-title">
                                    <a href="#">SWP</a>
                                </div>
                                <p class="card-subject">soft ware</p>
                                <p class="card-price">$99</p>
                            </div>
                        </div>
                    </div>
                    <div class="cards col-md-4 col-xs-6">
                        <div class="course-card ">
                            <div class="card-infor">
                                <div class="card-img">
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
                                </div>
                                <div class="card-title">
                                    <a href="#">SWP</a>
                                </div>
                                <p class="card-subject">soft ware</p>
                                <p class="card-price">$99</p>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                <h2 class="title"> blog </h2>
                <div class="row">
                    <div class="cards col-md-4 col-xs-6">
                        <div class="blog-card">
                            <div class="card-infor">
                                <div class="card-img">
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
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
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
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
                                    <img src="free-online-course-on-learning-to-teach-online-1024x577.jpeg" alt="">
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
</body>

</html>