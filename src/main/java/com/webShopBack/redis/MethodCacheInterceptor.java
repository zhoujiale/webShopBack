package com.webShopBack.redis;/**
 * @Auther: zhou
 * @Date: 2018/12/17 17:06
 * @Description:
 */

import org.aopalliance.aop.Advice;

import java.util.List;

/**
 *@ClassName MethodCacheInterceptor
 *@Description 缓存拦截器配置
 *@Author zhou
 *Date 2018/12/17 17:06
 *@Version 1.0
 **/
public class MethodCacheInterceptor implements Advice {
    private RedisUtil redisUtil;
    //缓存默认的过期时间
    private String defaultCacheExpireTime;
    //禁用缓存的类名列表
    private List<String> targetNamesList;
    //禁用缓存的方法列表
    private List<String> methodNamesList;
    private List targetNameList;

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }

    public void setDefaultCacheExpireTime(String defaultCacheExpireTime) {
        this.defaultCacheExpireTime = defaultCacheExpireTime;
    }

    public String getDefaultCacheExpireTime() {
        return defaultCacheExpireTime;
    }

    public void setTargetNameList(List targetNameList) {
        this.targetNameList = targetNameList;
    }

    public List getTargetNameList() {
        return targetNameList;
    }
}
