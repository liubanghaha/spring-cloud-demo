package com.wlwk.manager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlwk.manager.domain.UserRole;

@Mapper
@Repository
public interface UserRoleMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param userRole
	 * @return
	 */
	Integer insert(@Param("userRole") UserRole userRole);
	
	/**
	 * 更新数据
	 * 
	 * @param userRole
	 * @param where
	 * @return
	 */
	Integer update(@Param("userRole") UserRole userRole, @Param("where") UserRole where);

	/**
	 * 根据主键更新
	 * 
	 * @param userRole
	 * @param userRoleId
	 * @return
	 */
	Integer updateById(@Param("userRole") UserRole userRole, @Param("userRoleId") String userRoleId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param userRole
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("userRole") UserRole userRole, @Param("where") UserRole where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param userRole
	 * @param userRoleId
	 * @return
	 */
	Integer updateActiveById(@Param("userRole") UserRole userRole, @Param("userRoleId") String userRoleId);

	/**
	 * 查询列表
	 * 
	 * @param userRole
	 * @return
	 */
	List<UserRole> select(@Param("userRole") UserRole userRole);

	/**
	 * 根据主键查询
	 * 
	 * @param userRoleId
	 * @return
	 */
	UserRole selectById(@Param("userRoleId") String userRoleId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") UserRole where);

	/**
	 * 按主键删除
	 * 
	 * @param userRoleId
	 * @return
	 */
	Integer deleteById(@Param("userRoleId") String userRoleId);
}
