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
         <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <!-- Nhung Alert-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="sweetalert2.all.min.js"></script>
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css"> 
        <script src="/summer2022-se1616-g4/js/validationForm/validateForm.js" type="text/javascript"></script>
        <style>
            .container-edit-pricepackage{
                margin-top: 20px;
            }
            .font-weight-subject-overview{
                font-weight: 500;
            }
            .status_pricepackage select{
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
            .status_pricepackage span{
                margin-left: 15px;
            }
            label.error{
                color: red;
                font-weight: 500;
            }
            /* Kết quả search của pricepackage */
            .style-list-subject{
                margin-top: 10px;
            }
            .style-list-subject ul{
                 list-style: none;
                 width: 500px;
            }
            .style-list-subject ul li{
                 width: 100%;
/*                 background: #E1DCDA;*/
                 background: #f2f2f2;
                 border-radius: 30px;
                 height: 40px;
                 line-height: 40px;
                 font-weight: 500;
                 padding: 0 5px;
                 cursor: pointer;
                 margin: 5px 0;
/*                 box-shadow: -3px 6px 4px #222;*/
                 text-transform : capitalize;
            }
            /* assign pricePackage : */
            .assigned_list_style{
                margin-top: 10px;
            }
            .assigned_list_style ul{
                list-style: none;
                 width: 500px;
            }
            .assigned_list_style ul li{
                 width: 100%;
                 background: white;
/*                 background: #6EBDC3;*/
                 height: 40px;
                 line-height: 40px;
                 padding: 0 5px;
                 cursor: pointer;
                 position: relative;
                 display: block;
                 margin: 5px 0;
/*               box-shadow: -3px 6px 4px #222;*/
                 text-transform : capitalize;
/*               font-style: oblique;*/
                 font-weight: 500;
                 border : 1px solid lightgreen;
            }
            .assigned_list_style ul li span.delete-pricepackage{
                position: absolute;
                top : 0; 
                right: 0;
                width: 50px;
                text-align: center;
                background: lightgray;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <jsp:include page="../../view/admin/header_admin.jsp" /> 
        <!--Main container start -->
        <main class="ttr-wrapper">
        <div class="container mt-3">
            <div style="display: flex; justify-content: space-between; border-bottom: 1px solid black">
                <h2 style="color: #F68051">Add Price Package</h2>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    Add Package To Search
                </button>
            </div>
            <br>
            <div class="col-12" style="display: flex; justify-content: left">
                
                <button style="margin-top: -10px;margin-left: 1px;" type="submit" onclick ="backToOverview(${requestScope.cid})" class="btn btn-secondary"><i class="fa fa-arrow-left" aria-hidden="true"></i><span style="margin-left: 5px;">Back Overview</span></button>
            </div>
            <!-- Start Modal add pricepackage to system-->
                     
            <div class="modal fade" id="myModal" style="margin-top: 10px">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-body">
                          <form id = "validate-form-edit-pricepackage" action = "addsystem"  method="get">
                              <input id = "cid" name ="cid" class="form-control" type="text" hidden ="hideen" value="${requestScope.course.courseId}" >
                            <div class = "col-12 col-md-12">
                                <div class="ml-auto">
                                    <h5 class = "title-overview-course">Add a new PricePackage if you can't searching it</h5>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for = "pname" class="col-form-label font-weight-subject-overview">Price Package Name</label>
                                    <div>
                                        <input id = "pname" name ="pname" class="form-control" type="text" placeholder="Enter package name..." >
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for = "duration" class="col-form-label font-weight-subject-overview">Duration ( month )</label>
                                    <div>
                                        <input id = "duration" name ="duration" class="form-control" type="text" placeholder="Enter number month...">
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for = "listprice" class="col-form-label font-weight-subject-overview">List Price ($)</label>
                                    <div>
                                        <input id = "listprice" name ="listprice" class="form-control" type="text"  placeholder="Enter list price...">
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for = "saleprice" class="col-form-label font-weight-subject-overview">Sale Price ($)</label>
                                    <div>
                                        <input id = "saleprice" name ="saleprice" class="form-control" type="text" placeholder="Enter sale price...">
                                    </div>
                                </div>
                                <div class = "status_pricepackage">
                                    <span class = "font-weight-subject-overview">Status : </span>
                                    <select style="text-transform: capitalize" id="status_id" name = "status_id">
                                        <!-- <c:forEach items="${requestScope.statuses}" var ="s">
                                            <option value = "${s.id}">${s.name}</option>
                                        </c:forEach> -->
                                            <option value = "1">Active</option>
                                            <option value = "2">Deactive</option>
                                    </select>
                                </div>    
                                <div class="col-12" style="margin-top: 10px; display: flex; justify-content: center">
                                    <button type="submit" class="btn btn-success">Save Change</button>
                                </div>
                            </div>
                           </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>   
            </div>
            <!--End-->
            <!-- Nav tabs -->
            <div class = "container-edit-pricepackage">
                <form action = "add"  method="post">
                    <div class = "row">
                        <div class = "col-12 col-md-6" style="border-right: 1px solid #E0D5D3">
                          <img  id = "img_course" class = "img-thumbnail img-fluid" src="../../images/courses/${requestScope.course.thumnailURL}" alt="" style="width: 600px; height: 300px; object-fit: cover;"/>
                          <h5 style="margin-top: 5px; color: #819830">${requestScope.course.title}</h5>
                        </div>
                        <div class = "col-12 col-md-6">
                            <div class="form-group col-md-12">
                                <label for = "search_pricepackage" class="col-form-label font-weight-subject-overview">Search PricePackage you want to add <span style="color : #3C9130">( Show all just enter <span style="color : red">"all"</span> )</span></label>
                                <i class="fa fa-search" aria-hidden="true"></i>
                                <div>
                                    <input id = "search_pricepackage" oninput="searchPricePackage(this)" name ="search_pricepackage" class="form-control" type="text" placeholder="You can search by name and number month" >
                                </div>
                                <!--result search pricepackage-->
                                <div id = "result_search_pricepackage" class= "style-list-subject">
                                    <ul id = "my_list_result_search_pricepackage">

                                    </ul>
                                </div>
                                <!--Chọn ông PricePackage nào cho code -->
                                <input type ="text" value ="${requestScope.course.courseId}" hidden="hidden" name ="cid" />
                                <label class="col-form-label font-weight-subject-overview" style="color : #6A747C">PricePackages you added : </label>
                                <div id = "assigned_pricepackage" class = "assigned_list_style">
                                    <ul>
                                        <c:forEach items="${requestScope.pricePackages}" var = "p">
                                            <li><input class ="input-pricepackage" type="text" hidden="hidden"  name = "pricepackage" value = "${p.id}">
                                                 Package ${p.name} ( <span style = "color : #819830">List Price</span> : ${p.listPrice}$ - <span style = "color : #819830">Sale Price</span> : ${p.salePrice}$ ) <span class ="delete-pricepackage"><i class="fa fa-trash" aria-hidden="true"></i></span></li>
                                        </c:forEach> 
                                    </ul>
                                </div>
                                <div class="col-12" style="margin-top: 10px; display: flex; justify-content: center">
                                   <button type="submit" class="btn btn-success">Save Change</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

           
        </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
            validateEditPricePackage();
            <c:if test="${sessionScope.addPricePackage_mess!=null}">
                Swal.fire(
                    'Added successfully',
                    'Added PricePackage to ${requestScope.course.title} successfully ',
                    'success'
                          )
                <% request.getSession().setAttribute("addPricePackage_mess", null); %>
            </c:if>
            <c:if test="${sessionScope.addPricePackageSystem_mess!=null}">
                Swal.fire(
                    'Added successfully',
                    'Added PricePackage to Fcourse System successfully ',
                    'success'
                          )
                <% request.getSession().setAttribute("addPricePackageSystem_mess", null); %>
            </c:if>
            // Xử lí bên tìm kiếm pricepackage và gán pricepackage
           var close = document.querySelectorAll('.delete-pricepackage');
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
            function searchPricePackage(param){
                var txtSearch = param.value;
                $.ajax({
                        url: '/summer2022-se1616-g4/searchPricePackageAjax',
                        type: 'get',
                        data: {
                            txt: txtSearch
                        } ,
                        success: function (response) {
                            var content = document.querySelector('#result_search_pricepackage ul');
                            content.innerHTML = response;
                        },
                        error: function () {
                            alert("error");
                        }
                });
                
            }
            function addPricePackage(param){
                // check xem đã thêm vào hay chưa
                var close = document.querySelectorAll('.input-pricepackage');
                if(close.length > 0 ){
                    for (let i in close) {
                        if(typeof close[i].value != typeof undefined){
                             if(param.id == close[i].value){
                                Swal.fire({
                                    icon: 'error',
                                    title: 'PricePackage already exist',
                                    text: 'This PricePacakge you added - Add other pricepackage',
                                })
                                 return;
                             }
                        }
                    }
                }
                var id = param.id;
                var content = param.innerHTML;
                console.log(content);
                const list = document.querySelector("#assigned_pricepackage ul");
                // tạo thẻ li gán vào ul
                const myLi = document.createElement('li');
                myLi.innerHTML = content;
                list.appendChild(myLi);
                // tạo thẻ input gắn vào li
                const myInput = document.createElement('input');
                myInput.setAttribute('type','text');
                myInput.setAttribute('name','pricepackage');
                myInput.setAttribute('value',id);
                myInput.setAttribute('hidden','hidden');
                myInput.setAttribute('class','input-pricepackage');
                myLi.appendChild(myInput);
                // tạo thẻ span gắn vào li
                const mySpan = document.createElement('span');
                mySpan.innerHTML = '<i class="fa fa-trash" aria-hidden="true"></i>';
                mySpan.setAttribute("class","delete-pricepackage");
                myLi.appendChild(mySpan);
                Swal.fire(
                    'Added Successfully',
                    'Added ' + content + ' is pricepackage of this subject',
                    'success'
                )
                 // xóa 
                var close = document.querySelectorAll('.delete-pricepackage');
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
            function backToOverview(cid){
                window.location.href = "../../admin/subject/details?id="+cid;               
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
