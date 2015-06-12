package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.CampaignStatusDao;
import com.thingtrack.konekti.map.domain.CampaignStatus;

public class CampaignStatusDaoImpl extends JpaDao<CampaignStatus, Integer> implements CampaignStatusDao {

	@Override
	public CampaignStatus getByCode(String code) throws Exception {
		return (CampaignStatus)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.code = :code")
				.setParameter("code", code).getSingleResult();
	}

}
