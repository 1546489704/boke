package com.csdj.entity;
/*
管理员表
 */
public class Admin {
    public Admin(){}

    public Admin(int aId, String name, int powerId, String password, String sex, int age, int phone, String email, String career, String hobby, String site, String prcture) {
        this.aId = aId;
        this.name = name;
        this.powerId = powerId;
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

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
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

    private int aId;//id
    private String name;//姓名
    private int powerId;//权限
    private String password;//密码
    private String sex;//性别
    private int age;//年龄
    private int phone;//手机号
    private String email;//邮箱
    private String career;//职业
    private String hobby;//爱好
    private String site;//地址
    private String prcture;//头像
}
