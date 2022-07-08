/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author pv
 */
public class AjaxSearchExpert_SubjectDetailController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        UserDBContext userDB = new UserDBContext();
        ArrayList<User> users = userDB.seachUserByEmailName(txtSearch); 
        for (User user : users) {
//            response.getWriter().println(" <input name =\"search_expert\" class=\"form-control result_search\" type=\"text\" value=\" "+user.getEmail()+" \" disabled>");
              response.getWriter().print("<li onclick=\"addExpert(this)\" id='"+user.getId()+"'>"+user.getFullName() +"( " +user.getEmail() + " )"+"</li>");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

 
}
