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
public class CardListView extends NavigationView {
	private CardType cardType;
			
	private CssLayout mainLayout = new CssLayout();
	
	public CardListView(CardType cardType) throws Exception {
		this.cardType = cardType;
		
		//KonektiMapApplication.getApp().getCardService().getAllByType(cardType);
		
		mainLayout.addComponent(buildListExhibitorLayout());
		
		setContent(mainLayout);
	}
	   
    @Override
    public void attach() {
        super.attach();
        buildView();
    }

    private void buildView() {
    	setCaption(cardType.getCode());
    	
    	mainLayout = new CssLayout();
    	mainLayout.setWidth("100%");
    	mainLayout.setMargin(true);
    	
    }
    
	
    private Component buildListExhibitorLayout() throws Exception {
    	VerticalComponentGroup listExhibitorComponentGroup = new VerticalComponentGroup();
    	
    	for(Card card : KonektiMapApplication.getApp().getCardService().getAllByType(cardType)) {
    		listExhibitorComponentGroup.addComponent(new ItemNavigationButton(card, card.getName()));

    	}
    	
    	return listExhibitorComponentGroup;
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
         * ClassificationItem: ExhibitorListView for groups and
         * ExhibitorCardView for exhibitor detail.
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
			getNavigationManager().navigateTo(new CardView(card));
			
		}
    	
    }
}
