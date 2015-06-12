package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.Campaign;

public interface CampaignDao extends Dao<Campaign, Integer> {
	public Campaign getByName(String name) throws Exception;
}
