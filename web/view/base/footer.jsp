<%-- 
    Document   : footer
    Created on : May 23, 2022, 5:09:41 PM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            footer{
                background-color: black;
                color: aliceblue;
                text-align: center;
                list-style: none;
                padding-bottom: 100px;
            }
            footer a{
                text-decoration: none;
                color:aliceblue;

            }

            .footer-top img{
                height: 100px;
            }
            .footer-bottom h4{
                padding: 10px;
                font-size: medium;
            }

            .footer-container{
                height: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                font-size: larger;
                bottom: 0%;
            }
            .space{
                margin: 10px;
                width: 100%;
                height: 3px;
                background-color: aliceblue;
            }
            .footer-top a{
                justify-content: center;
            }    
            .icon a{
                font-size: 30px;
                margin-right: 10px;  
            }
            .icon{
                margin-top: 30px;
            }
        </style>
    </head>
    <body>
        <div class = "footer-side" style = "margin-top: 10px;">
            <footer>
                <div class="footer-top">
                    <div class="row">
                        <div class="col-md-4">
                            <img src="${pageContext.request.contextPath}/images/header/logo-main.png" alt="">
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
