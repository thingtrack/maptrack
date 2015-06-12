package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.MarkerDao;
import com.thingtrack.konekti.map.domain.Marker;
import com.thingtrack.konekti.map.service.api.MarkerService;

public class MarkerServiceImpl implements MarkerService {
	@Autowired
	private MarkerDao markerDao;
	
	@Override
	public List<Marker> getAll() throws Exception {
		return markerDao.getAll();
		
	}

	@Override
	public Marker get(Integer markerId) throws Exception {
		return markerDao.get(markerId);
				
	}

	@Override
	public Marker save(Marker marker) throws Exception {
		return markerDao.save(marker);
		
	}

	@Override
	public void delete(Marker marker) throws Exception {
		markerDao.delete(marker);
		
	}

}
