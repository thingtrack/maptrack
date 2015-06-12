package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.Marker;

public interface MarkerService {
	public List<Marker> getAll() throws Exception;
	public Marker get( Integer pinId ) throws Exception;
	public Marker save(Marker marker) throws Exception;
	public void delete(Marker marker) throws Exception;
}
