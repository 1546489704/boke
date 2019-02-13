package com.csdj.entity;

import java.util.List;

/**
 * 评论实体类
 */
public class Comments {
    /**
     * 有参构造
     */
    public Comments(int cID, int postID, String commentText, int pID, String pTime) {
        this.setcID(cID);
        this.setPostID(postID);
        this.setCommentText(commentText);
        this.setpID(pID);
        this.setpTime(pTime);
    }

    /**
     * 无参构造
     */
    public Comments(){}
    private List<User> userList; //用户表list
    private List<Posts> postType;//发帖表list
    private int cID;            //评论ID
    private int postID;        //评论发帖内容ID
    private String commentText;//评论内容
    private int pID;            //评论者ID
    private String pTime;       //评论时间

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Posts> getPostType() {
        return postType;
    }

    public void setPostType(List<Posts> postType) {
        this.postType = postType;
    }
}
