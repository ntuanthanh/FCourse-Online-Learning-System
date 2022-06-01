/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author pv
 */
public class ResetPasswordController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get token from user req : 
        String tokenRest = request.getParameter("token");
        UserDBContext userDB = new UserDBContext(); 
        // get User by this token to see token does exist 
        User user = userDB.GetUserByToken(tokenRest); 
        //If resetToken exist in database and have mapping one account
        if(user != null){
            try {
                long ExpirationTime = Long.parseLong(getServletConfig().getInitParameter("ExpirationTime"));
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date currentDate = new java.util.Date(); // current time went user click link 
                Date createTimeResetToken = sdfDate.parse(user.getCreateTimeResetToken()); // create time of token
                long duration = currentDate.getTime() - createTimeResetToken.getTime(); // Get msec of duration  
                long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration); // currentDate more than xMinute with createTimeResetToken 
                if(diffInMinutes <= ExpirationTime && diffInMinutes >= 0){
                    // gửi user and token reset
                    request.setAttribute("resetToken", user.getResetToken());
                    request.getRequestDispatcher("../view/user/reset_password.jsp").forward(request, response);
                }else{
                    // error message time out
                    request.setAttribute("err", "Time out");
                    request.getRequestDispatcher("../view/base/404page.jsp").forward(request, response);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ResetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{ //If resetToken doesn't exist in database and dont mapping any account
            // error message 
            request.setAttribute("err", "An unspecified error occurred");
            request.getRequestDispatcher("../view/base/404page.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Trường hợp 2 : nếu người dùng vào được link và form nhưng k ấn liền mà đến khi hết thời gian mới submit thì phải chặn 
        // get token from user req : 
        String resetToken = request.getParameter("resetToken"); 
        UserDBContext userDB = new UserDBContext(); 
        // get User by this token to see token does exist 
        User user = userDB.GetUserByToken(resetToken); 
        //If resetToken exist in database and have mapping one account
        if(user != null){
            try {
                long ExpirationTime = Long.parseLong(getServletConfig().getInitParameter("ExpirationTime"));
                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date currentDate = new java.util.Date(); // current time went user click link 
                Date createTimeResetToken = sdfDate.parse(user.getCreateTimeResetToken()); // create time of token
                long duration = currentDate.getTime() - createTimeResetToken.getTime(); // Get msec of duration  
                long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration); // currentDate more than xMinute with createTimeResetToken 
                if(diffInMinutes <= ExpirationTime && diffInMinutes >= 0){
                    // Reset password 
                    String password = request.getParameter("password"); 
                    userDB.resetPassword(resetToken, password);
                    // successfully reset password and send message to user
                    request.setAttribute("mess_header", "Reset Password Successfully");
                    request.setAttribute("mess_main", "You can login here");
                    request.getRequestDispatcher("../view/user/successful_reset_password.jsp").forward(request, response);
                }else{
                    // error message time out
                    request.setAttribute("err", "Time out");
                    request.getRequestDispatcher("../view/base/404page.jsp").forward(request, response);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ResetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{ //If resetToken doesn't exist in database and dont mapping any account
            // error message 
            request.setAttribute("err", "An unspecified error occurred");
            request.getRequestDispatcher("../view/base/404page.jsp").forward(request, response);
        }
    }

}
