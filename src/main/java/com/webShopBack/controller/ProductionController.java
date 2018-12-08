package com.webShopBack.controller;


import com.webShopBack.entity.Production;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.ProductionService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import static com.webShopBack.utils.BigDecimalUtil.isDecimalEmpty;
import static com.webShopBack.utils.BigDecimalUtil.isTwoDecimal;
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
    @RequestMapping(value = "/find",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse findProduction(@RequestParam(value = "pageNum",defaultValue = "1",required = true) int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10",required = true)int pageSize,
                                      @RequestBody HashMap<String,Object> production, HttpServletRequest request){

        WebResponse webResponse = productionService.findProduction(pageNum,pageSize,production);
        return webResponse;
    }

    /**
     * @description 新增商品
     * @author zhou
     * @created  2018/12/5 16:11
     * @param production 商品类
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @RequiresPermissions("addProduction")
    public WebResponse addProduction(@RequestBody Production production){
        String classify = production.getClassify();//分类编号
        String mainImgUrl = production.getMainImgUrl();//主图
        BigDecimal newPrice = production.getNewPrice();//新价格
        BigDecimal oldPrice = production.getOldPrice();//旧价格
        String productionName = production.getProductionName();//商品名称
        String title = production.getTitle();//商品标题
        int stack = production.getStack();//库存
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

    /**
     * @description 编辑商品
     * @author zhou
     * @created  2018/12/7 14:04
     * @param
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse editProduction(@RequestBody Production production){
        if(isEmpty(production.getProductionName())||isEmpty(production.getTitle())||isEmpty(production.getClassify())||
                isEmpty(production.getMainImgUrl()) ||isDecimalEmpty(production.getOldPrice())||
                isDecimalEmpty(production.getNewPrice())|| (Integer)production.getStack() == null||
                (Boolean)production.isStatus() == null){
           log.error("参数错误");
           return new WebResponse().error(401,"","参数错误");
        }
        if(!isTwoDecimal(production.getOldPrice())||!isTwoDecimal(production.getNewPrice())){
            log.error("价格错误");
            return new WebResponse().error(402,"","价格错误");
        }
        if(production.getStack()<0){
            log.error("库存错误");
            return new WebResponse().error(403,"","库存错误");
        }
        WebResponse webResponse = productionService.editProduction(production);
        return webResponse;
    }
}
