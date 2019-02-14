package com.csdj.dao.PostsMapper;

import com.csdj.entity.Posts;
import com.csdj.entity.photo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 * 发帖接口
 */
public interface PostsMapper {
    /**
     * 查询所有贴
     * @return
     */
    public List<Posts> QueryPosts(Connection connection,int currPageNo,int pageSize) throws SQLException;
    /**
     *按id查询数据
     */
    public List<Posts> QueryPos(Connection connection,int id) throws SQLException;
    /**
     * 按id修改浏览数据
     */
    public void  UpdatePosts(Connection connection,int id,int click) throws SQLException;
    /**
     * 按id修改点赞数据
     */
    public void Updatepos(Connection connection,int id,int like) throws SQLException;
    /**
     * 按分页查询图片
     */
    public List<photo> QueryPhoto(Connection connection) throws SQLException;
    /**
     * 添加评论
     * @param connection
     * @param bt
     * @param nr
     * @param diz
     * @return
     * @throws SQLException
     */
    public int  InnsertPhsts(Connection connection,String bt,String nr,String diz)throws SQLException;

    /**
     * 获得评论条数
     * @param connection
     * @return
     * @throws SQLException
     */
    public int Hdts(Connection connection) throws  SQLException;

    /**
     * 查询全部帖子标题
     * @param connection
     * @return
     * @throws SQLException
     */
    public List<Posts> postsList(Connection connection) throws  SQLException;

    /**
     * 按id查询
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     */
    public int postsSc(Connection connection ,int id) throws SQLException;

    /**
     * 修改帖子
     */
    public int UpdPosts(Connection connection,String type,String con,int id)throws  SQLException;
}
