package com.thingtrack.konekti.map.service.impl.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.thingtrack.konekti.map.dao.api.UserDao;
import com.thingtrack.konekti.map.domain.User;
import com.thingtrack.konekti.map.service.api.UserService;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAll() throws Exception {
		return userDao.getAll();
		
	}

	@Override
	public User get(Integer userId) throws Exception {
		return userDao.get(userId);
		
	}

	@Override
	public User getByUsername(String username) throws Exception {
		return userDao.getByUsername(username);
		
	}

	@Override
	public User save(User user) throws Exception {
		return userDao.save(user);
		
	}

	@Override
	public void delete(User user) throws Exception {
		userDao.delete(user);
		
	}

}
