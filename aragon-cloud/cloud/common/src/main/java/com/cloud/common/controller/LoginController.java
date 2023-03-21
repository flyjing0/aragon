/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: ErgouController
 * Author:   王子健
 * Date:     2022/12/19 9:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.controller;

import com.cloud.common.dto.LoginDto;
import com.cloud.common.dto.Result;
import com.cloud.common.entity.User;
import com.cloud.common.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author 王子健
 * @create 2022/12/19
 * @since 1.0.0
 */
@Api(value = "测试类", tags = "登入类")
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

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

    @PostMapping("/logout")
    public Result logout(){
        Result result = new Result();
        result.setCode(20000);
        result.setMessage("登出成功");
        result.setData("success");
        return result;
    }

    @GetMapping("/info")
    public Result profile(){
        Result result = new Result();
        User user = loginService.profile();
        result.setCode(20000);
        result.setMessage("SUCCESS");
        result.setData(user);
        return result;
    }


}