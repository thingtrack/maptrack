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
@Table(name="CAMPAIGN_TYPE")
public class CampaignType implements Serializable {
	@Id
	@Column(name="CAMPAIGN_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer campaignTypeId;
	
	@Column(name="CODE", nullable=false, length=64)
	private String code;
	
	@Column(name="DESCRIPTION", length=256)
	private String description;

	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	/**
	 * @return the campaignTypeId
	 */
	public Integer getCampaignTypeId() {
		return campaignTypeId;
	}

	/**
	 * @param campaignTypeId the campaignTypeId to set
	 */
	public void setCampaignTypeId(Integer campaignTypeId) {
		this.campaignTypeId = campaignTypeId;
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
		return "CampaignType [campaignTypeId=" + campaignTypeId + "]";
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
