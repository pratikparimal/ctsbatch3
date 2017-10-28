package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void addUser(User user){
		System.out.println("peform any business logic..");
		userRepository.addUser(user);
	}

	public User findUser(int id) {
		if(id<0){
			throw new RuntimeException("Id is not correct");
		}
		return userRepository.findUser(id);
	}

}
