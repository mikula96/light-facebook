package com.consulteer.facebook.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Milos Stambolija on 3.9.2019.
 **/
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

    private static final List<String> clients = Arrays.asList("google", "facebook");

    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private OAuth2Authentication oAuth2Authentication;
    @Autowired
    private OAuth2AccessToken oAuth2AccessToken;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.getTokenStore().readAccessToken(tokenStore.getAccessToken(oAuth2Authentication).toString());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated();
    }

}
