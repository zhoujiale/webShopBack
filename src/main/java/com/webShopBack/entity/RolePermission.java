package com.webShopBack.entity;/**
 * @Auther: bee
 * @Date: 2018/10/17 15:46
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName RolePermission
 *@Description TODO
 *@Author bee
 *Date 2018/10/17 15:46
 *@Version 1.0
 **/
public class RolePermission implements Serializable {

    //角色id
    private int roleId;
    //权限id
    private int permissionId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
