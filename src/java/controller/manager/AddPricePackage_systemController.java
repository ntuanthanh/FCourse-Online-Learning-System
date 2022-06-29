/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.PricePackageDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PricePackage;
import model.Status;

/**
 *
 * @author pv
 */
public class AddPricePackage_systemController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String pname = request.getParameter("pname");
        int duration = Integer.parseInt(request.getParameter("duration"));
        float listprice = Float.parseFloat(request.getParameter("listprice"));
        float saleprice = Float.parseFloat(request.getParameter("saleprice"));
        int statusId = Integer.parseInt(request.getParameter("status_id"));
        
        PricePackage p = new PricePackage(); 
        p.setName(pname);
        p.setDuration(duration);
        p.setListPrice(listprice);
        p.setSalePrice(saleprice);
        Status s = new Status(); 
        s.setId(statusId);
        p.setStatus(s);
        // add to pricepackage 
        PricePackageDBContext pricePackageDB = new PricePackageDBContext();
        pricePackageDB.AddPricePackageToSystem(p);
        response.sendRedirect("../../admin/pricepackage/add?cid="+cid);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
}
