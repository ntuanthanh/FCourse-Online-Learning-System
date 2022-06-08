function validateEditProfile(){     
   $('#validate-form-edit-profile').validate({
           rules:{
               fullname: {
                   required:true
               },
               phone: {
                   required:true,
                   number: true,
                   minlength : 10,
                   maxlength : 12
               }            
           },
           messages:{
                fullname:{
                   required:"Enter your name - Don't leave it empty"
                },
                phone: {
                   required:"Enter your phone - Don't leave it empty",
                   number: "Enter number phone - Dont String",
                   minlength: "phone number from 10 -> 12 numbers",
                   maxlength: "phone number from 10 -> 12 numbers "
               }           
            }
        });
}

function validate_form_change_password(){ 
        $('#validate-form-change-password').validate({
            rules: {
                password_change_password: {
                    required: true
                },
                newpass_change_password: {
                    required: true
                },
                confirm_password_change_password: {
                    equalTo: "#password_change_password"
                }
            },
            messages: {
                password_change_password: {
                    required: "Mật khẩu không được bỏ trống"
                },
                newpass_change_password: {
                    required: "Mật khẩu mới không được bỏ trống"
                },
                confirm_password_change_password: {
                    equalTo: "Mật khẩu không khớp với mật khẩu mới bạn vừa nhập"
                }
            }
        });
}

