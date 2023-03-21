/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: TextClientFallbackFactory
 * Author:   王子健
 * Date:     2023/2/3 16:10
 * Description: Feign异常回滚处理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.business.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 〈功能简述〉<br> 
 * 〈Feign异常回滚处理类〉
 *
 * @author 王子健
 * @create 2023/2/3
 * @since 1.0.0
 */
@Slf4j
@Component
public class FeignClientFallbackFactory implements FallbackFactory<FeignClient> {
    

    @Override
    public FeignClient create(Throwable cause) {
        return new FeignClient() {
            @Override
            public String findUserById() {
                // 请求失败，回退逻辑
                log.debug("失败啦");
                return null;
            }
        };
    }
}