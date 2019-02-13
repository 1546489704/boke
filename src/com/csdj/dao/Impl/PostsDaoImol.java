package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.PostsDao;
import com.csdj.entity.Posts;
import com.csdj.entity.User;
import com.csdj.entity.photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 帖子的增删改查DAO
 */
public class PostsDaoImol  implements PostsDao {

    /**
     * 查询风风的所有帖子
     * @return
     */
    public List<Posts> QueryPosts(Connection connection, int currPageNo, int pageSize) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pstm=null;
        List<Object> list2 = new ArrayList<Object>();
        List<Posts> list = new ArrayList<Posts>();
        List<User> list1 = new ArrayList<User>();
        int ss=(currPageNo-1)*pageSize;
        list2.add(ss);
        list2.add(pageSize);
        if(null!=connection) {
            String sql = "SELECT a.`postId`,a.`type`,b.`uname`,a.`content`,a.`postingTime`,a.`click`,a.`like`,a.`picture` FROM `posts` AS a ,`users` AS b WHERE a.`uId`=b.`uId`AND a.uId=4  ORDER BY `postingTime` DESC LIMIT ?,?";
            rs =BaseDao.executeQuery(connection, pstm, rs, sql, list2);
            while (rs.next()) {
                Posts ps = new Posts();
                User us = new User();
                ps.setPostId(rs.getInt(1));
                ps.setType(rs.getString(2));
                us.setuName(rs.getString(3));
                list1.add(us);
                ps.setUser(list1);
                ps.setContent(rs.getString(4));
                ps.setPostingTime(rs.getDate(5));
                ps.setClick(rs.getInt(6));
                ps.setLike(rs.getInt(7));
                ps.setPicture(rs.getString(8));
                list.add(ps);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return list;
    }

    /**
     * 按id查询
     * @param id
     * @return
     */
    public List<Posts> QueryPos(Connection connection,int id) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pstm=null;
        List<Object> list2 = new ArrayList<Object>();
        List<Posts> list = new ArrayList<Posts>();
        List<User> list1 = new ArrayList<User>();
        list2.add(id);
        if(null!=connection) {
            String sql = "SELECT a.`postId`,a.`type`,b.`uname`,a.`content`,a.`postingTime`,a.`click`,a.`like`,a.`picture` FROM `posts` AS a ,`users` AS b WHERE a.`uId`=b.`uId` AND b.`uname`='风风' AND postId=?";
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, list2);
            if (rs.next()) {
                Posts ps = new Posts();
                User us = new User();
                ps.setPostId(rs.getInt(1));
                ps.setType(rs.getString(2));
                us.setuName(rs.getString(3));
                list1.add(us);
                ps.setUser(list1);
                ps.setContent(rs.getString(4));
                ps.setPostingTime(rs.getDate(5));
                ps.setClick(rs.getInt(6));
                ps.setLike(rs.getInt(7));
                ps.setPicture(rs.getString(8));
                list.add(ps);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return list;
    }

    /**
     * 按id更新点击率
     * @param id
     * @param click
     */
    public void UpdatePosts(Connection connection,int id, int click) throws SQLException {
        PreparedStatement pstm=null;
        List<Object> list =new ArrayList<Object>();
        list.add(click);
        list.add(id);
        if(null!=connection) {
            String sql = "UPDATE posts SET click =? WHERE  postId=?";
            BaseDao.executeUpdate(connection, pstm, sql, list);
            BaseDao.closeResource(null,pstm,null);
        }
    }

    /**
     * 按id更改点赞数据
     * @param id
     * @param like
     */
    public void Updatepos(Connection connection,int id, int like) throws SQLException {
        PreparedStatement pstm=null;
        List<Object> list =new ArrayList<Object>();
        list.add(like);
        list.add(id);
        if(null!=connection) {
            String sql = "UPDATE posts SET `like`=? WHERE postId=?";
            BaseDao.executeUpdate(connection, pstm, sql, list);
            BaseDao.closeResource(null,pstm,null);
        }
    }

    /**
     * 查询所有图片 分页
     */
    public List<photo> QueryPhoto(Connection connection) throws SQLException {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<photo> list1=new ArrayList<photo>();
        List<Object> list=new ArrayList<Object>();
      if(null!=connection) {
        String sql = "SELECT id, uid,photo,`describe`,`time` FROM Photo ";
        rs = BaseDao.executeQuery(connection, pstm, rs, sql, list);
        while (rs.next()) {
            photo ph = new photo();
            ph.setPhId(rs.getInt("id"));
            ph.setUid(rs.getInt("uid"));
            ph.setPicture(rs.getString("photo"));
            ph.setIntroduce(rs.getString("describe"));
            ph.setDate(rs.getString("time"));
            list1.add(ph);
        }
        BaseDao.closeResource(null,pstm,rs);
    }
    return list1;
    }

    /**
     * 添加类容
     * @param connection
     * @param bt
     * @param nr
     * @param diz
     * @return
     * @throws SQLException
     */
    public int InnsertPhsts(Connection connection,String bt, String nr, String diz) throws SQLException {
        int i=0;
        PreparedStatement pstm=null;
        List<Object> list=new ArrayList<Object>();
        list.add(bt);
        list.add(nr);
        list.add(diz);
        String sql="INSERT INTO`posts`(`type`,`uId`,`content`,`postingTime`,`click`,`like`,`picture`)VALUE(?,4,?,NOW(),0,0,?)";
        i= BaseDao.executeUpdate(connection,pstm,sql,list);
        BaseDao.closeResource(null,pstm,null);
        return i;
    }

    public int Hdts(Connection connection) throws SQLException {
        int i=0;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Object> list=new ArrayList<Object>();
        String sql="SELECT COUNT(*) FROM posts WHERE uId=4 ";
        rs= BaseDao.executeQuery(connection,pstm,rs,sql,list);
        if(rs.next()){
        i=rs.getInt(1);
        }
        BaseDao.closeResource(null,pstm,rs);
        return i;
    }

    /**
     *  查询所有帖子不分页
     */
    public List<Posts> postsList(Connection connection) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pstm=null;
        List<Object> list2 = new ArrayList<Object>();
        List<Posts> list = new ArrayList<Posts>();
        List<User> list1 = new ArrayList<User>();
        if(null!=connection) {
            String sql = "SELECT a.`postId`,a.`type`,b.`uname`,a.`content`,a.`postingTime`,a.`click`,a.`like`,a.`picture` FROM `posts` AS a ,`users` AS b WHERE a.`uId`=b.`uId`AND a.uId=4  ORDER BY `postingTime` DESC";
            rs =BaseDao.executeQuery(connection, pstm, rs, sql, list2);
            while (rs.next()) {
                Posts ps = new Posts();
                User us = new User();
                ps.setPostId(rs.getInt(1));
                ps.setType(rs.getString(2));
                us.setuName(rs.getString(3));
                list1.add(us);
                ps.setUser(list1);
                ps.setContent(rs.getString(4));
                ps.setPostingTime(rs.getDate(5));
                ps.setClick(rs.getInt(6));
                ps.setLike(rs.getInt(7));
                ps.setPicture(rs.getString(8));
                list.add(ps);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return list;

    }

    /**
     * 删除帖子
     */
    public int postsSc(Connection connection, int id) throws SQLException {
        int i=0;
        PreparedStatement pstm=null;
        List<Object> list = new ArrayList<Object>();
        list.add(id);
        String sql="DELETE FROM `posts` WHERE `postId`=?";
        i=BaseDao.executeUpdate(connection,pstm,sql,list);
        BaseDao.closeResource(null,pstm,null);
        return i;
    }

    /**
     * 修改帖子
     */
    public int UpdPosts(Connection connection, String type, String con,int id) throws SQLException {
        int i=0;
        List<Object> list=new ArrayList<Object>();
        PreparedStatement pstm=null;
        list.add(type);
        list.add(con);
        list.add(id);
        String sql="UPDATE `posts` SET `type`=?,`content`=? WHERE `postId`=?";
        i=BaseDao.executeUpdate(connection,pstm,sql,list);
        BaseDao.closeResource(null,pstm,null);
        return i;
    }
}

