package com.thingtrack.konekti.map.mobile.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.vaadin.vol.PointVector;
import org.vaadin.vol.Style;
import org.vaadin.vol.VectorLayer;

import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.Marker;
import com.thingtrack.konekti.map.mobile.KonektiMapApplication;

import com.vaadin.ui.Component;

public class CardLayerManager {
	private Map map;
	private java.util.Map<Card, VectorLayer> mapLayer = new HashMap<Card, VectorLayer>();
			
	public static final int DEFAULT_ICON_HEIGHT = 50;
	public static final int DEFAULT_ICON_WIDTH = 50;
	
	public CardLayerManager(Map map) {
		this.map = map;
		
		// markerLayer for each card
		for(Card card : map.getCards()) {
			VectorLayer cardLayer = new VectorLayer();
			cardLayer.setDisplayName(card.getName());
						
			for(Marker marker : card.getMarkers()) {
				if (marker.isGeoLocated()) {
			    	PointVector pointVector = new PointVector(marker.getLongitude(), marker.getLatitude());
			    	
			    	Style style = new Style();
			        style.setExternalGraphic(KonektiMapApplication.getApp().getURL() + "VAADIN/themes/konektimap/markers/" + marker.getMarkerType().getIcon());
			        style.setGraphicHeight(DEFAULT_ICON_HEIGHT);
			        style.setGraphicWidth(DEFAULT_ICON_WIDTH);
			        style.setFillOpacity(1);
			        
			    	pointVector.setCustomStyle(style);
			    	pointVector.setData(marker);
			    	
					cardLayer.addVector(pointVector);
				}
				
			}
	
			mapLayer.put(card, cardLayer);
			
		}
		
	}
	
	public Map getMap() {
		return this.map;
		
	}
			
	@SuppressWarnings({ "rawtypes" })
	public VectorLayer getMapLayer() {
		VectorLayer vectorLayer = new VectorLayer();
		
		Iterator<Entry<Card, VectorLayer>> it = mapLayer.entrySet().iterator();

		while (it.hasNext()) {
			java.util.Map.Entry e = (java.util.Map.Entry)it.next();
			VectorLayer vl =  (VectorLayer)e.getValue();
			
			Iterator<Component> itm = vl.getComponentIterator();
			
			while (itm.hasNext()) {
				PointVector comp = (PointVector)itm.next();
				
				vectorLayer.addVector(comp);
			}
		}
		
		return vectorLayer;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public VectorLayer getCardLayer(String cardName) {
		Iterator<Entry<Card, VectorLayer>> it = mapLayer.entrySet().iterator();

		while (it.hasNext()) {
			java.util.Map.Entry e = (java.util.Map.Entry)it.next();
			
			VectorLayer vl = (VectorLayer)e.getValue();
			
			if (vl.getDisplayName().equals(cardName)) 				
				return  (VectorLayer) e.getValue();
			
		}
		
		return null;
	}
    
}
