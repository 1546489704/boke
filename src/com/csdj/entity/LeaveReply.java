package com.csdj.entity;

/**
 * 留言回复类
 */
public class LeaveReply {
    //有参构造
    public LeaveReply(int rID, int sID, int hID, String replyText, int replyID, String replyTime) {
        this.setrID(rID);
        this.setsID(sID);
        this.sethID(hID);
        this.setReplyText(replyText);
        this.setReplyID(replyID);
        this.setReplyTime(replyTime);
    }
    //无参构造
    public  LeaveReply(){}
    //封装字段
    private int rID;             //留言回复ID
    private int sID;            //收到回复的用户ID
    private int hID;            //回复留言的ID
    private String replyText;    //回复内容
    private int replyID;        //回复者ID
    private String replyTime;   //回复时间


    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public int gethID() {
        return hID;
    }

    public void sethID(int hID) {
        this.hID = hID;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }
}
