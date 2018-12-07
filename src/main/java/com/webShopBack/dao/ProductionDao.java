package com.webShopBack.dao;

import com.webShopBack.entity.Production;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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
     * @param production
     * @return
     */
    List<Production> findProduction(HashMap<String, Object> production);

    /**
     * @description 添加商品
     * @author zhou
     * @created  2018/12/5 18:05
     * @param production 商品
     * @return
     */
    int addProduction(Production production);
}
