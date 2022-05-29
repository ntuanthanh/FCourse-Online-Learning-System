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

