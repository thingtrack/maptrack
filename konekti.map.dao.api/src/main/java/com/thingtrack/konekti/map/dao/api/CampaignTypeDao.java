package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.CampaignType;

public interface CampaignTypeDao extends Dao<CampaignType, Integer> {
	public CampaignType getByCode(String code) throws Exception;
	
}
