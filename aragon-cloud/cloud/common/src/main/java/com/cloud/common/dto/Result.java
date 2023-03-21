/**
 * Copyright (C), 2019-2022, XXX有限公司
 * FileName: Result
 * Author:   王子健
 * Date:     2022/12/19 9:34
 * Description: 封装返回结果
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.dto;

import lombok.Data;

/**
 * 〈功能简述〉<br> 
 * 〈封装返回结果〉
 *
 * @author 王子健
 * @create 2022/12/19
 * @since 1.0.0
 */
@Data
public class Result {

    private Integer code;

    private String message;

    private Object data;
}