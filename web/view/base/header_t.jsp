<%-- 
    Document   : header_t
    Created on : Jun 8, 2022, 4:02:07 PM
    Author     : pv
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- header css -->
        <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css"/>      
    </head>
    <body>
        <!-- Header Top ==== -->
        <header class="header rs-nav">
            <div class="top-bar">
                <div class="container">
                    <div class="row d-flex justify-content-between">
                        <div class="topbar-left">
                            <ul>
                                <li><a href="faq-1.html"><i class="fa fa-question-circle"></i>Ask a Question</a></li>
                                <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>FCourse@edu.com</a></li>
                            </ul>
                        </div>
                        <div class="topbar-right">
                            <ul>
                                <c:if test = "${sessionScope.user != null}">
                                    <li><a href="${pageContext.request.contextPath}/myregistration">My Registration<img src="${pageContext.request.contextPath}/images/header/shopping-cart.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a></li>
                                    <li><a href="${pageContext.request.contextPath}/mycourse">My Course<img src="${pageContext.request.contextPath}/images/header/online-course.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a></li>
                                    <li><a href="${pageContext.request.contextPath}/user/profile">${sessionScope.user.fullName}<img src="${pageContext.request.contextPath}/images/header/icons8-user.png" style="margin-bottom: 8px;" width="20px" height="20px" alt=""/></a></li>
                                    <li><a href="${pageContext.request.contextPath}/logout">Logout<img src="${pageContext.request.contextPath}/images/header/icons8-logout-16.png" width="20px" style="margin-bottom: 6px;" height="20px" alt=""/></a></li>
                                </c:if>
                                <c:if test = "${sessionScope.user == null}">
                                    <img src="${pageContext.request.contextPath}/images/header/user.png" width="20px" height="20px" style="margin-top: 10px; margin-right: 5px" alt="" />
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal-login">
                                        Login
                                    </button>
                                </c:if> 
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="sticky-header navbar-expand-lg">
                <div class="menu-bar clearfix">
                    <div class="container clearfix">
                        <!-- Header Logo ==== -->
                        <div class="menu-logo">
                            <a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/images/header/logo-main2_1.png" alt=""></a>
                        </div>
                        <!-- Mobile Nav Button ==== -->
                        <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span></span>
                            <span></span>
                            <span></span>
                        </button>
                        <!-- Author Nav ==== -->
                        <div class="secondary-menu">
                            <div class="secondary-inner">
                                <ul>
                                    <li><a href="#" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
                                    <li><a href="#" class="btn-link"><i class="fa fa-linkedin"></i></a></li>
                                    <!-- Search Button ==== -->
                                    <li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>
                                </ul>
                            </div>
                        </div>
                        <!-- Search Box ==== -->
                        <div class="nav-search-bar">
                            <form action="#">
                                <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                                <span><i class="ti-search"></i></span>
                            </form>
                            <span id="search-remove"><i class="ti-close"></i></span>
                        </div>
<!--                         Navigation Menu ==== -->
                        <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                            <div class="menu-logo">
                                <a href="#"><img src="assets/images/logo.png" alt=""></a>
                            </div>
                            <ul class="nav navbar-nav">	
                                <li class="active"><a href="${pageContext.request.contextPath}/home">Home</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/course/list">Our Course</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/blog/list">Blogs</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/home">About us</a>
                                </li>
                                <li><a href="javascript:;">Contact <i class="fa fa-chevron-down"></i></a>
                                    <ul class="sub-menu">
                                        <li><a href="${pageContext.request.contextPath}/contact">Contact Link</a></li>
                                        <li><a href="#">Help</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <div class="nav-social-link">
                                <a href="javascript:;"><i class="fa fa-facebook"></i></a>
                                <a href="javascript:;"><i class="fa fa-google-plus"></i></a>
                                <a href="javascript:;"><i class="fa fa-linkedin"></i></a>
                            </div>
                        </div>
                        <!-- Navigation Menu END ==== -->
                    </div>
                </div>
            </div>
            <!--login-->
            <div class="modal fade" id="myModal-login" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">LOGIN</h5>
                        </div>
                        <div class="modal-body">
                            <form id ="validate-form-login" action="${pageContext.request.contextPath}/login" method="post">
                                <div class="alert-danger" role="alert">
                                    <p>${mess}</p>
                                </div>
                                <span id="errorlogin"></span>


                                <div class="form__input-group">
                                    <label for="username">Email: </label>
                                    <input type="text" class="form__input" name="email" id="email" > 
                                </div>
                                <div class="form__input-group">
                                    <label for="pass">Password: </label>
                                    <input type="password" class="form__input" name="password" id="password" > 
                                </div>
                                <p><input type="checkbox" value="remember" name="remember"/> Remember Me! </p>
                                <a href="${pageContext.request.contextPath}/reset/lostpassword">Forgot password?</a>


                                </a>
                                <div class = "edit-profile-submit" style = "display: flex; justify-content: center">
                                    <button class="btn btn-success" style="margin: auto;" type="submit">Login</button>
                                </div>                            

                                <div class="modal-footer d-block">
                                    <a href="#" data-target="#myModal-signup" data-toggle="modal" class="text-info" type="button">Do you have an account?Create Account</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
             <!--        Modal-->
             <div class="modal fade" id="myModal-signup" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                 <div class="modal-dialog modal-xl">
                     <div class="modal-content">
                         <div class="modal-header">
                             <h5 class="modal-title" id="exampleModalLabel">SIGN UP</h5>
                         </div>
                         <div class="modal-body">
                             <form id ="validate-form-sign-up" action="${pageContext.request.contextPath}/user/register" method="POST" >


                                 <input id="email" type="email" placeholder="Email" name="email" />
                                 <input id="fullname" type="text" placeholder="User" name="fullname" />
                                 <input id="password" type="password" placeholder="Password" name="password"/>
                                 <input id="phone" type="tel" placeholder="Phone" name="phone" />
                                 <br/>
                                 <div style="display: flex;">                     
                                     <input  style="width: 15px; margin-left: 20px; " type="radio" name="gender" value="male"/> Male   <br/>                            
                                     <input   style="width: 15px; margin-left: 50px; " type="radio" name="gender" value="female"/> Female <br/>
                                 </div>
                                 <div class = "edit-profile-submit" style ="display: flex; justify-content: center">
                                     <button class="btn btn-success" type="submit">SIGN UP</button>
                                 </div>

                             </form>
                         </div>
                     </div>
                 </div>
             </div>
            <script>
            var hidden = ${requestScope.alerterror};
            if (hidden <= 1) {
            $('#myModal-login').modal('show');
            }

            validate_form_login();
            validate_form_sign_up();
            </script>        
        </header>
        <!-- header END ==== -->
        
    </body>
</html>
