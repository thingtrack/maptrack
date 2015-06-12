package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.CouponTypeDao;
import com.thingtrack.konekti.map.domain.CouponType;

public class CouponTypeDaoImpl extends JpaDao<CouponType, Integer> implements CouponTypeDao {

	@Override
	public CouponType getByCode(String code) throws Exception {
		return (CouponType)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.code = :code")
				.setParameter("code", code).getSingleResult();
	}

}
