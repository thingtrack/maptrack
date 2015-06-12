package com.thingtrack.konekti.map.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="COUPON")
public class Coupon implements Serializable {
	@Id
	@Column(name="COUPON_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer couponId;
		
	@Column(name="IMAGE", length=256)
	private String image;
	
	@Column(name="DESCRIPTION", length=256)
	private String description;
	
	@Column(name="CODE", length=56)
	private String code;
	
	@ManyToOne
	@JoinColumn(name="CAMPAIGN_ID", nullable=false)
	private Campaign campaign;
	
	@Column(name="COUPON_DATE_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date couponDateFrom;
	
	@Column(name="COUPON_DATE_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date couponDateTo;
	
	@Column(name="VALIDATED")
	private boolean validated;

	/**
	 * @return the couponId
	 */
	public Integer getCouponId() {
		return couponId;
	}

	/**
	 * @param couponId the couponId to set
	 */
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
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
	 * @return the campaign
	 */
	public Campaign getCampaign() {
		return campaign;
	}

	/**
	 * @param campaign the campaign to set
	 */
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	/**
	 * @return the couponDateFrom
	 */
	public Date getCouponDateFrom() {
		return couponDateFrom;
	}

	/**
	 * @param couponDate the couponDateFrom to set
	 */
	public void setCouponDateFrom(Date couponDateFrom) {
		this.couponDateFrom = couponDateFrom;
	}

	/**
	 * @return the couponDateTo
	 */
	public Date getCouponDateTo() {
		return couponDateTo;
	}

	/**
	 * @param couponDateTo the couponDateTo to set
	 */
	public void setCouponDateTo(Date couponDateTo) {
		this.couponDateTo = couponDateTo;
	}
	
	/**
	 * @return the validated
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * @param validated the validated to set
	 */
	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + "]";
	}
	
}
