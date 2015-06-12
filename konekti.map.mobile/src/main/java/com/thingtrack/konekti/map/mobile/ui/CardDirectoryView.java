package com.thingtrack.konekti.map.mobile.ui;

import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.CardType;
import com.thingtrack.konekti.map.mobile.KonektiMapApplication;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

@SuppressWarnings("serial")
public class CardDirectoryView extends NavigationView {
	private CssLayout mainLayout = new CssLayout();
	
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
    	setCaption("DIRECTORIO");
    	
    	mainLayout = new CssLayout();
    	mainLayout.setWidth("100%");
    	mainLayout.setMargin(true);
        
    	if (KonektiMapApplication.getApp().getCardService().getAllBySponsor().size() > 0)
    		mainLayout.addComponent(buildSponsorExhibitorLayout());
    	
    	mainLayout.addComponent(buildClassifiedExhibitorLayout());
    	
        setContent(mainLayout);            	
    
    }
    
    private Component buildSponsorExhibitorLayout() throws Exception {
    	VerticalComponentGroup sponsorExhibitorComponentGroup = new VerticalComponentGroup();
    	sponsorExhibitorComponentGroup.setCaption("PATROCINADORES");
    	
    	for(Card card : KonektiMapApplication.getApp().getCardService().getAllBySponsor()) {
    		sponsorExhibitorComponentGroup.addComponent(new ItemNavigationButton(card, card.getName()));

    	}
    	
    	return sponsorExhibitorComponentGroup;
    }
    
    private Component buildClassifiedExhibitorLayout() throws Exception {
    	VerticalComponentGroup classifiedExhibitorComponentGroup = new VerticalComponentGroup();
    	classifiedExhibitorComponentGroup.setCaption("CLASIFICADOS");
    	
    	for(CardType cardType : KonektiMapApplication.getApp().getCardTypeService().getAll()) {
    		classifiedExhibitorComponentGroup.addComponent(new ItemNavigationButton(cardType, cardType.getCode()));

    	}
    	
    	return classifiedExhibitorComponentGroup;
    }
    
    /**
     * Helper class to wrap a classification item in a NavigationButton.
     */
    @SuppressWarnings("unchecked")
    static class ItemNavigationButton extends NavigationButton implements Button.ClickListener {
    	private Object item;
    	
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
        public ItemNavigationButton(Object item, String caption) {
            addListener((ClickListener) this);
            this.item = item;
            if (caption.length() > 20)
            	setCaption(caption.substring(0, 20) + " …");
            else
            	setCaption(caption);
            
        }
        
		@Override
		public void buttonClick(ClickEvent event) {
			if (item instanceof Card)
                getNavigationManager().navigateTo(new CardView((Card)item));
			else {
				try {
					getNavigationManager().navigateTo(new CardListView((CardType)item));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    	
    }
    
}
