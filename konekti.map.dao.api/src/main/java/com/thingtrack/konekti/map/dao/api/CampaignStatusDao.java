package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.CampaignStatus;

public interface CampaignStatusDao extends Dao<CampaignStatus, Integer> {
	public CampaignStatus getByCode(String code) throws Exception;
}
