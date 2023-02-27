package com.cloud.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.common.entity.Transaction;
import com.cloud.common.mapper.TransactionMapper;
import com.cloud.common.service.TransactionService;
import org.springframework.stereotype.Service;

/**
* @author aragon
* @description 针对表【transaction】的数据库操作Service实现
* @createDate 2023-02-27 09:39:52
*/
@Service
public class TransactionServiceImpl extends ServiceImpl<TransactionMapper, Transaction>
implements TransactionService{

}
