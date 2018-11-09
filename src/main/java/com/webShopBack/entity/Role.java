package com.webShopBack.entity;/**
 * @Auther: bee
 * @Date: 2018/10/17 15:18
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName RoleService
 *@Description 角色
 *@Author bee
 *Date 2018/10/17 15:18
 *@Version 1.0
 **/
public class Role implements Serializable{

    private int id;

    //角色名
    private String role;
    //角色描述
    private String description;
    //是否可用
    private Boolean available = false;

    public Role() {

    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return "RoleService{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
