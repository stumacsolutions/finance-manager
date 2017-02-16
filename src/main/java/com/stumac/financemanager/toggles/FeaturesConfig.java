package com.stumac.financemanager.toggles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.spi.FeatureProvider;

import javax.sql.DataSource;

@Configuration
class FeaturesConfig {

    @Bean
    FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(Features.class);
    }

    @Bean
    StateRepository stateRepository(DataSource dataSource) {
        return new JDBCStateRepository(dataSource);
    }
}
