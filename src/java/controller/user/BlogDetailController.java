/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.BlogDBContext;
import dal.CategoryDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.Category;

/**
 *
 * @author pv
 */
public class BlogDetailController extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        BlogDBContext dbBlog = new BlogDBContext();
        CategoryDBContext dbCategory = new CategoryDBContext();
        
        ArrayList<Blog> blogs = dbBlog.getBlogs();
        request.setAttribute("blogs", blogs);
        
        String bid = request.getParameter("bid");
        Blog blog = dbBlog.getBlog(bid);
        request.setAttribute("blog", blog);

        ArrayList<Category> categories = dbCategory.getCategories();
        request.setAttribute("categories", categories);
        
        request.getRequestDispatcher("../view/blogdetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
