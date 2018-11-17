package com.webShopBack.controller;/**
 * @Auther: bee
 * @Date: 2018/11/14 18:14
 * @Description:
 */

import com.webShopBack.response.WebResponse;
import com.webShopBack.service.RoleService;
import com.webShopBack.utils.IntUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *@ClassName RoleController
 *@Description 角色管理
 *@Author zhou
 *Date 2018/11/14 18:14
 *@Version 1.0
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    private static Logger log = Logger.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * @description 返回所有角色
     * @author zhou
     * @created  2018/11/15 9:19    
     * @param 
     * @return 
     */
    @RequestMapping(value = "/getAllRole",method = RequestMethod.POST)
    public WebResponse getAllRole(){
        WebResponse webResponse = roleService.getAllRole();
        return webResponse;
    }

    /**
     * @description 为角色添加权限
     * @author zhou
     * @created  2018/11/15 9:32
     * @param
     * @return
     */
    @RequestMapping(value = "/addPermissionByRole",method = RequestMethod.POST)
    public WebResponse addPermissionByRole(int roleId,int permissionId){
        if(IntUtil.isEmpty(roleId)){
            log.error("角色编号不正确");
            return new WebResponse().error(401,null,"角色编号不正确");
        }
        if(IntUtil.isEmpty(permissionId)){
            log.error("权限编号不正确");
            return new WebResponse().error(402,null,"权限编号不正确");
        }
        WebResponse webResponse = roleService.addPermissionByRole(roleId,permissionId);
        return webResponse;
    }

    /**
     * @description 禁用/启用角色
     * @author zhou
     * @created  2018/11/16 11:14
     * @param
     * @return
     */
    @RequestMapping(value = "/lockedRole",method = RequestMethod.POST)
    public WebResponse lockedRole(int roleId,@RequestParam(value = "available",defaultValue = "false") boolean available){
        if(IntUtil.isEmpty(roleId)){
            log.error("角色id为空");
        }
        WebResponse webResponse = roleService.lockedRole(roleId,available);
        return webResponse;
    }
}