package com.wlwk.manager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlwk.manager.domain.RoleInfo;

@Mapper
@Repository
public interface RoleInfoMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param roleInfo
	 * @return
	 */
	Integer insert(@Param("roleInfo") RoleInfo roleInfo);
	
	/**
	 * 更新数据
	 * 
	 * @param roleInfo
	 * @param where
	 * @return
	 */
	Integer update(@Param("roleInfo") RoleInfo roleInfo, @Param("where") RoleInfo where);

	/**
	 * 根据主键更新
	 * 
	 * @param roleInfo
	 * @param roleInfoId
	 * @return
	 */
	Integer updateById(@Param("roleInfo") RoleInfo roleInfo, @Param("roleInfoId") String roleInfoId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param roleInfo
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("roleInfo") RoleInfo roleInfo, @Param("where") RoleInfo where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param roleInfo
	 * @param roleInfoId
	 * @return
	 */
	Integer updateActiveById(@Param("roleInfo") RoleInfo roleInfo, @Param("roleInfoId") String roleInfoId);

	/**
	 * 查询列表
	 * 
	 * @param roleInfo
	 * @return
	 */
	List<RoleInfo> select(@Param("roleInfo") RoleInfo roleInfo);

	/**
	 * 根据主键查询
	 * 
	 * @param roleInfoId
	 * @return
	 */
	RoleInfo selectById(@Param("roleInfoId") String roleInfoId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") RoleInfo where);

	/**
	 * 按主键删除
	 * 
	 * @param roleInfoId
	 * @return
	 */
	Integer deleteById(@Param("roleInfoId") String roleInfoId);
}
