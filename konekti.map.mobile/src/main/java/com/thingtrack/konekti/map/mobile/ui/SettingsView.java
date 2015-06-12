package com.thingtrack.konekti.map.mobile.ui;

import com.thingtrack.konekti.map.mobile.component.ButtonLink;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Layout;

@SuppressWarnings("serial")
public class SettingsView extends NavigationView {
	
	private Layout mainLayout = new CssLayout();
	
	private static final String HELP = "Ayuda";
	private static final String LICENSE = "Licencia";
	private static final String ABOUT = "Quienes somos";
	
    @Override
    public void attach() {
        super.attach();
        buildView();
    }
    
    private void buildView() {
    	setCaption("Ajustes");
    	
    	mainLayout = new CssLayout();
    	mainLayout.setWidth("100%");
    	mainLayout.setMargin(true);
    	mainLayout.setSizeFull();
    	
    	mainLayout.addComponent(buildMenuAboutLayout());
    	mainLayout.addComponent(buildEmailCardLayout());
    	
    	setContent(mainLayout);
    }
        
    private Component buildMenuAboutLayout() {
    	VerticalComponentGroup sponsorExhibitorComponentGroup = new VerticalComponentGroup();
    	
    	sponsorExhibitorComponentGroup.addComponent(new ItemNavigationButton(HELP));
    	sponsorExhibitorComponentGroup.addComponent(new ItemNavigationButton(LICENSE));
    	sponsorExhibitorComponentGroup.addComponent(new ItemNavigationButton(ABOUT));
    	    	
    	return sponsorExhibitorComponentGroup;
    }
    
    private Component buildEmailCardLayout() {    	
    	ButtonLink buttonAboutLink = new ButtonLink("Danos tu opinión", new ExternalResource("mailto:info@thingtrack.com"), "100%");
    	buttonAboutLink.setStyleName("v-button-weblink");
    	//buttonAboutLink.setWidth("100%");
    	    	
    	return buttonAboutLink;
    }
    
    /**
     * Helper class to wrap a classification item in a NavigationButton.
     */
    @SuppressWarnings("unchecked")
    static class ItemNavigationButton extends NavigationButton implements Button.ClickListener {   	
    	/**
         * Creates a navigation button with the localized name as a caption.
         * Button will navigate the manager to appropriate view for the
         * ClassificationItem: ExhibitorListView for groups and
         * ExhibitorCardView for exhibitor detail.
         * 
         * @param item
         * @param caption
         * @see ItemNavigationButon
         */
        public ItemNavigationButton(String caption) {
            addListener((ClickListener) this);

            if (caption.length() > 20)
            	setCaption(caption.substring(0, 20) + " …");
            else
            	setCaption(caption);
            
        }
        
		@Override
		public void buttonClick(ClickEvent event) {
			if (event.getButton().getCaption().equals(HELP))
				getNavigationManager().navigateTo(new HelpView());
			else if (event.getButton().getCaption().equals(LICENSE))
				getNavigationManager().navigateTo(new LicenseView());
			else if (event.getButton().getCaption().equals(ABOUT))
				getNavigationManager().navigateTo(new AboutView());			
		}
    	
    }
}
