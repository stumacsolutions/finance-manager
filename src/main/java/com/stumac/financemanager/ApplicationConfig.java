package com.stumac.financemanager;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties
public class ApplicationConfig {

    public Security security;

    @Getter
    @Setter
    public static class Info {
        private Map<String, String> keys = new HashMap<>();
    }

    @Getter
    @Setter
    public static class Security {
        private List<String> admins = new ArrayList<>();
        private Info info;
    }
}
