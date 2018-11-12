package com.webShopBack.service;

import com.webShopBack.entity.User;
import com.webShopBack.response.WebResponse;

/**
 * @Auther: zhou
 * @Date: 2018/10/17 15:08
 * @Description:
 */
public interface UserService {

     /**
      * @description 根据用户名查找用户信息
      * @author zhou
      * @created  2018/10/19 11:16
      * @param :userName
      * @return :User
      */
     User findByUserName(String userName);
     /**
      * @description 添加用户
      * @author zhou
      * @created  2018/10/19 11:16
      * @param :userName,password
      * @param userName
      * @param password
      * @return :WebResponse
      */
      WebResponse addUser(String userName, String password);
}
