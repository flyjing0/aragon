package com.aragon.excle.easyexcle.test;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excle")
public class EasyExcleTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/test")
    public String test(){

        String str = JSON.toJSONString(redisTemplate.opsForValue().get("user"));
        return str;
    }

}
