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
import model.Tag;

/**
 *
 * @author jicon
 */
public class TagDBContext extends DBContext {
    public ArrayList<Tag> getTags(int courseId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT ct.tagId, t.tagname FROM \n"
                + "	[courseTag] ct inner join Tag t on ct.tagId=t.tagId\n"
                + "  where ct.courseId =?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, courseId);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<Tag> Tags = new ArrayList<>();
            while (rs.next()) {
                Tag t = new Tag();
                t.setTagId(rs.getInt("tagId"));
                t.setTagname(rs.getString("tagname"));
                Tags.add(t);
            }
            return Tags;
        } catch (SQLException ex) {
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Tag> getListTags() {
        ArrayList<Tag> tags = new ArrayList<>();
        try {
            String sql = "SELECT Tag.*\n"
                    + "FROM     Tag";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tag t = new Tag();
                t.setTagId(rs.getInt(1));
                t.setTagname(rs.getString(2));
                tags.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tags;
    }

    public ArrayList<Tag> getTagsByCourse(int cid) {
        ArrayList<Tag> tags = new ArrayList<>();
        try {
            String sql = "SELECT Tag.tagId, Tag.tagname\n"
                    + "FROM     Tag INNER JOIN\n"
                    + "                  courseTag ON Tag.tagId = courseTag.tagId where courseTag.courseId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tag t = new Tag();
                t.setTagId(rs.getInt(1));
                t.setTagname(rs.getString(2));
                tags.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TagDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tags;
    }
    public static void main(String[] args) {
        TagDBContext t = new TagDBContext();
        System.out.println(t.getTags(1).get(0).getTagname());
    }
}
