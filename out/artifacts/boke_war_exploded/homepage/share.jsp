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
<link href="css/share.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<script src="js/jquery.min.js" ></script>
<script src="js/share.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
  <script type="text/javascript">


         function ondian(obj){
             var type=$(obj).attr("name");
             $.getJSON("/PhotoServlet", "opt=typeList&type="+type, callback);
             function callback(data) {
                 var j = 1;
                 for (var i = 0; i < data.length; i++) {
                     var l = "no" + j;
                     $("." + l + " .tnum").html(data[i].type);
                     $("." + l + " img").attr("src", data[i].picture);
                     $("." + l + " .mbtitle").html(data[i].introduce);
                     j++;
                 }
             }
         }

  </script>
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
        <li><a href="share.jsp">美图分享</a></li>
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
  <%--<div class="topbox">--%>
    <%--<ul>--%>
      <%--<li><i><a href="/"><span class="tnum">1</span><span class="tpic"><img src="images/5.jpg"></span><span class="toptext">html5个人博客模板《simple》</span></a></i></li>--%>
      <%--<li><i><a href="/"><span class="tnum">2</span><span class="tpic"><img src="images/mb2.jpg"></span><span class="toptext">html5个人博客模板《simple》</span></a></i></li>--%>
      <%--<li><i><a href="/"><span class="tnum">3</span><span class="tpic"><img src="images/mb3.jpg"></span><span class="toptext">html5个人博客模板《simple》</span></a></i></li>--%>
      <%--<li><i><a href="/"><span class="tnum">4</span><span class="tpic"><img src="images/mb4.jpg"></span><span class="toptext">html5个人博客模板《simple》</span></a></i></li>--%>
    <%--</ul>--%>
  <%--</div>--%>
  <div class="fenlei">
    <ul>
      <li class="flselect"><a href="#top1">个人博客</a> </li>
      <li onclick="ondian(this)" name="小清新" ><a href="#top2" id="top2">小清新</a></li>
      <li onclick="ondian(this)" name="古风"><a  href="#top3">古风</a> </li>
      <li onclick="ondian(this)" name="性感"><a  href="#top4">性感</a> </li>
      <li onclick="ondian(this)" name="唯美"><a  href="#top5">唯美</a> </li>
    </ul>
  </div>
  <div class="mbans">
    <div class="mban"  style="display: block;" name="top1">
      <ul>
        <c:forEach items="${sessionScope.List}" var="photo">
        <li><i><a href="${photo.picture}"><span class="tnum">动漫</span><img style="height:320px" src="${photo.picture}"> <span class="mbtitle">${photo.introduce}</span> </a></i></li>
        </c:forEach>
      </ul>
    </div>
    <div class="mban" name="top2"  >
      <ul>
        <li class="no1"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb1.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no2"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb4.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no3"><i><a href="/"><span class="tnum">原创</span><img src="images/mb2.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no4"><i><a href="/"><span class="tnum">原创</span><img src="images/mb3.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no5"><i><a href="/"><span class="tnum">原创</span><img src="images/mb5.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
      </ul>
    </div>
    <div class="mban" name="top3"  >
      <ul>
        <li class="no1"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb1.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no2"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb4.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no3"><i><a href="/"><span class="tnum">原创</span><img src="images/mb2.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no4"><i><a href="/"><span class="tnum">原创</span><img src="images/mb3.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no5"><i><a href="/"><span class="tnum">原创</span><img src="images/mb5.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
      </ul>
    </div>
    <div class="mban" name="top4"  >
      <ul>
        <li class="no1"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb1.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no2"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb4.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no3"><i><a href="/"><span class="tnum">原创</span><img src="images/mb2.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no4"><i><a href="/"><span class="tnum">原创</span><img src="images/mb3.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no5"><i><a href="/"><span class="tnum">原创</span><img src="images/mb5.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
      </ul>
    </div>
    <div class="mban" name="top5"  >
      <ul>
        <li class="no1"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb1.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no2"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb4.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no3"><i><a href="/"><span class="tnum">原创</span><img src="images/mb2.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no4"><i><a href="/"><span class="tnum">原创</span><img src="images/mb3.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no5"><i><a href="/"><span class="tnum">原创</span><img src="images/mb5.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
      </ul>
    </div>
    <div class="mban" name="top6"  >
      <ul>
        <li class="no1"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb1.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no2"><i><a href="/"><span  class="tnum">原创</span><img src="images/mb4.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no3"><i><a href="/"><span class="tnum">原创</span><img src="images/mb2.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no4"><i><a href="/"><span class="tnum">原创</span><img src="images/mb3.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
        <li class="no5"><i><a href="/"><span class="tnum">原创</span><img src="images/mb5.jpg"> <span class="mbtitle">个人博客模板《simple》</span> </a></i></li>
      </ul>
    </div>
  </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">风风个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<a href="#" class="cd-top">Top</a>

</body>
</html>
