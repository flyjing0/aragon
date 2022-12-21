package com.aragon.demo.service;

import com.aragon.demo.dto.LoginDto;
import com.aragon.demo.dto.Result;
import com.aragon.demo.entity.User;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2022/12/19
 * @since 1.0.0
 */
public interface LoginService {

    Result login(LoginDto loginDto);

    User profile();
}
