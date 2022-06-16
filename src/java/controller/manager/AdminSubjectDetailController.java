/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.CategoryDBContext;
import dal.CourseDBContext;
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
import model.Category;
import model.Course;
import model.Status;
import model.Tag;
import model.User;
import utility.Generate;

/**
 *
 * @author pv
 */
@MultipartConfig()
public class AdminSubjectDetailController extends BaseAuthController {


    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // take id by subject
        String raw_cid = request.getParameter("id");
        // validate - if raw_cid dont exist show 404 page
        int cid; 
        try{
            cid = Integer.parseInt(raw_cid);
        }catch(Exception e){
            request.getRequestDispatcher("../../view/base/404page.jsp").forward(request, response);
            return;
        }
        // get data to show page
        // All  category
        CategoryDBContext categoryDB = new CategoryDBContext();
        ArrayList<Category> categories = categoryDB.getCategories();
        // get course by id
        CourseDBContext courseDB = new CourseDBContext();
        Course course = courseDB.getSubjectById(cid);
        // get all status 
        StatusDBContext statusDB = new StatusDBContext();
        ArrayList<Status> statuses = statusDB.getAllStatuses();
        // set data in req scope 
        request.setAttribute("categories", categories);
        request.setAttribute("course", course);
        request.setAttribute("statuses", statuses);
        request.getRequestDispatcher("../../view/admin/subjectDetails.jsp").forward(request, response);
    }

   
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");         
        CourseDBContext courseDB = new CourseDBContext();
        // get data form to update course
        int CourseId = Integer.parseInt(request.getParameter("courseId"));
        String title = request.getParameter("course_title");
        String briefinfo = request.getParameter("briefInfo");
        String description = request.getParameter("description");
        int Categoryid = Integer.parseInt(request.getParameter("categoryID"));
        int status_id = Integer.parseInt(request.getParameter("status_id"));
        boolean isFeatured = true;
        String featured_subject = request.getParameter("featured_subject");
        if(featured_subject == null || featured_subject.length() == 0){
            isFeatured = false;
        }
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
            while(true){
              tempNameGenerate = g.generateResetToken();
              tempNameGenerate += "." + typeFile;
              if(courseDB.doesExistImgNameCourse(tempNameGenerate) == false){
                  break;
              }
            }
            // final fileName to save 
            fileName = tempNameGenerate;
            // Save file at location 
            InputStream is = course_img.getInputStream();
            // String test = "C:\\Users\\pv\\Desktop\\Project SWP391\\OnlineLearning\\web\\images\\avatar"; // fix cứng máy người code
            Files.copy(is, Paths.get(realPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING); // upload image to forder
        }
        // Save data in database 
        Course course = new Course();
        course.setCourseId(CourseId);
        course.setBriefInfo(briefinfo);
        course.setThumnailURL(fileName);
        course.setTitle(title);
        course.setFeature(isFeatured);
        Category c = new Category();
        c.setCategoryID(Categoryid);
        course.setCategory(c);
        Status s = new Status();
        s.setId(status_id);
        course.setStatus(s);
        course.setDescription(description);
        // get Data owners and tags 
        String [] raw_ownerIds = request.getParameterValues("expert");
        if(raw_ownerIds != null){
            for (String owerId : raw_ownerIds) {
                User user = new User();
                user.setId(Integer.parseInt(owerId));
                course.getOwners().add(user);
            }
        }
        // get Data tags for this course
        String [] raw_tags = request.getParameterValues("tag");
        if(raw_tags != null){
            for (String tagId : raw_tags) {
                Tag tag = new Tag();
                tag.setTagId(Integer.parseInt(tagId));
                course.getTags().add(tag);
            }
        }
        // update
        courseDB.UpdateCourse(course);
        response.sendRedirect("details?id="+course.getCourseId());
    }

}
