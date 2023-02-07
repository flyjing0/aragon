/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: TextClientFallbackFactory
 * Author:   Administrator
 * Date:     2023/2/3 16:10
 * Description: Feign异常回滚处理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.business.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 〈功能简述〉<br> 
 * 〈Feign异常回滚处理类〉
 *
 * @author Administrator
 * @create 2023/2/3
 * @since 1.0.0
 */
@Component
public class TextClientFallbackFactory implements FallbackFactory<TextClient> {

    Logger logger = LoggerFactory.getLogger(TextClientFallbackFactory.class);

    @Override
    public TextClient create(Throwable cause) {
        return new TextClient() {
            @Override
            public String findUserById() {
                // 请求失败，回退逻辑
                logger.debug("失败啦");
                return null;
            }
        };
    }
}