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
import model.Category;
import model.Course;
import model.Status;
import model.Tag;

/**
 *
 * @author thand
 */
public class CourseDBContext extends DBContext {

   public Course getCourseDetail(int CourseId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT [CourseId]\n"
                + "      ,[createdate]\n"
                + "      ,[briefinfo]\n"
                + "      ,[thumnaiURL]\n"
                + "      ,[title]\n"
                +",[description]"
                + "      ,[featured]\n"
                + "      ,[Categoryid]\n"
                + "      ,[statusid]\n"
                + "  FROM [Courses] c\n"
                + "  where c.CourseId = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, CourseId);
            stm.executeQuery();
            rs = stm.executeQuery();
            if (rs.next()) {
                Course Course = new Course();
                Course.setCourseId(CourseId);
                Course.setCreatedate(rs.getDate("createdate"));
                Course.setBriefinfo(rs.getString("briefinfo"));
                Course.setThumnailURL(rs.getString("thumnaiURL"));
                Course.setTitle(rs.getString("title"));
                Course.setDescription(rs.getString("description"));
                Course.setFeature(rs.getBoolean("featured"));
                TagDBContext tdbc = new TagDBContext();
                ArrayList<Tag> tags = tdbc.getTags(CourseId);
                Course.setTags(tags);
                Category category = new Category();
                category.setCategoryID(rs.getInt("Categoryid"));
                Course.setCategory(category);
                Status a = new Status();
                Course.setStatus(a);
                return Course;
            }
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

    public ArrayList<Course> getMyCourse(int UserId, int pageindex, int pagesize) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "	select * from\n"
                + "	(select c.CourseId,\n"
                + "     c.title,\n"
                + "     c.briefinfo,\n"
                + "     c.createdate,\n"
                + "     c.Categoryid,\n"
                + "     c.featured,\n"
                +"c.[description],"
                + "     c.statusid,\n"
                + "     c.thumnaiURL,\n"
                + "	u.Userid,uc.registration_status,\n"
                + "	ROW_NUMBER() over (order by c.CourseId asc ) as row_index\n"
                + "     from \n"
                + "     [User] u inner join User_Course uc on u.Userid=uc.Userid\n"
                + "              inner join Courses c on uc.Courseid = c.CourseId) u\n"
                + "     where u.Userid = ? and u.registration_status='true' \n"
                + "		and row_index >= (?-1)*?+1 and row_index<= ?*?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, UserId);
            stm.setInt(2, pageindex);
            stm.setInt(3, pagesize);
            stm.setInt(4, pageindex);
            stm.setInt(5, pagesize);
            stm.executeQuery();
            rs = stm.executeQuery();
            ArrayList<Course> Courses = new ArrayList<>();
            while (rs.next()) {
                Course Course = new Course();
                Course.setCourseId(rs.getInt("CourseId"));
                Course.setCreatedate(rs.getDate("createdate"));
                Course.setDescription(rs.getString("description"));
                Course.setBriefinfo(rs.getString("briefinfo"));
                Course.setThumnailURL(rs.getString("thumnaiURL"));
                Course.setTitle(rs.getString("title"));
                Course.setFeature(rs.getBoolean("featured"));
                TagDBContext tdbc = new TagDBContext();
                ArrayList<Tag> tags = tdbc.getTags(rs.getInt("CourseId"));
                Course.setTags(tags);
                Category category = new Category();
                category.setCategoryID(rs.getInt("Categoryid"));
                Course.setCategory(category);
                Status a = new Status();
                Course.setStatus(a);
                Courses.add(Course);
            }
            return Courses;
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

    public int count(int Userid) {
        PreparedStatement stm=null;
        ResultSet rs =null;
        try {
            String sql = "SELECT COUNT(*) as Total FROM(\n" +
"                    	select * from\n" +
"                   	(select c.CourseId,\n" +
"                               c.title,\n" +
"                               c.briefinfo,\n" +
"                               c.createdate,\n" +
"                                c.Categoryid,\n" +
"                               c.featured,\n" +
"                               c.statusid,\n" +
"                               c.thumnaiURL,\n" +
"                   			   u.Userid,\n" +
"							   uc.registration_status,\n" +
"                    				ROW_NUMBER() over (order by c.CourseId asc ) as row_index\n" +
"                                   	from \n" +
"                                  [User] u inner join User_Course uc on u.Userid=uc.Userid\n" +
"                                    		inner join Courses c on uc.Courseid = c.CourseId) u)a\n" +
"                                where a.Userid =  ? and a.registration_status ='true'";
             stm = connection.prepareStatement(sql);
            stm.setInt(1, Userid);
             rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
        }finally {
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
        return -1;
    }
    
    public int getCourseRate(int courseId, int userId){
            PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "EXEC getRatecourse  @UserId = ?, @CourseId= ?;";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setInt(2, courseId);
            stm.executeQuery();
            rs = stm.executeQuery();
            if (rs.next()) {
                return  rs.getInt("ratecourse");
            }
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
        return 0;
    }
    

    public ArrayList<Course> searchCourse(int sort, int[] cid, int[] tid, Date begin, Date end, int feature, String name, int pageIndex, int pageSize) {
        //page size is  number of element in page
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "  SELECT * FROM\n"
                    + "                        (SELECT Courses.CourseId, thumnaiURL,title, Courses.featured, Category.Categoryid, Category.value, "; // last element in pageindex
            switch (sort) {
                case 0:
                    sql += " ROW_NUMBER() OVER (ORDER BY Courses.createdate DESC) ";
                    break;
                case 1:
                    sql += " ROW_NUMBER() OVER (ORDER BY Courses.createdate ASC) ";
                    break;
                case 2:
                    sql += " ROW_NUMBER() OVER (ORDER BY Courses.title ASC) ";
                    break;
                case 3:
                    sql += " ROW_NUMBER() OVER (ORDER BY Courses.title DESC) ";
                    break;
                default:
                    break;
            }
            sql += " as row_index \n"
                    + "FROM Courses \n"
                    + " inner join Status on Status.Sid = Courses.statusid \n"
                    + " inner join Category on Category.Categoryid = Courses.Categoryid\n";
            if (tid != null) {
                sql += "   inner join\n"
                        + "	(SELECT distinct Courses.CourseId\n"
                        + "	FROM     courseTag INNER JOIN\n"
                        + "            Tag ON courseTag.tagId = Tag.tagId INNER JOIN\n"
                        + "            Courses ON courseTag.courseId = Courses.CourseId where (1=1) and Tag.tagId in (";
                for (int i = 0; i < tid.length; i++) {
                    sql += tid[i] + ",";
                }
                if (sql.endsWith(",")) {
                    sql = sql.substring(0, sql.length() - 1);
                }
                sql += ")) as tb on tb.CourseId=Courses.CourseId";
            }
            sql += "                    where statusid =1 ";
            
                  

            //add cid
            if (cid != null) {
                sql += " and Category.Categoryid in (";
                for (int i = 0; i < cid.length; i++) {
                    sql += cid[i] + ",";
                }
                if (sql.endsWith(",")) {
                    sql = sql.substring(0, sql.length() - 1);
                }
                sql += ")";
            }
           

            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 0;
            if (begin != null) {
                sql += " And Courses.createdate >= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = begin;
                parameters.put(paramIndex, param);
            }
            if (end != null) {
                sql += " And Courses.createdate <= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = end;
                parameters.put(paramIndex, param);
            }
            if (feature != 0) {
                sql += " And featured =? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = feature;
                parameters.put(paramIndex, param);
            }
            if (name != null) {
                sql += " And Courses.title like ?  ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = name;
                parameters.put(paramIndex, param);
            }

            sql += " ) tbl\n"
                    + "WHERE row_index >= (? -1)*? + 1\n"
                    + "AND row_index <= ? *?   ";
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
            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Integer.class.getName())) {
                    stm.setInt(index, Integer.parseInt(value[1].toString()));
                } else if (type.equals(String.class.getName())) {
                    stm.setString(index, "%" + value[1].toString() + "%");
                } else if (type.equals(Date.class.getName())) {
                    stm.setDate(index, Date.valueOf(value[1].toString()));
                }
            }

//            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt(1));
                c.setThumnailURL(rs.getString(2));
                c.setTitle(rs.getString(3));
                c.setFeature(rs.getBoolean(4));
                Category ca = new Category();
                ca.setCategoryID(rs.getInt(5));
                ca.setValue(rs.getString(6));
                c.setCategory(ca);

