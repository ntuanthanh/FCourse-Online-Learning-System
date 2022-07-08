/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.DimensionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dimension;

/**
 *
 * @author pv
 */
public class AjaxPagingDimension extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        DimensionDBContext dimensionDB = new DimensionDBContext();
        int pageSize = 2; 
        ArrayList<Dimension> dimensions = dimensionDB.getDimenstionByCoursePaging(cid, pageIndex, pageSize);
        int count = dimensionDB.CountGetDimensionCoursePaging(cid);
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        int gap = 2;
        response.getWriter().print(""
                + "    <table class=\"table table-hover\">\n" +
"                            <thead>\n" +
"                                <tr class = \"bg-warning\">\n" +
"                                    <th scope=\"col\">#</th>\n" +
"                                    <th scope=\"col\">Type</th>\n" +
"                                    <th scope=\"col\">Dimension</th>\n" +
"                                    <th scope=\"col\">Action</th>\n" +
"                                </tr>\n" +
"                            </thead>");
        response.getWriter().print(""
                           + " <tbody>");
        for (Dimension dimension : dimensions) {
          response.getWriter().print(""
                               + "<tr>\n" +
"                                   <th scope=\"row\">"+dimension.getId()+"</th>\n" +
"                                   <td>"+dimension.getDimensionType().getName()+"</td>\n" +
"                                   <td>"+dimension.getName()+"</td>\n" +
"                                   <td>\n" +
"                                       <a style=\"margin-right: 5px; text-decoration: none \" href = \"../../admin/dimension/edit?did="+dimension.getId()+"&cid="+cid+"\">Edit</a>\n" +
"                                       <a style=\"text-decoration: none \"href = \"#\" onclick =\"DeleteDimension("+dimension.getId()+","+cid+","+pageIndex+")\">Delete</a>\n" +
"                                    </td>\n" +
"                                 </tr>");
        }
        response.getWriter().print(""
                           + " </tbody>"
                + "     </table>");
        response.getWriter().print(""
               + "<div style=\"display: flex;justify-content: center; margin-top: 20px;\" >\n" +
"                            <ul class=\"pagination\">"
               + "");
       if(pageIndex - gap > 1){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingDimension("+cid+","+1+")\">First</a></li>");
       }
       if(pageIndex > 1){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingDimension("+cid+","+(pageIndex-1)+")\">Previous</a></li>");
       } 
       for(int i = pageIndex - gap; i < pageIndex; i++){
        if(i > 0)
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingDimension("+cid+","+i+")\">"+i+"</a></li>");
       }
       if(totalPage > 0)
        response.getWriter().print("<li class=\"page-item active\"><a class=\"page-link\")\">"+pageIndex+"</a></li>");
       for(int i = pageIndex + 1; i <= pageIndex + gap; i++){
        if(i <= totalPage)
         response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingDimension("+cid+","+i+")\">"+i+"</a></li>");
       } 
       if(pageIndex < totalPage){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingDimension("+cid+","+(pageIndex + 1)+")\">Next</a></li>");
       }
       if(pageIndex + gap < totalPage){
        response.getWriter().print("<li class=\"page-item\"><a class=\"page-link\" onclick =\"pagingDimension("+cid+","+(totalPage)+")\">Last</a></li>");
       }
       response.getWriter().print("</ul>"
               + "</div>");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    

   

}
