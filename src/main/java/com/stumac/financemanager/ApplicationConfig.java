package com.stumac.financemanager;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties
public class ApplicationConfig {

    public Security security;

    @Getter
    @Setter
    public static class Security {
        private List<String> admins = new ArrayList<>();
    }
}
