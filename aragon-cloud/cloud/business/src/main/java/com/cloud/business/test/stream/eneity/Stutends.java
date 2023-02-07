/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: stutends
 * Author:   Administrator
 * Date:     2022/11/9 12:25
 * Description: 学生实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.business.test.stream.eneity;

import lombok.Data;

/**
 * 〈功能简述〉<br> 
 * 〈学生实体类〉
 *
 * @author Administrator
 * @create 2022/11/9
 * @since 1.0.0
 */
@Data
public class Stutends {

    public String name;
    public Integer age;
  
    public String classLevel;

    public Stutends(){

    }

    public Stutends(String name){
        this.name = name;
    }

    public Stutends(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Stutends(String name, Integer age, String classLevel){
        this.name = name;
        this.age = age;
        this.classLevel = classLevel;
    }
}