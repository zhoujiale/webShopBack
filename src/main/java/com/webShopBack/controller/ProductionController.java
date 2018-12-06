package com.webShopBack.controller;


import com.webShopBack.entity.Production;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.ProductionService;
import com.webShopBack.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

import static com.webShopBack.utils.BigDecimalUtil.isDecimalEmpty;
import static com.webShopBack.utils.IntUtil.isIntEmpty;
import static com.webShopBack.utils.StringUtil.isEmpty;

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

    /**
     * @description 返回所有的商品
     * @author zhou
     * @created  2018/12/4 18:52
     * @param
     * @return
     */
    @RequestMapping(value = "/findall",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse findAllProduction(){
        WebResponse webResponse = productionService.findAllProduction();
        return webResponse;
    }

    /**
     * @description 新增商品
     * @author zhou
     * @created  2018/12/5 16:11
     * @param production 商品类
     * @return
     */
    @RequestMapping(value = "/addproduction",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse addProduction(@RequestBody Production production){
        String classify = production.getClassify();//分类编号
        String mainImgUrl = production.getMainImgUrl();//主图
        BigDecimal newPrice = production.getNewPrice();//新价格
        BigDecimal oldPrice = production.getOldPrice();//旧价格
        String productionName = production.getProductionName();//商品名称
        String title = production.getTitle();//商品标题
        int stack = production.getStack();//缓存
        //验空
        if(isEmpty(classify)||isEmpty(mainImgUrl)||isEmpty(productionName)||isEmpty(title)
                ||isIntEmpty(stack)||isDecimalEmpty(newPrice)||isDecimalEmpty(oldPrice)){
           log.error("参数不全");
           return new WebResponse().error(401,"","参数不全");
        }
        production.setStatus(true);
        production.setCreateTime(new Date());
        production.setUpdateTime(new Date());

        WebResponse webResponse = productionService.addProduction(production);
        return webResponse;
    }
}
