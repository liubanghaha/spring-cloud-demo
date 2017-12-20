package com.wlwk.manager.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wlwk.framework.support.BusinessException;
import com.wlwk.manager.client.hystrix.DemoTestClientHystrix;

@FeignClient(name = "WLWK-SERVICE-CUSTOMERS", fallback = DemoTestClientHystrix.class)
public interface IDemoTestClient {
	
	@RequestMapping("/demo-test")
	public String demoTest(@RequestParam("source") Integer source) throws BusinessException;
}
