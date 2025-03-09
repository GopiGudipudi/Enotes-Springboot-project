package com.exa.service;

import com.exa.entity.User;

public interface UserService{
	public User saveUser(User user);
	public boolean existEmailCheck(String email);
	

}
