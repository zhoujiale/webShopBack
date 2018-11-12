package com.webShopBack.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @Auther: zhou
 * @Date: 2018/10/23 14:47
 * @Description:
 */
@Repository
public interface PermissionDao {

    /**
     * @description 根据用户查询权限
     * @author zhou
     * @created  2018/10/23 14:53
     * @param
     * @return
     */
    List<String> findPermissionByUserName(String userName);
}
