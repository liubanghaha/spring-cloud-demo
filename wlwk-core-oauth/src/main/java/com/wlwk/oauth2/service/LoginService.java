package com.wlwk.oauth2.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wlwk.framework.service.BaseService;
import com.wlwk.framework.support.BusinessException;
import com.wlwk.framework.utils.CollectionUtils;
import com.wlwk.framework.utils.StringUtils;
import com.wlwk.oauth2.domain.UserAccount;
import com.wlwk.oauth2.repository.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService extends BaseService {
    private @Resource LoginMapper loginMapper;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
    public UserAccount getUserInfoByName(String username) throws BusinessException {
        log.info("user.login:{}", username);
        return loginMapper.getUserInfoByName(username);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
    public List<String> listAutoByUser(String userId) throws BusinessException {
        List<String> auths = new ArrayList<String>();
        List<String> roleIds = loginMapper.listUserRole(userId);
        if (CollectionUtils.isNotEmpty(roleIds)) {
            // 查询角色资源码
            List<String> resources = loginMapper.listRoleAuths("'" + StringUtils.join(roleIds.toArray(), "','") + "'");
            if (CollectionUtils.isNotEmpty(resources)) {
                auths.addAll(resources);
            }
        }
        return auths;
    }
}
