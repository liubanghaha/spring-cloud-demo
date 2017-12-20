package com.wlwk.framework.web.support.interceptor;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wlwk.framework.domain.AjaxReturn;
import com.wlwk.framework.utils.SecurityUtils;
import com.wlwk.framework.web.support.annotation.Secure;

/**
 * 权限验证
 */
public class SecureHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		super.preHandle(request, response, handler);
		if (handler instanceof HandlerMethod) {
			// 获取方法注解，根据注解的类型
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Secure secure = handlerMethod.getMethodAnnotation(Secure.class);
			if (secure != null) {
				if (SecurityUtils.isAuthenticated() && SecurityUtils.hasAllAuthority(secure.has()) && SecurityUtils.hasAnyAuthority(secure.any()) && SecurityUtils.notAuthority(secure.not())) {
					return true;
				}
				if (!SecurityUtils.isAuthenticated()) {
					// 清除登录错误限制
					try (Writer writer = response.getWriter();) {
						response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
						response.setStatus(HttpServletResponse.SC_OK);
						objectMapper.writeValue(writer, new AjaxReturn(401, null, null));
					}
				} else {
					// 清除登录错误限制
					try (Writer writer = response.getWriter();) {
						response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
						response.setStatus(HttpServletResponse.SC_OK);
						objectMapper.writeValue(writer, new AjaxReturn(402, null, null));
					}
				}
				return false;
			}
		}
		return true;
	}
}
