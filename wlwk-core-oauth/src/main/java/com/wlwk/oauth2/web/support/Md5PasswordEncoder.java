package com.wlwk.oauth2.web.support;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class Md5PasswordEncoder extends MessageDigestPasswordEncoder {

	public Md5PasswordEncoder() {
		super("MD5");
	}

	@Override
	public String encodePassword(String rawPass, Object salt) {
		return super.encodePassword(rawPass, salt);
	}

}
