/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: RedisTest
 * Author:   Administrator
 * Date:     2022/11/8 12:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.common.test.stream.eneity.Stutends;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2022/11/8
 * @since 1.0.0
 */
@Tag(name = "Redis测试类", description = "aaaa")
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    Logger logger = LoggerFactory.getLogger(RedisTestController.class);

    @Autowired
    private RedisTemplate redisTemplate;


    @Operation(summary = "方法一")
    @PostMapping("/test")
    public String test(){
        List<Stutends> list = new ArrayList<>();
        Stutends stu = new Stutends("张一", 8, "一");
        list.add(stu);
        stu = new Stutends("张三三", 9, "二");
        list.add(stu);
        stu = new Stutends("李四四", 10, "三");
        list.add(stu);
        stu = new Stutends("张五五", 11, "四");
        list.add(stu);
        stu = new Stutends("李二二", 12, "五");
        list.add(stu);
        stu = new Stutends("王一一", 13, "六");
        list.add(stu);
        redisTemplate.opsForValue().set("stutends", list);
        return JSON.toJSONString(redisTemplate.opsForValue().get("stutends"));
    }

    @Operation(summary = "方法二")
    @PostMapping("/test2")
    public String test2(@RequestBody Stutends stutend){
        // logger.info("Enter Function {} Param {}", Thread.currentThread().getStackTrace()[1].getMethodName(), JSON.toJSONString(stutend));
        // logger.info("Exist Function {} Param {}", Thread.currentThread().getStackTrace()[1].getMethodName(), JSON.toJSONString(stutend));
        return "666";
    }

    public static void main(String[] args) {
        List<Stutends> list = new ArrayList<>();
        Stutends stu = new Stutends("张一", 8, "一");
        list.add(stu);
        stu = new Stutends("张三", 9, "二");
        list.add(stu);
        stu = new Stutends("李四", 10, "三");
        list.add(stu);
        stu = new Stutends("张五", 11, "四");
        list.add(stu);
        stu = new Stutends("李二", 12, "五");
        list.add(stu);
        stu = new Stutends("王一", 13, "六");
        list.add(stu);
        System.out.println(list);
        list.stream().sorted((o1, o2) -> o2.name.compareTo(o1.name)).forEach(
                o -> System.out.println(o)
        );
    }

}