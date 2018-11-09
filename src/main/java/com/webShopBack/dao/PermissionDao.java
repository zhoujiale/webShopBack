package com.webShopBack.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @Auther: zhou
 * @Date: 2018/10/23 14:47
 * @Description:
 */
@Repository
public interface PermissionDao {

    /**
     * @description 根据用户查询权限
     * @author zhou
     * @created  2018/10/23 14:53
     * @param
     * @return
     */
    @Select("select permissionName from user_permission where id in(" +
            "select permission_id from auh_role_permission where role_id in" +
            " (select role_id from auth_user_role where user_id in(select " +
            "  userId from user where userName= #{userName})))")
    Set<String> findPermissionByUserName(String userName);
}
