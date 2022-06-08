<%-- 
    Document   : header
    Created on : May 23, 2022, 8:25:07 AM
    Author     : pv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <div class="header-frist">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-7">
                            <div class="row">
                                <div class="col-md-4">
                                    <img src="${pageContext.request.contextPath}/images/header/logo-main.png" width="50px" height="50px" alt="" />
                                    <span class="name-banner">Edu-FCourse</span>
                                </div>
                                <div class="col-md-8">
                                    <ul class="nav">
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">Ask a Question<img src="${pageContext.request.contextPath}/images/header/ask.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">Course@gmail.com<img src="${pageContext.request.contextPath}/images/header/email.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <c:if test = "${sessionScope.user != null}">                                                         
                                <ul class="nav">
                                   <li class="nav-item"> 
                                    <a class="nav-link" href="${pageContext.request.contextPath}/myregistration">My Registration<img src="${pageContext.request.contextPath}/images/header/shopping-cart.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                   </li>
                                   <li class="nav-item"> 
                                    <a class="nav-link" href="${pageContext.request.contextPath}/mycourse">My Course<img src="${pageContext.request.contextPath}/images/header/online-course.png" style="margin-bottom: 6px; margin-left: 2px;" width="20px" height="20px" alt=""/></a>
                                   </li>       
                                    <li class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/user/profile">${sessionScope.user.fullName}<img src="${pageContext.request.contextPath}/images/header/icons8-user.png" style="margin-bottom: 8px;" width="20px" height="20px" alt=""/></a> 
                                    </li>   
                                    <li class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout<img src="${pageContext.request.contextPath}/images/header/icons8-logout-16.png" width="20px" style="margin-bottom: 6px;" height="20px" alt=""/></a>
                                    </li>
                                </ul>
                             </c:if>
                            <c:if test = "${sessionScope.user == null}">
                                <div style="display: flex; justify-content: flex-end">
                                    <img src="${pageContext.request.contextPath}/images/header/user.png" width="20px" height="20px" style="margin-top: 10px; margin-right: 5px" alt="" />
<!--                                    <a class=" btn btn-primary" href="${pageContext.request.contextPath}/login">Login</a>-->
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal-login">
                                        Login
                                    </button>
                                </div>
                            </c:if>
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
                                        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/course/list">Our courses</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/blog/list">Blogs</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">About us</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact</a>
                                    </li>
<!--                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/dashboard">Admin site(link tam)</a>
                                    </li>-->
                                </ul>
                                 <form class="form-inline" medthod="GET" action="${pageContext.servletContext.contextPath}/course/list"/>
                                    <input  class="form-control mr-sm-2" name="title" type="search" placeholder="Search Courses">
                                    <button class="btn btn-warning" type="submit">Search</button>
                                </form>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
                                    
<!--             login-->
             <div class="modal fade" id="myModal-login" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                 <div class="modal-dialog">
                     <div class="modal-content">
                         <div class="modal-header">
                             <h5 class="modal-title" id="exampleModalLabel">LOGIN</h5>
                         </div>
                         <div class="modal-body">
                             <form id ="validate-form-login" action="login" method="post">
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
                        <form id ="validate-form-sign-up" action="user/register" method="POST" >


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
    </body>
</html>
