/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.manager;

import dal.LessonDBContext;
import model.LessonQuiz;
import dal.LessonQuizDBConetxt;
import dal.QuizDBContext;
import dal.TopicDBContext;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Lesson;
import model.Quiz;
import model.Topic;

/**
 *
 * @author thand
 */
public class LessonDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Lid = "1";
        Lid = request.getParameter("Lid");
        int a = 1;
        if (Lid != null && !Lid.isEmpty()) {
            a = Integer.parseInt(Lid);
        }
        String cid = request.getParameter("cid");
        int c = 1;
        if (cid != null && !cid.isEmpty()) {
            c = Integer.parseInt(cid);
        }
        TopicDBContext tdb = new TopicDBContext();
        ArrayList<Topic> Topics = tdb.getTopics(c);
        LessonDBContext ldb = new LessonDBContext();
        Lesson Lesson = ldb.getLesson(Lid);
        Topic T = tdb.getTopic(c);
        request.setAttribute("T", T);
        if (Lesson != null) {
            LessonQuizDBConetxt lqdb = new LessonQuizDBConetxt();
            ArrayList<LessonQuiz> lqs = lqdb.getLessonQuizs(Lesson.getId());
            request.setAttribute("lqs", lqs);
        }
        QuizDBContext qdb = new QuizDBContext();
        ArrayList<Quiz> Quizs = qdb.getQuizs(c);

        request.setAttribute("Quizs", Quizs);
        request.setAttribute("Topics", Topics);
        request.setAttribute("Lesson", Lesson);
        request.getSession().setAttribute("cid", cid);
        request.getSession().setAttribute("Lesson", Lesson);
        request.getRequestDispatcher("view/admin/LessonDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lesson Les = (Lesson) request.getSession().getAttribute("Lesson");
        String cid = (String) request.getSession().getAttribute("cid");
        String Lid = request.getParameter("Lid");
        String name = request.getParameter("name");
        String selecttype = request.getParameter("selecttype");
        String topic = request.getParameter("topicid");
        int topicid = Integer.parseInt(topic);
        String or = request.getParameter("order");
        int order = Integer.parseInt(or);
        LessonDBContext ldb = new LessonDBContext();
        if (Lid != null) {
            if (selecttype.equals("Lesson")) {
                String link = request.getParameter("link");
                String htmlcontent = request.getParameter("htmlcontent");
                ldb.updateLessonDetail(Lid, link, name, htmlcontent,
                        Les.getStatus().getId(), topicid, order, selecttype);
            }
            if (selecttype.equals("Subject Topic")) {
                ldb.updateLessonDetail(Lid, "", name, "",
                        Les.getStatus().getId(), topicid, order, selecttype);
            }
            if (selecttype.equals("Quiz")) {

                LessonQuizDBConetxt lqdb = new LessonQuizDBConetxt();
                ArrayList<LessonQuiz> lqs = lqdb.getLessonQuizs(Les.getId());
                String[] quizids = request.getParameterValues("quizid");
                updateQuiz( Lid, quizids, lqs);
                String htmlcontent = request.getParameter("htmlcontent");
                ldb.updateLessonDetail(Lid, "", name, htmlcontent,
                        Les.getStatus().getId(), topicid, order, selecttype);
            }
        } else {

            if (selecttype.equals("Lesson")) {
                String link = request.getParameter("link");
                String htmlcontent = request.getParameter("htmlcontent");
                ldb.INSERTLessonDetail(link, name, htmlcontent, 1, topicid,
                        order, selecttype);
            }
            if (selecttype.equals("Subject Topic")) {
                ldb.INSERTLessonDetail("", name, "", 1, topicid,
                        order, selecttype);
            }
            if (selecttype.equals("Quiz")) {
                String quizid = request.getParameter("quizid");
                String htmlcontent = request.getParameter("htmlcontent");
                ldb.INSERTLessonDetail("", name, htmlcontent, 1, topicid,
                        order, selecttype);
            }
        }
        request.getSession().setAttribute("Lesson_successful", "Lesson_successful");
        
        String url = "LessonDetail?cid=" + cid;
        response.sendRedirect(url);
    }

    public void updateQuiz(String Lid, String[] quizids, ArrayList<LessonQuiz> lqs) {
        if(quizids==null || quizids.length==0){
             for (int i = 0; i < lqs.size(); i++) {
                 LessonQuizDBConetxt a = new LessonQuizDBConetxt();
                a.deleteLessonQuiz(lqs.get(i).getLessonId(), lqs.get(i).getQid());
             }
             return;
        }
        for (int i = 0; i < lqs.size(); i++) {
            int n = 0;
            for (int j = 0; j < quizids.length; j++) {
                int a = Integer.parseInt(quizids[j].trim());
                if (a == lqs.get(i).getQid()) {
                    n = 1;
                    break;
                }
            }
            if (n == 0) {
//                        delete
                LessonQuizDBConetxt a = new LessonQuizDBConetxt();
                a.deleteLessonQuiz(lqs.get(i).getLessonId(), lqs.get(i).getQid());
            }
        }
        
        for (int i = 0; i < quizids.length; i++) {
            int n = 0;
            for (int j = 0; j < lqs.size(); j++) {
                if (Integer.parseInt(quizids[i].trim()) == lqs.get(j).getQid()) {
                    n = 1;
                    break;
                }
            }
            if (n == 0) {
//                        insert
                LessonQuizDBConetxt b = new LessonQuizDBConetxt();
                b.insertLessonQuiz( Integer.parseInt(Lid), Integer.parseInt(quizids[i]));
            }
        }
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
