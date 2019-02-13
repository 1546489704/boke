package com.csdj.entity;

/**
 * 系统通知类
 */
public class Informs {
    //有参构造
    public Informs(int informID, String datatime, String informText) {
        this.informID = informID;
        this.datatime = datatime;
        this.informText = informText;
    }
    //无参构造
    public Informs(){}

    private int informID;        //系统通知ID
    private String datatime;            //通知时间
    private String informText;  //通知内容

    public int getInformID() {
        return informID;
    }

    public void setInformID(int informID) {
        this.informID = informID;
    }

    public String getDatatime() {
        return datatime;
    }

    public void setuDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getInformText() {
        return informText;
    }

    public void setInformText(String informText) {
        this.informText = informText;
    }
}
