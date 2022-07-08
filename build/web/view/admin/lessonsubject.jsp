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
        <title>Subject Lesson</title>
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
        <link href="../css/subjectlesson.css" rel="stylesheet" type="text/css"/>

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="../view/admin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../view/admin/assets/css/color/color-1.css">
        <script src="../js/ImgPreview/imgPreview.js" type="text/javascript"></script>
        <script src="//cdn.ckeditor.com/4.19.0/basic/ckeditor.js"></script>
        <script src="../js/pagination/pagging_subjectlesson.js" type="text/javascript"></script>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="../../view/admin/header_admin.jsp" /> 
        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Subject Lesson</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Subject Lesson</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>${requestScope.course.title}</h4>
                            </div>
                            <div class="widget-inner">
                                
                                <form action="lesson" method="GET" id="searchFRM" onchange="submitData();">
                                    <div class="row">
                                    <div class="form-group col-4">
                                        <label class="col-form-label">Select Topic</label>
                                        <select name="tid" class="chosen" style="width:17.6rem;">
                                            <option value="-1">All lesson group</option>
                                            <c:forEach items="${requestScope.topics}" var="t">
                                                <option 
                                                    ${(t.getId()==requestScope.tid)?"selected=\"selected\"":""}
                                                    value="${t.id}">${t.topicName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group col-4">
                                        <label class="col-form-label">Select Status</label>
                                        <select name="sid" class="chosen" style="width:17.6rem;">
                                            <option value="-1">All status</option>
                                            <c:forEach items="${requestScope.statuses}" var="s">
                                                <option 
                                                    ${(s.getId()==requestScope.sid)?"selected=\"selected\"":""}
                                                    value="${s.id}">${s.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>    
                                    <div class="form-group col-4">
                                        <label class="col-form-label">Search Lesson</label>
                                        <input type="text" name="name" class="form-control" placeholder="Enter Searching..."  value="${requestScope.name}">
                                    </div> 
                                    
                                    <input type="hidden" name="cid" value="${requestScope.cid}">
                                    <div class="col-12" style="margin-bottom: 30px;">
                                            <button type="submit" class="btn" >Search</button>
                                    </div>    
                                    </div>
                                 <a href="../LessonDetail?cid=${requestScope.cid}">add lesson</a>       
                                        
                                </form>
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table">
                                            <tr>
                                              <th class="table__heading">ID</th>
                                              <th class="table__heading">Lesson</th>
                                              <th class="table__heading">Order</th>
                                              <th class="table__heading">Type</th>
                                              <th class="table__heading">Status</th>
                                              <th class="table__heading">Action</th>
                                            </tr>
                                            <c:forEach items="${requestScope.searchsubjectlesson}" var="l">
                                                <tr class="table__row">
                                                    <td class="table__content" data-heading="Player">${l.id}</td>
                                                    <td class="table__content" data-heading="Seasons">${l.lessonname}</td>
                                                    <td class="table__content" data-heading="Points">${l.lessonorder}</td>
                                                    <td class="table__content" data-heading="Jersey Number">Subject Topic</td>
                                                    <td class="table__content" data-heading="Teams">${l.status.name}</td>
                                                    <td class="table__content" data-heading="Career"><a href="../LessonDetail?cid=${requestScope.cid}&Lid=${l.id}">Edit</a> | 
                                                        <c:if test="${l.status.id==1}">
                                                            <a href="../lesson/updatestatus?lid=${l.id}&sid=${requestScope.sid}&cid=${requestScope.cid}&tid=${requestScope.tid}&name=${requestScope.name}">Inactive</a></td>
                                                        </c:if>
                                                        <c:if test="${l.status.id==2}">
                                                            <a href="../lesson/updatestatus?lid=${l.id}&sid=${requestScope.sid}&cid=${requestScope.cid}&tid=${requestScope.tid}&name=${requestScope.name}">Active</a></td>
                                                        </c:if>
                                                </tr>
                                            </c:forEach>


                                          </table>
                                        <div style="display: flex; justify-content: center">
                                            <ul class="pagination" id = "paggerBottomSubjectLesson">

                                            </ul>
                                        </div>
                                    </div>
                                </div>
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
        pagger_Lessons("paggerBottomSubjectLesson",2,${requestScope.totalPage},${requestScope.pageIndex},'${requestScope.url}'); 
        
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
