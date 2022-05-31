<%-- 
    Document   : verify_user
    Created on : Jun 1, 2022, 12:40:09 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="layoutError">
            <div id="layoutError_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-6">
                                <div class="text-center mt-4">
                                    <h1 class="display-1">VERIFY SUCCESSFUL </h1>
                                    <p class="lead">Your account verify successfully</p>
                                    <p>Access to this resource to login</p>
                                    <a href="../login">
                                        <i class="fas fa-arrow-left me-1"></i>
                                        Return to Login
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutError_footer">
                
            </div>
        </div>
         <%--<jsp:include page="../base/footer.jsp" />--%> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
