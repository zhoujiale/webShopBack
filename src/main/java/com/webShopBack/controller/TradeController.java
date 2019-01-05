package com.webShopBack.controller;/**
 * @Auther: zhou
 * @Date: 2019/1/5 11:58
 * @Description:
 */

import com.webShopBack.response.WebResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName TradeController
 *@Description 订单
 *@Author zhou
 *Date 2019/1/5 11:58
 *@Version 1.0
 **/
@RestController
@RequestMapping("/trade")
public class TradeController {

    private static Logger log = Logger.getLogger(TradeController.class);

    @RequestMapping(value = "/findAllOrder",method = RequestMethod.POST)
    public WebResponse findAllOrder(Integer customerId){

        return null;
    }
}
