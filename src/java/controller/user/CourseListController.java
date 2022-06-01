/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.CategoryDBContext;
import dal.CourseDBContext;
import dal.PricePackageDBContext;
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
import model.PricePackage;

/**
 *
 * @author pv
 */
public class CourseListController extends HttpServlet {

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
            out.println("<title>Servlet CourseListController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseListController at " + request.getContextPath() + "</h1>");
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
       String sort_raw = request.getParameter("sort");
        if(sort_raw == null || sort_raw.trim().length()==0 ){
            sort_raw = "0";
        }
        int sort = Integer.parseInt(sort_raw);
        
        String title = request.getParameter("title");
        
        String []cid_raw = request.getParameterValues("cateId");
        int[] cid = null;
        if(cid_raw!=null){
            cid = new int[cid_raw.length];
            for (int i = 0; i < cid_raw.length; i++) {
                   cid[i] = Integer.parseInt(cid_raw[i]);
            }
        }
        String begin_raw = request.getParameter("from") ;
        
        String end_raw = request.getParameter("to") ;
       
        if(begin_raw==null || begin_raw.trim().length()==0){
            begin_raw = "2015-01-01";
        }
         Date begin = Date.valueOf(begin_raw) ;
         if(end_raw==null || end_raw.trim().length()==0){
             SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
             Date date = new Date(System.currentTimeMillis());
             
            end_raw = formatter.format(date);
        }
        Date end = Date.valueOf(end_raw) ;
       
        
        
        String f_raw = request.getParameter("feature");
        
        if(f_raw==null || f_raw.length()==0 ){
           f_raw="0";
        }
        
        int feature = Integer.parseInt(f_raw);
        
        
        
        int pageSize = 6;
        CourseDBContext cdb = new CourseDBContext();
        String page = request.getParameter("page");
        if(page==null || page.trim().length() == 0){
            page = "1"; //default page 1 in first access
        }
        int pageIndex = Integer.parseInt(page);
        
        ArrayList<Course> courses = cdb.searchCourse(sort,cid,begin,end,feature,title,pageIndex,pageSize);
        int count = cdb.coutCouse(cid, begin, end, feature, title);
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        PricePackageDBContext pdb  = new PricePackageDBContext();
        
        for (int i = 0; i < courses.size(); i++) {
            ArrayList<PricePackage> prices = pdb.getPricePackageByCourseList(courses.get(i).getCourseId());
            // get price by courseid
          
            courses.get(i).setPricePackage(prices);
        }
        CategoryDBContext cadb = new CategoryDBContext();
        
        ArrayList<Category> cates = cadb.getAllCategory();//get categories
        
        boolean []cidCheck = new boolean[cates.size()];
        
        
        for (int i = 0; i < cidCheck.length; i++) {
            cidCheck[i] = ischeck(cates.get(i).getCategoryID(), cid); //finding category having check
        }
        
        
//        for (int i = 0; i < courses.get(0).getPricePackage().size() ; i++) {
//            response.getWriter().write("<br> a: "+courses.get(0).getPricePackage().get(i).getName()+"</br>");
//        }
       String url = "list?";
       String url_param=request.getQueryString(); //get parametter 
       if(url_param!=null && url.length()>0){
           if(url_param.contains("page=" + pageIndex)){
               url_param = url_param.replaceAll("page=" +pageIndex, "");      
            }
            // if not contain page=x , add & 
            if(!url_param.equals("") && !url_param.endsWith("&")){
                url_param += "&"; 
            }
            url += (url_param);
       }
        ArrayList<Course> coursesSlider = cdb.getCourseForSlider();
        request.setAttribute("coursesSlider", coursesSlider);
      request.setAttribute("sort",sort);
      request.setAttribute("cidcheck",cidCheck);
      request.setAttribute("begin",begin);
      request.setAttribute("end",end);
      request.setAttribute("feature",feature);
      request.setAttribute("title",title);
      
      request.setAttribute("url", url);
      request.setAttribute("totalpage", totalPage);
      request.setAttribute("pageindex", pageIndex);
      request.setAttribute("categories", cates);
      request.setAttribute("courses", courses);
      request.getRequestDispatcher("../view/courseList.jsp").forward(request, response);
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
    boolean ischeck(int id, int []cids){
        //is id in cids?  
        if (cids == null) return false;
        for (int i = 0; i < cids.length; i++) {
            if (id==cids[i]){
                return true;
            }
        }
        return false;
    }
}
