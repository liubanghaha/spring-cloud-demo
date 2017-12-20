package com.wlwk.manager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlwk.manager.domain.RoleAuth;

@Mapper
@Repository
public interface RoleAuthMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param roleAuth
	 * @return
	 */
	Integer insert(@Param("roleAuth") RoleAuth roleAuth);
	
	/**
	 * 更新数据
	 * 
	 * @param roleAuth
	 * @param where
	 * @return
	 */
	Integer update(@Param("roleAuth") RoleAuth roleAuth, @Param("where") RoleAuth where);

	/**
	 * 根据主键更新
	 * 
	 * @param roleAuth
	 * @param roleAuthId
	 * @return
	 */
	Integer updateById(@Param("roleAuth") RoleAuth roleAuth, @Param("roleAuthId") String roleAuthId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param roleAuth
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("roleAuth") RoleAuth roleAuth, @Param("where") RoleAuth where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param roleAuth
	 * @param roleAuthId
	 * @return
	 */
	Integer updateActiveById(@Param("roleAuth") RoleAuth roleAuth, @Param("roleAuthId") String roleAuthId);

	/**
	 * 查询列表
	 * 
	 * @param roleAuth
	 * @return
	 */
	List<RoleAuth> select(@Param("roleAuth") RoleAuth roleAuth);

	/**
	 * 根据主键查询
	 * 
	 * @param roleAuthId
	 * @return
	 */
	RoleAuth selectById(@Param("roleAuthId") String roleAuthId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") RoleAuth where);

	/**
	 * 按主键删除
	 * 
	 * @param roleAuthId
	 * @return
	 */
	Integer deleteById(@Param("roleAuthId") String roleAuthId);
}
