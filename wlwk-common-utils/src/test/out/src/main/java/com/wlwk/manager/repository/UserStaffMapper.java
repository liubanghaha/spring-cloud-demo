package com.wlwk.manager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlwk.manager.domain.UserStaff;

@Mapper
@Repository
public interface UserStaffMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param userStaff
	 * @return
	 */
	Integer insert(@Param("userStaff") UserStaff userStaff);
	
	/**
	 * 更新数据
	 * 
	 * @param userStaff
	 * @param where
	 * @return
	 */
	Integer update(@Param("userStaff") UserStaff userStaff, @Param("where") UserStaff where);

	/**
	 * 根据主键更新
	 * 
	 * @param userStaff
	 * @param userStaffId
	 * @return
	 */
	Integer updateById(@Param("userStaff") UserStaff userStaff, @Param("userStaffId") String userStaffId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param userStaff
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("userStaff") UserStaff userStaff, @Param("where") UserStaff where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param userStaff
	 * @param userStaffId
	 * @return
	 */
	Integer updateActiveById(@Param("userStaff") UserStaff userStaff, @Param("userStaffId") String userStaffId);

	/**
	 * 查询列表
	 * 
	 * @param userStaff
	 * @return
	 */
	List<UserStaff> select(@Param("userStaff") UserStaff userStaff);

	/**
	 * 根据主键查询
	 * 
	 * @param userStaffId
	 * @return
	 */
	UserStaff selectById(@Param("userStaffId") String userStaffId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") UserStaff where);

	/**
	 * 按主键删除
	 * 
	 * @param userStaffId
	 * @return
	 */
	Integer deleteById(@Param("userStaffId") String userStaffId);
}
