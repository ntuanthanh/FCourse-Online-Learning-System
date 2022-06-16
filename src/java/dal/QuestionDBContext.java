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
import model.Question;
import model.QuizLevel;
import model.Status;
import model.Tag;

/**
 *
 * @author ADMIN
 */
public class QuestionDBContext extends DBContext{

    public  ArrayList <Question> getQuestion() {
        
        ArrayList <Question> getQ = new ArrayList<>();
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
    public static void main(String[] args) {
        QuestionDBContext qdb = new QuestionDBContext();
        ArrayList<Question> qs = qdb.getQuestion();
        int size =  qs.size();
        System.out.println(""+size);
        for (Question q : qs) {
            System.out.println("c:"+ q.getContent()+q.getAnswer());
        }
    }
}
