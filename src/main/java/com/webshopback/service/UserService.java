package com.webshopback.service;

import com.webshopback.entity.User;
import com.webshopback.response.WebResponse;

/**
 * @Auther: zhou
 * @Date: 2018/10/17 15:08
 * @Description: 用户接口
 */
public interface UserService {

    /**
     * @param :userName
     * @return :User
     * @description 根据用户名查找用户信息
     * @author zhou
     * @created 2018/10/19 11:16
     */
    User findByUserName(String userName);

    /**
     * @param :userName,password
     * @param userName
     * @param password
     * @param roleId
     * @return :WebResponse
     * @description 添加用户
     * @author zhou
     * @created 2018/10/19 11:16
     */
    WebResponse addUser(String userName, String password, int roleId);
    /**
     * @description 禁用用户
     * @author zhou
     * @created  2018/11/13 16:33
     * @param
     * @return
     */
    WebResponse lockedUser(String userName, int state);

    /**
     * @description 返回所有的用户
     * @author zhou
     * @created  2018/11/17 16:09
     * @param
     * @param pageSize 每页返回数量
     * @param pageNum 页号
     * @return
     */
    WebResponse getAllUser(int pageSize, int pageNum);
}
