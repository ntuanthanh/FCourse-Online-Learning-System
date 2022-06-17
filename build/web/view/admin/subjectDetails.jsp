<%-- 
    Document   : subjectDetails
    Created on : Jun 12, 2022, 2:46:43 PM
    Author     : pv
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <script src="../../js/ImgPreview/imgPreview.js" type="text/javascript"></script>
        <!-- Nhung Alert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="sweetalert2.all.min.js"></script>
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css"> 
        <style>
            .nav-tabs .nav-item.show .nav-link, .nav-tabs .nav-link.active{
                font-weight: bold;
            }
            .title-overview-course{
                color : #F28864;
            }
            .status-subject{
                margin-left: 30px;
            }
            .status-subject select{
                height: calc(1.5em + 0.75rem + 2px);
                padding: 0.375rem 0.75rem;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #495057;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #ced4da;
                border-radius: 0.25rem;
                transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
            }
            .font-weight-subject-overview{
                font-weight: 500;
            }
            .result_search{
                cursor: pointer;
                margin-top: 10px;
            }
            .style-list-subject{
                margin-top: 10px;
            }
            .style-list-subject ul{
                 list-style: none;
                 width: 500px;
            }
            .style-list-subject ul li{
                 width: 100%;
                 background: #E1DCDA;
                 height: 40px;
                 line-height: 40px;
                 padding: 0 5px;
                 cursor: pointer;
                 margin: 5px 0;
                 box-shadow: -3px 6px 4px #222;
                 text-transform : capitalize;
            }
            /* assign expert : */
            .assigned_list_style{
                margin-top: 10px;
            }
            .assigned_list_style ul{
                list-style: none;
                 width: 500px;
            }
            .assigned_list_style ul li{
                 width: 100%;
                 background: #FFCCCC;
/*                 background: #6EBDC3;*/
                 height: 40px;
                 line-height: 40px;
                 padding: 0 5px;
                 cursor: pointer;
                 position: relative;
                 display: block;
                 margin: 5px 0;
                 box-shadow: -3px 6px 4px #222;
                 text-transform : capitalize;
                 font-style: oblique;
                 font-weight: 500;
            }
            .assigned_list_style ul li span{
                position: absolute;
                top : 0; 
                right: 0;
                width: 50px;
                text-align: center;
                background: #e00;
                
            }
            td{
                text-transform: capitalize;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <jsp:include page="../../view/admin/header_admin.jsp" /> 
        <!--Main container start -->
        <main class="ttr-wrapper">
        <div class="container mt-3">
            <h2>Subject Details</h2>
            <br>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#Overview">Overview</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#Price_Package">Price Package</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#Dimensio">Dimension</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div id="Overview" class="container tab-pane active"><br>
                    <form class="m-b30" method="POST" action ="details" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-12" style = "margin-left: 12px">
                                <div class="ml-auto">
                                    <h5 class = "title-overview-course">Course general information</h5>
                                </div>
                            </div>
                            <input  name ="courseId" hidden="hidden" type="text" value="${requestScope.course.courseId}">
                            <div class = "col-12 col-md-6">
                                <div class="form-group col-12">
                                    <label for = "course_title" class="col-form-label font-weight-subject-overview">Subject Name</label>
                                    <div>
                                        <input id = "course_title" name ="course_title" class="form-control" type="text" value="${requestScope.course.title}">
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <label for = "category" class="col-form-label font-weight-subject-overview">Catgory</label>
                                    <div>
                                        <select class="form-control" id="categoryID" name = "categoryID">
                                            <c:forEach items = "${requestScope.categories}" var = "c">
                                                <option ${requestScope.course.category.categoryID == c.categoryID?"selected = selected":""} value = "${c.categoryID}">${c.value}</option>
                                            </c:forEach>                                        
                                        </select>
                                    </div>
                                </div> 
                                <div class="form-group col-12">
                                    <label for ="course_briefinfo" class="col-form-label font-weight-subject-overview">Course Briefinfo</label>
                                    <div>
                                        <textarea id ="course_briefinfo" class="form-control" name = "briefInfo">${requestScope.course.briefInfo}</textarea>
                                    </div>
                                </div>
                                <div class = "row" style="margin-left: 1px;">
                                    <div class="col-6">                                          
                                        <div>
                                            <input type="checkbox" ${requestScope.course.feature == true?"checked= checked":""} id = "featured_subject" value="true" name = "featured_subject">
                                            <label for="featured_subject" class="col-form-label font-weight-subject-overview">Featured Subject</label>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class = "status-subject">
                                            <c:if test = "${requestScope.isAdmin == false}">
                                                <input type ="text" hidden ="hidden" name ="status_id" value = "${requestScope.course.status.id}"/>
                                            </c:if>
                                            <span class = "font-weight-subject-overview">Status : </span>   <select ${requestScope.isAdmin == false?"disabled":"" } id="status" name = "status_id">
                                                <c:forEach items="${requestScope.statuses}" var ="s">
                                                      <option value ="${s.id}" ${s.id == requestScope.course.status.id?"selected = selected":""} >${s.id == 1?"Published":"UnPublished"}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class = "col-12 col-md-6"> 
                                <img  id = "img_course" class = "img-thumbnail img-fluid" src="../../images/courses/${requestScope.course.thumnailURL}" alt="" style="width: 600px; height: 300px; object-fit: cover;"/>
                                <h6>Upload a new thumbnail image</h6>
                                <input value="${requestScope.course.thumnailURL}" type="text" hidden="hidden" name = "old_img_course"/>
                                <input type="file" onchange="getImgPreview_SubjectOverview(event)" name = "img_course" class="text-center center-block file-upload">
                            </div>
                            <div class="form-group col-12" style="margin-left: 12px">
                                <label for ="course_description" class="col-form-label font-weight-subject-overview">Course Description</label>
                                <div>
                                    <textarea id="course_description" class="form-control" name = "description">${requestScope.course.description}</textarea>
                                </div>
                            </div>
                            <!--Search user expert by ajax-->
                            <c:if test = "${requestScope.isAdmin == true}">
                                <div class = "col-12 col-md-6"> 
                                    <div class="form-group col-12">
                                        <label for = "search_expert" class="col-form-label font-weight-subject-overview" style="color : #6A747C">Search expert you want to assign </label>
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                        <div>
                                            <input id = "search_expert" name ="search_expert" class="form-control" type="text" placeholder ="You can search by email or name expert" oninput="searchExpert(this)">
                                        </div>
                                        <!--result search expert-->
                                        <div id = "result_search_expert" class= "style-list-subject">
                                            <ul id = "my_list_result_search_expert">

                                            </ul>
                                        </div>
                                        <!--Chọn ông Expert nào cho code -->
                                        <label class="col-form-label font-weight-subject-overview" style="color : #6A747C">Experts you assigned : </label>
                                        <div id = "assigned_expert" class = "assigned_list_style">
                                            <ul>
                                                <c:forEach items="${requestScope.course.owners}" var = "o">
                                                    <li><input class ="input-expert" type="text" hidden="hidden"  name = "expert" value = "${o.id}">${o.fullName}( ${o.email} )<span class ="delete-expert">x</span></li>
                                                </c:forEach> 
                                            </ul>
                                        </div>
                                     </div>
                                </div>
                            </c:if>
                            <c:if test = "${requestScope.isAdmin == false}">
                                <c:forEach items="${requestScope.course.owners}" var = "o">
                                        <input class ="input-expert" type="text" hidden="hidden"  name = "expert" value = "${o.id}">
                                 </c:forEach> 
                            </c:if>
                            
                            <!--Search tag by ajax-->
                            <div class = "col-12 col-md-6"> 
                                <div class="form-group col-12">
                                    <label for = "course_tag" class="col-form-label font-weight-subject-overview" style="color : #6A747C">Search tag to add</label>
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                    <div>
                                        <input oninput="searchTag(this)" id = "course_tag" placeholder ="You can search by name tag" name ="course_tag" class="form-control" type="text">
                                    </div>
                                    <!--Kết quả search bởi admin-->
                                    <div id = "result_search_tag" class= "style-list-subject">
                                        <ul id = "my_list_result_search_tag">
                                            
                                        </ul>
                                    </div>
                                    <!--Chọn Tag-->
                                    <label class="col-form-label font-weight-subject-overview" style="color : #6A747C">Tags you choiced : </label>
                                    <div id = "assigned_tag" class = "assigned_list_style">
                                        <ul>
                                             <c:forEach items="${requestScope.course.tags}" var = "t">
                                                <li><input class ="input-tag" type="text" hidden="hidden"  name = "tag" value = "${t.tagId}">${t.tagname}<span class ="delete-expert">x</span></li>
                                            </c:forEach> 
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12" style="margin-left: 12px">
                                <button type="submit" class="btn btn-success">Save changes</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div id="Price_Package" class="container tab-pane fade"><br>
                    <c:if test = "${requestScope.isAdmin == true}">
                        <a style="text-decoration: none; float : right" href="#">Add New</a>
                    </c:if>
                    <table class="table table-hover">
                        <thead>
                            <tr class = "bg-warning">
                                <th scope="col">#</th>
                                <th scope="col">Package</th>
                                <th scope="col">Duration(month)</th>
                                <th scope="col">List Price</th>
                                <th scope="col">Sale Price</th>
                                <th scope="col">Status</th>
                                <c:if test = "${requestScope.isAdmin == true}">
                                <th scope="col">Action</th>
                                </c:if>
                            </tr>
                        </thead>
                        <tbody id = "table-price">
<!--                            <c:forEach var = "i" begin = "1" end = "5"> 
                                <tr>
                                    <th scope="row">${i}</th>
                                    <td>Gói truy cập 3 tháng</td>
                                    <td>3</td>
                                    <td>3600</td>
                                    <td>3200</td>
                                    <td>Active</td>
                                    <td>
                                        <a style="margin-right: 5px; text-decoration: none " href = "#">Edit</a>
                                        <a style="text-decoration: none "href = "#">Deactivate</a>
                                    </td>
                                </tr>
                            </c:forEach>    -->
                            <c:forEach items="${requestScope.course.pricePackage}" var = "p"> 
                                <tr>
                                    <th scope="row">${p.id}</th>
                                    <td>${p.name}</td>
                                    <td>${p.duration != -1 ? p.duration : "Unlimited"} (Month)</td>
                                    <td>${p.listPrice} ($)</td>
                                    <td>${p.salePrice} ($)</td>
                                    <td>${p.status.name}</td>
                                    <c:if test = "${requestScope.isAdmin}">
                                    <td>
                                        <a style="margin-right: 5px; text-decoration: none " href = "#">Edit</a>
                                        <a style="text-decoration: none" href = "#" onclick = "ActionPricePackage(${p.id},${p.status.id},${requestScope.course.courseId})">${p.status.id == 1?"Deactivate":"Active"}</a>
                                    </td>
                                    </c:if>
                                </tr>
                            </c:forEach>  
                        </tbody>
                    </table>
                </div>
                <div id="Dimensio" class="container tab-pane fade"><br>
                    <a style="text-decoration: none; float : right" href="#">Add New</a>
                    <table class="table table-hover">
                        <thead>
                            <tr class = "bg-warning">
                                <th scope="col">#</th>
                                <th scope="col">Type</th>
                                <th scope="col">Dimension</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach items = "${requestScope.course.dimensions}" var = "d"> 
                                <tr>
                                    <th scope="row">${d.id}</th>
                                    <td>${d.dimensionType.name}</td>
                                    <td>${d.name}</td>
                                    <td>
                                        <a style="margin-right: 5px; text-decoration: none " href = "#">Edit</a>
                                        <a style="text-decoration: none "href = "#">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
           // Xử lí bên tìm kiếm expert và gán expert
           var close = document.querySelectorAll('.delete-expert');
            var num = close.length;
            for (let i in close) {
                close[i].addEventListener('click', () => {
                    close[i].parentElement.style.opacity = 0;
                    setTimeout(() => {
                        close[i].parentElement.style.display = "none";
                        close[i].parentElement.remove();
                    }, 500);
                });
            }
            getImgPreview_SubjectOverview(event);
            function searchExpert(param){            
                var txtSearch = param.value;
                $.ajax({
                        url: '/summer2022-se1616-g4/searchExpertAjax',
                        type: 'get',
                        data: {
                            txt: txtSearch
                        } ,
                        success: function (response) {
                            var content = document.querySelector('#result_search_expert ul');
                            content.innerHTML = response;
                        },
                        error: function () {
                            alert("error");
                        }
                });       
            }
            function addExpert(param){
                // check xem đã thêm vào hay chưa
                var close = document.querySelectorAll('.input-expert');
                if(close.length > 0 ){
                    for (let i in close) {
                        if(typeof close[i].value != typeof undefined){
                             if(param.id == close[i].value){
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Expert already exist',
                                    text: 'This Expert you assigned - Add other expert',
                                })
                                 return;
                             }
                        }
                    }
                }
                var id = param.id;
                var content = param.innerHTML;
                console.log(content);
                const list = document.querySelector("#assigned_expert ul");
                // tạo thẻ li gán vào ul
                const myLi = document.createElement('li');
                myLi.innerHTML = content;
                list.appendChild(myLi);
                // tạo thẻ input gắn vào li
                const myInput = document.createElement('input');
                myInput.setAttribute('type','text');
                myInput.setAttribute('name','expert');
                myInput.setAttribute('value',id);
                myInput.setAttribute('hidden','hidden');
                myInput.setAttribute('class','input-expert');
                myLi.appendChild(myInput);
                // tạo thẻ span gắn vào li
                const mySpan = document.createElement('span');
                mySpan.innerHTML = 'x';
                mySpan.setAttribute("class","delete-expert");
                myLi.appendChild(mySpan);
                Swal.fire(
                    'Assigned Successfully',
                    'Assigned ' + content + ' is expert of this subject',
                    'success'
                )
                 // xóa 
                var close = document.querySelectorAll('.delete-expert');
                    var num = close.length;
                    for (let i in close) {
                        close[i].addEventListener('click', () => {
                            close[i].parentElement.style.opacity = 0;
                            setTimeout(() => {
                                close[i].parentElement.style.display = "none";
                                close[i].parentElement.remove();
                            }, 500);
                        });
                    }
            }
            // Xử lí tìm kiếm tag và gán tag cho subject 
            var close2 = document.querySelectorAll('.delete-tag');
            var num2 = close2.length;
            for (let i in close2) {
                close2[i].addEventListener('click', () => {
                    close2[i].parentElement.style.opacity = 0;
                    setTimeout(() => {
                        close2[i].parentElement.style.display = "none";
                        close2[i].parentElement.remove();
                    }, 500);
                });
            }
            function searchTag(param){            
                var txtSearch = param.value;
                $.ajax({
                        url: '/summer2022-se1616-g4/searchAjaxTag',
                        type: 'get',
                        data: {
                            txt: txtSearch
                        } ,
                        success: function (response) {
                            var content = document.querySelector('#result_search_tag ul');
                            content.innerHTML = response;
                        },
                        error: function () {
                            alert("error");
                        }
                });       
            }
            function addTag(param){
                // check xem đã thêm vào hay chưa
                var close = document.querySelectorAll('.input-tag');
                if(close.length > 0 ){
                    for (let i in close) {
                        if(typeof close[i].value != typeof undefined){
                             if(param.id == close[i].value){
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Tag already exist',
                                    text: 'This tag you choiced - Add other tag',
                                })
                                 return;
                             }
                        }
                    }
                }
                var id = param.id;
                var content = param.innerHTML;
                console.log(content);
                const list = document.querySelector("#assigned_tag ul");
                // tạo thẻ li gán vào ul
                const myLi = document.createElement('li');
                myLi.innerHTML = content;
                list.appendChild(myLi);
                // tạo thẻ input gắn vào li
                const myInput = document.createElement('input');
                myInput.setAttribute('type','text');
                myInput.setAttribute('name','tag');
                myInput.setAttribute('value',id);
                myInput.setAttribute('hidden','hidden');
                myInput.setAttribute('class','input-tag');
                myLi.appendChild(myInput);
                // tạo thẻ span gắn vào li
                const mySpan = document.createElement('span');
                mySpan.innerHTML = 'x';
                mySpan.setAttribute("class","delete-tag");
                myLi.appendChild(mySpan);
                Swal.fire(
                    'Choiced Successfully',
                    'Choiced ' + content + ' is tag of this subject',
                    'success'
                )
                 // xóa 
                var close2 = document.querySelectorAll('.delete-tag');
                    var num = close2.length;
                    for (let i in close2) {
                        close2[i].addEventListener('click', () => {
                            close2[i].parentElement.style.opacity = 0;
                            setTimeout(() => {
                                close2[i].parentElement.style.display = "none";
                                close2[i].parentElement.remove();
                            }, 500);
                        });
                    }
            }
            // Price Package : Action ( Ajax ) 
            function ActionPricePackage(id,statusId,courseId){
                var pricePackageId = id;
                var status = statusId; 
                var course = courseId;
                $.ajax({
                        url: '/summer2022-se1616-g4/updateStatusPricePackage',
                        type: 'get',
                        data: {
                            pid: pricePackageId,
                            sid: status,
                            cid: course
                        } ,
                        success: function (response) {
                            var content = document.querySelector('#table-price');
                            content.innerHTML = response;
                            Swal.fire(
                    'Change status successfully',
                    'Change status successfully ',
                    'success'
                )
                        },
                        error: function () {
                            alert("error");
                        }
                });    
                
            }
        </script>
        
        
        <script src="/summer2022-se1616-g4/view/admin/assets/js/jquery.min.js"></script>
<!--        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap/js/popper.min.js"></script>
       <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>-->
<!--        <script src="/summer2022-se1616-g4/view/admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>-->
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
<!--        <script src='/summer2022-se1616-g4/view/admin/assets/vendors/switcher/switcher.js'></script>-->
    </body>
</html>
