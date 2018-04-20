package ru.mamsta.gridapp.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.mamsta.gridapp.model.User;
import ru.mamsta.gridapp.services.UsersService;

@RestController()
@RequestMapping("/api/users/")
public class UsersController {
	
	@Resource(name = "usersServiceFromMap")
	private UsersService usersService;
	
	@Resource(name = "usersServiceFromMap")
	private UsersService usersService2;

	@GetMapping()
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(usersService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<User> postUser(@RequestBody User user) {
		return new ResponseEntity<User>(usersService.createUser(user), HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<User> putUser(@RequestParam("id") long id, @RequestBody User user) {
		return new ResponseEntity<User>(usersService.editUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<Boolean> deleteUser(@RequestParam("id") long id) {
		return new ResponseEntity<Boolean>(usersService.deleteUser(id), HttpStatus.OK);
	}
	
	@GetMapping("helloworld")
	public ResponseEntity<String> helloworld() {
		System.out.println(usersService.getAllUsers());
		System.out.println(usersService2.getAllUsers());
		return new ResponseEntity<String>(new String("Hello world!!"), HttpStatus.OK);
	}
}
