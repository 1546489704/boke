package com.csdj.service.Impl;

import com.csdj.dao.BaseDao;
import com.csdj.dao.Impl.PostsDaoImol;
import com.csdj.dao.PostsMapper.PostsMapper;
import com.csdj.entity.Posts;
import com.csdj.entity.photo;
import com.csdj.service.PostsServiceDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 帖子的实现类
 */
public class PostsServiceDaoImpl implements PostsServiceDao {
  private PostsMapper postsDao;
  public  PostsServiceDaoImpl(){
      postsDao=new PostsDaoImol();
  }

    /**
     * 按id查询帖子
     * @param id
     * @return
     */
    public List<Posts> QueryPosService(int id) {
       Connection connection=null;
       List<Posts> postsList=new ArrayList<Posts>();
        try {
            connection= BaseDao.getConnection();
          postsList =postsDao.QueryPos(connection,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //在service层关闭conn
            BaseDao.closeResource(connection,null,null);
        }
        return postsList;
    }

    /**
     * 查询所有帖子 并且分页
     * @param currPageNo
     * @param pageSize
     * @return
     */
    public List<Posts> QueryPostsService(int currPageNo,int pageSize) {
        Connection connection=null;
        List<Posts> postsList=new ArrayList<Posts>();
        try {
            connection= BaseDao.getConnection();
            postsList =postsDao.QueryPosts(connection,currPageNo,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //在service层关闭conn
            BaseDao.closeResource(connection,null,null);
        }
        return postsList;
    }

    /**
     * 按id修改
     * @param id
     * @param click
     */
    public void UpdatePostsService(int id, int click) {
        Connection connection=null;
        try {
            connection = BaseDao.getConnection();
            click = click + 1;
             postsDao.UpdatePosts(connection,id,click);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
  }

    /**
     * 按id修改
     * @param id
     * @param like
     */
    public void UpdatePosService(int id, int like) {
        Connection connection=null;
        try {
            connection = BaseDao.getConnection();
            like = like + 1;
            postsDao.Updatepos(connection,id,like);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
    }

    /**
     * 查找上一个
     * @param id
     * @return
     */
    public List<Posts> QueryShan(int id) {
        Connection connection=null;
        List<Posts> postsList=null;
        try {
            connection=BaseDao.getConnection();
            id=id-1;
            postsList=postsDao.QueryPos(connection,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return postsList;
    }

    /**
     * 查找下一个
     * @param id
     * @return
     */
    public List<Posts> QueryXia(int id) {
        Connection connection=null;
        List<Posts> postsList=null;
        try {
            connection=BaseDao.getConnection();
            id=id+1;
            postsList=postsDao.QueryPos(connection,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return postsList;
    }

    /**
     * 查询所有帖子
     * @return
     */
    public List<photo> QueryPhoto() {
        Connection connection=null;
        List<photo> postsList=new ArrayList<photo>();
        try {
            connection= BaseDao.getConnection();
            postsList =postsDao.QueryPhoto(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //在service层关闭conn
            BaseDao.closeResource(connection,null,null);
        }
        return postsList;
    }
    /**
     * 添加评论
     * @param bt
     * @param nr
     * @param diz
     * @return
     */
    public int InnsertPhsts(String bt, String nr, String diz) {
        int i=0;
        Connection connection=null;
        try{
            connection=BaseDao.getConnection();
            i=postsDao.InnsertPhsts(connection,bt,nr,diz);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return i;
    }

    /**
     * 查询条数
     * @return
     */
    public int Hdts() {
       int i=0;
       Connection connection=null;
       try{
           connection=BaseDao.getConnection();
           i=postsDao.Hdts(connection);
       }catch(Exception e){
           e.printStackTrace();
       }finally{
           BaseDao.closeResource(connection,null,null);
        }
        return i;
    }

    /**
     * 查询帖子
     * @return
     */
    public List<Posts> postsList() {
        Connection connection=null;
        List<Posts> postsList=new ArrayList<Posts>();
        try {
            connection= BaseDao.getConnection();
            postsList =postsDao.postsList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //在service层关闭conn
            BaseDao.closeResource(connection,null,null);
        }
        return postsList;
    }
    /**
     * 删除帖子
     */
    public int postsSc(int id) {
        int i=0;
        Connection connection=null;
        try{
            connection=BaseDao.getConnection();
            i=postsDao.postsSc(connection,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return i;
    }

    /**
     * 修改帖子
     * @param type
     * @param con
     * @param id
     * @return
     */
    public int UpdPosts(String type, String con, int id) {
        Connection connection;
        int i=0;
        try{
        connection=BaseDao.getConnection();
        i=postsDao.UpdPosts(connection,type,con,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
