package com.webShopBack.dao;

import com.webShopBack.entity.SubClassify;
import org.springframework.stereotype.Repository;

/**
 * @Auther: zhou
 * @Date: 2018/12/26 15:04
 * @Description:
 */
@Repository
public interface SubClassifyDao {
    
    /**
     * @description 增加子类目
     * @author zhou
     * @created  2018/12/26 15:50
     * @param 
     * @return 
     */
    int addSubClassify(SubClassify subClassify);
}
