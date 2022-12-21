/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: LoginServiceImpl
 * Author:   Administrator
 * Date:     2022/12/19 10:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aragon.demo.service.impl;

import com.aragon.demo.dto.LoginDto;
import com.aragon.demo.dto.Result;
import com.aragon.demo.entity.User;
import com.aragon.demo.mapper.UserMapper;
import com.aragon.demo.service.LoginService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
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
        qw.eq("username", loginDto.getUserName());
        user = userMapper.selectOne(qw);
        if(null == user){
            result.setResultCode(500);
            result.setMessage("SUCCESS");
            result.setData("用户名不存在！");
        }else{
            if(loginDto.getPasswordMd5().equals(user.getPassword())){
                result.setResultCode(200);
                result.setMessage("SUCCESS");
                result.setData("登录成功！");
            }else{
                result.setResultCode(500);
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