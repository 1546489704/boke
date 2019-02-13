<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
  <title>首页_风风个人博客 - 一个个人博客网站</title>
  <meta name="keywords" content="个人博客,风风个人博客" />
  <meta name="description" content="风风个人博客" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/about.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<script src="js/jquery.min.js" ></script>
<script src="js/ab.js"></script>
  <link rel="stylesheet" type="text/css" href="css/haoDeCss.css">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
 <script src="../js/jquery-1.8.3.min.js"></script>
</head>
<body>
<header class="header-navigation" id="header">
  <nav>
    <div class="logo"><a href="http://www.yangqq.com">风风个人博客</a></div>
    <h2 id="mnavh"><span class="navicon"></span></h2>
      <ul id="starlist">
          <li><a href="main.jsp">网站首页</a></li>
          <li><a href="about.jsp" id="maName">${sessionScope.maName}</a></li>
        <li><a href="../LeavesServlet?opt=useT">留言板</a></li>
        <li><a href="../PhotoServlet?opt=List">美图分享</a></li>
          <li class="menu"><a href="fengmian.html">学无止境</a>
            <ul class="sub">
              <li><a href="fengmian.jsp">XPR语录</a></li>
            </ul>
          </li>
        <li><a href="/haoServlet?opt=backstage&bac=${sessionScope.maName}">后台通道</a></li>
          <li><a href="time.jsp">时间轴</a></li>
      </ul>
    <div class="searchbox">
      <div id="search_bar" class="search_bar">
        <form  id="searchform" action="[!--news.url--]e/search/index.php" method="post" name="searchform">
          <input class="input" placeholder="想搜点什么呢.." type="text" name="keyboard" id="keyboard">
          <input type="hidden" name="show" value="title" />
          <input type="hidden" name="tempid" value="1" />
          <input type="hidden" name="tbname" value="news">
          <input type="hidden" name="Submit" value="搜索" />
          <p class="search_ico"> <span></span></p>
        </form>
      </div>
    </div>
  </nav>
