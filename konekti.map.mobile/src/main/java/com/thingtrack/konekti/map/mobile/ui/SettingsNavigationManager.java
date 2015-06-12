package com.thingtrack.konekti.map.mobile.ui;

import com.vaadin.addon.touchkit.ui.NavigationManager;

@SuppressWarnings("serial")
public class SettingsNavigationManager extends NavigationManager {
	/**
     * Creates a classification hierarchy displaying the birds classification
     * group in the top level view
     */
    public SettingsNavigationManager() {
        navigateTo(new SettingsView());
        
    }
}
