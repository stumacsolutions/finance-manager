package com.stumac.financemanager.security;

import com.stumac.financemanager.ApplicationConfig;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Configuration
@Profile("github")
class GitHubSecurityConfig {

    @Bean
    AuthoritiesExtractor authoritiesExtractor(ApplicationConfig config) {
        return map -> {
            String username = (String) map.get("login");
            return config.getSecurity().getAdmins().contains(username) ?
                commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN") :
                commaSeparatedStringToAuthorityList("ROLE_USER");
        };
    }

    @Bean
    PrincipalExtractor principalExtractor() {
        return map -> User.builder()
            .avatarUrl((String) map.get("avatar_url"))
            .name((String) map.get("name"))
            .username((String) map.get("login"))
            .build();
    }
}
