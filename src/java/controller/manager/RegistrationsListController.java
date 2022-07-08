/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.UserCourseDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserCourse;

/**
 *
 * @author pv
 */
public class RegistrationsListController extends BaseAuthController {


   
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       request.setCharacterEncoding("UTF-8");
       // phân trang
       int pageSize = 5; 
       String page = request.getParameter("page");
       if(page == null || page.trim().length() == 0){
            page = "1"; 
       }
       int pageIndex = Integer.parseInt(page);
       if(pageIndex < 1) pageIndex = 1;
       // Searching :
       String raw_sort = request.getParameter("sort"); 
       String raw_status = request.getParameter("status"); 
       String raw_registrationtimefrom = request.getParameter("registrationtimefrom");
       String raw_registrationtimeto = request.getParameter("registrationtimeto"); 
       String raw_title = request.getParameter("title");
       String raw_email = request.getParameter("email"); 
        if(raw_title == null || raw_title.length() == 0){
            raw_title = null;
        }
        if(raw_email == null || raw_email.length() == 0){
            raw_email = null;
        } 
        if(raw_sort == null || raw_sort.length() == 0){
           raw_sort = "0"; 
        }
        if(raw_status == null || raw_status.length() == 0){
            raw_status = "-1";
        }

        int sort = Integer.parseInt(raw_sort); 
        String title = raw_title; 
        String email = raw_email;
        //Boolean status = (!raw_status.equals("all"))?raw_status.equals("1"):null;
        int status = Integer.parseInt(raw_status);
        Date registrationtimefrom = (raw_registrationtimefrom != null && raw_registrationtimefrom.length()>0)?Date.valueOf(raw_registrationtimefrom):null;
        Date registrationtimeto = (raw_registrationtimeto != null && raw_registrationtimeto.length()>0)?Date.valueOf(raw_registrationtimeto):null;
        
        // Xử lí sort khi bấm lần tiếp theo : 
        // Th1 : mới vào liền
        int sortId = 0; // 1
        int sortEmail = 2; // 3 
        int sortRegisTime = 4; // 5
        int sortSubject = 6; // 7
        int sortPackage = 8; // 9
        int sortTotalCost = 10; // 11
        int sortStatus = 12; // 13
        // Đổi trạng thái để sort lần sau nhấn 
        switch(sort){
            case 0:
                sortId = 1;
                break;
            case 1:
                sortId = 0;
                break;
                // email : 
            case 2:
                sortEmail = 3;
                break;
            case 3:
                sortEmail = 2;
                break;
                // registration time : 
            case 4:
                sortRegisTime = 5;
                break;
            case 5:
                sortRegisTime = 4;
                break;
                // subject ( sort theo title ) 
            case 6:
                sortSubject = 7;
                break; 
            case 7: 
                sortSubject = 6;
                break;
                //  ( sort theo package ) 
            case 8:
                sortPackage = 9;
                break;
            case 9:
                sortPackage = 8; 
                break;
                // total cost
            case 10:
                sortTotalCost = 11;
                break;
            case 11:
                sortTotalCost = 10;
                break;
                // status 
            case 12:
                sortStatus = 13;
                break;
            case 13:
                sortStatus = 12;
                break; 
            default:
                break;
        }
        // Set ngược lại cho function js để lần sau bấm sort 
        request.setAttribute("sortId", sortId);
        request.setAttribute("sortEmail", sortEmail);
        request.setAttribute("sortRegisTime", sortRegisTime);
        request.setAttribute("sortSubject", sortSubject);
        request.setAttribute("sortPackage", sortPackage);
        request.setAttribute("sortTotalCost", sortTotalCost);
        request.setAttribute("sortStatus", sortStatus);
        // lấy ra 
        UserCourseDBContext userCourseDB = new UserCourseDBContext();
        ArrayList<UserCourse> usercourses = userCourseDB.advancedSearchRegistration(sort, title, registrationtimefrom, registrationtimeto, status, email, pageIndex, pageSize);
        int count = userCourseDB.CountAdvancedSearchRegistration(sort, title, registrationtimefrom, registrationtimeto, status, email);
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        request.setAttribute("usercourses",usercourses);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        // sau khi đã search thì vẫn select những dữ liệu mà mình đã chọn search 
        request.setAttribute("sort", sort);
        request.setAttribute("title", title);
        request.setAttribute("email", email);
        request.setAttribute("status", status);
        request.setAttribute("registrationtimefrom", registrationtimefrom);
        request.setAttribute("registrationtimeto", registrationtimeto);
        // lấy Url để phân trang bằng js 
        String url = "list?";
        String url_param = request.getQueryString();
        response.getWriter().print(url_param);
        if(url_param != null && url_param.length() > 0){
            if(url_param.endsWith("page=" + pageIndex)){
               url_param = url_param.replaceAll("page=" +pageIndex, "");      
            }
            // nếu nó không rời vào trường hợp book?page=x và thiếu & thì thêm vào
            if(!url_param.equals("") && !url_param.endsWith("&")){
                url_param += "&"; 
            }
            url += (url_param); 
        }
        request.setAttribute("url", url);
        request.getRequestDispatcher("../../view/admin/adminRegistrationList.jsp").forward(request, response);
    }

   
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
   
}
