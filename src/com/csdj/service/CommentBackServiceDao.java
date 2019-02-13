package com.csdj.service;

import com.csdj.entity.CommentBack;

import java.util.List;

public interface CommentBackServiceDao {
    /**
     * 查询回复评论
     */
    public List<CommentBack> CommentBackShow(int postid,String sName,String fName,int plId);
    /**
     *添加回复评论
     */
    public int addCommentBack(CommentBack commentBack);
    /**
     * 删除回复评论
     */
    public  int deleteCommentBack(CommentBack commentBack);
}
