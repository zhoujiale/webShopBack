package com.webshopback.controller;/**
 * @Auther: zhou
 * @Date: 2018/12/8 11:10
 * @Description:
 */

import com.webshopback.response.WebResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName ClassifyController
 *@Description 主类目
 *@Author zhou
 *Date 2018/12/8 11:10
 *@Version 1.0
 **/
@RestController
@RequestMapping("/classify")
public class ClassifyController {

    private static Logger log = Logger.getLogger(ClassifyController.class);

    @RequestMapping(value = "/find",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse findClassify(){

         return null;
    }
}
