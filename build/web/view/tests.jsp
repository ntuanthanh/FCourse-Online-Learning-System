<%-- 
    Document   : tests
    Created on : Jun 2, 2022, 4:08:13 PM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <form id = "testss" action = "a">
            <input type="text" name ="testoke"/>
            <div class="form-group">
               <input type ="submit" value ="submit" > 
            </div>
        </form>
        <script>
            $('#testss').validate({
           rules:{
               testoke: {
                   required:true             
               }           
           },
           messages:{
                testoke:{
                   required:"Enter your email - Don't leave it empty"               
                }       
            }
        });             
        </script>
    </body>
</html>
