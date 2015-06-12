package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.CouponDao;
import com.thingtrack.konekti.map.domain.Coupon;

public class CouponDaoImpl extends JpaDao<Coupon, Integer> implements CouponDao {

	@Override
	public Coupon getByCode(String code) throws Exception {
		return (Coupon)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.code = :code")
				.setParameter("code", code).getSingleResult();
	}

}
