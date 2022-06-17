/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.CategoryDBContext;
import dal.CourseDBContext;
import dal.ParentCategoryDBContext;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Category;
import model.Course;
import model.ParentCategory;
import model.Status;
import model.Tag;
import model.User;
import utility.Generate;

/**
 *
 * @author ADMIN
 */

@MultipartConfig()
public class NewCourseController extends BaseAuthController {

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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDBContext cdb = new CategoryDBContext();
        ArrayList<Category> categories = cdb.getCategories();
        request.setAttribute("categories", categories);

        StatusDBContext sdb = new StatusDBContext();
        ArrayList<Status> allStatuses = sdb.getAllStatuses();
        request.setAttribute("status", allStatuses);

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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         String thumail = request.getParameter("thumnail_img");
        String title = request.getParameter("title");
          String status = request.getParameter("status");
       
        String brief_info = request.getParameter("brief_info");
        String feature = request.getParameter("feature");
      
        String description = request.getParameter("description");
        
        String category = request.getParameter("cate");

//        String category = request.getParameter("category");
//        int cate = Integer.parseInt(category);
//        Category c = new Category();
//        c.setCategoryID(cate);
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
//
//        String []cid_raw = request.getParameterValues("cateId");
//            
//        int[] cid = null;
//        if(cid_raw!=null){
//            cid = new int[cid_raw.length];
//            for (int i = 0; i < cid_raw.length; i++) {
//                   cid[i] = Integer.parseInt(cid_raw[i]);
//            }
//        }
//        
          //get parent cate
//        ParentCategoryDBContext padb = new ParentCategoryDBContext();
//        ArrayList<ParentCategory> pCates = padb.getParentCategory();
//        
//        //get categories
//        CategoryDBContext cadb = new CategoryDBContext();
//        ArrayList<Category> cates = cadb.getCategorys();
//        
//        int []cidCheck = new int[cates.size()];
//        for (int i = 0; i < cidCheck.length; i++) {
//            cidCheck[i] = findcid(cates.get(i).getCategoryID(), cid); //finding category having check
//        }
        
        

// xử lý ảnh 
        // image( course ) 
        Part course_img = request.getPart("img_course"); //
         // get file name of file 
        String raw_fileName = Paths.get(course_img.getSubmittedFileName()).getFileName().toString();
        String fileName; 
        if(raw_fileName == null || raw_fileName.length() == 0){ // User dont send image
            fileName = request.getParameter("old_img_course");
        }else{ //User sended image and Doing
             // getRealPath to return location ( không fix cứng với máy code - tất cả tv nhóm push về đều dùng được )
            String raw_realPath = request.getServletContext().getRealPath("");// C:\Users\pv\Desktop\Project SWP391\OnlineLearning\build\web
            // Xử lý chuỗi - chỉ lấy C:\Users\pv\Desktop\Project SWP391\OnlineLearning\web ( bỏ qua forder build )
            String realPath = raw_realPath.substring(0, raw_realPath.indexOf("build")) + "web\\images\\courses"; // C:\Users\pv\Desktop\Project SWP391\OnlineLearning\web\images\avatar
            // get type of file 
            int index = raw_fileName.lastIndexOf('.');
            String typeFile = "";
            if (index > 0) {
                typeFile = raw_fileName.substring(index + 1);
            }
            // generateFileName 
            Generate g = new Generate();
            String tempNameGenerate;
           // while(true){
              tempNameGenerate = g.generateResetToken();
              tempNameGenerate += "." + typeFile;
//              if(courseDB.doesExistImgNameCourse(tempNameGenerate) == false){
//                  break;
//              }
//            }

            // final fileName to save 
            fileName = tempNameGenerate;
            // Save file at location 
            InputStream is = course_img.getInputStream();
            // String test = "C:\\Users\\pv\\Desktop\\Project SWP391\\OnlineLearning\\web\\images\\avatar"; // fix cứng máy người code
            Files.copy(is, Paths.get(realPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING); // upload image to forder
        }
        // Save data in database


        
        
        Course course = new Course();
     
        course.setBriefInfo(brief_info);
        course.setThumnailURL(fileName);
        course.setTitle(title);
        course.setDescription(description);

        Status s = new Status();
        s.setId(Integer.parseInt(status));
        course.setStatus(s);
        boolean featured = false;
        if(feature != null)
        {
            featured = feature.equals("checked");
        }
        course.setFeature(featured);
        
        Category x = new Category();
        x.setCategoryID(Integer.parseInt(category));
        course.setCategory(x);
        
        CourseDBContext cdb = new CourseDBContext();
        int insertCourse = cdb.insertCourse(course);
        
        response.sendRedirect("../admin/subject/details?id="+ insertCourse);
       
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
