package com.webShopBack.service.impl;/**
 * @Auther: zhou
 * @Date: 2018/10/23 14:13
 * @Description:
 */

import com.webShopBack.dao.PermissionDao;
import com.webShopBack.dao.RoleDao;
import com.webShopBack.entity.Permission;
import com.webShopBack.entity.Role;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.RoleService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

/**
 * @ClassName RoleServiceImpl
 * @Description 角色实现类
 * @Author zhou
 * Date 2018/10/23 14:13
 * @Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    /**
     * @param userName 用户名
     * @return
     * @description 根据用户名查询角色
     * @author zhou
     * @created 2018/10/23 14:27
     */
    @Override
    public Set<String> findRoleByUserName(String userName) {
        List<String> roleList = roleDao.findRoleByUserName(userName);
        Set<String> keySet = new HashSet<>(roleList);
        return keySet;
    }

    /**
     * @param roleDescription 角色描述
     * @param roleName 角色名
     * @return
     * @description 添加角色
     * @author zhou
     * @created 2018/11/14 9:57
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public WebResponse addRole(String roleName, String roleDescription) {
        Role role = roleDao.findRoleByRoleName(roleName);
        if (role != null) {
            log.error("角色名重复");
            return new WebResponse().error(402, null, "角色名重复");
        }
        Role newRole = new Role();
        newRole.setRoleName(roleName);
        newRole.setRoleDescription(roleDescription);
        newRole.setAvailable(true);
        //添加角色
        try {
            int addCount = roleDao.addRole(newRole);
            if (addCount == 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.error("添加角色失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(403, null, "添加角色失败");
        }
        return new WebResponse().ok(newRole);
    }

    /**
     * @param
     * @return
     * @description 返回所有的角色
     * @author zhou
     * @created 2018/11/14 18:21
     */
    @Override
    public WebResponse getAllRole() {
        List<HashMap<String, Object>> roleList = roleDao.getAllRole();
        return new WebResponse().ok(roleList);
    }

    /**
     * @param roleId 角色id
     * @param permissionId 权限id
     * @return
     * @description 为角色添加权限
     * @author zhou
     * @created 2018/11/15 9:36
     */
    @Override
    @RequiresPermissions("addPermissionByRole")
    public WebResponse addPermissionByRole(int roleId, int permissionId) {
        Role role = roleDao.findRoleByRoleId(roleId);
        if (role == null) {
            log.error("角色不存在或禁用");
            return new WebResponse().error(403, null, "角色不存在或禁用");
        }
        Permission permission = permissionDao.findPermissionById(permissionId);
        if (permission == null) {
            log.error("权限不存在或禁用");
            return new WebResponse().error(404, null, "权限不存在或禁用");
        }
        try {
            //添加权限
            int addRolePermission = roleDao.addPermission(roleId, permissionId);
            if (addRolePermission == 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.error("角色添加权限失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(405, null, "角色添加权限失败");
        }
        return new WebResponse().ok("角色" + role.getRoleName() + "添加权限" + permission.getPermissionName() + "成功");
    }

    /**
     * @param roleId    角色Id
     * @param available 是否可用
     * @return
     * @description 禁用/启用角色
     * @author zhou
     * @created 2018/11/16 11:17
     */
    @Override
    public WebResponse lockedRole(int roleId, boolean available) {

        Role role = roleDao.findRoleByRoleId(roleId);
        String str = "";
        if (role.getAvailable() == true) {
            str = "启用";
        } else {
            str = "禁用";
        }
        try {
            int updateRole = roleDao.lockedRole(roleId, available);
            if (updateRole == 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            log.error("禁用或启用失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new WebResponse().error(403, null, "禁用或启用失败");
        }
        return new WebResponse().ok(role.getRoleName() + str + "成功");
    }
}
