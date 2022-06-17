/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.CategoryDBContext;
import dal.CourseDBContext;
import dal.DimensionDBContext;
import dal.QuestionDBContext;
import dal.QuizLevelDBContext;
import dal.StatusDBContext;
import dal.TagDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Dimension;
import model.Question;
import model.QuizLevel;
import model.Status;
import model.Tag;

/**
 *
 * @author ADMIN
 */
public class QuestionListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuestionListController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuestionListController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        QuizLevelDBContext qdb = new QuizLevelDBContext();
        ArrayList<QuizLevel> listQuizLevels = qdb.getListQuizLevels();
        request.setAttribute("quizlevels", listQuizLevels);
        
         StatusDBContext sdb = new StatusDBContext();
        ArrayList<Status> allStatuses = sdb.getAllStatuses();
        request.setAttribute("status", allStatuses);
        
        DimensionDBContext db = new DimensionDBContext();
        ArrayList<Dimension> dimensions = db.getDimensions();
        request.setAttribute("dimensions", dimensions);
//        boolean []tidCheck = new boolean[tags.size()];
//        
//        String []tid_raw = request.getParameterValues("tagId");
//        int[] tid = null;
//        if(tid_raw!=null){
//            tid = new int[tid_raw.length];
//            for (int i = 0; i < tid_raw.length; i++) {
//                   tid[i] = Integer.parseInt(tid_raw[i]);
//            }
//        }
//        for (int i = 0; i < tidCheck.length; i++) {
//            tidCheck[i] = ischeck(tags.get(i).getTagId(), tid); //finding tag having check
//        }
 
      
        
        
        String status = request.getParameter("status");    
        int stt = -1;
        if (status != null){
            stt = Integer.parseInt(status);
        }
        String dimension = request.getParameter("dimensions");
        int did = -1;
        if (dimension != null){
            did = Integer.parseInt(dimension);
        }
        
        String []cid_raw = request.getParameterValues("qid");
        
        int[] cid = null;
        ArrayList <Integer> qid = new ArrayList<>();
        if(cid_raw!=null){
            cid = new int[cid_raw.length];
            for (int i = 0; i < cid_raw.length; i++) {
                   cid[i] = Integer.parseInt(cid_raw[i]);
                   qid.add(cid[i]);                  
            }
        }
        
      
        QuestionDBContext q = new QuestionDBContext();
        ArrayList<Question> question = q.getFilterQuestion(stt, did, cid);
        request.setAttribute("list", question);
        
       
        request.setAttribute("qid", qid);
        request.setAttribute("stt", stt);
        request.setAttribute("did", did);
        
//        response.getWriter().println("a"+question.get(0).getOption1());
        request.getRequestDispatcher("../view/questionlist.jsp").forward(request, response);
  //    response.sendRedirect("../view/demo.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   
}
