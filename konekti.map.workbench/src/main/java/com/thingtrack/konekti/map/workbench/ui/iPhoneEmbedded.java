package com.thingtrack.konekti.map.workbench.ui;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;

@SuppressWarnings("serial")
public class iPhoneEmbedded extends CustomComponent {

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Embedded embeddediPhone;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	private Embedded embeddedWeb;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public iPhoneEmbedded(String mapId, String userId, String cardId) {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		
		//String uri = "http://192.168.1.49:8080/konekti.map.mobile?map=" + mapId + "&user=" + userId + "&card=" + cardId;
		String uri = "http://127.0.0.1:8080/konekti.map.mobile?map=" + mapId + "&user=" + userId + "&card=" + cardId;
		
		embeddedWeb = new Embedded(null, new ExternalResource(uri));
		
		//web.setAlternateText("Vaadin web site");
		embeddedWeb.setType(Embedded.TYPE_BROWSER);
		embeddedWeb.setWidth("247px");
		embeddedWeb.setHeight("370px");
		mainLayout.addComponent(embeddedWeb, "top:93.0px;left:28.0px;");
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("300px");
		mainLayout.setHeight("504px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("300px");
		setHeight("504px");
		
		// embeddediPhone
		embeddediPhone = new Embedded();
		embeddediPhone.setEnabled(true);
		embeddediPhone.setImmediate(false);
		embeddediPhone.setVisible(true);
		embeddediPhone.setWidth("-1px");
		embeddediPhone.setHeight("-1px");
		embeddediPhone.setSource(new ThemeResource("iPhone.png"));
		embeddediPhone.setType(1);
		embeddediPhone.setMimeType("image/png");
		mainLayout.addComponent(embeddediPhone, "top:0.0px;left:0.0px;");
		
		return mainLayout;
	}

}
