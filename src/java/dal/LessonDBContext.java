/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Blog;
import model.Category;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lesson;
import model.Status;

/**
 *
 * @author jicon
 */
public class LessonDBContext extends DBContext {
    

    
    
    
    
        
    
    public Lesson getLesson(String lid)
    {
        try {
            String sql ="select LessonId, videoLink, LessonsName, Content, StatusId, TopicId, LessonOder, s.Sname from Lessons l\n" +
"					join Status s on s.sid= l.StatusId where LessonId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lid);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Lesson l = new Lesson();
                Status s = new Status();
                l.setId(rs.getInt("LessonId"));
                l.setVideolink(rs.getString("videoLink"));
                l.setLessonname(rs.getString("LessonsName"));
                l.setContent(rs.getString("Content"));
                s.setId(rs.getInt("StatusId"));
                s.setName(rs.getString("Sname"));
                l.setTopicid(rs.getInt("TopicId"));
                l.setLessonorder(rs.getInt("LessonOder"));
                l.setStatus(s);
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public ArrayList<Lesson> getLessonListForSubjectLesson(String cid, int tid, String name, int sid) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            String sql = "select l.LessonId, l.LessonsName, l.StatusId, l.TopicId, l.LessonOder, s.sname\n" +
"                        from Lessons l join Topic t on t.Id=l.TopicId\n" +
"                        join Status s on s.Sid = l.StatusId\n" +
"                        join Courses c on c.CourseId = t.CourseId\n" +
"                        where c.CourseId=?";

            if (sid>-1) {
                sql += " and l.StatusId = "+ sid;
            }
            if (tid>-1) {
                sql += " and TopicId = " + tid;
            }
            if( name!= null){
                sql += " and LessonsName like ?";
            }

            
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cid);
            if(name!=null){
                
                stm.setString(2, "%"+ name +"%");
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                Status s = new Status();
                l.setId(rs.getInt("LessonId"));
                l.setLessonname(rs.getString("LessonsName"));
                l.setLessonorder(rs.getInt("LessonOder"));
                s.setId(rs.getInt("StatusId"));
                s.setName(rs.getString("sname"));
                l.setStatus(s);
                lessons.add(l);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessons;
    }
    public void updateStatusForLesson(int lid, int sid)
    {
        String sql = "UPDATE [Lessons]\n" +
"                       SET [StatusId] = ?\n" +
"                     WHERE [LessonId] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(2, lid);
            if(sid==1){
                stm.setInt(1,2);
            }
            if(sid==2){
                stm.setInt(1,1);
            }
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /*Thuận 1:50 */
   public int courntLessonByCourse(int courseId) {

        try {
            String sql = "SELECT COUNT(*) \n"
                    + "FROM     Lessons INNER JOIN\n"
                    + "                  Topic ON Lessons.TopicId = Topic.Id INNER JOIN\n"
                    + "                  Courses ON Topic.CourseId = Courses.CourseId\n"
                    + "				  where Courses.CourseId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, courseId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
   public ArrayList<Lesson> getLessonListForSubjectLesson1(String cid, int tid, String name, int sid, int pageIndex, int pageSize ) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            String sql = "select * from ( select ROW_NUMBER() OVER(order by l.lessonId asc) as row_index, \n" +
                    " l.LessonId, l.LessonsName, l.StatusId, l.TopicId, l.LessonOder, s.sname \n" +
                    " from Lessons as l inner join Topic as t on t.Id=l.TopicId\n" +
                    "join Status s on s.Sid = l.StatusId\n" +
                    "join Courses c on c.CourseId = t.CourseId\n" +
                    " And c.CourseId=? ";
            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 1;
            if(tid != -1){
                sql += "And t.Id = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = tid;
                parameters.put(paramIndex, param);
            }
            if(sid != -1){
                sql += "And l.StatusId =  ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = sid;
                parameters.put(paramIndex, param);
            }
            if(name != null){
                sql += "And l.LessonsName like '%' + ? + '%' ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = name;
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
            stm.setString(1, cid);
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
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                Status s = new Status();
                l.setId(rs.getInt("LessonId"));
                l.setLessonname(rs.getString("LessonsName"));
                l.setLessonorder(rs.getInt("LessonOder"));
                s.setId(rs.getInt("StatusId"));
                s.setName(rs.getString("sname"));
                l.setStatus(s);
                lessons.add(l);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessons;
    }
    public int countLessonListForSubjectLesson1(String cid, int tid, String name, int sid){
        try {
            String sql = "select Count(*) as Total from ( select ROW_NUMBER() OVER(order by l.lessonId asc) as row_index, \n" +
                            " l.LessonId, l.LessonsName, l.StatusId, l.TopicId, l.LessonOder, s.sname \n" +
                            " from Lessons as l inner join Topic as t on t.Id=l.TopicId\n" +
                            "join Status s on s.Sid = l.StatusId\n" +
                            "join Courses c on c.CourseId = t.CourseId\n" +
                            " And c.CourseId=? ";
            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int paramIndex = 1;
            if(tid != -1){
                sql += "And t.Id = ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = tid;
                parameters.put(paramIndex, param);
            }
            if(sid != -1){
                sql += "And s.Sid =  ? ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = Integer.class.getTypeName();
                param[1] = sid;
                parameters.put(paramIndex, param);
            }
            
            if(name != null){
                sql += "And l.LessonsName like '%' + ? + '%' ";
                paramIndex++;
                Object[] param = new Object[2];
                param[0] = String.class.getTypeName();
                param[1] = name;
                parameters.put(paramIndex, param);
            }
            
            sql += ") as tbl"; 
            PreparedStatement stm = connection.prepareStatement(sql); 
            stm.setString(1, cid);
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
            }
            ResultSet rs = stm.executeQuery(); 
            while(rs.next()){
                return rs.getInt("Total");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    /*
     Dat inter 3
    */
    public void INSERTLessonDetail(String videoLink, String LessonsName,
            String Content, int StatusId, int TopicId, int LessonOder, String LessonType) {
        try {
            String sql = "INSERT INTO [Lessons]\n"
                    + "           ([videoLink]\n"
                    + "           ,[LessonsName]\n"
                    + "           ,[Content]\n"
                    + "           ,[StatusId]\n"
                    + "           ,[TopicId]\n"
                    + "           ,[LessonOder]\n"
                    + "           ,[LessonType])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, videoLink);
            stm.setString(2, LessonsName);
            stm.setString(3, Content);
            stm.setInt(4, StatusId);
            stm.setInt(5, TopicId);
            stm.setInt(6, LessonOder);
            stm.setString(7, LessonType);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateLessonDetail(String lid, String videoLink, String LessonsName,
            String Content, int StatusId, int TopicId, int LessonOder, String LessonType) {
        try {
            String sql = "UPDATE [Lessons] \n"
                    + "   SET [videoLink] = ?\n"
                    + "      ,[LessonsName] = ?\n"
                    + "      ,[Content] = ?\n"
                    + "      ,[StatusId] = ?\n"
                    + "      ,[TopicId] = ?\n"
                    + "      ,[LessonOder] = ?\n"
                    + "      ,[LessonType] = ?\n"
                    + " WHERE [Lessons].LessonId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, videoLink);
            stm.setString(2, LessonsName);
            stm.setString(3, Content);
            stm.setInt(4, StatusId);
            stm.setInt(5, TopicId);
            stm.setInt(6, LessonOder);
            stm.setString(7, LessonType);
            stm.setString(8, lid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
