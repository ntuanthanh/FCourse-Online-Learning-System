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

  public ArrayList<UserCourse> getCoursesRegistraion(int userId, int Categoryid, String title) {
        ResultSet rs = null;
        PreparedStatement stm = null;
        String sql = "";
        if (Categoryid == 0) {
            sql = "select uc.usercourseId,\n"
                    + "		uc.Courseid,\n"
                    + "		uc.Startdate,\n"
                    + "		uc.enddate,\n"
                    + "		uc.price_packageid,\n"
                    + "		uc.registration_status\n"
                    + "from User_Course uc inner join [User] u \n"
                    + "			on uc.Userid= u.Userid\n"
                    + "where u.Userid =? \n"
                    + "order by uc.registration_status asc, uc.Startdate desc";
        } else {
            sql = "select a.usercourseId,\n"
                    + "	a.Courseid,\n"
                    + "	a.Startdate,\n"
                    + "	a.enddate,\n"
                    + "	a.price_packageid,\n"
                    + "	a.registration_status,\n"
                    + "	a.Userid,\n"
                    + "	cu.Categoryid\n"
                    + "	from\n"
                    + "	(select uc.usercourseId,\n"
                    + "	uc.Courseid,\n"
                    + "	uc.Startdate,\n"
                    + "	uc.enddate,\n"
                    + "	uc.price_packageid,\n"
                    + "	uc.registration_status,\n"
                    + "	u.Userid\n"
                    + "	from User_Course uc inner join [User] u \n"
                    + "	on uc.Userid= u.Userid)\n"
                    + "	a inner join Courses cu on cu.CourseId =a.Courseid\n"
                    + "where a.Userid=? and cu.Categoryid=?\n"
                    + "order by a.registration_status asc, a.Startdate desc";
        }
        if (title != null && title.trim().length() != 0 ) {
            sql = "select uc.usercourseId,\n"
                    + "uc.Courseid,\n"
                    + "uc.Startdate,\n"
                    + "uc.enddate,\n"
                    + "uc.price_packageid,\n"
                    + "uc.registration_status\n"
                    + "from User_Course uc inner join [User] u \n"
                    + "on uc.Userid= u.Userid\n"
                    + "inner join Courses c on c.CourseId=uc.Courseid\n"
                    + "\n"
                    + "where u.Userid = ? and c.title like ?\n"
                    + "order by uc.registration_status asc, uc.Startdate desc";
        }

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            if (Categoryid > 0) {
                stm.setInt(2, Categoryid);
            }
            if(title != null && title.trim().length() != 0){
                String a = "%"+ title+"%";
                stm.setString(2, a);
            }
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


}
