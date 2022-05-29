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
import model.Status;
import model.User;

/**
 *
 * @author pv
 */
public class UserDBContext extends DBContext{
    public void test( int n){
    }
    public User getUserById(int id){        
        try { 
            String sql = "select Userid, fullname, email, gender, [password], phone, avatar_img, Statusid from [User]\n" +
                          " where Userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                //Take user by id
                User user = new User();
                user.setId(rs.getInt("Userid"));
                user.setFullName(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getBoolean("gender"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAvatarImage(rs.getString("avatar_img"));
                // Take status of this User 
                Status status = new Status();
                status.setId(rs.getInt("Statusid"));
                user.setStatus(status);
                return user; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public User getUser(String username, String password) {

        try {
            String sql = "SELECT * FROM [User] \n"
                    + "WHERE email = ? AND password = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("Userid"));
                user.setFullName(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getBoolean("gender"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAvatarImage(rs.getString("avatar_img"));
                // Take status of this User 
                Status status = new Status();
                status.setId(rs.getInt("Statusid"));
                user.setStatus(status);
                return user; 
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertUser(User s) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[displayName])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
        //    stm.setString(1, s.getId());
            stm.setString(2, s.getPassword());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void UpdateUser(User user){
        try {
            String sql = "UPDATE [User]\n" +
                    "   SET [fullname] = ?\n" +
                    "      ,[gender] = ?\n" +
                    "      ,[phone] = ?\n" +
                    "      ,[avatar_img] = ?\n" +
                    " WHERE Userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getFullName());
            stm.setBoolean(2, user.isGender());
            stm.setString(3, user.getPhone());
            stm.setString(4, user.getAvatarImage());
            stm.setInt(5, user.getId());
            stm.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
