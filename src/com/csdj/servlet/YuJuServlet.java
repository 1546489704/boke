package com.csdj.servlet;

import com.csdj.entity.yulu;
import com.csdj.service.Impl.YuluServiceDaoimpl;
import com.csdj.service.YuluServiceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "YuJuServlet")
public class YuJuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt=request.getParameter("opt");
        if(opt.equals("selectYuju")){ //后台查询全部语句
            String tishi=request.getParameter("tishi");
            request.getSession().setAttribute("tishi",tishi);
            YuluServiceDao yuluServiceDao=new YuluServiceDaoimpl();
            List<yulu> yuluList=yuluServiceDao.selectAll();
            request.getSession().setAttribute("yuluList",yuluList);
            response.sendRedirect("../bokehoutai/duanwen.jsp");
        }else if(opt.equals("update")){ //修改短语
            String type=request.getParameter("type");
            String name=request.getParameter("name");
            String time=request.getParameter("time");
            String introduce=request.getParameter("introduce");
            String id=request.getParameter("id");
            yulu yulu=new yulu();
            yulu.setName(name);
            yulu.setLeibie(type);
            yulu.setTime(time);
            yulu.setYulu(introduce);
            yulu.setId(Integer.parseInt(id));
            YuluServiceDao yuluServiceDao=new YuluServiceDaoimpl();
            int result=yuluServiceDao.updateYulu(yulu);
            if(result>0){
                response.sendRedirect("YujuServlet?opt=selectYuju&tishi=UpdateTure");
            }else{
                response.sendRedirect("YujuServlet?opt=selectYuju&tishi=UpdateFalse");
            }

        }else if(opt.equals("delete")){
            String id=request.getParameter("id");
            YuluServiceDao yuluServiceDao=new YuluServiceDaoimpl();
            int result=yuluServiceDao.delectByid(Integer.parseInt(id));
            if(result>0){
                response.sendRedirect("YujuServlet?opt=selectYuju&tishi=DeleteTure");
            }else{
                response.sendRedirect("YujuServlet?opt=selectYuju&tishi=DeleteFalse");
            }
        }else if(opt.equals("insert")){
            String type=request.getParameter("type");
            String name=request.getParameter("name");
            String time=request.getParameter("time");
            String introduce=request.getParameter("introduce");
            yulu yulu=new yulu();
            yulu.setName(name);
            yulu.setLeibie(type);
            yulu.setTime(time);
            yulu.setYulu(introduce);
            YuluServiceDao yuluServiceDao=new YuluServiceDaoimpl();
            int result=yuluServiceDao.insertYulu(yulu);
            if(result>0){
                response.sendRedirect("YujuServlet?opt=selectYuju&tishi=InsertTure");
            }else{
                response.sendRedirect("YujuServlet?opt=selectYuju&tishi=InsertFalse");
            }


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
