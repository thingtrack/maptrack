/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.thingtrack.konekti.map.workbench;

import java.io.Serializable;

import org.dellroad.stuff.vaadin.ContextApplication;
import org.dellroad.stuff.vaadin.SpringContextApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.domain.User;
//import com.thingtrack.konekti.map.domain.extras.Extra;
import com.thingtrack.konekti.map.service.api.CampaignService;
import com.thingtrack.konekti.map.service.api.CampaignStatusService;
import com.thingtrack.konekti.map.service.api.CampaignTypeService;
import com.thingtrack.konekti.map.service.api.CouponService;
import com.thingtrack.konekti.map.service.api.MapService;
import com.thingtrack.konekti.map.service.api.MarkerService;
import com.thingtrack.konekti.map.service.api.MarkerTypeService;
import com.thingtrack.konekti.map.service.api.CardService;
import com.thingtrack.konekti.map.service.api.CardTypeService;
import com.thingtrack.konekti.map.service.api.UserService;
import com.thingtrack.konekti.map.workbench.ui.MapDesignerView;
import com.thingtrack.konekti.map.workbench.ui.ToolBar;

import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MainApplication extends SpringContextApplication implements Serializable {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MapService mapService;
	
	@Autowired
	private CampaignService campaignService;
	
	@Autowired
	private CampaignTypeService campaignTypeService;
	
	@Autowired
	private CampaignStatusService campaignStatusService;
	
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private CampaignTypeService couponTypeService;
		
	@Autowired
	private CardService cardService;
	
	@Autowired
	private CardTypeService cardTypeService;
	
	@Autowired
	private MarkerService markerService;
	
	@Autowired
	private MarkerTypeService markerTypeService;
	
	private Map activeMap = null;
	private User activeUser = null;
	
	private Window window;
	
	private VerticalLayout mainLayout;
	
	private HorizontalLayout toolbarLayout;
	private ToolBar toolBar;
	
	private VerticalLayout mapDesignerLayout;
	private MapDesignerView mapDesigner;
	
	private final static int TEST_USER_ID = 1;
		
	private SpringContextApplication app; // For distinguishing between apps
	private static ThreadLocal<MainApplication> instance = new ThreadLocal<MainApplication>();
	
	@Override
	protected void initSpringApplication(ConfigurableWebApplicationContext context) {
		setTheme("konektimap");

	    window = new Window("Konekti Map Workbench");
	    setMainWindow(window);
	    
		buildMainLayout();
		
		try {
			activeUser = userService.get(TEST_USER_ID);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	private void buildMainLayout() {
		mainLayout = (VerticalLayout)window.getContent();
	    mainLayout.setSizeFull();
	    mainLayout.setMargin(true);	    
	    mainLayout.setStyleName("applicationBackground");
	    
	    // set Konekti Map Toolbar
		toolbarLayout = new HorizontalLayout();
		toolbarLayout.setWidth("100%");
		toolbarLayout.setHeight("50px");
		toolbarLayout.setStyleName("toolbar");
		
		toolBar = new ToolBar();
		toolBar.setSizeFull();		
		toolbarLayout.addComponent(toolBar);
		
		mainLayout.addComponent(toolbarLayout);
		mainLayout.setExpandRatio(toolbarLayout, 0.0f);
		
		// set a Konekti Map Separator
		VerticalLayout separator = new VerticalLayout();
		separator.setWidth("100%");
		separator.setHeight("10px");
		
		mainLayout.addComponent(separator);
		mainLayout.setExpandRatio(separator, 0.0f);
		
		// set Konekti Map Main Layout
		mapDesignerLayout = new VerticalLayout();
		mapDesignerLayout.setSizeFull();
		mapDesignerLayout.setStyleName("mapdesigner");
		
		toolBar.setKonektiMapMainLayout(mapDesignerLayout);
		
		mapDesigner = new MapDesignerView();
		mapDesigner.setSizeFull();

		toolBar.addListenerMapChange((ValueChangeListener) mapDesigner);
		
		// initialize with Map Designer
		mapDesignerLayout.addComponent(mapDesigner);
		
		mainLayout.addComponent(mapDesignerLayout);
		mainLayout.setExpandRatio(mapDesignerLayout, 1.0f);
			
	}
 
    /**
     * Get the {@link SpringContextApplication} instance associated with the current thread or throw an exception if there is none.
     *
     * <p>
     * Works just like {@link ContextApplication#get()} but returns this narrower type.
     * </p>
     *
     * @return the {@link SpringContextApplication} associated with the current thread
     * @throws IllegalStateException if the current thread is not servicing a Vaadin web request
     *  or the current Vaadin {@link com.vaadin.Application} is not a {@link SpringContextApplication}
     */
    public static MainApplication get() {
        return ContextApplication.get(MainApplication.class);
        
    }
    
    public void setMap(Map map) {
    	get().activeMap = map;
    	        
    }
    
    public Map getMap() {
    	return get().activeMap;
        
    }
    
    public User getMapUser() {
    	return get().activeUser;
        
    }
    
	public MapService getMapService() {
        return get().mapService;
        
    }

}
