package com.csdj.entity;
/*
用户关注表
 */
public class Attentions {
    //id主键自增
    private int attId;
    //用户id
    private  int uId;
    //被关注人id
    private int bId;

    public int getAttId() {
        return attId;
    }

    public void setAttId(int attId) {
        this.attId = attId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }
}
