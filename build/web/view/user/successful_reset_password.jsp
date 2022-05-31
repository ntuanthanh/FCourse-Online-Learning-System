<%-- 
    Document   : successful_reset_password
    Created on : May 31, 2022, 7:47:33 PM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="../css/send_resetpassword.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class = "content-send-reset-password">
            <div class = "text-center">
                <img src="${pageContext.request.contextPath}/images/reset/padlock.png"/>
                <c:if test = "${requestScope.mess_header != null}">
                    <h2 style="color : green !important">${requestScope.mess_header}</h2>
                    <p>${requestScope.mess_main}</p>
                </c:if>
            </div>
                <%
                  String mess_header = (String)request.getAttribute("mess_header");
                  if(mess_header.equals("Reset Password Successfully")){ %>
                    <div class = "send-reset-password-profile-submit">
                        <button class="btn btn-primary" onclick ="FLogin()">Login Here</button>
                    </div>
                <%}
                %>
                <%
                  if(!mess_header.equals("Reset Password Successfully")){ %>
                    <a style="text-decoration: none" href="../login">Login</a> 
                    <span>/</span>
                    <a style="text-decoration: none" href="../regiter">Register</a>
                <%}
                %>
        </div>
        <script>
            function FLogin(){
                location.href = "${pageContext.request.contextPath}/login";
            }
        </script>
    </body>
</html>
