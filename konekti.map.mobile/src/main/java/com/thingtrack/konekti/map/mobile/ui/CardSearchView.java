package com.thingtrack.konekti.map.mobile.ui;

import java.util.List;

import org.vaadin.henrik.superimmediatetextfield.SuperImmediateTextField.KeyPressEvent;
import org.vaadin.henrik.superimmediatetextfield.SuperImmediateTextField.KeyPressListener;

import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.mobile.KonektiMapApplication;
import com.thingtrack.konekti.map.mobile.component.ButtonSearch;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class CardSearchView extends NavigationView {
	private VerticalLayout mainLayout = new VerticalLayout();
	private Layout directoryLayout = new CssLayout();
	
	private String filterName;
	
	public CardSearchView() {
		this(null);
	}
	
	public CardSearchView(String filterName) {
		this.filterName = filterName;
		
	}
	
    @Override
    public void attach() {
        super.attach();
        try {
			buildView();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void buildView() throws Exception {
    	setCaption("BUSCADOR");
    	
    	mainLayout.removeAllComponents();
    	
    	// build search toolbar    	
    	mainLayout.addComponent(buildSearchButtonCardLayout());    	
    	    	
    	// Card list
    	mainLayout.addComponent(buildSearchListCardLayout(filterName));
    	    	
    	// set content navigation view
        setContent(mainLayout);
    }
    
    private Component buildSearchButtonCardLayout() {   
    	HorizontalLayout searchToolbar = new HorizontalLayout();
    	
    	searchToolbar.setMargin(false, true, false, true);
    	searchToolbar.setSpacing(true);
    	searchToolbar.setWidth("100%");
    	searchToolbar.setHeight("50px");
    	searchToolbar.setStyleName("v-touchkit-navbar");
    	
    	final ButtonSearch searchButton = new ButtonSearch();
    	searchButton.setWidth("100.0%");
    	searchButton.setHeight("40px");
    	searchButton.getSearchBox().addListener(new KeyPressListener() {
    	    public void keyPressed(final KeyPressEvent event) {
    	    	mainLayout.removeComponent(directoryLayout);
    	    	try {
					mainLayout.addComponent(buildSearchListCardLayout((String) searchButton.getSearchBox().getValue()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    	
    	    }
    	});
    	
    	searchToolbar.addComponent(searchButton);
    	searchToolbar.setExpandRatio(searchButton, 1.0f);
    	searchToolbar.setComponentAlignment(searchButton, Alignment.MIDDLE_RIGHT);
    	
    	return searchToolbar;
    }
    
    private Component buildSearchListCardLayout(String filter) throws Exception {    	
    	String letter = null;
    	VerticalComponentGroup letterComponentGroup = null;
    	
    	// build directory
    	directoryLayout = new CssLayout();
    	directoryLayout.setWidth("100%");
    	directoryLayout.setMargin(true);
    	
    	for (Card card : filterCard(filter)) {
    		// get the first letter of the word
    		String checkLetter = card.getName().substring(0, 1);
    		
    		if (!checkLetter.equals(letter)) {
    			if (letterComponentGroup != null)
    				directoryLayout.addComponent(letterComponentGroup);
    			
    			letter = checkLetter; 
    			
    			letterComponentGroup = new VerticalComponentGroup();
    			letterComponentGroup.setCaption(letter);
    			    			   			    			
    		}
    		
    		letterComponentGroup.addComponent(new ItemNavigationButton(card, card.getName()));

    	}
    	
    	if (letterComponentGroup != null)
    		directoryLayout.addComponent(letterComponentGroup);
    	
    	return directoryLayout;
    }
    
    private List<Card> filterCard(String filter) throws Exception {
    	if (filter != null && !filter.isEmpty())
    		return KonektiMapApplication.getApp().getCardService().getAllByName(filter + "%");    		
    	else
    		return KonektiMapApplication.getApp().getCardService().getAll();
    	
    }
        
    /**
     * Helper class to wrap a classification item in a NavigationButton.
     */
    @SuppressWarnings("unchecked")
    static class ItemNavigationButton extends NavigationButton implements Button.ClickListener {
    	private Card card;
    	
    	/**
         * Creates a navigation button with the localized name as a caption.
         * Button will navigate the manager to appropriate view for the
         * ClassificationItem: CardListView for groups and
         * CardView for card detail.
         * 
         * @param item
         * @param caption
         * @see ItemNavigationButon
         */
        public ItemNavigationButton(Card card, String caption) {
            addListener((ClickListener) this);
            this.card = card;
            
            if (caption.length() > 20)
            	setCaption(caption.substring(0, 20) + " …");
            else
            	setCaption(caption);
            
            if (card.isSponsor()) {
            	setDescription("P");
            	addStyleName("pill");
            	
            }
            
        }
        
		@Override
		public void buttonClick(ClickEvent event) {
			getNavigationManager().navigateTo(new MapView(card));			
			
		}
    	
    }
}
