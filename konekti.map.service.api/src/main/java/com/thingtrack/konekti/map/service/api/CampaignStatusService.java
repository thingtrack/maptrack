package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.CampaignStatus;

public interface CampaignStatusService {
	public List<CampaignStatus> getAll() throws Exception;
	public CampaignStatus get( Integer CampaignStatusId ) throws Exception;
	public CampaignStatus getByCode( String code ) throws Exception;
	public CampaignStatus save(CampaignStatus campaignStatus) throws Exception;
	public void delete(CampaignStatus campaignStatus) throws Exception;
}
