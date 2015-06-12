package com.thingtrack.konekti.map.dao.api;

import java.util.Date;
import java.util.List;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.CardType;

/**
 * @author Thingtrack S.L.
 *
 */
public interface CardDao extends Dao<Card, Integer> {
	public Card getByCode(String code) throws Exception;
	public Card getByName(String name) throws Exception;
	public List<Card> getAllByName(String name) throws Exception;
	public List<Card> getAllBySponsor() throws Exception;
	public List<Card> getAllByType(CardType cardType) throws Exception;
	public Card getBySchedule(Date date) throws Exception;
}
