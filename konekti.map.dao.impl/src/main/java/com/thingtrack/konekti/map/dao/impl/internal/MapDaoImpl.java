package com.thingtrack.konekti.map.dao.impl.internal;

import java.util.List;

import javax.persistence.Query;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.MapDao;
import com.thingtrack.konekti.map.domain.Map;
import com.thingtrack.konekti.map.domain.User;

public class MapDaoImpl extends JpaDao<Map, Integer> implements MapDao {
	@Override
	public Map getByCode(String code) throws Exception {
		return (Map)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.code = :code")
				.setParameter("code", code).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getByUser(User user) throws Exception {
		String queryString = "SELECT p";
		queryString += " FROM FROM " + getEntityName() + "p";
		queryString += " JOIN p.user";
		queryString += " WHERE p.user = :user";
		

		Query query = (Query) getEntityManager().createQuery(queryString)
				.setParameter("user", user);

		return query.getResultList();
		
	}
	
}
