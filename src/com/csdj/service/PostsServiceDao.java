package com.csdj.service;

import com.csdj.entity.Posts;
import com.csdj.entity.photo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 帖子的业务逻辑层
 */
public interface PostsServiceDao {
    /**
     * 查询所有 并且分页
     * @param currPageNo
     * @param pageSize
     * @return
     */
    public List<Posts> QueryPostsService(int currPageNo,int pageSize);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public List<Posts> QueryPosService(int id);

    /**
     * 按id修改
     * @param id
     * @param click
     */
    public void  UpdatePostsService(int id,int click);

    /**
     * 按id修改
     * @param id
     * @param like
     */
    public void UpdatePosService(int id,int like);
    /**
     * 查找他的上一个
     */
    public List<Posts> QueryShan(int id);
    /**
     * 查找他的下一个
     */
    public List<Posts> QueryXia(int id);
    /**
     * 查找所有图片
     */
    public List<photo> QueryPhoto();

    /**
     * 添加图片
     * @param bt
     * @param nr
     * @param diz
     * @return
     */
    public int InnsertPhsts(String bt, String nr, String diz);

    /**
     * 查询条数
     * @return
     */
    public int Hdts();

    /**
     * 查询全部帖子标题
     * @param
     * @return
     * @throws SQLException
     */
    public List<Posts> postsList();

    /**
     * 删除帖子
     */
    public int postsSc(int id);
    /**
     * 修改帖子
     */
    public int UpdPosts(String type, String con,int id);
}
