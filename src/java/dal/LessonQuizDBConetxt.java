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
import model.LessonQuiz;

/**
 *
 * @author thand
 */
public class LessonQuizDBConetxt extends DBContext {

    public void deleteLessonQuiz(int Lid, int Qid) {
        try {
            String sql = "DELETE FROM [LessonQuiz]\n" +
"      WHERE [LessonQuiz].LessonId = ? and [LessonQuiz].Qid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Lid);
            stm.setInt(2, Qid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertLessonQuiz(int Lid, int Qid) {
        try {
            String sql = "INSERT INTO [LessonQuiz]\n"
                    + "           ([LessonId]\n"
                    + "           ,[Qid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Lid);
            stm.setInt(2, Qid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<LessonQuiz> getLessonQuizs(int LId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT [LessonId]\n"
                + "      ,[Qid]\n"
                + "  FROM [LessonQuiz]\n"
                + "  where [LessonId] = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, LId);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<LessonQuiz> LessonQuizs = new ArrayList<>();
            while (rs.next()) {
                LessonQuiz lq = new LessonQuiz();
                lq.setLessonId(rs.getInt("LessonId"));
                lq.setQid(rs.getInt("Qid"));
                LessonQuizs.add(lq);
            }
            return LessonQuizs;
        } catch (SQLException ex) {
        }
        return null;
    }
}
