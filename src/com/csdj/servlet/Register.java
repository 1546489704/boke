package com.csdj.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s=(String)request.getSession().getAttribute("vCode");

        PrintWriter out= response.getWriter();//拿到out对象
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/hmtl;charset=UTF-8");
        String username=request.getParameter("username");
        if(s.toLowerCase().equals(username.toLowerCase())){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
