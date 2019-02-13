package com.csdj.entity;

import javax.print.DocFlavor;

//私信类
public class Privates {
    //有参构造

    public Privates(int privateID, int fID, int sID, String privateText, String privateTime) {
        this.privateID = privateID;
        this.fID = fID;
        this.sID = sID;
        this.privateText = privateText;
        this.privateTime = privateTime;
    }

    //无参构造
    public Privates(){}

    private int privateID;      //私信ID
    private int fID;            //(发)信息者ID
    private int sID;            //(收)信息者ID
    private String privateText;    //私信内容
    private String privateTime; //私信时间

    public int getPrivateID() {
        return privateID;
    }

    public void setPrivateID(int privateID) {
        this.privateID = privateID;
    }

    public int getfID() {
        return fID;
    }

    public void setfID(int fID) {
        this.fID = fID;
    }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getPrivateText() {
        return privateText;
    }

    public void setPrivateText(String privateText) {
        this.privateText = privateText;
    }

    public String getPrivateTime() {
        return privateTime;
    }

    public void setPrivateTime(String privateTime) {
        this.privateTime = privateTime;
    }
}
