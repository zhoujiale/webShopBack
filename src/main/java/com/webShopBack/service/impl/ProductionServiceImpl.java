package com.webShopBack.service.impl;/**
 * @Auther: zhou
 * @Date: 2018/12/4 17:52
 * @Description:
 */

import com.webShopBack.dao.ProductionDao;
import com.webShopBack.service.ProductionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@ClassName ProductionServiceImpl
 *@Description 商品实现类
 *@Author zhou
 *Date 2018/12/4 17:52
 *@Version 1.0
 **/
@Service
public class ProductionServiceImpl implements ProductionService{

    private static Logger log = Logger.getLogger(ProductionServiceImpl.class);

    @Autowired
    private ProductionDao productionDao;
}
