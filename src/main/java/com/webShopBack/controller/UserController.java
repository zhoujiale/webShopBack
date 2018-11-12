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
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public WebResponse UserLogin(String userName,String password){
        if(isEmpty(userName)||isEmpty(password)){
            log.error("用户名或密码为空");
            return new WebResponse().error(401,null,"用户名或密码为空");
        }
        Subject currentUser = SecurityUtils.getSubject();
        //判断用户是否登陆

        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
            try {
                currentUser.login(usernamePasswordToken);
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
        return new WebResponse().ok("登陆成功");
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
        WebResponse webResponse = userService.addUser(userName,password);
        return webResponse;
    }

    @RequestMapping(value = "/selectPermission",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public WebResponse selectRole(String userName){
    Set<String> permission = permissionService.findPermissionByUserName(userName);
        return new WebResponse().ok(permission);
    }



}
