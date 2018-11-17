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

    /**
     * @description 返回所有的角色
     * @author zhou
     * @created  2018/11/14 18:21    
     * @param 
     * @return 
     */
    WebResponse getAllRole();

    /**
     * @description 为角色添加权限
     * @author zhou
     * @created  2018/11/15 9:40
     * @param
     * @param permissionId
     * @return
     */
    WebResponse addPermissionByRole(int roleId, int permissionId);

    /**
     * @description 禁用/启用角色
     * @author zhou
     * @created  2018/11/16 11:45
     * @param
     * @param available
     * @return
     */
    WebResponse lockedRole(int roleId, boolean available);
}
