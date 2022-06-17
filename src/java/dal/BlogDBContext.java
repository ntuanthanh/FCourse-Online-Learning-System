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

/**
 *
 * @author jicon
 */
public class BlogDBContext extends DBContext {
    
//    public ArrayList<Blog> getBlogForHome() {
//        ArrayList<Blog> blogs = new ArrayList<>();
//        try {
//            String sql = "SELECT top(3) Blog.*, Category.value, [user].fullname\n"
//                    + "FROM     Blog INNER JOIN\n"
//                    + "                  Category ON Blog.CategoryId = Category.Categoryid\n"
//                    + "				  inner join [User] on  [User].Userid = Blog.UserId\n"
//                    + "				  where Blog.StatusId=1 \n"
//                    + "				  order by createdate desc ";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Blog b = new Blog();
//                b.setId(rs.getInt(1));
//                b.setBrief(rs.getString(2));
//                b.setContent(rs.getString(2));
//                b.setThumbnail(rs.getString(4));
//                b.setCreatedate(rs.getDate(5));
//                
//                b.setTitle(rs.getString(6));
//                
//                Category ca = new Category();
//                ca.setCategoryID(rs.getInt(7));
//                ca.setValue(rs.getString(10));
//                b.setCategory(ca);
//                User u = new User();
//                u.setId(rs.getInt(9));
//                u.setFullName(rs.getString(11));
//                
//                b.setUser(u);
//                blogs.add(b);
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return blogs;
//    }
    
