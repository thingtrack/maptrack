package com.thingtrack.konekti.map.dao.impl.internal;

import com.thingtrack.konekti.dao.template.JpaDao;
import com.thingtrack.konekti.map.dao.api.UserDao;
import com.thingtrack.konekti.map.domain.User;

public class UserDaoImpl extends JpaDao<User, Integer> implements UserDao {
	@Override
	public User getByUsername(String username) throws Exception {
		return (User)getEntityManager()
				.createQuery("SELECT p FROM " + getEntityName() + " p WHERE p.username = :username")
				.setParameter("username", username).getSingleResult();
	}

}
