package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.CampaignTypeDao;
import com.thingtrack.konekti.map.domain.CampaignType;

public class CampaignTypeDaoImpl extends JpaDao<CampaignType, Integer> implements CampaignTypeDao {

	@Override
	public CampaignType getByCode(String code) throws Exception {
		return (CampaignType)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.code = :code")
				.setParameter("code", code).getSingleResult();
	}

}
