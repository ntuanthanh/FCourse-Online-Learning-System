/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.PricePackageDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PricePackage;

/**
 *
 * @author pv
 */
public class AjaxSearchPricePackage_SubjectDetailController extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        PricePackageDBContext pricePackageDB = new PricePackageDBContext();
        ArrayList<PricePackage> pricePackages = pricePackageDB.seachPricePackageByName(txtSearch);
        for (PricePackage pricePackage : pricePackages) {
            response.getWriter().print("<li onclick=\"addPricePackage(this)\" id='"+pricePackage.getId()+"'>" + "Package "+pricePackage.getName() +""
                    + " ( <span style = \"color : #819830\">List Price</span> : " + pricePackage.getListPrice() + "$" + " - <span style = \"color : #819830\">Sale Price</span> : "  +pricePackage.getSalePrice()  + "$" + " )"+"</li>");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
