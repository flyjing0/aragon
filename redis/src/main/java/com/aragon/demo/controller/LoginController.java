/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: ErgouController
 * Author:   Administrator
 * Date:     2022/12/19 9:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aragon.demo.controller;

import com.aragon.demo.dto.LoginDto;
import com.aragon.demo.dto.Result;
import com.aragon.demo.entity.User;
import com.aragon.demo.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2022/12/19
 * @since 1.0.0
 */
@Api(value = "二狗测试类", description = "ergou")
@RestController
@RequestMapping("/ergou")
@MapperScan("com.aragon.demo.mapper")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginDto loginDto){
        Map<String, Object> map = new HashMap<>();
        Result result = new Result();
        if(null != loginDto){
            result = loginService.login(loginDto);
        }else{
                result.setResultCode(500);
                result.setMessage("FAIL");
                result.setData("登录失败");
        }
        map.put("data", result);
        map.put("resultCode", 200);
        map.put("message", "sa1234");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("data", map);
        return map2;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/profile")
    public User profile(){
        Map<String, Object> map = new HashMap<>();
        User user = loginService.profile();
        return user;
    }

}