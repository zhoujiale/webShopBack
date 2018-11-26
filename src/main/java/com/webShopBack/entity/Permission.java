package com.webShopBack.entity;/**
 * @Auther: zhou
 * @Date: 2018/10/17 15:26
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName Permission
 *@Description 权限实体类
 *@Author zhou
 *Date 2018/10/17 15:26
 *@Version 1.0
 **/
public class Permission implements Serializable{

    private int permissionId;
    //权限
    private String permissionName;
    //权限描述
    private String permissionDescription;
    //是否可用
    private Boolean available = true;

    public Permission() {

    }

    public Permission(int permissionId, String permissionName, String permissionDescription, Boolean available) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
        this.available = available;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionDescription='" + permissionDescription + '\'' +
                ", available=" + available +
                '}';
    }
}
