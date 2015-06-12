package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.CouponType;

public interface CouponTypeDao extends Dao<CouponType, Integer> {
	public CouponType getByCode(String code) throws Exception;
}
