package com.webShopBack.entity;/**
 * @Auther: bee
 * @Date: 2018/10/17 15:26
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName Permission
 *@Description TODO
 *@Author bee
 *Date 2018/10/17 15:26
 *@Version 1.0
 **/
public class Permission implements Serializable{

    private int id;
    //权限
    private String permission;
    //权限描述
    private String description;
    //是否可用
    private Boolean available = false;

    public Permission() {

    }

    public Permission( String permission, String description, Boolean available) {
        this.permission = permission;
        this.description = description;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
