package com.thingtrack.konekti.map.mobile;

//import com.thingtrack.konekti.map.db.KonektiMapDB;
import com.vaadin.addon.touchkit.ui.TouchKitWindow;

@SuppressWarnings("serial")
public class KonektiMapWindow extends TouchKitWindow {

	public KonektiMapWindow() {		
        //setCaption(KonektiMapDB.KONEKTI_MAP_CAPTION);
        
        /*
         * These configurations modify how the app behaves as "ios webapp".
         */
        setWebAppCapable(true);
        setPersistentSessionCookie(true);
	}
}
