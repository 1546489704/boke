package com.csdj.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csdj.dao.Impl.UserDaoImpl;
import com.csdj.dao.UserDao;
import com.csdj.entity.User;
import com.csdj.entity.photo;
import com.csdj.service.Impl.PhotoServiceImpl;
import com.csdj.service.Impl.PostsServiceDaoImpl;
import com.csdj.service.Impl.UserServiceDaoImpl;
import com.csdj.service.PhotoService;
import com.csdj.service.PostsServiceDao;
import com.csdj.service.UserServiceDao;
import com.csdj.util.Page;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @program: boke
 *
 * @description: 相册控制器
 *
 * @author: YinKang
 *
 * @create: 2018-12-17
 **/
@WebServlet(name = "PhotoServlet")
public class PhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        //设置回响字符集
         response.setContentType("text/html;chaset=utf-8");
         //if判断条件
         String opt=request.getParameter("opt");
         //得到session对象
        HttpSession session= request.getSession();
        //实例化Service层
        PhotoService photoService=new PhotoServiceImpl();
        if(opt.equals("selTup")){ //首页六张图
            //请求servlice查询六张图片
            List<photo> photoList= photoService.selPhoto();
            //存放到session
            request.getSession().setAttribute("photoList",photoList);
            //时间
            String time=dataTime(new Date());
            //把时间存放到session
            session.setAttribute("time",time);
            //重定向到主页
            response.sendRedirect("homepage/main.jsp");
        }else if(opt.equals("useTup")){ //个人介绍四张图 博主简介
            //请求servlice查询四张图片
            List<photo> photoList= photoService.UserPhoto();
            //实例化list出来
            List<photo>list=new ArrayList<photo>();
            //实例化帖子posts的Service
            PostsServiceDao psb=new PostsServiceDaoImpl();
            //请求posts的Service得到方法赋值给list
            list=psb.QueryPhoto();
            //存到session里面
            session.setAttribute("inaList",list);
            //把四张图存到Session里面
            request.getSession().setAttribute("Userphoto",photoList);
            //重定向出去
            response.sendRedirect("homepage/about.jsp");
        }else if(opt.equals("List")){ //美图分享首10张
            //请求Service得到图片
            List<photo> photoList= photoService.Photo();
            //存放到Session里面
            request.getSession().setAttribute("List",photoList);
            //重定向出去
            response.sendRedirect("homepage/share.jsp");
        }else if(opt.equals("typeList")){
            String type=request.getParameter("type");
            photo p=new photo();
            System.out.println(type);
            p.setType(type);
            PhotoService photoService1=new PhotoServiceImpl();
            List<photo> pList=photoService1.typeList(p);
            String json= JSON.toJSONString(pList, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteDateUseDateFormat);
            PrintWriter out=response.getWriter();
            System.out.println(json);
            out.print(json);
            out.flush();
            out.close();
        }else if(opt.equals("fenye")){
            PhotoService photoService1=new PhotoServiceImpl();
            int id=Integer.parseInt(request.getParameter("currPageNo"));
             Page page=new Page();
            page.setPageSize(6);
            page.setCurrPageNo(id);
            List<photo> xpList=photoService1.PhotoSel(page.getCurrPageNo(),6);
            String json= JSON.toJSONString(xpList, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteDateUseDateFormat);
            PrintWriter out=response.getWriter();
            out.print(json);
            out.flush();
            out.close();

        }else if(opt.equals("update")){  //编辑图片
            String date=request.getParameter("date");  //时间
            String type=request.getParameter("type");  //类型
            String text=request.getParameter("text");  //内容
            String id=request.getParameter("id");    //id
                photo photo=new photo();
                photo.setDate(date);
                photo.setType(type);
                photo.setIntroduce(text);
                photo.setPhId(Integer.parseInt(id));
                PhotoService photoService1=new PhotoServiceImpl();
                int result=photoService1.update(photo);
                if(result>0){
                    request.setAttribute("tishi","updateTure");
                    request.getRequestDispatcher("PhotoServlet?opt=select").forward(request,response);
                }else{
                    request.setAttribute("tishi","updateFalse");
                    request.getRequestDispatcher("PhotoServlet?opt=select").forward(request,response);
                }


        }else if(opt.equals("select")){ //后台查询所有图片
              String tishi=(String)request.getAttribute("tishi");
                PhotoService photoService1=new PhotoServiceImpl();
                Page page=new Page();
                page.setCurrPageNo(1);
                page.setPageSize(6);
                int PageSize=photoService1.count();
                page.setTotalCount(PageSize);
                List<photo> xpList=photoService1.PhotoSel(1,6);
                List<photo> typeList=photoService1.PType();
                session.setAttribute("page",page);
                session.setAttribute("typeList",typeList);
                session.setAttribute("xpList",xpList);
                response.sendRedirect("../bokehoutai/img.jsp?tishi="+tishi);
        }else if(opt.equals("delete")){  //删除图片
            String id=request.getParameter("id");    //id
            photo photo=new photo();
            photo.setPhId(Integer.parseInt(id));
            PhotoService photoService1=new PhotoServiceImpl();
            int result=photoService1.delePhoto(photo);
            if(result>0){
                request.setAttribute("tishi","deleteTure");
                request.getRequestDispatcher("PhotoServlet?opt=select").forward(request,response);
            }else{
                request.setAttribute("tishi","deleteFalse");
                request.getRequestDispatcher("PhotoServlet?opt=select").forward(request,response);
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    //获取ip地址
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    //获取当前时间
    public String dataTime(Date date){
        java.text.SimpleDateFormat formater=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formater.format(date);
    }
}
