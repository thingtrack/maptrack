package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.CampaignStatusDao;
import com.thingtrack.konekti.map.domain.CampaignStatus;
import com.thingtrack.konekti.map.service.api.CampaignStatusService;

public class CampaignStatusServiceImpl implements CampaignStatusService {
	@Autowired
	private CampaignStatusDao campaignStatusDao;
	
	@Override
	public List<CampaignStatus> getAll() throws Exception {
		return campaignStatusDao.getAll();
		
	}

	@Override
	public CampaignStatus get(Integer CampaignStatusId) throws Exception {
		return campaignStatusDao.get(CampaignStatusId);
		
	}

	@Override
	public CampaignStatus getByCode(String code) throws Exception {
		return campaignStatusDao.getByCode(code);
		
	}

	@Override
	public CampaignStatus save(CampaignStatus campaignStatus) throws Exception {
		return campaignStatusDao.save(campaignStatus);
	}

	@Override
	public void delete(CampaignStatus campaignStatus) throws Exception {
		campaignStatusDao.delete(campaignStatus);
		
	}

}
