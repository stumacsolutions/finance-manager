package com.stumac.financemanager.features;

import org.junit.Rule;
import org.junit.Test;
import org.togglz.junit.TogglzRule;

import static org.junit.Assert.assertFalse;

public class FeaturesTest
{
    @Rule
    public TogglzRule togglzRule = TogglzRule.builder(Features.class).build();

    @Test
    public void dividendsFeatureShouldBeDisabledByDefault()
    {
        assertFalse(Features.DIVIDENDS.isActive());
    }

    @Test
    public void mileageFeatureShouldBeDisabledByDefault()
    {
        assertFalse(Features.MILEAGE.isActive());
    }

    @Test
    public void vatFeatureShouldBeDisabledByDefault()
    {
        assertFalse(Features.VAT.isActive());
    }
}
