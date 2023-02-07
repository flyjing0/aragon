/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: Result
 * Author:   Administrator
 * Date:     2022/12/19 9:34
 * Description: 封装返回结果
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.business.dto;

import lombok.Data;

/**
 * 〈功能简述〉<br> 
 * 〈封装返回结果〉
 *
 * @author Administrator
 * @create 2022/12/19
 * @since 1.0.0
 */
@Data
public class Result {

    private Integer code;

    private String message;

    private Object data;
}