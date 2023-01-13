/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: JwtUtils
 * Author:   Administrator
 * Date:     2023/1/12 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.aragon.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2023/1/12
 * @since 1.0.0
 */
public class JwtUtils {

    private static String SECRET = "token!Q@W#E$R";

    /**
     * 生产token
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();

        //payload   将用户信息放到令牌里面
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, 2); //默认7天过期

        builder.withExpiresAt(instance.getTime());//指定令牌的过期时间
        String token = builder.sign(Algorithm.HMAC256(SECRET));//签名
        return token;
    }

    /**
     * 验证token
     */
    public static DecodedJWT verify(String token) {
        DecodedJWT decodedJWT = null;
        try {
            //如果有任何验证异常，此处都会抛出异常
             decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        return decodedJWT;
    }

}