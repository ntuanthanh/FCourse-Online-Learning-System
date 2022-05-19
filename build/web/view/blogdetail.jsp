<%-- 
    Document   : blogdetail
    Created on : May 19, 2022, 11:03:55 PM
    Author     : tuann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/98df298cac.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/blogdetail.css"/>
    <link rel="stylesheet" href="../css/header.css"/>
    <link rel="stylesheet" href="../css/home.css"/>
    <title>Blog Detail</title>
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
                                <a class="nav-link" href="#">NguyÃªÌn TuÃ¢Ìn ThaÌnh<img src="../images/header/icons8-user.png" style="margin-bottom: 8px;" width="20px" height="20px" alt=""/></a> 
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
    <div class="content">       
        <div class="image-detail"><img src="../images/blogdetail/blogdetail.png" alt="" style="width: 100%;"></div>
        <div class="grid">
            <div class="row">
                <div class="col-md-8 right" >
                    <div class="thurmbnail">
                        <img src="../images/blogdetail/thurmbnail.jpg"  alt="">
                    </div>
                    <div class="info">
                        <div class="day"><i class="fa-solid fa-calendar-days"></i> May 14 2022</div>
                        <div class="poster">Post by: Mr.A</div>
                    </div>
                    <div class="details">
                        <h1>Biden visits Japan, South Korea carrying warning to China
                        </h1>
                        <p>Biden departs for the five day trip on Thursday, after spending several months organizing allies to punish Russia for its invasion of Ukraine, which Moscow calls a "special operation."</p>

                        <p>He meets new South Korean President Yoon Suk-yeol in Seoul and Japanese Prime Minister Fumio Kishida in Tokyo, leaders who share anxieties about North Korea and China and are eager to build on their long alliances with Washington.</p>    

                        <p>"At its core this (trip) is about building out the alliance network in East Asia," in part to counter any Chinese actions against Taiwan, said Evan Medeiros, an Asia specialist in the Barack Obama administration.</p>
                    </div>
                    <div class="space"></div>
                    <div class="share">
                        <p>SHARE</p>
                        <a href=""><i class="fa-brands fa-facebook"></i></a>
                        <a href=""><i class="fa-brands fa-twitter"></i></a>
                        <a href=""><i class="fa-brands fa-google-plus"></i></a>
                    </div>
                </div>
                <div class="col-md-4 left" >
                    <div class="box-search">
                        <form action="#" class="search-box">
                            <input type="text" placeholder="Enter Searching..." style="width:80%" required>
                            <button type="submit" class="search-icon" style="background-color: #F18121; width: 35px;"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="recent-post">
                        <h3>Recent Post</h3>
                        <div class="post">
                            <img src="../images/blogdetail/thurmbnail.jpg" alt="" style="height: 70px; width: 100px;">
                            <a>WASHINGTON/SEOUL/TOKYO, May 19 (Reuters) - Joe Biden will visit Japan and South Korea on his first Asian trip as U.S. president, carrying a clear message to China, advisers and analysts say - don't try what Russia did in Ukraine anywhere in Asia, and especially not in Taiwan.</a>
                        </div>
                        <div class="post">
                            <img src="../images/blogdetail/thurmbnail.jpg" alt="" style="height: 70px; width: 100px;">
                            <a>WASHINGTON/SEOUL/TOKYO, May 19 (Reuters) - Joe Biden will visit Japan and South Korea on his first Asian trip as U.S. president, carrying a clear message to China, advisers and analysts say - don't try what Russia did in Ukraine anywhere in Asia, and especially not in Taiwan.</a>
                        </div>
                        <div class="post">
                            <img src="../images/blogdetail/thurmbnail.jpg" alt="" style="height: 70px; width: 100px;">
                            <a>WASHINGTON/SEOUL/TOKYO, May 19 (Reuters) - Joe Biden will visit Japan and South Korea on his first Asian trip as U.S. president, carrying a clear message to China, advisers and analysts say - don't try what Russia did in Ukraine anywhere in Asia, and especially not in Taiwan.</a>
                        </div>
                        <div class="post">
                            <img src="../images/blogdetail/thurmbnail.jpg" alt="" style="height: 70px; width: 100px;">
                            <a>WASHINGTON/SEOUL/TOKYO, May 19 (Reuters) - Joe Biden will visit Japan and South Korea on his first Asian trip as U.S. president, carrying a clear message to China, advisers and analysts say - don't try what Russia did in Ukraine anywhere in Asia, and especially not in Taiwan.</a>
                        </div>

                    </div>
                </div>
            </div>



        </div>
    </div>
    
    
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
</body>
</html>
