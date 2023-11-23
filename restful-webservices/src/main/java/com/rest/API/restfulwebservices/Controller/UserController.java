package com.rest.API.restfulwebservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.API.restfulwebservices.Service.UserDaoServive;
import com.rest.API.restfulwebservices.UserBean.User;

@RestController
public class UserController {
	
	@Autowired
	public UserDaoServive service;
	
	@GetMapping("/users")
	public List<User> RetrieveAllUSers(){
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User RetrieveUSer(@PathVariable int id){
		return service.findOne(id);
	}
}