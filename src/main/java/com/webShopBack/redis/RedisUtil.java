package com.webShopBack.redis;/**
 * @Auther: bee
 * @Date: 2018/12/4 15:05
 * @Description:
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *@ClassName RedisUtil
 *@Description Redis工具类
 *@Author zhou
 *Date 2018/12/4 15:05
 *@Version 1.0
 **/
public class RedisUtil {


    @Autowired
    private RedisTemplate<Serializable,Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * @description 删除对应的value
     * @author zhou
     * @created  2018/12/17 17:35
     * @param keys
     * @return
     */
    public void remove(final String... keys){
        for(String key :keys){
            remove(key);
        }
    }

    /**
     * @description 批量删除key
     * @author zhou
     * @created  2018/12/17 17:35
     * @param pattern
     * @return
     */
    public void removePattern(final String pattern){
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if(keys.size()>0){
            redisTemplate.delete(keys);
        }
    }
    
    /**
     * @description 删除对应的Key
     * @author zhou
     * @created  2018/12/17 17:40    
     * @param 
     * @return 
     */
    public void remove(final String key){
        if(exists(key)){
            redisTemplate.delete(key);
        }
    }
    /**
     * @description 判断缓存中是否有对应的value
     * @author zhou
     * @created  2018/12/17 17:46    
     * @param key
     * @return 
     */
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * @description 读取缓存
     * @author zhou
     * @created  2018/12/17 17:48    
     * @param 
     * @return 
     */
    public Object get(final String key){
        Object result = null;
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * @description 写入缓存
     * @author zhou
     * @created  2018/12/17 18:04
     * @param
     * @return
     */
    public boolean set(final String key,Object value){
        boolean result = false;
        try{
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @description 写入缓存
     * @author zhou
     * @created  2018/12/17 18:12
     * @param
     * @return
     */
    public boolean set(final String key,Object value,Long expireTime){
        boolean result = false;
        try{
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
