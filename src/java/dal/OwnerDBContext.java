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

import model.User;

/**
 *
 * @author jicon
 */
public class OwnerDBContext extends DBContext {

    public ArrayList<User> getOwnerByCourseId(int id) {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = " SELECT [User].*\n"
                    + "FROM     Owner INNER JOIN\n"
                    + "                  [User] ON Owner.UserId = [User].Userid INNER JOIN\n"
                    + "                  Courses ON Owner.CourseId = Courses.CourseId\n"
                    + "				  where Courses.CourseId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u  = new User();
                u.setId(rs.getInt("Userid"));
                u.setFullName(rs.getString("fullname"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
