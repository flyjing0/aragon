/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: Transaction
 * Author:   Administrator
 * Date:     2023/1/13 17:09
 * Description: 交易实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.business.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 〈功能简述〉<br> 
 * 〈交易实体类〉
 *
 * @author Administrator
 * @create 2023/1/13
 * @since 1.0.0
 */
@Data
public class Transaction {
    private Long id;
    private String orderNo;
    private BigDecimal price;
    private String status;
}