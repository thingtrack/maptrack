package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.CampaignType;

public interface CampaignTypeService {
	public List<CampaignType> getAll() throws Exception;
	public CampaignType get( Integer CampaignTypeId ) throws Exception;
	public CampaignType getByCode( String code ) throws Exception;
	public CampaignType save(CampaignType campaignType) throws Exception;
	public void delete(CampaignType campaignType) throws Exception;
}
