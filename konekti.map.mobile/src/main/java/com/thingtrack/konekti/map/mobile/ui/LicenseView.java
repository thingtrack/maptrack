package com.thingtrack.konekti.map.mobile.ui;

import com.vaadin.addon.touchkit.ui.HorizontalComponentGroup;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

@SuppressWarnings("serial")
public class LicenseView extends NavigationView {	
	private Layout mainLayout = new CssLayout();
		
    @Override
    public void attach() {
        super.attach();
        buildView();
    }
    
    private void buildView() {
    	setCaption("Licencia");
    	
    	mainLayout = new CssLayout();
    	mainLayout.setWidth("100%");
    	mainLayout.setMargin(true);
    
    	mainLayout.addComponent(buildLicenseCardLayout());
    	
    	setContent(mainLayout);
    }
    
    private Component buildLicenseCardLayout() {    	
    	HorizontalComponentGroup aboutCardComponentGroup = new HorizontalComponentGroup();    	
    	aboutCardComponentGroup.setMargin(true);
    	aboutCardComponentGroup.setWidth("100%");
    	aboutCardComponentGroup.addStyleName("about");
    	
    	Resource image = new ThemeResource("cards/thingtrack_icon.png");
    	
    	 if (image != null) {
    		 Embedded embedded = new Embedded(null, image);
             embedded.setWidth("100px");             
             aboutCardComponentGroup.addComponent(embedded);
             
    	 }
    	aboutCardComponentGroup.addComponent(new Label("<p><b>Konekti Map</b><br/>Localiza todo aquello que quieras</p>", Label.CONTENT_RAW));      
    	aboutCardComponentGroup.addComponent(new Label("<b>Versión 1.2.0</b>",  Label.CONTENT_RAW));
    	aboutCardComponentGroup.addComponent(new Label("<p>Todo el Contenido de esta Aplicación,<br/>como así también los productos y<br/>servicios comercializados son propiedad intelectual de Edikal Technology S.L.</p>",  Label.CONTENT_RAW));
    	        
    	return aboutCardComponentGroup;  
    }
}
