package com.cyb.crm.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ccc
 * @create 2021-12-30 9:39
 */
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入到过滤字符编码的过滤器");

        //过滤post请求中文参数乱码
        req.setCharacterEncoding("utf-8");
        //过滤相应刘响应中文乱码
        resp.setContentType("text/html;charset=utf-8");
        //将请求放行
        chain.doFilter(req,resp);
    }
}
