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
import model.Topic;

/**
 *
 * @author thand
 */
public class TopicDBContext extends DBContext {

    public ArrayList<Topic> getTopics(int CourseId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT [Id]\n"
                + "      ,[TopicOrder]\n"
                + "      ,[TopicName]\n"
                + "      ,[CourseId]\n"
                + "      ,[description]\n"
                + "  FROM [Topic]\n"
                + "  where [CourseId]=?\n"
                + "  order by [TopicOrder] asc";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, CourseId);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<Topic> Topics = new ArrayList<>();
            while (rs.next()) {
                Topic Topic = new Topic();
                Topic.setId(rs.getInt("Id"));
                Topic.setTopicOrder(rs.getInt("TopicOrder"));
                Topic.setTopicName(rs.getString("TopicName"));
                Topic.setDescription(rs.getString("description"));
                Topics.add(Topic);
            }
            return Topics;
        } catch (SQLException ex) {
            Logger.getLogger(TopicDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
        return null;
    }
    public static void main(String[] args) {
        TopicDBContext t = new TopicDBContext();
        ArrayList<Topic> Topics = t.getTopics(1);
        for (Topic x : Topics) {
            System.out.println(x.getTopicOrder());
        }
    }
}
