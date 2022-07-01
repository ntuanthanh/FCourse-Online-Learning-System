/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Option;
import model.Question;
import model.UserQuiz;

/**
 *
 * @author jicon
 */
public class UserQuizDBContext extends DBContext {

    public ArrayList<Integer> answerQuestion(int qid, ArrayList<Option> ops) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (Option op : ops) {
            if (op.getQuestion().getId() == qid) {
                answer.add(op.getId());
            }
        }
        return answer;
    }

    public void insertUserQuiz(UserQuiz u) {
        ArrayList<Option> ops = u.getOps();
        QuestionDBContext questiondb = new QuestionDBContext();
        ArrayList<Question> questions = questiondb.getQuestionByQuizId(u.getQuiz().getId());
        OptionDBContext optiondb = new OptionDBContext();
        float mark = 0;
        for (Question q : questions) {
            boolean isCorrect = false;
            ArrayList<Integer> listCorrectAnswers = optiondb.getIdOptionCorrect(q.getId());
            ArrayList<Integer> answers = answerQuestion(q.getId(), ops);
            if (answers != null && answers.size() == listCorrectAnswers.size()) {
                for (int answer : answers) {
                    if (!listCorrectAnswers.contains(answer)) {
                        isCorrect = false;
                        break;
                    } else {
                        isCorrect = true;
                    }
                }
            }
            if (isCorrect) {
                mark = mark + 1;
            }
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Timestamp curent = new Timestamp(cal.getTimeInMillis());
        mark = mark * 10 / questions.size();
        try {

            connection.setAutoCommit(false);
            String sql = "INSERT INTO [dbo].[UserQuiz]\n"
                    + "           ([Mark]\n"
                    + "           ,[StarTime]\n"
                    + "           ,[QuizId]\n"
                    + "           ,[UserId])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setFloat(1, mark);
            stm.setTimestamp(2, curent);
            stm.setInt(3, u.getQuiz().getId());
            stm.setInt(4, u.getUser().getId());

            stm.executeUpdate();
//            String sql_get_id ="select studentid as sid";
//            ResultSet rs = stm.executeQuery();
//            
            String sql_get_uid = " SELECT @@IDENTITY as uid ";
            PreparedStatement stm_get_uid = connection.prepareStatement(sql_get_uid);
            ResultSet rs = stm_get_uid.executeQuery();
            if (rs.next()) {
                u.setId(rs.getInt("uid"));
            }
            if (u.getOps().size() > 0 || u.getOps() != null) {
                for (Option op : u.getOps()) {
                    String sql_add_choose = "INSERT INTO [dbo].[UserQuesionAnswer]\n"
                            + "           ([QuestionId]\n"
                            + "           ,[OptionId]\n"
                            + "           ,[UserQuizId])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,?\n"
                            + "           ,?)";
                    PreparedStatement stm_add_choose = connection.prepareStatement(sql_add_choose);
                    stm_add_choose.setInt(1, op.getQuestion().getId());
                    stm_add_choose.setInt(2, op.getId());
                    stm_add_choose.setInt(3, u.getId());
                    stm_add_choose.executeUpdate();

                }
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UserQuizDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserQuizDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserQuizDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
