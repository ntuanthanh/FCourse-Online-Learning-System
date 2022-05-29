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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author pv
 */
public abstract class BaseAuthController extends HttpServlet {
    
    private boolean isAuthenticated(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user"); 
        return user != null; 
    }
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(isAuthenticated(request)){
            // bussiness logic
            processGet(request, response);           
        }else{
           response.sendRedirect(request.getContextPath()+"/login");
        }
    }
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(isAuthenticated(request)){
            // bussiness logic
            processPost(request, response);
        }else{
           response.sendRedirect(request.getContextPath()+"/login");
        }
    }
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

}
