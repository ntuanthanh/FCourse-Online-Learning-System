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
import model.Content;

/**
 *
 * @author tuann
 */
public class ContentDBContext extends DBContext{
    public ArrayList<Content> getcontents(String bid)
    {
        ArrayList<Content> contents = new ArrayList<>();
        try {
            
            String sql ="select id, bid, content from Content\n" +
                        "where bid = ? order by id asc";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, bid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Content c = new Content();
                c.setId(rs.getInt("id"));
                c.setBid(rs.getInt("bid"));
                c.setContent(rs.getString("content"));
                contents.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contents;
    }
    public static void main(String[] args){
        ContentDBContext a = new ContentDBContext();
        ArrayList<Content> b = a.getcontents("7");
        for(Content i: b){
            System.out.println(i);
        }
    }
}

