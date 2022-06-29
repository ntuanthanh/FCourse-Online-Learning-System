<%-- 
    Document   : LessonDetail
    Created on : Jun 22, 2022, 11:15:11 PM
    Author     : thand
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lesson Detail</title>
        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="view/admin/assets/images/favicon.png" />

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="view/admin/assets/css/assets.css"/>
        <link rel="stylesheet" type="text/css" href="view/admin/assets/vendors/calendar/fullcalendar.css"/>

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css"/>

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="view/admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="view/admin/assets/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="view/admin/assets/css/dashboard.css"/>
        <link class="skin" rel="stylesheet" type="text/css" href="view/admin/assets/css/color/color-1.css"/>
        <script src="js/ImgPreview/imgPreview.js" type="text/javascript"></script>
        <script src="//cdn.ckeditor.com/4.19.0/basic/ckeditor.js"></script>
        <Style>
            .abc {
                padding: 0% 2% 3% 2%;
            }

            .Lesson {
                margin-bottom: 0%;
                padding-left: 2%;
            }

        </Style>

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar" >
        <jsp:include page="../../view/admin/header_admin.jsp" />
        <main class="ttr-wrapper">
            
            <div>
                <h2 class="Lesson">Lesson Details</h2>
            </div>
            <form action="LessonDetail" method="POST" id="form">
                <c:if test="${requestScope.Lesson != null}">
                    <input hidden name="Lid" value="${requestScope.Lesson.getId()}">
                </c:if>
                <div class="row" style="margin: 0%;">
                    <div class="col-lg-8  col-sm-12 abc">
                        Name <br>

                        <input type="text" id="name" name="name" 
                               <c:if test="${requestScope.Lesson!=null}">
                                   value="${requestScope.Lesson.lessonname}"
                               </c:if>
                               style=" width: 90%;" required="required" >
                        <br><br>
                        Topic <br>
                        <select name="topicid" style = "width: 90%;">
                            <c:forEach items="${requestScope.Topics}" var="t">
                                <option 
                                    ${(t.getId()==requestScope.Lesson.topicid)?"selected=\"selected\"":""}
                                    value="${t.id}">${t.topicName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-lg-4  col-sm-12 abc">
                        <span>Type </span><br>
                        <select name="selecttype" id="selecttype" style="width: 90%;">

                            <option id="Lesson" value="Lesson"
                                    <c:if test="${(requestScope.Lesson!=null)}">
                                        ${("Lesson"==requestScope.Lesson.getLessonType())?"selected=\"selected\"":""}
                                    </c:if>
                                    >Lesson</option>
                            <option id="Topic" value="Subject Topic"
                                    <c:if test="${(requestScope.Lesson!=null)}">
                                        ${("Subject Topic"==requestScope.Lesson.getLessonType())?"selected=\"selected\"":""}
                                    </c:if>
                                    >Subject Topic</option>
                            <option id="Quiz" value="Quiz"
                                    <c:if test="${(requestScope.Lesson!=null)}">
                                        ${("Quiz"==requestScope.Lesson.getLessonType())?"selected=\"selected\"":""}
                                    </c:if>
                                    >Quiz</option>
                        </select><br><br>
                        Order <br>
                        <input type="number" id="name" name="order" 
                               <c:if test="${requestScope.Lesson!=null}">
                                   value="${requestScope.Lesson.lessonorder}"</c:if>
                                   required style=" width: 90%;">
                        </div><br>
                    </div>
                    <div class="abc" id="link">
                        Video link <br>
                        <input type="text" placeholder="You tube link" name="link"
                        <c:if test="${requestScope.Lesson!=null}">
                            value="${requestScope.Lesson.videolink}"</c:if>
                            style="width: 97%;">
                    </div>
                    <div class="dropdown abc" id="quizs">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            List Quizs
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">

                        <c:forEach items="${requestScope.Quizs}" var="t">
                            <div class="dropdown-item" >
                                <input type="checkbox" name="quizid" 
                                       <c:forEach items="${requestScope.lqs}" var="q">
                                           ${(q.getQid()==t.getId())?"checked=\"checked\"":""}
                                       </c:forEach>
                                       value="${t.getId()}">
                                ${t.getName()}
                                (Quizlevel:
                                <c:if test="${t.getQuizLevelId()==1}">Hard</c:if>
                                <c:if test="${t.getQuizLevelId()==2}">Medium</c:if>
                                <c:if test="${t.getQuizLevelId()==3}">Easy</c:if>) 
                                </div>
                        </c:forEach>

                    </div>

                </div>
                <div class="abc " id="htmlconten">
                    HTML Content <br>
                    <textarea name="htmlcontent" 
                              required  style="width: 97%; height: 150px;" >
                        <c:if test="${requestScope.Lesson!=null}">
                            ${requestScope.Lesson.content}  </c:if>
                        </textarea>
                    </div>


                    <div class="abc">
                        <input  type="submit" value="Submit" > &emsp;&emsp;&emsp;&emsp;
                        <a href="subject/lesson?cid=${sessionScope.cid}&page=1">
                        <input type="button" value="back">
                    </a>
                </div>   
            </form>
        </main>

        <script>
            
            function doload()
            {
                var a = document.getElementById("selecttype").value;
                if (a === "Subject Topic") {
                    document.getElementById("quizs").style.display = 'none';
                    document.getElementById("link").style.display = 'none';
                    document.getElementById("htmlconten").style.display = 'none';
                }
                if (a === "Lesson") {
                    document.getElementById("quizs").style.display = 'none';
                    document.getElementById("link").style.display = 'block';
                    document.getElementById("htmlconten").style.display = 'block';
                }
                if (a === "Quiz") {
                    document.getElementById("quizs").style.display = 'block';
                    document.getElementById("link").style.display = 'none';
                    document.getElementById("htmlconten").style.display = 'block';
                }
            }
            ;
            doload();
            document.getElementById("selecttype").onchange = function () {
                doload();
            };

        </script>                                

        <!-- External JavaScripts -->
        <script src="view/admin/assets/js/jquery.min.js"></script>
        <script src="view/admin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="view/admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="view/admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="view/admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="view/admin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="view/admin/assets/vendors/counter/counterup.min.js"></script>
        <script src="view/admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="view/admin/assets/vendors/masonry/masonry.js"></script>
        <script src="view/admin/assets/vendors/masonry/filter.js"></script>
        <script src="view/admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='view/admin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="view/admin/assets/js/functions.js"></script>
        <script src="view/admin/assets/vendors/chart/chart.min.js"></script>
        <script src="view/admin/assets/js/admin.js"></script>
        <script src='view/admin/assets/vendors/switcher/switcher.js'></script>

    </body>

</html>
