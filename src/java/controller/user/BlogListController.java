/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.BlogDBContext;
import dal.CategoryDBContext;
import dal.CourseDBContext;
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

/**
 *
 * @author jicon
 */
public class BlogListController extends HttpServlet {

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
            out.println("<title>Servlet BloglistCotroller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BloglistCotroller at " + request.getContextPath() + "</h1>");
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

        CategoryDBContext cadb = new CategoryDBContext();

        ArrayList<Category> cates = cadb.getAllCategory();
        String title = request.getParameter("title");
        String[] cid_raw = request.getParameterValues("cateId");
        int[] cid = null;
        if (cid_raw != null) {
            cid = new int[cid_raw.length];
            for (int i = 0; i < cid_raw.length; i++) {
                cid[i] = Integer.parseInt(cid_raw[i]);
            }
        }

        int pageSize = 6;
        BlogDBContext bdb = new BlogDBContext();
        String page = request.getParameter("page");
        if (page == null || page.trim().length() == 0) {
            page = "1"; //default page 1 in first access
        }
        int pageIndex = Integer.parseInt(page);
        
        ArrayList<Blog> blogs = bdb.getBlogList(cid, title, pageIndex, pageSize);
        
        int count = bdb.CountBlogList(cid, title, pageIndex, pageSize);
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;

        String url = "list?";
        String url_param = request.getQueryString(); //get parametter 
        if (url_param != null && url.length() > 0) {
            if (url_param.contains("page=" + pageIndex)) {
                url_param = url_param.replaceAll("page=" + pageIndex, "");
            }
            // if not contain page=x , add & 
            if (!url_param.equals("") && !url_param.endsWith("&")) {
                url_param += "&";
            }
            url += (url_param);
        }
        boolean[] cidCheck = new boolean[cates.size()];
        for (int i = 0; i < cidCheck.length; i++) {
            cidCheck[i] = ischeck(cates.get(i).getCategoryID(), cid); //finding category having check
        }
        CourseDBContext cdb = new CourseDBContext();

        ArrayList<Course> coursesSlider = cdb.getCourseForSlider();
        request.setAttribute("cidcheck",cidCheck);
        request.setAttribute("coursesSlider", coursesSlider);
        request.setAttribute("url", url);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageindex", pageIndex);
        request.setAttribute("categories", cates);
        request.setAttribute("blogs", blogs);
        
        
        request.getRequestDispatcher("../view/bloglist.jsp").forward(request, response);

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
        processRequest(request, response);
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

    boolean ischeck(int id, int[] x) {
        //is id in cids?  
        if (x == null) {
            return false;
        }
        for (int i = 0; i < x.length; i++) {
            if (id == x[i]) {
                return true;
            }
        }
        return false;
    }
}
