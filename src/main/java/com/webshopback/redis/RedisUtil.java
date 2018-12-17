package com.webshopback.redis;/**
 * @Auther: bee
 * @Date: 2018/12/4 15:05
 * @Description:
 */

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 *@ClassName RedisUtil
 *@Description Redis工具类
 *@Author zhou
 *Date 2018/12/4 15:05
 *@Version 1.0
 **/
@Component
public class RedisUtil {

    private RedisTemplate<Serializable,Object> redisTemplate;

    public void remove(){

    }
}
