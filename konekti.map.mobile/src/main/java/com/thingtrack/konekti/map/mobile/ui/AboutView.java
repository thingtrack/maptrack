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
public class AboutView extends NavigationView {
	private Layout mainLayout = new CssLayout();
	
    @Override
    public void attach() {
        super.attach();
        
        buildView();
    }
    
    private void buildView() {
    	setCaption("Quienes somos");
    	
    	mainLayout = new CssLayout();
    	mainLayout.setWidth("100%");
    	mainLayout.setMargin(true);
    	
    	mainLayout.addComponent(buildAboutCardLayout());
    	
    	setContent(mainLayout);
    }
    
    private Component buildAboutCardLayout() {    	
    	HorizontalComponentGroup aboutCardComponentGroup = new HorizontalComponentGroup();    	
    	aboutCardComponentGroup.setMargin(true);
    	aboutCardComponentGroup.setWidth("100%");
    	aboutCardComponentGroup.addStyleName("about");
    	
    	Resource image = new ThemeResource("cards/thingtrack.png");
    	
    	 if (image != null) {
    		 Embedded embedded = new Embedded(null, image);
             embedded.setWidth("100px");
             embedded.setHeight("100px");
             aboutCardComponentGroup.addComponent(embedded);
             
    	 }
    	 
    	aboutCardComponentGroup.addComponent(new Label("<p>Thingtrack es una empresa de base tecnológica que proporciona una<br/>plataforma para el desarrollo de<br/>aplicaciones web modulares en entornos Cloud que facilita la puesta en marcha de aplicaciones de negocio basadas en la captura de datos en tiempo real y la explotación de los mismos.</p>", Label.CONTENT_RAW));      
        
    	return aboutCardComponentGroup;  
    }
}
