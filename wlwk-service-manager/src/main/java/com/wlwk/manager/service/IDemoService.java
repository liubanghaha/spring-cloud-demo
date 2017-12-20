package com.wlwk.manager.service;

import com.wlwk.framework.domain.Pagination;
import com.wlwk.framework.support.BusinessException;
import com.wlwk.manager.domain.UserAccount;

public interface IDemoService {

	/**
	 * 查询用户账号
	 * 
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	UserAccount findUserAccount(String userId) throws BusinessException;

	/**
	 * 添加账号
	 * 
	 * @param userId
	 * @param loginName
	 * @param loginPwd
	 * @param confirmPwd
	 * @throws BusinessException
	 */
	void addUserAccount(String userId, String loginName, String loginPwd, String confirmPwd) throws BusinessException;

	/**
	 * 查询用户账号列表
	 * 
	 * @param userId
	 * @param page
	 * @param rows
	 * @return
	 * @throws BusinessException
	 */
	Pagination<UserAccount> listUserAccount(String userId, Integer page, Integer rows) throws BusinessException;

	/**
	 * 跨服务调用示例
	 * 
	 * @param userId
	 * @return
	 * @throws BusinessException
	 */
	String feignClientDemo(String userId) throws BusinessException;

}
