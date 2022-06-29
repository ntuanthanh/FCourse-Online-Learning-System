/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.CourseDBContext;
import dal.PricePackageDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.PricePackage;

/**
 *
 * @author pv
 */
public class AjaxUpdateActionPricePackageController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid")); 
        int sid = Integer.parseInt(request.getParameter("sid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        int pageSize = 2; 
        PricePackageDBContext pricePackageDB = new PricePackageDBContext();
        if(sid == 1){
           sid = 2;
        }else{
          sid = 1;
        }    
        CourseDBContext courseDB = new CourseDBContext();
        pricePackageDB.updateStatusPricePackage(pid, sid);
        ArrayList<PricePackage> pricePackages = pricePackageDB.getPricePackgeByCoursePaging(cid, pageIndex , pageSize);
        for (PricePackage pricePackage : pricePackages) {
            response.getWriter().println("<tr>\n" +
                    " <th scope=\"row\">"+pricePackage.getId()+"</th>\n" +
                    " <td>"+pricePackage.getName()+"</td>\n" +
                    " <td>"+(pricePackage.getDuration() != -1 ? pricePackage.getDuration() : "Unlimited")+" (Month)</td>\n" +
                    " <td>"+pricePackage.getListPrice()+" ($)</td>\n" +
                    " <td>"+pricePackage.getSalePrice()+" ($)</td>\n" +
                    " <td>"+pricePackage.getStatus().getName()+"</td>\n" +
                    " <td>\n" +
                    "   <a style=\"margin-right: 5px; text-decoration: none \" href = \"#\" onclick =\"DeletePricePackage("+pricePackage.getId()+","+cid+","+pageIndex+")\" >Delete</a>\n" +
                    "   <a style=\"margin-right: 5px; text-decoration: none \" href = \"../../admin/pricepackage/edit?pid="+pricePackage.getId()+"&cid="+cid+"\">Edit</a>\n" +
                    "   <a style=\"text-decoration: none\" href = \"#\" onclick = \"ActionPricePackage("+pricePackage.getId()+","+pricePackage.getStatus().getId()+","+cid+","+pageIndex+")\">"+ (pricePackage.getStatus().getId() == 1 ? "Deactivate" : "Active")+"</a>\n" +
                    " </td>\n" +
                    " </tr>");
        }          
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
