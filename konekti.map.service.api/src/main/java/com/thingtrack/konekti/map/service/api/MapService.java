package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.domain.User;

public interface MapService {
	public List<Map> getAll() throws Exception;
	public Map get( Integer mapId ) throws Exception;
	public Map getByCode( String code ) throws Exception;
	public Map save(Map map) throws Exception;
	public void delete(Map map) throws Exception;
	public List<Map> getByUser(User user) throws Exception;
}
