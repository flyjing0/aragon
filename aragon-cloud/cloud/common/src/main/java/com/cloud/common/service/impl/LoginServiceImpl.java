/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: LoginServiceImpl
 * Author:   王子健
 * Date:     2022/12/19 10:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.common.dto.LoginDto;
import com.cloud.common.dto.Result;
import com.cloud.common.entity.User;
import com.cloud.common.mapper.UserMapper;
import com.cloud.common.service.LoginService;
import com.cloud.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(LoginDto loginDto) {
        Result result = new Result();
        User user = new User();
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", loginDto.getUsername());
        user = userMapper.selectOne(qw);
        if(null == user){
            result.setCode(50008);
            result.setMessage("SUCCESS");
            result.setData("用户名不存在！");
        }else{
            if(loginDto.getPassword().equals(user.getPassword())){
                result.setCode(20000);
                result.setMessage("登录成功！");
                Map<String, String> payload = new HashMap<>();
                payload.put("id", user.getId().toString());
                payload.put("name", user.getUsername());
                String token = JwtUtils.getToken(payload);
                Map<String, String> map = new HashMap<>();
                map.put("token", token);
                result.setData(map);
            }else{
                result.setCode(50008);
                result.setMessage("SUCCESS");
                result.setData("用户名或密码错误！");
            }
        }
        return result;
    }

    @Override
    public User profile() {
        User user = new User();
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", "root");
        user = userMapper.selectOne(qw);
        return user;
    }
}