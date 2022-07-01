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
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Course;
import model.Dimension;
import model.DimensionType;
import model.PricePackage;
import model.Status;
import model.Tag;
import model.User;

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
     public int countRegis(int Userid) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) as Total from (select uc.usercourseId,\n"
                    + "                    uc.Courseid,\n"
                    + "                    uc.Startdate,\n"
                    + "                    uc.enddate,\n"
                    + "                    uc.price_packageid,\n"
                    + "                    uc.registration_status,\n"
                    + "					uc.Userid,\n"
                    + "					ROW_NUMBER() over (order by uc.CourseId asc ) as row_index\n"
                    + "                    from User_Course uc \n"
                    + "					inner join [User] u  on uc.Userid= u.Userid\n"
                    + "                    where u.Userid = ? ) a";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, Userid);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {

        }
        return -1;
    }
    public ArrayList<Course> getMyCourse(int UserId, int pageindex, int pagesize) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select * from\n"
                + "	(select c.CourseId,\n"
                + "            c.title,\n"
                + "            c.briefinfo,\n"
                + "            c.createdate,\n"
                + "            c.Categoryid,\n"
                + "            c.featured,\n"
                + "            c.statusid,\n"
                + "            c.thumnaiURL,\n"
                + "			u.Userid,uc.registration_status,\n"
                + "			ROW_NUMBER() over (order by c.CourseId asc ) as row_index\n"
                + "            from  [User] u inner join User_Course uc on u.Userid=uc.Userid\n"
                + "                		inner join Courses c on uc.Courseid = c.CourseId\n"
                + "			where u.Userid = ? \n"
                + "			) u\n"
                + " where row_index >= (?-1) * ? + 1 and row_index <= ?*? ";
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
//                a.setId(rs.getInt(""));
//                Course.setStatus(a);
                Courses.add(Course);
            }
            return Courses;
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
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
"                                where a.Userid =  ? ";
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
    public ArrayList<Course> getThreeCourseForCourse(int id) {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "SELECT top(3) Courses.CourseId, Courses.thumnaiURL, Courses.title, Courses.featured ,Category.Categoryid,Category.value\n"
                    + "FROM     Courses INNER JOIN\n"
                    + "                  Status ON Courses.statusid = Status.Sid INNER JOIN\n"
                    + "                  Category ON Courses.Categoryid = Category.Categoryid\n"
                    + "				  where Status.Sid = 1 and Courses.CourseId!=?\n"
                    + "				  order by createdate desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt(1));
                c.setThumnailURL(rs.getString(2));
                c.setTitle(rs.getString(3));
                
                c.setFeature(rs.getBoolean(5));
                TagDBContext tdb = new TagDBContext();
               ArrayList<Tag> tag = tdb.getTagsByCourse(id);
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
    /*
       tuanthanh
       14/06/2022
    */
    public Course getSubjectById(int id){
        Course course = new Course();
       try {       
           String sql_course = "select * from Courses as c INNER JOIN Category as cat on c.Categoryid = cat.Categoryid\n" +
                   " INNER JOIN [Status] as s on c.statusid = s.[Sid] where courseid = ? ";
           PreparedStatement stm_sql_course = connection.prepareStatement(sql_course);
           stm_sql_course.setInt(1, id);
           ResultSet rs_sql_course = stm_sql_course.executeQuery();
           while(rs_sql_course.next()){
               // take Course
               course.setCourseId(rs_sql_course.getInt("CourseId"));
               course.setCreateDate(rs_sql_course.getDate("createdate"));
               course.setBriefInfo(rs_sql_course.getString("briefinfo"));
               course.setThumnailURL(rs_sql_course.getString("thumnaiURL"));
               course.setTitle(rs_sql_course.getString("title"));
               course.setFeature(rs_sql_course.getBoolean("featured"));
               course.setDescription(rs_sql_course.getString("description"));
               // get category for this course
               Category category = new Category(); 
               category.setCategoryID(rs_sql_course.getInt("categoryId"));
               category.setValue(rs_sql_course.getString("value"));
               course.setCategory(category);
               // get status for this course 
               Status status = new Status();
               status.setId(rs_sql_course.getInt("sid"));
               status.setName(rs_sql_course.getString("Sname"));
               course.setStatus(status);
               // get list packages for this course 
               String sql_Packages = "select * from Course_package as cp INNER JOIN Price_Package as p on cp.packageid = p.id \n" +
              " INNER JOIN [Status] as s on p.Status_id = s.Sid  where courseid = ? ";
               stm_sql_course = connection.prepareStatement(sql_Packages);
               stm_sql_course.setInt(1, id);
               ResultSet rs_sql_Packages = stm_sql_course.executeQuery();
               ArrayList<PricePackage> pricepackages = new ArrayList<>();
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
               course.setPricePackage(pricepackages);
               // get list Owns for this course 
               String sql_Owners = "select * from [Owner] as o INNER JOIN [User] as p on o.UserId = p.Userid \n" +
                                   " INNER JoIn [Status] as s on p.Statusid = s.Sid \n" +
                                   " where courseid = ?";
               stm_sql_course = connection.prepareStatement(sql_Owners);
               stm_sql_course.setInt(1, id);
               ResultSet rs_sql_Owners = stm_sql_course.executeQuery(); 
               ArrayList<User> owners = new ArrayList<>();
               while(rs_sql_Owners.next()){
                    User user = new User();
                    user.setId(rs_sql_Owners.getInt("Userid"));
                    user.setFullName(rs_sql_Owners.getString("fullname"));
                    user.setEmail(rs_sql_Owners.getString("email"));
                    user.setGender(rs_sql_Owners.getBoolean("gender"));
                    user.setPassword(rs_sql_Owners.getString("password"));
                    user.setPhone(rs_sql_Owners.getString("phone"));
                    user.setAvatarImage(rs_sql_Owners.getString("avatar_img"));
                    user.setDob(rs_sql_Owners.getDate("dob"));
                    // get status for this user 
                    Status status_user = new Status();
                    status_user.setId(rs_sql_Owners.getInt("Sid"));
                    status_user.setName(rs_sql_Owners.getString("Sname"));
                    user.setStatus(status_user);
                    owners.add(user);
               } 
               course.setOwners(owners);
               // get list Tags for this course
               String sql_Tags = "select * from courseTag as c INNER JOIN tag as t on c.tagId = t.tagId  where courseid = ? ";
               stm_sql_course = connection.prepareStatement(sql_Tags);
               stm_sql_course.setInt(1, id);
               ResultSet rs_sql_Tags = stm_sql_course.executeQuery();
               ArrayList<Tag> tags = new ArrayList<>();
               while(rs_sql_Tags.next()){
                  Tag tag = new Tag();
                  tag.setTagId(rs_sql_Tags.getInt("tagId"));
                  tag.setTagname(rs_sql_Tags.getString("tagname"));
                  tags.add(tag);
               }
               course.setTags(tags);
               // get list Dimension for this course
               String sql_dimension = " select dimensionid, did, d.[name] as dname, d.typeID, dicription, dt.TypeId, dt.[name] as dtname from Course_dimension as cd INNER JOIN Dimension as d on cd.dimensionid = d.Did \n" +
                                     " INNER JOIN DimensionType as dt on dt.TypeId = d.typeID\n" +
                                        " where Courseid = ? ";
               stm_sql_course = connection.prepareStatement(sql_dimension);
               stm_sql_course.setInt(1, id);
               ResultSet rs_sql_dimension = stm_sql_course.executeQuery();
               ArrayList<Dimension> dimensions = new ArrayList<>();
               while(rs_sql_dimension.next()){
                   Dimension dimension = new Dimension();
                   dimension.setId(rs_sql_dimension.getInt("Did"));
                   dimension.setName(rs_sql_dimension.getString("dname"));
                   dimension.setDescription(rs_sql_dimension.getString("dicription"));
                   DimensionType dimensionType = new DimensionType();
                   dimensionType.setId(rs_sql_dimension.getInt("TypeId"));
                   dimensionType.setName(rs_sql_dimension.getString("dtname"));
                   dimension.setDimensionType(dimensionType);
                   dimensions.add(dimension);
               }
               course.setDimensions(dimensions);
           }
       } catch (SQLException ex) {
           Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       return course;
    }
    /*
       tuanthanh
       check name img exist
    */
    public boolean doesExistImgNameCourse(String name){
       try {
           String sql = "select * from Courses where thumnaiURL like ?";
           PreparedStatement stm = connection.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               return true;
            }
           } catch (SQLException ex) {
           Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    }
    /*
      Update Course
      tuanthanh
    */
    public void UpdateCourse(Course c){
       try {
           String sql_course = "UPDATE [Courses]\n" +
                   "   SET [briefinfo] = ?\n" +
                   "      ,[thumnaiURL] = ?\n" +
                   "      ,[title] = ?\n" +
                   "      ,[featured] = ?\n" +
                   "      ,[Categoryid] = ?\n" +
                   "      ,[statusid] = ?\n" +
                   "      ,[description] = ?\n" +
                   " WHERE CourseId = ? ";
           connection.setAutoCommit(false);
           PreparedStatement stm_sql_course = connection.prepareStatement(sql_course);
           stm_sql_course.setString(1, c.getBriefInfo());
           stm_sql_course.setString(2, c.getThumnailURL());
           stm_sql_course.setString(3, c.getTitle());
           stm_sql_course.setBoolean(4, c.isFeature());
           stm_sql_course.setInt(5, c.getCategory().getCategoryID());
           stm_sql_course.setInt(6, c.getStatus().getId());
           stm_sql_course.setString(7, c.getDescription());
           stm_sql_course.setInt(8, c.getCourseId());
           stm_sql_course.executeUpdate();
           // update Owner
            // first delete Owner where id : 
           String sql_delete_Owner = "DELETE FROM [Owner] WHERE CourseId = ? ";
           PreparedStatement stm_delete_Owner = connection.prepareStatement(sql_delete_Owner);
           stm_delete_Owner.setInt(1, c.getCourseId());
           stm_delete_Owner.executeUpdate();
           // update Owner
           String sql_update_Owner = "INSERT INTO [Owner]\n" +
                                    "           ([UserId]\n" +
                                    "           ,[CourseId])\n" +
                                    "     VALUES\n" +
                                    "           (? \n" +
                                    "           ,? )";         
           for (User user : c.getOwners()) {
                PreparedStatement stm_update_Owner = connection.prepareStatement(sql_update_Owner);
                stm_update_Owner.setInt(1, user.getId());
                stm_update_Owner.setInt(2, c.getCourseId());
                stm_update_Owner.executeUpdate();
           }
           // Update tag
           // frist delete tag where id course :
           String sql_delete_tag = "DELETE FROM [courseTag] WHERE courseId = ? ";
           PreparedStatement stm_delete_tag = connection.prepareStatement(sql_delete_tag);
           stm_delete_tag.setInt(1, c.getCourseId());
           stm_delete_tag.executeUpdate();
           // Update tag
           String sql_update_tag = "INSERT INTO [courseTag]\n" +
                                    "           ([courseId]\n" +
                                    "           ,[tagId])\n" +
                                    "     VALUES\n" +
                                    "           (? \n" +
                                    "           ,? ) ";
           for (Tag tag : c.getTags()) {
               PreparedStatement stm_update_tag = connection.prepareStatement(sql_update_tag);
               stm_update_tag.setInt(1, c.getCourseId());
               stm_update_tag.setInt(2, tag.getTagId());
               stm_update_tag.executeUpdate();
           }
          connection.commit(); 
       } catch (SQLException ex) {
           Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    /*
    1 : 50   
    */
   /*
    1 : 50   
     */
    public ArrayList<Course> searchSubject(int sort, int[] cid, Date begin, Date end, String name, int statusid, int userid, int pageIndex, int pageSize) {
        //page size is  number of element in page
        ArrayList<Course> courses = new ArrayList<>();
        try {
            String sql = "  SELECT * FROM\n"
                    + "                        (SELECT Courses.CourseId, thumnaiURL,title, Courses.featured, Category.Categoryid, Category.value,createdate ,"
                    + "[Status].Sid,[Status].Sname , "; // last element in pageindex
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
            sql += "as row_index  \n"
                    + "			FROM Courses\n"
                    + "			inner join Status on Status.Sid = Courses.statusid\n"
                    + "			inner join Category on Category.Categoryid = Courses.Categoryid \n";

            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 0;
            if (userid != 0) {
                sql += " inner join (select distinct Courses . CourseId  from Courses \n"
                        + "			inner join  [Owner]  on [Owner].CourseId = Courses.CourseId where (1=1) and [Owner].UserId = ? ) tb"
                        + " on Courses.CourseId = tb.CourseId ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = userid;
                parameters.put(paramIndex, param);
            }
            sql += " where (1=1) ";

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

            if (name != null) {
                sql += " And Courses.title like ?  ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = name;
                parameters.put(paramIndex, param);
            }
            if (statusid != 0) {
                sql += " And [Status].Sid = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = statusid;
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
                c.setCreateDate(rs.getDate(7));

                Status s = new Status();
                s.setId(rs.getInt(8));
                s.setName(rs.getString(9));

                c.setCategory(ca);
                c.setStatus(s);
                courses.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }

    public int countSubject(int sort, int[] cid, Date begin, Date end, String name, int statusid, int userid) {
        //page size is  number of element in page

        try {
            String sql = "  SELECT count(*) FROM\n"
                    + "                       (SELECT Courses.CourseId as courseId, "
                    + " ROW_NUMBER() OVER (ORDER BY Courses.createdate DESC) "
                    + " as row_index  \n"
                    + "			FROM Courses\n"
                    + "			inner join Status on Status.Sid = Courses.statusid\n"
                    + "			inner join Category on Category.Categoryid = Courses.Categoryid ";

            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 0;

            if (userid != 0) {
                sql += "inner join (select distinct Courses . CourseId  from Courses \n"
                        + "			inner join  [Owner]  on [Owner].CourseId = Courses.CourseId where (1=1) and [Owner].UserId = ? ) tb"
                        + " on Courses.CourseId = tb.CourseId ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = userid;
                parameters.put(paramIndex, param);
            }
            sql += " where (1=1) ";

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

            if (name != null) {
                sql += " And Courses.title like ?  ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = name;
                parameters.put(paramIndex, param);
            }
            if (statusid != 0) {
                sql += " And [Status].Sid = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = statusid;
                parameters.put(paramIndex, param);
            }
            sql += " ) tb1" ;
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
            if (rs.next()) {
                return rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int insertCourse(Course s) {
        int cid = 0;
        try {
            String sql = "INSERT INTO [dbo].[Courses]\n"
                    + "           ([createdate]\n"
                    + "           ,[briefinfo]\n"
                    + "           ,[thumnaiURL]\n"
                    + "           ,[title]\n"
                    + "           ,[featured]\n"
                    + "           ,[Categoryid]\n"
                    + "           ,[statusid]\n"
                    + "           ,[description])\n"
                    + "     VALUES\n"
                    + "           (GETDATE() \n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,? )";
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement(sql);
            //   stm.setInt(1, s.getCid());
            stm.setString(1, s.getBriefInfo());
            stm.setString(2, s.getThumnailURL());
            stm.setNString(3, s.getTitle());
            stm.setBoolean(4, s.isFeature());
            stm.setInt(5, s.getCategory().getCategoryID());
            stm.setInt(6, s.getStatus().getId());
            stm.setString(7, s.getDescription());

            stm.executeUpdate();

            String sql_get_id = "select @@IDENTITY as id";
            PreparedStatement stm_get_id = connection.prepareStatement(sql_get_id);

            ResultSet rs = stm_get_id.executeQuery();
            if (rs.next()) {
                cid = rs.getInt("id");
            }
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                return cid;
            } catch (SQLException ex) {
                Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public void insertCourseTag(int cid, ArrayList<Tag> certs) {
        String sql = "INSERT INTO [dbo].[courseTag]\n"
                + "           ([courseId]\n"
                + "           ,[tagId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";

        try {
            PreparedStatement stm_insert_cert = connection.prepareStatement(sql);
            for (Tag cert : certs) {

                stm_insert_cert.setInt(1, cid);
                stm_insert_cert.setInt(2, cert.getTagId());
                stm_insert_cert.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertOwner(int cid, ArrayList<User> owner) {
        String sql = "INSERT INTO [dbo].[Owner]\n"
                + "           ([UserId]\n"
                + "           ,[CourseId])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,? )";

        try {
            PreparedStatement stm_insert_cert = connection.prepareStatement(sql);
            for (User cert : owner) {

                stm_insert_cert.setInt(2, cid);
                stm_insert_cert.setInt(1, cert.getId());
                stm_insert_cert.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
       Hoa inter 3, ngày 7/1/2022
    */
    // Total
    public int totalCourse() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) as Total from courses ";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int newCourse() {
        try {
            String sql = "select count(*) as Total1 from \n"
                    + "(select top (7) CourseId ,createdate from \n"
                    + "(select CourseId, createdate from courses group by createdate,CourseId )  \n"
                    + " as t order by createdate desc) as c ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int totalCustomer() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select count(Distinct UserId) as Total2 from User_Course ";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total2");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int newCustomer() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select count(Distinct UserId) as Total from (\n"
                    + "select Top(7) UserId,Startdate from (\n"
                    + "select Userid, Startdate from User_Course \n"
                    + "group by Userid,Startdate ) as c  order by Startdate desc ) as d ";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int totalRevenues() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "select SUM(sale_price) as Total \n"
                    + "from User_Course as c inner join Price_Package as p\n"
                    + "on c.price_packageid = p.id ";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int newRevenues() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = " select SUM(sale_price) as Total from (\n"
                    + "select Top (7) sale_price, Startdate from\n"
                    + "(select c.Startdate, p.sale_price\n"
                    + "from User_Course as c inner join Price_Package as p\n"
                    + "on c.price_packageid = p.id )  as d \n"
                    + "order by d.Startdate desc) \n"
                    + "as m ";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    // registration
    public int registrationStatus(String status, String from, String to) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = " select count(*) as Total from User_Course as r \n"
                    + "inner join [Status] as s on r.registration_status = s.Sid \n"
                    + "where s.Sname like ? and r.Startdate >= ? and r.Startdate <= ? ";
            stm = connection.prepareStatement(sql);
            stm.setString(1, status);
            stm.setString(2, from);
            stm.setString(3, to);

            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int customCategory(int id, String from, String to) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = " select count(Distinct u.Userid) as Total  from User_Course as u \n"
                    + "inner join Courses as c on c.CourseId = u.Courseid\n"
                    + "inner join [Status] as s on s.Sid = u.registration_status \n"
                    + "inner join Category as cg on cg.Categoryid = c.Categoryid\n"
                    + "inner join parentCategory as pc on pc.id = cg.parentId\n"
                    + "where pc.id = ? and Startdate >= ? and Startdate <= ?  ";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, from);
            stm.setString(3, to);

            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int customSuc(int id, String from, String to) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = " select count(Distinct u.Userid) as Total  from User_Course as u \n"
                    + "inner join Courses as c on c.CourseId = u.Courseid\n"
                    + "inner join [Status] as s on s.Sid = u.registration_status \n"
                    + "inner join Category as cg on cg.Categoryid = c.Categoryid\n"
                    + "inner join parentCategory as pc on pc.id = cg.parentId\n"
                    + "where pc.id = ? and Startdate >= ? and Startdate <= ? and s.Sname like 'success'  ";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, from);
            stm.setString(3, to);

            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int orderSuc(String date) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = " select count(*) as Total  from User_Course as u \n"
                    + "inner join Courses as c on c.CourseId = u.Courseid\n"
                    + "inner join [Status] as s on s.Sid = u.registration_status \n"
                    + "inner join Category as cg on cg.Categoryid = c.Categoryid\n"
                    + "inner join parentCategory as pc on pc.id = cg.parentId\n"
                    + "where Startdate like ? and s.Sname = 'success'  ";
            stm = connection.prepareStatement(sql);
            stm.setString(1, date);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int order(String date) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = " select count(*) as Total  from User_Course as u \n"
                    + "inner join Courses as c on c.CourseId = u.Courseid\n"
                    + "inner join [Status] as s on s.Sid = u.registration_status \n"
                    + "inner join Category as cg on cg.Categoryid = c.Categoryid\n"
                    + "inner join parentCategory as pc on pc.id = cg.parentId\n"
                    + "where Startdate like ? ";
            stm = connection.prepareStatement(sql);
            // stm.setInt(1, id);
            stm.setString(1, date);

            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
