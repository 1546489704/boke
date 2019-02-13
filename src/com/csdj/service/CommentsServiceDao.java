package com.csdj.service;

import com.csdj.dao.CommentsDao;
import com.csdj.entity.Comments;
import com.csdj.entity.Privates;
import com.csdj.util.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 评论业务层
 */
public interface CommentsServiceDao {
    /**
     * 发表评论
     */
    public int addComments(Comments commentsDao);

    /**
     * 查看评论
     * @return
     */
    public List<Comments> listComments(Comments comments, Page page);
    /**
     * 评论数目
     */
    public int CommentCount(Comments comments);
    /**
     * 删除评论
     */
    public int deletComment(Comments comments);
    /**
     * 查询全部评论
     */
    public List<Comments> htshowComments(int currPageNo,int pageSize);
    /**
     * 评论条数
     * @return
     */
    public int htCommentCount();

    /**
     * 更新信息
     * @param comments
     * @return
     */
    public int updateCommnets(Comments comments);

}
