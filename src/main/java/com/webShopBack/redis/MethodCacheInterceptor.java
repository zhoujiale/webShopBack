package com.webShopBack.redis;/**
 * @Auther: zhou
 * @Date: 2018/12/17 17:06
 * @Description:
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.List;

;

/**
 *@ClassName MethodCacheInterceptor
 *@Description 缓存拦截器配置
 *@Author zhou
 *Date 2018/12/17 17:06
 *@Version 1.0
 **/
public class MethodCacheInterceptor implements MethodInterceptor{
    private RedisUtil redisUtil;
    //缓存默认的过期时间
    private String defaultCacheExpireTime;
    //禁用缓存的类名列表
    private List<String> targetNamesList;
    //禁用缓存的方法列表
    private List<String> methodNamesList;



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

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object value = null;
        String targetName = methodInvocation.getThis().getClass().getName();
        String methodName = methodInvocation.getMethod().getName();
        if(!isAddCache(targetName,methodName)){
            //跳过缓存返回结果
            return methodInvocation.proceed();
        }
        Object[] arguments = methodInvocation.getArguments();
        String key = getCacheKey(targetName,methodName,arguments);
        try{
            //判断是否有缓存
            if(redisUtil.exists(key)){
                return redisUtil.get(key);
            }
            //写入缓存
            value = methodInvocation.proceed();
            if(value != null){
               final String tkey = key;
               final Object tvalue = value;
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       redisUtil.set(tkey,tvalue,Long.parseLong(defaultCacheExpireTime));

                   }
               }).start();
            }
        }catch (Exception e){
            e.printStackTrace();
            if(value == null){
                return methodInvocation.proceed();
            }
        }
        return value;
    }

    /**
     * @description 创建缓存key
     * @author zhou
     * @created  2018/12/18 9:37
     * @param targetName
     * @param methodName
     * @param arguments
     * @return
     */
    private String getCacheKey(String targetName, String methodName,
                               Object[] arguments) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(targetName).append("_").append(methodName);
        if((arguments != null)&&(arguments.length != 0)){
            for(int i = 0;i < arguments.length;i++){
                stringBuffer.append("_").append(arguments[i]);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * @description 是否加入缓存
     * @author zhou
     * @created  2018/12/18 9:24
     * @param 
     * @return 
     */
    private boolean isAddCache(String targetName, String methodName) {
        boolean flag = true;
        if(targetNamesList.contains(targetName)||methodNamesList.contains(methodName)
                ||targetName.contains("$$EnhancerBySpringCGLIB$$")){
             flag = false;
        }
        return flag;
    }

    public void setTargetNamesList(List targetNamesList) {
        this.targetNamesList = targetNamesList;
    }

    public List getTargetNamesList() {
        return targetNamesList;
    }

    public List<String> getMethodNamesList() {
        return methodNamesList;
    }

    public void setMethodNamesList(List<String> methodNamesList) {
        this.methodNamesList = methodNamesList;
    }
}
