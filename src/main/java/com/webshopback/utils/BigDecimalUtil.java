package com.webshopback.utils;/**
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

    /**
     * @description 判断是否为空
     * @author zhou
     * @created  2018/12/7 15:49
     * @param bigDecimal
     * @return
     */
    public static boolean isDecimalEmpty(BigDecimal bigDecimal){
        if(bigDecimal.compareTo(BigDecimal.ZERO) == 0|| bigDecimal == null){
            return true;
        }
        return false;
    }
    /**
     * @description 判断小数位数
     * @author zhou
     * @created  2018/12/7 15:49
     * @param bigDecimal
     * @return
     */
    public static boolean isTwoDecimal(BigDecimal bigDecimal){
        String str = bigDecimal.toString();
        String reg = "^(([1-9][0-9]*)|(([0]\\.\\d{1,2}|[1-9][0-9]*\\.\\d{1,2})))$";
        return str.matches(reg);
    }
}
