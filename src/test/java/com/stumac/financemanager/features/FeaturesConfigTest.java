package com.stumac.financemanager.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FeaturesConfigTest
{
    @Mock
    private Connection mockConnection;

    @Mock
    private DataSource mockDataSource;

    @Mock
    private Statement mockStatement;

    @InjectMocks
    private FeaturesConfig config;

    @Test
    public void shouldConfigureFeatureProviderBean()
    {
        assertNotNull(config.featureProvider());
    }

    @Test
    public void shouldConfigureStateRepositoryBean() throws SQLException
    {
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        assertNotNull(config.stateRepository(mockDataSource));
    }
}
