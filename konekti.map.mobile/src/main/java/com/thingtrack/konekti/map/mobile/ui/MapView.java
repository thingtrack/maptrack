package com.thingtrack.konekti.map.mobile.ui;

import org.vaadin.vol.Bounds;
import org.vaadin.vol.Control;
import org.vaadin.vol.OpenLayersMap;
import org.vaadin.vol.OpenStreetMapLayer;
import org.vaadin.vol.Point;
import org.vaadin.vol.PointVector;
import org.vaadin.vol.Style;
import org.vaadin.vol.Vector;
import org.vaadin.vol.VectorLayer;
import org.vaadin.vol.VectorLayer.SelectionMode;
import org.vaadin.vol.VectorLayer.VectorSelectedEvent;
import org.vaadin.vol.VectorLayer.VectorSelectedListener;

import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.Marker;
import com.thingtrack.konekti.map.mobile.KonektiMapApplication;
import com.thingtrack.konekti.map.mobile.service.CardLayerManager;

import com.vaadin.addon.touchkit.service.Position;
import com.vaadin.addon.touchkit.service.PositionCallback;
import com.vaadin.addon.touchkit.ui.NavigationView;

@SuppressWarnings("serial")
public class MapView extends NavigationView implements PositionCallback, VectorSelectedListener {
    private CardLayerManager cardLayerManager;
    
	private Card card;

	private OpenLayersMap openLayersMap;
	private VectorLayer vectorLayer;
	
    private double latestLongitude;
    private double latestLatitude;
    
	public MapView() {
        this(null);
       
    }

	public MapView(Card card) {
		this.card = card;
		this.cardLayerManager = KonektiMapApplication.getApp().getCardLayerManager();
		
		if (KonektiMapApplication.getApp().getMode() == KonektiMapApplication.MODE.DIRECTOTY)
			this.vectorLayer = cardLayerManager.getMapLayer();
		else
			this.vectorLayer = cardLayerManager.getCardLayer(card.getName());
		
		// get current position
        KonektiMapApplication.get().getMainWindow().detectCurrentPosition(this);			

	}

	@Override
	public void attach() {
		super.attach();

	    buildView();
	}
 
	private void buildView() {
    	if (card != null)
    		setCaption("Mapa: " + card.getName());
    	else
    		setCaption("MAPA: " + KonektiMapApplication.getApp().getMapParameter().getTittle());
    	
    	if (openLayersMap == null) {
            openLayersMap = new OpenLayersMap() {
                @Override
                protected void updateExtent(java.util.Map<String, Object> variables) {
                    super.updateExtent(variables);
                    
                    updateMarkers();
                };
            };

            openLayersMap.getControls().clear();
            openLayersMap.addControl(Control.Attribution);
            openLayersMap.addControl(Control.ZoomPanel);
            openLayersMap.addControl(Control.TouchNavigation); 
            
            openLayersMap.setImmediate(true);
            openLayersMap.addLayer(new OpenStreetMapLayer());            
            openLayersMap.setSizeFull();
            openLayersMap.setZoom(13);
            
            setContent(openLayersMap);
    	}
	}

	private void updateMarkers() {
		PointVector pointMeVector = new PointVector(latestLongitude, latestLatitude);
    	
    	Style style = new Style();
        style.setExternalGraphic(KonektiMapApplication.getApp().getURL() + "VAADIN/themes/konektimap/markers/blue-dot.png");
        style.setGraphicHeight(CardLayerManager.DEFAULT_ICON_HEIGHT);
        style.setGraphicWidth(CardLayerManager.DEFAULT_ICON_WIDTH);
        style.setFillOpacity(1);
        
        pointMeVector.setCustomStyle(style);
        vectorLayer.addVector(pointMeVector);
        
		if (vectorLayer.getParent() == null) {
			vectorLayer.setSelectionMode(SelectionMode.SIMPLE);
			vectorLayer.addListener(this);
			
            openLayersMap.addLayer(vectorLayer);
		}

	}

	@Override
	public void onSuccess(Position position) {
		latestLatitude = position.getLatitude();
        latestLongitude = position.getLongitude();

        KonektiMapApplication.getApp().setCurrentLatitude(position.getLatitude());
        KonektiMapApplication.getApp().setCurrentLongitude(position.getLongitude());

        setCenter();

	}

	@Override
	public void onFailure(int errorCode) {
		// TODO Auto-generated method stub

	}

	private void showPopup(Marker marker) {
    	if (marker == null) {
    		updateMarkers(); // to evitate not clickeable markers
    		
    		return;
    	}    		
    	
    	CardDetailPopover exhibitorDetailPopover = new CardDetailPopover(marker);
    	exhibitorDetailPopover.showRelativeTo(getNavigationBar());
    	
    	// to click again in the marker?
    	updateMarkers();
    }

    private void setCenter() {
    	if (openLayersMap != null) {
	    	if (card != null) {	  
    			Point pointMe = new Point(latestLongitude, latestLatitude);
    			Point pointTarget = new  Point(card.getMarkers().get(0).getLongitude(), 
	                					       card.getMarkers().get(0).getLatitude());

	        	openLayersMap.zoomToExtent(new Bounds(pointMe, pointMe, pointTarget, pointTarget));
        		openLayersMap.setZoom(18);
	    	}
	    	else
	    		openLayersMap.setCenter(latestLongitude, latestLatitude);
        		        		
        }
    }

	@Override
	public void vectorSelected(VectorSelectedEvent event) {
		Vector vector = event.getVector();
        
        if (vector != null) {
        	Marker marker = (Marker) vector.getData();
        	
        	if (marker!= null && marker.isPopup())
        		showPopup(marker);
        	else
        		updateMarkers();
        	
        }		
	}
}