package com.csdj.dao.CommentBackMapper;

import com.csdj.entity.CommentBack;
import com.csdj.entity.Comments;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 回复评论接口
 */
public interface CommentBackMapper {
    /**
     * 查询回复评论
     */
    public List<CommentBack> CommentBackShow(Connection connection,int postid, String sName, String fName, int plId) throws SQLException;
    /**
     *添加回复评论
     */
    public int addCommentBack(Connection connection,CommentBack commentBack) throws SQLException;
    /**
     * 删除回复评论
     */
    public int deleteCommentBack(Connection connection,CommentBack commentBack)throws  SQLException;
}
