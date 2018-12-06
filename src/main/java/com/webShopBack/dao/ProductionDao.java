package com.webShopBack.dao;

import com.webShopBack.entity.Production;
import com.webShopBack.response.WebResponse;
import org.springframework.stereotype.Repository;

/**
 * @Auther: zhou
 * @Date: 2018/12/4 17:54
 * @Description: 商品Dao
 */
@Repository
public interface ProductionDao {

    /**
     * @description 返回所有的商品
     * @author zhou
     * @created  2018/12/4 19:19
     * @param
     * @return
     */
    WebResponse findAllProduction();

    /**
     * @description 添加商品
     * @author zhou
     * @created  2018/12/5 18:05
     * @param production 商品
     * @return
     */
    int addProduction(Production production);
}
