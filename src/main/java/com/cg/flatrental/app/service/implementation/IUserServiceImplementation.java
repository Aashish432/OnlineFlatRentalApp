package com.cg.flatrental.app.service.implementation;

import lombok.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatrental.app.entity.User;
import com.cg.flatrental.app.exception.UserNotFoundException;
import com.cg.flatrental.app.exception.UserValidationException;
import com.cg.flatrental.app.repository.IUserRepository;
import com.cg.flatrental.app.service.IUserService;

@Service
public class IUserServiceImplementation implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User viewUser(Long id) throws UserNotFoundException {
		
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User("+id+") Not Found");
		}
		return user.get();
	}

	@Override
	public List<User> viewAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User validateUser(Long userId, String password) throws UserValidationException {
		
		Optional<User> userOpt = userRepository.findById(userId);
		User user = userOpt.get();
		if(user.getPassword().equals(password))
		{
			return user;
		}
		else
		{
			throw new UserValidationException("Incorrect Details");
		}
		
	}

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, Long userId) throws UserNotFoundException{
		

		Optional<User> userOpt = userRepository.findById(userId);
		User user1 = null;
		if(!userOpt.isPresent()) {
			throw new UserNotFoundException("User("+userId+") Not Found");
		}else {
			user1 = userOpt.get();
			user1.setUserName(user.getUserName());
			user1.setUserType(user.getUserType());
			user1.setPassword(user.getPassword());

			userRepository.save(user);
		}
			
		return user1;

	}

	@Override
	public User updatePassword(Long userId, String newpass) {

		Optional<User> userOpt = userRepository.findById(userId);
		User user = null;
		if(!userOpt.isPresent()) {
			throw new UserNotFoundException("User("+userId+") Not Found");
		}else {
			user = userOpt.get();
			user.setPassword(newpass);
			
			userRepository.save(user);
		}
			
		return user;
	}

	@Override
	public void removeUser(Long userId) {

		userRepository.deleteById(userId);
		
	}
}
