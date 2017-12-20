package com.wlwk.framework.web.support.security;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class Md5PasswordEncoder extends MessageDigestPasswordEncoder {

	public Md5PasswordEncoder() {
		super("MD5");
	}

	@Override
	public String encodePassword(String rawPass, Object salt) {
		return super.encodePassword(rawPass, salt).substring(8, 24);
	}

}
