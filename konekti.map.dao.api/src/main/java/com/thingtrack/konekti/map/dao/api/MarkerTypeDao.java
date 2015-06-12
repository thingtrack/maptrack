package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.MarkerType;

public interface MarkerTypeDao extends Dao<MarkerType, Integer> {
	public MarkerType getByName(String name) throws Exception;
}
