package com.csdj.entity;

import java.util.List;

/**
 * 评论类
 */
public class CommentBack {
    //有参构造
    public CommentBack(int hID, int sID, int postID, String content, int pID, String hTime,int cid) {
        this.hID = hID;
        this.sID = sID;
        this.postID = postID;
        this.content = content;
        this.pID = pID;
        this.hTime = hTime;
        this.cId=cid;
    }
    /**
     * 无参构造
     */
    public CommentBack(){}
    private List<User> userList;
    private int hID;            //评论回复ID
    private int sID;            //收到评论的用户ID
    private int postID;         //评论发帖内容ID
    private String content;     //评论内容
    private int pID;            //评论者
    private String hTime;       //评论时间
    private int cId; //评论id
    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }


    public int gethID() {
        return hID;
    }

    public void sethID(int hID) {
        this.hID = hID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String gethTime() {
        return hTime;
    }

    public void sethTime(String hTime) {
        this.hTime = hTime;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
