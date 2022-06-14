/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.TagDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tag;

/**
 *
 * @author tuanthanh
 * 14/6/2022
 */
public class AjaxSearchTag_SubjectDetailController extends HttpServlet {



   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        TagDBContext tagDB = new TagDBContext();
        ArrayList<Tag> tags = tagDB.SearchTag(txtSearch);
        for (Tag tag : tags) {
           response.getWriter().print("<li onclick=\"addTag(this)\" id='"+tag.getTagId()+"'>"+tag.getTagname() + "</li>");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
