package com.webShopBack.service.impl;/**
 * @Auther: zhou
 * @Date: 2018/12/4 17:52
 * @Description:
 */

import com.github.pagehelper.PageHelper;
import com.webShopBack.dao.ProductionDao;
import com.webShopBack.entity.Production;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.ProductionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;

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

    /**
     * @description 返回所有的商品
     * @author zhou
     * @created  2018/12/4 18:55    
     * @param
     * @param pageNum
     * @param pageSize
     * @param production
     * @return
     */
    @Override
    public WebResponse findProduction(int pageNum, int pageSize, HashMap<String, Object> production) {
        PageHelper.startPage(pageNum,pageSize);
       List<Production> list = productionDao.findProduction(production);
        if (list == null || list.size() == 0) {
            return new WebResponse().ok(list);
        }
        return new WebResponse().ok(list);
    }
    
    /**
     * @description 添加商品
     * @author zhou
     * @created  2018/12/5 17:07    
     * @param production 产品
     * @return 
     */
    @Override
    @Transactional
    public WebResponse addProduction(Production production) {
        try {
            int count = productionDao.addProduction(production);
            if(count == 0){
                throw new  RuntimeException();
            }
        }catch (Exception e){
            log.error("添加失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(402,"","添加失败");
        }

        return new WebResponse().ok(production);
    }
}
