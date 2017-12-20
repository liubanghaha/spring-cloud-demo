package com.wlwk.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.wlwk.oauth2.web.support.Md5PasswordEncoder;
import com.wlwk.oauth2.web.support.UserDetailsService;

@Order(-20)
@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	private @Autowired UserDetailsService userDetailsService;
	private @Autowired Md5PasswordEncoder passwordEncoder;
	private @Autowired OAuth2AuthenticationEntryPoint authenticationEntryPoint;
	private @Autowired ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")//
				.and().authorizeRequests().anyRequest().authenticated()//
				.and().formLogin().loginPage("/login").permitAll()//
				.and().logout().logoutUrl("/logout").clearAuthentication(true)//
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)//
				.and().rememberMe().alwaysRemember(false).key("remember")//
				.and().headers().frameOptions().disable()//
				.and().cors().disable()//
				.httpBasic().authenticationEntryPoint(authenticationEntryPoint)//
				.and().addFilterBefore(clientCredentialsTokenEndpointFilter, BasicAuthenticationFilter.class)//
				.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("/login", "POST"));
	}

	@Override
	@Bean(name = "authenticationManager")
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/public/**");
		web.expressionHandler(new OAuth2WebSecurityExpressionHandler());
	}
}
