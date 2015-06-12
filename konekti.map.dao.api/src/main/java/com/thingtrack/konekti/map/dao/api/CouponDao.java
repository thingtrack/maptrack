package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.Coupon;

public interface CouponDao extends Dao<Coupon, Integer> {
	public Coupon getByCode(String code) throws Exception;
}
