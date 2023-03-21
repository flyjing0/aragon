package com.cloud.business.service;

import com.cloud.business.entity.Transaction;

import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author 王子健
 * @create 2023/1/13
 * @since 1.0.0
 */
public interface TransactionService {
    List<Transaction> getList();

    List<Transaction> getList2();
}
