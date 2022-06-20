/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authorization.BaseAuthController;
import dal.CategoryDBContext;
import dal.CourseDBContext;
import dal.ParentCategoryDBContext;
import dal.UserCourseDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.ParentCategory;
import model.User;
import model.UserCourse;

public class MyRegistrationController extends BaseAuthController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int categoryId = 0;
        String a = request.getParameter("categoryId");
        if (a != null) {
            categoryId = Integer.parseInt(a);
        }
        User u = (User) request.getSession().getAttribute("user");
        int pagesize =4;
        String page = request.getParameter("page");
        if(page == null || page.trim().length()==0){
            page = "1";
        }
        User user = (User) request.getSession().getAttribute("user");
        int pageindex = Integer.parseInt(page);
        CourseDBContext cdbc1 = new CourseDBContext();
        int count = cdbc1.countRegis(user.getId());
        int totalpage = (count%pagesize==0)?(count/pagesize):(count / pagesize)+1;
        
        ParentCategoryDBContext padb = new ParentCategoryDBContext();
        ArrayList<ParentCategory> pCates = padb.getParentCategory();

        //get categories
        CategoryDBContext cadb = new CategoryDBContext();
        ArrayList<Category> cates = cadb.getCategorys();

        request.setAttribute("cates", cates);

        request.setAttribute("pCates", pCates);
        CategoryDBContext CDB = new CategoryDBContext();
        ArrayList<Category> Categorys = CDB.getCategorys();
        UserCourseDBContext ucdbc = new UserCourseDBContext();
        ArrayList<UserCourse> myCourses = 
            ucdbc.getCoursesRegistraion(user.getId(), categoryId, "",pageindex, pagesize);
        request.setAttribute("myCourses", myCourses);
        request.setAttribute("Categorys", Categorys);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("totalpage", totalpage);
        request.getRequestDispatcher("view/myregister.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String title = request.getParameter("title");
        int categoryId = 0;
        CategoryDBContext CDB = new CategoryDBContext();
        ArrayList<Category> Categorys = CDB.getCategorys();
        UserCourseDBContext ucdbc = new UserCourseDBContext();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<UserCourse> myCourses = ucdbc.getCoursesRegistraion(user.getId(), categoryId, title,1, 100);
        request.setAttribute("myCourses", myCourses);
        request.setAttribute("Categorys", Categorys);
        request.setAttribute("pageindex", 1);
        request.setAttribute("totalpage", 100);
        ParentCategoryDBContext padb = new ParentCategoryDBContext();
        ArrayList<ParentCategory> pCates = padb.getParentCategory();

        //get categories
        CategoryDBContext cadb = new CategoryDBContext();
        ArrayList<Category> cates = cadb.getCategorys();

        request.setAttribute("cates", cates);

        request.setAttribute("pCates", pCates);
        request.getRequestDispatcher("view/myregister.jsp").forward(request, response);
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
