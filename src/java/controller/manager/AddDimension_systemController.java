/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.DimensionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dimension;
import model.DimensionType;

/**
 *
 * @author pv
 */
public class AddDimension_systemController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid")); 
        String dname = request.getParameter("dname"); 
        String description = request.getParameter("description");
        int dimensiontype_id = Integer.parseInt(request.getParameter("dimensiontype_id"));
        //
        Dimension d = new Dimension();
        d.setName(dname);
        d.setDescription(description);
        DimensionType dt = new DimensionType();
        dt.setId(dimensiontype_id);
        d.setDimensionType(dt);
        // add
        DimensionDBContext dimensionDB = new DimensionDBContext();
        dimensionDB.AddDimension(d);
        // Lưu message bằng session, hiện thị trong thì xóa nó đi 
        request.getSession().setAttribute("addDimensionSystem_mess", "addDimensionSystem_mess");
        response.sendRedirect("../../admin/dimension/add?cid="+cid);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
