<%-- 
    Document   : postdetail
    Created on : Jun 14, 2022, 5:22:46 PM
    Author     : tuann
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <link href="${pageContext.request.contextPath}/css/header.css" rel="stylesheet" type="text/css"/>
        <script src="//cdn.ckeditor.com/4.19.0/basic/ckeditor.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/postdetail.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="detail" method="POST">
            <div class="row">
                <div class="col-12" style = "margin-left: 12px">
                    <div class="ml-auto">
                        <h5 class = "title-overview-course">Post Details</h5>
                    </div>
                </div>
                <div class = "col-12 col-md-6">
                    <div class="form-group col-12">
                        <label for = "course_title" class="col-form-label font-weight-subject-overview">Title</label>
                            <div>
                                <input id = "course_title" name ="blog_title" class="form-control" type="text" value="${requestScope.blog.title}">
                            </div>
                    </div>
                    <div class="form-group col-12">
                        <label for = "category" class="col-form-label font-weight-subject-overview">Catgory</label>
                        <div>
                            <select class="form-control" id="categoryID" name = "categoryID">
                                <c:forEach items = "${requestScope.categories}" var = "c">
                                    <option ${requestScope.blog.categoryId == c.categoryID?"selected = selected":""} value = "${c.categoryID}">${c.value}</option>
                                </c:forEach>                                        
                            </select>
                        </div>
                    </div> 
                    <div class="form-group col-12">
                        <label for ="blog_brief" class="col-form-label font-weight-subject-overview">Brief Information</label>
                            <div>
                                <textarea id ="course_briefinfo" class="form-control" name = "blog_brief">${blog.brief}</textarea>
                            </div>
                    </div>
                    <div class = "row" style="margin-left: 1px;">
                        <div class="col-6">                                          
                            <div>
                                <input type="checkbox" ${blog.feature == true?"checked= checked":""} id = "featured_subject" name = "featured_blog">
                                <label for="featured_subject" class="col-form-label font-weight-subject-overview">Featured Post</label>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class = "status-subject">
                                <span class = "font-weight-subject-overview">Status : </span>   
                                <select id="status" name = "status_id">
                                    <c:forEach items="${requestScope.statuses}" var ="s">
                                         <option ${requestScope.blog.statusId == s.id?"selected = selected":""} value = "${s.id}">${s.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class = "col-12 col-md-6"> 
                    <img  id = "img_course" class = "img-thumbnail img-fluid" src="../../images/courses/java.png" alt="" style="width: 600px; height: 300px; object-fit: cover;"/>
                    <h6>Upload a new thumbnail image</h6>
                    <input value="" type="text" hidden="hidden" name = "old_img_course"/>
                    <input type="file" onchange="getImgPreview_SubjectOverview(event)" name = "img_course" class="text-center center-block file-upload">
                </div>
                <div class="form-group col-12" >
                    <label for ="course_description" class="col-form-label font-weight-subject-overview">Post Description</label>
                    <div style="width: 100%">
                        <textarea id="course_description" class="form-control ckeditor" name="content_blog" >${requestScope.blog.content}</textarea>
                    </div>
                </div>
                <input type="hidden" name="bid" value="${requestScope.blog.id}">

                <div class="col-12" style="margin-left: 12px">
                    <button type="submit" class="btn btn-success">Save changes</button>
                </div>
            </div>
        </form>
    </body>
</html>
