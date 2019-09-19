/*
package com.consulteer.facebook.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

*/
/**
 * Created by Milos Stambolija on 18.9.2019.
 **//*

@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/posts/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
*/
