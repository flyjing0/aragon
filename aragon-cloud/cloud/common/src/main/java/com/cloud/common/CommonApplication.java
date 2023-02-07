package com.cloud.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@MapperScan("com.cloud.common.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
// @EnableFeignClients(basePackages="com.cloud.common.feign.*")
@SpringBootApplication
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

}
