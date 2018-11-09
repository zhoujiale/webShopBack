package com.webShopBack.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
     * @created  2018/10/23 14:30
     * @param
     * @return
     */
    @Select("select roleName from user_role where id in(" +
            "  select role_id from auth_user_role where user_id in(" +
            "  select userId from user where userName =' #{userName}))")
    Set<String> findRoleByUserName(String userName);
}
