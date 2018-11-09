package com.webShopBack.service;

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
}
