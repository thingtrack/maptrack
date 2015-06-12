package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.CardType;

public interface CardTypeService {
	public List<CardType> getAll() throws Exception;
	public CardType get( Integer cardTypeId ) throws Exception;
	public CardType getByCode( String code ) throws Exception;
	public CardType save(CardType cardType) throws Exception;
	public void delete(CardType cardType) throws Exception;
}
