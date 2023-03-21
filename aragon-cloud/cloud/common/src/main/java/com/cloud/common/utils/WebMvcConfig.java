/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: WebMvcConfig
 * Author:   aragon
 * Date:     2023/3/20 10:19
 * Description: WebMvc配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.utils;

import com.cloud.common.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 〈功能简述〉<br> 
 * 〈WebMvc配置类〉
 *
 * @author aragon
 * @create 2023/3/20
 * @since 1.0.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** swaggerw3-ui */
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
        /** knife4j-ui */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/logout")
                .excludePathPatterns("/nacos/**")
                .excludePathPatterns("/feign/**")
                .excludePathPatterns("/text/**")
                .excludePathPatterns("/token/**")
                .excludePathPatterns("/swagger-ui/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/v3/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/doc.html")
        ;
    }
}