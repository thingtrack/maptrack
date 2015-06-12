package com.thingtrack.konekti.map.mobile.ui;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;

@SuppressWarnings("serial")
public class HelpView extends NavigationView {
	private Layout mainLayout = new CssLayout();
	
    @Override
    public void attach() {
        super.attach();
        buildView();
    }
    
    private void buildView() {
    	setCaption("Ayuda");
    	
    	mainLayout = new CssLayout();
    	mainLayout.setWidth("100%");
    	mainLayout.setMargin(true);
    	
    	mainLayout.addComponent(buildHelp01Layout());
    	mainLayout.addComponent(buildHelp02Layout());
    	mainLayout.addComponent(buildHelp03Layout());
    	
    	setContent(mainLayout);
    }
    
    private Component buildHelp01Layout() {    	
    	VerticalComponentGroup aboutCardComponentGroup = new VerticalComponentGroup();
    	aboutCardComponentGroup.setCaption("¿Qué es Konekti Map?");
    	
    	aboutCardComponentGroup.setMargin(true);
    	aboutCardComponentGroup.setWidth("100%");
    	
    	aboutCardComponentGroup.addComponent(new Label("<p>Es una aplicación web móvil destinada a facilitar a los usuarios/clientes de un establecimiento ponerse en contacto con el mismo utilizando para ello diferentes canales de comunicación, teléfono fijo, móvil, correo electrónico, redes sociales</p><br/>La aplicación Konekti Map está operativa para las plataformas iPhone y Android.", Label.CONTENT_RAW));      
    	
    	return aboutCardComponentGroup;  
    }
    
    private Component buildHelp02Layout() {    	
    	VerticalComponentGroup aboutCardComponentGroup = new VerticalComponentGroup();
    	aboutCardComponentGroup.setCaption("¿Cómo descargar la aplicación?");
    	
    	aboutCardComponentGroup.setMargin(true);
    	aboutCardComponentGroup.setWidth("100%");
    	
    	aboutCardComponentGroup.addComponent(new Label("<p>Konekti Map es una aplicación web diseñada para terminales móviles, es decir no necesita ser descargada localmente en un terminal para su funcionamiento. Además, es posible crear un icono en el escritorio del terminal móvil para disponer de un acceso directo a la aplicación. La única condición necesaria es disponer en el terminal móvil de conectividad 3G.", Label.CONTENT_RAW));    	            	
    	
    	return aboutCardComponentGroup;  
    }
    
    private Component buildHelp03Layout() {    	
    	VerticalComponentGroup aboutCardComponentGroup = new VerticalComponentGroup();
    	aboutCardComponentGroup.setCaption("¿Datos personales?");
    	
    	aboutCardComponentGroup.setMargin(true);
    	aboutCardComponentGroup.setWidth("100%");
    	    	        
    	aboutCardComponentGroup.addComponent(new Label("<p>La aplicación no registra ningún dato de carácter personal del usuario de la misma. El Geo-posicionamiento  se utiliza únicamente para mostrar la posición actual del usuario en relación con el establecimiento. En ningún caso se almacena dicha posición.", Label.CONTENT_RAW));
    	
    	return aboutCardComponentGroup;  
    }
}
