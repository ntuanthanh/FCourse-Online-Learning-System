/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authorization.BaseAuthController;
import dal.CategoryDBContext;
import dal.UserCourseDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.User;
import model.UserCourse;

public class MyRegistrationController extends BaseAuthController {


    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         CategoryDBContext CDB = new CategoryDBContext();
        ArrayList<Category> Categorys = CDB.getCategorys();
        UserCourseDBContext ucdbc = new UserCourseDBContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        ArrayList<UserCourse> myCourses= ucdbc.getCoursesRegistraion(1); // test
        request.setAttribute("myCourses", myCourses);
        request.setAttribute("Categorys", Categorys);
        request.getRequestDispatcher("view/MyRegistrations.jsp").forward(request, response);
    }


    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
