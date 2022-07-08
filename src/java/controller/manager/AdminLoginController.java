/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author ADMIN
 */
public class AdminLoginController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../view/admin/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDBContext db = new UserDBContext();
        User user = db.getUser(email, password);
      //  int roleid = 1;
        if (user == null ) // login fail
        {
            String mess = "Tài khoản hoặc mật khẩu không tồn tại.";          
            request.setAttribute("mess", mess);  
//            request.setAttribute("alerterror",1 );         
            request.getRequestDispatcher("../view/admin/login.jsp").forward(request, response);
        }
        else if (user.getStatus().getId() == 2 ) // login fail
        {
            String mess = "Tài khoản chưa kích hoạt. Mail kích hoạt đã gửi.";          
            request.setAttribute("mess", mess);  
       //     request.setAttribute("alerterror",1 );
            
            request.getRequestDispatcher("../view/admin/login.jsp").forward(request, response);
        }
        else if ( db.getRoleUser(user.getId())== 1 || db.getRoleUser(user.getId()) == 2 || db.getRoleId(user.getId()) == 4 ||db.getRoleId(user.getId()) == 5 ) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("../admin/dashboard");
        }else{
            String mess = "Bạn không có quyền vào trang này";          
            request.setAttribute("mess", mess);  
       //     request.setAttribute("alerterror",1 );
            
            request.getRequestDispatcher("../view/admin/login.jsp").forward(request, response);
        }
     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
