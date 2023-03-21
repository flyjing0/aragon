package com.cloud.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author 王子健
 * @create 2022/12/19
 * @since 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
