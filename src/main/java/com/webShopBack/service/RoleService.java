package com.webShopBack.service;

import com.webShopBack.response.WebResponse;

import java.util.Set;

/**
 * @Auther: bee
 * @Date: 2018/10/23 14:13
 * @Description:
 */
public interface RoleService {
    
    /**
     * @description 根据用户名查询角色
     * @author zhou
     * @created  2018/10/23 14:26    
     * @param 
     * @return 
     */
    Set<String> findRoleByUserName(String userName);

    /**
     * @description 添加角色
     * @author zhou
     * @created  2018/11/14 9:58
     * @param 
     * @return 
     */
    WebResponse addRole(String roleName, String roleDescription);
}
