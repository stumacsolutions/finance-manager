package com.stumac.financemanager.web.config;

import net.sourceforge.html5val.Html5ValDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ThymeleafConfig {

    @Bean
    Html5ValDialect html5ValDialect() {
        return new Html5ValDialect();
    }
}
