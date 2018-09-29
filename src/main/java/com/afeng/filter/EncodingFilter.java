package com.afeng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author afeng
 * @date 2018/9/28 15:28
 **/
public class EncodingFilter implements Filter
{

    public EncodingFilter()
    {


    }


    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(request, response);
    }

    public void destroy()
    {

    }
}
