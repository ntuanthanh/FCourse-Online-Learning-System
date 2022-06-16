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
import model.ParentCategory;

/**
 *
 * @author jicon
 */
public class ParentCategoryDBContext extends DBContext {

    public ArrayList<ParentCategory> getParentCategory() {
        ArrayList<ParentCategory> pas = new ArrayList<>();
        try {

            String sql = "select * from ParentCategory";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ParentCategory p = new ParentCategory();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                CategoryDBContext cdb = new CategoryDBContext();
         ArrayList<Category> c = cdb.getCategoryByParent(rs.getInt("id"));
              p.setCategories(c);
                pas.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParentCategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pas;
    }
    public static void main(String[] args) {
        ParentCategoryDBContext a = new ParentCategoryDBContext();
        ArrayList<ParentCategory> as = a.getParentCategory();
        for(int i=0;i<as.size();i++){
            System.out.println( as.get(i).getId() + "|" +  as.get(i).getName());
        }
    }
}
