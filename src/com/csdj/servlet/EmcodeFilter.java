package com.csdj.servlet;


import javax.servlet.*;
import java.io.IOException;

public class EmcodeFilter implements Filter {
    private  String encode;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encode=filterConfig.getInitParameter("encode");
        if (this.encode==null){
            this.encode=encode;     //查找配置文件中设置的字符集编码
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
            if (servletRequest.getCharacterEncoding()==null){
                servletRequest.setCharacterEncoding(this.encode);
            }
            //把请求发到下一个Filter
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        encode=null;
    }
}
