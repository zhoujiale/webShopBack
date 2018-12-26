package com.webShopBack.dao;

import com.webShopBack.entity.Classify;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: zhou
 * @Date: 2018/12/11 13:41
 * @Description:
 */
@Repository
public interface ClassifyDao {
    
    /**
     * @description 查询所有的父类目
     * @author zhou
     * @created  2018/12/11 13:48    
     * @param 
     * @return 
     */
    List<HashMap<String,Object>> findAllByClassify();

    /**
     * @description 查询所有的子类目
     * @author zhou
     * @created  2018/12/11 13:55
     * @param 
     * @return 
     */
    List<HashMap<String,Object>> findAllBySubClassify();


    /**
     * @description 增加父类目
     * @author zhou
     * @created  2018/12/26 14:24
     * @param classify
     * @return
     */
    int addMainClassify(Classify classify);

    /**
     * @description 通过父类目查找Id
     * @author zhou
     * @created  2018/12/26 15:34
     * @param
     * @return
     */
    Integer findClassifyByMainName(String mainClassifyName);
}
