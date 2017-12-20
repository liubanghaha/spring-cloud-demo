package com.wlwk.manager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wlwk.manager.domain.UserAccount;

@Mapper
@Repository
public interface UserAccountMapper {
	
	/**
	 * 插入数据
	 * 
	 * @param userAccount
	 * @return
	 */
	Integer insert(@Param("userAccount") UserAccount userAccount);
	
	/**
	 * 更新数据
	 * 
	 * @param userAccount
	 * @param where
	 * @return
	 */
	Integer update(@Param("userAccount") UserAccount userAccount, @Param("where") UserAccount where);

	/**
	 * 根据主键更新
	 * 
	 * @param userAccount
	 * @param userAccountId
	 * @return
	 */
	Integer updateById(@Param("userAccount") UserAccount userAccount, @Param("userAccountId") String userAccountId);
	
	/**
	 * 更新有值数据
	 * 
	 * @param userAccount
	 * @param where
	 * @return
	 */
	Integer updateActive(@Param("userAccount") UserAccount userAccount, @Param("where") UserAccount where);

	/**
	 * 根据主键更新有值数据
	 * 
	 * @param userAccount
	 * @param userAccountId
	 * @return
	 */
	Integer updateActiveById(@Param("userAccount") UserAccount userAccount, @Param("userAccountId") String userAccountId);

	/**
	 * 查询列表
	 * 
	 * @param userAccount
	 * @return
	 */
	List<UserAccount> select(@Param("userAccount") UserAccount userAccount);

	/**
	 * 根据主键查询
	 * 
	 * @param userAccountId
	 * @return
	 */
	UserAccount selectById(@Param("userAccountId") String userAccountId);

	/**
	 * 按条件删除
	 * 
	 * @param where
	 * @return
	 */
	Integer delete(@Param("where") UserAccount where);

	/**
	 * 按主键删除
	 * 
	 * @param userAccountId
	 * @return
	 */
	Integer deleteById(@Param("userAccountId") String userAccountId);
}
