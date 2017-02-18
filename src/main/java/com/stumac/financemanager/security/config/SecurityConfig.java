package com.stumac.financemanager.security.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableOAuth2Sso
@EnableJdbcHttpSession
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/", "/login**", "/css/**", "/img/**", "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().ignoringAntMatchers("/admin/h2-console/*")
            .and()
            .logout().logoutSuccessUrl("/").permitAll()
            .and()
            .headers().frameOptions().sameOrigin();
    }
}
