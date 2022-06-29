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
import model.Course;
import model.Quiz;

/**
 *
 * @author thand
 */
public class QuizDBContext extends DBContext {
    
    
    public ArrayList<Quiz> getQuizs(int CourseId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT  [Id]\n"
                + "      ,[Descripsion]\n"
                + "      ,[Duration]\n"
                + "      ,[Name]\n"
                + "      ,[PassRate]\n"
                + "      ,[CourseId]\n"
                + "      ,[QuizLevelId]\n"
                + "      ,[QuizTypeId]\n"
                + "  FROM  [Quiz] q\n"
                + "  where q.QuizTypeId =1 and q.CourseId=? ";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, CourseId);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<Quiz> Quizs = new ArrayList<>();
            while (rs.next()) {
                Quiz Quiz = new Quiz();
                Quiz.setId(rs.getInt("Id"));
                Quiz.setDescripsion(rs.getString("Descripsion"));
                Quiz.setDuration(rs.getInt("Duration"));
                Quiz.setName(rs.getString("Name"));
                Quiz.setPassRate(rs.getFloat("PassRate"));
                Course c = new Course();
                c.setCourseId(CourseId);
                Quiz.setCourse(c);
                Quiz.setQuizLevelId(rs.getInt("QuizLevelId"));
                Quizs.add(Quiz);
            }
            return Quizs;
        } catch (SQLException ex) {
        }
        return null;
    }
    public static void main(String[] args) {
        QuizDBContext a = new QuizDBContext();
        System.out.println(a.getQuizs(1));
    }
}
