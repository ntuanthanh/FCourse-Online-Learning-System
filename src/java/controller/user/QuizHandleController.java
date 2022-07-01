/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.authorization.BaseAuthController;
import dal.OptionDBContext;
import dal.QuestionDBContext;
import dal.QuizDBContext;
import dal.UserQuizDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Option;
import model.Question;
import model.Quiz;
import model.User;
import model.UserQuiz;

/**
 *
 * @author jicon
 */
public class QuizHandleController extends BaseAuthController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        QuizDBContext qudb = new QuizDBContext();
        Quiz quiz = qudb.getQuizByQuizIDForQ(quizId);
        QuestionDBContext qdb = new QuestionDBContext();
        ArrayList<Question> questions = qdb.getQuestionByQuizId(quizId);
        User user = (User) request.getSession().getAttribute("user");
   
        if (request.getSession().getAttribute("doingQuiz") == null) {
            User u = new User();
            u.setId(user.getId());
            UserQuiz uq = new UserQuiz();
            uq.setUser(u);
            uq.setQuiz(quiz);
            uq.setTime(ZonedDateTime.now().toInstant().toEpochMilli());
           
            request.getSession().setAttribute("doingQuiz", uq);
        } else {
            UserQuiz userq = (UserQuiz) request.getSession().getAttribute("doingQuiz");
            ArrayList<Option> ops = userq.getOps();
            request.setAttribute("choose",ops);
                
        }
        
       
        request.setAttribute("quiz", quiz);
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("../view/quizhandle.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        User user = (User) request.getSession().getAttribute("user");
//        int quizId = Integer.parseInt(request.getParameter("quiz"));
//        
//     
//        QuestionDBContext qdb = new QuestionDBContext();
//        ArrayList<Question> questions = qdb.getQuestionByQuizId(quizId);
//
//        OptionDBContext odb = new OptionDBContext();
//        ArrayList<Option> ops = new ArrayList<>();
//        for (int i = 0; i < questions.size(); i++) {
//            int questionID = Integer.parseInt(request.getParameter("question" + i));
//            String[] answers = request.getParameterValues("answer" + i);
//          
//            if (answers != null && answers.length > 0) {
//                for (int j = 0; j < answers.length; j++) {
//                    if (answers[j].length() > 0 && answers[j] != null) {
//                        int as = Integer.parseInt(answers[j]);
//                        Option o = new Option();
//                        o.setId(as);
//                        
//                        Question q = new Question();
//                        q.setId(questionID);
//                        
//                        o.setQuestion(q);
//                        ops.add(o);
//                    }
//                }
//            }
//        }
//      
//        User u = new User();
//        u.setId(1015);
//        UserQuiz uq = new UserQuiz();
//        
//        uq.setUser(u);
//        uq.setOps(ops);
//        
//        Quiz q = new Quiz();
//        q.setId(quizId);
//        uq.setQuiz(q);
        request.getSession().removeAttribute("doingQuiz");
        request.getSession().setAttribute("quizHandle_mess", "quizHandle_mess");
        
        response.sendRedirect("../home");

//        request.getRequestDispatcher("TakeQuizResult.jsp").forward(request, response);
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
