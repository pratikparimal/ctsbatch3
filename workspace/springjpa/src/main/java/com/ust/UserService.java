package com.ust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public void addUser(User user){
		repository.addUser(user);
	}

	public User findUser(int id) {
		return repository.findUser(id);
	}
}
