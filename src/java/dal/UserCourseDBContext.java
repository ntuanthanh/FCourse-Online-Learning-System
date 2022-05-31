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
import model.UserCourse;

/**
 *
 * @author thand
 */
public class UserCourseDBContext extends DBContext {

    public ArrayList<UserCourse> getCoursesRegistraion(int userId) {
        ResultSet rs = null;
        PreparedStatement stm = null;
        String sql = "select uc.usercourseId,\n"
                + "		uc.Courseid,\n"
                + "		uc.Startdate,\n"
                + "		uc.enddate,\n"
                + "		uc.price_packageid,\n"
                + "		uc.registration_status\n"
                + "from User_Course uc inner join [User] u \n"
                + "			on uc.Userid= u.Userid\n"
                + "where u.Userid =? \n"
                + "order by uc.registration_status asc, uc.Startdate desc";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<UserCourse> userCourses = new ArrayList<>();
            while (rs.next()) {
                UserCourse uc = new UserCourse();
                uc.setUserCourseId(rs.getInt("usercourseId"));
                CourseDBContext cdbc = new CourseDBContext();
                Course Course = cdbc.getCourseDetail(rs.getInt("Courseid"));
                uc.setCourse(Course);
                uc.setStartDate(rs.getDate("Startdate"));
                uc.setEndDate(rs.getDate("enddate"));
                uc.setRegistration_status(rs.getBoolean("registration_status"));
                PricePackageDBContext ppdbc = new PricePackageDBContext();
                PricePackage pk = ppdbc.getPackage(rs.getInt("price_packageid"));
                uc.setPricePackage(pk);
                userCourses.add(uc);
            }
            return userCourses;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
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

    public static void main(String[] args) {
        UserCourseDBContext a = new UserCourseDBContext();
        int x = a.getCoursesRegistraion(1).size();
        System.out.println(x);
    }
}
