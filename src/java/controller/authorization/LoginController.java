/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authorization;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author pv
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("home").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDBContext db = new UserDBContext();
        User user = db.getUser(email, password);
        if (user == null ) // login fail
        {
            String mess = "Tài khoản hoặc mật khẩu không tồn tại.";          
            request.setAttribute("mess", mess);  
            request.setAttribute("alerterror",1 );         
            request.getRequestDispatcher("home").forward(request, response);
        }
        else if (user.getStatus().getId() == 2 ) // login fail
        {
            String mess = "Tài khoản chưa kích hoạt. Mail kích hoạt đã gửi.";          
            request.setAttribute("mess", mess);  
            request.setAttribute("alerterror",1 );         
            request.getRequestDispatcher("home").forward(request, response);
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("home");
        }

//        String Username = request.getParameter("email");
//        String Password = request.getParameter("password");
//        
//        UserDBContext db = new UserDBContext();
//        User user = db.getUser(Username, Password);
//      
//        if (user != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user);      
//            response.sendRedirect("home");
//        } else {
//            String er = "Tài khoản hoặc mật khẩu không tồn tại.";          
//            request.setAttribute("er", er);            
//            request.getRequestDispatcher("view/login.jsp").forward(request, response);
//        }  
    }

}
