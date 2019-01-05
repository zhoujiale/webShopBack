package com.webShopBack.annotation;

import java.lang.annotation.*;

/**
 * @Auther: zhou
 * @Date: 2019/1/5 16:45
 * @Description: 自定义注解(redis)
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisCacheable {
    String key();
    String fieldKey();
    int expireTime() default 3600;
}
