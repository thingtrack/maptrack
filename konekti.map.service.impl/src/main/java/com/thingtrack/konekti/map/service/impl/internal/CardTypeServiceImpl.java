package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.CardTypeDao;
import com.thingtrack.konekti.map.domain.CardType;
import com.thingtrack.konekti.map.service.api.CardTypeService;

public class CardTypeServiceImpl implements CardTypeService {
	@Autowired
	private CardTypeDao cardTypeDao;
	
	@Override
	public List<CardType> getAll() throws Exception {
		return cardTypeDao.getAll();
		
	}

	@Override
	public CardType get(Integer cardTypeId) throws Exception {
		return cardTypeDao.get(cardTypeId);
		
	}

	@Override
	public CardType getByCode(String code) throws Exception {
		return cardTypeDao.getByCode(code);
		
	}

	@Override
	public CardType save(CardType cardType) throws Exception {
		return cardTypeDao.save(cardType);
		
	}

	@Override
	public void delete(CardType cardType) throws Exception {
		cardTypeDao.delete(cardType);
		
	}

}
