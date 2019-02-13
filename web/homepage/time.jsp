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
<link href="css/time.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<script src="js/jquery.min.js" ></script>
<script src="js/scrollReveal.js"></script>
<script src="js/time.js" ></script>
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
  <div class="timebox">
    <ul>
      <c:forEach var="list" items="${sessionScope.postsList}">
      <li><span>${list.postingTime}</span><i><a href="/haoServlet?opt=info&id=${list.postId}" target="_blank">${list.type}</a></i></li>
      </c:forEach>
    </ul>
  </div>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">风风个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<a href="#" class="cd-top">Top</a>
</body>
</html>
