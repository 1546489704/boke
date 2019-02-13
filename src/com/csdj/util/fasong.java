package com.csdj.util;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 发送邮件类
 */
public class fasong {
    public void fa(String user,String pwd,String email) throws Exception{
        Properties props=new Properties();
        props.setProperty("mail.transport.protocol","smtp");//使用的协议
        props.setProperty("mail.smtp.host","smtp.qq.com");//协议地址
        props.setProperty("mail.smtp.port","465");//协议端口
        props.setProperty("mail.smtp.auth","true");//需要授权
        //QQ:SSL安全认证
        props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback","false");
        props.setProperty("mail.smtp.socketFactory.port","465");
        Session session = Session.getInstance(props);
//        session.setDebug(true);//开启日志
        MimeMessage message=new MimeMessage(session);
        Address address=new InternetAddress("2578615755@qq.com","长沙大计风风博客","UTF-8");
        //邮件: 标题,正文,收件人,发件人
        message.setFrom(address);
        message.setSubject("长沙大计凤凤博客注册信息","UTF-8");
        message.setContent("<h3 style=\"color: #4585ff\">注册成功!注册信息如下:</h3><br>用户名:"+user+":密码为:"+pwd+"<br>请牢记此账号与密码!<br>来自凤凤博客","text/html;charset=UTF-8");
        //收件人类型 普通收件人 TO,抄送 CC,密送 BCC
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(email,"收件人","UTF-8"));
        message.setSentDate(new Date());//设置发送时间
        message.saveChanges();//保存邮件
        Transport transport=session.getTransport();//建立链接对象
        transport.connect("2578615755@qq.com","xcpvycpexetuecjb");//邮箱账号与授权码
        transport.sendMessage(message,message.getAllRecipients());//发送邮件
        transport.close();//关闭链接
    }
    public void chong(String username,String pwd,String email) throws Exception{
        Properties props=new Properties();
        props.setProperty("mail.transport.protocol","smtp");//使用的协议
        props.setProperty("mail.smtp.host","smtp.qq.com");//协议地址
        props.setProperty("mail.smtp.port","465");//协议端口
        props.setProperty("mail.smtp.auth","true");//需要授权
        //QQ:SSL安全认证
        props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback","false");
        props.setProperty("mail.smtp.socketFactory.port","465");
        Session session = Session.getInstance(props);
//        session.setDebug(true);//开启日志
        MimeMessage message=new MimeMessage(session);
        Address address=new InternetAddress("2578615755@qq.com","长沙大计风风博客","UTF-8");

        message.setFrom(address);
        message.setSubject("长沙大计凤凤博客重置密码信息","UTF-8");
        message.setContent("<h3 style=\"color: #4585ff\">重置密码成功!重置信息如下:</h3><br>用户名:"+username+",新密码为:"+pwd+"<br>请牢记此账号与密码!<br>来自凤凤博客","text/html;charset=UTF-8");
//        //收件人类型 普通收件人 TO,抄送 CC,密送 BCC
        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(email,"收件人","UTF-8"));
        message.setSentDate(new Date());//设置发送时间
        message.saveChanges();//保存邮件
        Transport transport=session.getTransport();//建立链接对象
        transport.connect("2578615755@qq.com","xcpvycpexetuecjb");//邮箱账号与授权码
        transport.sendMessage(message,message.getAllRecipients());//发送邮件
        transport.close();//关闭链接
    }
}
