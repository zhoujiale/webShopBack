package com.webshopback.shrio;/**
 * @Auther: zhou
 * @Date: 2018/10/17 11:39
 * @Description:
 */

import com.webshopback.entity.User;
import com.webshopback.service.PermissionService;
import com.webshopback.service.RoleService;
import com.webshopback.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 *@ClassName myRealm
 *@Description TODO
 *@Author zhou
 *Date 2018/10/17 11:39
 *@Version 1.0
 **/
public class myRealm extends AuthorizingRealm{

    private static Logger log = Logger.getLogger(myRealm.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * @description 为当前登录的用户授予角色和权限
     * @author zhou
     * @created  2018/10/17 15:15
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String userName = (String)principalCollection.getPrimaryPrincipal();
        Session session = SecurityUtils.getSubject().getSession();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //查询用户的role
        Set<String> roles = roleService.findRoleByUserName(userName);
        authorizationInfo.setRoles(roles);

        //查询用户的permission
        Set<String> permissions = permissionService.findPermissionByUserName(userName);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * @description 验证当前登录的用户
     * @author zhou
     * @created  2018/10/17 15:16
     * @param
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws
            AuthenticationException {
        //获得用户信息
        String userName = (String)authenticationToken.getPrincipal();
        //从数据库中查找
        User user = userService.findByUserName(userName);
        if(user==null){
            //账号不存在
            throw new UnknownAccountException();
        }else if(user.getState() == 1){
            //账号锁定
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
                user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        return simpleAuthenticationInfo;
    }
}
