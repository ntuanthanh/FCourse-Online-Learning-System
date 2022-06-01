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
import utility.SendEmail;

/**
 *
 * @author ADMIN
 */
public class UserRegisterController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
       String raw_email = request.getParameter("email");
        String raw_name = request.getParameter("fullname");
        String raw_phone = request.getParameter("phone");
        String raw_gender = request.getParameter("gender");
        String password = request.getParameter("password");

        String phone = raw_phone;
        boolean gender = raw_gender.equals("male");

        User s = new User();

        s.setEmail(raw_email);
        s.setFullName(raw_name);
        s.setPhone(phone);
        s.setPassword(password);
        s.setGender(gender);
        s.setAvatarImage("non-avatar.png");
        UserDBContext db = new UserDBContext();
        int userid = db.insertUser(s);
        String link = "http://localhost:8080\"+ request.getContextPath()+\"/user/verify?id="+userid;

        SendEmail y = new SendEmail();
        y.send(raw_email, content(link), "SUB");
        response.getWriter().print(userid);

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

    
    String content(String a) {
        String ct = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>JSP Page</title>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <h1>VERIFY ACCOUNT</h1>\n"
                + "        \n"
                + "        <p>Click to link: </p>\n" + a 
                + "        \n"
                + "    </body>\n"
                + "</html>";
        return ct;

    }
}
