<%-- 
    Document   : editPricePackage
    Created on : Jun 26, 2022, 3:45:28 PM
    Author     : pv
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Price Package</title>
       <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
<!--        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/shortcodes/shortcodes.css">-->

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="/summer2022-se1616-g4/view/admin/assets/css/color/color-1.css">
        
        
        
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <!-- Nhung Alert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="sweetalert2.all.min.js"></script>
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css"> 
        <script src="../../js/paging/pagingRegistrationList.js" type="text/javascript"></script>
        <style>
            .advanced-search{
                display: flex;
                flex-wrap: wrap;
                margin-left: 10px;
                margin-right: 10px;
                justify-content: space-between;
            }
            .advanced-search label{
                font-weight: bold;
                color: #333;
            }
            .advanced-search .advanced-search-item{
                flex-basis: 24%; 
            }
            .advanced-search .second{
                margin-top: 2px;
                flex-basis: calc(50% - 12px);
            }
            .advanced-search-submit{
                display: flex;
                justify-content: center;
                margin-top: 10px;
                margin-bottom: 10px;
            }

            .books-pagination{
                display: flex;
                justify-content: center;
                margin-top: 20px;
            }
            .page-link:hover{
                color : white !important;
            }
            @media (max-width: 900px){
                .advanced-search .advanced-search-item{
                    flex-basis: calc(50% - 12px);
                }
            }
            @media (max-width: 600px){
                .advanced-search .advanced-search-item{
                    flex-basis: 100% !important;
                }
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <jsp:include page="../../view/admin/header_admin.jsp" /> 
        <!--Main container start -->
        <main class="ttr-wrapper">
        <div class="container mt-3">
            <div style="display: flex; justify-content: space-between; border-bottom: 1px solid black">
                <h2 style="color: #F68051">Registration List</h2>
                <button onclick="addRegistration()" type="button" class="btn btn-primary">
                    Add Registration
                </button>
            </div>
            <br>
            <!--Form search-->
            <form action = "list" method="GET">
                <div class="advanced-search">
                    <div class = "advanced-search-item">
                        <label for="sort">Sorted By</label>
                        <select class="form-control" id="sort" name = "sort">
<!--                            <option value selected = "selected">Select The Field To Sort</option>-->
                            <option ${requestScope.sort == "0"?"selected = selected":""} value = "0">Sorted by id ascending</option>
                            <option ${requestScope.sort == "1"?"selected = selected":""} value = "1">Sorted by id descending</option>
                            <option ${requestScope.sort == "2"?"selected = selected":""} value = "2">Sorted by email ascending</option>
                            <option ${requestScope.sort == "3"?"selected = selected":""} value = "3">Sorted by email descending</option>
                            <option ${requestScope.sort == "4"?"selected = selected":""} value = "4">Sorted by registration time ascending</option>
                            <option ${requestScope.sort == "5"?"selected = selected":""} value = "5">Sorted by registration time descending</option>
                            <option ${requestScope.sort == "6"?"selected = selected":""} value = "6">Sorted by title ascending</option>
                            <option ${requestScope.sort == "7"?"selected = selected":""} value = "7">Sorted by title descending</option>
                            <option ${requestScope.sort == "8"?"selected = selected":""} value = "8">Sorted by package ascending</option>
                            <option ${requestScope.sort == "9"?"selected = selected":""} value = "9">Sorted by package descending</option>
                            <option ${requestScope.sort == "10"?"selected = selected":""} value = "10">Sorted by totalcost ascending</option>
                            <option ${requestScope.sort == "11"?"selected = selected":""} value = "11">Sorted by totalcost descending</option>
                            <option ${requestScope.sort == "12"?"selected = selected":""} value = "12">Sorted by valid to ascending</option>
                            <option ${requestScope.sort == "13"?"selected = selected":""} value = "13">Sorted by valid to descending</option>                                    
                        </select>
                    </div>
                    <div class = "advanced-search-item">
                        <label for="status">Search by status</label>
                        <select class="form-control" id="status" name = "status">
                            <option value>Select the status to search</option>
                            <option ${requestScope.status == "1"?"selected = selected":""} value = "1">Active</option>
                            <option ${requestScope.status == "0"?"selected = selected":""} value = "0">Deactive</option>
                        </select>
                    </div>
                    <div class = "advanced-search-item">
                        <label for="registrationtimefrom">Registration Time From</label>
                        <input onchange="myFrom()" max="" value="${requestScope.registrationtimefrom}" type="date" class="form-control" name ="registrationtimefrom" id="registrationtimefrom">
                    </div>
                    <div class = "advanced-search-item">
                        <label for="registrationtimefrom">Registration Time To</label>
                        <input onchange="myTo()" min="" value="${requestScope.registrationtimeto}" type="date" class="form-control" name ="registrationtimeto" id="registrationtimeto">
                    </div>
                    <div class = "advanced-search-item second">
                        <label for="title" class="mr-sm-2">Seach by Title Course</label>
                        <input value="${requestScope.title}" type="text" class="form-control" name ="title"  id="title" placeholder="Enter Title Course You Want To Search" >
                    </div>
                    <div class = "advanced-search-item second">
                        <label for="email" class="mr-sm-2">Seach by email</label>
                        <input value="${requestScope.email}" type="text" class="form-control" name ="email" id="email" placeholder="Enter Email You Want To Search" >
                    </div>
                </div>
                <div class = "advanced-search-submit">
                    <button class="btn btn-danger" type="submit">Search</button>
                </div>
            </form>
            
            <!--Show result search-->
            <table class="table table-hover">
                <thead>
                    <tr class = "bg-warning">
                        <th scope="col">ID</th>
                        <th scope="col">Email (Register) </th>
                        <th scope="col">RegistrationTime</th>
                        <th scope="col">Subject</th>
                        <th scope="col">Package</th>
                        <th scope="col">Total cost</th>
                        <th scope="col">Status</th>
<!--                        <th scope="col">Valid from</th>
                        <th scope="col">Valid to</th>-->
                        <th scope="col">Updated by user</th>
                        <th scope="col">Edit</th>
<!--                        <th scope="col">Delete</th>-->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.usercourses}" var="uc"> 
                        <tr>
                            <th scope="row">${uc.userCourseId}</th>
                            <td>${uc.user.email}</td>
                            <td>${uc.startDate}</td>
                            <td>${uc.course.title}</td>
                            <td>${uc.pricePackage.name}</td>
                            <td>${uc.pricePackage.salePrice}($)</td>
                            <td>${uc.registration_status==true?"Active":"Deactive"}</td>
                            <td>${uc.updateBy.fullName}</td>
                            <td><button type="button" onclick="editRegistration(${uc.userCourseId})" class="btn btn-info">Edit</button></td>
