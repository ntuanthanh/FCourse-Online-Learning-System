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
public class AjaxSearchDimension_subjectDetail extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        DimensionDBContext dimensionDB = new DimensionDBContext();
        ArrayList<Dimension> dimensions = dimensionDB.searchDimensionByName(txtSearch);
        for (Dimension dimension : dimensions) {
            response.getWriter().print("<li onclick=\"addDimension(this)\" id='"+dimension.getId()+"'>" + "Dimension "+dimension.getName() +""
                    + " ( <span style = \"color : #819830\">Type</span> : " + dimension.getDimensionType().getName() + " )"+"</li>"); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
}
