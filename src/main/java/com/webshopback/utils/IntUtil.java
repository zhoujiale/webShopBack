package com.webshopback.utils;/**
 * @Auther: zhou
 * @Date: 2018/11/13 15:04
 * @Description:
 */

/**
 *@ClassName IntUtil
 *@Description TODO
 *@Author zhou
 *Date 2018/11/13 15:04
 *@Version 1.0
 **/
public class IntUtil {

    public static boolean isIntEmpty(Integer inte){
        if(inte == 0 || inte == null){
           return true;
        }
        return false;
    }
}
