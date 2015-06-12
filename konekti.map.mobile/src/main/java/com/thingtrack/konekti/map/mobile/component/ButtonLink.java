package com.thingtrack.konekti.map.mobile.component;

import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Label;

/** Label that looks like a button, and has a link to an URL 
 * Tested with Reindeer only.
 * 
 * @author John Rizzo
 */
@SuppressWarnings("serial")
public class ButtonLink extends Label {
	/** Constructor
     * 
     * @param caption  text on the button
     * @param externalResource  where link goes
     * @param width    added to the constructor to make you remember that you don't specify a width the button does not appear (it's 0px wide)
     */
    public ButtonLink(String caption, ExternalResource externalResource, String width) {
        super(
        	  "<a href='" + externalResource.getURL() + "' style='text-decoration:none' target='_blank'>" +            
              // The following lines are copy pasted from rendered Vaadin v6.1 buttons.
                "<div class='v-button' tabindex='0'>" +
                    "<span class='v-button-wrap'>" +
                        "<span class='v-button-caption'>"+
                            caption +
                        "</span>"+
                    "</span>"+
                "</div>"+
            "</a>",
        Label.CONTENT_XHTML);
        setWidth(width);
    }
 
    
    /*public ButtonLink(String caption, ExternalResource externalResource, String width, String color) {
        super(
        	  "<a href='" + externalResource.getURL() + "' style='text-decoration:none' target='_blank'>" +            
              // The following lines are copy pasted from rendered Vaadin v6.1 buttons.
                "<div class='v-button' tabindex='0' style='background-color:" + color + "'>" +
                    "<span class='v-button-wrap'>" +
                        "<span class='v-button-caption'>"+
                            caption +
                        "</span>"+
                    "</span>"+
                "</div>"+
            "</a>",
        Label.CONTENT_XHTML);
        setWidth(width);
    }*/
    
    public ButtonLink(String caption, ExternalResource externalResource, String width, String style) {
        super(
        	  "<a href='" + externalResource.getURL() + "' style=" + style + ">" +            
              // The following lines are copy pasted from rendered Vaadin v6.1 buttons.
                "<div class='v-button' tabindex='0'>" +
                    "<span class='v-button-wrap'>" +
                        "<span class='v-button-caption'>"+
                            caption +
                        "</span>"+
                    "</span>"+
                "</div>"+
            "</a>",
        Label.CONTENT_XHTML);
        setWidth(width);
    }
    
    public ButtonLink(String caption, ExternalResource externalResource, String width, String style, String color) {
        super(
        	  "<a href='" + externalResource.getURL() + "' style=" + style + ">" +            
              // The following lines are copy pasted from rendered Vaadin v6.1 buttons.
                "<div class='v-button' tabindex='0' style='background-color:" + color + "'>" +
                    "<span class='v-button-wrap'>" +
                        "<span class='v-button-caption'>"+
                            caption +
                        "</span>"+
                    "</span>"+
                "</div>"+
            "</a>",
        Label.CONTENT_XHTML);
        setWidth(width);
    }
}