     public ArrayList<Blog> getBlogs(String bid)
    {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            
            String sql ="select top(6) b.id, b.brief, b.createdate, b.Thumbnail, b.Title, b.CategoryId, b.StatusId, b.UserId, u.fullname\n" +
                        "from Blog b inner join [User] u on u.UserId= b.UserId where b.statusId=1 and b.id!=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, bid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Blog b = new Blog();
                User u = new User();
                b.setId(rs.getInt("id"));
                b.setCreatedate(rs.getDate("createdate"));
                b.setBrief(rs.getString("brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setTitle(rs.getString("title"));
                b.setCategoryId(rs.getInt("CategoryId"));
                b.setStatusId(rs.getInt("StatusId"));
                u.setFullName(rs.getString("fullname"));
                b.setUser(u);
                blogs.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }
    //select blog by BlogId
    public Blog getBlog(String bid)
    {
        try {
            String sql ="select b.id, b.brief, b.Thumbnail, b.featured, b.content, b.Title, b.CategoryId, b.StatusId, b.UserId, u.fullname, c.value, b.createdate\n" +
"                        from Blog b inner join [User] u on u.UserId= b.UserId\n" +
"                        inner join Category c on b.CategoryId= c.Categoryid\n" +
"                        where b.id = ? and  b.StatusId=1";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, bid);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Blog b = new Blog();
                User u = new User();
                Category c = new Category();
                b.setId(rs.getInt("id"));
                b.setFeature(rs.getBoolean("featured"));
                b.setBrief(rs.getString("brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setContent(rs.getString("content"));
                b.setTitle(rs.getString("title"));
                b.setCategoryId(rs.getInt("CategoryId"));
                b.setStatusId(rs.getInt("StatusId"));
                u.setFullName(rs.getString("fullname"));
                c.setValue(rs.getString("value"));
                b.setUser(u);
                b.setCreatedate(rs.getDate("createdate"));
                b.setCategory(c);
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public Blog getBlogForMK(String bid)
    {
        try {
            String sql ="select b.id, b.brief, b.Thumbnail, b.featured, b.content, b.Title, b.CategoryId, b.StatusId, b.UserId, u.fullname, c.value, b.createdate\n" +
"                        from Blog b inner join [User] u on u.UserId= b.UserId\n" +
"                        inner join Category c on b.CategoryId= c.Categoryid\n" +
"                        where b.id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, bid);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                Blog b = new Blog();
                User u = new User();
                Category c = new Category();
                b.setId(rs.getInt("id"));
                b.setFeature(rs.getBoolean("featured"));
                b.setBrief(rs.getString("brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setContent(rs.getString("content"));
                b.setTitle(rs.getString("title"));
                b.setCategoryId(rs.getInt("CategoryId"));
                b.setStatusId(rs.getInt("StatusId"));
                u.setFullName(rs.getString("fullname"));
                c.setValue(rs.getString("value"));
                b.setUser(u);
                b.setCreatedate(rs.getDate("createdate"));
                b.setCategory(c);
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public ArrayList<Blog> getLatestBlogForHome() {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "SELECT top(6) Blog.Id, Blog.Brief, Blog.Thumbnail, Blog.Title, Blog.CategoryId, Blog.StatusId, Blog.UserId, Blog.createdate, Category.value, [user].fullname\n" +
"                    FROM     Blog INNER JOIN\n" +
"                                      Category ON Blog.CategoryId = Category.Categoryid\n" +
"                    				  inner join [User] on  [User].Userid = Blog.UserId\n" +
"                    				  where Blog.StatusId=1 \n" +
"                    				  order by createdate desc ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("Id"));
                b.setBrief(rs.getString("Brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setCreatedate(rs.getDate("createdate"));
                
                b.setTitle(rs.getString("title"));
                
                Category ca = new Category();
                ca.setCategoryID(rs.getInt("CategoryId"));
                ca.setValue(rs.getString("Value"));
                b.setCategory(ca);
                User u = new User();
                u.setId(rs.getInt("UserId"));
                u.setFullName(rs.getString("fullname"));
                
                b.setUser(u);
                blogs.add(b);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }
    public ArrayList<Blog> getBlogForHome() {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "SELECT top(3) Blog.Id, Blog.Brief, Blog.Thumbnail, Blog.Title, Blog.CategoryId, Blog.StatusId, Blog.UserId, Blog.createdate, Category.value, [user].fullname\n" +
"                    FROM     Blog INNER JOIN\n" +
"                                      Category ON Blog.CategoryId = Category.Categoryid\n" +
"                    				  inner join [User] on  [User].Userid = Blog.UserId\n" +
"                    				  where Blog.StatusId=1 \n" +
"                    				  order by createdate desc ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("Id"));
                b.setBrief(rs.getString("Brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setCreatedate(rs.getDate("createdate"));
                
                b.setTitle(rs.getString("title"));
                
                Category ca = new Category();
                ca.setCategoryID(rs.getInt("CategoryId"));
                ca.setValue(rs.getString("Value"));
                b.setCategory(ca);
                User u = new User();
                u.setId(rs.getInt("UserId"));
                u.setFullName(rs.getString("fullname"));
                
                b.setUser(u);
                blogs.add(b);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }
    public ArrayList<Blog> getBlogList(int[] cid, String name, int pageindex, int pagesize) {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM\n"
                    + "            (SELECT Blog.Id, Blog.Brief,createdate ,Blog.Thumbnail, Blog.Title, Category.Categoryid, Category.value, Blog.UserId, [User].fullname  ,ROW_NUMBER() OVER (ORDER BY Blog.createdate DESC) as row_index  \n"
                    + "			FROM     Blog INNER JOIN\n"
                    + "                  Category ON Blog.CategoryId = Category.Categoryid\n"
                    + "				  inner join [User] on [User].Userid = Blog.UserId\n"
                    + "				  where Blog.StatusId=1 ";

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

            if (name != null) {
                sql += " and Category.value like ? ";
            }
            sql += ") tbl\n"
                    + "            WHERE row_index >= (?-1)*? + 1 \n"
                    + "                    AND row_index <= ?* ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            if (name != null) {
                stm.setString(1, "%" + name + "%");
                stm.setInt(2, pageindex);
                stm.setInt(3, pagesize);
                stm.setInt(4, pageindex);
                stm.setInt(5, pagesize);
            } else {
                stm.setInt(1, pageindex);
                stm.setInt(2, pagesize);
                stm.setInt(3, pageindex);
                stm.setInt(4, pagesize);
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("Id"));
                b.setBrief(rs.getString("Brief"));
                b.setThumbnail(rs.getString("Thumbnail"));
                b.setCreatedate(rs.getDate("createdate"));
                b.setTitle(rs.getString("Title"));
                
                Category ca = new Category();
                ca.setCategoryID(rs.getInt("Categoryid"));
                ca.setValue(rs.getString("value"));
                b.setCategory(ca);
                User u = new User();
                u.setId(rs.getInt("UserId"));
                u.setFullName(rs.getString("fullname"));

                b.setUser(u);
                blogs.add(b);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }

    public int CountBlogList(int[] cid, String name, int pageindex, int pagesize) {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "SELECT Count(*) FROM\n"
                    + "            (SELECT Blog.Id, Blog.Brief, Blog.Thumbnail, Blog.Title, Category.Categoryid, Category.value, Blog.UserId, [User].fullname  ,ROW_NUMBER() OVER (ORDER BY Blog.createdate DESC) as row_index  \n"
                    + "			FROM     Blog INNER JOIN\n"
                    + "                  Category ON Blog.CategoryId = Category.Categoryid\n"
                    + "				  inner join [User] on [User].Userid = Blog.UserId\n"
                    + "				  where Blog.StatusId=1 ";

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

            if (name != null) {
                sql += " and Category.value like ? ";
            }
            sql += ") tbl\n";
                    
            PreparedStatement stm = connection.prepareStatement(sql);
            if (name != null) {
                stm.setString(1, "%" + name + "%");
          
            }

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public void insertBlog(Blog b)
    {
        String sql = "INSERT INTO [dbo].[Blog]\n" +
        "           ([Brief]\n" +
        "           ,[Thumbnail]\n" +
        "           ,[Title]\n" +
        "           ,[CategoryId]\n" +
        "           ,[StatusId]\n" +
        "           ,[UserId]\n" +
        "           ,[createdate]\n" +
        "           ,[content]\n" +
        "           ,[featured])\n" +
        "     VALUES\n" +
        "           (?\n" +
        "           ,?\n" +
        "           ,?\n" +
        "           ,?\n" +
        "           ,?\n" +
        "           ,?\n" +
        "           ,?\n" +
        "           ,?\n" +
        "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, b.getBrief());
            stm.setString(2, b.getThumbnail());
            stm.setString(3, b.getTitle());
            stm.setInt(4, b.getCategory().getCategoryID());
            stm.setInt(5, b.getStatusId());
            stm.setDate(6, b.getCreatedate());
            stm.setString(7, b.getContent());
            stm.setBoolean(8, b.isFeature());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void editBlog(Blog b)
    {
        String sql = "UPDATE [Blog]\n" +
            "   SET [Brief] = ?\n" +
            "      ,[Thumbnail] = ?\n" +
            "      ,[Title] = ?\n" +
            "      ,[CategoryId] = ?\n" +
            "      ,[StatusId] = ?\n" +
            "      ,[content] = ?\n" +
            "      ,[featured] = ?\n" +
            " WHERE Id = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, b.getBrief());
            stm.setString(2, b.getThumbnail());
            stm.setString(3, b.getTitle());
            stm.setInt(4, b.getCategoryId());
            stm.setInt(5, b.getStatusId());
            stm.setString(6, b.getContent());
            stm.setBoolean(7, b.isFeature());
                        stm.setInt(8, b.getId());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void addBlog(Blog b)
    {
        String sql = "INSERT INTO [dbo].[Blog]\n" +
                    "           ([Brief]\n" +
                    "           ,[Thumbnail]\n" +
                    "           ,[Title]\n" +
                    "           ,[CategoryId]\n" +
                    "           ,[StatusId]\n" +
                    "           ,[UserId]\n" +
                    "           ,[createdate]\n" +
                    "           ,[content]\n" +
                    "           ,[featured])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, b.getBrief());
            stm.setString(2, b.getThumbnail());
            stm.setString(3, b.getTitle());
            stm.setInt(4, b.getCategoryId());
            stm.setInt(5, b.getStatusId());
            stm.setInt(6, b.getUser().getId());
            stm.setDate(7, b.getCreatedate());
            stm.setString(8, b.getContent());
            stm.setBoolean(9, b.isFeature());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
            {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(connection !=null)
            {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //Nghia dep trai da cope o day
    public boolean doesExistImgNameBlog(String name){
       try {
           String sql = "select * from Blog where thumbnail like ?";
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
    public static void main(String[] args){
        BlogDBContext a = new BlogDBContext();
        ArrayList<Blog> blogs = a.getBlogForHome();
        System.out.println(blogs.size());
        
        
//        ArrayList<Serie> list = a.getSeriesViews();
//        for(Serie s: list){
//            System.out.println(s);
//        }
//        Serie b = a.getSerie("1");
////        int s = a.getSid();
//        System.out.println(b);
    }
}
