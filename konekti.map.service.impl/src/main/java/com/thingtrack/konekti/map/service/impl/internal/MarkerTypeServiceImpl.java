package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.MarkerTypeDao;
import com.thingtrack.konekti.map.domain.MarkerType;
import com.thingtrack.konekti.map.service.api.MarkerTypeService;

public class MarkerTypeServiceImpl implements MarkerTypeService {
	@Autowired
	private MarkerTypeDao markerTypeDao;
	
	@Override
	public List<MarkerType> getAll() throws Exception {
		return markerTypeDao.getAll();
		
	}

	@Override
	public MarkerType get(Integer markerType) throws Exception {
		return markerTypeDao.get(markerType);
		
	}

	@Override
	public MarkerType getByName(String name) throws Exception {
		return markerTypeDao.getByName(name);
		
	}

	@Override
	public MarkerType save(MarkerType markerType) throws Exception {
		return markerTypeDao.save(markerType);
		
	}

	@Override
	public void delete(MarkerType markerType) throws Exception {
		markerTypeDao.delete(markerType);
		
	}

}
