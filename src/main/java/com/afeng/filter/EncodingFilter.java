package com.afeng.filter;

import javax.servlet.*;
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
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy()
    {

    }
}
