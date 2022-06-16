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
import model.PricePackage;
import model.Status;

/**
 *
 * @author thand
 */
public class PricePackageDBContext extends DBContext {

   public ArrayList<PricePackage> PricePackes(int CourseId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT  p.id,p.duration,\n"
                + "		p.list_price,\n"
                + "		p.name,\n"
                + "        p.sale_price,\n"
                + "		p.Status_id\n"
                + "  FROM [Price_Package] p inner join Course_package cp\n"
                + "	on cp.packageid=p.id\n"
                + "	inner join Courses c\n"
                + "	on c.CourseId=cp.courseid\n"
                + "where c.CourseId=? and p.Status_id = 1"
                + "ORDER BY p.sale_price asc";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, CourseId);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<PricePackage> PricePackages = new ArrayList<>();
            while (rs.next()) {
                PricePackage PricePackage = new PricePackage();
                PricePackage.setId(rs.getInt("id"));
                PricePackage.setDuration(rs.getInt("duration"));
                PricePackage.setListPrice(rs.getFloat("list_price"));
                PricePackage.setName(rs.getString("name"));
                PricePackage.setSalePrice(rs.getFloat("sale_price"));
                PricePackages.add(PricePackage);
            }
            return PricePackages;
        } catch (SQLException ex) {
            Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
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

    public PricePackage getPackage(int id) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT  [id]\n"
                + "      ,[duration]\n"
                + "      ,[list_price]\n"
                + "      ,[name]\n"
                + "      ,[sale_price]\n"
                + "      ,[Status_id]\n"
                + "  FROM [Price_Package]\n"
                + "  where id = ? and [Status_id] = 1";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeQuery();
            rs = stm.executeQuery();

            if (rs.next()) {
                PricePackage PricePackage = new PricePackage();
                PricePackage.setId(rs.getInt("id"));
                PricePackage.setDuration(rs.getInt("duration"));
                PricePackage.setListPrice(rs.getFloat("list_price"));
                PricePackage.setName(rs.getString("name"));
                PricePackage.setSalePrice(rs.getFloat("sale_price"));
                return PricePackage;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<PricePackage> getPricePackageByCourseList(int courseid) {
        ArrayList<PricePackage> coursePrices = new ArrayList<>();
        try {

            String sql = "SELECT Price_Package.*\n"
                    + "FROM     Course_package INNER JOIN\n"
                    + "                  Price_Package ON Course_package.packageid = Price_Package.id INNER JOIN\n"
                    + "                  Courses ON Course_package.courseid = Courses.CourseId\n"
                    + "				  where Courses.CourseId = ? and statusid = 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, courseid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PricePackage p = new PricePackage();
                p.setId(rs.getInt(1));
                p.setDuration(rs.getInt(2));
                p.setListPrice(rs.getFloat(3));
                p.setName(rs.getString(4));
                p.setSalePrice(rs.getFloat(5));
                
               
                
                coursePrices.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coursePrices;
    }
    public PricePackage getPriceByPriceId(int id) {
            try {

            String sql = "select * from Price_Package where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                PricePackage p = new PricePackage();
                p.setId(rs.getInt(1));
                p.setDuration(rs.getInt(2));
                p.setListPrice(rs.getFloat(3));
                p.setName(rs.getString(4));
                p.setSalePrice(rs.getFloat(5));
                
                return p;

            }
        } catch (SQLException ex) {
            Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /*tuan thanh
    16/06
    */
    public void updateStatusPricePackage(int id, int sid){
       try {
           String sql = "UPDATE [Price_Package]\n" +
                   " SET [Status_id] = ? \n" +
                   " WHERE id = ? ";
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setInt(1, sid);
           stm.setInt(2, id);
           stm.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
