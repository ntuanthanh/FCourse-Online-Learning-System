<%-- 
    Document   : RegistrationDetails
    Created on : Jun 25, 2022, 12:25:53 AM
    Author     : thand
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Details</title>
        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="/summer2022-se1616-g4/view/admin/assets/images/favicon.png" />

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/color/color-1.css">
        <script src="js/ImgPreview/imgPreview.js" type="text/javascript"></script>
        <script src="//cdn.ckeditor.com/4.19.0/basic/ckeditor.js"></script>
        <style>
            * {
                box-sizing: border-box;
            }
            body {
                background-color: #ffffff;
            }
            .logo-add-registration {
                display: block;
                width: 200px;
                margin: 30px auto;

            }
            .form1 {
                background-color: #ffffff;
                width: 500px;
                margin: 20px auto 70px auto;
                padding: 30px;
                border-radius: 8px;
                overflow: hidden;
                box-shadow: 0 2px 10px -3px #333;
                text-align: center;
            }
            .input {
                padding: 1px 10px;
                width: 80%;
                border: 1px solid #D9D9D9;
                outline: none;
                display: block;
                margin: 10px auto 10px auto;
            }
            a {
                text-align: center;
                margin-top: 0px;
                color: #719BE6;
                text-decoration: none;
                padding: 5px;
                display: inline-block;
            }
            a:hover {
                text-decoration: underline;
            }
            .style-list-course ul li{
                width: 100%;
                background: #E1DCDA;
                height: 40px;
                line-height: 40px;
                font-weight: 500;
                padding: 0 5px;
                cursor: pointer;
                margin: 5px 0;
                box-shadow: -3px 6px 4px #222;
                text-transform : capitalize;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar" >
        <jsp:include page="../../view/admin/header_admin.jsp" />
        <main class="ttr-wrapper">
             <c:if test="${sessionScope.successful!=null}">
                 <span style="margin-left: 40%">successful</span><br>
                    <% request.getSession().setAttribute("successful", null); %>
                </c:if>  
            <c:if test="${requestScope.ucid == null}">
                <c:if test="${requestScope.Course.getPricePackage().size()==0}">
                    <div class="form1">
                        <img class ="logo-add-registration"
                            src="${pageContext.request.contextPath}/images/header/logo-main2_1.png">
                        Enter the course name and
                        choose course to continue to add new Registration Details
                        <div>
                            <input id="a" class="input" placeholder="Enter Course Name" type="text"
                                   oninput="searchCourse(this)"  name="name" placeholder="Enter Course Name">
                        </div>
                        <!--result search expert-->
                        <div id = "result_search_course" class="style-list-course" >
                            <ul id = "list_result_search_course">

                            </ul>
                        </div>
                        <a href="course/list">Forgot course? Go to course list page.</a><br><br>

                        <a href="${pageContext.request.contextPath}/admin/registration/list">
                            <button>back </button>
                        </a>
                    </div>
                </c:if>
                <c:if test="${requestScope.Course.getPricePackage().size()>0}">
                    <div>
                        <div>
                            <h2>Registration Details</h2>
                        </div>
                        <form action="RegistrationDetails" method="POST">
                            <div class="row" style="margin: 0%;">

                                <div class="col-md-6">
                                    <div>
                                        <b>Course ID:</b>&nbsp; 
                                        <input name="cid" value="${requestScope.Course.courseId}" hidden="">
                                        <span > ${requestScope.Course.courseId} </span>
                                    </div>
                                    <div>
                                        <b>Course name: </b>&nbsp; 
                                        <span>${requestScope.Course.title}</span> 
                                    </div>
                                    <div>
                                        <b>Sale:</b>&nbsp;

                                        <span> ${sessionScope.user.fullName}</span>
                                    </div>
                                    <div>
                                        <b>Status:</b>&nbsp; 
                                        <span><input type="radio" name="status" value="Active"/> Activate
                                            &emsp;&emsp;&emsp;&emsp;
                                            <input type="radio" name="status" value="Deactive"/> Deactivate </span>
                                    </div>
                                </div>


                                <div class="col-md-6">

                                    <div>
                                        <b>Course package:</b>&nbsp; 
                                        <select name="package" id="package" onchange="abc()">
                                            <c:forEach items="${requestScope.Course.getPricePackage()}" var="p">
                                                <option value="${p.id}"
                                                        ${p.id==requestScope.pid?"selected=\"selected\"":""}
                                                        >
                                                    ${p.getName()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div id="package_edit">
                                        <b>Registration time:</b>&nbsp;
                                        <span id="Registrationtime">${requestScope.pr.getDuration()} month</span> 
                                        <br>
                                        <b>List price: </b>&nbsp
                                        <span>${requestScope.pr.listPrice}  $</span>&emsp; 
                                        &emsp; &emsp; <b>Sale price: </b>&nbsp; 
                                        <span>${requestScope.pr.salePrice}   $</span> 
                                        <br><b>Start date:</b>&nbsp; 
                                        <span > <input type="date" name="sdate" 
                                                       oninput ="xyz(this)"
                                                       id="startdate" value="${requestScope.date}"/> </span>
                                        <br>
                                        <b>End date:</b>&nbsp; 
                                        <span id="endate"> ${requestScope.enddate} </span>
                                        <input name="edate" value="${requestScope.enddate}" hidden="">
                                    </div>

                                </div>
                            </div>
                            <div style="border: 1px; border-style: solid;
                                 border-color: #000316; padding: 10px; margin: 1% 5% 0% 0%; ">

                                <table border="1" style="margin: 0%">
                                    <thead>
                                    <b>&nbsp; Customer information</b> 
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><b>Full name:</b></td>
                                            <td><input type="text" name="cname" required="" style="width: 300px"></td>
                                        </tr>
                                        <tr>
                                            <td><b>Email: </b></td>
                                            <td> <input type="text" name="email" required="" style="width: 300px"></td>
                                        </tr>
                                        <tr>
                                            <td><b> Mobile:</b></td>
                                            <td> <input type="text" name="mobile" required="" style="width: 300px"></td>
                                        </tr>
                                        <tr>
                                            <td><b> Gender: </b></td>
                                            <td> <input type="radio" name="gender" value="male" required=""/> Male
                                                &emsp;&emsp;&emsp;&emsp;
                                                <input type="radio" name="gender" value="female" required=""/> Female
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div><br>

                            <input type="submit" value="Submit"> 
                            &emsp;&emsp;&emsp;&emsp;
                            &emsp;&emsp;&emsp;&emsp;
                            <a href="${pageContext.request.contextPath}/admin/registration/list">
                                <input type="button" value="back"></a>
                            <input id="time" value="${sessionScope.a}" hidden="">
                        </form>
                    </div><br>
                </c:if>
            </c:if>
            <c:if test="${requestScope.ucid != null}">
                <div>
                    <div>
                        <h2>Registration Details</h2>
                    </div>
                    <form action="updateRegisDetail" method="POST">
                        <div class="row" style="margin: 0%;">

                            <div class="col-md-6">
                                <div>
                                    <b>Course ID:</b>&nbsp; 
                                    <input name="cid" value="${requestScope.Course.courseId}" hidden="">
                                    <span > ${requestScope.Course.courseId} </span>
                                </div>
                                <div>
                                    <b>Course name: </b>&nbsp;
                                    <c:if test="${sessionScope.create.id!=sessionScope.user.id}">
                                        <span id="Coursename2">${requestScope.Course.title}</span> 
                                    </c:if>
                                    <c:if test="${sessionScope.create.id==sessionScope.user.id}">
                                        <input oninput="searchCourse2(this)" name="title" value="${requestScope.Course.title}" style="width: 350px "> 
                                        <!--result search expert-->
                                        <div id = "result_search_course" class="style-list-course" >
                                            <ul id = "list_result_search_course">

                                            </ul>
                                        </div>
                                    </c:if>
                                </div>
                                <div>
                                    <b>Sale:</b>&nbsp;

                                    <span> ${sessionScope.create.fullName}</span>
                                </div>
                                <div>
                                    <b>Status:</b>&nbsp; 
                                    <span><input type="radio" name="status"
                                                 ${requestScope.uc.isRegistration_status()?"checked=\"checked\"":""}
                                                 value="Active"/> Activate
                                        &emsp;&emsp;&emsp;&emsp;
                                        <input type="radio" ${!requestScope.uc.isRegistration_status()?"checked=\"checked\"":""}
                                               name="status" value="Deactive"/> Deactivate </span>
                                </div>
                            </div>


                            <div class="col-md-6">

                                <div>
                                    <b>Course package:</b>&nbsp; 
                                    <c:if test="${sessionScope.create.id==sessionScope.user.id}">
                                        <select name="package" id="package" onchange="abc()">
                                            <c:forEach items="${requestScope.Course.getPricePackage()}" var="p">
                                                <option value="${p.id}"
                                                        ${p.id==requestScope.pid?"selected=\"selected\"":""}
                                                        >
                                                    ${p.getName()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </c:if>
                                    <c:if test="${sessionScope.create.id!=sessionScope.user.id}">
                                        <span>${requestScope.pr.name}</span>
                                    </c:if>

                                </div>
                                <div id="package_edit">
                                    <b>Registration time:</b>&nbsp;
                                    <span id="Registrationtime">${requestScope.pr.getDuration()} month</span> 
                                    <br>
                                    <b>List price: </b>&nbsp
                                    <span>${requestScope.pr.listPrice}  $</span>&emsp; 
                                    &emsp; &emsp; <b>Sale price: </b>&nbsp; 
                                    <span>${requestScope.pr.salePrice}   $</span> 
                                    <br><b>Start date:</b>&nbsp; 
                                    <span > 
                                        <c:if test="${sessionScope.create.id==sessionScope.user.id}">
                                            <input type="date" name="sdate" 
                                                   oninput ="xyz(this)"
                                                   id="startdate" value="${requestScope.date}"/></c:if>
                                        <c:if test="${sessionScope.create.id!=sessionScope.user.id}">
                                            ${requestScope.date}
                                        </c:if>
                                    </span>
                                    <br>
                                    <b>End date:</b>&nbsp; 
                                    <span id="endate"> ${requestScope.enddate} </span>
                                    <input name="edate" value="${requestScope.enddate}" hidden="">
                                </div>

                            </div>
                        </div>
                        <div style="border: 1px; border-style: solid;
                             border-color: #000316; padding: 10px; margin: 1% 5% 0% 0%; ">

                            <table border="1" style="margin: 0%">
                                <thead>
                                <b>&nbsp; Customer information</b> 
                                </thead>
                                <tbody>

                                    <tr>
                                        <td><b>Full name:</b></td>
                                        <td>
                                            <c:if test="${sessionScope.create.id==sessionScope.user.id}">
                                                <input type="text" name="cname" required="" value="${requestScope.user.fullName}" style="width: 300px">
                                            </c:if>
                                            <c:if test="${sessionScope.create.id!=sessionScope.user.id}">
                                                ${requestScope.user.fullName}
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Email: </b></td>
                                        <td> <c:if test="${sessionScope.create.id==sessionScope.user.id}">
                                                <input type="text" name="email" value="${requestScope.user.email}" required="" style="width: 300px">
                                            </c:if>
                                            <c:if test="${sessionScope.create.id!=sessionScope.user.id}">
                                                ${requestScope.user.email}
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b> Mobile:</b></td>
                                        <td> 
                                            <c:if test="${sessionScope.create.id==sessionScope.user.id}">
                                                <input type="text" name="mobile" value="${requestScope.user.phone}" required="" style="width: 300px">
                                            </c:if>
                                            <c:if test="${sessionScope.create.id!=sessionScope.user.id}">
                                                ${requestScope.user.phone},
                                            </c:if>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td><b> Gender: </b></td>
                                        <c:if test="${sessionScope.create.id!=sessionScope.user.id}">
                                            <td> <c:if test="${requestScope.user.gender}">
                                                    male
                                                </c:if>
                                                <c:if test="${!requestScope.user.gender}">
                                                    female
                                                </c:if>   
                                            </td>
                                        </c:if>
                                        <c:if test="${sessionScope.create.id==sessionScope.user.id}">
                                            <td> <input type="radio" name="gender" value="male"
                                                        ${requestScope.user.gender?"checked=\"checked\"":""}
                                                        required=""/> Male
                                                &emsp;&emsp;&emsp;&emsp;
                                                <input type="radio" ${!requestScope.user.gender?"checked=\"checked\"":""}
                                                       name="gender" value="female" required=""/> Female
                                            </td>
                                        </c:if>
                                <input name="create" value="sessionScope.create.id" hidden=""  >
                                </tr>
                                </tbody>
                            </table>
                        </div><br>

                        <input type="submit" value="Submit"> 
                        &emsp;&emsp;&emsp;&emsp;
                        &emsp;&emsp;&emsp;&emsp;
                        <a href="${pageContext.request.contextPath}/admin/registration/list">
                                <input type="button" value="back"></a>
                        <input id="time" value="${sessionScope.a}" hidden="">
                    </form>
                </div><br>
                <% request.getSession().setAttribute("ucid", request.getAttribute("ucid")); %> 
                
                <% request.getSession().setAttribute("uc", request.getAttribute("uc"));%>
            </c:if>
                 




        </main>
        <script>
            function searchCourse(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: '${pageContext.request.contextPath}/AjaxSearchRegistrationDetail',
                    type: 'get',
                    data: {
                        txt: txtSearch
                    },
                    success: function (response) {
                        var content = document.querySelector('#result_search_course ul');
                        content.innerHTML = response;
                    },
                    error: function () {

                    }
                });
            }
            ;
            function searchCourse2(param) {
                var txtSearch = param.value;
                $.ajax({
                    url: '${pageContext.request.contextPath}/AjaxSearchRegistrationDetail',
                    type: 'get',
                    data: {
                        txt: txtSearch,
                        xx: 'cc'
                    },
                    success: function (response) {
                        var content = document.querySelector('#result_search_course ul');
                        content.innerHTML = response;
                    },
                    error: function () {

                    }
                });
            }
            ;
            function submit(cid) {
                var a = '${pageContext.request.contextPath}/RegistrationDetails?cid=' + cid;
                window.location = a;
            }
            ;
            function submit2(cid) {

                var a = '${pageContext.request.contextPath}/updateRegisDetail?cid=' + cid;
                window.location = a;
            }
            ;
            function abc() {
                var aa = document.getElementById("package").value;
                var bb = document.getElementById("startdate").value;
                $.ajax({
                    url: '${pageContext.request.contextPath}/AjaxSearchRegistrationDetail',
                    type: 'post',
                    data: {
                        txt: aa,
                        bb: bb
                    },
                    success: function (response) {
                        var content = document.querySelector('#package_edit');
                        content.innerHTML = response;
                    },
                    error: function () {

                    }
                });
            }
            ;
            function xyz(param) {
                var time = document.getElementById("time").value;
                var ngay = param.value;
                if (ngay < time) {
                    
                    document.getElementById('startdate').value = time;
                    return;
                }
                var aa = document.getElementById("package").value;
                $.ajax({
                    url: '${pageContext.request.contextPath}/AjaxStartDate',
                    type: 'get',
                    data: {
                        txt: ngay,
                        aa: aa
                    },
                    success: function (response) {
                        var content = document.querySelector('#endate');
                        content.innerHTML = response;
                    },
                    error: function () {

                    }
                });
            }
            ;
        </script>                                

        <!-- External JavaScripts -->
        <script src="view/admin/assets/js/jquery.min.js"></script>
        <script src="view/admin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="view/admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="../view/admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
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
