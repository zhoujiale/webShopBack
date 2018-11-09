package com.webShopBack.dao;/**
 * @Auther: bee
 * @Date: 2018/10/17 14:56
 * @Description:
 */

import com.webShopBack.entity.User;
import org.springframework.stereotype.Repository;

/**
 *@ClassName UserDao
 *@Description TODO
 *@Author bee
 *Date 2018/10/17 14:56
 *@Version 1.0
 **/
@Repository
public interface UserDao {
    
    User findByUserName(String userName);

    void addUser(User newUser);
}
