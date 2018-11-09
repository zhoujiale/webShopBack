package com.webShopBack.entity;/**
 * @Auther: bee
 * @Date: 2018/10/17 14:49
 * @Description:
 */

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 *@ClassName User
 *@Description 用户实体类
 *@Author bee
 *Date 2018/10/17 14:49
 *@Version 1.0
 **/

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    //用户名
    private String userName;
    //密码
    private String password;
    //加盐
    private String passwordSalt;
    //状态
    private boolean locked;
    //加入时间
    private Date createTime;

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", locked=" + locked +
                ", createTime=" + createTime +
                '}';
    }
}
