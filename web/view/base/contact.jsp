<%@page import="model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact|Edu-FCourse</title>
        <link rel="stylesheet" href="../../css/contact.css"/>
        <link rel="stylesheet" href="css/blog.css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>

    <body>
        <!-- Header side -->
        <jsp:include page="../base/header.jsp" />     
        <!-- Slider side --> 
        <div class="container contact">
            <div class="row box">
                <div class="col-md-3">
                    <div class="contact-info">
                        <img src="../../images/contact/contact-image.png" alt=""/>
                        <h2>Contact Us</h2>
                        <h4>We would love to hear from you !</h4>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="contact-form">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="fname">First Name:</label>
                            <div class="col-sm-10">          
                                <input type="text" class="form-control" id="fname" placeholder="Enter First Name" name="fname">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="lname">Last Name:</label>
                            <div class="col-sm-10">          
                                <input type="text" class="form-control" id="lname" placeholder="Enter Last Name" name="lname">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="email">Email:</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="comment">Comment:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="5" id="comment"></textarea>
                            </div>
                        </div>
                        <div class="form-group">        
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Submit</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer side --> 
        <jsp:include page="../base/footer.jsp" /> 
    </body>

</html>
