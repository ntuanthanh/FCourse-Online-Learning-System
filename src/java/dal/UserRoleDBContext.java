/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thand
 */
public class UserRoleDBContext extends DBContext {

    public void insertUR(int userId, int RoleId) {
        String sql = "INSERT INTO [dbo].[User_Role]\n"
                + "           ([Userid]\n"
                + "           ,[Rid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, RoleId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserRoleDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
