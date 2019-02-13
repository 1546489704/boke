<%--
  Created by IntelliJ IDEA.
  User: H丶丢心先生
  Date: 2018/12/4
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>野猪博客-注册</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <link rel="shortcut icon" href="cc.ico">
</head>
<body bgcolor=#FFFFFF alink=#333333 vlink=#333333 link=#333333 topmargin=0 leftmargin=0 onLoad="init()">
<div id="in">
    <%--最右边的导航    --%>
    <div id="you">
        <a href="#">首页</a>
        <a href="#">登录</a>
        <a href="#">注册</a>
        <a href="#">关于</a>
    </div>
    <div id="fo">
        <h2 style="color: white;margin-left: 430px">欢迎注册风风博客</h2>
        <form action="UserServlet" name="creator" id="myform">
            <input type="hidden" name="ac" value="register">
            <table style="color: white" id="fo1">
                <tr>
                    <td>账号名称:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr style="height: 20px"></tr>
                <tr>
                    <td>您的密码:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr style="height: 20px"></tr>
                <tr>
                    <td>确认密码:</td>
                    <td><input type="password" name="password2"></td>
                </tr>
                <tr style="height: 20px"></tr>
                <tr>
                    <td>手机号码:</td>
                    <td><input type="text" name="phone"></td>
                </tr>
            </table>
            <table style="color: white" id="fo2">
                <tr>
                    <td>QQ邮箱:</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr style="height: 20px"></tr>
                <tr>
                    <td>您的地址:</td>
                    <td>
                        <select name="province" onChange = "select()" style="height: 25px;width: 97px"></select>
                        <select name="city" onChange = "select()" style="height: 25px;width: 97px"></select>
                    </td>
                </tr>
                <tr style="height: 30px"></tr>
                <tr>
                    <td>您的性别:</td>
                    <td><select name="sex" id="" style="height: 35px;width: 200px">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select></td>
                </tr>
                <tr style="height: 20px"></tr>
                <tr>
                    <td>您的年龄:</td>
                    <td><input type="text" name="age"></td>
                </tr>
                <tr id="btn">
                    <td><input type="submit" id="btn_zhu" value="注册用户"></td>
                    <td><input type="button" id="btn_qu" value="取消注册"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script src="js/register.js"></script>
<script src="js/dianji.js"></script>
<script type="text/javascript">
    $(function () {
        //最右上角的四个a标签移入与移除事件 更换背景颜色以及下边框
        $("#you a").hover(function () {
            $(this).css({"color":"#00F7DE","border-bottom":"1px #00F7DE solid"});
        },function () {
            $(this).css({"color":"white","border-bottom":"none"});
        });
        $("#btn_zhu,#btn_qu").hover(function () {
            $(this).css({"background-color":"white","color":"black"});
        },function () {
            $(this).css({"background-color":"transparent","color":"white"});
        });
        $("#btn_qu").click(function () {
            layer.confirm('您确定要取消注册？', {
                btn: ['是','否'] //按钮
            }, function(){
                var ii = layer.load();
                setTimeout(function(){
                    layer.close(ii);
                    window.location.href='index.jsp';
                }, 500);
            });
        });
        var username=$("input[name='username']");//姓名
        var password=$("input[name='password']");//密码
        var password2=$("input[name='password2']");//二次密码
        var phone=$("input[name='phone']");//手机号码
        var email=$("input[name='email']");//邮箱
        var age=$("input[name='age']");//年龄
        var is=false;
        //验证用户名
        function user() {
            if(username.val()==""&&username.val().length==0){
                layer.msg('用户名不能为空!', {icon: 2});
                return false;
            }else{
                var data = "ac=wei&username=" + username.val();
                $.ajax({
                    "url": "UserServlet",
                    "type": "GET",
                    "data": data,
                    "dataType": "text",
                    "success": function (data) {
                        if (data == "true") {
                            is=true;
                            layer.msg('用户名可以使用!', {icon: 1});
                        } else {
                            is=false;
                            layer.msg('用户名已被占用!', {icon: 2});
                        }
                    },
                    "error": function () {
                        alert("出错了,请联系管理员!");
                    }
                });
            }
            return is;
        }
        //验证密码
        function pwd() {
            if(password.val()==""&&password.val().length==0){
                layer.msg('密码不能为空!', {icon: 2});
                return false;
            }else if(password2.val()!=password.val()){
                layer.msg('您输入的两次密码不一致,请重新输入!', {icon: 2});
                return false;
            }
            return true;
        }
        //验证手机号码
        function ph() {
            if(phone.val()==""&&phone.val().length==0){
                layer.msg('手机号码不能为空!', {icon: 2});
                return false;
            }else if(phone.val().length!=11){
                //手机号码必须十一位
                layer.msg('手机号码必须为十一位数!', {icon: 2});
                return false;
            }
            return true;
        }
        //验证邮箱
        function em() {
            if(email.val()==""&&email.val().length==0){
                layer.msg('邮箱不能为空!', {icon: 2});
                return false;
            }else if(email.val().indexOf("@")==-1){
                //必须包含 @与.
                layer.msg('邮箱必须包含@哦!', {icon: 2});
                return false;
            }else if(email.val().indexOf(".")==-1){
                layer.msg('邮箱必须包含.哦!', {icon: 2});
                return false;
            }
            return true;
        }
        //验证年龄
        function ag() {
            if(age.val()==""&&age.val().length==0){
                layer.msg('请输入您的年龄!', {icon: 2});
                return false;
            }else if(age.val()>120&&age.val()<1){
                //只能1-100
                layer.msg('年龄只能是1-120之间哦!', {icon: 2});
                return false;
            }
            return true;
        }
        username.blur(user);
        password.blur(pwd);
        phone.blur(ph);
        email.blur(em);
        age.blur(ag);
        $("#myform").submit(function () {
            if(!user()) return false;
            if(!pwd()) return false;
            if(!ph()) return false;
            if(!em()) return false;
            if(!ag()) return false;
            return true;
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
            layer.msg('当前页面就是注册哦!', {icon: 6});
        });
        //关于界面加载事件
        $("#you a:eq(3)").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                window.location.href='guanyu.jsp';
            }, 2000);
        });
    });
</script>
</body>
</html>
