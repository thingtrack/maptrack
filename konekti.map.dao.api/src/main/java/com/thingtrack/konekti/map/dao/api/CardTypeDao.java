package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.Campaign;
import com.thingtrack.konekti.map.domain.CardType;

public interface CardTypeDao extends Dao<CardType, Integer> {
	public CardType getByCode(String code) throws Exception;
}
