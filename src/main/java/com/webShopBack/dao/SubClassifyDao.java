package com.webShopBack.dao;

import com.webShopBack.entity.SubClassify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

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

    /**
     * @description 查询所有类目
     * @author zhou
     * @created  2018/12/26 16:35
     * @param 
     * @return 
     */
    List<HashMap<String,Object>> findAllClassify();

    /**
     * @description 编辑类目
     * @author zhou
     * @created  2019/1/5 11:43
     * @param
     * @return
     */
    Integer updateSubClassify(@Param("classifyId") Integer classifyId,
                              @Param("classifyName") String classifyName);
}
