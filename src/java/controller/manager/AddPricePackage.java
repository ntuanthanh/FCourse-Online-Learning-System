/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.CourseDBContext;
import dal.PricePackageDBContext;
import dal.StatusDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Course;
import model.PricePackage;
import model.Status;
import model.User;

/**
 *
 * @author pv
 */
public class AddPricePackage extends BaseAuthController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid;
        try{
           cid = Integer.parseInt(request.getParameter("cid"));
        }catch(Exception e){
           cid = 1;
        }
        // get Course by cid 
        CourseDBContext courseDB = new CourseDBContext();
        Course course = courseDB.getSubjectById(cid);
        // take list PricePackage for cid
        PricePackageDBContext packageDB = new PricePackageDBContext();
        ArrayList<PricePackage> pricePackages = packageDB.getPricePackagesByCid(cid);
        // get all status
        StatusDBContext statusDB = new StatusDBContext();
        ArrayList<Status> statuses = statusDB.getAllStatuses();
        request.setAttribute("cid", cid);
        request.setAttribute("statuses", statuses);
        request.setAttribute("pricePackages", pricePackages);
        request.setAttribute("course", course);
        request.getRequestDispatcher("../../view/admin/addPricePackage.jsp").forward(request, response);
        
    }


    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String []temp_pid = request.getParameterValues("pricepackage");
        // update pricepackage for this course 
        Course course = new Course();
        course.setCourseId(cid);
        if(temp_pid != null){
           for (String pid : temp_pid) {
                PricePackage p = new PricePackage();
                p.setId(Integer.parseInt(pid));
                course.getPricePackage().add(p);
            }
        }
        PricePackageDBContext pricePackageDB = new PricePackageDBContext(); 
        pricePackageDB.updatePricePackageByCid(course);
        response.sendRedirect("../../admin/pricepackage/add?cid="+cid);
    }

 
  

}
