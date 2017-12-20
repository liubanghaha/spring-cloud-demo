package com.wlwk.manager.client.hystrix;

import org.springframework.stereotype.Component;

import com.wlwk.framework.support.BusinessException;
import com.wlwk.manager.client.IDemoTestClient;

@Component
public class DemoTestClientHystrix implements IDemoTestClient {

	@Override
	public String demoTest(Integer source) throws BusinessException {
		return "Hystrix";
	}
}
