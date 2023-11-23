package com.rest.API.restfulwebservices.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}