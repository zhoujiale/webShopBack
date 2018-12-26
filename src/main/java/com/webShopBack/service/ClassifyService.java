package com.webShopBack.service;

import com.webShopBack.response.WebResponse;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: zhou
 * @Date: 2018/12/11 12:00
 * @Description:
 */
public interface ClassifyService {
    
    /**
     * @description 分页返回分类记录
     * @author zhou
     * @created  2018/12/11 14:21
     * @param 
     * @return 
     */
    WebResponse findAllByClassify(int pageNum, int pageSize);

    /**
     * @description 新增父类目
     * @author zhou
     * @created  2018/12/11 14:29
     * @param classifyName 父类目名称
     * @return
     */
    WebResponse addClassify(String classifyName);

    /**
     * @description
     * @author zhou
     * @created  2018/12/26 15:27
     * @param
     * @return
     */
    WebResponse addSubClassify(@Param("subClassifyName") String subClassifyName,
                               @Param("mainClassifyName") String mainClassifyName);
}