                courses.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public int coutCouse(int[] cid, int[] tid, Date begin, Date end, int feature, String name) {
        try {
            String sql = "SELECT COUNT(*) as total from\n"
                    + "(SELECT\n"
                    + "ROW_NUMBER() OVER (ORDER BY Courses.createdate DESC)\n"
                    + "as row_index \n"
                    + "                    FROM Courses \n"
                    + "                     inner join Status on Status.Sid = Courses.statusid \n"
                    + "                    inner join Category on Category.Categoryid = Courses.Categoryid";

            if (tid != null) {
                sql += "   inner join\n"
                        + "	(SELECT distinct Courses.CourseId\n"
                        + "	FROM     courseTag INNER JOIN\n"
                        + "            Tag ON courseTag.tagId = Tag.tagId INNER JOIN\n"
                        + "            Courses ON courseTag.courseId = Courses.CourseId where (1=1) and Tag.tagId in (";
                for (int i = 0; i < tid.length; i++) {
                    sql += tid[i] + ",";
                }
                if (sql.endsWith(",")) {
                    sql = sql.substring(0, sql.length() - 1);
                }
                sql += ")) as tb on tb.CourseId=Courses.CourseId";
            }
            sql += "                    where statusid =1 ";
            
            
            if (cid != null) {
                sql += " and Category.Categoryid in (";
                for (int i = 0; i < cid.length; i++) {
                    sql += cid[i] + ",";
                }
                if (sql.endsWith(",")) {
                    sql = sql.substring(0, sql.length() - 1);
                }
                sql += ")";
            }

            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 0;
            if (begin != null) {
                sql += " And Courses.createdate >= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = begin;
                parameters.put(paramIndex, param);
            }
            if (end != null) {
                sql += " And Courses.createdate <= ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Date.class.getTypeName();
                param[1] = end;
                parameters.put(paramIndex, param);
            }
            if (feature != 0) {
                sql += " And featured =? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = feature;
                parameters.put(paramIndex, param);
            }
            if (name != null) {
                sql += " And Courses.title like ?  ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = name;
                parameters.put(paramIndex, param);
            }

            sql += " ) tbl\n";

            // dấu hỏi số 1 của where row_index >= ....
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] value = entry.getValue();
                String type = value[0].toString();
                if (type.equals(Integer.class.getName())) {
                    stm.setInt(index, Integer.parseInt(value[1].toString()));
                } else if (type.equals(String.class.getName())) {
                    stm.setString(index, "%" + value[1].toString() + "%");
                } else if (type.equals(Date.class.getName())) {
                    stm.setDate(index, Date.valueOf(value[1].toString()));
                }
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public ArrayList<Course> getThreeCourseForHome() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT top(3) Courses.CourseId, Courses.thumnaiURL, Courses.title, Courses.featured ,Category.Categoryid,Category.value\n"
                    + "FROM     Courses INNER JOIN\n"
                    + "                  Status ON Courses.statusid = Status.Sid INNER JOIN\n"
                    + "                  Category ON Courses.Categoryid = Category.Categoryid\n"
                    + "				  where Status.Sid = 1 \n"
                    + "				  order by createdate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt(1));
                c.setThumnailURL(rs.getString(2));
                c.setTitle(rs.getString(3));
                
                c.setFeature(rs.getBoolean(5));

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(5));
                ca.setValue(rs.getString(6));
                c.setCategory(ca);

