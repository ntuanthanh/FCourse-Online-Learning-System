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

/**
 *
 * @author pv
 */
public class StatusDBContext extends DBContext{
    public ArrayList<Status> getAllStatuses(){
        ArrayList<Status> statuses = new ArrayList<>();
        try {
            String sql = "select [Sid], Sname from [Status]";
            PreparedStatement stm = connection.prepareStatement(sql); 
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Status status = new Status(); 
                status.setId(rs.getInt("Sid"));
                status.setName(rs.getString("Sname"));
                statuses.add(status);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }
    public Status getStatus(int sid)
    {
        
        try {
            
            String sql ="select sid, sname from status where sid=?\n" ;
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Status s = new Status();
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatusDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
