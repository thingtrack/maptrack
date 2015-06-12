package com.thingtrack.konekti.map.dao.api;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.map.domain.Card;
import com.thingtrack.konekti.map.domain.User;

public interface UserDao extends Dao<User, Integer> {
	public User getByUsername(String username) throws Exception;
	
}
