package com.webShopBack.service.impl;/**
 * @Auther: bee
 * @Date: 2018/10/17 15:10
 * @Description:
 */

import com.webShopBack.entity.User;
import com.webShopBack.dao.UserDao;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.UserService;
import com.webShopBack.shrio.PassWordHelper;
import com.webShopBack.utils.UUIDUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 *@ClassName UserServiceImpl
 *@Description 用户实现层
 *@Author bee
 *Date 2018/10/17 15:10
 *@Version 1.0
 **/
@Service
@Transactional(propagation= Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class UserServiceImpl implements UserService{

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;
    @Autowired
    private PassWordHelper passWordHelper;



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
    @Transactional
    public WebResponse addUser(String userName, String password, int roleId) {
        User users = userDao.findByUserName(userName);
        if(users != null){
            log.error("用户已存在");
            return new WebResponse().error(403,null,"用户已存在");
        }
        User user = new User();
        String salt = UUIDUtil.createUUID().toString();
        Date createTime = new Date();
        Integer state = 0;
        user.setUserName(userName);
        user.setPassword(password);
        user.setSalt(salt);
        user.setCreateTime(createTime);
        user.setState(state);
        User newUser = passWordHelper.encryptPassword(user);
        try{
            int userCount  = userDao.addUser(newUser);
            if(userCount == 0){
                throw new RuntimeException();
            }
            int roleCount = userDao.addRole(userName,roleId);
            if(roleCount == 0){
                throw new RuntimeException();
            }

        }catch (Exception e){
            log.error("添加新用户失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(404,null,"添加新用户失败");
        }
        return new WebResponse().ok(userName + "添加成功");
    }

    /**
     * @description 禁用/启用用户
     * @author zhou
     * @created  2018/11/13 16:31
     * @param
     * @return
     */
    @Override
    public WebResponse lockedUser(String userName, int state) {

        User user = userDao.findByUserName(userName);
        //获得状态
        int oldState = user.getState();
        String str = null;
        if(oldState == 0){
            str = "禁用";
        }else if(oldState == 1){
            str = "解禁";
        }
        try {
            int updateState = userDao.lockedUser(userName,state);
            if(updateState == 0){
                throw new RuntimeException();
            }
        }catch (Exception e){
            log.error("禁用用户失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(403,null,"禁用用户失败");
        }
        return new WebResponse().ok(str + userName);
    }
}
