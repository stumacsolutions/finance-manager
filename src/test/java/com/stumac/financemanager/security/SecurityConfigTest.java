package com.stumac.financemanager.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class SecurityConfigTest
{
    @InjectMocks
    private SecurityConfig config;

    @Test
    public void shouldConfigureAuthoritiesExtractorBean()
    {
        assertNotNull(config.authoritiesExtractor());
    }

    @Test
    public void shouldConfigurePrincipleExtractorBean()
    {
        assertNotNull(config.principalExtractor());
    }
}
