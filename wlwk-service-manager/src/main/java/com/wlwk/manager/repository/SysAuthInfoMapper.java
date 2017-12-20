package com.wlwk.manager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlwk.manager.domain.SysAuthInfo;

@Mapper
@Repository
public interface SysAuthInfoMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param sysAuthInfo
	 * @return
	 */
	Integer insert(@Param("sysAuthInfo") SysAuthInfo sysAuthInfo);
	
	/**
	 * 更新数据
	 * 
	 * @param sysAuthInfo
	 * @param where
	 * @return
	 */
	Integer update(@Param("sysAuthInfo") SysAuthInfo sysAuthInfo, @Param("where") SysAuthInfo where);

	/**
	 * 根据主键更新
	 * 
	 * @param sysAuthInfo
	 * @param sysAuthInfoId
	 * @return
	 */
	Integer updateById(@Param("sysAuthInfo") SysAuthInfo sysAuthInfo, @Param("sysAuthInfoId") String sysAuthInfoId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param sysAuthInfo
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("sysAuthInfo") SysAuthInfo sysAuthInfo, @Param("where") SysAuthInfo where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param sysAuthInfo
	 * @param sysAuthInfoId
	 * @return
	 */
	Integer updateActiveById(@Param("sysAuthInfo") SysAuthInfo sysAuthInfo, @Param("sysAuthInfoId") String sysAuthInfoId);

	/**
	 * 查询列表
	 * 
	 * @param sysAuthInfo
	 * @return
	 */
	List<SysAuthInfo> select(@Param("sysAuthInfo") SysAuthInfo sysAuthInfo);

	/**
	 * 根据主键查询
	 * 
	 * @param sysAuthInfoId
	 * @return
	 */
	SysAuthInfo selectById(@Param("sysAuthInfoId") String sysAuthInfoId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") SysAuthInfo where);

	/**
	 * 按主键删除
	 * 
	 * @param sysAuthInfoId
	 * @return
	 */
	Integer deleteById(@Param("sysAuthInfoId") String sysAuthInfoId);
}
