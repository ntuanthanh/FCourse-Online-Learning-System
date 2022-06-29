/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.PricePackageDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PricePackage;
import model.User;

/**
 *
 * @author pv
 */
public class AjaxDeletePricePackage_SubjectDetail extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid")); 
        int cid = Integer.parseInt(request.getParameter("cid"));
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        int pageSize = 2; 
        PricePackageDBContext pricePackageDB = new PricePackageDBContext();
        pricePackageDB.DeletePricePackageByCourse(cid, pid);
        ArrayList<PricePackage> pricePackages = pricePackageDB.getPricePackgeByCoursePaging(cid, pageIndex , pageSize);
        int count = pricePackageDB.CountGetPricePackgeByCoursePaging(cid);
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        int gap = 2;
        UserDBContext userDB = new UserDBContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        boolean isOwnerCourse = userDB.isOwnerOfCourse(cid, user);
        boolean isAdmin = userDB.isAdmin(user.getId());
        response.getWriter().print("<table class=\"table table-hover\">\n" +
"                            <thead>\n" +
"                                <tr class = \"bg-warning\">\n" +
"                                    <th scope=\"col\">#</th>\n" +
"                                    <th scope=\"col\">Package</th>\n" +
"                                    <th scope=\"col\">Duration(month)</th>\n" +
"                                    <th scope=\"col\">List Price</th>\n" +
"                                    <th scope=\"col\">Sale Price</th>\n" +
"                                    <th scope=\"col\">Status</th>\n" );
       if(isAdmin == true){
        response.getWriter().print("<th scope=\"col\">Action</th> "
                                 + "</tr>"
                           + "</thead>");
       }
       response.getWriter().print(""
                            + "<tbody id = \"table-price\">\n " ); 
        for (PricePackage pricePackage : pricePackages) {
           response.getWriter().print(""
                               + "<tr>\n" +
"                                      <th scope=\"row\">"+pricePackage.getId()+"</th>\n" +
"                                      <td>"+pricePackage.getName()+"</td>\n" +
"                                      <td>"+(pricePackage.getDuration() != -1 ? pricePackage.getDuration() : "Unlimited") +" (Month)</td>\n" +
"                                      <td>"+pricePackage.getListPrice()+" ($)</td>\n" +
"                                      <td>"+pricePackage.getSalePrice()+" ($)</td>\n" +
"                                      <td>"+pricePackage.getStatus().getName()+"</td>\n" );
         if(isAdmin){
           response.getWriter().print(""
                   + "                <td>\n" +
                   "                       <a style=\"margin-right: 5px; text-decoration: none \" href = \"#\" onclick =\"DeletePricePackage("+pricePackage.getId()+","+cid+","+pageIndex+")\" >Delete</a>\n" +
"                                          <a style=\"margin-right: 5px; text-decoration: none \" href = \"../../admin/pricepackage/edit?pid="+pricePackage.getId()+"&cid="+cid+"\">Edit</a>\n" +
"                                          <a style=\"text-decoration: none\" href = \"#\" onclick = \"ActionPricePackage("+pricePackage.getId()+","+pricePackage.getStatus().getId()+","+cid+","+pageIndex+")\">"+ (pricePackage.getStatus().getId() == 1 ? "Deactivate" : "Active")+"</a>\n" +
"                                     </td>");
         }
         response.getWriter().print(""
                 + "           </tr>");
       }
        response.getWriter().print("</tbody>"
                + "             </table>");
       response.getWriter().print(""
               + "<div style=\"display: flex;justify-content: center; margin-top: 20px;\" >\n" +
"                            <ul class=\"pagination\" id = \"paggerBottom\">"
               + "");
       if(pageIndex - gap > 1){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingPricePackage("+cid+","+1+")\">First</a></li>");
       }
       if(pageIndex > 1){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingPricePackage("+cid+","+(pageIndex-1)+")\">Previous</a></li>");
       } 
       for(int i = pageIndex - gap; i < pageIndex; i++){
        if(i > 0)
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingPricePackage("+cid+","+i+")\">"+i+"</a></li>");
       }
       if(totalPage > 0)
         response.getWriter().print("<li class=\"page-item active\"><a class=\"page-link\")\">"+pageIndex+"</a></li>");
       for(int i = pageIndex + 1; i <= pageIndex + gap; i++){
        if(i <= totalPage)
         response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingPricePackage("+cid+","+i+")\">"+i+"</a></li>");
       } 
       if(pageIndex < totalPage){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingPricePackage("+cid+","+(pageIndex + 1)+")\">Next</a></li>");
       }
       if(pageIndex + gap < totalPage){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingPricePackage("+cid+","+(totalPage)+")\">Last</a></li>");
       }
       response.getWriter().print("</ul>"
               + "</div>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
