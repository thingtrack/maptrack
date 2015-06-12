package com.thingtrack.konekti.map.service.api;

import java.util.Date;
import java.util.List;

import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.CardType;

public interface CardService {
	public List<Card> getAll() throws Exception;
	public Card get( Integer cardId ) throws Exception;
	public Card getByCode(String code) throws Exception;
	public Card getByName(String name) throws Exception;
	public List<Card> getAllByName(String name) throws Exception;
	public List<Card> getAllBySponsor() throws Exception;
	public List<Card> getAllByType(CardType cardType) throws Exception;
	public Card getBySchedule(Date date) throws Exception;
	public Card save(Card card) throws Exception;
	public void delete(Card card) throws Exception;
}
