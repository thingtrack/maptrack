package com.thingtrack.konekti.map.domain;

import java.io.Serializable;
import java.util.ArrayList;
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

@SuppressWarnings("serial")
@Entity
@Table(name="MAP")
public class Map implements Serializable {
	@Id
	@Column(name="MAP_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer mapId;
	
	@Column(name="CODE", nullable=false, unique=true)
	private String code;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TITTLE")
	private String tittle;
	
	@Column(name="ICON_IMAGE")
    private String iconImage;
	
	@Column(name="SPLASH_IMAGE")
    private String splashImage;
	
	@OneToMany(mappedBy="map")	
	private List<Card> cards = new ArrayList<Card>();
	
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;

	@Column(name="MODE")
	private String mode;
	
	/**
	 * @return the mapId
	 */
	public Integer getMapId() {
		return mapId;
	}

	/**
	 * @param mapId the mapId to set
	 */
	public void setMapId(Integer mapId) {
		this.mapId = mapId;
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

	/**
	 * @return the tittle
	 */
	public String getTittle() {
		return tittle;
	}

	/**
	 * @param tittle the tittle to set
	 */
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	/**
	 * @return the iconImage
	 */
	public String getIconImage() {
		return iconImage;
	}

	/**
	 * @param iconImage the iconImage to set
	 */
	public void setIconImage(String iconImage) {
		this.iconImage = iconImage;
	}

	/**
	 * @return the splashImage
	 */
	public String getSplashImage() {
		return splashImage;
	}

	/**
	 * @param splashImage the splashImage to set
	 */
	public void setSplashImage(String splashImage) {
		this.splashImage = splashImage;
	}
	
	/**
	 * @return the cards
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<Card> cards) {
		this.cards = cards;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.description;
		
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
}