</header>
<article id="article1">
  <div class="photowall">
    <ul class="wall_a">
      <li><a href="#"><img src="${sessionScope.Userphoto.get(0).picture}">
        <figcaption>
          <h2>${sessionScope.Userphoto.get(0).date} </h2>
        </figcaption>
        </a></li>
      <li>
        <p class="text_b"><a href="/">${sessionScope.Userphoto.get(0).introduce}</a></p>
      </li>
      <li><a href="#"><img src="${sessionScope.Userphoto.get(1).picture}">
        <figcaption>
          <h2>${sessionScope.Userphoto.get(1).date} </h2>
        </figcaption>
        </a></li>
      <li>
        <p class="text_b"><a href="/">${sessionScope.Userphoto.get(1).introduce}</a></p>
      </li>
      <li>
        <p class="text_b"><a href="/">${sessionScope.Userphoto.get(2).introduce}</a></p>
      </li>
      <li><a href="#"><img src="${sessionScope.Userphoto.get(2).picture}">
        <figcaption>
          <h2>${sessionScope.Userphoto.get(2).date}  </h2>
        </figcaption>
        </a></li>
      <li>
        <p class="text_b"><a href="/">${sessionScope.Userphoto.get(3).introduce}</a></p>
      </li>
      <li><a href="#"><img src="${sessionScope.Userphoto.get(3).picture}">
        <figcaption>
          <h2>${sessionScope.Userphoto.get(3).date}</h2>
        </figcaption>
        </a></li>
    </ul>
  </div>
  <div class="abox">
  <h2>博主简介</h2>
  <div class="biji-content" id="content"> ${sessionScope.bozhu.get(0).uName},${sessionScope.bozhu.get(0).sex},${sessionScope.bozhu.get(0).hobby} </div>
  <div class="navlist">
    <ul>
      <li class="navcurrent"><a href="#top1">基本信息</a> </li>
      <li> <a href="#top2" >工作技能</a> </li>
      <li> <a href="#top3" >心路历程</a> </li>
      <li> <a href="#top4" >我的博客</a> </li>
      <li> <a href="#top5" >购买空间</a> </li>
    </ul>
  </div>
  <div class="navtab">
    <div class="navitem" style="display: block;" name = "top1">
      <div class="content">
        <p>网名：dancesmile | 风风</p>
        <p>职业：Web前端设计师、网页设计 </p>
                <p>邮箱：dancesmiling@qq.com</p>
        <p>个人微信：</p>
        <p><img src="images/grwx.png"></p>

      </div>
    </div>
    <div class="navitem" name = "top2">
      <div class="content">
        <p class="ab_t">工作技能：</p>
        <p>1、web前端页面的开发</p>
        <p>2、根据产品需求，配合后端开发人员协作实现前端页面效果和功能</p>
        <p>3、能够进行手机端和Pc端Html页面制作</p>
        <p>4、熟练使用html5，CSS3，javascript，熟悉页面架构和布局</p>
        <p>5、熟练使用Javascript框架</p>
      </div>
    </div>
    <div class="navitem" name = "top3">
      <div class="content">
        <p class="ab_t">心路历程：</p>
        <p><a href="http://www.yangqq.com/news/life/2018-04-27/816.html" target="_blank">【走进心灵】个人博客，属于我的小世界！</a></p>
        <p><a href="http://www.yangqq.com/news/life/2018-06-17/873.html" target="_blank">【爱设计】安静地做一个爱设计的女子</a></p>
        <p><a href="http://www.yangqq.com/jstt/bj/2015-01-09/740.html" target="_blank">【匆匆那些年】总结个人博客经历的这四年</a></p>
        <p><a href="http://www.yangqq.com/jstt/bj/2014-11-06/732.html" target="_blank">分享我的个人博客访问量如何做到IP从10到600的</a></p>
        <p><a href="http://www.yangqq.com/news/s/2014-01-08/635.html" target="_blank">个人博客从简不繁</a></p>
        <p><a href="http://www.yangqq.com/jstt/bj/2013-06-18/285.html" target="_blank">如果个人博客网站再没有价值，你还会坚持吗？</a></p>
        <p><a href="http://www.yangqq.com/news/life/2013-06-06/68.html" target="_blank">Web之路，经历了心酸之后</a></p>
      </div>
    </div>
    <div class="navitem" name = "top4">
      <div class="content">
        <p class="ab_t">我的博客：</p>
        <p>域 名：www.yangqq.com 创建于2011年01月12日&nbsp;</p>
        <p>服务器：阿里云服务器&nbsp;&nbsp;<a href="https://promotion.aliyun.com/ntms/act/ambassador/sharetouser.html?userCode=8smrzoqa&amp;productCode=vm" target="_blank"><span style="color:#FF0000;"><strong>前往阿里云官网购买&gt;&gt;</strong></span></a></p>
        <p>备案号：蜀ICP备11002373号-1</p>
        <p>程 序：PHP 帝国CMS7.5&nbsp; &nbsp;<u><a href="http://www.yangqq.com/blogs/876.html" target="_blank"><span style="color:#000000;">为什么选择帝国cms？</span></a></u></p>
           <p class="ab_t">微信扫码打赏：</p>

        <p><img src="images/weipayimg.jpg"></p>

      </div>
    </div>
    <div class="navitem" name = "top5">
      <div class="content">
        <p class="ab_t">购买空间：</p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3Dtx5qvgOp2sEcQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViRJZyTmHFgi7toyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVcJ9DgiofYXHhmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6uIOTs4KMj3yjpOyWSRdiSZDEm2YKA6YIrbIzrZDfgWtwGXLU4WXsy%2FSGTLzgkOZ%2F6tHZYFMpqEnXF%2B87KN7TKeiZ%2BQMlGz6FQ%3D%3D" target="_blank">【推荐】阿里云ECS</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DBd7iLbiMBvscQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViRlCnp0VPQiKVoyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVe3QAIFZ4qxdxmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6uIOTs4KMj3yjpOyWSRdiSZDEm2YKA6YIrbIzrZDfgWtewfOCTsUhuL7A4ojqcFxLlxfvOyje0ynomfkDJRs%2BhU%3D" target="_blank">【推荐】阿里云学生特惠云服务器</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DOU6WqfEvy%2FQcQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViRgNciauKrSpxoyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVdiEIb0a5VTxRmIkXBqRClNTcEU%2BDykfuTlSg55GVX5wb6HrfO5Rkxh34mdTsZIUcAD%2Bi4rDfTRpeTIM5d0rdP%2BMLZ4%2BrZ7PWchhQs2DjqgEA%3D%3D" target="_blank">RDS云数据库</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DkOyMRXLe5y0cQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViRLZXTD7FAd8hoyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVdeQ9pcQh0ldxmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6htm26afTqZhX2AelcDTwouII%2BH4AtnKmf9aAWiTxsBW2YeVZAPpWRfGDF1NzTQoPw%3D%3D" target="_blank">云数据库Redis版</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DNEP6My0TsB0cQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViR2Wp0cUyixa5oyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVeG2k2079gAVRmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6htm26afTqZhX2AelcDTwouII%2BH4AtnKmf9aAWiTxsBWuCgE0st4OyjGDmntuH4VtA%3D%3D" target="_blank">阿里云DDOS防护-高防IP</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DxKaTivPOxxscQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViRxJn51p0fCRZoyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVe%2FTQ%2BKb31whBmIkXBqRClNTcEU%2BDykfuTlSg55GVX5wVaL%2B82m0QZTEzn0DH69aFtLyrb2g0H2G%2Fwamd%2BEL%2FWmhcLzAjcuTkddow9d%2FMD%2BXQ%3D%3D" target="_blank">阿里云云解析</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DbAEFASZ9ijccQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViR4CZyur93miVoyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVfmlqlNq1vcQRmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6mMC%2FVYRjeGkg1LZ9gMhib9Lyrb2g0H2G3pD%2Buoa%2BvW2xgxdTc00KD8%3D" target="_blank">阿里云精品网站模版</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DYFtE9mLmbI8cQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViR%2F67zSlRHtIZoyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVdqFcPM5kapBRmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6htm26afTqZhX2AelcDTwouII%2BH4AtnKmf9aAWiTxsBWI8xs9INDEPvGJe8N%2FwNpGw%3D%3D" target="_blank">web应用防火墙</a></p>
        <p><a href="https://s.click.taobao.com/t?e=m%3D2%26s%3DG7ldZyW9ShocQipKwQzePCperVdZeJviEViQ0P1Vf2kguMN8XjClAv6rqJwbkViRVSG%2Bc1h4z9hoyO3ddgEZ98KZ%2FCBiGC%2BAA120cfxpzVf0SX%2FX7ryxfhmIkXBqRClNTcEU%2BDykfuSM%2BhtH71aX6htm26afTqZhX2AelcDTwouII%2BH4AtnKmf9aAWiTxsBWC9C%2BaUDluR%2FGJe8N%2FwNpGw%3D%3D" target="_blank">云盾证书</a></p>
      </div>
    </div>
  </div>
  </div>
