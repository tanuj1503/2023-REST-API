package com.rest.API.restfulwebservices.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.API.restfulwebservices.UserBean.User;
import com.rest.API.restfulwebservices.UserService.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService service;
	
//	public UserService service;
//	public UserController(UserService service){
//		this.service = service;
//	}
//	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findOne(id);
	}
}
