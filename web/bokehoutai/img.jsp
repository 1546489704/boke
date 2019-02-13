<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>博客后台管理</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
</head>

<body data-type="generalComponents">


    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="javascript:;" class="tpl-logo">
                <img src="123.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">5</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 【预览模块】移动端 查看时 手机、电脑框隐藏。</a>
                            <span class="tpl-dropdown-list-fr">3小时前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span> 移动端，导航条下边距处理</a>
                            <span class="tpl-dropdown-list-fr">15分钟前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span> 追加统计代码</a>
                            <span class="tpl-dropdown-list-fr">2天前</span>
                        </li>
                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-comment-o"></span> 消息 <span class="am-badge tpl-badge-danger am-round">9</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-danger">9</span> 条新消息</h3><a href="###">全部</a></li>
                        <li>
                            <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="assets/img/user02.png" alt=""> </span>
                                <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> 风风 </span>
                                <span class="tpl-dropdown-content-time">10分钟前 </span>
                                </span>
                                <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
                            </a>
                            <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="assets/img/user03.png" alt=""> </span>
                                <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> Steam </span>
                                <span class="tpl-dropdown-content-time">18分钟前</span>
                                </span>
                                <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-calendar"></span> 进度 <span class="am-badge tpl-badge-primary am-round">4</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-primary">4</span> 个任务进度</h3><a href="###">全部</a></li>
                        <li>
                            <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">博客管理 </span>
                                <span class="percent">45%</span>
                                </span>
                                <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-success" style="width:45%"></div></div>
                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">新闻内容页 </span>
                                <span class="percent">30%</span>
                                </span>
                                <span class="progress">
                       <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-secondary" style="width:30%"></div></div>
                    </span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">管理中心 </span>
                                <span class="percent">60%</span>
                                </span>
                                <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-warning" style="width:60%"></div></div>
                    </span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="tpl-header-list-user-nick">${sessionScope.user.uName}</span><span class="tpl-header-list-user-ico"> <img src="${sessionScope.user.prcture}"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                        <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                        <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <li><a href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
            </ul>
        </div>
    </header>





    <div class="tpl-page-container tpl-page-header-fixed">

        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">
                博客管理
            </div>
            <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-table"></i>
                            <span>用户管理</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu">
                            <li>
                                <a href="select.jsp">
                                    <i class="am-icon-angle-right"></i>
                                    <span>查询用户</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>
                                <a href="/UserServlet?ac=blockList&yem=hot">
                                    <i class="am-icon-angle-right"></i>
                                    <span>黑名单查询</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-wpforms"></i>
                            <span>博客管理</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <ul class="tpl-left-nav-sub-menu" style="display: block;">
                            <li>
                                <a href="../haoServlet?opt=indexti">
                                    <i class="am-icon-angle-right"></i>
                                    <span>帖子管理</span>
                                    <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                                </a>

                                <a href="/CommentsServlet?opt=htlist">
                                    <i class="am-icon-angle-right"></i>
                                    <span>评论管理</span>
                                </a>
                                <a href="../PhotoServlet?opt=select">
                                    <i class="am-icon-angle-right"></i>
                                    <span>图片管理</span>
                                </a>
                                  <a href="../LeavesServlet?opt=leav">
                                    <i class="am-icon-angle-right"></i>
                                    <span>留言管理</span>
                                </a>  
                                 <a href="../YujuServlet?opt=selectYuju">
                                    <i class="am-icon-angle-right"></i>
                                    <span>短文管理</span>
                                </a>  
                                 <a href="tongzhi.jsp">
                                    <i class="am-icon-angle-right"></i>
                                    <span>系统通知</span>
                                </a>  
                            </li>
                        </ul>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="login.html" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-key"></i>
                            <span>退出后台系统</span>

                        </a>
                    </li>
                </ul>
            </div>
        </div>




        <div class="tpl-content-wrapper">
            <div class="tpl-content-page-title">
              操作列表
            </div>
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">博客管理</a></li>
                <li class="am-active">图片管理</li>
            </ol>
            <div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 列表
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>


                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-form-group">
                                <select data-am-selected="{btnSize: 'sm'}" class="xiala">
              <option value="option1">所有类别</option>
                                    <c:forEach var="type" items="${sessionScope.typeList}">
              <option value="${type.type}">${type.type}</option>
                                    </c:forEach>

            </select>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" class="am-form-field">
                                <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
          </span>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="tpl-table-images"><%int i=0;%>
                            <c:forEach var="img" items="${sessionScope.xpList}">
                                <% String id="id"+i; i++;pageContext.setAttribute("id",id);%>
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-4"id="${pageScope.id}">
                                <div class="tpl-table-images-content">
                                    <div class="tpl-table-images-content-i-time">发布时间：<a  class="date">${img.date}</a></div>
                                    <div class="tpl-i-title">${img.type}</div>
                                    <a href="javascript:;" class="tpl-table-images-content-i">
                                        <div class="tpl-table-images-content-i-info">
                                        </div>
                                        <span class="tpl-table-images-content-i-shadow" name="${img.phId}"></span>
                                        <img style="height:350px" class="img" src="${img.picture}" alt="">
                                    </a>
                                    <div class="tpl-table-images-content-block">
                                        <div class="tpl-i-font">${img.introduce}</div>
                                        <div class="tpl-i-more">
                                            <ul>
                                                <li><span class="am-icon-qq am-text-warning"> 100+</span></li>
                                                <li><span class="am-icon-weixin am-text-success"> 235+</span></li>
                                                <li><span class="am-icon-github font-green"> 600+</span></li>
                                            </ul>
                                        </div>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs tpl-edit-content-btn">
                                                <button type="button" onclick="bianji(this)" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-edit"></span> 编辑</button>
                                                <button type="button" onclick="delTup(this)" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                            <input type="hidden" id="tishi" value="<%=request.getParameter("tishi")%>">
                                    </div>
                                </div>
                            </div>
                            <div class="am-u-lg-12">
                                <div class="am-cf">
                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li onclick="page(this)" class="am-active" name="1"><a >首页</a></li>
                                            <li onclick="page(this)"  class="am-disabled"  name="${sessionScope.page.currPageNo-1}"><a >«</a></li>
                                            <li><a class="dangqian" >${sessionScope.page.currPageNo}</a></li>
                                            <li ><a class="count"> ${sessionScope.page.totalPageCount}</a></li>
                                            <li onclick="page(this)" class="xia" name="${sessionScope.page.currPageNo+1}"><a>»</a></li>
                                            <li onclick="page(this)" class="am-active" name="${sessionScope.page.totalPageCount}"><a>末页</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <hr>
                            </div>

                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>
        </div>
    </div>


    <script src="../js/jquery-1.8.3.min.js"></script>
    <script src="../js/layer/layer.js"></script>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/app.js"></script>
    <%--ajax分页--%>
     <script type="text/javascript">
         function  page(obj) {
             var id=parseInt($(obj).attr("name"))
             var zong=$(".count").html();
             if (id<1){
                 layer.msg('没有上一页了',{icon:2})
             }else
             if(id-1==zong){
                 layer.msg('没有下一页了',{icon:2})
             }
             else{
                 $.getJSON("/PhotoServlet","currPageNo="+id+"&opt=fenye",callBack)
                 function callBack(JSON){
                        for (var i=0;i<JSON.length;i++){
                            var Tid="id"+i;
                            $("#"+Tid+" .img").attr("src",JSON[i].picture);
                            $("#"+Tid+" .tpl-table-images-content-i-time").html(JSON[i].date);
                            $("#"+Tid+" .tpl-i-title").html(JSON[i].type);
                            $("#"+Tid+" .tpl-i-font").html(JSON[i].introduce)
                        }
                        $(".am-disabled").attr("name",id-1)
                        $(".xia").attr("name",id+1)
                        $(".dangqian").html(id)
                      if(zong==id){
                          var tiaoshu=${sessionScope.page.totalCount};
                          var sheng= tiaoshu%zong;
                          for (var j=0;j<=zong;j++){
                              var Tid="id"+j;
                              if(j>=sheng){
                                  $("#"+Tid).hide()
                              }
                          }
                      }else{
                          for (var j=0;j<=zong;j++){
                              var Tid="id"+j;
                                  $("#"+Tid).show();

                          }
                      }
                 }

             }


         }

         //下拉框查询
         $(".xiala").change(function () {
             var type=$(this).val();
             $.getJSON("/PhotoServlet","type="+type+"&opt=typeList",callBack)
             function callBack(JSON){
                 for (var i=0;i<JSON.length;i++){
                     var Tid="id"+i;
                     $("#"+Tid+" .img").attr("src",JSON[i].picture);
                     $("#"+Tid+" .tpl-table-images-content-i-time").html(JSON[i].date);
                     $("#"+Tid+" .tpl-i-title").html(JSON[i].type);
                     $("#"+Tid+" .tpl-i-font").html(JSON[i].introduce)
                 }
                 $(".am-disabled").attr("name",id-1)
                 $(".xia").attr("name",id+1)
                 $(".dangqian").html(id)

             }
         })


       //   编辑图片
        function bianji(obj) {
             var bian=$(obj).text();
            var introduce=$(obj).parent().parent().prev().prev(".tpl-table-images-content-block .tpl-i-font").text();
             var img=$(obj).parent().parent().parent().prev().children("img").attr("src")
            var type=$(obj).parent().parent().parent().prev().prev().text()
            var date=$(obj).parent().parent().parent().prev().prev().prev().children("a").text()
            var id=$(obj).parent().parent().parent().prev().children("span").attr("name")
              window.location.href="imgUpdate.jsp?introduce="+introduce+"&img="+img+"&type="+type+"&date="+date+"&id="+id


        }
        //删除图片
         function delTup(obj) {
             var id=$(obj).parent().parent().parent().prev().children("span").attr("name")
             window.location.href="/PhotoServlet?opt=delete&id="+id;
         }


         $(function () {
             //提示语句
             if($("#tishi").val()=="updateTure"){
                 layer.msg('修改成功',{icon:1})
             }else if($("#tishi").val()=="updateFalse"){
                 layer.msg('修改失败',{icon:2})
             }else if($("#tishi").val()=="deleteTure"){
                 layer.msg('删除成功',{icon:1})
             }else if($("#tishi").val()=="deleteFalse"){
                 layer.msg('删除失败',{icon:2})
             }
         })


     </script>
</body>

</html>