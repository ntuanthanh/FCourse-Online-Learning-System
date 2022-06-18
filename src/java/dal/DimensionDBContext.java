/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dimension;
import model.Dimension;
import model.DimensionType;

/**
 *
 * @author ADMIN
 */
public class DimensionDBContext extends DBContext {

    public ArrayList<Dimension> getDimensions() {
        ArrayList<Dimension> Dimensiones = new ArrayList<>();
        try {
            String sql = "SELECT [Did]\n"
                    + "      ,[name]\n"
                    + "      ,[typeID]\n"
                    + "      ,[dicription]\n"
                    + "  FROM [dbo].[Dimension]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Dimension Dimension = new Dimension();
                Dimension.setId(rs.getInt("Did"));
                Dimension.setName(rs.getString("name"));
                DimensionType d = new DimensionType();
                d.setId(rs.getInt("typeID"));
                Dimension.setDimensionType(d);
                Dimension.setDescription(rs.getString("dicription"));
                Dimensiones.add(Dimension);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DimensionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Dimensiones;
    }
    
    public Dimension getDimensionById(int did) {
//        ArrayList<Dimension> Dimensiones = new ArrayList<>();
        try {
            String sql = "SELECT [Did]\n"
                    + "      ,[name]\n"
                    + "      ,[typeID]\n"
                    + "      ,[dicription]\n"
                    + "  FROM [dbo].[Dimension] where did = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, did);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Dimension Dimension = new Dimension();
                Dimension.setId(rs.getInt("Did"));
                Dimension.setName(rs.getString("name"));
                DimensionType d = new DimensionType();
                d.setId(rs.getInt("typeID"));
                Dimension.setDimensionType(d);
                Dimension.setDescription(rs.getString("dicription"));
                return Dimension;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DimensionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /*
       tuanthanh 
       19/06/2022
    */
    public ArrayList<Dimension> getDimenstionByCoursePaging(int cid, int pageIndex, int pageSize){
        ArrayList<Dimension> dimensions = new ArrayList<>();
        try {
            String sql = "select * from (select ROW_NUMBER() OVER(order by dimensionid asc) as row_index, dimensionid, did, d.[name] as dname, dicription, dt.TypeId, dt.[name] as dtname  from Course_dimension as cd "
                    + "      INNER JOIN Dimension as d on cd.dimensionid = d.Did\n" +
                    "      INNER JOIN DimensionType as dt on dt.TypeId = d.typeID\n" +
                    "      where Courseid = ? ) as tb where row_index >= ( ? - 1 ) * ? + 1 and row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setInt(2, pageIndex);
            stm.setInt(3, pageSize);
            stm.setInt(4, pageSize);
            stm.setInt(5, pageIndex);
            ResultSet rs_sql_dimension = stm.executeQuery();
            while(rs_sql_dimension.next()){
                   Dimension dimension = new Dimension();
                   dimension.setId(rs_sql_dimension.getInt("did"));
                   dimension.setName(rs_sql_dimension.getString("dname"));
                   dimension.setDescription(rs_sql_dimension.getString("dicription"));
                   DimensionType dimensionType = new DimensionType();
                   dimensionType.setId(rs_sql_dimension.getInt("TypeId"));
                   dimensionType.setName(rs_sql_dimension.getString("dtname"));
                   dimension.setDimensionType(dimensionType);
                   dimensions.add(dimension);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DimensionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
     return dimensions; 
    }
    public int CountGetDimensionCoursePaging(int cid){
        ArrayList<Dimension> dimensions = new ArrayList<>();
        try {
            String sql = "select Count(*) as Total from (select ROW_NUMBER() OVER(order by dimensionid asc) as row_index, dimensionid, did, d.[name] as dname, dicription, dt.TypeId, dt.[name] as dtname  from Course_dimension as cd "
                    + "      INNER JOIN Dimension as d on cd.dimensionid = d.Did\n" +
                    "      INNER JOIN DimensionType as dt on dt.TypeId = d.typeID\n" +
                    "      where Courseid = ? ) as tb " ;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs_sql_dimension = stm.executeQuery();
            while(rs_sql_dimension.next()){
                return rs_sql_dimension.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DimensionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
     return -1; 
    }
    
}
