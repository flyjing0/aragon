package com.cloud.common.service;

import com.cloud.common.entity.Transaction;

import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2023/1/13
 * @since 1.0.0
 */
public interface TransactionService {
    List<Transaction> getList();
}
