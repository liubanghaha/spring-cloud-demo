package com.wlwk.oauth2.web.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {

	@GetMapping({ "/user", "/me" })
	public Principal user(Principal user) {
		return user;
	}
}
