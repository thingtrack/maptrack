package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.MapDao;
import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.domain.User;
import com.thingtrack.konekti.map.service.api.MapService;

public class MapServiceImpl implements MapService {
	@Autowired
	private MapDao mapDao;
	
	@Override
	public List<Map> getAll() throws Exception {
		return mapDao.getAll();
		
	}

	@Override
	public Map get(Integer mapId) throws Exception {
		return mapDao.get(mapId);
		
	}

	@Override
	public Map getByCode(String code) throws Exception {
		return mapDao.getByCode(code);
		
	}
	
	@Override
	public Map save(Map map) throws Exception {
		return mapDao.save(map);
	}

	@Override
	public void delete(Map map) throws Exception {
		mapDao.delete(map);
		
	}

	@Override
	public List<Map> getByUser(User user) throws Exception {
		return mapDao.getByUser(user);
		
	}

}
