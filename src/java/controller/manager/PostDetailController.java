/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.BlogDBContext;
import dal.CategoryDBContext;
import dal.StatusDBContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Blog;
import model.Category;
import model.Status;
import utility.Generate;

/**
 *
 * @author tuann
 */
@MultipartConfig()
public class PostDetailController extends BaseAuthController {

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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoryDBContext cdb = new CategoryDBContext();
        ArrayList<Category> categories = cdb.getCategories();
        request.setAttribute("categories", categories);

        StatusDBContext sdb = new StatusDBContext();
        ArrayList<Status> allStatuses = sdb.getAllStatuses();
        request.setAttribute("statuss", allStatuses);
        
        String bid = request.getParameter("bid");
        BlogDBContext dbBlog = new BlogDBContext();
        Blog blog = dbBlog.getBlogForMK(bid);
        
        request.setAttribute("blog", blog);
        
        request.getRequestDispatcher("../view/admin/updatepost.jsp").forward(request, response);
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
        
        // xử lý ảnh 
        // image( blog ) 
        Part blog_img = request.getPart("img_blog"); //
         // get file name of file 
        String raw_fileName = Paths.get(blog_img.getSubmittedFileName()).getFileName().toString();
        String fileName; 
        if(raw_fileName == null || raw_fileName.length() == 0){ // User dont send image
            fileName = request.getParameter("old_img_blog");
        }else{ //User sended image and Doing
             // getRealPath to return location ( không fix cứng với máy code - tất cả tv nhóm push về đều dùng được )
            String raw_realPath = request.getServletContext().getRealPath("");// C:\Users\pv\Desktop\Project SWP391\OnlineLearning\build\web
            // Xử lý chuỗi - chỉ lấy C:\Users\pv\Desktop\Project SWP391\OnlineLearning\web ( bỏ qua forder build )
            String realPath = raw_realPath.substring(0, raw_realPath.indexOf("build")) + "web\\images\\blogdetail"; // C:\Users\pv\Desktop\Project SWP391\OnlineLearning\web\images\avatar
            // get type of file 
            int index = raw_fileName.lastIndexOf('.');
            String typeFile = "";
            if (index > 0) {
                typeFile = raw_fileName.substring(index + 1);
            }
            // generateFileName 
            Generate g = new Generate();
            String tempNameGenerate;
            while(true){
              tempNameGenerate = g.generateResetToken();
              tempNameGenerate += "." + typeFile;
              if(dbBlog.doesExistImgNameBlog(tempNameGenerate) == false){
                  break;
              }
            }
            // final fileName to save 
            fileName = tempNameGenerate;
            // Save file at location 
            InputStream is = blog_img.getInputStream();
            // String test = "C:\\Users\\pv\\Desktop\\Project SWP391\\OnlineLearning\\web\\images\\avatar"; // fix cứng máy người code
            Files.copy(is, Paths.get(realPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING); // upload image to forder
        }
        // Save data in database
        
//        b.setId(Integer.parseInt(bid));
        b.setBrief(brief);
        b.setTitle(title);
        b.setCategoryId(categoryId);
        b.setFeature(feature);
        b.setStatusId(statusId);
        b.setContent(content);
        b.setThumbnail(fileName);

         
         
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
