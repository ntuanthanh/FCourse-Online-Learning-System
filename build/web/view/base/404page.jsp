<%-- 
    Document   : 404page
    Created on : May 31, 2022, 3:25:58 PM
    Author     : pv
--%>

<!-- W3hubs.com - Download Free Responsive Website Layout Templates designed on HTML5 CSS3,Bootstrap which are 100% Mobile friendly. w3Hubs all Layouts are responsive cross browser supported, best quality world class designs. -->
<!DOCTYPE html>
<html>
    <head>
        <title>404 Error Page In Bootstrap 4</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style type="text/css">
            @import url('https://fonts.googleapis.com/css?family=Sniglet:400,800');
            body{
                background: #95A5A6;
                font-family: 'Sniglet', cursive;
            }
            h1{
                text-align: center;
                font-size: 190px;
                font-weight: 400;
                margin: 0;
            }
            .fa{
                font-size: 120px;
                text-align: center;
                display: block;
                padding-top: 50px;
                margin: 0 auto;
                color: #A93226;
            }
            #error p{
                text-align: center;
                font-size: 36px;
                color: #4A235A;
            }
            a.back{
                text-align: center;
                margin: 0 auto;
                display: block;
                text-decoration: none;
                font-size: 24px;
                background: #BA4A00;
                border-radius: 10px;
                width: 10%;
                padding: 4px;
                color: #fff; 

            }
            @media(max-width: 550px){
                a.back{
                    width: 20%;
                }
            }
            @media(max-width: 425px){
                h1{
                    padding-top: 20px;
                }
                .fa{
                    padding-top: 100px;
                }
            }
        </style>
    </head>
    <body>
        <section id="error">
            <div class="content">
                <i class="fa fa-warning"></i>
                <h1>404</h1>
                <p>Error occurred! - Link not Found</p>
                <!-- If there are more message, show them here -->
                <c:if test="${requestScope.err != null || requestScope.err != ""}">
                   <p>${requestScope.err}</p>
                </c:if>
<!--                <a class="back" href="${pageContext.request.contextPath}/home">Home</a>-->
            </div>
        </section>
    </body>
</html>