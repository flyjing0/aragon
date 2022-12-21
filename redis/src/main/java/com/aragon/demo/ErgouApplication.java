package com.aragon.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@MapperScan("com.atagon.demo.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class ErgouApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErgouApplication.class, args);
    }

}
