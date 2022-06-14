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
            String sql = "select * from [User]\n" +
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
                user.setDob(rs.getDate("dob"));
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
    /*
      13/6/2022
      search user by email and name 
    */
    public ArrayList<User> seachUserByEmailName(String txtSearch){
        ArrayList<User> users = new ArrayList<>();
        try {
            if(txtSearch.trim().equals("")){
                txtSearch = "-1";
            }
            String sql = "select * from [User] where email like '%' + ? + '%' or fullname like '%' + ? + '%' ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, txtSearch);
            stm.setString(2, txtSearch);
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
                users.add(user); 
            }          
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public User getUser(String username, String password) {

        try {
            String sql = "SELECT * FROM [User] \n"
                    + "where email = ? \n"
                    + "and password = CONVERT(VARCHAR(32), HashBytes('MD5', '"+ password+"'), 2)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
          //  stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("Userid"));
                user.setFullName(rs.getString("fullname"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getBoolean("gender"));
                user.setPassword(password);
                user.setPhone(rs.getString("phone"));
                user.setAvatarImage(rs.getString("avatar_img"));
                // add dob in database ( fix 6/7/2022) 
                user.setDob(rs.getDate("dob"));
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

    public int insertUser(User s) {
        int cid = 0;
        try {
            String sql = "INSERT INTO [User]\n" +
                        "           ([fullname]\n" +
                        "           ,[email]\n" +
                        "           ,[gender]\n" +
                        "           ,[password]\n" +
                        "           ,[phone]\n" +
                        "           ,[avatar_img]\n" +
                        "           ,[Statusid] )\n" +
                        "     VALUES\n" +
                        "           (?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,CONVERT(VARCHAR(32), HashBytes('MD5', '" + s.getPassword() + "'), 2)\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,2)";
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setNString(1, s.getFullName());
            stm.setString(2, s.getEmail());
            stm.setBoolean(3, s.isGender());;
            stm.setString(4, s.getPhone());
            stm.setString(5, s.getAvatarImage());
            stm.executeUpdate();

            String sql_get_id = "select @@IDENTITY as Userid";
            PreparedStatement stm_get_id = connection.prepareStatement(sql_get_id);

            ResultSet rs = stm_get_id.executeQuery();
            if (rs.next()) {
                cid = rs.getInt("Userid");
            }
             connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                return cid;
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    public void UpdateUser(User user){
        try {
            String sql = "UPDATE [User]\n" +
                    "   SET [fullname] = ?\n" +
                    "      ,[gender] = ?\n" +
                    "      ,[phone] = ?\n" +
                    "      ,[avatar_img] = ?\n" +
                    "      ,[dob] = ? \n" +
                    " WHERE Userid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getFullName());
            stm.setBoolean(2, user.isGender());
            stm.setString(3, user.getPhone());
            stm.setString(4, user.getAvatarImage());
            stm.setDate(5, user.getDob());
            stm.setInt(6, user.getId());
            stm.executeUpdate();
            } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<User> getListUser() {

        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT email,password FROM [User] \n";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User a = new User();
                a.setEmail(rs.getString("email"));
                a.setPassword(rs.getString("password"));

                users.add(a);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    // ktra mail ton tai
    public boolean checkExistEmail(String email) {
        ArrayList<User> users = getListUser();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
     // ktra tk ton tai
    public boolean checkExistUser(String email, String password) {
        ArrayList<User> users = getListUser();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
     public void changePassword(String email, String password) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET password = CONVERT(VARCHAR(32), HashBytes('MD5', '" + password + "'), 2)     \n"
                + " WHERE email = ? ";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, email);
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
     public void updateStatus(int id) {
        String sql = " UPDATE [dbo].[User]    \n"
                + "SET Statusid = 1 \n"
                + "WHERE  Userid = ? ";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
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
     
}
