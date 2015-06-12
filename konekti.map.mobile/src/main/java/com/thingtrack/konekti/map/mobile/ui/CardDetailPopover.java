package com.thingtrack.konekti.map.mobile.ui;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import com.thingtrack.konekti.map.domain.Marker;
import com.thingtrack.konekti.map.mobile.component.ButtonLink;

@SuppressWarnings("serial")
public class CardDetailPopover extends Popover {
	 public CardDetailPopover(final Marker marker) {
		// set popover configuration
	    setClosable(true);
	    setModal(true);

	    setWidth("50%");
	    setHeight("80%");
	    center();
	    
	    // set main layout
        CssLayout mainLayout = new CssLayout();
        mainLayout.setSizeFull();
        mainLayout.setMargin(true);
        mainLayout.addStyleName("details");

        // set exhibitor image
        Resource image = new ThemeResource("cards/" + marker.getImage());
    	
        if (image != null) {
        	CssLayout cssImageExhibitor = new CssLayout();
        	cssImageExhibitor.setMargin(true, false, true, false);
        	
        	Embedded embedded = new Embedded(null, image);
            embedded.setWidth("100%");
            cssImageExhibitor.addComponent(embedded);
            
            mainLayout.addComponent(cssImageExhibitor);
        }
        
    	ButtonLink buttonWebLink = new ButtonLink("Visitar nuestra Web", new ExternalResource(marker.getWeb()), "100px");
    	buttonWebLink.setWidth("100%");
    	
    	mainLayout.addComponent(buttonWebLink);
    	         
        // set exhibitor observations
        Label label = new Label();
        label.setCaption("Observaciones: ");
        label.setValue(marker.getDescription());
        mainLayout.addComponent(new Label(marker.getDescription(), Label.CONTENT_RAW));
                
        // set popover close button
        Button close = new Button(null, new ClickListener() {
            public void buttonClick(ClickEvent event) {
                event.getButton().getWindow().getParent().removeWindow(event.getButton().getWindow());
            }
        });
        
        close.setIcon(new ThemeResource("../runo/icons/64/cancel.png"));

        NavigationView navigationView = new NavigationView(mainLayout);
        navigationView.setCaption(marker.getCaption());
        navigationView.setRightComponent(close);
        
        setContent(navigationView);
	 }
}
