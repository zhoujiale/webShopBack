package com.webShopBack.utils;/**
 * @Auther: zhou
 * @Date: 2018/12/5 16:29
 * @Description:
 */

import java.math.BigDecimal;

/**
 *@ClassName BigDecimalUtil
 *@Description TODO
 *@Author zhou
 *Date 2018/12/5 16:29
 *@Version 1.0
 **/
public class BigDecimalUtil {

    public static boolean isDecimalEmpty(BigDecimal bigDecimal){
        if(bigDecimal.compareTo(BigDecimal.ZERO) == 0|| bigDecimal == null){
            return true;
        }
        return false;
    }
}
