package com.csdj.entity;

/**
 * 用户实体类
 */
public class User {
    private int uId;//id
    private String uName;//姓名
    private int gradeid;//等级
    private String password;//密码
    private String sex;//性别
    private int age;//年龄
    private String phone;//手机号
    private String email;//邮箱
    private String career;//职业
    private String hobby;//爱好
    private String site;//地址
    private String prcture;//头像
    private String time;    //时间
    public User() { }
    public User(int uId, String uName, int gradeid, String password, String sex, int age, String phone, String email, String career, String hobby, String site, String prcture) {
        this.uId = uId;
        this.uName = uName;
        this.gradeid = gradeid;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.career = career;
        this.hobby = hobby;
        this.site = site;
        this.prcture = prcture;
    }
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getGradeid() {
        return gradeid;
    }

    public void setGradeid(int gradeid) {
        this.gradeid = gradeid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPrcture() {
        return prcture;
    }

    public void setPrcture(String prcture) {
        this.prcture = prcture;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
