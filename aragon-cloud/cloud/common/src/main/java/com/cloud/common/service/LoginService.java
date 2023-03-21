package com.cloud.common.service;

import com.cloud.common.dto.LoginDto;
import com.cloud.common.dto.Result;
import com.cloud.common.entity.User;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author 王子健
 * @create 2022/12/19
 * @since 1.0.0
 */
public interface LoginService {

    Result login(LoginDto loginDto);

    User profile();
}
