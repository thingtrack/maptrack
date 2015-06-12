package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.Campaign;

public interface CampaignService {
	public List<Campaign> getAll() throws Exception;
	public Campaign get( Integer CampaignId ) throws Exception;
	public Campaign getByName( String name ) throws Exception;
	public Campaign save(Campaign campaign) throws Exception;
	public void delete(Campaign campaign) throws Exception;
}
