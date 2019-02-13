package com.csdj.entity;

import java.util.Date;

/**
 * 相册表
 */
public class photo {
    //主键 自增
    private  int phId;
    //用户id
    private  int uid;
    //图片地址
    private String picture;
    //图片介绍
    private String introduce;
    //上传时间
    private String date;
    //图片类型
    private  String type;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPhId() {
        return phId;
    }

    public void setPhId(int phId) {
        this.phId = phId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
