/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: WebLogFilter
 * Author:   Administrator
 * Date:     2022/12/7 13:52
 * Description: 请求拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aragon.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 〈功能简述〉<br> 
 * 〈请求过滤器〉
 *
 * @author Administrator
 * @create 2022/12/7
 * @since 1.0.0
 */
@Component
public class LogFilter implements Filter{
    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 打印请求信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("------------- LogFilter 开始 -------------");
        logger.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
        logger.info("远程地址: {}", request.getRemoteAddr());

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("------------- LogFilter 结束 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
    }
}




