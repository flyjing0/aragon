/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: FeignController
 * Author:   王子健
 * Date:     2023/2/3 16:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author 王子健
 * @create 2023/2/3
 * @since 1.0.0
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    // @Autowired
    // private TextClient textClient;
    //
    // @PostMapping("/getUsername")
    // public String getProductName(@RequestParam String userid){
    //     String result = textClient.findUserById(userid);
    //     return result;
    // }
}