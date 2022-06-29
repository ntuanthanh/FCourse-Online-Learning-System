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
                margin-left: 25%;
                margin-right: 25%;
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
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <jsp:include page="../../view/admin/header_admin.jsp" /> 
        <!--Main container start -->
        <main class="ttr-wrapper">
        <div class="container mt-3">
            <h2 style="border-bottom: 1px solid black; color: #F68051">Edit Dimension</h2>
            <br>
            <div class="col-12" style="display: flex; justify-content: left">
                
                <button style="margin-top: -10px;margin-left: 1px;" type="submit" onclick ="backToOverview(${requestScope.cid})" class="btn btn-secondary"><i class="fa fa-arrow-left" aria-hidden="true"></i><span style="margin-left: 5px;">Back Overview</span></button>
            </div>
            <!-- Nav tabs -->
            <div class = "container-edit-pricepackage">
                <form id = "validate-form-edit-dimension" action = "edit"  method="post">
                    <div class = "row">
                          <div class="form-group col-md-12">
                            <input name ="cid" type="text" value="${requestScope.cid}" hidden="hidden" >
                            <input name ="did" type="text" value="${requestScope.dimension.id}" hidden="hidden" >
                            <label for = "dname" class="col-form-label font-weight-subject-overview">Dimension Name</label>
                            <div>
                                <input id = "dname" name ="dname" class="form-control" type="text" value="${requestScope.dimension.name}" placeholder="Enter dimension name..." >
                            </div>
                          </div>
                          <div class="form-group col-md-12">
                            <label for = "description" class="col-form-label font-weight-subject-overview">Description</label>
                            <div>
                                <input id = "description" name ="description" class="form-control" type="text" value="${requestScope.dimension.description}" placeholder="Enter description...">
                            </div>
                          </div>             
                          <div class = "status_pricepackage">
                            <span class = "font-weight-subject-overview">Dimension Type : </span>
                            <select style="text-transform: capitalize" id="dimensiontype_id" name = "dimensiontype_id">
                                <c:forEach items="${requestScope.dimensiontypes}" var ="dt">
                                    <option value ="${dt.id}" ${dt.id == requestScope.dimension.dimensionType.id?"selected = selected":""} >${dt.name}</option>
                                </c:forEach>
                            </select>
                          </div>    
                          <div class="col-12" style="margin-top: 10px; display: flex; justify-content: center">
                                <button type="submit" class="btn btn-success">Save Change</button>
                          </div>
                    </div>
                </form>
            </div>

           
        </div>
        </main>
        <div class="ttr-overlay"></div>
        <script>
            validateEditDimension();
            if(${requestScope.mess != null}){          
                Swal.fire(
                    'Update successfully',
                    'Update Price Package successfully ',
                    'success'
                          )
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
