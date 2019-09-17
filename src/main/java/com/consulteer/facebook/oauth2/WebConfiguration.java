package com.consulteer.facebook.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Milos Stambolija on 17.9.2019.
 **/
@Configuration
@EnableOauth2Sso
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .anyRequest().authenticated();
    }
}
