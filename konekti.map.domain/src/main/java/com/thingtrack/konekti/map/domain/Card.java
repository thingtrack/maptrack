/*
 * Copyright 2011 Thingtrack, S.L.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.thingtrack.konekti.map.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Thingtrack S.L.
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="CARD")
public class Card implements Serializable {
	@Id
	@Column(name="CARD_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cardId;
	
	@ManyToOne
	@JoinColumn(name="CARD_TYPE_ID", nullable=false)
	private CardType cardType;
	
	@ManyToOne
	@JoinColumn(name="MAP_ID", nullable=false)
	private Map map;
	
	@Column(name="CODE", length=64, unique=true, nullable=false)
	private String code;
		
	@Column(name="NAME", length=64, nullable=false)
	private String name;
	
	@Column(name="IMAGE", length=64)
	private String image;
	
	@Column(name="WEB", length=64)
	private String web;
	
	@Column(name="EMAIL", length=64)
	private String email;
	
	@Column(name="FIRST_PHONE", length=64)
	private String firstPhone;
	
	@Column(name="SECOND_PHONE", length=64)
	private String secondPhone;
	
	@Column(name="OBSERVATION", length=256)
	private String observation;
	
	@Column(name="SLOGAN", length=32)
	private String slogan;

	@Column(name="SPONSOR")
	private boolean sponsor;
	
	@Column(name="COUPONING")
	private boolean couponing;
	
	@Column(name="SCHEDULE_DATE_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduleDateFrom;
	
	@Column(name="SCHEDULE_DATE_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduleDateTo;

	@OneToMany(mappedBy="card")
	private List<Marker> markers = new ArrayList<Marker>();
	
	@OneToMany(mappedBy="card")
	private List<Campaign> campaigns = new ArrayList<Campaign>();

	/**
	 * @return the cardId
	 */
	public Integer getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstPhone
	 */
	public String getFirstPhone() {
		return firstPhone;
	}

	/**
	 * @param firstPhone the firstPhone to set
	 */
	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}

	/**
	 * @return the secondPhone
	 */
	public String getSecondPhone() {
		return secondPhone;
	}

	/**
	 * @param secondPhone the secondPhone to set
	 */
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}

	/**
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	/**
	 * @return the slogan
	 */
	public String getSlogan() {
		return slogan;
	}

	/**
	 * @param slogan the slogan to set
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	/**
	 * @return the sponsor
	 */
	public boolean isSponsor() {
		return sponsor;
	}

	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(boolean sponsor) {
		this.sponsor = sponsor;
	}

	/**
	 * @return the couponing
	 */
	public boolean isCouponing() {
		return couponing;
	}

	/**
	 * @param couponing the couponing to set
	 */
	public void setCouponing(boolean couponing) {
		this.couponing = couponing;
	}

	/**
	 * @return the scheduleDateFrom
	 */
	public Date getScheduleDateFrom() {
		return scheduleDateFrom;
	}

	/**
	 * @param scheduleDateFrom the scheduleDateFrom to set
	 */
	public void setScheduleDateFrom(Date scheduleDateFrom) {
		this.scheduleDateFrom = scheduleDateFrom;
	}

	/**
	 * @return the scheduleDateTo
	 */
	public Date getScheduleDateTo() {
		return scheduleDateTo;
	}

	/**
	 * @param scheduleDateTo the scheduleDateTo to set
	 */
	public void setScheduleDateTo(Date scheduleDateTo) {
		this.scheduleDateTo = scheduleDateTo;
	}

	/**
	 * @return the markers
	 */
	public List<Marker> getMarkers() {
		return markers;
	}

	/**
	 * @param pins the markers to set
	 */
	public void setMarkers(List<Marker> markers) {
		this.markers = markers;
	}

	/**
	 * @return the campaigns
	 */
	public List<Campaign> getCampaigns() {
		return campaigns;
	}

	/**
	 * @param campaigns the campaigns to set
	 */
	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
		
	}
	
}
