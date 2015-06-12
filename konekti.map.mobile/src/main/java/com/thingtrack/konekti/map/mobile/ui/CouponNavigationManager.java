package com.thingtrack.konekti.map.mobile.ui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.qr.QRCodeBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import com.thingtrack.konekti.map.domain.Campaign;
import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.Coupon;
import com.thingtrack.konekti.map.mobile.KonektiMapApplication;

import com.vaadin.addon.touchkit.ui.NavigationBar;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationManager.NavigationEvent.Direction;
import com.vaadin.addon.touchkit.ui.SwipeView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.StreamResource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.terminal.StreamResource.StreamSource;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class CouponNavigationManager extends NavigationManager {
	int index = 0;
	private CouponView[] coupons;
	
	private Card card;
	
	/**
     * Creates a classification hierarchy displaying the birds classification
     * group in the top level view
     */
    public CouponNavigationManager(Card card) {
    	this.card = card;
    	
    	final boolean loop = true;
    	
    	setMaintainBreadcrump(false);
        setWidth("100%");
        
        coupons = loadCoupons();
        
        SwipeView prev = getCoupon(index - 1);
        SwipeView cur = getCoupon(index);
        SwipeView next = getCoupon(index + 1);
        
        setPreviousComponent(prev);
        setCurrentComponent(cur);
        setNextComponent(next);
        
        //updateNextPreviousInCurrentComponent();
        
        addListener(new NavigationListener() {
            public void navigate(NavigationEvent event) {
                if (event.getDirection() == Direction.FORWARD) {
                    index++;
                    int nextViewIndex = index + 1;
                    while (nextViewIndex >= coupons.length) {
                        nextViewIndex -= coupons.length;
                    }
                    if (loop || nextViewIndex != 0) {
                        SwipeView next = getCoupon(nextViewIndex);
                        setNextComponent(next);
                    }
                } else {
                    index--;
                    int i = index - 1;
                    while (i < 0) {
                        i += coupons.length;
                    }
                    if (loop || i != coupons.length - 1) {
                        SwipeView prev = getCoupon(i);
                        setPreviousComponent(prev);
                    }

                }
                
                //updateNextPreviousInCurrentCompoenent();
            }
        });
    }
    
    private CouponView[] loadCoupons() {
    	List<CouponView> cps = new ArrayList<CouponView>();
    	
    	// generate all SwipeView coupon for this card
    	for (Campaign campaign : card.getCampaigns()) {
    		for (Coupon coupon : campaign.getCoupons()) {
    			CouponView couponView = new CouponView(campaign, coupon);
    			
    			cps.add(couponView);
    		}
    		
    	}
    	
    	return (CouponView[]) cps.toArray(new CouponView[cps.size()]);
    
    }
    
    private CouponView getCoupon(int i) {
        while (i < 0) {
            i += coupons.length;
        }
        
        return coupons[i % coupons.length];
    }
    
    /*private void updateNextPreviousInCurrentComponent() {
        Component currentComponent2 = getCurrentComponent();

        if (currentComponent2 instanceof CouponView) {
        	CouponView new_name = (CouponView) currentComponent2;
            
            NavigationButton leftComponent = (NavigationButton) new_name.navigationBar.getLeftComponent();
            leftComponent.setTargetView(getPreviousComponent());
            
            NavigationButton rightComponent = (NavigationButton) new_name.navigationBar .getRightComponent();
            rightComponent.setTargetView(getNextComponent());
        }
    }*/
    
    private class CouponView extends SwipeView {
    	private Coupon coupon;
    	
    	private NavigationBar navigationBar;
    	
    	public CouponView(Campaign campaign, Coupon coupon) {
    		this.coupon = coupon;
    		
    		setWidth("100%");
    		
            /*navigationBar = new NavigationBar();
            
            NavigationButton button = new NavigationButton("<");
            button.setStyleName("back");
            navigationBar.setLeftComponent(button);
                        
            button = new NavigationButton(">");
            button.setStyleName("forward");
            navigationBar.setRightComponent(button);
            
            navigationBar.setCaption(campaign.getName());
            
            addComponent(navigationBar);*/
    		
    		buildView();
    	}
    	
        /*@Override
        protected String getCss(Component c) {
            // Make background of bar semitranparent over the image.
            if (c == navigationBar) {
                return "background: rgba(255, 255, 255, 0.7); position:absolute;top:0;left:0;right:0;";
            }
            
            return super.getCss(c);
        }*/

        @Override
        public void attach() {
            super.attach();
            
            //buildView();
            
        }

        private void buildView() {
        	// build Image Coupon
        	if (coupon.getImage() != null)
        		addComponent(buildImageCouponCardLayout());
        	
        	//  build Description Coupon
        	addComponent(buildDescriptionCouponCardLayout());
        	 
        	//  build QR Coupon
        	addComponent(buildBarcodeCouponCardLayout());
        }
        
        private Component buildImageCouponCardLayout() {
        	VerticalComponentGroup photoCouponNodeComponentGroup = new VerticalComponentGroup();
        	
        	Resource image = new ThemeResource("coupons/" + coupon.getImage());
        	
            if (image != null) {
            	CssLayout imageLayout = new CssLayout();
            	imageLayout.setMargin(true, false, true, false);
            	
            	Embedded embedded = new Embedded(null, image);
                embedded.setWidth("100%");
                imageLayout.addComponent(embedded);
                            
                photoCouponNodeComponentGroup.addComponent(imageLayout);
                
            }
        	
        	return photoCouponNodeComponentGroup;
        }
        
        private Component buildDescriptionCouponCardLayout() {
        	VerticalComponentGroup descriptionCouponNodeComponentGroup = new VerticalComponentGroup();
        	descriptionCouponNodeComponentGroup.setCaption("Descripción");
        	
        	if (coupon.getDescription() != null) {    		
        		descriptionCouponNodeComponentGroup.addComponent(new Label(coupon.getDescription()));
        		
        	}
        	        		
        	return descriptionCouponNodeComponentGroup;
        	
        }
        
        private Component buildBarcodeCouponCardLayout() {
        	VerticalComponentGroup qrCouponNodeComponentGroup = new VerticalComponentGroup();
        	qrCouponNodeComponentGroup.setCaption("Cupón");
        	
        	CssLayout qrLayout = new CssLayout();
        	qrLayout.setHeight("150px");
        	qrLayout.setMargin(true, false, true, false);
        	
        	Format formatter = new SimpleDateFormat("ddHHmmss");
            String s = formatter.format(new Date());
            
        	// define text coupon
        	/*Label couponLabel = new Label(s);
        	//Label couponLabel = new Label("<p><h1>" + s + "</h1></p>", Label.CONTENT_RAW);
        	couponLabel.setStyleName("couponFont");    	   
        	qrLayout.addComponent(couponLabel);
        	qrLayout.addComponent(new Label());*/
        	
            byte[] bytesOut = generateCode39(s);
            //byte[] bytesOut = generateQR(s);
            
        	Embedded embedded = new Embedded();
            embedded.setSource(getImageCoupon(s, bytesOut));  
            embedded.setSizeFull();
            qrLayout.addComponent(embedded);
        	
        	qrCouponNodeComponentGroup.addComponent(qrLayout);
        			    	 
        	return qrCouponNodeComponentGroup;
        }
        
        private byte[] generateCode39(String code) {
        	Code39Bean beanCode39 = new Code39Bean();
        	int dpi = 200;
        	BitmapCanvasProvider canvasCode39 = new BitmapCanvasProvider(dpi, 1,false, 0);
        	
        	//Generate the Qr
        	beanCode39.generateBarcode(canvasCode39, code);
            
            //Signal end of generation
            try {
            	canvasCode39.finish();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            ByteArrayOutputStream baosCode39 = new ByteArrayOutputStream();
            try {
    			ImageIO.write(canvasCode39.getBufferedImage(), "png", baosCode39);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}        
            return baosCode39.toByteArray();
            
        }
        
        private byte[] generateQR(String code) {
        	QRCodeBean beanQr = new QRCodeBean();
        	int dpi = 200;
        	BitmapCanvasProvider canvasQr = new BitmapCanvasProvider(dpi, 1,false, 0);
        	
        	//Generate the Qr
            beanQr.generateBarcode(canvasQr, code);
            
            //Signal end of generation
            try {
    			canvasQr.finish();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            ByteArrayOutputStream baosQr = new ByteArrayOutputStream();
            try {
    			ImageIO.write(canvasQr.getBufferedImage(), "png", baosQr);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}        
            return baosQr.toByteArray();
            
        }
        
        private StreamResource getImageCoupon(String name, final byte[] byteResource) {
        	if (byteResource == null)
        		return null;
        	
        	// create an instance of our stream source.
        	StreamSource imagesource = new ModuleResource(byteResource);
        	
        	// Create a resource that uses the stream source and give it a name.
        	// The constructor will automatically register the resource in the application.
        	//StreamResource imageresource = new StreamResource(imagesource, name + "_coupon.png", getApplication());
        	StreamResource imageresource = new StreamResource(imagesource, name + "_coupon.png", KonektiMapApplication.getApp());
        	
            return imageresource;
        }
        
        private class ModuleResource implements StreamResource.StreamSource {
        	private byte[] resource = null;
        	private ByteArrayOutputStream imagebuffer = null;
        	
        	public ModuleResource(byte[] resource) {
        		this.resource = resource;
        		
        	}
        	
    		@Override
    		public InputStream getStream() {
    			if (resource != null) {
                	InputStream in = new ByteArrayInputStream(resource);
                	BufferedImage bImageFromConvert = null;
                	
    				try {
    					bImageFromConvert = ImageIO.read(in);					
    					imagebuffer = new ByteArrayOutputStream();
    					
    					ImageIO.write(bImageFromConvert, "png", imagebuffer);
    				} catch (IOException e) {	
    					e.printStackTrace();
    					
    				}
                    
                    return new ByteArrayInputStream(imagebuffer.toByteArray());
                }
                
                return null;
    		}
        	
        }
        
        @Override
        public void detach() {
            super.detach();
        }
    }
}
