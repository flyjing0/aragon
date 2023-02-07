/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: NacosController
 * Author:   Administrator
 * Date:     2023/2/3 14:04
 * Description: nacos测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.business.test.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能简述〉<br> 
 * 〈nacos测试类〉
 *
 * @author Administrator
 * @create 2023/2/3
 * @since 1.0.0
 */
@RestController
@RefreshScope
@RequestMapping("/nacos")
public class NacosController {

    @Value("${value}")
    private String value;

    @GetMapping("/text")
    public String text(){
        return value;
    }

}