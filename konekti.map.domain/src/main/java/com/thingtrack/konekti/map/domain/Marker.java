package com.thingtrack.konekti.map.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="MARKER")
public class Marker implements Serializable {
	@Id
	@Column(name="MARKER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer markerId;
	
	@ManyToOne
	@JoinColumn(name="MARKER_TYPE_ID", nullable=false)
	private MarkerType markerType;
	
	@Column(name="LONGITUDE", nullable=false)
	private double longitude;
	
	@Column(name="LATITUDE", nullable=false)
	private double latitude;
	
	@Column(name="POPUP", nullable=false)
	private boolean popup = true;
	
	@Column(name="CAPTION", length=64)
	private String caption;
	
	@Column(name="IMAGE", length=64)
	private String image;
		
	@Column(name="WEB", length=64)
	private String web;
	
	@Column(name="PHONE", length=64)
	private String phone;
	
	@Column(name="DESCRIPTION", length=256)
	private String description;
	
	@Column(name="GEOLOCATED")
	private boolean geoLocated = true;
	
	@ManyToOne
	@JoinColumn(name="CARD_ID", nullable=false)
	private Card card;

	public static class TYPE {
		public final static Integer ME = 1;
		public final static Integer TARGET = 2;
		public final static Integer TOILET = 3;
		public final static Integer RESTAURANT = 4;
		public final static Integer POLICE = 5;
		public final static Integer DOCTOR = 6;
		public final static Integer GAS_STATION = 7;
		public final static Integer BUS_STATION = 8;
		public final static Integer FACTORY = 9;
		public final static Integer INFO_POINT = 10;
		public final static Integer ENTRANCE = 11;
	}
	
	/**
	 * @return the MarkerId
	 */
	public Integer getMarkerId() {
		return markerId;
	}

	/**
	 * @param pinId the MarkerId to set
	 */
	public void setMarkerId(Integer markerId) {
		this.markerId = markerId;
	}

	/**
	 * @return the markerType
	 */
	public MarkerType getMarkerType() {
		return markerType;
	}

	/**
	 * @param markerType the markerType to set
	 */
	public void setMarkerType(MarkerType markerType) {
		this.markerType = markerType;
	}
	
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the popup
	 */
	public boolean isPopup() {
		return popup;
	}

	/**
	 * @param popup the popup to set
	 */
	public void setPopup(boolean popup) {
		this.popup = popup;
	}

	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the card
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
	}


	/**
	 * @return the geoLocated
	 */
	public boolean isGeoLocated() {
		return geoLocated;
	}

	/**
	 * @param geoLocated the geoLocated to set
	 */
	public void setGeoLocated(boolean geoLocated) {
		this.geoLocated = geoLocated;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.caption;
		
	}
	
}
