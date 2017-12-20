package com.wlwk.oauth2.web.support;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.wlwk.framework.utils.CollectionUtils;
import com.wlwk.framework.utils.StringUtils;
import com.wlwk.oauth2.domain.UserAccount;
import com.wlwk.oauth2.service.LoginService;


@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	private @Autowired LoginService loginService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserAccount userAccount = null;
			if (StringUtils.isNotBlank(username)) {
				userAccount = loginService.getUserInfoByName(username);
			}

			if (userAccount != null) {
				Set<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("wlwk:authority"));
				List<String> auths = loginService.listAutoByUser(userAccount.getPkId());
				if (CollectionUtils.isNotEmpty(auths)) {
					for (String auth : auths) {
						authorities.add(new SimpleGrantedAuthority(auth));
					}
				}
				return new User(String.valueOf(userAccount.getPkId()), userAccount.getLoginPwd(), authorities);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
