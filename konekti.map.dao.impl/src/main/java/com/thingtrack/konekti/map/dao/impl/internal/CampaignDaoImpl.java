package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.CampaignDao;
import com.thingtrack.konekti.map.domain.Campaign;

public class CampaignDaoImpl extends JpaDao<Campaign, Integer> implements CampaignDao {

	@Override
	public Campaign getByName(String name) throws Exception {
		return (Campaign)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.name = :name")
				.setParameter("name", name).getSingleResult();
	}

}
