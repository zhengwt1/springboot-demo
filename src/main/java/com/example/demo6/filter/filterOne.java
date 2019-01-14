package com.example.demo6.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 */
@WebFilter(urlPatterns = "/*")
public class filterOne implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
           System.out.println("过滤器执行；");
           chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
