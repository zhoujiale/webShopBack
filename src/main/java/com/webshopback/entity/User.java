package com.webshopback.entity;/**
 * @Auther: zhou
 * @Date: 2018/10/17 14:49
 * @Description:
 */

import java.io.Serializable;
import java.util.Date;

/**
 *@ClassName User
 *@Description 用户实体类
 *@Author zhou
 *Date 2018/10/17 14:49
 *@Version 1.0
 **/

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int userId;
    /**用户名*/
    private String userName;
    /**密码*/
    private String password;
    /**加盐*/
    private String salt;
    /**状态*/
    private int state;
    /**加入时间*/
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User() {
    }

    public User(int userId, String userName, String password, String salt, int state, Date createTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.state = state;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
