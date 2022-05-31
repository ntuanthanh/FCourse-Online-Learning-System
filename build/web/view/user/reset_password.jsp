<%-- 
    Document   : reset_password
    Created on : May 31, 2022, 2:29:01 PM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recover Password</title>
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
            <div class="text-center">
                <img src="${pageContext.request.contextPath}/images/reset/padlock.png"/>
                <h2>Reset Password?</h2>
            </div>
            <form id = "validate-form-reset-password" action = "recoverpassword" method="Post">
                <div class = "form-send-reset-password">
                    <input type="text" name ="resetToken" value="${requestScope.resetToken}" hidden = "hidden"/>
                    <div class = "form-group form-send-reset-password-item">
                       <label for="password">Password</label>
                       <input type="password" id = "password" class="form-control" name ="password" placeholder="Enter new password">
                    </div>
                </div>
                <div class = "form-send-reset-password">
                    <div class = "form-group form-send-reset-password-item">
                       <label for="confirm_password">Confirm password</label>
                       <input type="password" id = "confirm_password" class="form-control" name ="confirm_password" placeholder="Confirm password">
                    </div>
                </div>
                <div class = "send-reset-password-profile-submit">
                    <button class="btn btn-primary" type="submit">Send</button>
                </div> 
            </form>
            <a style="text-decoration: none" href="../login">Login</a> 
            <span>/</span>
            <a style="text-decoration: none" href="../login">Register</a>
        </div>
        <script>
           validateResetPassword();
        </script> 
    </body>
</html>
