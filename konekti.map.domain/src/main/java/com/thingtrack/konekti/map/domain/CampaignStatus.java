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
@Table(name="CAMPAIGN_STATUS")
public class CampaignStatus implements Serializable {
	@Id
	@Column(name="CAMPAIGN_STATUS_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer campaignStatusId;
	
	@Column(name="CODE", nullable=false, length=64)
	private String code;
	
	@Column(name="DESCRIPTION", length=256)
	private String description;

	/**
	 * @return the campaignStatusId
	 */
	public Integer getCampaignStatusId() {
		return campaignStatusId;
	}

	/**
	 * @param campaignStatusId the campaignStatusId to set
	 */
	public void setCampaignStatusId(Integer campaignStatusId) {
		this.campaignStatusId = campaignStatusId;
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
		return "CampaignStatus [campaignStatusId=" + campaignStatusId + "]";
	}
}
