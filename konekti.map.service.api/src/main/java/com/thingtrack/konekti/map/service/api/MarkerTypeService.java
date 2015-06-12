package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.MarkerType;

public interface MarkerTypeService {
	public List<MarkerType> getAll() throws Exception;
	public MarkerType get( Integer markerTypeId ) throws Exception;
	public MarkerType getByName( String name ) throws Exception;
	public MarkerType save(MarkerType markerType) throws Exception;
	public void delete(MarkerType markerType) throws Exception;
}
