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

@SuppressWarnings("serial")
@Entity
@Table(name="CAMPAIGN")
public class Campaign implements Serializable {
	@Id
	@Column(name="CAMPAIGN_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer campaignId;
	
	@Column(name="NAME", length=64, nullable=false)
	private String name;
	
	@Column(name="DESCRIPTION", length=256)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="CAMPAIGN_TYPE_ID", nullable=false)
	private CampaignType campaignType;
	
	@ManyToOne
	@JoinColumn(name="COUPON_TYPE_ID", nullable=false)
	private CouponType couponType;
	
	@ManyToOne
	@JoinColumn(name="CARD_ID")
	private Card card;
	
	@Column(name="SCHEDULE_DATE_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduleDateFrom;
	
	@Column(name="SCHEDULE_DATE_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduleDateTo;
	
	@OneToMany(mappedBy="campaign")
	private List<Coupon> coupons = new ArrayList<Coupon>();
	
	@ManyToOne
	@JoinColumn(name="CAMPAIGN_STATUS_ID", nullable=false)
	private CampaignType campaignStatus;

	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	/**
	 * @return the campaignId
	 */
	public Integer getCampaignId() {
		return campaignId;
	}

	/**
	 * @param campaignId the campaignId to set
	 */
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
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
	 * @return the campaignType
	 */
	public CampaignType getCampaignType() {
		return campaignType;
	}

	/**
	 * @param campaignType the campaignType to set
	 */
	public void setCampaignType(CampaignType campaignType) {
		this.campaignType = campaignType;
	}

	/**
	 * @return the couponType
	 */
	public CouponType getCouponType() {
		return couponType;
	}

	/**
	 * @param couponType the couponType to set
	 */
	public void setCouponType(CouponType couponType) {
		this.couponType = couponType;
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
	 * @return the coupons
	 */
	public List<Coupon> getCoupons() {
		return coupons;
	}

	/**
	 * @param coupons the coupons to set
	 */
	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	/**
	 * @return the campaignStatus
	 */
	public CampaignType getCampaignStatus() {
		return campaignStatus;
	}

	/**
	 * @param campaignStatus the campaignStatus to set
	 */
	public void setCampaignStatus(CampaignType campaignStatus) {
		this.campaignStatus = campaignStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Campaign [campaignId=" + campaignId + "]";
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
