package com.csdj.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csdj.entity.Comments;
import com.csdj.entity.Posts;
import com.csdj.entity.photo;
import com.csdj.service.CommentsServiceDao;
import com.csdj.service.Impl.CommentsServiceDaoImpl;
import com.csdj.service.Impl.PostsServiceDaoImpl;
import com.csdj.service.PostsServiceDao;
import com.csdj.util.Page;
import jdk.nashorn.internal.runtime.JSONFunctions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 帖子的Servlet类
 */
public class haoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    /**
     * servlet的post方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置字符集编码34 req  35 resp 36 html
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
       resp.setContentType("text/html;charset=utf-8");
       //实现 session方法
       HttpSession session= req.getSession();
       //获得opt的值
       String opt= req.getParameter("opt");
       // new PostsServiceDaoImpl 业务逻辑层
       PostsServiceDao psb=new PostsServiceDaoImpl();
       if(opt.equals("main")){   //主页显示列表
           List<Posts> list=new ArrayList<Posts>();//创建list集合 Posts
           Page pa=new Page();//new 分页对象
           pa.setPageSize(3);
           pa.setTotalCount(psb.Hdts());//设置条数
           list=psb.QueryPostsService(pa.getCurrPageNo(),pa.getPageSize());//查询分页主页
           //时间愁
           List<Posts> postsList=new ArrayList<Posts>();
           postsList=psb.postsList();
           session.setAttribute("postsList",postsList);
           session.setAttribute("page",pa);//储存分页信息
           session.setAttribute("malist",list);//储存值
          resp.sendRedirect("PhotoServlet?opt=selTup");
       }else if(opt.equals("info")){  //查看帖子内容
           int id=Integer.parseInt(req.getParameter("id"));//获得id
           session.setAttribute("postid",id);//储存id
           List<Posts> list=new ArrayList<Posts>();
           list=psb.QueryPosService(id);//按id查询帖
           session.setAttribute("inList",list);//session 把list存起来
           int click=list.get(0).getClick();//获得点击率 getClick
           list.get(0).setClick(click+1);   //设置点击率加1
           psb.UpdatePostsService(id,click); //根据id 修改click   方法UpdatePostsService
           List<Posts> list01 =new ArrayList<Posts>();//新建list01
           List<Posts> list02 =new ArrayList<Posts>();//新建list02
           List<Posts> list03 =new ArrayList<Posts>();//新建list03
           list02=psb.QueryShan(id);//调用上一页的方法QueryShan 把id传过去
           list03=psb.QueryXia(id);//调用下一页的方法QueryXia 把id传过去
           String type1=null;     //初始化type1
           String type2=null;       //初始化type2
           //上一个
           if(list02.size()>0){
               Posts ps=new Posts();
               ps.setuId(id-1);
               ps.setType(list02.get(0).getType());
               list01.add(ps);
               type1="/haoServlet?opt=info&id";
           }else{
               Posts ps=new Posts();
               ps.setType("前面没有了");
               list01.add(ps);
               type1="#?opt=info&id";
           }
           //下一个
           if(list03.size()>0){
               Posts ps=new Posts();
               ps.setuId(id+1);
               ps.setType(list03.get(0).getType());
               list01.add(ps);
               type2="/haoServlet?opt=info&id";
           }else {
               Posts ps=new Posts();
               ps.setType("后面没有了");
               list01.add(ps);
               type2="#?opt=info&id";
           }

           session.setAttribute("type1",type1);
           session.setAttribute("type2",type2);
           session.setAttribute("idList",list01);
           resp.sendRedirect("/CommentsServlet?opt=paging");
       }else if(opt.equals("infos")){ //点赞
           List<Posts> list =new ArrayList<Posts>();           //Posts 的list
           int id=Integer.parseInt(req.getParameter("id"));//获得id
           int like=Integer.parseInt(req.getParameter("like")); //获得like
           psb.UpdatePosService(id,like);//调用updatePosService的修改语法
            list =(List)session.getAttribute("inList");//获得sess里面的inList
            int lik= list.get(0).getLike();//获得list点赞数量  getLike  int 存起来
            list.get(0).setLike(lik+1);//修改setLike的点赞数量
           PrintWriter out=resp.getWriter();//Printwriter
           out.print(list.get(0).getLike());
           out.flush();
           out.close();
       }else  if(opt.equals("inajax")){ //查询上下篇文章方法
           List<photo>list=new ArrayList<photo>();
            list=psb.QueryPhoto();
           PrintWriter out=resp.getWriter();
           session.setAttribute("inaList",list);
           resp.sendRedirect("homepage/about.jsp");
       }else if(opt.equals("abTP")){
           String diz= req.getParameter("diz");
           String bt= req.getParameter("bt");
           String nr= req.getParameter("nr");
           int i=psb.InnsertPhsts(bt,nr,diz);
           System.out.println(i);
           String name1="发送失败";
           if(i>0){ name1="发送成功";}
           PrintWriter out=resp.getWriter();
           out.print(name1);
           out.flush();
           out.close();
       }else if(opt.equals("haode")){
           int i=Integer.parseInt(req.getParameter("i"));
           List<Posts> list=new ArrayList<Posts>();
           Page pa=new Page();
           pa.setCurrPageNo(i);
           pa.setPageSize(3);
           pa.setTotalCount(psb.Hdts());
           list=psb.QueryPostsService(pa.getCurrPageNo(),pa.getPageSize());
           String json= JSON.toJSONString(list, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero);
           PrintWriter out=resp.getWriter();
             out.print(json);
             out.flush();
             out.close();
       }else if(opt.equals("backstage")){
        String name=req.getParameter("bac");
           if(name.equals("我要发帖")){
               resp.sendRedirect("bokehoutai/select.jsp");
           }else{
               resp.sendRedirect("homepage/main.jsp");
           }
       }else if(opt.equals("tiezi")){//ajax查询所有帖子 分页
           int ye=Integer.parseInt(req.getParameter("ye"));
           List<Posts> list=new ArrayList<Posts>();
           Page pa=new Page();
           list=psb.QueryPostsService(ye,pa.getPageSize());
           session.setAttribute("tlpage",pa);
           session.setAttribute("tlList",list);
           String json= JSON.toJSONString(list,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullStringAsEmpty);
           PrintWriter out=resp.getWriter();
           out.print(json);
           out.flush();
           out.close();
       }else if(opt.equals("Sc")){
           int id=Integer.parseInt(req.getParameter("id"));
           int i= psb.postsSc(id);
           resp.sendRedirect("/haoServlet?opt=indexti");
       }else if(opt.equals("haosvle")){
           System.out.println("22423");
            String type=req.getParameter("type");
            String content=req.getParameter("content");
            int id=Integer.parseInt(req.getParameter("id"));
           int i= psb.UpdPosts(type,content,id);
           resp.sendRedirect("/haoServlet?opt=indexti");
       }else if(opt.equals("indexti")){//加载页面 实现分页
           List<Posts> list=new ArrayList<Posts>();
           Page pa=new Page();
           pa.setPageSize(6);
           pa.setTotalCount(psb.Hdts());
           list=psb.QueryPostsService(1,pa.getPageSize());
           session.setAttribute("tlpage",pa);
           session.setAttribute("tlList",list);
           resp.sendRedirect("bokehoutai/tiezi.jsp");
       }
    }
}
