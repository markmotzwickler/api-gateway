package com.ethanq.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/eureka/**")
                .permitAll()
                .antMatchers("/oauth-server/**")
                .permitAll()
                .antMatchers("/user-service/**")
                .permitAll()
                .antMatchers("/user-service/swagger-ui.html")
                .hasRole("ADMIN");

        http
                .headers()
                .frameOptions()
                .disable();
    }
}

