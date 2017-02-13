package com.stumac.financemanager.security.config;

import com.stumac.financemanager.ApplicationConfig;
import com.stumac.financemanager.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static java.time.LocalDate.now;
import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Configuration
class ExtractorConfig {

    @Autowired
    ApplicationConfig config;

    @Bean
    AuthoritiesExtractor authoritiesExtractor() {
        return map -> {
            String username = extract("username", map);
            return config.getSecurity().getAdmins().contains(username) ?
                commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN,ROLE_ACTUATOR") :
                commaSeparatedStringToAuthorityList("ROLE_USER");
        };
    }

    @Bean
    PrincipalExtractor principalExtractor() {
        return map -> User.builder()
            .avatarUrl(extract("avatarUrl", map))
            .lastLogin(now())
            .name(extract("name", map))
            .username(extract("username", map))
            .build();
    }

    private String extract(String fieldName, Map<String, Object> fieldValues) {
        ApplicationConfig.Security security = config.getSecurity();
        ApplicationConfig.Info info = security.getInfo();
        Map<String, String> keys = info.getKeys();
        String key = keys.get(fieldName);
        return (String) fieldValues.get(key);
    }
}
