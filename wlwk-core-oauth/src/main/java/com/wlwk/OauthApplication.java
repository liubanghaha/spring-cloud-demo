package com.wlwk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.vote.ScopeVoter;

@SpringBootApplication
@EnableEurekaClient
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }

    @Bean
    public OAuth2RequestFactory oAuth2RequestFactory(ClientDetailsService clientDetailsService) {
        return new DefaultOAuth2RequestFactory(clientDetailsService);
    }

    @Bean
    public TokenStoreUserApprovalHandler oauthUserApprovalHandler(TokenStore tokenStore, ClientDetailsService clientDetailsService, OAuth2RequestFactory oAuth2RequestFactory) {
        TokenStoreUserApprovalHandler userApprovalHandler = new TokenStoreUserApprovalHandler();
        userApprovalHandler.setTokenStore(tokenStore);
        userApprovalHandler.setClientDetailsService(clientDetailsService);
        userApprovalHandler.setRequestFactory(oAuth2RequestFactory);
        return userApprovalHandler;
    }

    @Bean
    public OAuth2AuthenticationEntryPoint authenticationEntryPoint() {
        return new OAuth2AuthenticationEntryPoint();
    }

    @Bean
    public ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter(ClientDetailsService clientDetailsService, @Qualifier("tokenServices") DefaultTokenServices tokenServices) {
        ClientCredentialsTokenEndpointFilter filter = new ClientCredentialsTokenEndpointFilter();
        filter.setAllowOnlyPost(true);
        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
        authenticationManager.setClientDetailsService(clientDetailsService);
        authenticationManager.setTokenServices(tokenServices);
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }

    @Primary
    @Bean("tokenServices")
    public DefaultTokenServices tokenServices(ClientDetailsService clientDetailsService, TokenStore tokenStore) {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setSupportRefreshToken(true);
        return tokenServices;
    }

    /**
     * 客户端配置
     * 
     * @return
     * @throws Exception
     */
    @Bean
    public ClientDetailsService clientDetailsService() throws Exception {
        return new InMemoryClientDetailsServiceBuilder()//
                .withClient("4bf56b730a735348898cb61e9d6a9dc1").secret("7df185825160b35ca33df14c716bcfc8").authorizedGrantTypes("authorization_code", "refresh_token").scopes("openid").authorities("ROLE_TRUSTED_CLIENT").autoApprove(true).accessTokenValiditySeconds(604800).refreshTokenValiditySeconds(604800)//
                .and().build();
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    public InMemoryAuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

    @Bean
    public ClientDetailsUserDetailsService oauth2ClientDetailsUserService(ClientDetailsService clientDetailsService) {
        return new ClientDetailsUserDetailsService(clientDetailsService);
    }

    @Bean
    public UnanimousBased oauth2AccessDecisionManager() {
        return new UnanimousBased(Arrays.asList(new ScopeVoter(), new RoleVoter(), new AuthenticatedVoter()));
    }

    @Bean
    public OAuth2AccessDeniedHandler oauth2AccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }
}
