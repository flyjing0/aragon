/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: TransactionController
 * Author:   Administrator
 * Date:     2023/1/13 17:05
 * Description: 交易控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.controller;

import com.cloud.common.dto.Result;
import com.cloud.common.entity.Transaction;
import com.cloud.common.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈功能简述〉<br> 
 * 〈交易控制层〉
 *
 * @author Administrator
 * @create 2023/1/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/list")
    public Result getList(){
        Result result = new Result();
        List<Transaction> list = service.getList();
        result.setCode(20000);
        result.setMessage("查询成功");
        result.setData(list);
        return result;
    }
}