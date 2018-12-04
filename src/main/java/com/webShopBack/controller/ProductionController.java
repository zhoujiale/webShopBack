package com.webShopBack.controller;


import com.webShopBack.response.WebResponse;
import com.webShopBack.service.ProductionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName ProductionController
 *@Description 商品web层
 *@Author zhou
 *Date 2018/12/4 17:45
 *@Version 1.0
 **/
@RestController
@RequestMapping("/production")
public class ProductionController {

    private static Logger log = Logger.getLogger(ProductionController.class);

    @Autowired
    private ProductionService productionService;



}
