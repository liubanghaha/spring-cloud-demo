package com.wlwk.customers.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wlwk.framework.support.BusinessException;
import com.wlwk.framework.web.controller.BaseController;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class DemoController extends BaseController {
	
	@RequestMapping("/demo-test")
	public String demoTest(@RequestParam("source") Integer source) throws BusinessException {
		return "customers";
	}
}
