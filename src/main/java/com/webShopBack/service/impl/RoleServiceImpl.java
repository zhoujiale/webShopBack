package com.webShopBack.service.impl;/**
 * @Auther: bee
 * @Date: 2018/10/23 14:13
 * @Description:
 */

import com.webShopBack.dao.RoleDao;
import com.webShopBack.service.RoleService;
import org.apache.ibatis.javassist.bytecode.Descriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *@ClassName RoleServiceImpl
 *@Description 角色实现类
 *@Author zhou
 *Date 2018/10/23 14:13
 *@Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService{

   @Autowired
   private RoleDao roleDao;

    /**
     * @description 根据用户名查询角色
     * @author zhou
     * @created  2018/10/23 14:27
     * @param
     * @return
     */
    @Override
    public Set<String> findRoleByUserName(String userName) {
        List<String> roleList =  roleDao.findRoleByUserName(userName);
        Set<String> keySet = new HashSet<>(roleList);
        return keySet;
    }
}
