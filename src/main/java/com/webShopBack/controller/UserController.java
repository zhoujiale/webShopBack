package com.webShopBack.controller;/**
 * @Auther: bee
 * @Date: 2018/10/17 14:55
 * @Description:
 */

import com.webShopBack.entity.User;
import com.webShopBack.response.WebResponse;
import com.webShopBack.service.PermissionService;
import com.webShopBack.service.RoleService;
import com.webShopBack.service.UserService;
import com.webShopBack.utils.IntUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.net.www.http.HttpClient;


import java.util.Set;

import static com.webShopBack.utils.StringUtil.isEmpty;


/**
 *@ClassName UserController
 *@Description TODO
 *@Author bee
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
     * @param
     * @return
     */
    @RequestMapping(value = "/login")
    public WebResponse UserLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,
                                 @RequestParam(value = "rememberMe",defaultValue = "false") boolean rememberMe){
        if(isEmpty(userName)||isEmpty(password)){
            log.error("用户名或密码为空");
            return new WebResponse().error(401,null,"用户名或密码为空");
        }
        Subject currentUser = SecurityUtils.getSubject();
        //判断用户是否登陆

        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            try {
                //token.setRememberMe(rememberMe);
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
        return new WebResponse().ok(userName + "登陆成功");
    }

    /**
     * @description 添加用户
     * @author zhou
     * @created  2018/10/19 11:11
     * @param  :userName,password
     * @return :webResponse
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public WebResponse addUser(String userName,String password,int roleId){

        if(isEmpty(userName)||isEmpty(password)){
            log.error("用户名或密码为空");
            return new WebResponse().error(401,null,"用户名或密码为空");
        }
        if(IntUtil.isEmpty(roleId)){
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
     * @param
     * @return
     */
    @RequestMapping(value = "/lockedUser",method = RequestMethod.POST)
    public WebResponse lockedUser(String userName,int state){
        if(isEmpty(userName)){
            log.error("用户名为空");
            return new WebResponse().error(401,null,"用户名为空");
        }
        WebResponse webResponse = userService.lockedUser(userName,state);
        return webResponse;
    }

    /**
     * @description 退出登录
     * @author zhou
     * @created  2018/11/13 11:23
     * @param
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

    @RequestMapping(value = "/selectPermission",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse selectRole(String userName){
    Set<String> permission = permissionService.findPermissionByUserName(userName);
        return new WebResponse().ok(permission);
    }



}
