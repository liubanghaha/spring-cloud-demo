package com.wlwk.framework.utils;

import java.util.Arrays;
import java.util.Set;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
	/**
	 * 获取登录用户编号
	 * 
	 * @return
	 */
	public static String getAuthentication() {
		return StringUtils.isNotBlank(SecurityContextHolder.getContext().getAuthentication().getName()) ? SecurityContextHolder.getContext().getAuthentication().getName() : "0";
	}

	/**
	 * 用户是否登录
	 * 
	 * @return
	 */
	public static Boolean isAuthenticated() {
		return !(getAuthentication().equals("anonymousUser") || getAuthentication().equals("0"));
	}

	/**
	 * 是否具备权限
	 * 
	 * @param authority
	 * @return
	 */
	public static Boolean hasAllAuthority(String... authoritys) {
		if (authoritys != null && authoritys.length > 0) {
			Set<String> set = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
			return set.containsAll(Arrays.asList(authoritys));
		}
		return true;
	}

	/**
	 * 具备任一项授权
	 * 
	 * @param authoritys
	 * @return
	 */
	public static Boolean hasAnyAuthority(String... authoritys) {
		if (authoritys != null && authoritys.length > 0) {
			Set<String> set = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
			Boolean flag = false;
			for (String authority : authoritys) {
				if (set.contains(authority)) {
					flag = true;
					break;
				}
			}
			return flag;
		} else {
			return true;
		}
	}

	/**
	 * 不具备授权
	 * 
	 * @param authoritys
	 * @return
	 */
	public static Boolean notAuthority(String... authoritys) {
		if (authoritys != null && authoritys.length > 0) {
			Set<String> set = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
			Boolean flag = true;
			for (String authority : authoritys) {
				if (set.contains(authority)) {
					flag = false;
					break;
				}
			}
			return flag;
		}
		return true;
	}
}
