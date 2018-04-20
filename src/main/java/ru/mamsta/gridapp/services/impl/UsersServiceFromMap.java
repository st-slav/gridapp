package ru.mamsta.gridapp.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import ru.mamsta.gridapp.model.User;
import ru.mamsta.gridapp.services.UsersService;

@Service("usersServiceFromMap")
//@Scope("prototype")
@Lazy
public class UsersServiceFromMap implements UsersService {

	private static long ID;

	private static long getId() {
		return ++ID;
	}

	private Map<Long, User> usersMap;

	@PostConstruct
	private void init() {
		System.out.println("start data init");
		usersMap = new HashMap<Long, User>();
		long id = getId();
		usersMap.put(id, new User(id, "Ivana", 22));
		id = getId();
		usersMap.put(id, new User(id, "Gera", 22));
	}

	public User getUser(long id) {
		return usersMap.get(id);
	}

	public List<User> getAllUsers() {
		return new ArrayList<User>(usersMap.values());
	}

	public User createUser(String name, Integer age) {
		return createUser(new User(null, name, age));
	}

	public User createUser(User user) {
		user.setId(getId());
		usersMap.put(user.getId(), user);
		return getUser(user.getId());
	}

	public User editUser(User user) {
		return usersMap.replace(user.getId(), user);
	}

	public boolean deleteUser(long id) {
		return deleteUser(usersMap.get(id));
	}

	public boolean deleteUser(User user) {
		return usersMap.remove(user.getId(), user);
	}
}
