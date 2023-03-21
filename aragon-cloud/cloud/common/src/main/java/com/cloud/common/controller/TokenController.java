/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: TokenController
 * Author:   aragon
 * Date:     2023/3/17 14:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.controller;

import com.cloud.common.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author aragon
 * @create 2023/3/17
 * @since 1.0.0
 */
@RestController
@Api(tags = "Token控制类")
@RequestMapping(value = "/token")
public class TokenController {

    @ApiOperation("获取测试token")
    @GetMapping(value = "/getTestToken")
    public String getTestToken(){
        return JwtUtils.getTestToken();
    }

    @ApiOperation("获取2分钟测试token")
    @GetMapping(value = "/getToken")
    public String getToken(){
        Map<String, String> map = new HashMap<>();
        map.put("id", "test");
        map.put("name", "test");
        return JwtUtils.getToken(map);
    }
}