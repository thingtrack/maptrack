package com.thingtrack.konekti.map.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="COUPON_TYPE")
public class CouponType implements Serializable {
	@Id
	@Column(name="COUPON_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer couponTypeId;
	
	@Column(name="CODE", length=64, nullable=false)
	private String code;
	
	@Column(name="DESCRIPTION", length=256)
	private String description;

	/**
	 * @return the couponTypeId
	 */
	public Integer getCouponTypeId() {
		return couponTypeId;
	}

	/**
	 * @param couponTypeId the couponTypeId to set
	 */
	public void setCouponTypeId(Integer couponTypeId) {
		this.couponTypeId = couponTypeId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CouponType [couponTypeId=" + couponTypeId + "]";
	}
	
}
