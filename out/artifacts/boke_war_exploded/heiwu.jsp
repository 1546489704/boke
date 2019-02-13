<%--
  Created by IntelliJ IDEA.
  User: H丶丢心先生
  Date: 2018/12/20
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon" href="cc.ico">
    <script type="text/javascript" src="js/dianji.js"></script>
    <title>风风博客-小黑屋</title>
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
        .rightpic{
            width:500px;
            height:330px;
            position:absolute;
            right:30px;
            top:30px;
            opacity: 0.8;
        }
        #container{
            position: relative;
            width:500px;
            height:330px;
        }
        canvas{ position: absolute;
            backface-visibility: hidden;
            -webkit-backface-visibility: hidden;
            -moz-backface-visibility: hidden;
            -ms-backface-visibility: hidden;
        }
        img {
            position: absolute;
            -webkit-transition: opacity .3s;
            transition: opacity .3s;
        }
    </style>
</head>
<body style=" background: url(images/0005.jpg)no-repeat;background-size: cover;">
<%--最右边的导航    --%>
<div id="you">
    <a href="#">首页</a>
    <a href="#">登录</a>
    <a href="#">注册</a>
    <a href="#">关于</a>
</div>
<div class="logins">
    <h2 style="margin-left: 250px;color: white">小黑屋</h2>
    <table border="1" id="sj" style="text-align: center;color: wheat;margin-left: 100px">
        <tr>
            <td>用户名</td>
            <td>操作行为</td>
            <td>操作理由</td>
            <td>过期时间</td>
            <td>操作时间</td>
        </tr>
        <c:forEach var="list" items="${sessionScope.blockList}" varStatus="i">
            <tr>
                <td>${list.uName}</td>
                <td>${list.career}</td>
                <td>${list.hobby}</td>
                <td>${list.site}</td>
                <td>${list.time}</td>
            </tr>
        </c:forEach>

    </table>
    <div class="rightpic">
        <div id="container"></div>
        <h2 style="margin-left: 200px;color: white">温馨提示</h2>
        <marquee style="WIDTH: 500px; position: fixed;top: 500px; HEIGHT: 200px" scrollamount="3" direction="left" >
            <p id="tz" style="color: white;font-size: 20px">用户被关小黑屋后将永不解封,每个用户会有三次警告,三次过后直接拉入小黑屋!</p>
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
<script src="js/layer/layer.js"></script>

<script src="js/effect.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/delaunay.js"></script>
<script src="js/TweenMax.js"></script>
<script>
    $(function () {
        //最右上角的四个a标签移入与移除事件 更换背景颜色以及下边框
        $("#you a").hover(function () {
            $(this).css({"color":"#00F7DE","border-bottom":"1px #00F7DE solid"});
        },function () {
            $(this).css({"color":"white","border-bottom":"none"});
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
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                window.location.href='login.jsp';
            }, 2000);
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
        $("#lian a").hover(function () {
            $(this).css("color","F70004");
        },function () {
            $(this).css("color","white");
        });
    });
</script>
</body>
</html>
