package com.webShopBack.redis;/**
 * @Auther: bee
 * @Date: 2018/12/4 16:33
 * @Description:
 */

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;


/**
 *@ClassName RedisConfig
 *@Description redis配置
 *@Author zhou
 *Date 2018/12/4 16:33
 *@Version 1.0
 **/
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport{

    private volatile JedisConnectionFactory jedisConnectionFactory;
    private volatile RedisTemplate<String,String> redisTemplate;
    private volatile RedisCacheManager redisCacheManager;

    public RedisCacheConfig(){
        super();
    }
    /**
     * @description 带参的构造方法初始化所有成员变量
     * @author zhou
     * @created  2018/12/4 16:46    
     * @param 
     * @return 
     */
    public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory,
                            RedisTemplate redisTemplate,
                            RedisCacheManager redisCacheManager) {
        this.jedisConnectionFactory = jedisConnectionFactory;
        this.redisTemplate = redisTemplate;
        this.redisCacheManager = redisCacheManager;
    }

    public JedisConnectionFactory getJedisConnectionFactory() {
        return jedisConnectionFactory;
    }

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public RedisCacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for(Object obj : objects){
                    sb.append(obj.toString());
                }
                return sb.toString();
            }


        };
    }
}
