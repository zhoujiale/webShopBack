package com.webShopBack.dao;/**
 * @Auther: bee
 * @Date: 2018/10/17 14:56
 * @Description:
 */

import com.webShopBack.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 *@ClassName UserDao
 *@Description TODO
 *@Author bee
 *Date 2018/10/17 14:56
 *@Version 1.0
 **/
@Repository
public interface UserDao {
    
    /**
     * @description 根据用户名查询用户信息
     * @author zhou
     * @created  2018/11/13 15:23    
     * @param 
     * @return 
     */
    User findByUserName(String userName);

    /**
     * @description 添加新用户
     * @author zhou
     * @created  2018/11/13 15:28
     * @param 
     * @return 
     */
    int addUser(User user);

    /**
     * @description 为用户添加角色
     * @author zhou
     * @created  2018/11/13 15:36
     * @param
     * @return
     */
    int addRole(@Param("userName") String userName,@Param("roleId") int roleId);

    /**
     * @description 禁用用户
     * @author zhou
     * @created  2018/11/13 16:35
     * @param
     * @return
     */
    int lockedUser(@Param("userName") String userName,@Param("state") int state);

    /**
     * @description 获得所有的用户
     * @author zhou
     * @created  2018/11/17 16:25
     * @param 
     * @return 
     */
    List<HashMap<String,Object>> getAllUser();
}
