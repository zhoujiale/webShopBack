package com.webShopBack.redis;/**
 * @Auther: zhou
 * @Date: 2019/1/5 18:23
 * @Description:
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@ClassName RedisCacheAspect
 *@Description redis切面
 *@Author zhou
 *Date 2019/1/5 18:23
 *@Version 1.0
 **/
@Component
@Aspect
public class RedisCacheAspect {
    @Autowired
    private RedisUtil redisUtil;

    @Around("@annotation(com.webShopBack.annotation.RedisCacheable)")
    public Object redisCache(ProceedingJoinPoint joinPoint){
       return null;
    }
}
