package com.webShopBack.redis;

import java.util.List;

/**
 * @Auther: zhou
 * @Date: 2018/12/17 15:30
 * @Description:
 */
public interface RedisBase<H,K,V> {

    //增
    void add(K key,String value);
    void addObj(H objectKey,K key,V object);
    //删
    void delete(K key);
    void delete(List<K> listKeys);
    void deleteObj(H objectKey,K key);
    //改
    void update(K key,String value);
    void updateObj(H objectKey,K key,V object);
    //查
    String get(K key);
    V getObj(H objectKey,K key);


}
