package com.webShopBack.service.impl;/**
 * @Auther: bee
 * @Date: 2018/10/23 14:13
 * @Description:
 */

import com.webShopBack.dao.RoleDao;
import com.webShopBack.entity.Role;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.RoleService;
import org.apache.ibatis.javassist.bytecode.Descriptor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

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

    /**
     * @description 添加角色
     * @author zhou
     * @created  2018/11/14 9:57    
     * @param 
     * @return 
     */
    @Override
    @Transactional
    public WebResponse addRole(String roleName, String roleDescription) {
        Role role = roleDao.findRoleByRoleName(roleName);
        if(role.getRoleName().equals(roleName)){
            log.error("角色名重复");
            return new WebResponse().error(402,null,"角色名重复");
        }
        Role newRole = new Role();
        newRole.setRoleName(roleName);
        newRole.setRoleDescription(roleDescription);
        newRole.setAvailable(true);

        //添加角色
        try{
            int addCount = roleDao.addRole(newRole);
            if(addCount == 0){
                throw new RuntimeException();
            }
        }catch (Exception e){
            log.error("添加角色失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(403,null,"添加角色失败");
        }
        return new WebResponse().ok("添加角色" + roleName + "成功");
    }
}
