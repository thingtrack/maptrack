package com.thingtrack.konekti.map.dao.api;

import java.util.List;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.domain.User;

public interface MapDao extends Dao<Map, Integer> {
	public Map getByCode(String code) throws Exception;
	public List<Map> getByUser(User user) throws Exception;
}
