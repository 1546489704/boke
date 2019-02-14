package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.CommentsMapper.CommentsMapper;
import com.csdj.dao.Impl.CommentsDaoImpl;
import com.csdj.entity.Comments;
import com.csdj.service.CommentsServiceDao;
import com.csdj.util.DataBaseUtil;
import com.csdj.util.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 评论业务层
 */
public class CommentsServiceDaoImpl implements CommentsServiceDao {
   private CommentsMapper commentsDao;
   public CommentsServiceDaoImpl(){
       commentsDao=new CommentsDaoImpl();
   }
    /**
     * 发表评论
     */
    @Override
    public int addComments(Comments comments) {
        //创建Connection对象
        Connection connection=null;
        int result=0;
        try {
            //调用BaseDao类中的getConnection()获取数据库连接
            connection= BaseDao.getConnection();
            //调用Dao层方法
            result=commentsDao.addComments(connection,comments);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(connection,null,null);
        }
        return result;
    }

    /**
     * 查看全部评论
     */
    public List<Comments> listComments(Comments comments,Page page) {
        //创建Connection对象
        Connection connection=null;
        List<Comments> commentsList=new ArrayList<Comments>();
        try {
            //调用BaseDao类中的getConnection()获取数据库连接
            connection=BaseDao.getConnection();
            //调用Dao层方法
            commentsList=commentsDao.listComments(connection,comments,page);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(connection,null,null);
        }
        return commentsList;
    }

    /**
     * 统计评论条数
     * @param comments
     * @return
     */
    @Override
    public int CommentCount(Comments comments) {
        //创建Connection对象
        Connection connection=null;
        int result=0;
        try {
            //调用BaseDao类中的getConnection()获取数据库连接
            connection= BaseDao.getConnection();
            //调用Dao层方法
            result=commentsDao.CommentCount(connection,comments);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(connection,null,null);
        }
        return result;
    }

    /**
     * 删除评论
     * @param comments
     * @return
     */
    @Override
    public int deletComment(Comments comments) {
        //创建Connection对象
        Connection conn=null;
        int result=0;
        try{
            //调用BaseDao类中的getConnection()获取数据库连接
            conn=BaseDao.getConnection();
            result=commentsDao.deletComment(conn,comments);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(conn,null,null);
        }
        return result;
    }

    /**
     * 后台查询所有评论
     */
    public List<Comments> htshowComments(int currPageNo,int pageSize){
        //创建Connection对象
        Connection conn=null;
        List<Comments> commentsList=new ArrayList<Comments>();
        try{
            //调用BaseDao类中的getConnection()获取数据库连接
            conn=DataBaseUtil.getConnection();
            commentsList=commentsDao.htshowComments(conn,currPageNo,pageSize);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(conn,null,null);
        }
        return commentsList;
    }
    /**
     * 统计评论条数
     */
    public int htCommentCount() {
        //创建Connection对象
        Connection conn=null;
        int result=0;
        try {
            //调用BaseDao类中的getConnection()获取数据库连接
            conn= BaseDao.getConnection();
            result= commentsDao.htCommentCount(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(conn,null,null);
        }
        return result;
    }

    /**
     * 更新评论
     * @param comments
     * @return
     */
    @Override
    public int updateCommnets(Comments comments) {
        int result=0;
        //创建Connection对象
        Connection conn=null;
        try{
            //调用BaseDao类中的getConnection()获取数据库连接
            conn=BaseDao.getConnection();
            result=commentsDao.updateComments(conn,comments);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭连接
            BaseDao.closeResource(conn,null,null);
        }
        return result;
    }

}
