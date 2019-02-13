package com.csdj.servlet;

import com.csdj.entity.Leaves;
import com.csdj.service.Impl.LeavesServiceImpl;
import com.csdj.service.LeavesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeavesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opt=req.getParameter("opt");
        HttpSession session=req.getSession();
        LeavesService ls=new LeavesServiceImpl();
        if(opt.equals("leav")){
            List<Leaves> list=new ArrayList<Leaves>();
            list= ls.SesLeaves();
            session.setAttribute("LeaList",list);
            resp.sendRedirect("bokehoutai/liuyan.jsp");
        }else if(opt.equals("Sclea")){
            int id=Integer.parseInt(req.getParameter("id"));
            int i=0;
            i=ls.DatLeaves(id);
            resp.sendRedirect("/LeavesServlet?opt=leav");
        }else if(opt.equals("useT")){
            List<Leaves> list=new ArrayList<Leaves>();
            list=ls.SelecLeaves();
            session.setAttribute("usList",list);
            resp.sendRedirect("homepage/list.jsp");
        }else if(opt.equals("listmai")){
            String name=req.getParameter("name");
            int id=Integer.parseInt(req.getParameter("id"));
            int i= ls.InnLeaves(id,name);
            System.out.println(i);
            resp.sendRedirect("/LeavesServlet?opt=useT");
        }
    }
}
