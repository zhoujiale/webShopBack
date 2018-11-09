package com.webShopBack.service.impl;/**
 * @Auther: bee
 * @Date: 2018/10/17 15:10
 * @Description:
 */

import com.webShopBack.entity.User;
import com.webShopBack.dao.UserDao;
import com.webShopBack.service.UserService;
import com.webShopBack.shrio.PassWordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@ClassName UserServiceImpl
 *@Description 用户实现层
 *@Author bee
 *Date 2018/10/17 15:10
 *@Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    /**
     * @description 根据用户名查询用户信息
     * @author zhou
     * @created  2018/10/19 11:25
     * @param userName
     * @return User
     */
    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }


    @Override
    public void addUser(User user) {
        User newUser  = new PassWordHelper().encryptPassword(user);
        userDao.addUser(newUser);
    }
}
