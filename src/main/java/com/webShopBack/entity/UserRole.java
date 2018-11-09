package com.webShopBack.entity;/**
 * @Auther: bee
 * @Date: 2018/10/17 15:41
 * @Description:
 */

import java.io.Serializable;

/**
 *@ClassName UserRole
 *@Description TODO
 *@Author bee
 *Date 2018/10/17 15:41
 *@Version 1.0
 **/
public class UserRole implements Serializable{

    //用户id
    private int userId;
    //角色id
    private int roleId;

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
}
