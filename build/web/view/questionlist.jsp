<%-- 
    Document   : questionlist
    Created on : Jun 13, 2022, 4:11:12 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../assets/images/favicon.png" />
        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <!--<link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">-->


        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>

    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <jsp:include page="../view/base/header_t.jsp" /> 
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner2.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Question List</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Question List</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- contact area -->
                <!--                <div class="container" style="margin-top: 20px;">
                                    <div class="row">-->
                <!-- Left part start -->

                <!--                    </div>
                                </div>-->
            </div>
            <!--                <div class="content-block">
                                <div class="section-area section-sp1">-->
            <div class="container">
                <div class="row">
                    <!-- Left part start -->
                    <div class="col-lg-12">
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Question List</h1> 
                            
                            <button style="margin-left: 85%; padding: 20px; margin-bottom: 10px" type="file" class="btn">Question Import</button> <br/>
                            <form  method="GET">
                                <div class="breadcrumb mb-4">

                                    <div class="col-lg-12">

                                        <div class="widget widget_tag_cloud">
                                            <h6 class="widget-title">Subject Dimension</h6>

                                            <div class="tagcloud " > 
                                                <select name="dimensions" style="width:17.6rem;" >
                                                    <option value="-1">--Dimension--</option>
                                                    <c:set var="dimensions" value="${requestScope.dimensions}"  />
                                                    <c:forEach begin="0" end="${dimensions.size()-1}" var="i">
                                                        <!--<option value="${dimensions.get(i).id}">${dimensions.get(i).name}</option>-->
                                                        <option
                                                            ${(dimensions.get(i).id==requestScope.did)?"selected=\"selected\"":""}
                                                            value="${dimensions.get(i).id}">${dimensions.get(i).name}</option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                        </div>
                                    </div>     
                                    <div class="col-lg-12">

                                        <div class="widget widget_tag_cloud">
                                            <h6 class="widget-title">Status</h6>

                                            <div class="tagcloud " > 
                                                <select name="status" style="width:17.6rem;" >
                                                    <option value="-1">--Status--</option>
                                                    <c:set var="status" value="${requestScope.status}"  />
                                                    <c:forEach begin="0" end="${status.size()-1}" var="i">
                                                        <option 
                                                            ${(status.get(i).id==requestScope.stt)?"selected=\"selected\"":""}
                                                            value="${status.get(i).id}">${status.get(i).name}</option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                        </div>
                                    </div>     
                                    <div class="col-lg-12">
                                        <div class="widget widget_tag_cloud">
                                            <h6 class="widget-title">Level</h6>
                                            <div class="tagcloud">
                                                <c:forEach items="${requestScope.quizlevels}" var="c">
                                                    <a> <div class="cate-card">  
                                                            <label class="cate-item">   
                                                                <!--<input type="hidden" name="qid" value="${c.id}">-->
                                                                <input style="margin: 5px;" type="checkbox" name="qid" 
                                                                       <c:if test="${qid.size() > 0}">
                                                                       <c:forEach var="i" begin="0" end="${qid.size() - 1}" >    
                                                                           ${(qid.get(i)==c.id)?"checked=\"checked\"":""}   
                                                                       </c:forEach>   </c:if>

                                                                       value="${c.id}" value="checked"/> <span> ${c.levelName} </span>
                                                            </label>
                                                        </div>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <button type="submit" class="btn">Filter</button>
                                    </div>



                                </div>
                            </form>
                        </div>
                        <!--                            <div class="card mb-4">
                                                        <div class="card-body">
                                                            DataTables 
                                                            .
                                                        </div>
                                                    </div>-->
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Question List
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple" border=1px; >
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Content</th>   
                                            <th>Four option of Question</th>
                                            <th>Answer</th>
                                            <th>Explainaton</th>
                                            <th>Course Name</th>
                                            <th>Level</th>
                                           
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Content</th>  
                                            <th>Option</th>
                                            <th>Answer</th>
                                            <th>Explainaton</th>
                                            <th>Course</th>
                                            <th>Level</th>
                                           
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody >
                                        <c:forEach items="${requestScope.list}" var="b">
                                            <tr>
                                                <td>${b.id}</td>

                                                <td><div style="word-wrap: break-word"> ${b.content} </div>
                                                </td>
                                                <td>
                                                    <ul style="margin-left: 10px;">
                                                        <li><strong>A.</strong> ${b.option1}</li>
                                                        <li><strong>B.</strong> ${b.option2}</li>
                                                        <li><strong>C.</strong> ${b.option3}</li>
                                                        <li><strong>D.</strong> ${b.option4}</li>
                                                    </ul>
                                                </td>

                                                <td>${b.answer}</td>     
                                                <td>${b.explain}</td>

                                                <td>${b.course.title}</td>
                                                <td>${b.quizlevel.levelName}</td>
                                              
                                                <td><a href="" style="color: blue">Detail</a> / <a href="" style="color: blue">Edit</a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Left part END -->
                <!-- Side bar start -->

                <!-- Side bar END -->
            </div>
        </div>
        <!--                    </div>
                        </div>-->
    </div>
    <!-- Content END-->
    <!-- Footer ==== -->
    <jsp:include page="../view/base/footer_t.jsp" /> 
    <!-- Footer END ==== -->
    <!-- scroll top button -->
    <button class="back-to-top fa fa-chevron-up" ></button>
</div>
<!-- External JavaScripts -->
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/vendors/bootstrap/js/popper.min.js"></script>
<script src="../assets/vendors/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
<script src="../assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="../assets/vendors/magnific-popup/magnific-popup.js"></script>
<script src="../assets/vendors/counter/waypoints-min.js"></script>
<script src="../assets/vendors/counter/counterup.min.js"></script>
<script src="../assets/vendors/imagesloaded/imagesloaded.js"></script>
<script src="../assets/vendors/masonry/masonry.js"></script>
<script src="../assets/vendors/masonry/filter.js"></script>
<script src="../assets/vendors/owl-carousel/owl.carousel.js"></script>
<script src="../assets/js/functions.js"></script>
<script src="../assets/js/contact.js"></script>
<script src='../assets/vendors/switcher/switcher.js'></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="../js/datatables-simple-demo.js"></script>
</body>

</html>
