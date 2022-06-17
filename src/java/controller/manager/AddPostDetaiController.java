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
import dal.TagDBContext;
import dal.UserDBContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
//import java.time.LocalDate;
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
import model.Tag;
import model.User;
import utility.Generate;
//import utility.Generate;

/**
 *
 * @author tuann
 */
@MultipartConfig()
public class AddPostDetaiController extends BaseAuthController {

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
            out.println("<title>Servlet addpostdetail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addpostdetail at " + request.getContextPath() + "</h1>");
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

        

        UserDBContext udb = new UserDBContext();
        ArrayList<User> userByRole = udb.getUserByRole("admin");
        request.setAttribute("experts", userByRole);
        request.getRequestDispatcher("../view/admin/addpostdetail.jsp").forward(request, response);
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
        //select date
        long millis=System.currentTimeMillis();   
        java.sql.Date date=new java.sql.Date(millis);
        BlogDBContext dbBlog = new BlogDBContext();        
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
        
        String title = request.getParameter("title");
        String brief = request.getParameter("brief_info");
        int statusId = Integer.parseInt(request.getParameter("status"));
        String raw_feature = request.getParameter("feature");
        Boolean feature = false;
        if(raw_feature!=null){
            feature = true;
        }
        
        String content = request.getParameter("description");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Date createdate = date;   

        User u = (User)request.getSession().getAttribute("user");
        String raw_img = "chuathem";
        int raw_userId = u.getId();

        Blog b = new Blog();
        b.setBrief(brief);
        b.setCategoryId(categoryId);
        b.setThumbnail(fileName);
        b.setTitle(title);
        b.setStatusId(statusId);
        b.setContent(content);
        b.setFeature(feature);
        b.setCreatedate(createdate);
        User a = new User();
        a.setId(raw_userId);
        b.setUser(a);
        
//        response.getWriter().println(raw_userId);

//        response.getWriter().println(b.getBrief());
//        response.getWriter().println(b.getCategoryId());
//        response.getWriter().println(b.getThumbnail());
//        response.getWriter().println(b.getTitle());
//        response.getWriter().println(b.getStatusId());
//        response.getWriter().println(b.getContent());
//        response.getWriter().println(b.isFeature());
//        response.getWriter().println(b.getCreatedate());
//        response.getWriter().println(b.getUser().getId());
        
        
        
        dbBlog.addBlog(b);
        response.sendRedirect("post");
        
        
        
        

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
