/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.CategoryDBContext;
import dal.CourseDBContext;
import dal.ParentCategoryDBContext;
import dal.PricePackageDBContext;
import dal.TagDBContext;
import dal.TopicDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Course;
import model.ParentCategory;
import model.PricePackage;
import model.Tag;
import model.Topic;

/**
 *
 * @author pv
 */

public class CourseDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = "1";
        id = request.getParameter("id");
        int a = 1;
        if (id != null && !id.isEmpty()) {
            a = Integer.parseInt(id);
        }
         CourseDBContext cdb = new CourseDBContext();
         ArrayList<Course> courses = cdb.getThreeCourseForCourse(a);
        
//        PricePackageDBContext pdb = new PricePackageDBContext();
//        TagDBContext tdb = new TagDBContext();
//        for (int i = 0; i < courses.size(); i++) {
//            ArrayList<PricePackage> prices = pdb.getPricePackageByCourseList(courses.get(i).getCourseId());
//            // get price by courseid
//              ArrayList<Tag> tag = tdb.getTagsByCourse(courses.get(i).getCourseId());
//            courses.get(i).setPricePackage(prices);
//            courses.get(i).setTags(tag);
//            System.out.println("xxxx");
//            
//        }
       
        Course Course = cdb.getCourseDetail(a);
        CategoryDBContext CDB = new CategoryDBContext();
        ArrayList<Category> Categorys = CDB.getCategorys();
        PricePackageDBContext ppdbc = new PricePackageDBContext();
        ArrayList<PricePackage> PricePackes = ppdbc.PricePackes(a);
        TopicDBContext tdbc = new TopicDBContext();
        ArrayList<Topic> Topics = tdbc.getTopics(a);
        
        //get parrent
        ParentCategoryDBContext padb = new ParentCategoryDBContext();
        ArrayList<ParentCategory> pCates = padb.getParentCategory();
        
        //get categories
        CategoryDBContext cadb = new CategoryDBContext();
        ArrayList<Category> cates = cadb.getCategorys();
        
        request.setAttribute("cates", cates);
      
      request.setAttribute("pCates", pCates);
        request.setAttribute("courses", courses);
        request.setAttribute("Topics", Topics);
        request.setAttribute("PricePackes", PricePackes);
        request.setAttribute("Categorys", Categorys);
        request.setAttribute("Course", Course);
        request.setAttribute("now", java.time.LocalDate.now());
        request.getRequestDispatcher("view/courseDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
}
