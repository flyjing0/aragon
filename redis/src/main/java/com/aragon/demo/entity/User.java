/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: User
 * Author:   Administrator
 * Date:     2022/12/19 14:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aragon.demo.entity;

import lombok.Data;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2022/12/19
 * @since 1.0.0
 */
@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private String roles;

}