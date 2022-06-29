/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.CourseDBContext;
import dal.DimensionDBContext;
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
import model.Dimension;
import model.DimensionType;
import model.User;

/**
 *
 * @author pv
 */
public class AddDimension extends BaseAuthController {

  
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid;
        try{
           cid = Integer.parseInt(request.getParameter("cid"));
        }catch(Exception e){
           cid = 1;
        }
         // check xem Account hiện tại( Đã là expert và admin ) có phải Owner của khóa học hay không
        UserDBContext userDB = new UserDBContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        boolean isOwnerCourse = userDB.isOwnerOfCourse(cid, user);
        boolean isAdmin = userDB.isAdmin(user.getId());
        if(!isOwnerCourse && !isAdmin){
            request.getRequestDispatcher("../../view/base/404page.jsp").forward(request, response);
            return;
        }
        // get Course by cid 
        CourseDBContext courseDB = new CourseDBContext();
        Course course = courseDB.getSubjectById(cid);
        DimensionDBContext dimensionDB = new DimensionDBContext();
        ArrayList<DimensionType> dimensiontypes = dimensionDB.getAllDimensionType();
        
        request.setAttribute("cid", cid);
        request.setAttribute("course", course);
        request.setAttribute("dimensiontypes", dimensiontypes);
        request.getRequestDispatcher("../../view/admin/addDimension.jsp").forward(request, response);
    }

    
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int cid = Integer.parseInt(request.getParameter("cid"));
       String []temp_did = request.getParameterValues("dimension");
       // update dimension for this course 
       Course course = new Course();
       course.setCourseId(cid);
       if(temp_did != null){
           for (String did : temp_did) {
                Dimension d = new Dimension();
                d.setId(Integer.parseInt(did));
                course.getDimensions().add(d);
            }
        }
       DimensionDBContext dimensionDB = new DimensionDBContext();
       dimensionDB.updateDimensionByCid(course);
       response.sendRedirect("../../admin/dimension/add?cid="+cid);
    }

   

}
