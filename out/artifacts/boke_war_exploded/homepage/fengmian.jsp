<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>首页_风风个人博客 - 一个个人博客网站</title>
<meta name="keywords" content="个人博客,风风个人博客" />
<meta name="description" content="风风个人博客" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<script src="js/jquery.min.js" ></script>
<script src="js/jquery.easyfader.min.js"></script>
<script src="js/hc-sticky.js"></script>
<script src="js/comm.js"></script>
<script src="js/scrollReveal.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<header class="header-navigation" id="header">
  <nav>
    <div class="logo"><a href="http://www.yangqq.com">风风个人博客</a></div>
    <h2 id="mnavh"><span class="navicon"></span></h2>
      <ul id="starlist">
          <li><a href="main.jsp">网站首页</a></li>
          <li><a href="../PhotoServlet?opt=useTup">${sessionScope.maName}</a></li>
        <li><a href="../LeavesServlet?opt=useT">留言板</a></li>
        <li><a href="../PhotoServlet?opt=List">美图分享</a></li>
          <li class="menu"><a href="fengmian.jsp">学无止境</a>
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
<article>
  <main>
    <div class="place" id="pageContents"><a style="text-align: center;font-size: 30px" href="/">经典语录</a></div>
    <div id="da">
    <div class="blogs" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/" target="_blank">别让这些闹心的套路，毁了你的网页设计!</a></h3>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">杨青</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">2018-5-13</li>
        </ul>
      </div>
    </div>

    </div>
    <div class="pagelist"><a title="Total record">&nbsp;<b>160</b> </a>&nbsp;&nbsp;&nbsp;<b>1</b>&nbsp;<a href="/jstt/index_2.html">2</a>&nbsp;<a href="/jstt/index_3.html">3</a>&nbsp;<a href="/jstt/index_4.html">4</a>&nbsp;<a href="/jstt/index_5.html">5</a>&nbsp;<a href="/jstt/index_6.html">6</a>&nbsp;<a href="/jstt/index_2.html">下一页</a>&nbsp;<a href="/jstt/index_14.html">尾页</a></div>
  </main>
  <aside class="r_box" >
      <div class="wdxc">
        <h2>图文精选</h2>
        <ul>
          <c:forEach items="${sessionScope.photoList}" var="page">
            <li><a href="/"><img src="${page.picture}"></a></li>
          </c:forEach>
        </ul>
      </div>
      <div class="cloud">
        <h2>标签云</h2>
        <ul>
          <a href="/">陌上花开</a> <a href="/">校园生活</a> <a href="/">html5</a> <a href="/">SumSung</a> <a href="/">青春</a> <a href="/">温暖</a> <a href="/">阳光</a> <a href="/">三星</a><a href="/">索尼</a> <a href="/">华维荣耀</a> <a href="/">三星</a> <a href="/">索尼</a>
        </ul>
      </div>
      <div class="tuijian">
        <h2 id="tab"><a href="#"class="current">点击排行</a><a href="#">站长推荐</a></h2>
        <div id="content">
          <ul style="display:block;">
            <li><a href="/">第二届 优秀个人博客模板比赛参选活动</a></li>
            <li><a href="/">【活动作品】柠檬绿兔小白个人博客模板</a></li>
            <li><a href="/">帝国cms 列表页调用子栏目，没有则不显示栏目名称</a></li>
            <li><a href="/">2014年度优秀个人博客评选活动</a></li>
            <li><a href="/">你是什么人便会遇上什么人</a></li>
            <li><a href="/">帝国cms 列表页调用子栏目，没有则不显示栏目名称</a></li>
            <li><a href="/">第二届 优秀个人博客模板比赛参选活动</a></li>
            <li><a href="/">个人博客模板《绅士》后台管理</a></li>
          </ul>
          <ul>
            <li><a href="/">个人博客，我为什么要用帝国cms？</a></li>
            <li><a href="/">D设计师博客-一个热爱生活的设计师</a></li>
            <li><a href="/">东轩博客，我看到了你的坚持！</a></li>
            <li><a href="/">程序员创业，就得“豁得出去”！</a></li>
            <li><a href="/">张建华 一个90后年轻站长！我们是对手亦是朋友！</a></li>
            <li><a href="/">《奋斗电商》看知名微商如何做博客引流？</a></li>
            <li><a href="/">《寻之旅》一个关于旅游，游记的个人博客</a></li>
            <li><a href="/">【匆匆那些年】总结个人博客经历的这四年</a></li>
          </ul>
        </div>
      </div>
      <div class="guanzhu">
        <h2>关注我 不迷路</h2>
        <ul>
          <img src="images/IMG_1907(20181214-105955).jpg"/>
        </ul>
      </div>

  </aside>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">风风博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<a href="#" class="cd-top">Top</a>
<script>
  $(function () {
      $.get("/UserServlet","ac=yulu",function (data) {
          $("#da").html(data);
      },"html");
      var obj=null;
      var As=document.getElementById('pageContents').getElementsByTagName('a');
      obj = As[0];
      for(i=1;i<As.length;i++){if(window.location.href.indexOf(As[i].href)>=0)
          obj=As[i];}
      obj.id='pagecurrent'

  })
</script>>
</body>
</html>
