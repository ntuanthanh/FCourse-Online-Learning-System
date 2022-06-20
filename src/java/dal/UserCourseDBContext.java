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
import model.User;
import model.UserCourse;

/**
 *
 * @author thand
 */
public class UserCourseDBContext extends DBContext {

    public ArrayList<UserCourse> getCoursesRegistraion(int userId,
            int Categoryid, String title, int pageindex, int pagesize) {
        ResultSet rs = null;
        PreparedStatement stm = null;
        String sql = "";
        if (Categoryid == 0) {
            sql = "select* from\n"
                    + "(select uc.usercourseId,\n"
                    + "                    uc.Courseid,\n"
                    + "                    uc.Startdate,\n"
                    + "                    uc.enddate,\n"
                    + "                    uc.price_packageid,\n"
                    + "                    uc.registration_status,\n"
                    + "					uc.Userid,\n"
                    + "					ROW_NUMBER() over (order by uc.CourseId asc ) as row_index\n"
                    + "                    from User_Course uc \n"
                    + "					inner join [User] u  on uc.Userid= u.Userid\n"
                    + "                    where u.Userid = ? \n"
                    + "					) u\n"
                    + "                    where row_index >= (" + pageindex + "-1)*" + pagesize + "+1 and row_index<= " + pageindex + "*" + pagesize + "\n"
                    + "                    order by u.registration_status asc, u.Startdate desc";
        } else {
            sql = "select * from \n"
                    + "(select a.usercourseId,\n"
                    + "        a.Courseid,\n"
                    + "        a.Startdate,\n"
                    + "        a.enddate,\n"
                    + "        a.price_packageid,\n"
                    + "        a.registration_status,\n"
                    + "        a.Userid,\n"
                    + "        cu.Categoryid,\n"
                    + "	       ROW_NUMBER() over (order by a.CourseId asc ) as row_index\n"
                    + "        from\n"
                    + "            (select uc.usercourseId,\n"
                    + "                    uc.Courseid,\n"
                    + "			   uc.Startdate,\n"
                    + "                    uc.enddate,\n"
                    + "                    uc.price_packageid,\n"
                    + "                    uc.registration_status,\n"
                    + "                    u.Userid\n"
                    + "                    from User_Course uc inner join [User] u \n"
                    + "                    on uc.Userid= u.Userid)\n"
                    + "                    a inner join Courses cu on cu.CourseId =a.Courseid\n"
                    + "                    where a.Userid=? and cu.Categoryid=?\n"
                    + "                    ) x\n"
                    + "                    where row_index >= (" + pageindex + "-1)*" + pagesize + "+1 and row_index<= " + pageindex + "*" + pagesize + "\n"
                    + "    order by x.registration_status asc, x.Startdate desc ";
        }
        if (title != null && title.trim().length() != 0) {
            sql = "select* from\n"
                    + "(select uc.usercourseId,\n"
                    + "                    uc.Courseid,\n"
                    + "                    uc.Startdate,\n"
                    + "                    uc.enddate,\n"
                    + "                    uc.price_packageid,\n"
                    + "                    uc.registration_status,\n"
                    + "					uc.Userid,\n"
                    + "					ROW_NUMBER() over (order by uc.CourseId asc ) as row_index\n"
                    + "                    from User_Course uc \n"
                    + "					inner join [User] u  on uc.Userid= u.Userid\n"
                    + "                    inner join Courses c on c.CourseId=uc.Courseid\n"
                    + "					where u.Userid = ? and c.title like ?\n"
                    + "					) u\n"
                    + "                    where row_index >= (" + pageindex + "-1)*" + pagesize + "+1 and row_index<= " + pageindex + "*" + pagesize + "\n"
                    + "                    order by u.registration_status asc, u.Startdate desc";
        }

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            if (Categoryid > 0) {
                stm.setInt(2, Categoryid);
            }
            if (title != null && title.trim().length() != 0) {
                String a = "%" + title + "%";
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

        }
        return null;
    }
    

    public UserCourse getUserCourseByUidCid(int userid, int courseid) {

        try {
            String sql = "select * from User_Course \n"
                    + "where Userid = ? and Courseid = ? order by registration_status";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);
            stm.setInt(2, courseid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserCourse uc = new UserCourse();

                Course c = new Course();
                User u = new User();
                PricePackage p = new PricePackage();
                uc.setUserCourseId(rs.getInt(1));
                u.setId(rs.getInt(2));
                uc.setUser(u);
                c.setCourseId(rs.getInt(3));
                uc.setCourse(c);
                uc.setStartDate(rs.getDate(4));
                uc.setEndDate(rs.getDate(5));
                p.setId(rs.getInt(6));

                uc.setPricePackage(p);
                uc.setRegistration_status(rs.getBoolean(7));
                return uc;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertUserCourse(UserCourse uc) {
        try {
            String sql = "INSERT INTO [dbo].[User_Course]\n"
                    + "           ([Userid]\n"
                    + "           ,[Courseid]\n"
                    + "           ,[Startdate]\n"
                    + "           ,[enddate]\n"
                    + "           ,[price_packageid]\n"
                    + "           ,[registration_status])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,'false')";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, uc.getUser().getId());
            stm.setInt(2, uc.getCourse().getCourseId());
            stm.setDate(3, uc.getStartDate());
            stm.setDate(4, uc.getEndDate());
            stm.setInt(5, uc.getPricePackage().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUserCourse(UserCourse uc) {
        try {
            String sql = "UPDATE [dbo].[User_Course]\n"
                    + "   SET \n"
                    + "         [Startdate] = ?\n"
                    + "      ,[enddate] = ?\n"
                    + "      ,[price_packageid] = ?\n"
                    + "      \n"
                    + " WHERE [Userid] = ? and [Courseid] = ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setDate(1, uc.getStartDate());
            stm.setDate(2, uc.getEndDate());
            stm.setInt(3, uc.getPricePackage().getId());
            stm.setInt(4, uc.getUser().getId());
            stm.setInt(5, uc.getCourse().getCourseId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
