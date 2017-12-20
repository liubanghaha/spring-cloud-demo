package com.wlwk.framework.web.support.security;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wlwk.framework.domain.AjaxReturn;

public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
	private ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		try (Writer writer = response.getWriter();) {
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			objectMapper.writeValue(writer, new AjaxReturn(200,null, null));
		}
	}
}
