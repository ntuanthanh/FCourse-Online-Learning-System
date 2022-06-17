<%-- 
    Document   : newsubject
    Created on : Jun 13, 2022, 12:57:03 AM
    Author     : ADMIN
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Post</title>
        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../view/admin/assets/images/favicon.png" />
        <!--[if lt IE 9]>
<script src="assets/js/html5shiv.min.js"></script>
<script src="assets/js/respond.min.js"></script>
<![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../view/admin/assets/css/color/color-1.css">
        <script src="../js/ImgPreview/imgPreview.js" type="text/javascript"></script>
        <script src="//cdn.ckeditor.com/4.19.0/basic/ckeditor.js"></script>
        

        
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <jsp:include page="../../view/admin/header_admin.jsp" /> 

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Add Post</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Add Post</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Add Post</h4>
                            </div>
                            <div class="widget-inner">
                                <form action = "post" method="POST" id="validate-form-post-course" enctype="multipart/form-data">

                                    <div class="row">
                                        <div class="col-12">
                                            <div class = "text-center modal-edit-header"> 
<!--                                                <img  id = "avatar" class = "img-thumbnail img-fluid" src="#" alt=""/>
                                                <h6>Upload a thumbnail image</h6>
                                                <input value="{sessionScope.user.avatarImage}" type="text" hidden="hidden" name = "old_avatar_img"/>
                                                <input type="file" onchange="getImgPreview_profileUser(event)" name = "thumnail_img" class="text-center center-block file-upload">-->
                                                <img  id = "avatar" class = "img-thumbnail img-fluid" src="../images/blogdetail/noimage.jpg" alt=""/>
<!--                                                <img src="../../images/blogdetail/noimage.jpg" alt=""/>-->
                                                <h6>Upload a new photo</h6>
                                                <input value="noimage.jpg" type="text" hidden="hidden" name = "old_img_blog"/>
                                                <input type="file" onchange="getImgPreview_profileUser(event)" name = "img_blog" class="text-center center-block file-upload">
                                            </div> 

                                        </div>

                                        <div class="col-12">
                                            <div class="ml-auto">
                                                <h3>1. Basic info</h3>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Post title</label>
                                            <div>
                                                <input id="title" name="title" class="form-control" type="text" value="" required="">
                                            </div>
                                        </div>                                      
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Brief Info</label>
                                            <div>
                                                <input id="brief_info" name="brief_info" class="form-control" type="text" value="" required="">
                                            </div>
                                        </div>

                                        <div class="form-group col-6">
                                            <label class="col-form-label">Status</label>
                                            <div>
                                                <select name="status" class="chosen" style="width:17.6rem;" >
                                                    <!--<option value="allcategory">All</option>-->
                                                    <c:set var="status" value="${requestScope.statuss}"  />
                                                    <c:forEach begin="0" end="${status.size()-1}" var="i" >
                                                        <option value="${status.get(i).id}">${status.get(i).name}</option>
                                                    </c:forEach> 
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Post Featured</label>
                                            <div>
                                                <input style="width: 30px; height: 30px;" name="feature" type="checkbox" value="checked">
                                            </div>
                                        </div>
                                        <div class="seperator"></div>

                                        <div class="col-12 m-t20">
                                            <div class="ml-auto m-b5">
                                                <h3>2. Description</h3>
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Post description</label>
                                            <div>
                                                <textarea id="description" name="description" required class="form-control ckeditor"></textarea>
                                            </div>
                                        </div>

                                        <div class="seperator"></div>
                                        <div class="col-12 m-t20">                                                               
                                            <div class="ml-auto m-b5" >
                                                <h3 >3. Select Category</h3>
                                                <select name="category" class="chosen" style="width:17.6rem;" >
                                                    <!--<option value="allcategory">All</option>-->
                                                    <c:set var="categories" value="${requestScope.categories}"  />
                                                    <c:forEach begin="0" end="${categories.size()-1}" var="o" items="${categories}">
                                                        <option value="${categories.get(i).categoryID}">${o.value}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="seperator"></div>


                                        <div class="col-12" style="margin-top: 30px;">
                                            <button type="submit" class="btn">Add Post</button>
                                        </div>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- Your Profile Views Chart END-->
            </div>
        </div>
    </main>
    <div class="ttr-overlay"></div>

    <!-- External JavaScripts -->
    <script src="../view/admin/assets/js/jquery.min.js"></script>
    <script src="../view/admin/assets/vendors/bootstrap/js/popper.min.js"></script>
    <script src="../view/admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src="../view/admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="../view/admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
    <script src="../view/admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
    <script src="../view/admin/assets/vendors/counter/waypoints-min.js"></script>
    <script src="../view/admin/assets/vendors/counter/counterup.min.js"></script>
    <script src="../view/admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
    <script src="../view/admin/assets/vendors/masonry/masonry.js"></script>
    <script src="../view/admin/assets/vendors/masonry/filter.js"></script>
    <script src="../view/admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
    <script src='../view/admin/assets/vendors/scroll/scrollbar.min.js'></script>
    <script src="../view/admin/assets/js/functions.js"></script>
    <script src="../view/admin/assets/vendors/chart/chart.min.js"></script>
    <script src="../view/admin/assets/js/admin.js"></script>
    <script src='../view/admin/assets/vendors/switcher/switcher.js'></script>
    <script>
        // Pricing add
        function newMenuItem() {
            var newElem = $('tr.list-item').first().clone();
            newElem.find('input').val('');
            newElem.appendTo('table#item-add');
        }
        if ($("table#item-add").is('*')) {
            $('.add-item').on('click', function (e) {
                e.preventDefault();
                newMenuItem();
            });
            $(document).on("click", "#item-add .delete", function (e) {
                e.preventDefault();
                $(this).parent().parent().parent().parent().remove();
            });
        }

        getImgPreview_profileUser(event);
        
        
        function validateCoursePost(){     
           $('#validate-form-post-course').validate({
                   rules:{
                       title: {
                           required:true
                       },
                       brief_info: {
                           required:true,
                       }            
                   },
                   messages:{
                        title:{
                           required:"Enter your title - Don't leave it empty"
                        },
                        brief_info: {
                           required:"Enter your brief - Don't leave it empty",

                       }           
                    }
                });
        }
        validateCoursePost();    
    </script>
</body>
</html>