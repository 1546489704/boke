
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
    <title>首页_风风个人博客 - 一个个人博客网站</title>
    <meta name="keywords" content="个人博客,风风个人博客" />
    <meta name="description" content="风风个人博客" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/info.css" rel="stylesheet">
<link href="css/m.css" rel="stylesheet">
<script src="js/jquery.min.js" ></script>
<script src="js/jquery.easyfader.min.js"></script>
<script src="js/hc-sticky.js"></script>
<script src="js/comm.js"></script>
<script src="js/scrollReveal.js"></script>
<script src="js/modernizr.js"></script>
  <!--评论样式 -->
  <link rel="stylesheet" type="text/css" href="../huifu/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="../huifu/css/huifuYangshi.css">
<script src="js/modernizr.js"></script>
<!--<script src="../js/jquery-1.8.3.min.js"></script>-->
    <script src="../js/layer/layer.js"></script>
<script type="text/javascript">
  $(function() {

      var i=$("#id13").val();
      var m=$("#id14").val();
    $("#like").click(function() {
      var name="opt=infos&id="+i+"&like="+m;
      $.get("/haoServlet",name,callba);
      function callba(data) {
         $("#like").hide();
         $(".diggit").html("亲！点个赞哦!("+data+")").css("background-color","#9d9d9d").css("color","#080808");
      }
});

  });
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
          <li><a href="list.jsp">留言板</a></li>
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
  <div class="infosbox">
    <div class="newsview">
      <h3 class="news_title">${sessionScope.inList.get(0).type}</h3>
      <div class="bloginfo">
        <ul>
          <li class="author">作者：<a href="/">${sessionScope.inList.get(0).getUser().get(0).getuName()}</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">时间：${sessionScope.inList.get(0).postingTime}</li>
          <li class="view">${sessionScope.inList.get(0).click}人已阅读</li>
        </ul>
      </div>
      <div class="tags"><a href="/" target="_blank">个人博客</a> &nbsp; <a href="/" target="_blank">小世界</a></div>
      <div class="news_about"><strong>简介</strong>个人博客，用来做什么？我刚开始就把它当做一个我吐槽心情的地方，也就相当于一个网络记事本，写上一些关于自己生活工作中的小情小事，也会放上一些照片，音乐。每天工作回家后就能访问自己的网站，一边听着音乐，一边写写文章。</div>
      <div class="news_con">
        <img alt="" src="${sessionScope.inList.get(0).picture}"><br>
        <br/>
       &nbsp;&nbsp; ${sessionScope.inList.get(0).content}
        &nbsp; </div>
    </div>
    <div class="share">
        <p class="diggit" ><a href="#"id="like">亲！点个赞哦!</a>(${sessionScope.inList.get(0).like})</p>
      <input type="hidden" id="id13" value="${sessionScope.inList.get(0).postId}"/>
      <input type="hidden" id="id14" value="${sessionScope.inList.get(0).like}"/>
    </div>
    <div class="nextinfo">
      <p>上一篇：<a href="${sessionScope.type1}=${sessionScope.idList.get(0).uId}" id="shang" >${sessionScope.idList.get(0).type}</a></p>
      <p>下一篇：<a href="${sessionScope.type2}=${sessionScope.idList.get(1).uId}" id="xian">${sessionScope.idList.get(1).type}</a></p>
    </div>
    <div class="news_pl">
      <h2>文章评论</h2>
      <div class="container">
        <div class="commentbox">
          <div id="divy"></div>
          <textarea cols="80" rows="50" placeholder="来说几句吧......" class="mytextarea" id="content1"></textarea>
          <div class="btn btn-info pull-right" id="comment">评论</div>
          <input type="hidden" id="putid" value="${sessionScope.user.uName}">
          <div class="comment-list">


          </div>
        </div>
          <div class="pagelist" style="margin-left:-290px;">
              <a title="Total record">&nbsp;<b>第${sessionScope.page.currPageNo}页共${sessionScope.page.totalPageCount}页</b> </a>
              <c:if test="${sessionScope.page.currPageNo<2}">
                  <style type="text/css">
                       .shangyiye{
                          text-decoration:none;
                          outline:0 none;
                          /*font:12px/1.5 \5B8B\4F53, Georgia, Times New Roman, serif, arial;*/
                           color: #A9A9A9;
                          pointer-events:none;
                          color:#afafaf;
                          cursor:default
                      }
                  </style>
              </c:if>
              <c:if test="${page.currPageNo>=page.totalPageCount}">
              <style type="text/css">
                  .xiayiye{
                      text-decoration:none;
                      outline:0 none;
                      /*font:12px/1.5 \5B8B\4F53, Georgia, Times New Roman, serif, arial;*/
                      color: #A9A9A9;
                      pointer-events:none;
                      color:#afafaf;
                      cursor:default
                  }
              </style>
              </c:if>
              &nbsp;<a href="/CommentsServlet?opt=paging&currPageNo=1" class="shoye">首页</a>
              &nbsp;<a href="/CommentsServlet?opt=paging&currPageNo=${page.currPageNo-1 }" class="shangyiye">上一页</a>
              &nbsp;<a href="/CommentsServlet?opt=paging&currPageNo=${page.currPageNo+1 }" class="xiayiye">下一页</a>
              &nbsp;<a href="/CommentsServlet?opt=paging&currPageNo=${page.totalPageCount}" class="weiye">尾页</a>
          </div>


        <!--<script type="text/javascript" src="../huifu/js/jquery.min.js"></script>-->
        <script type="text/javascript" src="../huifu/js/jquery.comment.js" ></script>
        <script type="text/javascript" src="../huifu/js/bootstrap.min.js"></script>
      <script type="text/javascript">
        //初始化数据
        var arr = [
         <c:forEach var="list" items="${sessionScope.commList}" varStatus="i" >
            {id:1,img:"${list.userList.get(i.index).prcture}",
                replyName:"${list.userList.get(i.index).uName}",
                beReplyName:"匿名",content:"${list.commentText}",
                time:"${list.pTime}",address:"${list.userList.get(i.index).site}",
                osname:"",
                browse:"谷歌",replyBody:[]},

            </c:forEach>
        ];
         var name="${sessionScope.user.uName}";
        $(function(){
            $(".comment-list").addCommentList({data:arr,add:""});
            $("#comment").click(function(){
                var obj = new Object();
                obj.img="${sessionScope.user.prcture}";
                //评论人姓名
                obj.replyName="${sessionScope.user.uName}";
                //评论内容
                obj.content=$("#content1").val();
                //评论人地址
                obj.browse="${sessinoScope.user.site}";
                obj.osname="win10";
                obj.replyBody=""
                var id=${sessionScope.postid}
                var pid=${sessionScope.user.uId}
                $(".comment-list").addCommentList({data:[],add:obj});
                $.get("/CommentsServlet","opt=comAjax&commText="+obj.content+"&pid="+pid+"&it="+id,cuurre);
                function cuurre(data) {
                if(data=="成功"){
                    layer.msg('评论成功!', {icon: 1});
                    $("#content1").val("");
                   }
                }
            });
        })
        </script>
  </div>
  </div>
  </div>
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
      <h2>关注我 么么哒</h2>
      <ul>
        <img src="images/wx.jpg">
      </ul>
    </div>

  </aside>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">杨青个人博客</a> <a href="/">蜀ICP备11002373号-1</a></p>
</footer>
<a href="#" class="cd-top">Top</a>
</body>
</html>
