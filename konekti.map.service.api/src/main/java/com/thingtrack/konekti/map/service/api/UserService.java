package com.thingtrack.konekti.map.service.api;

import java.util.List;

import com.thingtrack.konekti.map.domain.User;

public interface UserService {
	public List<User> getAll() throws Exception;
	public User get( Integer userId ) throws Exception;
	public User getByUsername( String username ) throws Exception;
	public User save(User user) throws Exception;
	public void delete(User user) throws Exception;
}
