/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: TransactionServiceImpl
 * Author:   Administrator
 * Date:     2023/1/13 17:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.business.service.impl;

import com.cloud.business.entity.Transaction;
import com.cloud.business.mapper.TransactionMapper;
import com.cloud.business.service.TransactionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
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

    @Override
    public List<Transaction> getList2() {
        return mapper.selectList(new QueryWrapper<>());
    }
}