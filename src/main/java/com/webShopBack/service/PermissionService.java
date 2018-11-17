package com.webShopBack.service;

import com.webShopBack.response.WebResponse;

import java.util.Set;

/**
 * @Auther: bee
 * @Date: 2018/10/23 14:44
 * @Description:
 */
public interface PermissionService {
    
    /**
     * @description 根据用户查询权限
     * @author zhou
     * @created  2018/10/23 14:46    
     * @param 
     * @return 
     */
    Set<String> findPermissionByUserName(String userName);

    /**
     * @description 添加权限
     * @author zhou
     * @created  2018/11/14 18:25
     * @param 
     * @return 
     */
    WebResponse addPermission(String permissionName, String permissionDescription);
}
