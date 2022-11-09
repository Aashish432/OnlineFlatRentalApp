package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.User;

public interface IUserService {
	
	
	User viewUser(Long id);
	List<User> viewAllUser();
	User validateUser(Long userId, String password);
	User addUser(User user);
	User updateUser(User user, Long userId);
	User updatePassword(Long userId, String newpass);
	void removeUser(Long id);
	
	
}