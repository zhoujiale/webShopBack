package com.webShopBack.controller;/**
 * @Auther: zhou
 * @Date: 2018/10/17 14:55
 * @Description:
 */


import com.webShopBack.response.WebResponse;
import com.webShopBack.service.PermissionService;
import com.webShopBack.service.RoleService;
import com.webShopBack.service.UserService;
import com.webShopBack.utils.IntUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Set;

import static com.webShopBack.utils.StringUtil.isEmpty;


/**
 *@ClassName UserController
 *@Description 用户Web层
 *@Author zhou
 *Date 2018/10/17 14:55
 *@Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * @description 登陆
     * @author zhou
     * @created  2018/11/9 16:33
     * @param userName 用户名
     * @param password 密码
     * @param rememberMe 记住账号
     * @return
     */
    @RequestMapping(value = "/login")
    public WebResponse userLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,
                                 @RequestParam(value = "rememberMe",defaultValue = "false") boolean rememberMe,
                                         HttpServletRequest request){
        if(isEmpty(userName)||isEmpty(password)){
            log.error("用户名或密码为空");
            return new WebResponse().error(401,null,"用户名或密码为空");
        }
        //查询角色
        Set<String> roleList = roleService.findRoleByUserName(userName);
        //查询权限
        Set<String> permissionList = permissionService.findPermissionByUserName(userName);
        //获得主体
        Subject currentUser = SecurityUtils.getSubject();
        //判断用户是否登陆
        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            try {
                //token.setRememberMe(rememberMe);
                //存入参数
                request.getSession().setAttribute("token",userName);
                request.getSession().setAttribute("role",roleList);
                request.getSession().setAttribute("permission",permissionList);
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.error("账号不存在");
                return new WebResponse().error(402, null, "账号不存在");
            } catch (IncorrectCredentialsException ice) {
                log.error("密码错误,请重试");
                return new WebResponse().error(403, null, "密码错误，请重试");
            } catch (LockedAccountException lae) {
                log.error("该账号已被禁用,无法登陆");
                return new WebResponse().error(404, null, "该账号已被禁用，无法登陆");
            } catch (AuthenticationException ae) {
                log.error("未知错误");
                return new WebResponse().error(405, null, "未知错误");
            }
        }
        HashMap<String,Object> userMap = new HashMap<>();
        userMap.put("msg",userName + "登陆成功");
        userMap.put("role",roleList);
        userMap.put("permission",permissionList);
        return new WebResponse().ok(userMap);
    }

    /**
     * @description 添加用户
     * @author zhou
     * @created  2018/10/19 11:11
     * @param userName 用户名
     * @param password 密码
     * @param roleId 角色id
     * @return :webResponse
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @RequiresPermissions("addUser")
    public WebResponse addUser(String userName,String password,int roleId){

        if(isEmpty(userName)||isEmpty(password)){
            log.error("用户名或密码为空");
            return new WebResponse().error(401,null,"用户名或密码为空");
        }
        if(IntUtil.isIntEmpty(roleId)){
            log.error("角色id为空");
            return new WebResponse().error(402,null,"角色id为空");
        }
        WebResponse webResponse = userService.addUser(userName,password,roleId);
        return webResponse;
    }

    /**
     * @description 禁用/解禁用户
     * @author zhou
     * @created  2018/11/13 16:40
     * @param userName 用户名
     * @param state 状态
     * @return
     */
    @RequestMapping(value = "/lockedUser",method = RequestMethod.POST)
    @RequiresPermissions("lockedUser")
    public WebResponse lockedUser(String userName,int state,HttpServletRequest request){
        if(isEmpty(userName)){
            log.error("用户名为空");
            return new WebResponse().error(401,null,"用户名为空");
        }
        String token = (String) request.getSession().getAttribute("token");
        if(token.equals(userName)){
            log.error("不能操作本人");
            return new WebResponse().error(402,null,"不能操作本人");
        }
        WebResponse webResponse = userService.lockedUser(userName,state);
        return webResponse;
    }

    /**
     * @description 退出登录
     * @author zhou
     * @created  2018/11/13 11:23
     * @param userName 用户名
     * @return
     */
    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    public WebResponse loginOut(String userName){
        if(isEmpty(userName)){
            log.error("用户名为空");
            return new WebResponse().error(401,null,"用户名为空");
        }
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return new WebResponse().ok(userName + "退出登录");
    }


    /**
     * @description 添加角色
     * @author zhou
     * @created  2018/11/14 9:50    
     * @param roleName 角色名
     * @param roleDescription 角色描述
     * @return 
     */
    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    @RequiresPermissions("addRole")
    public WebResponse addRole(String roleName,String roleDescription){
        if(isEmpty(roleName)){
            log.error("角色名不能为空");
            return new WebResponse().error(401,null,"角色名不能为空");
        }
        WebResponse webResponse = roleService.addRole(roleName,roleDescription);
        return webResponse;
    }

    /**
     * @description 获得所有的用户
     * @author zhou
     * @created  2018/11/17 16:06    
     * @param pageNum 页号
     * @param pageSize 每页记录数
     * @return 
     */
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public WebResponse getAllUser(@RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                  @RequestParam(value = "pageNum",defaultValue = "1") int pageNum){
        WebResponse webResponse = userService.getAllUser(pageSize,pageNum);
        return webResponse;
    }
    /**
     * @description 添加权限
     * @author zhou
     * @created  2018/11/26 17:26
     * @param permissionName 权限名称
     * @param permissionDescription 权限描述
     * @return
     */
    @RequestMapping(value = "/addPermission",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse addPermission(String permissionName,String permissionDescription){
        WebResponse webResponse = permissionService.addPermission(permissionName,permissionDescription);
        return webResponse;
    }



}
