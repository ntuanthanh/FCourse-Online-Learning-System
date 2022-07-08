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
import model.Course;
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
                    + "				  where Courses.CourseId = ? and status_id = 1";
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
    /*
      tuanthanh
      18/06
    */
    public ArrayList<PricePackage> getPricePackgeByCoursePaging(int cid, int pageIndex, int pageSize){
        ArrayList<PricePackage> pricepackages = new ArrayList<>();
        try {
           String sql = "select * from ( select ROW_NUMBER() OVER(order by packageid asc) as row_index, * from Course_package as cp INNER JOIN Price_Package as p on cp.packageid = p.id \n" +
                   "              INNER JOIN [Status] as s on p.Status_id = s.Sid  where courseid = ? ) as tbl \n" +
                   "  where row_index >= ( ? - 1 ) * ? + 1 and row_index <= ? * ? ";
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setInt(1, cid);
           stm.setInt(2, pageIndex);
           stm.setInt(3, pageSize);
           stm.setInt(4, pageSize);
           stm.setInt(5, pageIndex);
           ResultSet rs_sql_Packages = stm.executeQuery();
           while (rs_sql_Packages.next()) {
               PricePackage pricepackage = new PricePackage();
               pricepackage.setId(rs_sql_Packages.getInt("id"));
               pricepackage.setDuration(rs_sql_Packages.getInt("duration"));
               pricepackage.setListPrice(rs_sql_Packages.getFloat("list_price"));
               pricepackage.setName(rs_sql_Packages.getString("name"));
               pricepackage.setSalePrice(rs_sql_Packages.getFloat("sale_price"));
               // add status for this pricePackage 
               Status status_pricePackage = new Status();
               status_pricePackage.setId(rs_sql_Packages.getInt("Sid"));
               status_pricePackage.setName(rs_sql_Packages.getString("Sname"));
               pricepackage.setStatus(status_pricePackage);
               pricepackages.add(pricepackage);
           }
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
        return pricepackages;
    }
    public int CountGetPricePackgeByCoursePaging(int cid){
           try {
            String sql = "select Count(*) as Total from ( select ROW_NUMBER() OVER(order by packageid asc) as row_index, * from Course_package as cp INNER JOIN Price_Package as p on cp.packageid = p.id \n"
                    + "              INNER JOIN [Status] as s on p.Status_id = s.Sid  where courseid = ? ) as tb ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs_sql_Packages = stm.executeQuery();
            while (rs_sql_Packages.next()) {
                return rs_sql_Packages.getInt("Total"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
      return -1;
    }
    /*
      tuanthanh
      26/06
    */
    public void DeletePricePackageByCourse(int cid, int pid){
       try {
           String sql = "DELETE FROM [Course_package]\n" +
                   " WHERE courseid = ? and packageid = ? ";
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setInt(1, cid);
           stm.setInt(2, pid);
           stm.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    /*
      tuanthanh
      26/06
    */
    public PricePackage getPricePackageById(int pid){
        try {
           String sql = "select p.id, duration, list_price, [name], sale_price, Status_id, Sname from Price_Package as p \n" +
                        "         INNER JOIN [Status] as s on p.Status_id = s.[Sid]\n" +
                        "where p.id = ? ";
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setInt(1, pid);
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
              PricePackage p = new PricePackage();
              p.setId(rs.getInt("id"));
              p.setDuration(rs.getInt("duration"));
              p.setListPrice(rs.getFloat("list_price"));
              p.setName(rs.getString("name"));
              p.setSalePrice(rs.getFloat("sale_price"));
              Status s = new Status();
              s.setId(rs.getInt("status_id"));
              s.setName(rs.getString("sname"));
              p.setStatus(s);
              return p;
           }
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }
    /*
      tuanthanh
      26/06
    */
    public void UpdatePricePackage(PricePackage p){
       try {
           String sql = "UPDATE [Price_Package]\n" +
                   "   SET [duration] = ?\n" +
                   "      ,[list_price] = ?\n" +
                   "      ,[name] = ?\n" +
                   "      ,[sale_price] = ?\n" +
                   "      ,[Status_id] = ?\n" +
                   " WHERE id = ? "; 
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setInt(1, p.getDuration());
           stm.setFloat(2, p.getListPrice());
           stm.setString(3, p.getName());
           stm.setFloat(4, p.getSalePrice());
           stm.setInt(5, p.getStatus().getId());
           stm.setInt(6, p.getId());
           stm.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }  
    }
    /*
      tuanthanh
      27/06
    */
    public ArrayList<PricePackage> seachPricePackageByName(String txtSearch){
        ArrayList<PricePackage> pricePackages = new ArrayList<PricePackage>();
        try {
           if(txtSearch.trim().equals("")){
                txtSearch = "-1";
            }
           if(txtSearch.trim().equalsIgnoreCase("all")){
                txtSearch = "";
            }
           String sql = "select * from Price_Package where [name] like '%' + ? + '%' or duration like '%' + ? + '%'";
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setString(1, txtSearch);
           stm.setString(2, txtSearch);
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
              PricePackage p = new PricePackage();
              p.setId(rs.getInt("id"));
              p.setDuration(rs.getInt("duration"));
              p.setListPrice(rs.getFloat("list_price"));
              p.setName(rs.getString("name"));
              p.setSalePrice(rs.getFloat("sale_price"));
              Status s = new Status();
              s.setId(rs.getInt("status_id"));
              p.setStatus(s);
              pricePackages.add(p);
           }
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
        return pricePackages;
    }
    /*
      tuanthanh
      28/06
    */
    public ArrayList<PricePackage> getPricePackagesByCid(int cid){
        ArrayList<PricePackage> pricepackages = new ArrayList<>();
        try {
           String sql = "select * from Course_package as cp INNER JOIN Price_Package as p on cp.packageid = p.id\n" +
                   "INNER JOIN [Status] as s on p.Status_id = s.[Sid] where cp.courseid = ? ";
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setInt(1, cid);
           ResultSet rs_sql_Packages = stm.executeQuery();
           while(rs_sql_Packages.next()){
              PricePackage pricepackage = new PricePackage();
               pricepackage.setId(rs_sql_Packages.getInt("id"));
               pricepackage.setDuration(rs_sql_Packages.getInt("duration"));
               pricepackage.setListPrice(rs_sql_Packages.getFloat("list_price"));
               pricepackage.setName(rs_sql_Packages.getString("name"));
               pricepackage.setSalePrice(rs_sql_Packages.getFloat("sale_price"));
               // add status for this pricePackage 
               Status status_pricePackage = new Status();
               status_pricePackage.setId(rs_sql_Packages.getInt("Sid"));
               status_pricePackage.setName(rs_sql_Packages.getString("Sname"));
               pricepackage.setStatus(status_pricePackage);
               pricepackages.add(pricepackage);
           }
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
        return pricepackages;
    }
    public void updatePricePackageByCid(Course course){
       try {
           // frist delete
           String sql_delete = "DELETE FROM [Course_package]\n" +
                                " WHERE courseid = ? ";
           // update second 
           String sql_update = "INSERT INTO [Course_package]\n" +
                                "           ([courseid]\n" +
                                "           ,[packageid])\n" +
                                "     VALUES\n" +
                                "           (? \n" +
                                "           ,? )";
           connection.setAutoCommit(false);
           PreparedStatement stm = connection.prepareStatement(sql_delete);       
           stm.setInt(1, course.getCourseId());
           stm.executeUpdate();
           // after delete to update 
           stm = connection.prepareStatement(sql_update);
           for (PricePackage p : course.getPricePackage()) {
               stm.setInt(1, course.getCourseId());
               stm.setInt(2, p.getId());
               stm.executeUpdate();
           }
           connection.commit();
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }      
    }
    public void AddPricePackageToSystem(PricePackage p){
       try {
           String sql = "INSERT INTO [Price_Package]\n" +
                   "           ([duration]\n" +
                   "           ,[list_price]\n" +
                   "           ,[name]\n" +
                   "           ,[sale_price]\n" +
                   "           ,[Status_id])\n" +
                   "     VALUES\n" +
                   "           (?\n" +
                   "           ,?\n" +
                   "           ,?\n" +
                   "           ,?\n" +
                   "           ,?)";
           PreparedStatement stm = connection.prepareStatement(sql);
           stm.setInt(1, p.getDuration());
           stm.setFloat(2, p.getListPrice());
           stm.setString(3, p.getName());
           stm.setFloat(4, p.getSalePrice());
           stm.setInt(5, p.getStatus().getId());
           stm.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(PricePackageDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }      
    }
}
