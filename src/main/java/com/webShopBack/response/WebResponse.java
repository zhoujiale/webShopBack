package com.webShopBack.response;/**
 * @Auther: zhou
 * @Date: 2018/10/18 10:54
 * @Description:
 */

import org.springframework.stereotype.Component;

/**
 *@ClassName Response
 *@Description 统一响应格式
 *@Author zhou
 *Date 2018/10/18 10:54
 *@Version 1.0
 **/
@Component
public class WebResponse {

    //状态码
    private int code;
    //返回数据
    private Object data;
    //信息
    private String msg;

    public WebResponse ok(Object data){
        this.code = 200;
        this.data = data;
        this.msg = "success";
        return this;
    }

    public WebResponse error(int code,Object data,String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
