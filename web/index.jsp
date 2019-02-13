<%--
  Created by IntelliJ IDEA.
  User: H丶丢心先生
  Date: 2018/11/28
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%--123 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/audio.css">
    <link rel="shortcut icon" href="cc.ico">
    <title>风风博客-首页</title>
    <script src="js/modernizr.custom.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>
    <script type="text/javascript" src="js/dianji.js"></script>
</head>
<body>
    <div id="in">
        <div class="container">
            <div class="main">
                <ul id="cbp-bislideshow" class="cbp-bislideshow">
                    <li><img src="images/bj.jpg" alt="image01"/></li>
                    <li><img src="images/bj2.jpg" alt="image02"/></li>
                    <li><img src="images/bj3.jpg" alt="image03"/></li>
                </ul>
            </div>
        </div>
        <%--最右边的导航    --%>
        <div id="you">
            <a href="#">首页</a>
            <a href="#">登录</a>
            <a href="#">注册</a>
            <a href="#">关于</a>
        </div>


        <div id="title" style="display: none">
            <h1>长沙大计风风博客</h1>
            <div style="font-size: 25px">如果有用户请登录 如果还没有请注册</div>
        </div>
        <div id="cbp-bicontrols" class="cbp-bicontrols">
            <span class="cbp-biprev"><</span>
            <span class="cbp-binext">></span>
        </div>
        <div id="ti" style="display: none">
            <a id="lo" href="#">登录</a>
            <a id="re" href="#">注册</a>
        </div>

        <div class="audio-box">
            <div class="audio-container">
                <div class="audio-view">
                    <div class="audio-cover" ></div>
                    <div class="audio-body">
                        <h3 class="audio-title">未知歌曲</h3>
                        <div class="audio-backs">
                            <div class="audio-this-time">00:00</div>
                            <div class="audio-count-time">00:00</div>
                            <div class="audio-setbacks">
                                <i class="audio-this-setbacks">
                                    <span class="audio-backs-btn"></span>
                                </i>
                                <span class="audio-cache-setbacks">
							</span>
                            </div>
                        </div>
                    </div>
                    <div class="audio-btn">
                        <div class="audio-select">
                            <div class="audio-prev"></div>
                            <div class="audio-play"></div>
                            <div class="audio-next"></div>
                            <div class="audio-menu"></div>
                            <div class="audio-volume"></div>
                        </div>
                        <div class="audio-set-volume">
                            <div class="volume-box">
                                <i><span></span></i>
                            </div>
                        </div>
                        <div class="audio-list">
                            <div class="audio-list-head">
                                <p>歌单</p>
                                <span class="menu-close">关闭</span>
                            </div>
                            <ul class="audio-inline">
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src="js/jquery.imagesloaded.min.js"></script>
<script src="js/cbpBGSlideshow.min.js"></script>
    <script type="text/javascript" src="js/audio.js"></script>
<script>
    $(function() {
        cbpBGSlideshow.init();
    });
</script>
<script type="text/javascript">
    $(function () {
        //最右上角的四个a标签移入与移除事件 更换背景颜色以及下边框
        $("#you a").hover(function () {
            $(this).css({"color":"#00F7DE","border-bottom":"1px #00F7DE solid"});
        },function () {
            $(this).css({"color":"white","border-bottom":"none"});
        });
        //首页
        $("#you a:eq(0)").click(function () {
            layer.msg('当前页面就是首页哦!', {icon: 6});
        });

        //登录界面加载事件
        $("#lo").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                open('login.jsp');
            }, 2000);
        });
        //注册界面加载事件
        $("#re").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                open('register.jsp');
            }, 2000);
        });
        $("#you a:eq(1)").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                open('login.jsp');
            }, 2000);
        });

        //注册界面加载事件
        $("#you a:eq(2)").click(function () {
            var ii = layer.load();
            setTimeout(function(){
                layer.close(ii);
                open('register.jsp');
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
        //登录的移入样式
        $("#ti #lo").hover(function () {
            $(this).css({"background-color":"white","color":"black"});
        },function () {
            $(this).css({"background-color":"transparent","color":"white"});
        });
        //注册的移入样式
        $("#ti #re").hover(function () {
            $(this).css({"background-color":"white","color":"black"});
        },function () {
            $(this).css({"background-color":"transparent","color":"white"});
        });
        // //鼠标移入body则显示左右两个标签
        // $("body").hover(function () {
        //     $("#cbp-bicontrols").show(1000);
        // },function () {
        //     $("#cbp-bicontrols").hide(1000);
        // });
        $(".cbp-biprev,.cbp-binext").hover(function () {
            $(this).css({"background-color":"white","color":"black"});
        },function () {
            $(this).css({"background-color":"transparent","color":"white"});
        });

        var song = [
            {
                'cover':"images/dxlznsb.jpg",
                'src' : 'mp3/dxlznsb.mp3',
                'title' : '多想留在你身边-刘增瞳'
            },{
                'cover' : 'images/yzw.jpg',
                'src' : 'mp3/geldzj.mp3',
                'title' : '给未来的自己-杨宗纬 . Star!Start! 星空传奇演唱会'
            },
            {
                'cover' : 'images/PLANET.jpg',
                'src' : 'mp3/PLANET.mp3',
                'title' : 'PLANET-ラムジ'
            },
            {
                'cover' : 'images/lrh.jpg',
                'src' : 'mp3/jy.mp3',
                'title' : '戒烟-李荣浩'
            },
            {
                'cover' : 'images/ps.jpg',
                'src' : 'mp3/PFZL.mp3',
                'title' : '平凡之路-朴树'
            },
            {
                'cover' : 'images/yw.jpg',
                'src' : 'mp3/ShapeofYou.mp3',
                'title' : 'ShapeofYou-艾德·希兰'
            },
            {
                'cover' : 'images/zwy.jpg',
                'src' : 'mp3/ZWY.mp3',
                'title' : '钟无艳-谢安琪'
            }
        ];

        var audioFn = audioPlay({
            song : song,
            autoPlay : true  //是否立即播放第一首，autoPlay为true且song为空，会alert文本提示并退出
        });

        /* 向歌单中添加新曲目，第二个参数true为新增后立即播放该曲目，false则不播放 */
        // audioFn.newSong({
        //     'cover' : 'images/cover5.jpg',
        //     'src' : 'http://webmp3-1253691995.costj.myqcloud.com/audio/baab.mp3',
        //     'title' : 'B.A.A.B'
        // },false);
        $("body").dblclick(function () {
            // $(".audio-box").toggle();
            $(".audio-box").slideToggle(1000);
        });

        $(".audio-play").toggle(function(){
                $(".audio-cover").css("-webkit-animation","rotateImg 0s linear infinite");},
            function(){
                $(".audio-cover").css("-webkit-animation","rotateImg 8s linear infinite");}

        );
        $("#title,#ti").fadeIn(3000);
    });
</script>
</body>
</html>
