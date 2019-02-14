package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.CommentBackMapper.CommentBackMapper;
import com.csdj.dao.Impl.CommentBackDaoImpl;
import com.csdj.entity.CommentBack;
import com.csdj.service.CommentBackServiceDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentBackServiceImpl implements CommentBackServiceDao {
  private CommentBackMapper commentBackDao;
  public CommentBackServiceImpl(){
      commentBackDao=new CommentBackDaoImpl();
  }

    /**
     *查询回复评论
     * @param
     * @return
     */
    @Override
    public List<CommentBack> CommentBackShow(int postid,String sName,String fName,int plId) {
        Connection connection=null;
        List<CommentBack> commentBackList=new ArrayList<CommentBack>();
        try {
            connection= BaseDao.getConnection();
            commentBackList=commentBackDao.CommentBackShow(connection,postid,sName,fName,plId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentBackList;
    }
    /**
     *添加回复评论
     */
    @Override
    public int addCommentBack(CommentBack cBack) {
        Connection connection=null;
        int result=0;
        try {
            connection=BaseDao.getConnection();
            result=commentBackDao.addCommentBack(connection,cBack);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 删除回复评论
     */
    @Override
    public int deleteCommentBack(CommentBack commentBack) {
        Connection conn=null;
        int result=0;
        try{
            conn=BaseDao.getConnection();
            result=commentBackDao.deleteCommentBack(conn,commentBack);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn,null,null);
        }
        return result;
    }


}
