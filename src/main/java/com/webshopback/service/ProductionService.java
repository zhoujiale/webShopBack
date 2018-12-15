package com.webshopback.service;

import com.webshopback.entity.Production;
import com.webshopback.response.WebResponse;

import java.util.HashMap;

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
     * @param pageNum
     * @param pageSize
     * @param production
     * @return
     */
    WebResponse findProduction(int pageNum, int pageSize, HashMap<String, Object> production);

    /**
     * @description 添加产品
     * @author zhou
     * @created  2018/12/5 17:05    
     * @param
     * @param production
     * @return
     */
    WebResponse addProduction(Production production);

    /**
     * @description 编辑产品
     * @author zhou
     * @created  2018/12/7 16:47
     * @param production
     * @return
     */
    WebResponse editProduction(Production production);
}