package com.webShopBack.entity;/**
 * @Auther: zhou
 * @Date: 2018/10/17 15:18
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName Role
 *@Description 角色
 *@Author zhou
 *Date 2018/10/17 15:18
 *@Version 1.0
 **/
public class Role implements Serializable{


    private int roleId;
    /**角色名*/
    private String roleName;
    /**角色描述*/
    private String roleDescription;
    /**是否可用*/
    private Boolean available = true;

    public Role() {

    }

    public Role(int roleId,String roleName, String roleDescription, Boolean available) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.available = available;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String description) {
        this.roleDescription = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "RoleService{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", available=" + available +
                '}';
    }
}
