package com.webShopBack.service;

import com.webShopBack.entity.Production;
import com.webShopBack.response.WebResponse;

/**
 * @Auther: zhou
 * @Date: 2018/12/4 17:49
 * @Description:
 */
public interface ProductionService {

    /**
     * @description 返回所有的商品信息
     * @author zhou
     * @created  2018/12/4 18:54
     * @param
     * @return
     */
    WebResponse findAllProduction();

    /**
     * @description 添加产品
     * @author zhou
     * @created  2018/12/5 17:05    
     * @param
     * @param production
     * @return
     */
    WebResponse addProduction(Production production);
}
