/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: TextController
 * Author:   王子健
 * Date:     2023/2/3 16:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.controller;

import com.cloud.common.entity.Transaction;
import com.cloud.common.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author 王子健
 * @create 2023/2/3
 * @since 1.0.0
 */
@RestController
@RequestMapping("/text")
public class TextController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getUsername")
    public String findOrderDetailById(){
        List<Transaction> list = transactionService.getList();
        return list.get(0).getOrderNo();
    }
}