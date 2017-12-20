package com.wlwk.oauth2.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	private @Value("${sys.main.url:}") String main_url;

	@GetMapping({ "/", "/login" })
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("login");
		mav.addObject("main_url", main_url);
		return mav;
	}
}
