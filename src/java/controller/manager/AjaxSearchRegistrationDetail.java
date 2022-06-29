/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.manager;

import dal.CourseDBContext;
import dal.PricePackageDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.PricePackage;

/**
 *
 * @author thand
 */
public class AjaxSearchRegistrationDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        CourseDBContext cdb = new CourseDBContext();
        ArrayList<Course> courses = cdb.searchCourse(0, null, null, null, null, 0, txtSearch, 1, 6);
        String xx = request.getParameter("xx");
        if (xx != null) {
            for (Course c : courses) {
                response.getWriter().print("<li onclick=\"submit2(" + c.getCourseId() + ")\" id='" + c.getCourseId() + "'>" + c.getTitle() + "</li>");
            }
        } else {
            for (Course c : courses) {
                response.getWriter().print("<li onclick=\"submit(" + c.getCourseId() + ")\" id='" + c.getCourseId() + "'>" + c.getTitle() + "</li>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String p = request.getParameter("txt");
        int pid = 1;
        if (p != null && p.trim().length() > 0) {
            pid = Integer.parseInt(p);
        }
        PricePackageDBContext pdb = new PricePackageDBContext();
        PricePackage pr = pdb.getPackage(pid);
        String sdate = request.getParameter("bb");
        Date date = Date.valueOf(sdate);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.add(Calendar.MONTH, (pr.getDuration()));
        TimeZone tz = c1.getTimeZone();
        // Getting zone id
        ZoneId zoneId = tz.toZoneId();
        // conversion
        LocalDateTime localDateTime = LocalDateTime.ofInstant(c1.toInstant(), zoneId);
        String z = localDateTime.toString();
        String[] time = z.split("T");
        Date dates = Date.valueOf(time[0]);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        String endate = dt1.format(dates);
        request.setAttribute("pr", pr);
        if (pr.getDuration() > 0) {
            response.getWriter().print(
                    "<b>Registration time:</b>&nbsp;\n"
                    + "                                    <span id=\"Registrationtime\">" + pr.getDuration() + " month</span> \n"
                    + "                                    <br>\n"
                    + "                                    <b>List price: </b>&nbsp\n"
                    + "                                    <span>" + pr.getListPrice() + " $</span>&emsp; \n"
                    + "                                    &emsp; &emsp; <b>Sale price: </b>&nbsp; \n"
                    + "                                    <span>" + pr.getSalePrice() + " $</span> \n"
                    + " <br><b>Start date:</b>&nbsp; \n"
                    + "                                    <span > <input type=\"date\" name=\"date\" id=\"startdate\" oninput =\"xyz(this)\" value=\"" + date + "\"/> </span>\n"
                    + "                                    <br>\n"
                    + "                                    <b>End date:</b>&nbsp; \n"
                    + "                                    <span id=\"endate\"> " + endate + " </span>");
        } else {
            response.getWriter().print(
                    "<b>Registration time:</b>&nbsp;\n"
                    + "                                    <span id=\"Registrationtime\"> Unlimited time </span> \n"
                    + "                                    <br>\n"
                    + "                                    <b>List price: </b>&nbsp\n"
                    + "                                    <span>" + pr.getListPrice() + " $</span>&emsp; \n"
                    + "                                    &emsp; &emsp; <b>Sale price: </b>&nbsp; \n"
                    + "                                    <span>" + pr.getSalePrice() + " $</span> \n"
                    + " <br><b>Start date:</b>&nbsp; \n"
                    + "                                    <span > <input type=\"date\" name=\"date\" id=\"startdate\" oninput =\"xyz(this)\" value=\"" + date + "\"/> </span>\n"
                    + "                                    <br>\n"
                    + "                                    <b>End date:</b>&nbsp; \n"
                    + "                                    <span id=\"endate\"> Unlimited time </span>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
