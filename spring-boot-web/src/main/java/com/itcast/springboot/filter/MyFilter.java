package com.itcast.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    //初始
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("servlet原生过滤器执行");
        //放行
        chain.doFilter(request, response);
    }
    //销毁
    @Override
    public void destroy() {

    }
}
