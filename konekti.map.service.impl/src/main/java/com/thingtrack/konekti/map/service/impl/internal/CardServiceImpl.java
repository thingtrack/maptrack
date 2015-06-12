package com.thingtrack.konekti.map.service.impl.internal;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.CardDao;
import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.CardType;
import com.thingtrack.konekti.map.service.api.CardService;

public class CardServiceImpl implements CardService {
	@Autowired
	private CardDao cardDao;
	
	@Override
	public List<Card> getAll() throws Exception {
		return cardDao.getAll();
		
	}

	@Override
	public Card get(Integer cardId) throws Exception {
		return cardDao.get(cardId);
		
	}

	@Override
	public Card getByCode(String code) throws Exception {
		return cardDao.getByCode(code);
		
	}

	@Override
	public Card getByName(String name) throws Exception {
		return cardDao.getByName(name);
		
	}

	@Override
	public List<Card> getAllByName(String name) throws Exception {
		return cardDao.getAllByName(name);
		
	}

	@Override
	public List<Card> getAllBySponsor() throws Exception {
		return cardDao.getAllBySponsor();
		
	}

	@Override
	public List<Card> getAllByType(CardType cardType) throws Exception {
		return cardDao.getAllByType(cardType);
		
	}

	@Override
	public Card getBySchedule(Date date) throws Exception {
		return cardDao.getBySchedule(date);
		
	}

	@Override
	public Card save(Card card) throws Exception {
		return cardDao.save(card);
	}

	@Override
	public void delete(Card card) throws Exception {
		cardDao.delete(card);
		
	}

}
