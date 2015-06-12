package com.thingtrack.konekti.map.mobile.ui;

import org.vaadin.addthis.AddThis;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.mobile.component.ButtonLink;

@SuppressWarnings("serial")
public class CardView extends NavigationView {
	private Card card;
	
	private Layout mainLayout = new CssLayout();
	
	public CardView(Card card) {
		this.card = card;
		
	}
	
    @Override
    public void attach() {
        super.attach();
        buildView();
    }

    private void buildView() {
    	setCaption("Tarjeta: " + card.getName());
    	
    	mainLayout = new CssLayout();
    	mainLayout.setWidth("100%");
    	mainLayout.setMargin(true);
        
    	// photo card
    	if (card.isSponsor() && card.getImage() != null && !card.getImage().isEmpty())
    		mainLayout.addComponent(buildCardLayout());    	
        
    	// web card
    	if (card.isSponsor() && card.getWeb() != null && !card.getWeb().isEmpty())
    		buildWebCardLayout();
    	        
    	// email card
    	if (card.isSponsor() && card.getEmail() != null && !card.getEmail().isEmpty())
    		buildEmailCardLayout();
    	
    	// phones card
    	if (card.isSponsor() && (card.getFirstPhone() != null && !card.getFirstPhone().isEmpty()) || (card.getSecondPhone() != null && !card.getSecondPhone().isEmpty()))   
    		buildPhonesCardLayout();
    	
    	// observations card
    	if (card.isSponsor() && card.getObservation() != null && !card.getObservation().isEmpty())
    		mainLayout.addComponent(buildObservationCardLayout());
    	
    	// social card
    	//if (card.isSponsor() && !KonektiMapApplication.getApp().getMode().equals("directory"))
    	//	mainLayout.addComponent(buildSocialCardLayout());
    	
    	//mainLayout.addComponent(buildGeoLocationMapExhibitorLayout());
    	
        setContent(mainLayout);
    }
    
    private Component buildCardLayout() {
    	VerticalComponentGroup photoCardComponentGroup = new VerticalComponentGroup();
    	
    	Resource image = new ThemeResource("cards/" + card.getImage());
    	
        if (image != null) {
        	CssLayout imageLayout = new CssLayout();
        	imageLayout.setMargin(true, false, true, false);
        	
        	Embedded embedded = new Embedded(null, image);
            embedded.setWidth("100%");
            imageLayout.addComponent(embedded);
                        
            photoCardComponentGroup.addComponent(imageLayout);
            
        }
    	
    	return photoCardComponentGroup;
    }
    
    private void buildWebCardLayout() {
    	Label webLabel = new Label("Web");
    	webLabel.setStyleName("v-label-grey-title");
		
		mainLayout.addComponent(webLabel);
		
        ButtonLink buttonWebLink = new ButtonLink("Visita nuestra Web", new ExternalResource(card.getWeb()), "100%", "'text-decoration:none' target='_blank'");
    	buttonWebLink.setStyleName("v-button-weblink");
    	
    	mainLayout.addComponent(buttonWebLink);  	
    }

    private void buildEmailCardLayout() {
    	Label emailLabel = new Label("Email");
    	emailLabel.setStyleName("v-label-grey-title");
		
		mainLayout.addComponent(emailLabel);
    	
    	ButtonLink buttonEmailLink = new ButtonLink("Enviar Correo", new ExternalResource("mailto:" +  card.getEmail()), "100%", "'text-decoration:none'");
    	buttonEmailLink.setStyleName("v-button-weblink");
    	
    	mainLayout.addComponent(buttonEmailLink);
    	
    }
    
    private void buildPhonesCardLayout() {
    	Label phoneLabel = new Label("Teléfonos");
		phoneLabel.setStyleName("v-label-grey-title");
		
		mainLayout.addComponent(phoneLabel);
		
		if (card.getFirstPhone() != null) {
	    	ButtonLink buttonNormalPhoneLink = new ButtonLink("Llamar Fijo", new ExternalResource("tel://" + card.getFirstPhone()), "100%", "'text-decoration:none'", "rgba(130, 250, 88, 0.59375)");
	    	buttonNormalPhoneLink.setStyleName("v-button-weblink");
	    	
	    	mainLayout.addComponent(buttonNormalPhoneLink);
		}
		
    	if (card.getSecondPhone() != null) {
    		ButtonLink buttonSecondPhoneLink = new ButtonLink("Llamar Móvil", new ExternalResource("tel://" + card.getSecondPhone()), "100%", "'text-decoration:none'", "rgba(129, 159, 247, 0.59375)");
        	buttonSecondPhoneLink.setStyleName("v-button-weblink");
        	
    		mainLayout.addComponent(buttonSecondPhoneLink);
    	}
    	
    }
    
    private Component buildObservationCardLayout() {
    	VerticalComponentGroup observationExhibitorComponentGroup = new VerticalComponentGroup();
    	observationExhibitorComponentGroup.setCaption("Observaciones");
    	
    	if (card.getObservation() != null) {    		
    		observationExhibitorComponentGroup.addComponent(new Label(card.getObservation(), Label.CONTENT_RAW));
    		
    	}
    	
    	return observationExhibitorComponentGroup;
    	
    }
    
    /*private Component buildGeoLocationMapExhibitorLayout() {
    	VerticalComponentGroup geoLocationExhibitorComponentGroup = new VerticalComponentGroup();
    	geoLocationExhibitorComponentGroup.setCaption("Posición");
    	
    	OpenLayersMap openLayersMap = new OpenLayersMap();
    	
        // no panning or zooming in this read only map
    	openLayersMap.setImmediate(true);
        openLayersMap.getControls().clear();
        openLayersMap.addLayer(new OpenStreetMapLayer());
        openLayersMap.setZoom(18);
        
        openLayersMap.setWidth("100%");
        openLayersMap.setHeight((getWindow().getHeight() / 2) + "px");   
        
        // get card marker geolocated
        
        VectorLayer markerLayer = new VectorLayer();
        markerLayer.setStyleMap(MapView.STYLEMAP_TARGET_MARKER);  
        markerLayer.setSelectionMode(SelectionMode.NONE);
        markerLayer.addVector(new PointVector(card.getLongitude(),  card.getLatitude()));        	
        openLayersMap.addLayer(markerLayer);
                
        openLayersMap.setCenter(card.getLongitude(),  card.getLatitude());
        
        CssLayout geoLocationLayout = new CssLayout();
    	geoLocationLayout.setMargin(true, false, true, false);
    	geoLocationLayout.addComponent(openLayersMap);
    	
        geoLocationExhibitorComponentGroup.addComponent(geoLocationLayout);
        
        return geoLocationExhibitorComponentGroup;
    }*/
    
    private Component buildSocialCardLayout() {
    	VerticalComponentGroup socialCardComponentGroup = new VerticalComponentGroup();
    	socialCardComponentGroup.setCaption("Social");
    	socialCardComponentGroup.addStyleName("social");
    	
    	AddThis addThis = new AddThis(card.getWeb(), card.getName());
    	addThis.addStyleName("addthis_toolbox addthis_32x32_style addthis_default_style");
    	addThis.addButton("facebook");
    	addThis.addButton("twitter");
    	
    	socialCardComponentGroup.addComponent(addThis);
    	
    	return socialCardComponentGroup;
    }
    
}
