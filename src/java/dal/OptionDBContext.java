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
import model.Option;
import model.Question;
import model.Status;

/**
 *
 * @author jicon
 */
public class OptionDBContext extends DBContext {

    public ArrayList<Option> getOptionByQuestionId(int QestionId) {
        ArrayList<Option> options = new ArrayList<>();
        try {
            String sql = "select [Option].* from [Option] \n"
                    + "		inner join Question on Question.QuestionId = [Option].QuestionId\n"
                    + "		where [Option].QuestionId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, QestionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Option o = new Option();
                o.setId(rs.getInt(1));

                Question q = new Question();
                q.setId(rs.getInt(2));

                o.setContent(rs.getString(3));
                o.setCorrect(rs.getBoolean(4));
                o.setExplain(rs.getString(5));

                options.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return options;
    }

    public ArrayList<Integer> getIdOptionCorrect(int QuestionId) {
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            String sql = "SELECT OptionId, QuestionId, [content], correct, explain\n"
                    + "FROM     [Option] where QuestionId = ? and correct =1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, QuestionId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                ids.add(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ids;
    }
}
