package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.Coupon;

public interface CouponService {
	public List<Coupon> getAll() throws Exception;
	public Coupon get( Integer couponId ) throws Exception;
	public Coupon getByCode( String code ) throws Exception;
	public Coupon save(Coupon coupon) throws Exception;
	public void delete(Coupon coupon) throws Exception;
}
