package com.csdj.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csdj.entity.Informs;
import com.csdj.entity.User;
import com.csdj.entity.yulu;
import com.csdj.service.Impl.InformServiceDaoImpl;
import com.csdj.service.Impl.UserServiceDaoImpl;
import com.csdj.service.Impl.YuluServiceDaoimpl;
import com.csdj.service.InformsServiceDao;
import com.csdj.service.UserServiceDao;
import com.csdj.service.YuluServiceDao;
import com.csdj.util.Page;
import com.csdj.util.fasong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: boke
 *
 * @description: 用户控制器
 *
 * @author: H丶丢心先生
 *
 * @create: 2018-12-17 08:54
 **/
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();//拿到session对象
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //回调字符集编码
        response.setContentType("text/html;charset=utf-8");
        //隐藏域
        String ac=request.getParameter("ac");
        /**
         * 判断是否登录成功
         */
        if(ac.equals("login")){
            //博主信息
            User user1=new User();
            user1.setuName("风风");
            UserServiceDao userServiceDao=new UserServiceDaoImpl();
            List<User> bozhu=userServiceDao.selUsers(user1);
            session.setAttribute("bozhu",bozhu);
            PrintWriter out= response.getWriter();//拿到out对象
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            UserServiceDao dao=new UserServiceDaoImpl();
            User user=new User();
            user=dao.findUser(username,password);
            if(user!=null&&user.getGradeid()!=50){
                String name=null;
                if(user.getGradeid()==100){
                    name="我要发帖";
                }else {
                    name="关于我";
                }
                session.setAttribute("maName",name);
                session.setAttribute("user",user);
                response.sendRedirect("haoServlet?opt=main");
            }else{
                request.setAttribute("error","用户名或密码错误!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            /**
             * 注册用户
             */
        }else if(ac.equals("register")){
            PrintWriter out= response.getWriter();//拿到out对象
            String email=request.getParameter("email");
            String title=email.substring(0,email.indexOf("@"));
            String province=request.getParameter("province");//省
            String city=request.getParameter("city");//市
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String phone=request.getParameter("phone");
            String sex=request.getParameter("sex");
            String age=request.getParameter("age");
            String QQtitle="http://q1.qlogo.cn/g?b=qq&nk="+title+"&s=100";
            int nianlin=Integer.parseInt(age);
            String newlocation=province+city;//加起来
            User user=new User();
            user.setuName(username);
            user.setPassword(password);
            user.setAge(nianlin);
            user.setEmail(email);
            user.setPhone(phone);
            user.setSex(sex);
            user.setSite(newlocation);
            user.setPrcture(QQtitle);
            UserServiceDao dao=new UserServiceDaoImpl();
            int num=dao.insertUser(user);
            if(num>0){
                fasong fa=new fasong();
                try{
                    fa.fa(username,password,email);
                }catch (Exception e){
                    e.printStackTrace();
                }
                response.sendRedirect("login.jsp");
            }else{
                response.sendRedirect("register.jsp");
            }
            /**
             * 判断用户是否存在
             */
        }else if(ac.equals("wei")){
            PrintWriter out= response.getWriter();//拿到out对象
            String username=request.getParameter("username");
            UserServiceDao dao=new UserServiceDaoImpl();
            User user=new User();
            user.setuName(username);
            List<User> list=dao.selUsers(user);
            if(list.size()==0){
                out.print("true");
            }else{
                out.print("false");
            }
            out.flush();
            out.close();
            /**
             * 修改密码
             */
        }else if(ac.equals("xiu")){
            PrintWriter out= response.getWriter();//拿到out对象
            String username=request.getParameter("username");
            String xinpwd=request.getParameter("xinpwd");
            String jiupwd=request.getParameter("jiupwd");
            UserServiceDao dao=new UserServiceDaoImpl();
            int num=dao.updateUser(xinpwd,username,jiupwd);
            if(num>0){
                response.sendRedirect("login.jsp");
            }else{
                request.setAttribute("error","修改失败,用户名或密码填写错误!");
                request.getRequestDispatcher("xiu.jsp").forward(request,response);
            }
            /**
             * 重置密码
             */
        }else if(ac.equals("chong")){
            PrintWriter out= response.getWriter();//拿到out对象
            String username=request.getParameter("username");
            String xinpwd=request.getParameter("xinpwd");
            String email=request.getParameter("email");
            UserServiceDao dao=new UserServiceDaoImpl();
            int num=dao.resetPwd(xinpwd,username,email);
            if(num>0){
                fasong fa=new fasong();
                try{
                    fa.chong(username,xinpwd,email);
                }catch (Exception e){
                    e.printStackTrace();
                }
                response.sendRedirect("login.jsp");
            }else{
                request.setAttribute("error","重置失败,请确认您的邮箱或用户名是否正确!");
                request.getRequestDispatcher("chong.jsp").forward(request,response);
            }
            /**
             * 查询系统通知,返回html
             */
        }else if(ac.equals("tz")){
            PrintWriter out= response.getWriter();//拿到out对象
            InformsServiceDao dao=new InformServiceDaoImpl();
            Informs informs=dao.inform();
            String tz=informs.getInformText();
            if(tz.length()!=0){
                out.print("<p>"+tz+"</p>");
            }
            /**
             * 查询所有语录
             */
        }else if(ac.equals("yulu")){
            YuluServiceDao dao=new YuluServiceDaoimpl();
          List<yulu>  list = dao.selectAll();
           StringBuffer sb=new StringBuffer();
           for(int i=0;i<list.size();i++){
               yulu yulu=list.get(i);
              sb.append("<div class=\"blogs\" data-scroll-reveal=\"enter bottom over 1s\" >\n" +
                      "      <h3 class=\"blogtitle\"><a href=\"/\" target=\"_blank\">"+yulu.getYulu()+"</a></h3>\n" +
                      "      <div class=\"bloginfo\">\n" +
                      "        <ul>\n" +
                      "          <li class=\"author\"><a href=\"/\">"+yulu.getName()+"</a></li>\n" +
                      "          <li class=\"lmname\"><a href=\"/\">"+yulu.getLeibie()+"</a></li>\n" +
                      "          <li class=\"timer\">"+yulu.getTime()+"</li>\n" +
                      "        </ul>\n" +
                      "      </div>\n" +
                      "    </div>");
           }
            PrintWriter out= response.getWriter();//拿到out对象
            out.print(sb.toString());
            out.flush();
            out.close();
            /**
             * 后台查询所有用户
             */
        }else if(ac.equals("selectUser")){
            PrintWriter out= response.getWriter();//拿到out对象
            String pageIndex=request.getParameter("pageIndex");//获得当前页数
            String sex=request.getParameter("sex");             //获得性别
            String name=request.getParameter("name");           //获得用户名
            if(pageIndex==null ||pageIndex.trim().length()==0){
                pageIndex="1";
            }
            int currPageNo=Integer.parseInt(pageIndex);
            //对首页与末页进行控制
            if(currPageNo<1){
                currPageNo=1;
            }
            Page pa=new Page();
            UserServiceDao dao=new UserServiceDaoImpl();
            pa.setTotalCount(dao.selectCount()); //设置总页数
            pa.setCurrPageNo(currPageNo); //设置当前页数
            pa.setPageSize(5);
            User user=new User();
            user.setSex(sex);
            user.setuName(name);
            session.setAttribute("page",pa);
            List<User> list=dao.selectUser(user,pa.getCurrPageNo(),pa.getPageSize());
            String json= JSON.toJSONString(list, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero);
            out.print(json);
            out.flush();
            out.close();
            /**
             * 删除用户
             */
        }else if(ac.equals("del")){
            PrintWriter out= response.getWriter();//拿到out对象
            String id=request.getParameter("id");
            UserServiceDao dao=new UserServiceDaoImpl();
            int uid=Integer.parseInt(id);
            User user=new User();
            user.setuId(uid);
            int num=dao.deleteUser(user);
            System.out.println(num);
            if(num>1){
                out.print("true");
            }else{
                out.print("false");
            }
            out.flush();
            out.close();
            /**
             * 修改用户
             */
        }else if(ac.equals("update")){
            PrintWriter out= response.getWriter();//拿到out对象
            String userid=request.getParameter("userid");
            int  id=Integer.parseInt(userid);
            String name=request.getParameter("name");
            String sex=request.getParameter("sex");
            String email=request.getParameter("email");
            String zhiye=request.getParameter("zhiye");
            User user=new User();
            user.setuId(id);
            user.setuName(name);
            user.setSex(sex);
            user.setEmail(email);
            user.setCareer(zhiye);
            UserServiceDao dao=new UserServiceDaoImpl();
            int num=dao.updateUsers(user);
            if(num>0){
                session.setAttribute("error","修改成功!");
                response.sendRedirect("bokehoutai/select.jsp");
            }else{
                session.setAttribute("error","修改失败!");
                response.sendRedirect("bokehoutai/select.jsp");
            }
            /**
             * 发布系统通知
             */
        }else if(ac.equals("fabu")){
            PrintWriter out= response.getWriter();//拿到out对象
            String text=request.getParameter("text");
            String time=dataTime(new Date());
            Informs informs=new Informs();
            informs.setInformText(text);
            informs.setuDatatime(time);
            InformsServiceDao dao=new InformServiceDaoImpl();
            int num=dao.fabu(informs);
            if(num>0){
                session.setAttribute("error","发布成功!");
                response.sendRedirect("bokehoutai/tongzhi.jsp");
            }else{
                session.setAttribute("error","发布失败!");
                response.sendRedirect("bokehoutai/tongzhi.jsp");
            }
        }else if ("block".equals(ac)){               //查询小黑屋所有用户分页
            String currPageNo=request.getParameter("currPageNo");       //获得当前页
            if (currPageNo==null || (currPageNo=currPageNo.trim()).length()==0){
                currPageNo="1";
            }
            int dangqian=Integer.parseInt(currPageNo);
            UserServiceDao userServiceDao=new UserServiceDaoImpl();
            //查询小黑屋统计总数
            int result=userServiceDao.blockCount();
            Page page=new Page();
            //当前页码
            page.setCurrPageNo(dangqian);
            //每页显示数
            page.setPageSize(4);
            //记录总数
            page.setTotalCount(result);
            List<User> blockList=userServiceDao.blockUser(page);
            request.getSession().setAttribute("blockList",blockList);
            request.getSession().setAttribute("blockPage",page);
            String json= JSON.toJSONString(blockList, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteDateUseDateFormat);
            PrintWriter out=response.getWriter();
            out.print(json);
            out.flush();
            out.close();

        }else if ("blockList".equals(ac)){      //查询小黑屋所有用户
            String yem=request.getParameter("yem");
            String tishiBlock=request.getParameter("tishiBlock");   //提示
            UserServiceDao userServiceDao=new UserServiceDaoImpl();
            //查询小黑屋统计总数
            int result=userServiceDao.blockCount();
            Page page=new Page();
            //当前页码
            page.setCurrPageNo(1);
            //每页显示数
            page.setPageSize(4);
            //记录总数
            page.setTotalCount(result);
            List<User> blockList=userServiceDao.blockUser(page);
            request.getSession().setAttribute("blockList",blockList);
            request.getSession().setAttribute("blockPage",page);
            if (blockList!=null){
                if (yem.equals("xiaoheiwu")){
                    response.sendRedirect("heiwu.jsp");
                }else if (yem.equals("hot")){
                    request.getSession().setAttribute("tishiBlock",tishiBlock);
                    response.sendRedirect("bokehoutai/blacklist.jsp");
                }
            }
        }else if ("blockUpdate".equals(ac)){            //更新小黑屋信息
            int uid=Integer.parseInt(request.getParameter("uid"));    //用户id
//            String time=request.getParameter("time");   //操作时间time
//            String xinwei=request.getParameter("xinwei");//操作行为career
//            String liyou=request.getParameter("liyou");  //操作理由hobby
//            String guoqi=request.getParameter("guoqi");//过期时间site
            UserServiceDao userServiceDao=new UserServiceDaoImpl();
            User user=new User();
            user.setuId(uid);
//            user.setCareer(xinwei);
//            user.setHobby(liyou);
//            user.setSite(guoqi);
//            user.setTime(time);
            int result=userServiceDao.updateBlock(user);
            if (result>0){
                response.sendRedirect("UserServlet?ac=blockList&yem=hot&tishiBlock=updateture");
            }else{
                response.sendRedirect("UserServlet?ac=blockList&yem=hot&tishiBlock=updatefalse");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    //获取当前时间
    public String dataTime(Date date){
        java.text.SimpleDateFormat formater=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formater.format(date);
    }
}
