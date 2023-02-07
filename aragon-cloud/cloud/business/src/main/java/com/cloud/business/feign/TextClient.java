package com.cloud.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈功能简述〉<br>
 * 〈Fegin客户端〉
 *
 * @author Administrator
 * @create 2023/2/3
 * @since 1.0.0
 */
@FeignClient(value = "common",path = "aragon",
        fallbackFactory = TextClientFallbackFactory.class
)
public interface TextClient {
    @GetMapping("/text/getUsername")
    String findUserById();
}
