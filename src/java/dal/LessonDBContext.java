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
}
