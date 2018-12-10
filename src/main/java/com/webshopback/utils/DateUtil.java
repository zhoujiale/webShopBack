package com.webshopback.utils;/**
 * @Auther: zhou
 * @Date: 2018/11/24 15:16
 * @Description:
 */

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *@ClassName DataUtil
 *@Description TODO
 *@Author zhou
 *Date 2018/11/24 15:16
 *@Version 1.0
 **/
@Component
public class DateUtil {


    public static String timeStampDate(Timestamp timeStamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(timeStamp);
        return time;
    }
}
