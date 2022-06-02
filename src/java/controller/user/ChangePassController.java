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
import model.User;

/**
 *
 * @author ADMIN
 */
public class ChangePassController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String raw_email = request.getParameter("email");
        String password = request.getParameter("password");
        String newpass = request.getParameter("newpass");
        String cf_pass = request.getParameter("cf_pass");
//        String phone = raw_phone;
//        boolean gender = raw_gender.equals("male");
//
//        User s = new User();
//
//        s.setEmail(raw_email);
//        s.setFullName(raw_name);
//        s.setPhone(phone);
//        s.setPassword(password);
//        s.setGender(gender);
        UserDBContext db = new UserDBContext();
        User user = db.getUser(raw_email, password);

        if (user != null && newpass != password) {          
            db.changePassword(raw_email, newpass);
//            request.setAttribute("messss", "Đổi mật khẩu thành công");  
//            request.setAttribute("alerterror",2 );
            response.sendRedirect("../../user/profile");
        }
        else 
        {
            String er = "Đổi mật khẩu không thành công";          
            request.setAttribute("messss", er);          
            request.setAttribute("alerterror",2);
            response.sendRedirect("../../user/profile");

            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
