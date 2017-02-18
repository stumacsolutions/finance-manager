package com.stumac.financemanager.security;

import com.stumac.financemanager.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import java.util.Map;

import static java.time.LocalDate.now;
import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Configuration
@EnableOAuth2Sso
@EnableJdbcHttpSession
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter
{

    private final ApplicationConfig config;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
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

    @Bean
    AuthoritiesExtractor authoritiesExtractor()
    {
        return map ->
        {
            String username = extract("username", map);
            return config.getSecurity().getAdmins().contains(username) ?
                commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN,ROLE_ACTUATOR") :
                commaSeparatedStringToAuthorityList("ROLE_USER");
        };
    }

    @Bean
    PrincipalExtractor principalExtractor()
    {
        return map -> User.builder()
            .avatarUrl(extract("avatarUrl", map))
            .lastLogin(now())
            .name(extract("name", map))
            .username(extract("username", map))
            .build();
    }

    private String extract(String fieldName, Map<String, Object> fieldValues)
    {
        ApplicationConfig.Security security = config.getSecurity();
        ApplicationConfig.Info info = security.getInfo();
        Map<String, String> keys = info.getKeys();
        String key = keys.get(fieldName);
        return (String) fieldValues.get(key);
    }
}
