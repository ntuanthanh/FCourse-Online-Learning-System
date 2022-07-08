/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.manager;

import dal.PricePackageDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PricePackage;

/**
 *
 * @author thand
 */
public class AjaxStartDate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Startdate = request.getParameter("txt");
        String p = request.getParameter("aa");
        int pid = 1;
        if (p != null && p.trim().length() > 0) {
            pid = Integer.parseInt(p);
        }
        PricePackageDBContext pdb = new PricePackageDBContext();
        PricePackage pr = pdb.getPackage(pid);
        Date date = Date.valueOf(Startdate);
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
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        String endate = dt1.format(dates);
        if (pr.getDuration() > 0) {
            response.getWriter().print("<b>End date:</b>&nbsp; \n"
                    + "                                        <span > "+endate+"\n"
                    + "                                            <input name=\"edate\" value=\""+endate+"\" hidden=\"\">\n"
                    + "                                        </span>");
        } else {
            response.getWriter().print("Unlimited time");
        }

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
