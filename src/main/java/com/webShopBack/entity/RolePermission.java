package com.webShopBack.entity;/**
 * @Auther: zhou
 * @Date: 2018/10/17 15:46
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName RolePermission
 *@Description 角色权限关联类
 *@Author zhou
 *Date 2018/10/17 15:46
 *@Version 1.0
 **/
public class RolePermission implements Serializable {

    private int id;
    //角色id
    private int roleId;
    //权限id
    private int permissionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public RolePermission(int id, int roleId, int permissionId) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
