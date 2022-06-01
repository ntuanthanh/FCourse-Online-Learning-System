/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utility.Generate;
import utility.SendEmail;

/**
 *
 * @author pv
 */
public class SendResetPasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../view/user/send_reset_password.jsp").forward(request, response);
    }
    /*
       Send email of user to reset password
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // User send email want to reset password
        String email = request.getParameter("email"); 
        UserDBContext userDB = new UserDBContext(); 
        String err; 
        if(!userDB.CheckEmailExist(email)){
            err = "Email does not exist in the system"; 
            request.setAttribute("err", err);
            request.getRequestDispatcher("../view/user/send_reset_password.jsp").forward(request, response);
        }else{ //send email : 
            // Using UUID to generate reset_token for user
            String reset_token; 
            while(true){
               Generate generate = new Generate();
               // generate reset token by using UUID
               reset_token = generate.generateResetToken();
               if(!userDB.CheckResetToken(reset_token)){
                   break; 
               }
            }
            // After make sure reset token dont exist in database then insert reset token and date create token for user
            userDB.CreateReset_token(email, reset_token);
            // Send mail for user
            SendEmail sendEmail = new SendEmail();
            String subject = "Your Fcourse password reset link";
            String content = "<a href = \"http://localhost:8080"+ request.getContextPath()+"/reset/recoverpassword?token="+ reset_token +"\">Click this link to reset password</a>";            
            sendEmail.send(email, content, subject);
            // successfully send email and send message to user
            request.setAttribute("mess_header", "Your request has been processed");
            request.setAttribute("mess_main", "You will receive an email with instructions for changing your password.");
            request.getRequestDispatcher("../view/user/successful_reset_password.jsp").forward(request, response);
        }
    }
   
}
