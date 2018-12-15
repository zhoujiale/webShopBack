package com.webshopback.dao;

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
     * @description 查询父类目是否有重复
     * @author zhou
     * @created  2018/12/11 15:00    
     * @param 
     * @return 
     */
    int findClassifyName();
}
