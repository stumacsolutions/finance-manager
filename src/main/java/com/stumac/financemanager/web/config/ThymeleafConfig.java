package com.stumac.financemanager.web.config;

import net.sourceforge.html5val.Html5ValDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
class ThymeleafConfig
{
    @Bean
    Html5ValDialect html5ValDialect()
    {
        return new Html5ValDialect();
    }

    @Bean
    Java8TimeDialect java8TimeDialect()
    {
        return new Java8TimeDialect();
    }
}
