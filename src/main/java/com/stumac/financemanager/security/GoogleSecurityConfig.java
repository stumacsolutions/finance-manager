package com.stumac.financemanager.security;

import com.stumac.financemanager.ApplicationConfig;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Configuration
@Profile("google")
class GoogleSecurityConfig {

    @Bean
    AuthoritiesExtractor authoritiesExtractor(ApplicationConfig config) {
        return map -> {
            String username = (String) map.get("email");
            return config.getSecurity().getAdmins().contains(username) ?
                commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN") :
                commaSeparatedStringToAuthorityList("ROLE_USER");
        };
    }

    @Bean
    PrincipalExtractor principalExtractor() {
        return map -> User.builder()
            .avatarUrl((String) map.get("picture"))
            .name((String) map.get("given_name"))
            .username((String) map.get("email"))
            .build();
    }
}
