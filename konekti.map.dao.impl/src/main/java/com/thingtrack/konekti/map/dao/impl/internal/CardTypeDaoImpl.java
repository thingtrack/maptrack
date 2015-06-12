package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.CardTypeDao;
import com.thingtrack.konekti.map.domain.CardType;

public class CardTypeDaoImpl extends JpaDao<CardType, Integer> implements CardTypeDao {

	@Override
	public CardType getByCode(String code) throws Exception {
		return (CardType)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.code = :code")
				.setParameter("code", code).getSingleResult();
	}

}
