package com.cg.flatrental.app.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.flatrental.app.entity.User;
import com.cg.flatrental.app.repository.IUserRepository;
import com.cg.flatrental.app.service.implementation.IUserServiceImplementation;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	private IUserServiceImplementation userService;

	@Mock
	private IUserRepository userRepository;
	
	@Test
	void testViewAlluser()
	{
		List<User> users = getUsersMockData();		
		Mockito.when(userRepository.findAll()).thenReturn(users);
		
		List<User> userInfo = userService.viewAllUser();
		
		assertThat(userInfo.size() == users.size());
		assertThat(userInfo.get(0).getUserName().equals("Rahul"));
	}
	
	@Test
	void testViewUser() {
		
		Long userId = 168L;
		
		Optional<User> user = getUserMockData();
		
		Mockito.when(userRepository.findById(userId)).thenReturn(user);
		
		User user1 = userService.viewUser(userId);
		
		assertThat(user1.getUserName().equals("Rahul"));
		assertThat(user1.getPassword().equals("rahul"));
	}
	
	@Test
	void testAddUser() {
		
		Optional<User> userOpt = getUserMockData();
		User user = userOpt.get();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		User user1 = userService.addUser(user);
		
		assertThat(user1.getUserName().equals(user.getUserName()));
		assertThat(user1.getPassword().equals(user.getPassword()));
		
	}
	
	@Test
	void testUpdateUser() {
		
		Long userId = 168L;
		Optional<User> userOpt = getUserMockData();
		User user1 = userOpt.get();
		Mockito.when(userRepository.findById(userId)).thenReturn(userOpt);
		Mockito.when(userRepository.save(user1)).thenReturn(user1);
		
		User updateUser = userService.updateUser(user1, userId);
		
		assertThat(user1.getUserName().equals(updateUser.getUserName()));
		assertThat(user1.getPassword().equals(updateUser.getPassword()));
		
	}
	

	private List<User> getUsersMockData() {
		List<User> users = new ArrayList<>();
		User user1 = new User(174L, "Rahul", "rahul", "user");
		User user2 = new User(168L, "Mahesh", "mahesh", "user");
		User user3 = new User(172L, "Kumar", "kumar", "user");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;
	}
	
	private Optional<User> getUserMockData(){
		User user = new User(174L, "Rahul", "rahul", "user");
		return Optional.of(user);
	}
}
