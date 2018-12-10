package com.webshopback.utils;/**
 * @Auther: zhou
 * @Date: 2018/10/18 16:55
 * @Description:
 */

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;
import org.springframework.stereotype.Component;

/**
 *@ClassName StringUtil
 *@Description 字符串工具类
 *@Author zhou
 *Date 2018/10/18 16:55
 *@Version 1.0
 **/
public class StringUtil {

    /**
     * @description 验证字符串是否为空
     * @author zhou
     * @created  2018/10/18 16:57
     * @param
     * @return
     */
    public static boolean isEmpty(String str){
        if(str==null|| "".equals(str)){
            return true;
        }
        return false;
    }


}
