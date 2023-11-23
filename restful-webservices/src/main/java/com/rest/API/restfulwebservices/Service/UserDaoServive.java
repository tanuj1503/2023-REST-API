package com.rest.API.restfulwebservices.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.rest.API.restfulwebservices.UserBean.User;

@Component
public class UserDaoServive {
	
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount, "Deepak", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Tanuj", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Anuj", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
}
