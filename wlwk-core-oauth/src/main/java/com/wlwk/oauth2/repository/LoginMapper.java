package com.wlwk.oauth2.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wlwk.oauth2.domain.UserAccount;


@Mapper
public interface LoginMapper {
    /**
     * 根据账户名查询用户信息
     * 
     * @param userName
     * @return
     */
    @Select("SELECT pk_id,login_name,login_pwd,status FROM t_user_account WHERE login_name = #{username} AND del_mark = 1 Limit 1")
    UserAccount getUserInfoByName(@Param("username") String username);

    /**
     * 查询用户角色
     * 
     * @param userId
     * @return
     */
    @Select("SELECT role_id FROM t_user_role WHERE user_id = #{userId} AND del_mark = 1")
    List<String> listUserRole(@Param("userId") String userId);
    

    /**
     * @param roleIds
     * @return
     */
    @Select("SELECT role_auth_code FROM t_role_auth WHERE role_id IN(${roleIds})")
    List<String> listRoleAuths(@Param("roleIds") String roleIds);
}
