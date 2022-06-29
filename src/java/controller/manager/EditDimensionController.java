/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import controller.authorization.BaseAuthController;
import dal.DimensionDBContext;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Dimension;
import model.DimensionType;
import model.User;

/**
 *
 * @author pv
 */
public class EditDimensionController extends BaseAuthController {
  
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int did; 
        int cid;
        try{
           did = Integer.parseInt(request.getParameter("did"));
        }catch(Exception e){
           did = 1;
        }
        try{
           cid = Integer.parseInt(request.getParameter("cid"));
        }catch(Exception e){
           cid = 1;
        }
         // check xem Account hiện tại( Đã là expert và admin ) có phải Owner của khóa học hay không
        UserDBContext userDB = new UserDBContext();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        boolean isOwnerCourse = userDB.isOwnerOfCourse(cid, user);
        boolean isAdmin = userDB.isAdmin(user.getId());
        if(!isOwnerCourse && !isAdmin){
            request.getRequestDispatcher("../../view/base/404page.jsp").forward(request, response);
            return;
        }
        // get dimension by id
        DimensionDBContext dimensionDB = new DimensionDBContext();
        Dimension dimension = dimensionDB.getDimensionById(did);
        // get all DimensionType 
        ArrayList<DimensionType> dimensiontypes = dimensionDB.getAllDimensionType();
        request.setAttribute("cid", cid);
        request.setAttribute("dimension", dimension);
        request.setAttribute("dimensiontypes", dimensiontypes);
        request.getRequestDispatcher("../../view/admin/editDimension.jsp").forward(request, response);
    }

    
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int did = Integer.parseInt(request.getParameter("did")); 
        int cid = Integer.parseInt(request.getParameter("cid"));
        String dname = request.getParameter("dname"); 
        String description = request.getParameter("description");
        int dimensiontype_id =  Integer.parseInt(request.getParameter("dimensiontype_id"));
        Dimension d = new Dimension();
        d.setId(did);
        d.setName(dname);
        d.setDescription(description);
        DimensionType dt = new DimensionType();
        dt.setId(dimensiontype_id);
        d.setDimensionType(dt);
        // update 
        DimensionDBContext dimensionDB = new DimensionDBContext();
        dimensionDB.updateDimension(d);
        request.setAttribute("mess", "oke");
        request.setAttribute("cid", cid);
        request.setAttribute("did", did);
        doGet(request, response);
    }

}
