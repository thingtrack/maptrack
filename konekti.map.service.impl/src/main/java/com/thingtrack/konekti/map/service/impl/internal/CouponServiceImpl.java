package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.CouponDao;
import com.thingtrack.konekti.map.domain.Coupon;
import com.thingtrack.konekti.map.service.api.CouponService;

public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;
	
	@Override
	public List<Coupon> getAll() throws Exception {
		return couponDao.getAll();
	}

	@Override
	public Coupon get(Integer couponId) throws Exception {
		return couponDao.get(couponId);
		
	}

	@Override
	public Coupon getByCode(String code) throws Exception {
		return couponDao.getByCode(code);
		
	}

	@Override
	public Coupon save(Coupon coupon) throws Exception {
		return couponDao.save(coupon);
		
	}

	@Override
	public void delete(Coupon coupon) throws Exception {
		couponDao.delete(coupon);
		
		
	}

}
