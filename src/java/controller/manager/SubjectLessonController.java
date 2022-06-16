/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.CourseDBContext;
import dal.LessonDBContext;
import dal.StatusDBContext;
import dal.TopicDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Lesson;
import model.Status;
import model.Topic;

/**
 *
 * @author tuann
 */
public class SubjectLessonController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        LessonDBContext dbLesson = new LessonDBContext();
        String name = request.getParameter("name");
        String tid = request.getParameter("tid");
        String sid = request.getParameter("sid");
        String cid = request.getParameter("cid");
        if(tid==null|| tid.length()==0){
            tid="-1";
        }
        if(sid==null|| sid.length()==0){
            sid="-1";
        }
        int tid_int = Integer.parseInt(tid);
        int sid_int = Integer.parseInt(sid);
        CourseDBContext dbCourse = new CourseDBContext();
        int int_cid = Integer.parseInt(cid);
        Course course = dbCourse.getCourseDetail(int_cid);
        
        StatusDBContext dbStatus = new StatusDBContext();
        ArrayList<Status> statuses = dbStatus.getAllStatuses();
       
        TopicDBContext dbTopic = new TopicDBContext();
        ArrayList<Topic> topics = dbTopic.getTopics(int_cid);
        
        
        ArrayList<Lesson> searchsubjectlesson = dbLesson.getLessonListForSubjectLesson(cid, tid_int, name, sid_int);
        request.setAttribute("searchsubjectlesson", searchsubjectlesson);
        request.setAttribute("course", course);
        request.setAttribute("sid", sid);
        request.setAttribute("tid", tid);
        request.setAttribute("cid", cid);
        request.setAttribute("name", name);
        
        request.setAttribute("statuses", statuses);
        request.setAttribute("topics", topics);
        System.out.println(searchsubjectlesson);
        request.getRequestDispatcher("../view/admin/subjectlesson.jsp").forward(request, response);
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
        processRequest(request, response);
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
