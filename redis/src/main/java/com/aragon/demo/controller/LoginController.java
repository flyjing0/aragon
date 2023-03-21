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
import lombok.extern.log4j.Log4j;
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
@RequestMapping("/user")
@MapperScan("com.aragon.demo.mapper")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto){
        Map<String, Object> map = new HashMap<>();
        Result result = new Result();
        if(null != loginDto){
            result = loginService.login(loginDto);
        }else{
                result.setCode(50008);
                result.setMessage("FAIL");
                result.setData("登录失败");
        }
        return result;
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result profile(){
        Result result = new Result();
        User user = loginService.profile();
        result.setCode(20000);
        result.setMessage("SUCCESS");
        result.setData(user);
        return result;
    }


    @ApiOperation("登出")
    @PostMapping("/logout")
    public Result logout(){
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("登出成功");
        result.setData("success");
        return result;
    }
}