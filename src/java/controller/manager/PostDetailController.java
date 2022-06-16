/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.BlogDBContext;
import dal.CategoryDBContext;
import dal.StatusDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;
import model.Category;
import model.Status;

/**
 *
 * @author tuann
 */
public class PostDetailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostDetailController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostDetailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoryDBContext dbCategory = new CategoryDBContext();
        ArrayList<Category> categories = dbCategory.getCategories();
        request.setAttribute("categories", categories);
        
        StatusDBContext dbStatus = new StatusDBContext();
        ArrayList<Status> statuses = dbStatus.getAllStatuses();
        request.setAttribute("statuses", statuses);
        
        String bid = request.getParameter("bid");
        BlogDBContext dbBlog = new BlogDBContext();
        Blog blog = dbBlog.getBlogForMK(bid);
        
        request.setAttribute("blog", blog);
        
        request.getRequestDispatcher("../view/admin/UpdatePostDetail.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_title = request.getParameter("blog_title");
        String raw_categoryId = request.getParameter("categoryID");
        String raw_brief = request.getParameter("blog_brief");
        String raw_feature = request.getParameter("featured_blog");
        String raw_StatusId = request.getParameter("status_id");
        String raw_content = request.getParameter("content_blog");
        
        String title = raw_title;
        int categoryId = Integer.parseInt(raw_categoryId);
        String brief = raw_brief;
        Boolean feature=false;
        if(raw_feature!=null){
            feature = true;
        }
        int statusId = Integer.parseInt(raw_StatusId);
        String content = raw_content;
        
        String bid = request.getParameter("bid");
        BlogDBContext dbBlog = new BlogDBContext();
        Blog b = dbBlog.getBlogForMK(bid);
        
//        b.setId(Integer.parseInt(bid));
        b.setBrief(brief);
        b.setTitle(title);
        b.setCategoryId(categoryId);
        b.setFeature(feature);
        b.setStatusId(statusId);
        b.setContent(content);

         
         
        dbBlog.editBlog(b);
        response.sendRedirect("detail?bid="+bid);
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