<!--                            <td>
                                <button type="button" onclick="deleteRegistration(${uc.userCourseId})" class="btn btn-info">Delete</button>
                            </td>-->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
           <!-- This is pagination -->
            <div class = "books-pagination">
                <ul class="pagination" id = "paggerBottom">

                </ul>
            </div>
        </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
            if(${requestScope.usercourses.size() > 0}){
               pagger_RegistrationList("paggerBottom",2,${requestScope.totalPage},${requestScope.pageIndex},'${requestScope.url}'); 
            }
            var from = document.getElementById("registrationtimefrom");
            var to = document.getElementById("registrationtimeto");

            function myFrom() {
                to.min = from.value;
            }

            function myTo() {
                from.max = to.value;
            }
            function editRegistration(id){
                window.location.href = "../../RegistrationDetails?ucid="+id;
            }
            function addRegistration(){
                window.location.href = "../../RegistrationDetails";
            }
        </script>
        <script src="/summer2022-se1616-g4/view/admin/assets/js/jquery.min.js"></script>
    
<!--        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap/js/popper.min.js"></script>
       <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>-->
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/counter/counterup.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/masonry/masonry.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/masonry/filter.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/js/functions.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/chart/chart.min.js"></script>
        <script src="/summer2022-se1616-g4/view/admin/assets/js/admin.js"></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/calendar/moment.min.js'></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/calendar/fullcalendar.js'></script>
        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/switcher/switcher.js'></script>
    </body>
</html>