                courses.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public ArrayList<Course> getMostProminentForHome() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT top(4) Courses.CourseId, Courses.thumnaiURL, Courses.title, Courses.featured ,Category.Categoryid,Category.value\n"
                    + "                    FROM     Courses INNER JOIN\n"
                    + "                                     Status ON Courses.statusid = Status.Sid INNER JOIN\n"
                    + "                                      Category ON Courses.Categoryid = Category.Categoryid\n"
                    + "                    			  where Status.Sid = 1 and featured =1\n"
                    + "                    			  order by createdate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt(1));
                c.setThumnailURL(rs.getString(2));
                c.setTitle(rs.getString(3));
               
                c.setFeature(rs.getBoolean(5));

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(5));
                ca.setValue(rs.getString(6));
                c.setCategory(ca);

                courses.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public ArrayList<Course> getCourseForSlider() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT top(3) Courses.CourseId, Courses.thumnaiURL, Courses.title, Courses.featured ,Category.Categoryid,Category.value\n"
                    + "                    FROM     Courses INNER JOIN\n"
                    + "                                     Status ON Courses.statusid = Status.Sid INNER JOIN\n"
                    + "                                      Category ON Courses.Categoryid = Category.Categoryid\n"
                    + "                    			  where Status.Sid = 1 and featured =1\n"
                    + "                    			  order by createdate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt(1));
                c.setThumnailURL(rs.getString(2));
                c.setTitle(rs.getString(3));
              
                c.setFeature(rs.getBoolean(5));

                Category ca = new Category();
              
                ca.setValue(rs.getString(6));
                c.setCategory(ca);

                courses.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }
    public ArrayList<Course> getThreeCourseForCourse(String id) {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT top(3) Courses.CourseId, Courses.thumnaiURL, Courses.title, Courses.featured ,Category.Categoryid,Category.value\n"
                    + "FROM     Courses INNER JOIN\n"
                    + "                  Status ON Courses.statusid = Status.Sid INNER JOIN\n"
                    + "                  Category ON Courses.Categoryid = Category.Categoryid\n"
                    + "				  where Status.Sid = 1 and Courses.CourseId!=?\n"
                    + "				  order by createdate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt(1));
                c.setThumnailURL(rs.getString(2));
                c.setTitle(rs.getString(3));
                
                c.setFeature(rs.getBoolean(5));

                Category ca = new Category();
                ca.setCategoryID(rs.getInt(5));
                ca.setValue(rs.getString(6));
                c.setCategory(ca);

                courses.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }
}
