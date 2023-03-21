/**
 * Copyright (C), 2019-2023, XXX有限公司
 * FileName: JwtUtils
 * Author:   王子健
 * Date:     2023/1/12 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cloud.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 〈功能简述〉<br> 
 * 〈〉
 *
 * @author 王子健
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
        builder.withClaim("time", new Date().getTime());
        Calendar instance = Calendar.getInstance();
        //默认过期时间  1小时
        instance.add(Calendar.HOUR, 1);
        //指定令牌的过期时间
        builder.withExpiresAt(instance.getTime());
        //签名
        String token = builder.sign(Algorithm.HMAC256(SECRET));
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
            throw e;
        }
        return decodedJWT;
    }

    public static String getTestToken() {
        JWTCreator.Builder builder = JWT.create();

        builder.withClaim("admin", "test");

        Calendar instance = Calendar.getInstance();
        //默认过期时间
        instance.add(Calendar.DAY_OF_MONTH, 1);
        //指定令牌的过期时间
        builder.withExpiresAt(instance.getTime());
        //签名
        String token = builder.sign(Algorithm.HMAC256(SECRET));
        return token;
    }
}