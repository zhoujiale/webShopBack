package com.webShopBack.service.impl;

import com.webShopBack.dao.PermissionDao;
import com.webShopBack.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 *@ClassName PermissionServiceImpl
 *@Description 权限实现类
 *@Author： zhou
 *Date 2018/10/23 14:44
 *@Version 1.0
 **/
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * @description 根据用户查询权限
     * @author zhou
     * @created  2018/10/23 14:47    
     * @param 
     * @return 
     */
    @Override
    public Set<String> findPermissionByUserName(String userName) {
        return permissionDao.findPermissionByUserName(userName);
    }
}
