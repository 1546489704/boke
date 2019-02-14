package com.csdj.dao.CommentsMapper;

import com.csdj.entity.Comments;
import com.csdj.entity.Privates;
import com.csdj.util.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 评论接口类
 */
public interface CommentsMapper {
    /**
     * 添加评论
     * @param comments
     * @return
     */
    public int addComments(Connection connection,Comments comments) throws SQLException;

    /**
     * 查看评论
     * @return
     */
    public List<Comments> listComments(Connection connection,Comments comments,Page page) throws SQLException;
    /**
     * 评论数目
     */
    public int CommentCount(Connection connection,Comments comments) throws SQLException;
    /**
     * 删除评论
     */
    public int deletComment(Connection connection,Comments comments) throws SQLException;
    /**
     * 查询全部评论
     */
    public List<Comments> htshowComments(Connection connection,int currPageNo,int pageSize)throws  SQLException;
    /**
     * 后台评论数目
     */
    public int htCommentCount(Connection connection) throws SQLException;
    /**
     * 更新评论
     */
    public int updateComments(Connection connection,Comments comments)throws SQLException;
}
