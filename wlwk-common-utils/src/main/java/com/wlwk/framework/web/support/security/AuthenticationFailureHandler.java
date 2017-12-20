package com.wlwk.framework.web.support.security;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wlwk.framework.domain.AjaxReturn;

public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		try (Writer writer = response.getWriter();) {
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			objectMapper.writeValue(writer, new AjaxReturn(501, "用户名或密码不正确", null));
		}
	}
}
