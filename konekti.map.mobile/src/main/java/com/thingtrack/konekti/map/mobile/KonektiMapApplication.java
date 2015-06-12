package com.thingtrack.konekti.map.mobile;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.thingtrack.konekti.map.domain.User;
import com.thingtrack.konekti.map.domain.Card;

import com.thingtrack.konekti.map.service.api.CampaignService;
import com.thingtrack.konekti.map.service.api.CampaignStatusService;
import com.thingtrack.konekti.map.service.api.CampaignTypeService;
import com.thingtrack.konekti.map.service.api.CouponService;
import com.thingtrack.konekti.map.service.api.CouponTypeService;
import com.thingtrack.konekti.map.service.api.MapService;
import com.thingtrack.konekti.map.service.api.MarkerService;
import com.thingtrack.konekti.map.service.api.MarkerTypeService;
import com.thingtrack.konekti.map.service.api.CardService;
import com.thingtrack.konekti.map.service.api.CardTypeService;
import com.thingtrack.konekti.map.service.api.UserService;

import com.thingtrack.com.vaadin.addons.springstuff.mobile.TouchKitSpringContextApplication;
import com.thingtrack.konekti.map.mobile.service.CardLayerManager;
import com.thingtrack.konekti.map.mobile.ui.MainTabsheet;

