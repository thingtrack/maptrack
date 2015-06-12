package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.MarkerTypeDao;
import com.thingtrack.konekti.map.domain.MarkerType;

public class MarkerTypeDaoImpl extends JpaDao<MarkerType, Integer> implements MarkerTypeDao {

	@Override
	public MarkerType getByName(String name) throws Exception {
		return (MarkerType)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.name = :name")
				.setParameter("name", name).getSingleResult();
	}

}
