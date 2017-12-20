package com.wlwk.framework.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT,
        propagation = Propagation.SUPPORTS,
        readOnly = true,
        rollbackFor = Exception.class)
public abstract class BaseService {

}
