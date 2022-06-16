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
import model.QuizLevel;

/**
 *
 * @author ADMIN
 */
public class QuizLevelDBContext extends DBContext{
    public ArrayList<QuizLevel> getListQuizLevels() {
        ArrayList<QuizLevel> QuizLevels = new ArrayList<>();
        try {
            String sql = "SELECT QuizLevel.*\n"
                    + "FROM     QuizLevel ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                QuizLevel t = new QuizLevel();
                t.setId(rs.getInt(1));
                t.setLevelName(rs.getString(2));
                QuizLevels.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizLevelDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QuizLevels;
    }
}
