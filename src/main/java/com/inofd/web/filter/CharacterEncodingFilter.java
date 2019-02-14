package com.inofd.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("拦截请求:" + request);

        HttpServletRequest hsr = (HttpServletRequest) request;
        if (hsr.getMethod().equalsIgnoreCase("post")) {
            request.setCharacterEncoding("UTF-8");

        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
