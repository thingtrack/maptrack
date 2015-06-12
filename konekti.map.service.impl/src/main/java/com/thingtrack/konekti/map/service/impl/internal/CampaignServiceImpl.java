package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.CampaignDao;
import com.thingtrack.konekti.map.domain.Campaign;
import com.thingtrack.konekti.map.service.api.CampaignService;

public class CampaignServiceImpl implements CampaignService {
	@Autowired
	private CampaignDao campaignDao;
	
	@Override
	public List<Campaign> getAll() throws Exception {
		return campaignDao.getAll();
	}

	@Override
	public Campaign get(Integer CampaignId) throws Exception {
		return campaignDao.get(CampaignId);
	}

	@Override
	public Campaign getByName(String name) throws Exception {
		return campaignDao.getByName(name);
	}

	@Override
	public Campaign save(Campaign campaign) throws Exception {
		return campaignDao.save(campaign);
	}

	@Override
	public void delete(Campaign campaign) throws Exception {
		campaignDao.delete(campaign);
		
	}

}
