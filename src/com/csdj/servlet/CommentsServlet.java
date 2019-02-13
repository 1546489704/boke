package com.csdj.servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csdj.entity.Comments;
import com.csdj.service.CommentsServiceDao;
import com.csdj.service.Impl.CommentsServiceDaoImpl;
import com.csdj.util.Page;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 评论控制器
 */
@WebServlet(name = "CommentsServlet")
public class CommentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
            doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //客户端(请求)的编码
        request.setCharacterEncoding("utf-8");
        //服务器响应进行重新编码的编码。
        response.setCharacterEncoding("utf-8");
        //服务器响应进行重新编码的编码
        response.setContentType("text/html;charset=utf-8");
        String opt=request.getParameter("opt");
        if ("comAjax".equals(opt)){         //发表评论
            //获得当前时间
            Date d = new Date();
            //设置时间格式yyyy-mm-dd hh:mm:ss
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //格式化字符串f。1
            String Time=df.format(d);
            //评论内容id
            String postid=request.getParameter("it");
            //评论人id
            String pid=request.getParameter("pid");
            //评论内容
            String text=request.getParameter("commText");
            //把评论内容id转为int类型
            int postid1=Integer.parseInt(postid);
            //评论人id转为in他类型
            int pid1=Integer.parseInt(pid);
            //创建Comments对象
            Comments comments=new Comments();
            comments.setPostID(postid1);
            comments.setpID(pid1);
            comments.setCommentText(text);
            comments.setpTime(Time);
            //实例化评论的Service
            CommentsServiceDao csDao=new CommentsServiceDaoImpl();
            //创建输出流PrintWriter
            PrintWriter out=response.getWriter();
            //请求addComments方法的返回值
            int resutlt=csDao.addComments(comments);
            if (resutlt>0){
                out.print("成功");
            }else{
                 out.print("失败");
            }
            //刷新缓存区
            out.flush();
            //关闭流
            out.close();
        }else if ("paging".equals(opt)){                                    //查询评论
            //当前页
            String currPageNo=request.getParameter("currPageNo");
            if (currPageNo==null || (currPageNo=currPageNo.trim()).length()==0){
                currPageNo="1";
            }
            //把当前帖子id强转为int类型
            int id= (int)request.getSession().getAttribute("postid");
            Comments comments = new Comments();
            comments.setPostID(id);
            //实例化评论的Service
            CommentsServiceDao csd = new CommentsServiceDaoImpl();
            //请求统计数方法
            int result=csd.CommentCount(comments);
            //创建page对象
            Page page=new Page();
            //当前页码
            page.setCurrPageNo(Integer.parseInt(currPageNo));
            //每页显示数
            page.setPageSize(3);
            //记录总数
            page.setTotalCount(result);
            //查询评论
            List<Comments> commentsList = csd.listComments(comments,page);
            if (commentsList.size() > 0 || commentsList != null) {
                //把commentsList放到Session里
                request.getSession().setAttribute("commList", commentsList);
                //把page对象放到Session里
                request.getSession().setAttribute("page",page);
            }
            //重定向info.jsp页面
            response.sendRedirect("homepage/info.jsp");
        }else if ("htcomment".equals(opt)){                         //显示分页
                    String currPageNo=request.getParameter("currPageNo");       //获得当前页
                    if (currPageNo==null || (currPageNo=currPageNo.trim()).length()==0){
                        currPageNo="1";
                    }
                    int id=Integer.parseInt(currPageNo);
                    CommentsServiceDao serviceDao=new CommentsServiceDaoImpl();
                    int result=serviceDao.htCommentCount();
                    //创建Page对象
                    Page page=new Page();
                    //当前页码
                    page.setCurrPageNo(id);
                    //每页显示数
                    page.setPageSize(10);
                    //记录总数
                    page.setTotalCount(result);
                    List<Comments> list=serviceDao.htshowComments(page.getCurrPageNo(),page.getPageSize());
                    request.getSession().setAttribute("htcommentlist",list);
                    request.getSession().setAttribute("htpage",page);
                    String json= JSON.toJSONString(list, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteDateUseDateFormat);
                    PrintWriter out=response.getWriter();
                    out.print(json);
                    //刷新缓存区
                    out.flush();
                    //关闭流
                    out.close();
        }else if("htlist".equals(opt)){             //查询全部信息
            CommentsServiceDao serviceDao=new CommentsServiceDaoImpl();
            int result=serviceDao.htCommentCount();
            String tishi=request.getParameter("tishi");
            request.getSession().setAttribute("tishi",tishi);
            Page page=new Page();
            page.setCurrPageNo(1);            //当前页码
            page.setPageSize(10);            //每页显示数
            page.setTotalCount(result);      //记录总数
            List<Comments> list=serviceDao.htshowComments(page.getCurrPageNo(),page.getPageSize());
            request.getSession().setAttribute("htcommentlist",list);
            request.getSession().setAttribute("htpage",page);
            response.sendRedirect("../bokehoutai/comment.jsp");
        }else if ("update1".equals(opt)){            //更新后台评论
            PrintWriter out=response.getWriter();
            int cid=Integer.parseInt(request.getParameter("cid"));
            String text=request.getParameter("text");
            String time=request.getParameter("time");
            CommentsServiceDao serviceDao=new CommentsServiceDaoImpl();
            Comments comments=new Comments();
            comments.setcID(cid);
            comments.setCommentText(text);
            comments.setpTime(time);
            int result=serviceDao.updateCommnets(comments);
            if (result>0){
                    request.getRequestDispatcher("CommentsServlet?opt=htlist&tishi=updateture").forward(request,response);
            }else{
                   request.getRequestDispatcher("CommentsServlet?opt=htlist&tishi=updatefalse").forward(request,response);
            }
        }else if ("delete".equals(opt)){        //删除评论
            int cid=Integer.parseInt(request.getParameter("cid"));
            CommentsServiceDao serviceDao=new CommentsServiceDaoImpl();
            Comments comments=new Comments();
            comments.setcID(cid);
            int result=serviceDao.deletComment(comments);
            if (result>0){
                request.getRequestDispatcher("CommentsServlet?opt=htlist&tishi=delture").forward(request,response);
            }else{
                request.getRequestDispatcher("CommentsServlet?opt=htlist&tishi=delfalse").forward(request,response);
            }
        }
    }
}
