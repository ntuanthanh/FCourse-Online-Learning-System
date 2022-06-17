/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Course;
import model.Dimension;
import model.Question;
import model.QuizLevel;
import model.Status;
import model.Tag;

/**
 *
 * @author ADMIN
 */
public class QuestionDBContext extends DBContext {

    public ArrayList<Question> getQuestion() {

        ArrayList<Question> getQ = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT [Id]\n"
                + "      ,[Answer]\n"
                + "      ,[Content]\n"
                + "      ,[Explaination]\n"
                + "      ,[Option1]\n"
                + "      ,[Option2]\n"
                + "      ,[Option3]\n"
                + "      ,[Option4]\n"
                + "      ,[CourseId]\n"
                + "      ,[QuizLevelId]\n"
                + "      ,[StatusId]\n"
                + "  FROM [dbo].[QuesionBank]";
        try {
            stm = connection.prepareStatement(sql);
            //   stm.setInt(1, QuestionId);
            //    stm.executeQuery();
            rs = stm.executeQuery();
            while (rs.next()) {
                Question Question = new Question();
                Question.setId(rs.getInt(1));
                //  Question.setCreatedate(rs.getDate("createdate"));
                Question.setAnswer(rs.getString(2));
                Question.setContent(rs.getString(3));
                Question.setExplain(rs.getString(4));
                Question.setOption1(rs.getString(5));
                Question.setOption2(rs.getString(6));
                Question.setOption3(rs.getString(7));
                Question.setOption4(rs.getString(8));

                Course course = new Course();
                course.setCourseId(rs.getInt(9));
                Question.setCourse(course);

                QuizLevel q = new QuizLevel();
                q.setId(rs.getInt(10));
                Question.setQuizlevel(q);

                Status a = new Status();
                a.setId(rs.getInt(11));
                Question.setStatus(a);
                getQ.add(Question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }
        }
        return getQ;
    }

    public ArrayList<Question> getFilterQuestion(int stt, int did, int[] qlv) {

        ArrayList<Question> getQ = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT q.id, q.Answer, q.Content, q.Explaination, q.Option1,\n"
                + "q.Option2, q.Option3, q.Option4, q.CourseId, q.QuizLevelId, q.StatusId, d.Did \n"
                + "FROM QuesionBank as q left join QuesionDimension as d  on q.Id = d.Qid where (1=1) \n";

        if (stt > -1) {
            sql += " and StatusId = ? ";
        }
        if (did > -1) {
            sql += " and Did = ? ";
        }
        if (qlv != null) {
            sql += " and QuizLevelId in(";
            for (int i = 0; i < qlv.length; i++) {
                sql += qlv[i] + ",";
            }
            if (sql.endsWith(",")) {
                sql = sql.substring(0, sql.length() - 1);
            }
            sql += ")";
        }

        try {
            stm = connection.prepareStatement(sql);
            if (stt > -1) {
                stm.setInt(1, stt);
                if (did > -1) {
                    stm.setInt(2, did);
                }
            }
            if (did > -1) {
                stm.setInt(1, did);
            }

            rs = stm.executeQuery();
            while (rs.next()) {
                Question Question = new Question();
                Question.setId(rs.getInt("id"));
                //  Question.setCreatedate(rs.getDate("createdate"));
                Question.setAnswer(rs.getString("Answer"));
                Question.setContent(rs.getString("Content"));
                Question.setExplain(rs.getString("Explaination"));
                Question.setOption1(rs.getString("Option1"));
                Question.setOption2(rs.getString("Option2"));
                Question.setOption3(rs.getString("Option3"));
                Question.setOption4(rs.getString("Option4"));

//                Course course = new Course();
//                course.setCourseId(rs.getInt("CourseId"));
                CourseDBContext cdb = new CourseDBContext();
                Course subjectById = cdb.getSubjectById(rs.getInt("CourseId"));
                
                Question.setCourse(subjectById);

            
                QuizLevelDBContext qdb = new QuizLevelDBContext();
                QuizLevel q = qdb.getQuizLevelById(rs.getInt("QuizLevelId"));
                Question.setQuizlevel(q);

               StatusDBContext sdb = new StatusDBContext();
                Status a = sdb.getStatus(rs.getInt("StatusId"));
              //  a.setId();
                Question.setStatus(a);
                
                int didd = rs.getInt("Did");
                DimensionDBContext db = new DimensionDBContext();
                Dimension d = db.getDimensionById(didd);
                
               Question.setDimension(d);
                getQ.add(Question);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
            }
        }
        return getQ;
    }

    public static void main(String[] args) {
        QuestionDBContext qdb = new QuestionDBContext();
        ArrayList<Question> qs = qdb.getQuestion();
        int size = qs.size();
        System.out.println("" + size);
        for (Question q : qs) {
            System.out.println("c:" + q.getContent() + q.getAnswer());
        }
    }
}
