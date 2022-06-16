<%-- 
    Document   : subjectlesson
    Created on : Jun 13, 2022, 6:40:50 PM
    Author     : tuann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lesson View</title>
        <meta charset="utf-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="../css/subjectlesson.css" rel="stylesheet" type="text/css"/>
        <!------ Include the above in your HEAD tag ---------->
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-3 ">
                    <a href="" style="padding-bottom: 140px">Home</a>
                    
                    <div class="list-group " style="margin-top: 135px">
                        <a href="#" class="list-group-item list-group-item-action active">Subject Lesson</a>
                        <a href="#" class="list-group-item list-group-item-action">Subject detail (add lesson)</a>
                        <a href="#" class="list-group-item list-group-item-action">Exit</a>
                    </div> 
                </div>
		<div class="col-md-9">
		    <div class="card">
		        <div class="card-body">
		            <div class="row">
		                <div class="col-md-12">
		                    <h4>Subject Lesson</h4>
                                    <h5>Subject name: ${requestScope.course.title}</h5>
                                    <form action="lesson" method="GET" id="searchFRM" onchange="submitData();">
                                        <select name="tid" style="margin-right: 30px">
                                            <option value="-1">All lesson group</option>
                                            <c:forEach items="${requestScope.topics}" var="t">
                                                <option 
                                                    ${(t.getId()==requestScope.tid)?"selected=\"selected\"":""}
                                                    value="${t.id}">${t.topicName}</option>
                                            </c:forEach>
                                        </select>
                                        <select name="sid" style="margin-right: 30px">
                                            <option value="-1">All status</option>
                                            <c:forEach items="${requestScope.statuses}" var="s">
                                                <option 
                                                    ${(s.getId()==requestScope.sid)?"selected=\"selected\"":""}
                                                    value="${s.id}">${s.name}</option>
                                            </c:forEach>
                                        </select>
                                        <input type="text" name="name" placeholder="Enter Searching..." style="height: 20px">
                                        <input type="hidden" name="cid" value="${requestScope.cid}">
                                        <button class="button-36" type="submit" class="search-btn" >
                                            submit
                                        </button>
                                        
                                        
                                    </form>
		                    <hr>
		                </div>
		            </div>
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
                                        <td class="table__content" data-heading="Career"><a href="#">Edit</a> | 
                                            <c:if test="${l.status.id==1}">
                                                <a href="../lesson/updatestatus?lid=${l.id}&sid=${requestScope.sid}&cid=${requestScope.cid}&tid=${requestScope.tid}">Inactive</a></td>
                                            </c:if>
                                            <c:if test="${l.status.id==2}">
                                                <a href="../lesson/updatestatus?lid=${l.id}&sid=${requestScope.sid}&cid=${requestScope.cid}&tid=${requestScope.tid}">Active</a></td>
                                            </c:if>
                                            
                                    </tr>
                                </c:forEach>
                                
                                  
                              </table>
                                    
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
            </div>
        </div>
    </body>


</html>

