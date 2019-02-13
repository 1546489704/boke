<%--
  Created by IntelliJ IDEA.
  User: H丶丢心先生
  Date: 2018/11/27
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" type="text/css" href="../public/css/base.css">  -->
  <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="shortcut icon" href="cc.ico">
    <script type="text/javascript" src="js/dianji.js"></script>
  <title>风风博客-登录</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            text-decoration: none;
        }
        .logins{
            width: 1100px;
            height: 480px;
            background-color: rgba(0, 0, 0, 0.2);
            position: fixed;
            left: 150px;
            top: 70px;
        }
        .formlogin{
            height: 500px;
            width: 500px;
        }
        .formlogin-title{
            position: absolute;
            left: 160px;
            color: white;
            font-size: 30px;
        }
        .formlogin-form{
            position: absolute;
        }
        .formlogin-form-table{
            color: white;
            font-size: 20px;
            position: absolute;
            top: 110px;
            left: 40px;
        }
        #username{
            width: 300px;
        }
        #us{
            width: 300px;
        }
        .form-control{
            height: 35px;
            width: 300px;
        }
        .lo{
            height: 40px;
            width: 100px;
            background-color: transparent;
            color: white;
            position: absolute;
            left: 80px;
            border-radius:6px;border:1px solid #baffd4;
        }
        .wj {
            height: 40px;
            width: 100px;
            background-color: transparent;
            color: white;
            position: absolute;
            left: 260px;
            border-radius:6px;border:1px solid #baffd4;
        }
        .form-control{
            border-radius:6px;border:1px solid #baffd4;
        }
        #you{
            position: absolute;
            right: 50px;
            top: 30px;
        }
        #you a{
            color: white;
            margin-right: 30px;
        }
        #wei{
            background-color: rgba(0, 0, 0, 0.2);
            width: 100%;
            position: fixed;
            bottom: 0;
        }
        #wei a{
            color: white;
        }
        #xunwen a{
            margin-right: 50px;
            color: black;
        }
    </style>
</head>
<body>
<input type="hidden" value="${requestScope.error}" id="errors">
<%--最右边的导航    --%>
<div id="you">
    <a href="#">首页</a>
    <a href="#">登录</a>
    <a href="#">注册</a>
    <a href="#">关于</a>
</div>
<div class="logins">
  <div class="formlogin">
      <div class="formlogin-title">登录风风博客</div>
    <form action="UserServlet" id="myform" class="formlogin-form">
        <input type="hidden" name="ac" value="login">
        <table class="formlogin-form-table">
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" id="username" class="form-control" placeholder="请输入用户名"></td>
            </tr>
            <tr style="height: 50px"></tr>
            <tr>
                <td> 密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                <td><input type="password" name="password" id="password" class="form-control" placeholder="请输入密码"></td>
            </tr>
            <tr style="height: 50px"></tr>
            <tr id="yan">
                <td>验证码:</td>
                <td><input type="text" name="username" id="us" class="form-control" placeholder="请输入验证码"></td>
                <td>*<img alt="验证码" src="Servlet" id="ma" title="看不清?换一张"></td>
            </tr>
            <tr style="height: 100px"></tr>
            <tr id="loginmm">
                <td><input type="submit" class="lo" value="登录博客"></td>
                <td><input type="button" class="wj" value="修改密码"></td>
            </tr>
        </table>
    </form>
  </div>
    <%--轮播图--%>
  <div class="rightpic">
    <div id="container"></div>
      <h2 style="margin-left: 200px;color: white">最新通知</h2>
      <marquee style="WIDTH: 500px; position: fixed;top: 500px; HEIGHT: 200px" scrollamount="3" direction="left" >
          <p id="tz" style="color: white;font-size: 20px"></p>
      </marquee>
  </div>
</div>
<div id="wei">
    <div style="margin-left: 525px" id="lian">
        |<a href="/UserServlet?ac=blockList&yem=xiaoheiwu">&nbsp;&nbsp;小黑屋&nbsp;&nbsp;</a>|
        <a href="#">关于博客&nbsp;&nbsp;</a>|
        <a href="#">联系我们&nbsp;&nbsp;</a>|
        <a href="#">合作广告&nbsp;</a>|
    </div>
    <div style="margin-left: 200px">
        <p style="color: white">Copyright&nbsp;&nbsp;©&nbsp;&nbsp;2008-2018风风博客&nbsp;&nbsp;版权所有&nbsp;&nbsp;法律:长沙公益律师
            &nbsp;&nbsp;合作QQ:2578615755&nbsp;&nbsp;业务:13142035904&nbsp;&nbsp;技术支持:长沙大计272班</p>
    </div>
