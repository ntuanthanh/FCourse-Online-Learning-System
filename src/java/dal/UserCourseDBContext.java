/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.PricePackage;
import model.Status;
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
                // 
                Status s = new Status();
                s.setId(rs.getInt("registration_status"));
                uc.setRegistration_status(s); // Vì sửa bảng status từ boolean sang Status ( code của ai k biết - người sửa Thành ( 30/6/2022 ) 
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
                Status s = new Status();
                s.setId(rs.getInt("registration_status"));
                uc.setRegistration_status(s);  // Vì sửa bảng status từ boolean sang Status ( code của ai k biết - người sửa Thành ( 30/6/2022 ) 
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
    
    /*
      Tuanthanh 28/06/2022
    */
    public ArrayList<UserCourse> advancedSearchRegistration(int sort, String title, Date registrationFrom,Date registrationTo, int status, String Email, int pageIndex, int pageSize ){
        ArrayList<UserCourse> usercourses = new ArrayList<>();
        try {
            String sql = "select * from ( select uc.usercourseId, u.Userid, u.fullname, u.email, uc.Courseid, c.title, uc.Startdate, uc.enddate, uc.price_packageid, p.[name] as pname, p.sale_price as totalCost , uc.registration_status, s.Sname, \n" +
                    "	    updateBy.Userid as updateById, updateBy.fullname as updateByFullName, updateBy.email as updateByEmail ,";
            switch (sort) {
                case 0:
                    sql += " ROW_NUMBER() OVER(order by uc.usercourseId asc) as row_index ";
                    break;
                case 1:
                    sql += " ROW_NUMBER() OVER(order by uc.usercourseId desc) as row_index ";
                    break;
                    // email : 
                case 2:
                    sql += " ROW_NUMBER() OVER(order by u.email asc) as row_index ";
                    break;
                case 3:
                    sql += " ROW_NUMBER() OVER(order by u.email desc) as row_index ";
                    break;
                    // registration time : 
                case 4:
                    sql += " ROW_NUMBER() OVER(order by uc.Startdate asc) as row_index ";
                    break;
                case 5:
                    sql += " ROW_NUMBER() OVER(order by uc.Startdate desc) as row_index ";
                    break;
                    // subject ( sort theo title ) 
                case 6:
                    sql += " ROW_NUMBER() OVER(order by c.title asc) as row_index ";
                    break;
                case 7:
                    sql += " ROW_NUMBER() OVER(order by c.title desc) as row_index ";
                    break;
                    //  ( sort theo package ) 
                case 8:
                    sql += " ROW_NUMBER() OVER(order by p.[name] asc) as row_index ";
                    break;
                case 9:
                    sql += " ROW_NUMBER() OVER(order by p.[name] desc) as row_index ";
                    break;
                    // total cost
                case 10:
                    sql += " ROW_NUMBER() OVER(order by p.sale_price asc) as row_index ";
                    break;
                case 11:
                    sql += " ROW_NUMBER() OVER(order by p.sale_price desc) as row_index ";
                    break;
                    // valid to ( bỏ qua valid from ) 
                case 12:
                    sql += " ROW_NUMBER() OVER(order by s.sname asc) as row_index ";
                    break;
                case 13:
                    sql += " ROW_NUMBER() OVER(order by s.sname desc) as row_index ";
                    break; 
                default:
                    break;              
            }
            sql += " from User_Course as uc \n" +
                    "                    INNER JOIN [User] as u on uc.Userid = u.Userid\n" +
                    "                    INNER JOIN Courses as c on uc.Courseid = c.CourseId\n" +
                    "	             INNER JOIN Price_Package as p on uc.price_packageid = p.id\n" +
                    "		     INNER JOIN [User] as updateBy on uc.UpdateBy = updateBy.Userid\n" +
                    "                INNER JOIN  [Status] as s on uc.registration_status = s.[Sid] \n"+
                    "	             And (1=1) ";
            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 0;
            if (title != null) {
                sql += "And c.title like '%' + ? + '%' ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = title;
                parameters.put(paramIndex, param);
            }
            if (Email != null) {
                sql += "And u.email like '%' + ? + '%' ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = Email;
                parameters.put(paramIndex, param);
            }
            if (status != -1) {
                sql += "And uc.registration_status = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = status;
                parameters.put(paramIndex, param);
            }
            
            if (registrationFrom != null) {
                sql += "And uc.Startdate >= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = registrationFrom;
                parameters.put(paramIndex, param);
            }
            if (registrationTo != null) {
                sql += "And uc.Startdate <= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = registrationTo;
                parameters.put(paramIndex, param);
            }
            sql += ") as tbl where row_index >= ( ? - 1 ) * ? + 1 and row_index <= ? * ?";
            // dấu hỏi số 1 của where row_index >= ....
            paramIndex++;
            Object[] param = new Object[2];
            param[0] = Integer.class.getTypeName();
            param[1] = pageIndex; 
            parameters.put(paramIndex, param);
            // dấu hỏi số 2 của where row_index >= ....
            paramIndex++;
            param = new Object[2];
            param[0] = Integer.class.getTypeName();
            param[1] = pageSize; 
            parameters.put(paramIndex, param);
            // dấu hỏi số 3 của where row_index >= ....
            paramIndex++;
            param = new Object[2];
            param[0] = Integer.class.getTypeName();
            param[1] = pageSize; 
            parameters.put(paramIndex, param);
            // dấu hỏi số 4 của where row_index >= ....
            paramIndex++;
            param = new Object[2];
            param[0] = Integer.class.getTypeName();
            param[1] = pageIndex; 
            parameters.put(paramIndex, param);
            PreparedStatement stm = connection.prepareStatement(sql); 
             //parameters
            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if(type.equals(Integer.class.getName()))
                {
                    stm.setInt(index, Integer.parseInt(value[1].toString()));
                }
                else if (type.equals(String.class.getName()))
                {
                    stm.setString(index, value[1].toString());
                }
                else if(type.equals(Boolean.class.getName())){
                    stm.setBoolean(index, Boolean.parseBoolean(value[1].toString()));
                }
                else if(type.equals(Date.class.getName())){
                    stm.setDate(index, Date.valueOf(value[1].toString()));
                }
            }
            ResultSet rs = stm.executeQuery(); 
            while(rs.next()){
               UserCourse userCourse = new UserCourse();
               userCourse.setUserCourseId(rs.getInt("usercourseId"));
               // user to registration 
               User userRegis = new User(); 
               userRegis.setId(rs.getInt("Userid"));
               userRegis.setFullName(rs.getString("fullname"));
               userRegis.setEmail(rs.getString("email"));
               userCourse.setUser(userRegis);
               // course 
               Course course = new Course(); 
               course.setCourseId(rs.getInt("Courseid"));
               course.setTitle(rs.getString("title"));
               userCourse.setCourse(course);
               // start date 
               userCourse.setStartDate(rs.getDate("Startdate"));
               // end date 
               userCourse.setEndDate(rs.getDate("enddate"));
               // price package 
               PricePackage pricePackage = new PricePackage();
               pricePackage.setId(rs.getInt("price_packageid"));
               pricePackage.setName(rs.getString("pname"));
               pricePackage.setSalePrice(rs.getFloat("totalCost"));
               userCourse.setPricePackage(pricePackage);
               // registration_status
               Status s = new Status();
               s.setId(rs.getInt("registration_status"));
               s.setName(rs.getString("Sname"));
               userCourse.setRegistration_status(s);
               // updateBy
               User updateBy = new User(); 
               updateBy.setId(rs.getInt("updateById"));
               updateBy.setFullName(rs.getString("updateByFullName"));
               updateBy.setEmail(rs.getString("updateByEmail"));
               userCourse.setUpdateBy(updateBy);
               usercourses.add(userCourse);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usercourses;
    }
    
    public int CountAdvancedSearchRegistration(int sort, String title, Date registrationFrom,Date registrationTo, int status, String Email){
        ArrayList<UserCourse> usercourses = new ArrayList<>();
        try {
            String sql = "select Count(*) as Total from ( select uc.usercourseId, u.Userid, u.fullname, u.email, uc.Courseid, c.title, uc.Startdate, uc.enddate, uc.price_packageid, p.[name] as pname, p.sale_price as totalCost , uc.registration_status, \n" +
                    "	    updateBy.Userid as updateById, updateBy.fullname as updateByFullName, updateBy.email as updateByEmail ,";
            switch (sort) {
                case 0:
                    sql += " ROW_NUMBER() OVER(order by uc.usercourseId asc) as row_index ";
                    break;
                case 1:
                    sql += " ROW_NUMBER() OVER(order by uc.usercourseId desc) as row_index ";
                    break;
                    // email : 
                case 2:
                    sql += " ROW_NUMBER() OVER(order by u.email asc) as row_index ";
                    break;
                case 3:
                    sql += " ROW_NUMBER() OVER(order by u.email desc) as row_index ";
                    break;
                    // registration time : 
                case 4:
                    sql += " ROW_NUMBER() OVER(order by uc.Startdate asc) as row_index ";
                    break;
                case 5:
                    sql += " ROW_NUMBER() OVER(order by uc.Startdate desc) as row_index ";
                    break;
                    // subject ( sort theo title ) 
                case 6:
                    sql += " ROW_NUMBER() OVER(order by c.title asc) as row_index ";
                    break;
                case 7:
                    sql += " ROW_NUMBER() OVER(order by c.title desc) as row_index ";
                    break;
                    //  ( sort theo package ) 
                case 8:
                    sql += " ROW_NUMBER() OVER(order by p.[name] asc) as row_index ";
                    break;
                case 9:
                    sql += " ROW_NUMBER() OVER(order by p.[name] desc) as row_index ";
                    break;
                    // total cost
                case 10:
                    sql += " ROW_NUMBER() OVER(order by p.sale_price asc) as row_index ";
                    break;
                case 11:
                    sql += " ROW_NUMBER() OVER(order by p.sale_price desc) as row_index ";
                    break;
                    // valid to ( bỏ qua valid from ) 
                case 12:
                    sql += " ROW_NUMBER() OVER(order by s.sname asc) as row_index ";
                    break;
                case 13:
                    sql += " ROW_NUMBER() OVER(order by s.sname desc) as row_index ";
                    break; 
                default:
                    break;              
            }
            sql += " from User_Course as uc \n" +
                    "                    INNER JOIN [User] as u on uc.Userid = u.Userid\n" +
                    "                    INNER JOIN Courses as c on uc.Courseid = c.CourseId\n" +
                    "	             INNER JOIN Price_Package as p on uc.price_packageid = p.id\n" +
                    "		     INNER JOIN [User] as updateBy on uc.UpdateBy = updateBy.Userid\n" +
                    "	             And (1=1) ";
            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 0;
            if (title != null) {
                sql += "And c.title like '%' + ? + '%' ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = title;
                parameters.put(paramIndex, param);
            }
            if (Email != null) {
                sql += "And u.email like '%' + ? + '%' ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = Email;
                parameters.put(paramIndex, param);
            }
            if (status != -1) {
                sql += "And uc.registration_status = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = status;
                parameters.put(paramIndex, param);
            }
            
            if (registrationFrom != null) {
                sql += "And uc.Startdate >= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = registrationFrom;
                parameters.put(paramIndex, param);
            }
            if (registrationTo != null) {
                sql += "And uc.Startdate <= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = registrationTo;
                parameters.put(paramIndex, param);
            }
            sql += " ) as tbl ";
 
            PreparedStatement stm = connection.prepareStatement(sql); 
             //parameters
            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if(type.equals(Integer.class.getName()))
                {
                    stm.setInt(index, Integer.parseInt(value[1].toString()));
                }
                else if (type.equals(String.class.getName()))
                {
                    stm.setString(index, value[1].toString());
                }
                else if(type.equals(Boolean.class.getName())){
                    stm.setBoolean(index, Boolean.parseBoolean(value[1].toString()));
                }
                else if(type.equals(Date.class.getName())){
                    stm.setDate(index, Date.valueOf(value[1].toString()));
                }
            }
            ResultSet rs = stm.executeQuery(); 
            while(rs.next()){
               return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
    /*
      Dat inter 3 đã fix
    */
/*
      Dat inter 3 30/6
    */
     public void updateUcDetail2(UserCourse uc, int ucid) {
        try {
            String sql = "UPDATE [dbo].[User_Course]\n"
                    + "   SET [Userid] = ?\n"
                    + "      ,[Courseid] = ?\n"
                    + "      ,[Startdate] = ?\n"
                    + "      ,[enddate] = ?\n"
                    + "      ,[price_packageid] = ?\n"
                    + "      ,[registration_status] = ?\n"
                    + "      ,[updateby] = ?\n"
                    + " WHERE [usercourseId] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, uc.getUser().getId());
            stm.setInt(2, uc.getCourse().getCourseId());
            stm.setDate(3, uc.getStartDate());
            stm.setDate(4, uc.getEndDate());
            stm.setInt(5, uc.getPricePackage().getId());
            stm.setInt(6, uc.getRegistration_status().getId());
            stm.setInt(7, uc.getUpdateBy().getId());
            stm.setInt(8, ucid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStatus(int status, int ucid) {
        try {
            String sql = "UPDATE [User_Course]\n"
                    + "   SET [registration_status] = ?\n"
                    + " WHERE [User_Course].usercourseId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setInt(2, ucid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserCourse geUCourses(int ucid) {
        try {
            String sql = "select uc.usercourseId,\n"
                    + "uc.Userid,\n"
                    + "uc.Courseid,\n"
                    + "uc.Startdate,\n"
                    + "uc.enddate,\n"
                    + "uc.price_packageid,\n"
                    + "uc.registration_status,\n"
                    + "uc.createby,\n"
                    + "uc.updateby\n"
                    + " from User_Course uc where uc.usercourseId =? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, ucid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserCourse uc = new UserCourse();
                uc.setUserCourseId(rs.getInt("usercourseId"));
                UserDBContext udbc = new UserDBContext();
                User u = udbc.getUserById(rs.getInt("Userid"));
                uc.setUser(u);
                CourseDBContext cdbc = new CourseDBContext();
                Course c = cdbc.getSubjectById(rs.getInt("Courseid"));
                uc.setCourse(c);
                uc.setStartDate(rs.getDate("Startdate"));
                uc.setEndDate(rs.getDate("enddate"));
                PricePackageDBContext ppdbc = new PricePackageDBContext();
                PricePackage p = ppdbc.getPackage(rs.getInt("price_packageid"));
                uc.setPricePackage(p);
                Status s = new Status();
                s.setId(rs.getInt("registration_status"));   
                uc.setRegistration_status(s);
                UserDBContext udbc1 = new UserDBContext();
                User u1 = udbc1.getUserById(rs.getInt("createby"));
                UserDBContext udbc2 = new UserDBContext();
                User u2  = udbc2.getUserById(rs.getInt("updateby"));
                uc.setCreateBy(u1);
                uc.setUpdateBy(u2);
                return uc;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertUcDetail(UserCourse uc) {
        try {
            String sql = "INSERT INTO [User_Course]\n"
                    + "           ([Userid]\n"
                    + "           ,[Courseid]\n"
                    + "           ,[Startdate]\n"
                    + "           ,[enddate]\n"
                    + "           ,[price_packageid]\n"
                    + "           ,[registration_status]\n"
                    + "           ,[createby]\n"
                    + "           ,[updateby])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, uc.getUser().getId());
            stm.setInt(2, uc.getCourse().getCourseId());
            stm.setDate(3, uc.getStartDate());
            stm.setDate(4, uc.getEndDate());
            stm.setInt(5, uc.getPricePackage().getId());
            stm.setInt(6, uc.getRegistration_status().getId());
            stm.setInt(7, uc.getCreateBy().getId());
            stm.setInt(8, uc.getUpdateBy().getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public UserCourse getUserCouByUidCid1(int userid, int courseid) {

        try {
            String sql = "select uc.usercourseId,\n" +
    "	uc.Userid, uc.Courseid,uc.Startdate,\n" +
    "	uc.enddate,uc.price_packageid,uc.registration_status,\n" +
    "	uc.createby,uc.updateby\n" +
    " from User_Course uc\n" +
    " where Userid = ? and Courseid = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userid);
            stm.setInt(2, courseid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                UserCourse uc = new UserCourse();
                Course c = new Course();
                User u = new User();
                PricePackage p = new PricePackage();
                uc.setUserCourseId(rs.getInt("usercourseId"));
                u.setId(rs.getInt("Userid"));
                uc.setUser(u);
                c.setCourseId(rs.getInt("Courseid"));
                uc.setCourse(c);
                uc.setStartDate(rs.getDate("Startdate"));
                uc.setEndDate(rs.getDate("enddate"));
                p.setId(rs.getInt("price_packageid"));
                uc.setPricePackage(p);
                Status s = new Status();
                s.setId(rs.getInt("registration_status"));   
                uc.setRegistration_status(s);
                return uc;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserCourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
