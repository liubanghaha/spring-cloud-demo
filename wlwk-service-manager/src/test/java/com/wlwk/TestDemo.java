package com.wlwk;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wlwk.framework.constants.CommonConstants;
import com.wlwk.framework.utils.StringUtils;
import com.wlwk.manager.domain.RoleInfo;
import com.wlwk.manager.repository.RoleInfoMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
	private @Resource RoleInfoMapper roleInfoMapper;

	@Test
	public void sysAdminTest() {
		RoleInfo sysAdmin = RoleInfo.builder()//
				.pkId(StringUtils.uuid())//
				.createTime(new Date())//
				.createUser("0")//
				.updateTime(new Date())//
				.updateUser("0")//
				.delMark(CommonConstants.STATE_NORMAL)//
				.orgId("0")//
				.roleName("管理系统管理员")//
				.remark("管理系统管理员")//
				.roleType(1)//
				.build();
		roleInfoMapper.insert(sysAdmin);
	}
	
	@Test
	public void cusAdminTest() {
		RoleInfo cusAdmin = RoleInfo.builder()//
				.pkId(StringUtils.uuid())//
				.createTime(new Date())//
				.createUser("0")//
				.updateTime(new Date())//
				.updateUser("0")//
				.delMark(CommonConstants.STATE_NORMAL)//
				.orgId("0")//
				.roleName("客户平台管理员")//
				.remark("客户平台管理员")//
				.roleType(1)//
				.build();
		roleInfoMapper.insert(cusAdmin);
	}

}
