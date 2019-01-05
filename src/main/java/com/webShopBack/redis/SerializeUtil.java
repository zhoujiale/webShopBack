package com.webShopBack.redis;/**
 * @Auther: zhou
 * @Date: 2019/1/5 17:17
 * @Description:
 */

import java.io.*;

/**
 *@ClassName SerializeUtil
 *@Description 序列化工具
 *@Author zhou
 *Date 2019/1/5 17:17
 *@Version 1.0
 **/
public class SerializeUtil {

    /**
     * @description 序列化
     * @author zhou
     * @created  2019/1/5 17:40
     * @param
     * @return
     */
    public static byte[] serializeUtil(Object obj){
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try{
            //序列化
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description 反序列化
     * @author zhou
     * @created  2019/1/5 17:42
     * @param
     * @return
     */
    public static Object unSerialize(byte[] bytes){
        ByteArrayInputStream byteArrayInputStream = null;
        try{
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
