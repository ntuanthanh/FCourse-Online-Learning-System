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
                Quiz.setDescription(rs.getString("Descripsion"));
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
    /*
       Thuận inter 3 4:40
    */
    public Quiz getQuizByQuizIDForQ(int id){
        try {
            String sql = "select * from Quiz inner join QuizType "
                    + "\n on QuizType.Id = Quiz.QuizTypeId where Quiz.Id  = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Quiz q = new Quiz();
                q.setId(rs.getInt("Id"));
                q.setDescription(rs.getString("Descripsion"));
                q.setDuration(rs.getInt("Duration"));
                q.setName(rs.getString("Name"));
                return q;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
