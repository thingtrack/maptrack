package com.thingtrack.konekti.map.dao.impl.internal;

import java.util.Date;
import java.util.List;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.CardDao;
import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.CardType;

public class CardDaoImpl extends JpaDao<Card, Integer> implements CardDao {

	@Override
	public Card getByCode(String code) throws Exception {
		return (Card)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.code = :code")
				.setParameter("code", code).getSingleResult();
		
	}

	@Override
	public Card getByName(String name) throws Exception {
		return (Card)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.name = :name")
				.setParameter("name", name).getSingleResult();

	}

	@Override
	public List<Card> getAllByName(String name) throws Exception {
		return getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.name LIKE :name")
				.setParameter("name", name).getResultList();

	}

	@Override
	public List<Card> getAllBySponsor() throws Exception {
		return getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.sponsor=1").getResultList();
	}

	@Override
	public List<Card> getAllByType(CardType cardType) throws Exception {
		return getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.cardType = :cardType")
				.setParameter("cardType", cardType).getResultList();
	}

	@Override
	public Card getBySchedule(Date date) throws Exception {
		return (Card) getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.scheduleDateFrom >= :date AND p.scheduleDateTo <= :date")
				.setParameter("date", date).getSingleResult();
	}
}
