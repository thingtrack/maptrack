package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.CouponTypeDao;
import com.thingtrack.konekti.map.domain.CouponType;
import com.thingtrack.konekti.map.service.api.CouponTypeService;

public class CouponTypeServiceImpl implements CouponTypeService {
	@Autowired
	private CouponTypeDao couponTypeDao;
	
	@Override
	public List<CouponType> getAll() throws Exception {
		return couponTypeDao.getAll();
		
	}

	@Override
	public CouponType get(Integer couponTypeId) throws Exception {
		return couponTypeDao.get(couponTypeId);
		
	}

	@Override
	public CouponType getByCode(String code) throws Exception {
		return couponTypeDao.getByCode(code);
		
	}

	@Override
	public CouponType save(CouponType couponType) throws Exception {
		return couponTypeDao.save(couponType);
		
	}

	@Override
	public void delete(CouponType couponType) throws Exception {
		couponTypeDao.delete(couponType);
		
		
	}

}
