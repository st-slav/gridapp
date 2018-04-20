package ru.mamsta.gridapp.services;

import java.util.List;

import ru.mamsta.gridapp.model.User;

public interface UsersService {

	User getUser(long id);
	
	List<User> getAllUsers();
	
	User createUser(String name, Integer age);
	
	User createUser(User user);
	
	User editUser(User user);
	
	boolean deleteUser(long id);
	
	boolean deleteUser(User user);
}