</article>
<article id="article2">
  <div id="hao">
    <div id="haoDeTP"><div id="pTP">+添加封面</div></div>
   <div id="tyBT"><input type="text" id="haoDeBT" value="请输入标题"
                            onfocus='if(this.value=="请输入标题"){this.value="";}; '
                            onblur='if(this.value==""){this.value="请输入标题";};'/></div>
   <div id="haoDeXX1"><textarea id="haoDeXX" rows="10" cols="50"  style="font-size:20px;"onfocus='if(this.value=="输入内容"){this.value="";}; '
                                onblur='if(this.value==""){this.value="输入内容";};'>输入内容</textarea></div>
   <div style="margin: -3% auto;width: 85px;height: 40px;border-style: none;">
   <input type="submit"  onclick="Coutnds()" value="&nbsp&nbsp提交&nbsp&nbsp" style="font-size:28px;color: ghostwhite;background-color: turquoise;border-color: turquoise;border-radius:5px;"/></div>
  </div>
</article>
<article id="article3">
  <div id="thtp" style="width: 900px;position: relative; height: 550px;background-color:white;margin: 0 auto;">
    <h2 style="width: 250px;height: 30px;margin: 0 auto;padding-top: 3%">选择图片
      <select name="XZTP" id="tpid" style="font-size:18px;">
      <c:forEach var="li" items="${sessionScope.inaList}" >
      <option value="${li.picture}">${li.phId}</option>
      </c:forEach>
      </select>
      <input type="submit" onclick="Cliend()" value="查看图片" style="font-size:18px;"/></h2>
    <div id="Cktp"style="width: 630px;height: 370px;border-style:solid;border-color: #c70c0c;border-width: 13px;margin: 3% auto;">
            <img id="srcCp" src="../ykPhotos/cj0.jpg"alt="请选择图片"width="630px" height="370px">
    </div>
    <div style="margin: -2% auto;width: 85px;height: 40px">
      <input type="submit" name="tijiao" onclick="Coutnd()" value="&nbsp&nbsp提交&nbsp&nbsp" style="font-size:28px;color: ghostwhite;background-color: turquoise;border-color: turquoise;border-radius:5px;"/></div>
  </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">风风个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<a href="#" class="cd-top">Top</a>



<script type="text/javascript">
  $(function () {
      $("#haoDeTP").click(function () {
          $("#article2").hide();
          $("#article3").show();
      })
  })
    var naName1= $("#maName").text();
    $("#article3").hide();
    $("#article2").hide();
    $("#article1").hide();
    if(naName1=="我要发帖"){
       $("#article2").show();
    }else {
       $("#article1").show();
    }
    //安id获得图片
    function Cliend(){
      var diz=$("#tpid").val();
      $("#srcCp").attr("src",""+diz+"");
    }
    //提交数据
    function  Coutnd() {
        var diz=$("#tpid").val();
        $("#article2").show();
        $("#article3").hide();
        $("#pTP").hide();
        $("#haoDeTP").css({"background":"url('"+diz+"')","background-size":"cover"});
    }
    function Coutnds() {
    var diz=$("#tpid").val();
    var bt=$("#haoDeBT").val();
    var nr=$("#haoDeXX").val();
    var opt="opt=abTP&diz="+diz+"&bt="+bt+"&nr="+nr;
    $.get("/haoServlet",opt,mom);
    function mom(name){
        alert(name);
        if(name=="发送成功"){
        //     var opt="opt=main";
        // $.get("/haoServlet",opt,hao);
            window.location.href="../haoServlet?opt=main";
    }
    }
    }
</script>
</body>
</html>
