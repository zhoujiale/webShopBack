package com.webShopBack.dao;

import com.webShopBack.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: bee
 * @Date: 2018/10/23 14:29
 * @Description:
 */
@Repository
public interface RoleDao {

    /**
     * @description 根据用户名查询角色
     * @author zhou
     * @created  2018/11/12 10:53
     * @param 
     * @return 
     */
    List<String> findRoleByUserName(String userName);

    /**
     * @description 根据角色名查询角色
     * @author zhou
     * @created  2018/11/14 10:00    
     * @param 
     * @return 
     */
    Role findRoleByRoleName(String roleName);

    /**
     * @description 添加角色
     * @author zhou
     * @created  2018/11/14 16:15
     * @param 
     * @return 
     */
    int addRole(Role newRole);

    /**
     * @description 返回所有的角色
     * @author zhou
     * @created  2018/11/14 18:27
     * @param
     * @return
     */
    List<HashMap<String,Object>> getAllRole();

    /**
     * @description 根据角色编号查角色
     * @author zhou
     * @created  2018/11/15 9:40
     * @param 
     * @return 
     */
    Role findRoleByRoleId(int roleId);
    
    /**
     * @description 角色添加权限
     * @author zhou
     * @created  2018/11/16 10:13
     * @param 
     * @return 
     */
    int addPermission(@Param("roleId") int roleId,@Param("permissionId") int permissionId);

    /**
     * @description 禁用/启用角色
     * @author zhou
     * @created  2018/11/16 11:31    
     * @param
     * @param available
     * @return
     */
    int lockedRole(@Param("roleId") int roleId,@Param("available") boolean available);
}