package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.CouponType;

public interface CouponTypeService {
	public List<CouponType> getAll() throws Exception;
	public CouponType get( Integer couponTypeId ) throws Exception;
	public CouponType getByCode( String code ) throws Exception;
	public CouponType save(CouponType couponType) throws Exception;
	public void delete(CouponType couponType) throws Exception;
}
