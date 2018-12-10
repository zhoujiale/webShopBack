package com.webshopback.service.impl;

import com.webshopback.dao.PermissionDao;
import com.webshopback.entity.Permission;
import com.webshopback.response.WebResponse;
import com.webshopback.service.PermissionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashSet;
import java.util.List;
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

    private static Logger log = Logger.getLogger(PermissionServiceImpl.class);
    @Autowired
    private PermissionDao permissionDao;

    /**
     * @description 根据用户查询权限
     * @author zhou
     * @created  2018/10/23 14:47    
     * @param  userName 用户名
     * @return 
     */
    @Override
    public Set<String> findPermissionByUserName(String userName) {
        List<String> permissionList = permissionDao.findPermissionByUserName(userName);
        Set<String> permissionSet = new HashSet<>(permissionList);
        return permissionSet;
    }

    /**
     * @description 添加权限
     * @author zhou
     * @created  2018/11/14 17:41
     * @param permissionName 权限名
     * @param permissionDescription 权限描述
     * @return
     */
    @Override
    public WebResponse addPermission(String permissionName, String permissionDescription) {
        Permission permission = permissionDao.findByPermissionName(permissionName);
        if(permission != null){
            log.error("权限已存在");
            return new WebResponse().error(401,null,"权限已存在");
        }
        Permission newPermission = new Permission();
        newPermission.setPermissionName(permissionName);;
        newPermission.setPermissionDescription(permissionDescription);
        newPermission.setAvailable(true);
        try{

            int addCount = permissionDao.addPermission(newPermission);
            if(addCount == 0){
                throw new RuntimeException();
            }
        }catch (Exception e){
            log.error("添加权限失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(402,null,"添加权限失败");
        }
        return new WebResponse().ok(newPermission);
    }
}
