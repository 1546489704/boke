package com.csdj.entity;

/**
 * 留言类
 */
public class Leaves {

    public Leaves(int leaveID, int putID, String leaveText, int lyID, String leaveTime) {
        this.leaveID = leaveID;
        this.putID = putID;
        this.leaveText = leaveText;
        this.lyID = lyID;
        this.leaveTime = leaveTime;
    }

    //无参构造
    public Leaves(){}
    private int leaveID;        //留言ID
    private int putID;          //收到留言的用户ID
    private String leaveText;   //留言内容
    private int lyID;           //留言者ID
    private String leaveTime;   //留言时间
    public String put;           //收到留言的用户
    public String ly;            //留言者用户
    private String prcture;       //头像地址
    public int getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(int leaveID) {
        this.leaveID = leaveID;
    }

    public int getPutID() {
        return putID;
    }

    public void setPutID(int putID) {
        this.putID = putID;
    }

    public String getLeaveText() {
        return leaveText;
    }

    public void setLeaveText(String leaveText) {
        this.leaveText = leaveText;
    }

    public int getLyID() {
        return lyID;
    }

    public void setLyID(int lyID) {
        this.lyID = lyID;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getPut() {
        return put;
    }

    public void setPut(String put) {
        this.put = put;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public String getPrcture() {
        return prcture;
    }

    public void setPrcture(String prcture) {
        this.prcture = prcture;
    }
}
