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
    
    
    
}
