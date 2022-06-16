/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.BlogDBContext;
import dal.CategoryDBContext;
import dal.CourseDBContext;
import dal.PricePackageDBContext;
import dal.TagDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.Category;
import model.Course;
import model.PricePackage;
import model.Tag;

/**
 *
 * @author pv
 */
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        CourseDBContext cdb = new CourseDBContext();
        ArrayList<Course> courses = cdb.getThreeCourseForHome();
        
        PricePackageDBContext pdb = new PricePackageDBContext();
         TagDBContext tdb = new TagDBContext();
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<PricePackage> prices = pdb.getPricePackageByCourseList(courses.get(i).getCourseId());
            // get price by courseid
              ArrayList<Tag> tag = tdb.getTagsByCourse(courses.get(i).getCourseId());
            courses.get(i).setPricePackage(prices);
            courses.get(i).setTags(tag);
           
            
        }
        ArrayList<Course> coursesProminent = cdb.getMostProminentForHome();
        
       
        for (int i = 0; i < coursesProminent.size(); i++) {
            ArrayList<PricePackage> prices = pdb.getPricePackageByCourseList(coursesProminent.get(i).getCourseId());
            // get price by courseid
          
            ArrayList<Tag> tag = tdb.getTagsByCourse(coursesProminent.get(i).getCourseId());
            coursesProminent.get(i).setPricePackage(prices);
        }
        CategoryDBContext cadb = new CategoryDBContext();
        
        ArrayList<Category> cates = cadb.getCategories();//get categories
        
//        response.getWriter().write(""+courses.get(0).getCategory().getValue());
        
        BlogDBContext bdb = new BlogDBContext();
        ArrayList<Blog> blogs = bdb.getBlogForHome();
        ArrayList<Blog> blognews = bdb.getLatestBlogForHome();
        ArrayList<Course> coursesSlider = cdb.getCourseForSlider();
        request.setAttribute("coursesSlider", coursesSlider);
        request.setAttribute("blognews", blognews);
        request.setAttribute("blogs", blogs);
        request.setAttribute("courses", courses);
        request.setAttribute("coursesProminent", coursesProminent);
        request.setAttribute("cates", cates);
        request.getRequestDispatcher("view/home.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        doGet(request, response);
    }
}
