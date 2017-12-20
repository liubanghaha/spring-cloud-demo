package com.wlwk.manager.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wlwk.framework.constants.CommonConstants;
import com.wlwk.framework.domain.Pagination;
import com.wlwk.framework.support.BusinessException;
import com.wlwk.framework.utils.CollectionUtils;
import com.wlwk.framework.utils.DigestUtils;
import com.wlwk.framework.utils.StringUtils;
import com.wlwk.manager.client.IDemoTestClient;
import com.wlwk.manager.domain.UserAccount;
import com.wlwk.manager.repository.UserAccountMapper;
import com.wlwk.manager.service.IDemoService;

@Service
public class DemoServiceImpl implements IDemoService {
	private @Resource UserAccountMapper userAccountMapper;
	private @Resource IDemoTestClient demoTestClient;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
	public UserAccount findUserAccount(String userId) throws BusinessException {
		return userAccountMapper.selectById(userId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void addUserAccount(String userId, String loginName, String loginPwd, String confirmPwd) throws BusinessException {
		if (!loginPwd.equals(confirmPwd)) {
			throw new BusinessException("entered.passwords.differ");// 两次密码不一致
		}
		UserAccount where = new UserAccount();
		where.setLoginName(loginName);
		where.setDelMark(CommonConstants.STATE_NORMAL);

		List<UserAccount> userAccount = userAccountMapper.select(where);
		if (CollectionUtils.isNotEmpty(userAccount)) {
			throw new BusinessException("account.already.exists");// 账号已存在
		}

		UserAccount account = UserAccount.builder()//
				.pkId(StringUtils.uuid())//
				.createTime(new Date())//
				.createUser(userId)//
				.updateTime(new Date())//
				.updateUser(userId)//
				.delMark(CommonConstants.STATE_NORMAL)//
				.loginName(loginName)//
				.loginPwd(DigestUtils.md5Hex(loginPwd))//
				.status(CommonConstants.USER_ACCOUNT_NORMAL)//
				.build();

		userAccountMapper.insert(account);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
	public Pagination<UserAccount> listUserAccount(String userId, Integer page, Integer rows) throws BusinessException {
		Page<UserAccount> pageResult = PageHelper.startPage(page, rows, true);
		PageHelper.orderBy(" create_time DESC");

		UserAccount where = new UserAccount();
		where.setDelMark(CommonConstants.STATE_NORMAL);

		userAccountMapper.select(where);

		return new Pagination<UserAccount>(pageResult.getTotal(), pageResult.getResult());
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
	public String feignClientDemo(String userId) throws BusinessException {
		return demoTestClient.demoTest(1);
	}
}
