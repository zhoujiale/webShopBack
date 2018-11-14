package com.webShopBack.dao;

import com.webShopBack.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
}
