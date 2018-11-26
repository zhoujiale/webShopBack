package com.webShopBack.entity;/**
 * @Auther: zhou
 * @Date: 2018/10/17 15:41
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName UserRole
 *@Description 角色实体类
 *@Author zhou
 *Date 2018/10/17 15:41
 *@Version 1.0
 **/
public class UserRole implements Serializable{

    //主键
    private int id;
    //用户id
    private int userId;
    //角色id
    private int roleId;

    public UserRole(int id, int userId, int roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
