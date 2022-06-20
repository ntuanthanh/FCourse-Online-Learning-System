/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authorization.BaseAuthController;
import dal.PricePackageDBContext;
import dal.UserCourseDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Course;
import model.PricePackage;
import model.User;
import model.UserCourse;

/**
 *
 * @author jicon
 */
public class RegisterCourseController extends BaseAuthController {

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
            out.println("<title>Servlet RegisterCourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterCourseController at " + request.getContextPath() + "</h1>");
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
         int pid = Integer.parseInt(request.getParameter("priceid"));
        int cid = Integer.parseInt(request.getParameter("courseid"));
        int uid = Integer.parseInt(request.getParameter("userid"));
        
        
        
        PricePackageDBContext pdb = new PricePackageDBContext();
        PricePackage price = pdb.getPriceByPriceId(pid);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        
        UserCourseDBContext ucdb = new UserCourseDBContext();
        
        UserCourse userc = ucdb.getUserCourseByUidCid(uid, cid);
        
        int flag = 0;
        Boolean success = false;
        if (userc == null) {
            String dateBefore = sdf.format(cal.getTime());
            cal.add(Calendar.MONTH, price.getDuration());
            String dateAfter = sdf.format(cal.getTime());
            Date startdate = Date.valueOf(dateBefore);
            Date enddate = Date.valueOf(dateAfter);
            UserCourse uc = new UserCourse();
            Course c = new Course();
            User u = new User();
            PricePackage p = new PricePackage();
            u.setId(uid);
            uc.setUser(u);
            c.setCourseId(cid);
            uc.setCourse(c);
            uc.setStartDate(startdate);
            uc.setEndDate(enddate);
            p.setId(pid);
            uc.setPricePackage(p);
            ucdb.insertUserCourse(uc);
            flag = 1;
            success = true;
        } else {
            if (userc.isRegistration_status()) //   }
            {
                
                String dateBefore = sdf.format(userc.getEndDate());
                try {
                    cal.setTime(sdf.parse(dateBefore));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                cal.add(Calendar.MONTH, price.getDuration());
                String dateAfter = sdf.format(cal.getTime());
                Date startdate = Date.valueOf(dateBefore);
                Date enddate = Date.valueOf(dateAfter);
                userc.setStartDate(startdate);
                userc.setEndDate(enddate);
                ucdb.insertUserCourse(userc);
                flag = 1;
                success = true;
            } else {
                flag = 1;
            }
        }
     request.setAttribute("flag", flag);
       request.setAttribute("success",success );           
        request.getRequestDispatcher("../myregistration").forward(request, response);
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
//        
//        int pid = Integer.parseInt(request.getParameter("priceid"));
//        int cid = Integer.parseInt(request.getParameter("courseid"));
//        int uid = Integer.parseInt(request.getParameter("userid"));
//        
//        
//        
//        PricePackageDBContext pdb = new PricePackageDBContext();
//        PricePackage price = pdb.getPriceByPriceId(pid);
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar cal = Calendar.getInstance();
//        
//        UserCourseDBContext ucdb = new UserCourseDBContext();
//        
//        UserCourse userc = ucdb.getUserCourseByUidCid(uid, cid);
//        
//        int flag = 0;
//        Boolean success = false;
//        if (userc == null) {
//            String dateBefore = sdf.format(cal.getTime());
//            cal.add(Calendar.MONTH, price.getDuration());
//            String dateAfter = sdf.format(cal.getTime());
//            Date startdate = Date.valueOf(dateBefore);
//            Date enddate = Date.valueOf(dateAfter);
//            UserCourse uc = new UserCourse();
//            Course c = new Course();
//            User u = new User();
//            PricePackage p = new PricePackage();
//            u.setId(uid);
//            uc.setUser(u);
//            c.setCourseId(cid);
//            uc.setCourse(c);
//            uc.setStartDate(startdate);
//            uc.setEndDate(enddate);
//            p.setId(pid);
//            uc.setPricePackage(p);
//            ucdb.insertUserCourse(uc);
//            flag = 1;
//            success = true;
//        } else {
//            if (userc.isRegistration_status()) //   }
//            {
//                
//                String dateBefore = sdf.format(userc.getEndDate());
//                try {
//                    cal.setTime(sdf.parse(dateBefore));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                cal.add(Calendar.MONTH, price.getDuration());
//                String dateAfter = sdf.format(cal.getTime());
//                Date startdate = Date.valueOf(dateBefore);
//                Date enddate = Date.valueOf(dateAfter);
//                userc.setStartDate(startdate);
//                userc.setEndDate(enddate);
//                ucdb.insertUserCourse(userc);
//                flag = 1;
//                success = true;
//            } else {
//                flag = 1;
//            }
//        }
//        request.setAttribute("flag", flag);
//        request.setAttribute("success",success );
//          
       
        //   }

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
