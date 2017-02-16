package com.stumac.financemanager.toggles;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

import static org.togglz.core.context.FeatureContext.getFeatureManager;

public enum Features implements Feature {

    @Label("Dividends")
    DIVIDENDS,

    @Label("VAT")
    VAT;

    public boolean isActive() {
        return getFeatureManager().isActive(this);
    }
}
