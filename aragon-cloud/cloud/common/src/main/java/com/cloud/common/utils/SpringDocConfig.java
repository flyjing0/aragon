// /**
//  * Copyright (C), 2019-2023, XXX有限公司
//  * FileName: SpringDocConfig
//  * Author:   Administrator
//  * Date:     2023/2/6 16:12
//  * Description:
//  * History:
//  * <author>          <time>          <version>          <desc>
//  * 作者姓名           修改时间           版本号              描述
//  */
// package com.cloud.common.utils;
//
// import com.cloud.common.interceptor.JWTInterceptor;
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import org.springdoc.core.models.GroupedOpenApi;
// import org.springframework.boot.autoconfigure.AutoConfiguration;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
// /**
//  * 〈功能简述〉<br>
//  * 〈〉
//  *
//  * @author Administrator
//  * @create 2023/2/6
//  * @since 1.0.0
//  */
// @AutoConfiguration
// public class SpringDocConfig extends WebMvcConfigurationSupport {
//     @Bean
//     public OpenAPI openAPI() {
//         return new OpenAPI()
//                 .info(new Info()
//                         .title("aragon-cloud接口文档")
//                         .description("基于SpringDoc的在线接口文档")
//                         .version("0.0.1"));
//     }
//
//     @Bean
//     public GroupedOpenApi publicApi() {
//         return GroupedOpenApi.builder()
//                 .group("权限相关")
//                 .packagesToScan("com.iscas.biz.controller.common.auth")
//                 .build();
//     }
//
//     @Bean
//     public GroupedOpenApi adminApi() {
//         return GroupedOpenApi.builder()
//                 .group("默认")
//                 .pathsToMatch("/**")
//                 .build();
//     }
//
//     @Override
//     public void addInterceptors(InterceptorRegistry registry) {
//         registry.addInterceptor(new JWTInterceptor())
//                 .addPathPatterns("/**")
//                 .excludePathPatterns("/user/login")
//                 .excludePathPatterns("/user/logout")
//                 .excludePathPatterns("/nacos/**")
//                 .excludePathPatterns("/feign/**")
//                 .excludePathPatterns("/text/**")
//                 .excludePathPatterns("/swagger-ui/**")
//                 .excludePathPatterns("/swagger-resources/**")
//         ;
//     }
// }
