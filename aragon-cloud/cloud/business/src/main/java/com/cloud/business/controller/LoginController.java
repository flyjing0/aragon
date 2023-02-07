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
package com.cloud.business.controller;

import com.cloud.business.dto.LoginDto;
import com.cloud.business.dto.Result;
import com.cloud.business.entity.User;
import com.cloud.business.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "二狗测试类", description = "ergou")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "登录")
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

    @Operation(summary = "获取用户信息")
    @GetMapping("/info")
    public Result profile(){
        Result result = new Result();
        User user = loginService.profile();
        result.setCode(20000);
        result.setMessage("SUCCESS");
        result.setData(user);
        return result;
    }


    @Operation(summary = "登出")
    @PostMapping("/logout")
    public Result logout(){
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("登出成功");
        result.setData("success");
        return result;
    }
}