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
        <title>Update Post</title>
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
                    <h4 class="breadcrumb-title">Update Post</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Update Post</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Update Post</h4>
                            </div>
                            <div class="widget-inner">
                                <form action = "detail" method="POST" enctype="multipart/form-data">

                                    <div class="row">
                                        <div class="col-12">
                                            <div class = "text-center modal-edit-header"> 
                                                <img  id = "avatar" class = "img-thumbnail img-fluid" src="../images/blogdetail/${requestScope.blog.thumbnail}" alt="" style="width: 500px; height: 300px"/>
                                                <h6>Upload new thumbnail image</h6>
                                                <input value="${requestScope.blog.thumbnail}" type="text" hidden="hidden" name = "old_img_blog"/>
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
                                                <input name="blog_title" class="form-control" type="text" value="${requestScope.blog.title}">
                                            </div>
                                        </div>                                      
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Brief Info</label>
                                            <div>
                                                <input name="blog_brief" class="form-control" type="text" value="${blog.brief}">
                                            </div>
                                        </div>

                                        <div class="form-group col-6">
                                            <label class="col-form-label">Status</label>
                                            <div>
                                                <select name="status_id" class="chosen" style="width:17.6rem;" >
                                                    <!--<option value="allcategory">All</option>-->
                                                    <c:forEach items="${requestScope.statuss}" var ="s">
                                                        <option ${requestScope.blog.statusId == s.id?"selected = selected":""} value = "${s.id}">${s.name}</option>
                                                   </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Post Featured</label>
                                            <div>
<!--                                                <input style="width: 30px; height: 30px;" name="featured_blog" type="checkbox" value="checked">-->
                                                <input style="width: 30px; height: 30px;" type="checkbox" ${blog.feature == true?"checked= checked":""} id = "featured_subject" name = "featured_blog">
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
                                                
                                                <textarea class="form-control ckeditor" name="content_blog" >${requestScope.blog.content}</textarea>
                                            </div>
                                        </div>

                                        <div class="seperator"></div>
                                        <div class="col-12 m-t20">                                                               
                                            <div class="ml-auto m-b5" >
                                                <h3 >3. Select Category</h3>
                                                <select name="categoryID" class="chosen" style="width:17.6rem;" >
                                                    <!--<option value="allcategory">All</option>-->
                                                    <c:forEach items = "${requestScope.categories}" var = "c">
                                                        <option ${requestScope.blog.categoryId == c.categoryID?"selected = selected":""} value = "${c.categoryID}">${c.value}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="seperator"></div>
                                        <input type="hidden" name="bid" value="${requestScope.blog.id}">


                                        <div class="col-12" style="margin-top: 30px;">
                                            <button type="submit" class="btn">Save change</button>
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
    </script>
</body>
</html>
