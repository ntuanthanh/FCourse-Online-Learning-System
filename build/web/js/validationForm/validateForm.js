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

function validateSendResetPassword(){
     $('#validate-form-send-reset-password').validate({
           rules:{
               email: {
                   required:true, 
                   email : true
               }           
           },
           messages:{
                email:{
                   required:"Enter your email - Don't leave it empty", 
                   email : "Please provide an Email address"
                }       
            }
        });   
}
function validateResetPassword(){
     $('#validate-form-reset-password').validate({
           rules:{
               password: {
                   required:true,
                   minlength : 4
               },
               confirm_password:{
                   required:true,
                   equalTo: "#password"
               }
           },
           messages:{
               password: {
                   required:"Please provide a password",
                   minlength: "Your password must be at least 4 characters"
               },
               confirm_password: {
                   required:"Please provide a password",
                   equalTo:"The passwords do not match"
               }
            }
        });
}    

