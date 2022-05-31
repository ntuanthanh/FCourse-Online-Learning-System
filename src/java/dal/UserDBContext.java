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
    /*
     * get user by id
     * tuan thanh
    */
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
    /*
     * Check email exist in database
     * tuan thanh
    */
    public boolean CheckEmailExist(String email){
        try {
            String sql = "select * from [User] where email like ?"; 
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs =  stm.executeQuery(); 
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /*
     * Check reset_token exist in database
     * tuan thanh
    */
    public boolean CheckResetToken(String tempResetToken){
        try {
            String sql = "select * from [User] where ResetToken like ?"; 
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, tempResetToken);
            ResultSet rs =  stm.executeQuery(); 
            while(rs.next()){
               return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    /*
     * Update reset_token and createTime
     * tuan thanh
    */
    public void CreateReset_token(String email, String resetToken){
        try {
            String sql = "UPDATE [User]\n" +
                    "   SET [ResetToken] = ? \n" +
                    "      ,[CreateTimeResetToken] = GETDATE()\n" +
                    " WHERE email = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, resetToken);
            stm.setString(2, email);
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
     * get User by Reset token
     * tuan thanh
    */
    public User GetUserByToken(String resetToken){
        try {
            String sql = "select * from [User] where ResetToken = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, resetToken);
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
                user.setResetToken(rs.getString("ResetToken"));
                user.setCreateTimeResetToken(rs.getString("CreateTimeResetToken"));
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
    /*
      reset password
      tuanthanh
     */
    public void resetPassword(String resetToken, String newPassword){
        try {
            String sql = "UPDATE [User]\n" +
                        "   SET \n" +
                        "      [password] = CONVERT(VARCHAR(32), HashBytes('MD5', '"+newPassword+"' ), 2)\n" +
                        "      ,[ResetToken] = null\n" +
                        "      ,[CreateTimeResetToken] = null\n" +
                        " WHERE [ResetToken] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, resetToken);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
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
