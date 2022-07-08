/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.CategoryDBContext;
import dal.CourseDBContext;
import dal.LessonDBContext;
import dal.ParentCategoryDBContext;
import dal.PricePackageDBContext;
import dal.StatusDBContext;
import dal.TagDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Course;
import model.ParentCategory;
import model.PricePackage;
import model.Status;
import model.Tag;
import model.User;

/**
 *
 * @author jicon
 */
public class SubjectListController extends BaseAuthController {

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
            out.println("<title>Servlet SubjectListControll</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubjectListControll at " + request.getContextPath() + "</h1>");
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

        User user = (User) request.getSession().getAttribute("user");
        UserDBContext udb = new UserDBContext();
        int isUser = 0;
        if (udb.isExpert(user.getId())) {
            isUser = user.getId();
        }
        String sort_raw = request.getParameter("sort");
        if (sort_raw == null || sort_raw.trim().length() == 0) {
            sort_raw = "0";
        }
        int sort = Integer.parseInt(sort_raw);

        String title = request.getParameter("title");

        String[] cid_raw = request.getParameterValues("cateId");
        // category id
        int[] cid = null;
        if (cid_raw != null) {
            cid = new int[cid_raw.length];
            for (int i = 0; i < cid_raw.length; i++) {
                cid[i] = Integer.parseInt(cid_raw[i]);
            }
        }
        // tag id

        // date
        String begin_raw = request.getParameter("from");
        String end_raw = request.getParameter("to");

        if (begin_raw == null || begin_raw.trim().length() == 0) {
            begin_raw = "2015-01-01";
        }
        Date begin = Date.valueOf(begin_raw);
        if (end_raw == null || end_raw.trim().length() == 0) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());

            end_raw = formatter.format(date);
        }
        Date end = Date.valueOf(end_raw);

        //featrue
       

        //status
        String s_raw = request.getParameter("status");

        if (s_raw == null || s_raw.length() == 0) {
            s_raw = "0";
        }
        int status = Integer.parseInt(s_raw);
        //pagging
        int pageSize = 6;
        CourseDBContext cdb = new CourseDBContext();
        String page = request.getParameter("page");
        if (page == null || page.trim().length() == 0) {
            page = "1"; //default page 1 in first access
        }
        int pageIndex = Integer.parseInt(page);

        ArrayList<Course> courses = cdb.searchSubject(sort, cid, begin, end, title, status,isUser, pageIndex, pageSize);
        int count = cdb.countSubject(sort, cid, begin, end, title, status, isUser);
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        PricePackageDBContext pdb = new PricePackageDBContext();

        LessonDBContext ldb = new LessonDBContext();

        int[] numberOfLesson = new int[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
//            ArrayList<PricePackage> prices = pdb.getPricePackageByCourseList(courses.get(i).getCourseId());
//            // get price by courseid
//            ArrayList<Tag> tag = tdb.getTagsByCourse(courses.get(i).getCourseId());
//            courses.get(i).setPricePackage(prices);
//            courses.get(i).setTags(tag);
            numberOfLesson[i] = ldb.courntLessonByCourse(courses.get(i).getCourseId());
        }
        //get parent cate
        ParentCategoryDBContext padb = new ParentCategoryDBContext();
        ArrayList<ParentCategory> pCates = padb.getParentCategory();

        //get categories
        CategoryDBContext cadb = new CategoryDBContext();
        ArrayList<Category> cates = cadb.getCategorys();
        //get status

        int[] cidCheck = new int[cates.size()];
        for (int i = 0; i < cidCheck.length; i++) {
            cidCheck[i] = findcid(cates.get(i).getCategoryID(), cid); //finding category having check
        }
        for (Course c : courses) {
            ArrayList<User> us = udb.getOwnerByCourse(c.getCourseId());
            c.setOwners(us);
        }
        
        StatusDBContext sdb = new StatusDBContext();
        ArrayList<Status> statues = sdb.getAllStatuses();
        
        
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

        
        request.setAttribute("sort",sort);
        request.setAttribute("cidcheck", cidCheck);
        request.setAttribute("pCates", pCates);
        request.setAttribute("begin", begin);
        request.setAttribute("end", end);
        request.setAttribute("statues", statues);
        request.setAttribute("status", status);
        
        request.setAttribute("title", title);
        request.setAttribute("num", numberOfLesson);
        request.setAttribute("cates", cates);

        request.setAttribute("url", url);
        request.setAttribute("totalpage", totalPage);
        request.setAttribute("pageindex", pageIndex);

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("../view/admin/subjectList.jsp").forward(request, response);
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

    int findcid(int id, int[] x) {
        //is id in cids?  
        if (x == null) {
            return -1;
        }
        for (int i = 0; i < x.length; i++) {
            if (id == x[i]) {
                return x[i];
            }
        }
        return -1;
    }
}
