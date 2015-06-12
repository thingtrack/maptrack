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

/**
 * @author Thingtrack S.L.
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="CARD_TYPE")
public class CardType implements Serializable {
	@Id
	@Column(name="CARD_TYPE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cardTypeId;
	
	@Column(name="CODE", nullable=false, length=64)
	private String code;
	
	@Column(name="DESCRIPTION", length=256)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;

	/**
	 * @return the cardTypeId
	 */
	public Integer getCardTypeId() {
		return cardTypeId;
	}

	/**
	 * @param cardTypeId the cardTypeId to set
	 */
	public void setCardTypeId(Integer cardTypeId) {
		this.cardTypeId = cardTypeId;
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
		return "CardType [cardTypeId=" + cardTypeId + "]";
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
