package com.csdj.dao.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.CommentBackMapper.CommentBackMapper;
import com.csdj.entity.CommentBack;
import com.csdj.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 回复评论类
 */
public class CommentBackDaoImpl implements CommentBackMapper {

    /**
     * 查询回复的评论
     *
     */
    public List<CommentBack> CommentBackShow(Connection connection,int postid,String sName,String fName,int plId) throws SQLException {
        ResultSet rs=null;
        PreparedStatement pstm=null;
        List<CommentBack> commentBacksList=new ArrayList<CommentBack>();
        if(null!=connection) {
            List<Object> obj = new ArrayList<Object>();
            List<User> userList = new ArrayList<User>();
            obj.add(postid);
            obj.add(sName);
            obj.add(fName);
            obj.add(plId);
            String sql = "SELECT b.uname,d.`postid`,a.`content`,c.`uname`,a.`hTime` FROM `commentback` AS a,`users` AS b,`users` AS c ,`comments` AS d\n" +
                    " WHERE a.`sid`=b.`uid` AND c.`uid`=a.`pid` AND  d.cId=a.cid AND a.`postid`=？ AND b.uname=？ AND c.uname=？\n" +
                    " AND a.cid=？";
            rs = BaseDao.executeQuery(connection, pstm, rs, sql, obj);
            while (rs.next()) {
                CommentBack cb = new CommentBack();
                User user = new User();
                cb.sethID(rs.getInt(1));
                user.setuName(rs.getString(2));
                cb.setPostID(rs.getInt(3));
                user.setuName(rs.getString(4));
                cb.sethTime(rs.getString(5));
                userList.add(user);
                cb.setUserList(userList);
                commentBacksList.add(cb);
            }
            BaseDao.closeResource(null,pstm,rs);
        }

        return commentBacksList;
    }


    //添加回复评论
    @Override
    public int addCommentBack(Connection connection,CommentBack commentBack) throws SQLException {
        int result=0;
        PreparedStatement pstm=null;
        if(null!=connection) {
            List<Object> obj = new ArrayList<Object>();
            List<User> userList = new ArrayList<User>();
            obj.add(commentBack);
                String sql = "INSERT INTO commentback (sid,postid,content,pid,htime) VALUES(?,?,?,?,?)";
                result = BaseDao.executeUpdate(connection, pstm, sql, obj);
               BaseDao.closeResource(null,pstm,null);
        }
        return result;
    }

    /**
     * 删除评论中回复
     * @param connection
     * @param commentBack
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteCommentBack(Connection connection, CommentBack commentBack) throws SQLException {
        int result=0;
        PreparedStatement pstm=null;
        List<Object> obj=new ArrayList<Object>();
        List<CommentBack>list=new ArrayList<CommentBack>();
        String sql="";
        try{
            sql+="DELETE FROM commentback WHERE `cid`=?";
            result=BaseDao.executeUpdate(connection, pstm, sql, obj);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(null,pstm,null);
        }
        return result;
    }
}
