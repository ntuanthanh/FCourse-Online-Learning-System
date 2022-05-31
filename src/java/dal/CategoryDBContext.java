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
import model.Category;
import model.Course;
import model.Status;

/**
 *
 * @author thand
 */
public class CategoryDBContext extends DBContext {

    public ArrayList<Category>  getCategorys() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT [Categoryid]\n"
                + "      ,[value]\n"
                + "  FROM [Category]";
        try {
            stm = connection.prepareStatement(sql);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<Category> categorys = new ArrayList<>();
            while (rs.next()) {
                Category Category = new Category();
                Category.setCategoryID(rs.getInt("Categoryid"));
                Category.setValue(rs.getString("value"));
                categorys.add(Category);
            }
            return categorys;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> cates = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt(1));
                c.setValue(rs.getString(2));
                cates.add(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cates;
    }
    public ArrayList<Category> getCategories()
    {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            
            String sql ="select Categoryid, value from category ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Category c = new Category();
                c.setCategoryID(rs.getInt("Categoryid"));
                c.setValue(rs.getString("value"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }
}
