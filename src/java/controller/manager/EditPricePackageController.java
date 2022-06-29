/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.PricePackageDBContext;
import dal.StatusDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PricePackage;
import model.Status;
import model.User;

/**
 *
 * @author pv
 */
public class EditPricePackageController extends BaseAuthController {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid; 
        int cid;
        try{
           pid = Integer.parseInt(request.getParameter("pid"));
        }catch(Exception e){
           pid = 1;
        }
        try{
           cid = Integer.parseInt(request.getParameter("cid"));
        }catch(Exception e){
           cid = 1;
        } 
        // get pricepackage by id
        PricePackageDBContext pricePackageDB = new PricePackageDBContext();
        PricePackage p = pricePackageDB.getPricePackageById(pid);
        // get all status
        StatusDBContext statusDB = new StatusDBContext();
        ArrayList<Status> statuses = statusDB.getAllStatuses();
        request.setAttribute("cid", cid);
        request.setAttribute("pricepackage", p);
        request.setAttribute("statuses", statuses);
        request.getRequestDispatcher("../../view/admin/editPricePackage.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String pname = request.getParameter("pname");
        int duration = Integer.parseInt(request.getParameter("duration"));
        float listprice = Float.parseFloat(request.getParameter("listprice"));
        float saleprice = Float.parseFloat(request.getParameter("saleprice"));
        int statusId = Integer.parseInt(request.getParameter("status_id"));
        
        PricePackage p = new PricePackage(); 
        p.setId(pid);
        p.setName(pname);
        p.setDuration(duration);
        p.setListPrice(listprice);
        p.setSalePrice(saleprice);
        Status s = new Status(); 
        s.setId(statusId);
        p.setStatus(s);
        // update 
        PricePackageDBContext pricePackageDB = new PricePackageDBContext(); 
        pricePackageDB.UpdatePricePackage(p);
        request.setAttribute("mess", "oke");
        request.setAttribute("cid", cid);
        request.setAttribute("pid", pid);
        doGet(request, response);
        //response.sendRedirect("edit?pid="+p.getId());
    }

   
}
