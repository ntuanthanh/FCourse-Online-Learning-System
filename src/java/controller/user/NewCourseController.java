/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.CategoryDBContext;
import dal.CourseDBContext;
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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Category;
import model.Course;
import model.Status;
import model.Tag;
import model.User;

/**
 *
 * @author ADMIN
 */
public class NewCourseController extends HttpServlet {

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
        CategoryDBContext cdb = new CategoryDBContext();
        ArrayList<Category> categories = cdb.getCategories();
        request.setAttribute("categories", categories);

        StatusDBContext sdb = new StatusDBContext();
        ArrayList<Status> allStatuses = sdb.getAllStatuses();
        request.setAttribute("statuss", allStatuses);

        TagDBContext tdb = new TagDBContext();
        ArrayList<Tag> listTags = tdb.getListTags();
        request.setAttribute("tags", listTags);

        UserDBContext udb = new UserDBContext();
        ArrayList<User> userByRole = udb.getUserByRole("admin");
        request.setAttribute("experts", userByRole);

        request.getRequestDispatcher("../view/newsubject.jsp").forward(request, response);

 //     String category = request.getParameter("category");
       
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

        String title = request.getParameter("title");
        String thumail = request.getParameter("thumail");
        String brief_info = request.getParameter("brief_info");
        String feature = request.getParameter("feature");
        String status = request.getParameter("status");
        String description = request.getParameter("description");

        String category = request.getParameter("category");
        int cate = Integer.parseInt(category);
        Category c = new Category();
        c.setCategoryID(cate);
//
//        String[] experts = request.getParameterValues("expert");
//        ArrayList <User> exp = new ArrayList<>();
//        for (String expert : experts) {
//            int userid = Integer.parseInt("1");
//            User u = new User();
//            u.setId(userid);
//            exp.add(u);           
//        }
//        String[] tags = request.getParameterValues("tags");
//        ArrayList <Tag> tag = new ArrayList<>();
//        for (String t : tags) {
//            int userid = Integer.parseInt("1");
//            Tag u = new Tag();
//            u.setTagId(userid);
//            tag.add(u);           
//        }
        
//         int cate = Integer.parseInt("1");
//        Category c = new Category();
//        c.setCategoryID(cate);

//    //    String[] experts = request.getParameterValues("expert");
//        ArrayList <User> exp = new ArrayList<>();
//     //   for (String expert : experts) {
//            int userid = Integer.parseInt("1");
//            User u = new User();
//            u.setId(userid);
//            exp.add(u);           
////        }
//    //    String[] tags = request.getParameterValues("tags");
//        ArrayList <Tag> tag = new ArrayList<>();
//    //    for (String t : tags) {
//            int tid = Integer.parseInt("1");
//            Tag x = new Tag();
//            x.setTagId(tid);
//            tag.add(x);           
// //       }

        // image( avatar ) 
        Part avatar = request.getPart("thumnail_img"); //
        // get file name of file 
        String raw_fileName = Paths.get(avatar.getSubmittedFileName()).getFileName().toString();
        String fileName; 
        if(raw_fileName == null || raw_fileName.length() == 0){ // User dont send image
            fileName = "non-avatar.png";
        }else{ //User sended image and Doing
             // getRealPath to return location ( không fix cứng với máy code - tất cả tv nhóm push về đều dùng được )
            String raw_realPath = request.getServletContext().getRealPath("");// C:\Users\pv\Desktop\Project SWP391\OnlineLearning\build\web
            // Xử lý chuỗi - chỉ lấy C:\Users\pv\Desktop\Project SWP391\OnlineLearning\web ( bỏ qua forder build )
            String realPath = raw_realPath.substring(0, raw_realPath.indexOf("build")) + "web\\images\\avatar"; // C:\Users\pv\Desktop\Project SWP391\OnlineLearning\web\images\avatar
            // get type of file 
            int index = raw_fileName.lastIndexOf('.');
            String typeFile = "";
            if (index > 0) {
                typeFile = raw_fileName.substring(index + 1);
            }
            // final fileName to save 
            fileName = "thumnail" + typeFile;
            // Save file at location 
            InputStream is = avatar.getInputStream();
            // String test = "C:\\Users\\pv\\Desktop\\Project SWP391\\OnlineLearning\\web\\images\\avatar"; // fix cứng máy người code
            Files.copy(is, Paths.get(realPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING); // upload image to forder
        }
        
        
        
        Course course = new Course();
     
        course.setBriefInfo(brief_info);
        course.setThumnailURL(fileName);
        course.setTitle(title);
        course.setDescription(description);

  //      course.setStatus();
        course.setFeature(true);
        course.setCategory(c);

        
        
        CourseDBContext cdb = new CourseDBContext();
        int insertCourse = cdb.insertCourse(course);
        
       response.getWriter().print("Ok");

       
       
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
