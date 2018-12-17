package com.webShopBack.dao;

import com.webShopBack.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * @description 查询权限
     * @author zhou
     * @created  2018/11/14 17:42    
     * @param 
     * @return 
     */
    Permission findByPermissionName(String permissionName);

    /**
     * @description 添加权限
     * @author zhou
     * @created  2018/11/14 18:00
     * @param
     * @return
     */
    int addPermission(Permission newPermission);

    /**
     * @description 根据权限编号查权限
     * @author zhou
     * @created  2018/11/15 9:52
     * @param
     * @return
     */
    Permission findPermissionById(int permissionId);
}