</div>
<script src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>

<script src="js/bootstrap.min.js"></script>
<script src="js/delaunay.js"></script>
<script src="js/TweenMax.js"></script>
<script src="js/effect.js"></script>
<script>
    $(function () {
        $.get("UserServlet","ac=tz",function (data) {
            $("#tz").html(data);
        },"html");

        var i = 0;
        $("#ma").click(function () {
            $(this).attr("src", "Servlet?" + i);
            i++;
        });
        //最右上角的四个a标签移入与移除事件 更换背景颜色以及下边框
        $("#you a").hover(function () {
            $(this).css({"color":"#00F7DE","border-bottom":"1px #00F7DE solid"});
        },function () {
            $(this).css({"color":"white","border-bottom":"none"});
        });


        var is=false;
        function us() {
            var val = $("#us").val();
            if (val == "" || val == null) {
                layer.msg('请填写验证码', {icon: 5});
                return is;
            } else {
                var data = "username=" + val;
                $.ajax({
                    "url": "Register",
                    "type": "GET",
                    "data": data,
                    "dataType": "text",
                    "success": function (data) {
                        if (data == "true") {
                            is=true;
                            layer.msg('验证码正确!', {icon: 1});
                        } else {
                            is=false;
                            layer.msg('验证码错误!', {icon: 2});
                        }
                    },
                    "error": function () {
                        alert("出错了,请联系管理员!");
                    }
                });
                return is;
            }
        }
        function username() {
            var val = $("#username").val();
            if (val == "" || val == null) {
                layer.msg('请填写用户名', {icon: 5});
                return false;
            }
            return true;
        }
        function password() {
            var val = $("#password").val();
            if (val == "" || val == null) {
                layer.msg('请填写密码', {icon: 5});
                return false;
            }
            return true;
        }
        $("#username").blur(username);
        $("#password").blur(password);
        $("#us").blur(us);

        $("#myform").submit(function () {
            if(!username()) return false;
            if(!password()) return false;
            if(!us()) return false;
            return true;
        });
        $(".lo,.wj").hover(function () {
            $(this).css({"background-color":"white","color":"black"});
        },function () {
            $(this).css({"background-color":"transparent","color":"white"});
        });
        $("#tz").slideDown(2000);

        var errors=$("#errors").val();
        if(errors=="用户名或密码错误!"){
            layer.msg(errors, {icon: 5});
        }else if(errors=="你已被关入小黑屋"){
            layer.msg(errors, {icon: 5});
        }

        $("#lian a").hover(function () {
           $(this).css("color","F70004");
        },function () {
            $(this).css("color","white");
        });
        //首页
        $("#you a:eq(0)").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                window.location.href='index.jsp';
            }, 2000);
        });
        $("#you a:eq(1)").click(function () {
            layer.msg('当前页面就是登陆哦!', {icon: 6});
        });
        //注册界面加载事件
        $("#you a:eq(2)").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                window.location.href='register.jsp';
            }, 2000);
        });
        //关于界面加载事件
        $("#you a:eq(3)").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                window.location.href='guanyu.jsp';
            }, 2000);
        });
        $(".wj").click(function () {
            layer.open({
                type: 1 //Page层类型
                ,area: ['250px', '150px']
                ,title: '请选择您需要的链接'
                ,shade: 0.1 //遮罩透明度
                ,maxmin: true //允许全屏最小化
                ,anim: 1 //0-6的动画形式，-1不开启
                ,shadeClose: true
                ,skin: 'yourclass'
                ,content: '<div id="xunwen" style="margin-left: 22px;margin-top: 25px">' +
                    '<a href="#" id="xiu">修改密码</a>' +
                    '<a href="#" id="chong">重置密码</a>' +
                    '</div>'
            });
            $("#xiu").click(function () {
                var ii = layer.load();
                setTimeout(function(){
                    layer.close(ii);
                    window.location.href='xiu.jsp';
                }, 2000);
            });
            $("#chong").click(function () {
                var ii = layer.load();
                setTimeout(function(){
                    layer.close(ii);
                    window.location.href='chong.jsp';
                }, 2000);
            });
        });
    })
</script>
</body>
</html>
