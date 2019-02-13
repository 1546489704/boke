package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.CommentsDao;
import com.csdj.entity.Comments;
import com.csdj.entity.Posts;
import com.csdj.entity.User;
import com.csdj.util.Page;
import javax.xml.stream.events.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CommentsDaoImpl  implements CommentsDao {
    /**
     * 添加评论
     * @param Comments
     * @return
     */
    public int addComments(Connection connection,Comments Comments) throws SQLException {
        //初始化预编译
        PreparedStatement pstm=null;
        //定义一个变量返回int值
        int result=0;
        if(null!=connection) {
            //定义Object类型的List集合 1
            List<Object> obj = new ArrayList<Object>();
            obj.add(Comments.getPostID());
            obj.add(Comments.getCommentText());
            obj.add(Comments.getpID());
            obj.add(Comments.getpTime());
            //编写添加sql  //2
            String sql = "INSERT INTO Comments (postid,commentText,pid,pTime) VALUES(?,?,?,?)";
            //调用通用增删改方法  //3
            result = BaseDao.executeUpdate(connection, pstm, sql, obj);
            //调用BaseDao中的关闭数据库连接方法 //4
            BaseDao.closeResource(connection,pstm,null);
        }
        return result;
    }

    /**
     * 查看全部评论
     * @return
     */
    public List<Comments> listComments(Connection connection,Comments comments,Page page) throws SQLException {
        ResultSet rs=null;
        //初始化预编译 //5
        PreparedStatement pstm=null;
        List<Comments> commentsList=new ArrayList<Comments>();
        if(null!=connection) {
            //定义Object类型的List集合
            List<Object> obj = new ArrayList<Object>();
            //定义User实体类的List集合
            List<User> userList = new ArrayList<User>();
            //编写查询sql
            String sql = "SELECT `cid`,`postid`,b.`prcture`,`commentText`,b.`uname`,`pTime`  FROM `Comments` AS a,`users` AS b WHERE a.`pid`=b.`uid` AND a.`postid`=? order  by  `pTime`  desc";
            sql += " limit ?,?";
            //
            int str = (page.getCurrPageNo() - 1) * page.getPageSize();
            //向obj里添加getPostID
            obj.add(comments.getPostID());
            //把str添加到obj里
            obj.add(str);
            //页大小
            obj.add(page.getPageSize());
            //调用aseDao中查询通用方法 //8
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, obj);
            while (rs.next()) {
                //创建Comments对象
                Comments cs = new Comments();
                //创建User对象
                User user = new User();
                cs.setcID(rs.getInt(1));
                cs.setPostID(rs.getInt(2));
                user.setPrcture(rs.getString(3));
                cs.setCommentText(rs.getString(4));
                user.setuName(rs.getString(5));
                cs.setpTime(rs.getString(6));
                userList.add(user);
                cs.setUserList(userList);
                commentsList.add(cs);
            }
            //调用BaseDao中的关闭数据库连接方法
            BaseDao.closeResource(connection,pstm,rs);
        }
        return commentsList;
    }

    /**
     * 评论条数
     * @return
     */
    public int CommentCount(Connection connection,Comments comments) throws SQLException {
        int sum =0;
        ResultSet rs=null;
        //初始化预编译
        PreparedStatement pstm=null;
        if(null!=connection) {
            //定义Object类型的List集合
            List<Object> obj = new ArrayList<Object>();
            obj.add(comments.getPostID());
            //编写查询统计条数
            String sql = "SELECT COUNT(1) FROM comments WHERE postid=?";
            //调用BaseDao中通用增删改方法
            rs = BaseDao.executeQuery(connection,pstm,rs,sql,obj);
            if (rs.next()) {
                sum = rs.getInt(1);
            }
            //调用BaseDao中的关闭数据库连接方法
            BaseDao.closeResource(connection,pstm,rs);
        }
        return sum;
    }

    /**
     * 删除评论
     * @param connection
     * @param comments
     * @return
     */
    @Override
    public int deletComment(Connection connection, Comments comments) throws SQLException{
        int result=0;
        //初始化预编译
        PreparedStatement pstm=null;
        if (null!=connection){
            //定义Object类型的List集合
            List<Object> obj=new ArrayList<Object>();
            obj.add(comments.getcID());
            //编写删除sql
            String sql="DELETE FROM comments WHERE `cid`=?";
            result=BaseDao.executeUpdate(connection,pstm,sql,obj);
        }
            //调用BaseDao中的关闭数据库连接方法
            BaseDao.closeResource(connection,pstm,null);
        return result;
    }

    /**
     * 后台查询全部评论
     * @param connection
     * @return
     */
    @Override
    public List<Comments> htshowComments(Connection connection,int currPageNo,int pageSize) throws SQLException{
        ResultSet rs=null;
        //初始化预编译
        PreparedStatement pstm=null;
        //定义Comments实体类的List集合
        List<Comments> list =new ArrayList<Comments>();
        //定义Posts实体类的List集合
        List<Posts> postsList=new ArrayList<Posts>();
        //定义User实体类的List集合
        List<User> userList=new ArrayList<User>();
        //定义Object类型的List集合
        List<Object> obj=new ArrayList<Object>();
        if(null!=connection) {
            //编写查询sql
            String sql = " SELECT  a.`cid`,c.`type`,a.`commentText`,b.`uname`,a.`pTime` FROM `comments` AS a,`users` AS b,`posts` AS c  WHERE   a.pid=b.uid  AND  a.postid=c.postid ORDER BY `pTime` DESC ";
            sql+= "  LIMIT ?,?";
            //分页分批显示
            int str = (currPageNo - 1) * pageSize;
            //把str添加到obj里
            obj.add(str);
            //页大小
            obj.add(pageSize);
            //调用BaseDao中通用增删改方法
            rs = BaseDao.executeQuery(connection,pstm,rs,sql,obj);
            while (rs.next()){
                Comments comments=new Comments();
                Posts posts=new Posts();
                User user=new User();
                comments.setcID(rs.getInt(1));
                posts.setType(rs.getString(2));
                comments.setCommentText(rs.getString(3));
                user.setuName(rs.getString(4));
                comments.setpTime(rs.getString(5));
                postsList.add(posts);
                userList.add(user);
                comments.setUserList(userList);
                comments.setPostType(postsList);
                //用list对象
                list.add(comments);
            }
            //调用BaseDao中的关闭数据库连接方法
            BaseDao.closeResource(connection,pstm,rs);
        }
        return list;
    }
    /**
     * 后台评论条数
     * @return
     */
    public int htCommentCount(Connection connection) throws SQLException {
        int sum =0;
        ResultSet rs=null;
        //初始化预编译
        PreparedStatement pstm=null;
        if(null!=connection) {
            //定义Object类型的List集合
            List<Object> obj = new ArrayList<Object>();
            //编写查询统计条数
            String sql = "SELECT COUNT(1) FROM comments";
            rs = BaseDao.executeQuery(connection,pstm,rs,sql,obj);
            if (rs.next()) {
                sum = rs.getInt(1);
            }
            //调用BaseDao中的关闭数据库连接方法
            BaseDao.closeResource(connection,pstm,rs);
        }
        return sum;
    }

    /**
     * 更新评论
     * @param connection
     * @param comments
     * @return
     * @throws SQLException
     */
    @Override
    public int updateComments(Connection connection, Comments comments) throws SQLException {
        int result=0;
        //初始化预编译
        PreparedStatement ptstm=null;
        //定义Object类型的List集合
        List<Object> obj=new ArrayList<Object>();
        if (null!=connection) {
            obj.add(comments.getCommentText());
            obj.add(comments.getpTime());
            obj.add(comments.getcID());
            //编写更新sql
            String sql = "UPDATE  comments SET commentText=?, pTime=?  WHERE cid=?";
            //调用BaseDao中通用增删改方法
            result=BaseDao.executeUpdate(connection,ptstm,sql,obj);
        }
            //调用BaseDao中的关闭数据库连接方法
            BaseDao.closeResource(connection,ptstm,null);
        return result;
    }
}
