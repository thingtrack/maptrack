package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.CampaignTypeDao;
import com.thingtrack.konekti.map.domain.CampaignType;
import com.thingtrack.konekti.map.service.api.CampaignTypeService;

public class CampaignTypeServiceImpl implements CampaignTypeService {
	@Autowired
	private CampaignTypeDao campaignTypeDao;
	
	@Override
	public List<CampaignType> getAll() throws Exception {
		return campaignTypeDao.getAll();
				
	}

	@Override
	public CampaignType get(Integer campaignId) throws Exception {
		return campaignTypeDao.get(campaignId);
		
	}

	@Override
	public CampaignType getByCode(String code) throws Exception {
		return campaignTypeDao.getByCode(code);
	}

	@Override
	public CampaignType save(CampaignType campaignType) throws Exception {
		return campaignTypeDao.save(campaignType);
	}

	@Override
	public void delete(CampaignType campaignType) throws Exception {
		campaignTypeDao.delete(campaignType);
		
	}

}
