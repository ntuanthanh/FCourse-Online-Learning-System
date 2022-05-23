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
    <title>Blog Detail|Edu-FCourse</title>
</head>
<body>
    <!-- Header side -->
    <jsp:include page="base/header.jsp" />
    <!-- Content side -->
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
    <!-- footer side -->
    <jsp:include page="../view/base/footer.jsp" /> 
</body>
</html>