import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.terminal.ParameterHandler;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class KonektiMapApplication extends TouchKitSpringContextApplication implements ParameterHandler {
	@Autowired
	private UserService userService;

	@Autowired
	private MapService mapService;

	@Autowired
	private CardService cardService;

	@Autowired
	private CardTypeService cardTypeService;

	@Autowired
	private MarkerService markerService;
    
	@Autowired
	private MarkerTypeService markerTypeService;

	@Autowired
	private CampaignService campaignService;

	@Autowired
	private CampaignTypeService campaignTypeService;

	@Autowired
	private CampaignStatusService campaignStatusService;

	@Autowired
	private CouponService couponService;

	@Autowired
	private CouponTypeService couponTypeService;

    private KonektiMapWindow mainWindow;
    
    //private CardLayerManager cardLayerManager;
    private CardLayerManager cardLayerManager;
    
    static CustomizedSystemMessages customizedSystemMessages = new CustomizedSystemMessages();
    static { customizedSystemMessages.setSessionExpiredNotificationEnabled(false); }    

    /*
     * Default Konekti Map Card icon and splash App
     */
    private static final String DEFAULT_ICON = "thingtrack_icon.png";
    private static final String DEFAULT_SPLASH = "thingtrack_startup.png";
    
    /*
     * Konekti Map Card URI parameter:
     * 
     * Konekti Map mode Type:
     * Type 1: Directory Mode: show all marker cards
	 * Type 2: Schedule Mode: return the first card schedule for today
     * Type 3: Card Mode: return the card parameter
     */
    private User userParameter = null;
    private com.thingtrack.konekti.map.domain.Map mapParameter = null;
    private Card cardParameter = null;
    
    private int mode = MODE.DIRECTOTY;
    
    public static class MODE {
    	public final static int DIRECTOTY = 1;
    	public final static int SCHEDULE = 2;
    	public final static int CARD = 3;
    }
    /*
     * Default the location to Thingtrack HQ
     */
    private double currentLatitude = 43.5373432;
    private double currentLongitude = -5.6369219;
    
    /**
     * Make application reload itself when the session has expired. Our demo app
     * gains nothing for showing session expired message.
     * 
     * @see TouchKitApplication#getSystemMessages()
     */
    public static SystemMessages getSystemMessages() {
        return customizedSystemMessages;
    }
    
    /**
     * TouchKitApplication already provides access to currently active
     * application instance with "thread local pattern". The approach is handy
     * as we commonly store e.g. settings in the application instance (location
     * information in this example). Otherwise we'd need to pass references to
     * UI components in constructors or provided another mechanism to access
     * active class (e.g. CDI). This is a better typed version of the one that
     * TouchKitApplication provides for convenience.
     * 
     * @return the currently active Vornitologist application.
     */
    public static KonektiMapApplication getApp() {
        return (KonektiMapApplication) get();
    }
    
    /**
     * Konekti Map Business Services.
     */
    public UserService getUserService() {
        return getApp().userService;
        
    }
    
    public MapService getMapService() {
        return getApp().mapService;
        
    }
    
    public CardService getCardService() {
        return getApp().cardService;
        
    }
    
    public CardTypeService getCardTypeService() {
        return getApp().cardTypeService;
        
    }
    
    public MarkerService getMarkerService() {
        return getApp().markerService;
        
    }
    
    public MarkerTypeService getMarkerTypeService() {
        return getApp().markerTypeService;
        
    }
    
    public CampaignService getCampaignService() {
        return getApp().campaignService;
        
    }
    
    public CampaignTypeService getCampaignTypeService() {
        return getApp().campaignTypeService;
        
    }
    
    public CampaignStatusService getCampaignStatusService() {
        return getApp().campaignStatusService;
        
    }
    
    public CouponService getCouponService() {
        return getApp().couponService;
        
    }
    
    public CouponTypeService getCouponTypeService() {
        return getApp().couponTypeService;
        
    }
    /**
     * The location information is stored in Application instance to be
     * available for all components. It is detected by the map view during
     * application init, but also used by other maps in the application.
     * 
     * @return the current latitude as degrees
     */
    public double getCurrentLongitude() {
        return currentLongitude;
    }

    public void setCurrentLongitude(double currentLongitude) {
        this.currentLongitude = currentLongitude;
    }
    
    public double getCurrentLatitude() {
        return currentLatitude;
    }

    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }
        
    /**
     * Konekti Map URI Parameter and mode type
     */
    public User getUserParameter() {
    	return userParameter;
    	
    }
    
    public com.thingtrack.konekti.map.domain.Map getMapParameter() {
    	return mapParameter;
    	
    }
    
    public Card getCardParameter() {
    	return cardParameter;
    	
    }

    public Integer getMode() {
    	return mode;
    	
    }
       
    public CardLayerManager getCardLayerManager() {
    	return cardLayerManager;
    	
    }
    
    @Override
	protected void initSpringApplication(ConfigurableWebApplicationContext context) {
    	// configure main window
        mainWindow = new KonektiMapWindow();
        setMainWindow(mainWindow);

        // set URI parameter handler
        mainWindow.addParameterHandler(this);
        
        // set konekti map theme
        setTheme("konektimap");
    }    

	@Override
	public void onBrowserDetailsReady(ConfigurableWebApplicationContext context) {
		// TODO Auto-generated method stub

	}

	// Get the konekti.map Mode Runtime
	@Override
	public void handleParameters(Map<String, String[]> parameters) {
		if (parameters.containsKey("user")) {
			String userId = ((String[])parameters.get("user"))[0];

			try {
				userParameter = userService.get(Integer.parseInt(userId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}

		if (parameters.containsKey("map")) {
			String mapId= ((String[])parameters.get("map"))[0];

			try {
				mapParameter = mapService.get(Integer.parseInt(mapId));

				// create Card Manager from Map
				cardLayerManager = new CardLayerManager(mapParameter);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
		}

		// Type 1: Directory Mode: show all marker cards
		// Type 2: Schedule Mode: return the first card schedule for today
		// Type 3: Card Mode: return the card parameter
		//
		// get mode and the card if card mode is selected
		if (parameters.containsKey("card")) {
				String cardId = ((String[])parameters.get("card"))[0];

				try {
					if (cardId.equals("directory")) {										
						mode = MODE.DIRECTOTY;
						cardParameter = null;	
					}
					else if (cardId.equals("schedule")) {
						mode = MODE.SCHEDULE;
						cardParameter = cardService.getBySchedule(new Date());
					}
					else {
						mode = MODE.CARD;
						cardParameter = cardService.get(Integer.parseInt(cardId));
					}
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}

				// set custom card icon and startup image to mode selected
				if (mapParameter != null && mapParameter.getIconImage() != null)
					mainWindow.addApplicationIcon(KonektiMapApplication.get().getURL() + "VAADIN/themes/konektimap/cards/" + mapParameter.getIconImage());
				else
					mainWindow.addApplicationIcon(KonektiMapApplication.get().getURL() + "VAADIN/themes/konektimap/cards/" + DEFAULT_ICON);

				if (mapParameter != null && mapParameter.getSplashImage() != null)
					mainWindow.setStartupImage(KonektiMapApplication.get().getURL() + "VAADIN/themes/konektimap/cards/" + mapParameter.getSplashImage());
				else
					mainWindow.setStartupImage(KonektiMapApplication.get().getURL() + "VAADIN/themes/konektimap/cards/" + DEFAULT_SPLASH);				

		        mainWindow.setContent(new MainTabsheet());
		}

	}

}