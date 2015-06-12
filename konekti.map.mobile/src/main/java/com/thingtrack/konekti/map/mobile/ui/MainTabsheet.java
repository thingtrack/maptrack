package com.thingtrack.konekti.map.mobile.ui;

import com.thingtrack.konekti.map.mobile.KonektiMapApplication;
import com.vaadin.addon.touchkit.ui.TabBarView;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.TabSheet.Tab;

/**
 * This is the main view for Fair Tracker application. It displays a tabbar via
 * one can choose one of the sub views.
 */
@SuppressWarnings("serial")
public class MainTabsheet extends TabBarView {
    private CardSearchNavigationManager cardSearchNavigationManager;
    private CardDirectoryNavigationManager cardDirectoryNavigationManager;
    private CouponNavigationManager couponNavigationManager;
    private SettingsNavigationManager settingsNavigationManager;
    private CardView cardView;
    private MapView mapView;
    
    public MainTabsheet() {    	
        /*
         * Populate main views
         */
        KonektiMapApplication konektiMapApplication = (KonektiMapApplication) KonektiMapApplication.get();
        Tab tab = null;
        
        if (konektiMapApplication.getMode() != KonektiMapApplication.MODE.DIRECTOTY && konektiMapApplication.getCardParameter().isCouponing()) {
        	couponNavigationManager = new CouponNavigationManager(konektiMapApplication.getCardParameter());
	        tab = addTab(couponNavigationManager);
	        tab.setIcon(new ThemeResource("linegraphics/mail.png"));
	        tab.setCaption("Cupónes");
        }
        
    	if (konektiMapApplication.getMode() == KonektiMapApplication.MODE.DIRECTOTY) {
	    	cardSearchNavigationManager = new CardSearchNavigationManager();
	        tab = addTab(cardSearchNavigationManager);
	        tab.setIcon(new ThemeResource("linegraphics/search.png"));
	        tab.setCaption("Buscador");
    	}
        
    	if (konektiMapApplication.getMode() == KonektiMapApplication.MODE.DIRECTOTY) {
	        cardDirectoryNavigationManager = new CardDirectoryNavigationManager();
	        tab = addTab(cardDirectoryNavigationManager);
	        tab.setIcon(new ThemeResource("linegraphics/folder.png"));
	        tab.setCaption("Directorio");
    	}
    	              
        if (konektiMapApplication.getMode() != KonektiMapApplication.MODE.DIRECTOTY) {
	        cardView = new CardView(konektiMapApplication.getCardParameter());
	        tab = addTab(cardView);
	        tab.setIcon(new ThemeResource("linegraphics/folder.png"));
	        tab.setCaption("Tarjeta");
        }
        
        if (konektiMapApplication.getMode() != KonektiMapApplication.MODE.DIRECTOTY) {
	        mapView = new MapView(konektiMapApplication.getCardParameter());
	        tab = addTab(mapView);
	        tab.setIcon(new ThemeResource("linegraphics/world.png"));
	        tab.setCaption("Mapa");
        }
        else {
	        mapView = new MapView();
	        tab = addTab(mapView);
	        tab.setIcon(new ThemeResource("linegraphics/world.png"));
	        tab.setCaption("Mapa"); 
        }
        
        settingsNavigationManager = new SettingsNavigationManager();
        tab = addTab(settingsNavigationManager);
        tab.setIcon(new ThemeResource("linegraphics/tools.png"));
        tab.setCaption("Ajustes"); 
        
        /*
         * Make settings view as the default. This would not be best option for
         * a real application, but it also serves as our demos welcome page.
         */
        setSelectedTab(mapView);

    }

}
