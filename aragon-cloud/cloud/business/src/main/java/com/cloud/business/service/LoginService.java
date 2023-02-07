package com.cloud.business.service;

import com.cloud.business.dto.LoginDto;
import com.cloud.business.dto.Result;
import com.cloud.business.entity.User;

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
