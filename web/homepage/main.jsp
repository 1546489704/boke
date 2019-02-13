<%@ page import="java.util.List" %>
<%@ page import="com.csdj.entity.Posts" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.csdj.entity.photo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
  <script type="text/javascript" src="../js/dianji.js"></script>
<script src="js/modernizr.js"></script>

<script src="../js/layer/layer.js"></script>
<link href="../js/layui-v2.4.5/layui/css/layui.css" rel="stylesheet">
<style>
    #mane1 input{
        height: 35px;
        width: 70px;
        background-color:transparent;
        color: black;
    }
</style>

    <script>
        $(function () {
            $("#mane1 input").hover(function () {
                $(this).css({"background-color":"white","color":"orangered"});
            },function () {
                $(this).css({"background-color":"transparent","color":"black"});
            });
        })

        function haod(data) {
            var i=parseInt($(data).attr("class"));
            var r=$("#subm").attr("class");
            var y=$("#ye1").html();
            if(i<1){
                alert("前面没有了！！！")
            }else if((i-1)==r){
                alert("后面没有了！！！")
            } else {
                var opt="opt=haode&i="+i;
                $.get("/haoServlet",opt,function (json) {
                    var j=1;
                    var p=json.length;
                    var s=0;
                    for( s=0; s<=json.length;s++){
                        var id="id"+j;j++;
                        $("#"+id+" .blogtitle>a").html(json[s].type);
                        $("#"+id+" .blogtitle>a").attr("href","/haoServlet?opt=info&id="+json[s].postId+"");
                        $("#"+id+" .blogpic>a").attr("href","/haoServlet?opt=info&id="+json[s].postId+"");
                        $("#"+id+" .blogpic a>img").attr("src",""+json[s].picture+"");
                        var neir=null;
                        if(json[s].content.length>=30){
                            neir=json[s].content.substring(0,30);
                        }else {
                            neir=json[s].content;
                        }
                        var i1=parseInt(i+1);
                        var i2=parseInt(i-1);
                        $("#"+id+" .blogtext").html(neir+"...");
                        $("#"+id+" .timer").html(json[s].postingTime);
                        $("#"+id+" .view>span").html(json[s].click);
                        $("#"+id+" .like").html(json[s].like);
                        $("#shan").attr("class",i2);
                        $("#xian").attr("class",i1);
                        $("#ye").html("["+i);
                    }
                },"json");
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

  <!--banner begin-->
  <div class="banner">
    <div id="banner" class="fader">
      <li class="slide" ><a href="/" target="_blank"><img src="../images/cj0 (5).jpg"><span class="imginfo">别让这些闹心的套路!</span></a></li>
      <li class="slide" ><a href="/" target="_blank"><img src="../images/cj0 (6).jpg"><span class="imginfo">个人博客，属于我的小世界！</span></a></li>
      <li class="slide" ><a href="/" target="_blank"><img src="../images/cj0 (7).jpg"><span class="imginfo">个人博客，属于我的小世界！</span></a></li>
      <div class="fader_controls">
        <div class="page prev" data-target="prev">&lsaquo;</div>
        <div class="page next" data-target="next">&rsaquo;</div>
        <ul class="pager_list">
        </ul>
      </div>
    </div>
  </div>
  <!--banner end-->
  <div class="toppic">
    <li> <a href="/" target="_blank"> <i><img src="../images/timg.jpg"></i>
      <h2>安静地做一个爱it的孩子</h2>
      <span>学无止境</span> </a> </li>
    <li> <a href="/" target="_blank"> <i><img src="../images/timg (1).jpg"></i>
      <h2>个人博客，属于我的小世界！</h2>
      <span>学无止境</span> </a> </li>
  </div>
  <main>
  <div class="news_box">
    <%--首页图片--%>
    <ul>
      <c:forEach items="${sessionScope.photoList}" var="photo">
      <li><i><a href="${photo.picture}"><img src="${photo.picture}"></a></i>
          <c:if test="${fn:length(photo.introduce)>10}">
              <c:set var="img" value="${fn:substring(photo.introduce,0 ,10 )}">
              </c:set>
          </c:if>
          <c:if test="${fn:length(photo.introduce)<10}">
              <c:set var="img" value="${photo.introduce}">
              </c:set>
          </c:if>
        <h3><a href="/">${img}...</a></h3>
      </li>
      </c:forEach>
    </ul>
  </div>
  
  <div class="blogtab">
    <%--截取文章不全显示--%>
      <%
          Posts posts=new Posts();
          List nrong=(List)session.getAttribute("malist");
          List<Posts> postslist=new ArrayList<Posts>();
          for (int i=0;i<nrong.size();i++){
              posts=(Posts)nrong.get(i);
              String san=null;
              if(posts.getContent().length()>30) {
                 san = posts.getContent().substring(0, 30);
              }else{
                 san=posts.getContent();
              }
               posts.setContent(san);
              postslist.add(posts);
          }
          session.setAttribute("pList",postslist);
      int i=0;%>
    <c:forEach items="${sessionScope.pList}" var="li" >
        <% i++; request.setAttribute("id","id"+i);%>
    <div class="blogs" id="${requestScope.id}" data-scroll-reveal="enter bottom over 1s" >
      <h3 class="blogtitle"><a href="/haoServlet?opt=info&id=${li.postId}" target="_blank" name="">${li.type}</a></h3>
      <span class="blogpic"><a href="/haoServlet?opt=info&id=${li.postId}" title="" name=""><img src="${li.picture}" alt=""></a></span>
      <p class="blogtext">${li.content}.. </p>
      <div class="bloginfo">
        <ul>
          <li class="author"><a href="/">${li.getUser().get(0).getuName()}</a></li>
          <li class="lmname"><a href="/">学无止境</a></li>
          <li class="timer">${li.postingTime}</li>
          <li class="view"><span>${li.click}</span></li>
          <li class="like">${li.like}</li>
        </ul>
      </div>
    </div>
    </c:forEach>
        <div id="mane1" style="width: 450px;height: 42px;margin: 0 auto;">
            <input type="submit" s; class="${1}" value="&nbsp;&nbsp;首页&nbsp;&nbsp;" onclick="haod(this)"/>
            <input type="submit"  id="shan" class="${sessionScope.page.currPageNo-1}" value="&nbsp;上一页&nbsp;"onclick="haod(this)"/>
            <span id="ye"type="submit" style="font-size:20px;">[${sessionScope.page.currPageNo}</span>
            <span id="ye1" type="submit" style="font-size:20px;">/${sessionScope.page.totalPageCount}]</span>
            <input type="submit"type="submit" id="xian" class="${sessionScope.page.currPageNo+1}" value="&nbsp;下一页&nbsp;"onclick="haod(this)"/>
            <input type="submit"type="submit"  id="subm" class="${sessionScope.page.totalPageCount}" value="&nbsp;&nbsp;尾页&nbsp;&nbsp;"onclick="haod(this)"/>
       </div>
  </div>
</div>
  </main>
  <aside class="r_box" >
      <div class="about_me">
        <h2>博主简介</h2>
        <ul>
          <i><img src="${sessionScope.bozhu.get(0).prcture}"></i>
          <p><b>${sessionScope.bozhu.get(0).uName}</b>，${sessionScope.bozhu.get(0).hobby}。</p>
        </ul>
      </div>
      <div class="wdxc">
        <h2>图片精选</h2>
        <ul>
          <c:forEach items="${pageScope.photoList}" var="page">
          <li><a href="/"><img src="${page.picture}"></a></li>
          </c:forEach>
        </ul>
      </div>

      <div class="tuijian">
        <h2 id="tab"><a href="#"class="current">活动公告</a><a href="#">点击排行</a><a href="#">站长推荐</a></h2>
        
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
          <li><a href="/">你是什么人便会遇上什么人</a></li>
          <li><a href="/">帝国cms 列表页调用子栏目，没有则不显示栏目名称</a></li>
          <li><a href="/">第二届 优秀个人博客模板比赛参选活动</a></li>
          <li><a href="/">个人博客模板《绅士》后台管理</a></li>
          <li><a href="/">你是什么人便会遇上什么人</a></li>
          <li><a href="/">帝国cms 列表页调用子栏目，没有则不显示栏目名称</a></li>
          <li><a href="/">第二届 优秀个人博客模板比赛参选活动</a></li>
          <li><a href="/">黑色质感时间轴html5个人博客模板</a></li>
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
          <img src="../images/199.jpg">
        </ul>

      </div>

  </aside>
</article>
<footer>
  <p>Design by <a href="http://www.yangqq.com" target="_blank">杨青个人博客</a> <a href="/">蜀ICP备11002373号-1</a><a href="/" class="links">友情链接</a></p>
</footer>
<a href="#" class="cd-top">Top</a>

<div class="layui-layer layui-layer-page layer-ext-moon" id="layui-layer2" type="page"
     times="2" showtime="0" contype="string" style="position: fixed;z-index: 10000;display: none; width: 350px; top: 488px; left: 1115px;">
    <div class="layui-layer-title" style="cursor: pointer;padding-bottom: 10px; padding-left: 80px; font-weight:bold;height: 24px;background: rgba(0,0,0,0.4)">登陆通知&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;×</div>
    <div id="xiaobozai" class="layui-layer-content">
        <div style="padding: 12px;background-color: #e2e2e2;">
            <b>登陆IP：</b>175.9.129.17<br>
            <b>登录地址：</b>湖南省-长沙市<br>
            <b>登录时间：</b>${sessionScope.time}<br>
            <small style="color:#999;">如果登录地点异常，建议立即修改密码！</small>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#layui-layer2").fadeIn(1500);
        $(".layui-layer-title").click(function () {
            $("#layui-layer2").fadeOut(1500);
        });
    })
</script>
</body>
</html>
