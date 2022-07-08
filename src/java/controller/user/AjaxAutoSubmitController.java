/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.OptionDBContext;
import dal.QuestionDBContext;
import dal.UserQuizDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class AjaxAutoSubmitController extends HttpServlet {

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
            out.println("<title>Servlet AjaxAutoSubmitController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjaxAutoSubmitController at " + request.getContextPath() + "</h1>");
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
        User user = (User) request.getSession().getAttribute("user");
        int quizId = Integer.parseInt(request.getParameter("quiz"));

        QuestionDBContext qdb = new QuestionDBContext();
        ArrayList<Question> questions = qdb.getQuestionByQuizId(quizId);

        OptionDBContext odb = new OptionDBContext();
        ArrayList<Option> ops = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            int questionID = Integer.parseInt(request.getParameter("question" + i));
            String[] answers = request.getParameterValues("answer" + i);

            if (answers != null && answers.length > 0) {
                for (int j = 0; j < answers.length; j++) {
                    if (answers[j].length() > 0 && answers[j] != null) {
                        int as = Integer.parseInt(answers[j]);
                        Option o = new Option();
                        o.setId(as);

                        Question q = new Question();
                        q.setId(questionID);

                        o.setQuestion(q);
                        ops.add(o);
                    }
                }
            }
        }

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
        
        UserQuiz userQuiz = (UserQuiz) request.getSession().getAttribute("doingQuiz");
        if (ops != null || ops.size() > 0) {
             userQuiz.setOps(ops);
        }
      
        request.getSession().setAttribute("doingQuiz", userQuiz);
      
   
       
         
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
