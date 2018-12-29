package com.webShopBack.controller;/**
 * @Auther: zhou
 * @Date: 2018/12/28 18:10
 * @Description:
 */

import com.webShopBack.response.WebResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName OrderController
 *@Description 订单
 *@Author zhou
 *Date 2018/12/28 18:10
 *@Version 1.0
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    private static Logger log = Logger.getLogger(OrderController.class);

    public WebResponse findByOrder(){
      return null;
    }
}
