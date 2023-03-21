package com.cloud.business.feign;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈功能简述〉<br>
 * 〈Fegin客户端〉
 *
 * @author 王子健
 * @create 2023/2/3
 * @since 1.0.0
 */
@org.springframework.cloud.openfeign.FeignClient(value = "common",path = "common",
        fallbackFactory = FeignClientFallbackFactory.class
)
public interface FeignClient {
    @GetMapping("/text/getUsername")
    String findUserById();
}
