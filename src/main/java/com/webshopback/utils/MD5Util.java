package com.webshopback.utils;/**
 * @Auther: zhou
 * @Date: 2018/11/12 16:28
 * @Description:
 */

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *@ClassName MD5Util
 *@Description MD5加密
 *@Author zhou
 *Date 2018/11/12 16:28
 *@Version 1.0
 **/
public class MD5Util {

    public String md5Password(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return null;
    }
}
