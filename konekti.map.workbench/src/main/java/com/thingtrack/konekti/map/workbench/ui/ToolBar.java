package com.thingtrack.konekti.map.workbench.ui;

import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.workbench.MainApplication;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Select;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;

@SuppressWarnings("serial")
public class ToolBar extends CustomComponent {

	@AutoGenerated
	private HorizontalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout separator;
	@AutoGenerated
	private Button btnQR;
	@AutoGenerated
	private Button btnMobile;
	@AutoGenerated
	private Button btnCampaignManager;
	@AutoGenerated
	private Button btnMapDesigner;
	@AutoGenerated
	private VerticalLayout verticalLayout_1;
	@AutoGenerated
	private ComboBox cmbMap;
	@AutoGenerated
	private Label lblMap;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private BeanItemContainer<Map> bcMap = new BeanItemContainer<Map>(Map.class);
	private VerticalLayout konektiMapMainLayout;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	@SuppressWarnings("deprecation")
	public ToolBar() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		lblMap.setStyle("map-list");
		
		cmbMap.setStyle("map-list");
		cmbMap.setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
		cmbMap.setItemCaptionPropertyId("description");
		cmbMap.addListener(new ValueChangeListener() {			
			@Override
			public void valueChange(ValueChangeEvent event) {
				Map map = (Map) event.getProperty().getValue();
				
				if (map !=  null)
					MainApplication.get().setMap(map);
				
			}
		});
        
		fillMapDataSource();
		
		btnMapDesigner.setStyleName(Button.STYLE_LINK);
		btnMapDesigner.addStyleName("toplink-left");
		btnMapDesigner.addListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				konektiMapMainLayout.removeAllComponents();
				
				MapDesignerView view = new MapDesignerView();
				addListenerMapChange((ValueChangeListener) view);
				
				konektiMapMainLayout.addComponent(view);
				
			}
		});
		
		btnCampaignManager.setStyleName(Button.STYLE_LINK);
		btnCampaignManager.addStyleName("toplink-center");
		btnCampaignManager.addListener(new ClickListener() {			
			@Override
			public void buttonClick(ClickEvent event) {
				konektiMapMainLayout.removeAllComponents();
				
				CampaignDesignerView view = new CampaignDesignerView();
				addListenerMapChange((ValueChangeListener) view);
				
				konektiMapMainLayout.addComponent(view);
				
			}
		});
		
		btnMobile.setStyleName(Button.STYLE_LINK);
		btnMobile.addStyleName("toplink-center");
		btnMobile.addListener(new ClickListener() {			
			@Override
			public void buttonClick(ClickEvent event) {
				//konektiMapMainLayout.removeAllComponents();
				//konektiMapMainLayout.addComponent(new KonektiMapMobileView("1", "1", "directory"));
				
				String uri = "http://localhost:8080/konekti.map.mobile?map=" + 1 + "&user=" + 1 + "&card=" + "directory";
				
				MainApplication.get().getMainWindow().open(new ExternalResource(uri), 
				                                           "Konekti Map", 320, 420,  // Width and height 
			                							   Window.BORDER_NONE); // No decorations
				
				/*String uri = "/konekti.map.workbench/VAADIN/iPhoneEmulator.html";
				
				MainApplication.get().getMainWindow().open(new ExternalResource(uri),
			                							   "Konekti Map", 1100, 510,  // Width and height 
			                							   Window.BORDER_NONE); // No decorations*/				
				
			}
		});
		
		btnQR.setStyleName(Button.STYLE_LINK);
		btnQR.addStyleName("toplink-right");
		btnQR.addListener(new ClickListener() {			
			@Override
			public void buttonClick(ClickEvent event) {				
				konektiMapMainLayout.removeAllComponents();
				
				QRView view = new QRView();
				addListenerMapChange((ValueChangeListener) view);
				
				konektiMapMainLayout.addComponent(view);
				
			}
		});
		
		separator.setVisible(false);
	}

	public void setKonektiMapMainLayout(VerticalLayout konektiMapMainLayout) {
		this.konektiMapMainLayout = konektiMapMainLayout;
		
	}

	public void addListenerMapChange(ValueChangeListener listener) {
		cmbMap.addListener(listener);
		
		
	}
	
	private void fillMapDataSource() {
		try {
			bcMap.removeAllItems();
			bcMap.addAll(MainApplication.get().getMapService().getAll());
						
			cmbMap.setContainerDataSource(bcMap);
		} catch (UnsupportedOperationException e) {
			MainApplication.get().getMainWindow().showNotification(e.getMessage(), Notification.TYPE_ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception e) {
			MainApplication.get().getMainWindow().showNotification(e.getMessage(), Notification.TYPE_ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	@AutoGenerated
	private HorizontalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new HorizontalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// lblMap
		lblMap = new Label();
		lblMap.setImmediate(false);
		lblMap.setWidth("-1px");
		lblMap.setHeight("-1px");
		lblMap.setValue("Selecciona un mapa:");
		mainLayout.addComponent(lblMap);
		mainLayout.setExpandRatio(lblMap, 1.0f);
		mainLayout.setComponentAlignment(lblMap, new Alignment(34));
		
		// cmbMap
		cmbMap = new ComboBox();
		cmbMap.setImmediate(true);
		cmbMap.setWidth("-1px");
		cmbMap.setHeight("-1px");
		mainLayout.addComponent(cmbMap);
		mainLayout.setComponentAlignment(cmbMap, new Alignment(34));
		
		// verticalLayout_1
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("50px");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(false);
		mainLayout.addComponent(verticalLayout_1);
		mainLayout.setComponentAlignment(verticalLayout_1, new Alignment(34));
		
		// btnMapDesigner
		btnMapDesigner = new Button();
		btnMapDesigner.setCaption("Map Designer");
		btnMapDesigner.setImmediate(true);
		btnMapDesigner.setWidth("-1px");
		btnMapDesigner.setHeight("-1px");
		mainLayout.addComponent(btnMapDesigner);
		mainLayout.setComponentAlignment(btnMapDesigner, new Alignment(34));
		
		// btnCampaignManager
		btnCampaignManager = new Button();
		btnCampaignManager.setCaption("Campaign Manager");
		btnCampaignManager.setImmediate(true);
		btnCampaignManager.setWidth("-1px");
		btnCampaignManager.setHeight("-1px");
		mainLayout.addComponent(btnCampaignManager);
		mainLayout.setComponentAlignment(btnCampaignManager, new Alignment(34));
		
		// btnMobile
		btnMobile = new Button();
		btnMobile.setCaption("Show Mobile");
		btnMobile.setImmediate(true);
		btnMobile.setWidth("-1px");
		btnMobile.setHeight("-1px");
		mainLayout.addComponent(btnMobile);
		mainLayout.setComponentAlignment(btnMobile, new Alignment(34));
		
		// btnQR
		btnQR = new Button();
		btnQR.setCaption("My QR");
		btnQR.setImmediate(true);
		btnQR.setWidth("-1px");
		btnQR.setHeight("-1px");
		mainLayout.addComponent(btnQR);
		mainLayout.setComponentAlignment(btnQR, new Alignment(34));
		
		// separator
		separator = new VerticalLayout();
		separator.setImmediate(false);
		separator.setWidth("12px");
		separator.setHeight("100.0%");
		separator.setMargin(false);
		mainLayout.addComponent(separator);
		
		return mainLayout;
	}

}
