package com.webShopBack.utils;/**
 * @Auther: zhou
 * @Date: 2018/11/12 15:52
 * @Description:
 */

import java.util.UUID;

/**
 *@ClassName UUIDUtil
 *@Description TODO
 *@Author zhou
 *Date 2018/11/12 15:52
 *@Version 1.0
 **/
public class UUIDUtil {

    public static String createUUID(){
        return UUID.randomUUID().toString();
    }
}
