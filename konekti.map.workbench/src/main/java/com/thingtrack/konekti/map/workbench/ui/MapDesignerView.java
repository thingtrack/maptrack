package com.thingtrack.konekti.map.workbench.ui;

import org.vaadin.vol.Control;
import org.vaadin.vol.OpenLayersMap;
import org.vaadin.vol.OpenStreetMapLayer;

import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.domain.Marker;
import com.thingtrack.konekti.map.workbench.MainApplication;
import com.thingtrack.konekti.map.workbench.form.CardViewForm;
import com.thingtrack.konekti.map.workbench.form.MapViewForm;
import com.thingtrack.konekti.map.workbench.form.MarkerViewForm;
import com.thingtrack.konekti.map.workbench.form.WindowDialog;
import com.thingtrack.konekti.map.workbench.form.WindowDialog.DialogResult;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.ExpandEvent;
import com.vaadin.ui.Tree.ExpandListener;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MapDesignerView extends CustomComponent implements ValueChangeListener, Handler {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private Panel pnMainPanel;
	@AutoGenerated
	private VerticalLayout vlMapDesigner;
	@AutoGenerated
	private HorizontalSplitPanel splMapDesigner;
	@AutoGenerated
	private VerticalLayout sp1MapDesigner;
	@AutoGenerated
	private Panel pnMapTree;
	@AutoGenerated
	private VerticalLayout vlMapTree;
	@AutoGenerated
	private Tree treeMap;
	@AutoGenerated
	private HorizontalLayout hlMap;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	@SuppressWarnings("unused")
	private Map map;
	
	private OpenLayersMap openLayersMap;
	private OpenStreetMapLayer openStreetMapLayer;
	
	// Actions for the context menu
    private static final Action ACTION_EDIT_MAP = new Action("Editar Mapa");
    private static final Action ACTION_DELETE_MAP = new Action("Borrar Mapa");
    
    private static final Action ACTION_ADD_CARD = new Action("Añadir Tarjeta");
    private static final Action ACTION_EDIT_CARD = new Action("Editar Tarjeta");
    private static final Action ACTION_DELETE_CARD = new Action("Borrar Tarjeta");
    
    private static final Action ACTION_ADD_MARKER = new Action("Añadir Marcador");
    private static final Action ACTION_EDIT_MARKER = new Action("Editar Marcador");
    private static final Action ACTION_DELETE_MARKER = new Action("Borrar Marcador");
    
    private static final Action[] ACTIONS_MAP = new Action[] { ACTION_EDIT_MAP, ACTION_DELETE_MAP, ACTION_ADD_CARD };
    private static final Action[] ACTIONS_CARD = new Action[] { ACTION_EDIT_CARD, ACTION_DELETE_CARD, ACTION_ADD_MARKER };
    private static final Action[] ACTIONS_MARKER = new Action[] { ACTION_EDIT_MARKER, ACTION_DELETE_MARKER };
    
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public MapDesignerView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		mainLayout.setMargin(true);
		mainLayout.setStyleName("mapdesigner");
		
        // set Open Layers    
		openLayersMap = new OpenLayersMap();
		openLayersMap.setSizeFull();
		openLayersMap.setImmediate(false);
				
		openLayersMap.getControls().clear();
        openLayersMap.addControl(Control.ZoomPanel);
        openLayersMap.addControl(Control.TouchNavigation);

		openStreetMapLayer = new OpenStreetMapLayer();
		openLayersMap.addLayer(openStreetMapLayer);

        splMapDesigner.addComponent(openLayersMap);
        
        // set spleet position
        splMapDesigner.setSplitPosition(20, Sizeable.UNITS_PERCENTAGE);
        
        /*treeMap.addListener(new ItemClickEvent.ItemClickListener() {
            public void itemClick(ItemClickEvent event) {
                // Pick only left mouse clicks
                if (event.getButton() == ItemClickEvent.BUTTON_LEFT) {
                    //getWindow().showNotification("Left click", Notification.TYPE_HUMANIZED_MESSAGE);
                }
                else if (event.getButton() == ItemClickEvent.BUTTON_RIGHT){
                	
                }
            }
        });*/
        
        treeMap.addListener(new ExpandListener() {
            @Override
            public void nodeExpand(ExpandEvent event) {
            	pnMapTree.requestRepaint();
            }
        });
        
        // Add Valuechangelistener and Actionhandler
        //treeMap.addListener(this);

        // Add actions (context menu)
        treeMap.addActionHandler(this);
	}
	
	private void setMap(Map map) {
		this.map = map;
				
		HierarchicalContainer treeHierarchicalContainer = new HierarchicalContainer();
		treeHierarchicalContainer.addContainerProperty("icon", Resource.class, null);
		treeHierarchicalContainer.addContainerProperty("caption", String.class, null);
        
		Item itemMap = treeHierarchicalContainer.addItem(map);
		itemMap.getItemProperty("icon").setValue(new ThemeResource("../konektimap/icons/map-pin.png"));
		itemMap.getItemProperty("caption").setValue(map.getTittle());
		
		// create the map tree
		for(Card card : map.getCards()) {
			Item itemCard = treeHierarchicalContainer.addItem(card);
			itemCard.getItemProperty("icon").setValue(new ThemeResource("../konektimap/icons/card-address.png"));
			itemCard.getItemProperty("caption").setValue(card.getName());
			
			treeHierarchicalContainer.setParent(card, map);
			
			if (card.getMarkers().size() == 0)
				treeHierarchicalContainer.setChildrenAllowed(card, false);
			
			for (Marker marker : card.getMarkers()) {
				Item itemMarker = treeHierarchicalContainer.addItem(marker);
				itemMarker.getItemProperty("icon").setValue(new ThemeResource("../konektimap/icons/marker.png"));
				itemMarker.getItemProperty("caption").setValue(marker.getCaption());
				
				treeHierarchicalContainer.setParent(marker, card);
				
				treeHierarchicalContainer.setChildrenAllowed(marker, false);
			}
			
		}
		
		// set datasource
		treeMap.setContainerDataSource(treeHierarchicalContainer);
		treeMap.setItemIconPropertyId("icon");
		treeMap.setItemCaptionPropertyId("caption");
		treeMap.setItemCaptionMode(Tree.ITEM_CAPTION_MODE_PROPERTY);
		
        // Expand whole tree
        for (Object id : treeMap.rootItemIds())
        	treeMap.expandItemsRecursively(id);
        
	}
	
	@Override
	public void attach() {
		   Map selectMap = MainApplication.get().getMap();
		   
		   if (selectMap ==  null)
				return;
		   
		   setMap(selectMap);			
			   		   
	}
	
	@Override
	public void valueChange(ValueChangeEvent event) {
		if ( event.getProperty().getValue() instanceof Map) {
			Map map = (Map) event.getProperty().getValue();
			
			if (map !=  null)
				setMap(map);
			else {
				treeMap.removeAllItems();
			}
		}
	}

	@Override
	public Action[] getActions(Object target, Object sender) {
		if ( target instanceof Map)
			return ACTIONS_MAP;
		else if ( target instanceof Card)
			return ACTIONS_CARD;
		else if ( target instanceof Marker)
			return ACTIONS_MARKER;
		else
			return null;
	}

	@Override
	public void handleAction(Action action, Object sender, Object target) {
		if (action == ACTION_EDIT_MAP) {
			editMap((Map)target);
			
		}
		else if (action == ACTION_DELETE_MAP) {
			
		}
		else if (action == ACTION_ADD_CARD) {
			
		}
		else if (action == ACTION_EDIT_CARD) {
			editCard((Card)target);
			
		}
		else if (action == ACTION_DELETE_CARD) {
			
		}
		else if (action == ACTION_ADD_MARKER) {
			
		}
		else if (action == ACTION_EDIT_MARKER) {
			 editMarker((Marker)target);
			 
		}
		else if (action == ACTION_DELETE_MARKER) {
			
		}
	}
	
	private void editMap(Map map) {
		try {
			@SuppressWarnings("unused")
			WindowDialog<Map> windowDialog = new WindowDialog<Map>(getApplication().getMainWindow() , "Editar Mapa", 
					"Guardar", DialogResult.SAVE, "Cancelar", DialogResult.CANCEL, 
					new MapViewForm(), map, 
					new WindowDialog.CloseWindowDialogListener<Map>() {
			    public void windowDialogClose(WindowDialog<Map>.CloseWindowDialogEvent<Map> event) {
			    	if (event.getDialogResult() != WindowDialog.DialogResult.SAVE)
			    		return ;
			    	
			    	try {
			       		//JobOffer savingJobOffer = event.getDomainEntity();
			    		
			    		//JobOffer savedJobOffer = jobOfferService.save(savingJobOffer);			    					    		
			    		
			    		//refreshDataGridView(savedJobOffer);
			    		
					} catch (Exception e) {
						e.printStackTrace();
						
					}
			    }

			});
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editCard(Card card) {
		try {
			@SuppressWarnings("unused")
			WindowDialog<Card> windowDialog = new WindowDialog<Card>(getApplication().getMainWindow() , "Editar Tarjeta", 
					"Guardar", DialogResult.SAVE, "Cancelar", DialogResult.CANCEL, 
					new CardViewForm(), card, 
					new WindowDialog.CloseWindowDialogListener<Card>() {
			    public void windowDialogClose(WindowDialog<Card>.CloseWindowDialogEvent<Card> event) {
			    	if (event.getDialogResult() != WindowDialog.DialogResult.SAVE)
			    		return ;
			    	
			    	try {
			       		//JobOffer savingJobOffer = event.getDomainEntity();
			    		
			    		//JobOffer savedJobOffer = jobOfferService.save(savingJobOffer);			    					    		
			    		
			    		//refreshDataGridView(savedJobOffer);
			    		
					} catch (Exception e) {
						e.printStackTrace();
						
					}
			    }

			});
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editMarker(Marker marker) {
		try {
			@SuppressWarnings("unused")
			WindowDialog<Marker> windowDialog = new WindowDialog<Marker>(getApplication().getMainWindow() , "Editar Marcador", 
					"Guardar", DialogResult.SAVE, "Cancelar", DialogResult.CANCEL, 
					new MarkerViewForm(), marker, 
					new WindowDialog.CloseWindowDialogListener<Marker>() {
			    public void windowDialogClose(WindowDialog<Marker>.CloseWindowDialogEvent<Marker> event) {
			    	if (event.getDialogResult() != WindowDialog.DialogResult.SAVE)
			    		return ;
			    	
			    	try {
			       		//JobOffer savingJobOffer = event.getDomainEntity();
			    		
			    		//JobOffer savedJobOffer = jobOfferService.save(savingJobOffer);			    					    		
			    		
			    		//refreshDataGridView(savedJobOffer);
			    		
					} catch (Exception e) {
						e.printStackTrace();
						
					}
			    }

			});
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// pnMainPanel
		pnMainPanel = buildPnMainPanel();
		mainLayout.addComponent(pnMainPanel);
		mainLayout.setExpandRatio(pnMainPanel, 1.0f);
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPnMainPanel() {
		// common part: create layout
		pnMainPanel = new Panel();
		pnMainPanel.setImmediate(false);
		pnMainPanel.setWidth("100.0%");
		pnMainPanel.setHeight("100.0%");
		
		// vlMapDesigner
		vlMapDesigner = buildVlMapDesigner();
		pnMainPanel.setContent(vlMapDesigner);
		
		return pnMainPanel;
	}

	@AutoGenerated
	private VerticalLayout buildVlMapDesigner() {
		// common part: create layout
		vlMapDesigner = new VerticalLayout();
		vlMapDesigner.setImmediate(false);
		vlMapDesigner.setWidth("100.0%");
		vlMapDesigner.setHeight("100.0%");
		vlMapDesigner.setMargin(false);
		
		// splMapDesigner
		splMapDesigner = buildSplMapDesigner();
		vlMapDesigner.addComponent(splMapDesigner);
		vlMapDesigner.setExpandRatio(splMapDesigner, 1.0f);
		
		return vlMapDesigner;
	}

	@AutoGenerated
	private HorizontalSplitPanel buildSplMapDesigner() {
		// common part: create layout
		splMapDesigner = new HorizontalSplitPanel();
		splMapDesigner.setImmediate(true);
		splMapDesigner.setWidth("100.0%");
		splMapDesigner.setHeight("100.0%");
		splMapDesigner.setMargin(false);
		
		// sp1MapDesigner
		sp1MapDesigner = buildSp1MapDesigner();
		splMapDesigner.addComponent(sp1MapDesigner);
		
		return splMapDesigner;
	}

	@AutoGenerated
	private VerticalLayout buildSp1MapDesigner() {
		// common part: create layout
		sp1MapDesigner = new VerticalLayout();
		sp1MapDesigner.setImmediate(false);
		sp1MapDesigner.setWidth("100.0%");
		sp1MapDesigner.setHeight("100.0%");
		sp1MapDesigner.setMargin(false);
		
		// hlMap
		hlMap = new HorizontalLayout();
		hlMap.setImmediate(false);
		hlMap.setWidth("100.0%");
		hlMap.setHeight("-1px");
		hlMap.setMargin(false);
		sp1MapDesigner.addComponent(hlMap);
		
		// pnMapTree
		pnMapTree = buildPnMapTree();
		sp1MapDesigner.addComponent(pnMapTree);
		sp1MapDesigner.setExpandRatio(pnMapTree, 1.0f);
		
		return sp1MapDesigner;
	}

	@AutoGenerated
	private Panel buildPnMapTree() {
		// common part: create layout
		pnMapTree = new Panel();
		pnMapTree.setImmediate(false);
		pnMapTree.setWidth("99.69%");
		pnMapTree.setHeight("100.0%");
		
		// vlMapTree
		vlMapTree = buildVlMapTree();
		pnMapTree.setContent(vlMapTree);
		
		return pnMapTree;
	}

	@AutoGenerated
	private VerticalLayout buildVlMapTree() {
		// common part: create layout
		vlMapTree = new VerticalLayout();
		vlMapTree.setImmediate(false);
		vlMapTree.setWidth("100.0%");
		vlMapTree.setHeight("100.0%");
		vlMapTree.setMargin(false);
		
		// treeMap
		treeMap = new Tree();
		treeMap.setImmediate(true);
		treeMap.setWidth("100.0%");
		treeMap.setHeight("100.0%");
		vlMapTree.addComponent(treeMap);
		
		return vlMapTree;
	}

}
