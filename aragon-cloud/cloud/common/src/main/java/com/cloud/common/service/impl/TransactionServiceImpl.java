/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: TransactionServiceImpl
 * Author:   王子健
 * Date:     2023/1/13 17:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.common.entity.Transaction;
import com.cloud.common.mapper.TransactionMapper;
import com.cloud.common.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author 王子健
 * @create 2023/1/13
 * @since 1.0.0
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper mapper;

    @Override
    public List<Transaction> getList() {
        return mapper.selectList(new QueryWrapper<>());
    }
}