package com.csdj.entity;

import java.util.Date;
import java.util.List;

/**
发帖表
 */
public class Posts {
    //id,主键自增
    private int postId;
    /**
     * 标题
     */
    private String type;

    /**
     * 发帖人id
     */
    private int uId;
    /**
     *  发帖内容
     */
    private String content;
    /**
     *   发帖时间
     */
    private Date postingTime;
    /**
     * 点击率
     */
    private  int click;
    /**
     *  点赞
     */
    private int like;
    /**
    图片
     */
    private String picture;
    /**
    用来储存用户表数据
     */
    private List<User> user;

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(Date postingTime) {
        this.postingTime = postingTime;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
