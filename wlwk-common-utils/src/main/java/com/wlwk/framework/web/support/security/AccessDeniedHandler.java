package com.wlwk.framework.web.support.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wlwk.framework.domain.AjaxReturn;

/**
 * 无权限处理方式
 */
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		try (PrintWriter writer = response.getWriter();) {
			response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			objectMapper.writeValue(writer, new AjaxReturn(401, "未登录或登录超时", null));
		}
	}

}
