/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authorization.BaseAuthController;
import dal.CourseDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.User;

/**
 *
 * @author thand
 */
public class MyCourseController extends BaseAuthController {




 
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CourseDBContext cdbc1 = new CourseDBContext();
        User u = (User) request.getSession().getAttribute("user");
        int pagesize =8;
        String page = request.getParameter("page");
        if(page == null || page.trim().length()==0){
            page = "1";
        }
        int pageindex = Integer.parseInt(page);
        int count = cdbc1.count(1);
        int totalpage = (count%pagesize==0)?(count/pagesize):(count / pagesize)+1;
        CourseDBContext cdbc2 = new CourseDBContext();
        ArrayList<Course> Courses = cdbc2.getMyCourse(1,pageindex,pagesize);
        ArrayList<Integer> courserates = new ArrayList();
        for (int i=0 ; i< Courses.size(); i++) {
            CourseDBContext cdbc3 = new CourseDBContext();
            int courserate = cdbc3.getCourseRate(Courses.get(i).getCourseId(), 1);
            courserates.add(courserate);
        }
        request.setAttribute("courserates", courserates);
        request.setAttribute("Courses", Courses);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("totalpage", totalpage);
        request.getRequestDispatcher("view/mycourse.jsp").forward(request, response);
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