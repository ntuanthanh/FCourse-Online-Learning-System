<%-- 
    Document   : profile_temp_pop_up
    Created on : May 19, 2022, 8:16:07 PM
    Author     : pv
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <link href="../css/profile_user.css" rel="stylesheet" type="text/css"/>
        <script src="../js/validationForm/validateForm.js" type="text/javascript"></script>
        <script src="../js/ImgPreview/imgPreview.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="../base/header.jsp" /> 
        <!--Content -->
        <div class = "content-profile">
            <div class = row>
                <div class = "col-md-4 text-center main-profile"> 
                    <img class = "rounded-circle img-thumbnail img-fluid" src="../images/avatar/${sessionScope.user.avatarImage}" alt=""/>
                    <h4>${sessionScope.user.fullName}</h4>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        Edit Profile
                    </button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal-ChangePassword">
                        Change Password
                    </button>
                </div>
                <div class = "col-md-8 main-information"> 
                    <h4>Information</h4>
                    <table>
                        <tr>
                            <td><h5 class = "information-detail">Full Name</h5></td>
                            <td><p>${sessionScope.user.fullName}<p></td>
                        </tr>
                        <tr>
                            <td><h5 class = "information-detail">Email</h5></td>
                            <td><p>${sessionScope.user.email}<p></td>
                        </tr>
                        <tr>
                            <td><h5 class = "information-detail">Phone</h5></td>
                            <td><p>${sessionScope.user.phone}<p></td>
                        </tr>
                        <tr>
                            <td><h5 class = "information-detail">Gender</h5></td>
                            <td><p>${sessionScope.user.gender==true?"Male":"Female"}<p></td>
                        </tr>
                    </table>
                </div>
            </div>
            <!--Modal of edit profile -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <!-- Modal body of edit profile -->
                        <div class="modal-body">
                            <div class = "edit-profile">
                                <div class = "edit-profile-header">
                                    <h3>Edit My Profile</h3>
                                </div>
                                <form id ="validate-form-edit-profile" action = "../user/profile/update" method="POST" enctype="multipart/form-data">
                                    <div class = "text-center modal-edit-header"> 
                                        <img  id = "avatar" class = "rounded-circle img-thumbnail img-fluid" src="../images/avatar/${sessionScope.user.avatarImage}" alt=""/>
                                        <h6>Upload a new photo</h6>
                                        <input value="${sessionScope.user.avatarImage}" type="text" hidden="hidden" name = "old_avatar_img"/>
                                        <input type="file" onchange="getImgPreview_profileUser(event)" name = "avatar_img" class="text-center center-block file-upload">
                                    </div>
                                    <div class = "edit-profile-form">
                                        <input type = "text" name = "id" hidden ="hidden" value = "${sessionScope.user.id}"/><br>
                                        <div class = "edit-profile-form-item form-group">
                                            <label for="fullname" class="mr-sm-2">Full Name</label>
                                            <input type="text" id = "fullname" class="form-control" name ="fullname" placeholder="Nhập vào họ tên" value = "${sessionScope.user.fullName}">
                                        </div>
                                        <div class = "edit-profile-form-item form-group">
                                            <label for="email" class="mr-sm-2">Email</label>
                                            <input id = "email" class="form-control" name ="email" value = "${sessionScope.user.email}" disabled> 
                                        </div>   
                                        <div class = "edit-profile-form-item form-group">
                                            <label for="phone" class="mr-sm-2">Phone</label>
                                            <input type="text" id = "phone" class="form-control" name ="phone" value = "${sessionScope.user.phone}">
                                        </div>   
                                        <div class = "edit-profile-form-item form-group">
                                            <label class="mr-sm-2">Gender</label>
                                            <div style="display: flex;">
                                                <input
                                                    <c:if test = "${sessionScope.user.gender == true}">
                                                        checked = "checked"
                                                    </c:if>
                                                    type="radio" id="male" name = "gender" value ="male"/><p style="margin-right: 10px;" for = "male">Male</p>
                                                <input 
                                                    <c:if test = "${sessionScope.user.gender != true}">
                                                        checked = "checked"
                                                    </c:if>
                                                    type="radio" id="female" name = "gender" value ="female"/><p for = "female" >Female</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class = "edit-profile-submit">
                                        <button class="btn btn-success" type="submit">Update</button>
                                    </div>
                                </form>   
                            </div> 
                        </div>
                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>          
            </div>
        </div>
           <!--Modal of change password -->
        <div class="modal fade" id="myModal-ChangePassword">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                     change password 
                    <div class="modal-body">
                        <form id ="validate-form-change-password" action = "../user/profile/changepass" method="POST">
                            <div class = "edit-profile-form">
                                <input type = "text" name = "id" hidden ="hidden" value = "${sessionScope.user.id}"/><br>

                                <div class = "edit-profile-form-item form-group">
                                    <label for="email" class="mr-sm-2">Email</label>
                                    <input id = "email_change_password" class="form-control" value = "${sessionScope.user.email}" disabled> 
                                    <input name ="email" value = "${sessionScope.user.email}" hidden = "hidden">
                                </div>   

                                <div class = "edit-profile-form-item form-group">
                                    <label for="password" class="mr-sm-2">Old Password</label>
                                    <input id ="password_change_password" class="form-control" name ="password" value = "" > 
                                </div>  

                                <div class = "edit-profile-form-item form-group">
                                    <label for="" class="mr-sm-2">New Password</label>
                                    <input id="newpass_change_password" class="form-control" name ="newpass" value ="" > 
                                </div>  

                                <div class = "edit-profile-form-item form-group">
                                    <label for="confirm_pass" class="mr-sm-2">Confirm Password </label>
                                    <input id="confirm_pass_change_password" class="form-control" name ="confirm_pass" value = ""> 
                                </div>  
                            </div>
                            <div class = "edit-profile-submit">
                                <button class="btn btn-success" type="submit">Change Password</button>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>          
        </div>                           
        <!--Footer-->
        <jsp:include page="../base/footer.jsp" />
        <script>
           validateEditProfile();
           validate_form_change_password();
           getImgPreview_profileUser(event); 
        </script>
    </body>
</html>
