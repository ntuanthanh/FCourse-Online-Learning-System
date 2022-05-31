<%-- 
    Document   : send_reset_password
    Created on : May 30, 2022, 7:46:54 PM
    Author     : pv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <script src="../js/validationForm/validateForm.js" type="text/javascript"></script>
        <link href="../css/send_resetpassword.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class = "content-send-reset-password">
            <div class = "text-center">
                <img src="${pageContext.request.contextPath}/images/reset/padlock.png"/>
                <h2>Reset Password?</h2>
                <p>You can reset your password here.</p>
            </div>
            <form id = "validate-form-send-reset-password" action = "../reset/lostpassword" method="Post">
                <div class = "form-send-reset-password">
                    <div class = "form-group form-send-reset-password-item">
                        <input type="text" id = "email" class="form-control" name ="email" placeholder="Enter your email">
                    </div>
                </div>
                <c:if test = "${requestScope.err != null}">
                    <label class="error" for="email">${requestScope.err}</label>
                </c:if>
                <div class = "send-reset-password-profile-submit">
                    <button class="btn btn-primary" type="submit">Send</button>
                </div> 
            </form>
            <a style="text-decoration: none" href="../login">Login</a> 
            <span>/</span>
            <a style="text-decoration: none" href="../regiter">Register</a>
        </div>
        <script>
           validateSendResetPassword();
        </script> 
    </body>
</html>
