package com.wlwk.framework.web.controller;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@Order(2)
@ControllerAdvice(basePackages = "com.wlwk")
public class JsonpResponseBodyAdvice extends AbstractJsonpResponseBodyAdvice {
	public JsonpResponseBodyAdvice() {
		super("callback", "jsonp"); // 指定jsonpParameterNames
	}
}
