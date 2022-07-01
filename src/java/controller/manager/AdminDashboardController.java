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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.ParentCategory;

/**
 *
 * @author pv
 */
public class AdminDashboardController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        CourseDBContext cdb
                = new CourseDBContext();
        int totalCourse = cdb.totalCourse();
        int totalCustomer = cdb.totalCustomer();
        int totalRevenues = cdb.totalRevenues();
        int newCourse = cdb.newCourse();
        int newCustomer = cdb.newCustomer();
        int newRevenues = cdb.newRevenues();
//        double rateCourse = (Math.round(newCourse/totalCourse * 100.0) / 100.0)  * 100; 

        int rateCourse = newCourse * 100 / totalCourse;
        int rateCus = newCustomer * 100 / totalCustomer;
        int rateReve = newRevenues * 100 / totalRevenues;

        request.setAttribute("totalCourse", totalCourse);
        request.setAttribute("totalCustomer", totalCustomer);
        request.setAttribute("totalRevenues", totalRevenues);
        request.setAttribute("newCourse", newCourse);
        request.setAttribute("newCustomer", newCustomer);
        request.setAttribute("newRevenues", newRevenues);
        request.setAttribute("rateCourse", rateCourse);
        request.setAttribute("rateCus", rateCus);
        request.setAttribute("rateReve", rateReve);

        String x = request.getParameter("from");
        String y = request.getParameter("to");

        String nfrom,from;
        String nto,to;
        if (x == null && y == null) {
            to = Date.valueOf(java.time.LocalDate.now()).toString();
            from = Date.valueOf(LocalDate.now().minusDays(7)).toString();
           
        } else {
            from = x.substring(6, 10) + "-" + x.substring(0, 2) + "-" + x.substring(3, 5);
            to = y.substring(6, 10) + "-" + y.substring(0, 2) + "-" + y.substring(3, 5);
//            
//            nfrom = x.substring(8, 10) + "/" + x.substring(4, 6) + "/"  + x.substring(0, 4);
//            nto = y.substring(8, 10) + "/" + y.substring(4, 6) + "/"  + y.substring(0, 4);
//       
//        LocalDate localDate1 = LocalDate.parse(to,
//                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        to = Date.valueOf(localDate1).toString();
//        LocalDate localDate2 = LocalDate.parse(from,
//                DateTimeFormatter.ofPattern("yyyy-MM-dd"));  
//        from = Date.valueOf(localDate2).toString();
        }
         nfrom = from.substring(8, 10) + "/" + from.substring(5, 7) + "/"  + from.substring(0, 4);
         nto = to.substring(8, 10) + "/" + to.substring(5, 7) + "/"  + to.substring(0, 4);

        ArrayList<String> time = new ArrayList<>();
        ArrayList<Integer> orde = new ArrayList<>();
        ArrayList<Integer> orderSucc = new ArrayList<>();
        String toDe = to;
        ArrayList<Integer> days = new ArrayList<>();

        String nformat;
        while (toDe.compareTo(from) != 0) {
            nformat = toDe.substring(8, 10) + "/" + toDe.substring(5, 7) + "/"  + toDe.substring(0, 4);
            time.add(nformat);
            int xc = cdb.order(toDe);
            int orderSuc = cdb.orderSuc(toDe);

            orde.add(xc);
            orderSucc.add(orderSuc);
            LocalDate toDate = LocalDate.parse(toDe);
            toDe = (toDate.minusDays(1)).toString();
            String day = toDe.substring(8, 10);
            days.add(Integer.parseInt(day));
        }

        ParentCategoryDBContext catedb = new ParentCategoryDBContext();
        ArrayList<Integer> regis = new ArrayList<>();
        ArrayList<Integer> bought = new ArrayList<>();
        ArrayList<ParentCategory> category = catedb.getParentCategory();
        for (int i = 0; i < category.size(); i++) {
            ParentCategory get = category.get(i);
            regis.add(cdb.customCategory(get.getId(), from, to));
            bought.add(cdb.customSuc(get.getId(), from, to));
        }

        ArrayList<Integer> status = new ArrayList<>();
        status.add(cdb.registrationStatus("success", from, to));
        status.add(cdb.registrationStatus("submitted", from, to));
        status.add(cdb.registrationStatus("cancelled", from, to));

     
        
        

        request.setAttribute("from", nfrom);
        request.setAttribute("to", nto);
        request.setAttribute("category", category);
        request.setAttribute("regis", regis);
        request.setAttribute("bought", bought);
        request.setAttribute("status", status);
        request.setAttribute("time", time);
        request.setAttribute("orde", orde);
        request.setAttribute("days", days);
        request.setAttribute("orderss", orderSucc);

        request.getRequestDispatcher("../view/admin/demoDashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String from = request.getParameter("from");
//        String to = request.getParameter("to");
//        from = "2022/04/19";
//        to = "2022/06/19";
//        response.getWriter().print(from);
//        response.getWriter().print(to);
//        CourseDBContext cdb = new CourseDBContext();
////        int registrationStatus = cdb.registrationStatus("success", from, to);
////        response.getWriter().print(registrationStatus);
//
//        ParentCategoryDBContext catedb = new ParentCategoryDBContext();
//        ArrayList<Integer> regis = new ArrayList<>();
//        ArrayList<Integer> bought = new ArrayList<>();
//        ArrayList<ParentCategory> category = catedb.getParentCategory();
//        for (int i = 0; i < category.size(); i++) {
//            ParentCategory get = category.get(i);
//            regis.add(cdb.customCategory(get.getId(), from, to));
//            bought.add(cdb.customSuc(get.getId(), from, to));
//        }
//
//        ArrayList<Integer> status = new ArrayList<>();
//        status.add(cdb.registrationStatus("success", from, to));
//        status.add(cdb.registrationStatus("submitted", from, to));
//        status.add(cdb.registrationStatus("cancelled", from, to));
//
//        response.getWriter().print(regis);
//        response.getWriter().print(bought);
//        response.getWriter().print(status);
//        //   response.getWriter().print(regis);
    }

}